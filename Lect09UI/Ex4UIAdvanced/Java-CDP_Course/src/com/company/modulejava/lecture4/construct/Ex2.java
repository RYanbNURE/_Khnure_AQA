package com.company.modulejava.lecture4.construct;

public class Ex2 {
    int i;

    // constructor with no parameter
    private Ex2() {
        i = 10;
        System.out.println("Constructor is called");
    }

    public static void main(String[] args) {

        // calling the constructor without any parameter
        Ex2 obj = new Ex2();
        System.out.println("Value of i: " + obj.i);
    }
}
