package com.company.modulejava.lecture8;

public class Ex9StringMethods {
    public static void main(String[] args) {

        String str = "abcd";
        //result "dcba"
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        System.out.println(sb);
        }
    }

