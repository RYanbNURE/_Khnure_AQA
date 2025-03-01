package com.company.modulejava.lecture8;

public class Ex16StringMethods {
    public static void main(String[] args) {
        String str = "Hey there I am misusing WhatsApp WhatsApp WhatsApp WhatsApp WhatsApp WhatsApp";
        String [] split = str.split(" ", 7);

        for (String obj : split)
            System.out.println(obj);
        }
    }

