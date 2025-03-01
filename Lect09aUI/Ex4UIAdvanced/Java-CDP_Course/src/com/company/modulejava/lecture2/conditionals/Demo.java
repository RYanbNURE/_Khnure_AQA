package com.company.modulejava.lecture2.conditionals;

public class Demo {

    public static void main(String[] args) {
        RandomObject object = null;
//        object.equals("aaaa");
        int value1 = 1;
        int value2 = 2;
        if ((value1 == 1) && (value2 == 2))
            System.out.println("value1 is 1 AND value2 is 2");
        if ((value1 == 1) || (object.equals("aaaa")))
            System.out.println("value1 is 1 OR value2 is 1");
        if ((value1 != 1) && (object.equals("aaaa")))
            System.out.println("value1 is 1 OR value2 is 1");
    }
}