package org.khure.pojo.complex;

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

    public Address getAddress() {
        return address;
    }

    // Getters and Setters omitted for brevity
}
