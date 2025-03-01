package com.company.modulejava.lecture8;

import java.util.Arrays;
import java.util.List;

public class Ex12StringMethods {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("A", "B", "C");
        String split = ", ";

        String str = String.join(split, list);
        System.out.println(str);
        }
    }

