package com.company.modulejava.lecture8;

public class Ex8StringMethods {
    public static void main(String[] args) {

        Integer obj = new Integer(10);
        String str = obj.toString();
        String str2 = obj.toString(80);
        String str3 = obj.toString(9823, 2);
//The above line will represent the String in base 2
        System.out.println("The String representation is " + str);
        System.out.println("The String representation is " + str2);
        System.out.println("The String representation is " + str3);
        }
    }

