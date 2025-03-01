package com.company.modulejava.lecture8;

public class Ex15StringMethods {
    public static void main(String[] args) {

        String str = "StringJavaAndJavaStringMethodsJava";
        String strToFind = "Java";
        int count = 0, Index = 0;

        while ((Index = str.indexOf(strToFind, Index)) != -1 ){

            System.out.println("Java found at index: " + Index);
            count++;
            Index++;

        }

        System.out.println("So the total occurrences are: " + count);
        }
    }

