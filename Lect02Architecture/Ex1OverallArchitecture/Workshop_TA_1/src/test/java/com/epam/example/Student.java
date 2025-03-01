package com.epam.example;

public class Student {

    private int age = 33;
    private String name = getName();
//    private Address address;
    private Address address = new Address();

    private String getName () {
        System.out.println("Early init triggered in getting name");
        return "Joe";
    }

     Student() {
         System.out.println("Student created");
    }

    public static void main(String[] args) {
        new Student();

    }
}
