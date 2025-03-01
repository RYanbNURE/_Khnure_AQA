package com.company.modulejava.lecture3;

import java.util.Arrays;

public class Array18ToStream {
    public static void main(String[] args) {

        // Get the Array
        int intArr[] = { 10, 20, 15, 22, 35 };

        // To get the Stream from the array
        System.out.println("Integer Array: "
                + Arrays.stream(intArr));

        Arrays.stream(intArr).forEach(System.out::println);
    }
}
