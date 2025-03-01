package com.company.modulejava.lecture3;

public class Array3Demo {
    public static void main(String[] args) {
        // create an array
        int[] age = {12, 4, 5};

        // loop through the array
        // using for loop
        System.out.println("Using for Loop:");
        for (int i = 0; i < age.length; i++) {
            System.out.println("My element index " + i);
            System.out.println(age[i]);
        }
    }
}
