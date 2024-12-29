package com.example.rantelcar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class carDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        // Récupérer les données passées depuis BradsCar
        String carName = getIntent().getStringExtra("car_name");
        int carImage = getIntent().getIntExtra("car_image", 0);
        double carPrice = getIntent().getDoubleExtra("car_price", 0.0);

        // Lier les vues
        TextView carNameTextView = findViewById(R.id.car_name);
        ImageView carImageView = findViewById(R.id.car_image);
        TextView carPriceTextView = findViewById(R.id.car_price);

        // Afficher les données dans les vues
        carNameTextView.setText(carName);
        carImageView.setImageResource(carImage);
        carPriceTextView.setText(String.format("$%.2f", carPrice));
    }
}
