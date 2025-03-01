package com.company.modulejava.lecture4.construct;

public class Ex4 {
    int a;
    boolean b;
    String name;

//    Ex4() {
//        a = 0;
//        b = false;
//        name = null;
//    }

    public static void main(String[] args) {

        // A default constructor is called
        Ex4 obj = new Ex4();

        System.out.println("Default Value:");
        System.out.println("a = " + obj.a);
        System.out.println("b = " + obj.b);
    }
}
