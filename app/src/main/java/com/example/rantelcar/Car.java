package com.example.rantelcar;

public class Car {
    private String name;
    private int imageResource; // Drawable resource ID
    private double price;


    public Car(String name, int imageResource, double price) {
        this.name = name;
        this.imageResource = imageResource;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public double getPrice() {
        return price;
    }
}
