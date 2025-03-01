package com.company.modulejava.lecture4.methods;

public class Ex5MethodOverloading {
    private static void display(int a){
        System.out.println("Arguments: " + a);
    }

    private static int display(float a){
        System.out.println("Arguments: " + a);
        return 1;
    }

    private static void display(int a, int b){
        System.out.println("Arguments: " + a + " and " + b);
    }

    public static void main(String[] args) {
        display(1);
        display(1, 4);
    }
}
