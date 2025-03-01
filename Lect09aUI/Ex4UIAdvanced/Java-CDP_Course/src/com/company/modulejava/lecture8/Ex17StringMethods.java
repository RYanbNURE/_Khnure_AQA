package com.company.modulejava.lecture8;

public class Ex17StringMethods {
    public static void main(String[] args) {
        String str = "Hey there I am misusing WhatsApp";
        String [] split = str.split(" ", 7);

        for (String obj : split)
            System.out.println(obj);
        }
    }

