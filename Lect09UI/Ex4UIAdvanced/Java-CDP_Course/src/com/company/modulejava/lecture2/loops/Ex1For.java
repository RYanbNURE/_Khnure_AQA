package com.company.modulejava.lecture2.loops;

import java.util.List;
import java.util.stream.IntStream;

public class Ex1For {

    public static void main(String[] args) {
//        int n = 5;
//        // for loop
//        for(int i = 1; i <= n; i++) {
//            System.out.println(i);
//        }

//        int sum = 0;
//        int count = 5;
//        for (int i = 1; i <= count; ++i) {
//            sum += i;
//        }

//        System.out.println("Sum = " + sum);

        int[] intArray = IntStream.rangeClosed(1, 10).toArray();

        for (int i = 0; i < intArray.length;i++) {
            System.out.println(intArray[i]);
        }

        for (int i:intArray) {
            System.out.println(i);
        }
    }
}
