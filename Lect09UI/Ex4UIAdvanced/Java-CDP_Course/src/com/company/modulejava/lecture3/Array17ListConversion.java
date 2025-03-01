package com.company.modulejava.lecture3;

import java.util.Arrays;

public class Array17ListConversion {
    public static void main(String[] args) {
        // Get the Array
        int intArr[] = { 10, 20, 15, 22, 35 };

        Arrays.sort(intArr);

        System.out.println(Arrays.toString(intArr));

        int intKey = 24;

        // Print the key and corresponding index
        System.out.println(
                intKey + " found at index = "
                        + Arrays.binarySearch(intArr, intKey));
    }
}
