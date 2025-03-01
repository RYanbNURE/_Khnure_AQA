package com.company.modulejava.lecture8;

public class Ex4StringMethods {
    public static void main(String[] args) {
        String str1 = "Zeus";
        String str2 = "Chinese";
        String str3 = "American";
        String str4 = "Indian";

        System.out.println(str1.compareTo(str2));
        //C comes 23 positions before Z, so it will give you 23
        System.out.println(str3.compareTo(str4));
        // I comes 8 positions after A, so it will give you -8
    }
}
