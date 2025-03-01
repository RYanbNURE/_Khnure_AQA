package com.epam.example;

public class Address {
    private City city = new City();

    private String country = getDefaultCountry();

    private String getDefaultCountry() {
        System.out.println("Early init triggered in getting country");
        return "India";
    }



    public Address() {
        System.out.println("Adress created ");
    }


}
