package com.company.modulejava.lecture4.construct;

public class Ex1 {
    private String name;

    // constructor
    Ex1() {
        System.out.println("Constructor Called:");
        name = "Programiz";
    }

    public static void main(String[] args) {

        // constructor is invoked while
        // creating an object of the Main class
        Ex1 obj = new Ex1();
        System.out.println("The name is " + obj.name);
    }
}
