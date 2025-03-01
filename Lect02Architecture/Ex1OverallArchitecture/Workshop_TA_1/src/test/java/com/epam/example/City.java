package com.epam.example;

public class City {
    private String cityName = getDefaultCity();

    private String getDefaultCity() {
        System.out.println("Early init triggered in getting city");
        return "Delhi";
    }

    City () {
        System.out.println("City created");
    }
}
