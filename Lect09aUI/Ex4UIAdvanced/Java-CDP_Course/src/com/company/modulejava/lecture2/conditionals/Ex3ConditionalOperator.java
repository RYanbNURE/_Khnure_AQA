package com.company.modulejava.lecture2.conditionals;

import java.util.Scanner;

public class Ex3ConditionalOperator {

    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int age = sin.nextInt();
        String result = age>=18 ? "eligible" : "not eligible";

        System.out.println("Result is " + result);
    }
}
