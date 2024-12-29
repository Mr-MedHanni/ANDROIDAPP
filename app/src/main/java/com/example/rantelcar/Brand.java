package com.example.rantelcar;

public class Brand {
    private String name;
    private int imageResId;

    public Brand(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
