package com.company.modulejava.lecture15.ex1;


public class Main_5_PackageName {


    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Class.forName("com.company.modulejava.lecture15.ex1.BaseInterface").getPackage().getName());

    }
}

