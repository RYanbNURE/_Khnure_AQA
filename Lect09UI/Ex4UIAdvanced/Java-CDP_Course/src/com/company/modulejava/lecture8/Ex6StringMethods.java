package com.company.modulejava.lecture8;

import java.util.ArrayList;
import java.util.List;

public class Ex6StringMethods {
    public static void main(String[] args) {
        String str = "Thexyzwebsitexyzisxyzsoftwaretestingxyzhelp";
        String[] split = str.split("xyz");

        for (String obj: split) {
            System.out.println(obj);
        }

        String mySentence = "I like Java language";

        String[] spitResults = mySentence.split(" ");

        System.out.println(spitResults.length);

//        List<String> stringList = new ArrayList<String>(spitResults);
    }
}
