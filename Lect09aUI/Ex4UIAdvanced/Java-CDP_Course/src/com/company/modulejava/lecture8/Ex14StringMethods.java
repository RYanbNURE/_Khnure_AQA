package com.company.modulejava.lecture8;

public class Ex14StringMethods {
    public static void main(String[] args) {

        StringBuilder std = new StringBuilder("Test");
        System.out.println(std);
        System.out.println("length of std is  " + std.length());
        std.setLength(10);
        System.out.println("Increased the length to 10, string = " + std);
        System.out.println("length = " + std.length());
        }
    }

