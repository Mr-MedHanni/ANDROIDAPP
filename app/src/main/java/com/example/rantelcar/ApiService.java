package com.example.rantelcar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("auth/login") // Assurez-vous que l'URL correspond au backend
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    Call<List<Car>> getCars();

    Call<List<Brand>> getBrands();
}

// Classes pour la requête et la réponse
class LoginRequest {
    private String email;
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters et setters
}

class LoginResponse {
    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
