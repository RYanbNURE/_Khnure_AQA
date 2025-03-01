package org.khnure.model.complex;

public class User {
    private int id;
    private String name;
    private Address address;

    // Constructors, Getters, and Setters
    public User(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Getters and Setters omitted for brevity


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
