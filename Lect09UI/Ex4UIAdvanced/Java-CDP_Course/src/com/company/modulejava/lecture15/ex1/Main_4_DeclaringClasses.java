package com.company.modulejava.lecture15.ex1;


public class Main_4_DeclaringClasses {


    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> innerClass = Class.forName("com.company.modulejava.lecture15.ex1.ConcreteClass$ConcreteClassDefaultClass");
//prints com.journaldev.reflection.ConcreteClass
        System.out.println(innerClass.getDeclaringClass().getCanonicalName());
        System.out.println(innerClass.getEnclosingClass().getCanonicalName());

    }
}

