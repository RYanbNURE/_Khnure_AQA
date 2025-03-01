package com.company.modulejava.lecture2.conditionals;

import java.util.Scanner;

public class Ex2ElIf2 {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int age = sin.nextInt();


        System.out.println("Before if flow");

        if (age >= 18) {
            System.out.println("Eligible for driving");
        } else {
            System.out.println("Not eligible for driving");
        }

        System.out.println("After if flow");
    }
}
