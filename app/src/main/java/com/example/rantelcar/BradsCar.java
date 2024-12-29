package com.example.rantelcar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BradsCar extends AppCompatActivity {

    private RecyclerView recyclerViewCars;
    private RecyclerView recyclerViewBrands;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brads_car);

        // Setup RecyclerView for cars
        recyclerViewCars = findViewById(R.id.recycler_view_cars);
        recyclerViewCars.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Fetch cars from API
        fetchCars();

        // Setup RecyclerView for brands
        recyclerViewBrands = findViewById(R.id.recycler_view_brands);
        recyclerViewBrands.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Fetch brands from API
        fetchBrands();
    }

    private void fetchCars() {
        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);

        apiService.getCars().enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Car> carList = response.body();
                    CarAdapter carAdapter = new CarAdapter(carList, car -> {
                        // Handle car item click
                        Intent intent = new Intent(BradsCar.this, carDetail.class);
                        intent.putExtra("car_name", car.getName());
                        intent.putExtra("car_image", car.getImageResource());
                        intent.putExtra("car_price", car.getPrice());
                        startActivity(intent);
                    });
                    recyclerViewCars.setAdapter(carAdapter);
                } else {
                    Toast.makeText(BradsCar.this, "Failed to load cars", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {
                Toast.makeText(BradsCar.this, "Failed to load cars", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchBrands() {
        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);

        apiService.getBrands().enqueue(new Callback<List<Brand>>() {
            @Override
            public void onResponse(Call<List<Brand>> call, Response<List<Brand>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Brand> brandList = response.body();
                    BrandAdapter brandAdapter = new BrandAdapter(brandList);
                    recyclerViewBrands.setAdapter(brandAdapter);
                } else {
                    Toast.makeText(BradsCar.this, "Failed to load brands", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Brand>> call, Throwable t) {
                Toast.makeText(BradsCar.this, "Failed to load brands", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
