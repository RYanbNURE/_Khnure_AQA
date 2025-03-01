package com.company.modulejava.lecture8;

public class Ex7StringMethods {
    public static void main(String[] args) {

        String str = "Test utest " + "performing a search";
        System.out.println(str);
        System.out.println("index of 'p' is " + str.indexOf('p'));
        System.out.println("index of 'p' is " + str.indexOf(1));
        System.out.println("index of 'u' is " + str.indexOf('u'));
        System.out.println("last index of 'S' is " + str.lastIndexOf('S'));
        System.out.println("last index of 's' is " + str.lastIndexOf('s'));
        }
    }

