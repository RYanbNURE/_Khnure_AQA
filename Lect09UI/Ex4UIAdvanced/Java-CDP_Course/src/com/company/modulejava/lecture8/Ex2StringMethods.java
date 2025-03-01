package com.company.modulejava.lecture8;

public class Ex2StringMethods {
    public static void main(String[] args) {

        String str = "Test";
        char[] chars = str.toCharArray();
        System.out.println(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }
}
