package com.company.modulejava.lecture15.ex1;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main_2_PublicMemberClasses {

//    We can get Class of an object using three methods – through static variable class, using getClass() method of object and java.lang.Class.forName(String fullyClassifiedClassName).
//    For primitive types and arrays, we can use static variable class.
//    Wrapper classes provide another static variable TYPE to get the class.

    public static void main(String[] args) throws ClassNotFoundException {
    
// Get Super Class
        Class<?> concreteClass = ConcreteClass.class; //static variable class
        Class<?>[] classes = concreteClass.getClasses();
//[class com.company.modulejava.lecture15.ex1.ConcreteClass$ConcreteClassPublicClass,
//class com.company.modulejava.lecture15.ex1.ConcreteClass$ConcreteClassPublicEnum,
//interface com.company.modulejava.lecture15.ex1.ConcreteClass$ConcreteClassPublicInterface,
//class com.company.modulejava.lecture15.ex1..BaseClass$BaseClassInnerClass,
//class com.company.modulejava.lecture15.ex1.BaseClass$BaseClassMemberEnum]

        Stream.of(classes).forEach(System.out::println);
//        System.out.println(Arrays.toString(classes));

    }
}

