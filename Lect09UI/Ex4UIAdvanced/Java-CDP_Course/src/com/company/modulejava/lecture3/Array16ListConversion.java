package com.company.modulejava.lecture3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array16ListConversion {
    public static void main(String[] args) {
        // create an array
        String[] array = {"Java", "Python", "C"};
        System.out.println("Array: " + Arrays.toString(array));

        // convert array to list
        List<String> languages= new ArrayList<>(Arrays.asList(array));

        System.out.println("List: " + languages);
    }
}
