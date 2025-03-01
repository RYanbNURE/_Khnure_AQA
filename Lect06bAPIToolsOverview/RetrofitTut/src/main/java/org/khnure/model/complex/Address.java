package org.khnure.model.complex;

public class Address {
    private String street;
    private String city;

    // Constructors, Getters, and Setters
    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    // Getters and Setters omitted for brevity


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}