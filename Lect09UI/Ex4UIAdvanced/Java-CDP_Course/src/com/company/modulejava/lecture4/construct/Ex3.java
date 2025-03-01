package com.company.modulejava.lecture4.construct;

public class Ex3 {
    String languages;

    // constructor accepting single value
    Ex3(String lang) {
        languages = lang;
        System.out.println(languages + " Programming Language");
    }

    public static void main(String[] args) {

        // call constructor by passing a single value
        Ex3 obj1 = new Ex3("Java");
        Ex3 obj2 = new Ex3("Python");
        Ex3 obj3 = new Ex3("C");
    }
}
