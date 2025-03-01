package com.company.modulejava.lecture3;

import java.util.ArrayList;
import java.util.List;

public class Array15ListConversion {
    public static void main(String[] args) {
        List<String> languages = new ArrayList<>();

        // Add elements in the list
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");
        System.out.println("ArrayList: " + languages);

        // Create a new array of String type
        String[] arr = new String[languages.size()];

        // Convert ArrayList into the string array
        languages.toArray(arr);
        System.out.print("Array: ");
        for(String item:arr) {
            System.out.print(item+", ");
        }
    }
}
