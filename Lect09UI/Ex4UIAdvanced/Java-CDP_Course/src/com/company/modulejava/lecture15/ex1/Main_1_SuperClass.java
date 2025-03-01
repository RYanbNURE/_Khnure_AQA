package com.company.modulejava.lecture15.ex1;

public class Main_1_SuperClass {

//    We can get Class of an object using three methods – through static variable class, using getClass() method of object and java.lang.Class.forName(String fullyClassifiedClassName).
//    For primitive types and arrays, we can use static variable class.
//    Wrapper classes provide another static variable TYPE to get the class.

    public static void main(String[] args) throws ClassNotFoundException {

// Get Super Class
        Class<?> superClass = Class.forName("com.company.modulejava.lecture15.ex1.ConcreteClass").getSuperclass();
        System.out.println(superClass); // prints "class com.company.modulejava.lecture15.ex1.ConcreteClasss"
        System.out.println(Object.class.getSuperclass()); // prints "null"
        System.out.println(String[][].class.getSuperclass());// prints "class java.lang.Object"
    }
}

