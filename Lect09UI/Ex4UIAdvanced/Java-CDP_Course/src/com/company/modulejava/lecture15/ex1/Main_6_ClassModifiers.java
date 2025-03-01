package com.company.modulejava.lecture15.ex1;


import java.lang.reflect.Modifier;

public class Main_6_ClassModifiers {


    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> concreteClass = Class.forName("com.company.modulejava.lecture15.ex1.ConcreteClass");
        System.out.println(Modifier.toString(concreteClass.getModifiers())); //prints "public"
//prints "public abstract interface"
        System.out.println(Modifier.toString(Class.forName("com.company.modulejava.lecture15.ex1.BaseInterface").getModifiers()));

    }
}

