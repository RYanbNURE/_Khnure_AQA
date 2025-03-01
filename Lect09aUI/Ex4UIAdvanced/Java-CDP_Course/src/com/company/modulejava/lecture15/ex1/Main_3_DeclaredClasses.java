package com.company.modulejava.lecture15.ex1;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main_3_DeclaredClasses {

//    We can get Class of an object using three methods – through static variable class, using getClass() method of object and java.lang.Class.forName(String fullyClassifiedClassName).
//    For primitive types and arrays, we can use static variable class.
//    Wrapper classes provide another static variable TYPE to get the class.

    public static void main(String[] args) throws ClassNotFoundException {
    
// Get Super Class
        Class<?> concreteClass = ConcreteClass.class; //static variable class
//getting all of the classes, interfaces, and enums that are explicitly declared in ConcreteClass
        Class<?>[] explicitClasses = Class.forName("com.company.modulejava.lecture15.ex1.ConcreteClass").getDeclaredClasses();
//prints [class com.company.modulejava.lecture15.ex1.ConcreteClass$ConcreteClassDefaultClass,
//class com.company.modulejava.lecture15.ex1.ConcreteClass$ConcreteClassDefaultEnum,
//class com.company.modulejava.lecture15.ex1.ConcreteClass$ConcreteClassPrivateClass,
//class com.company.modulejava.lecture15.ex1.ConcreteClass$ConcreteClassProtectedClass,
//class com.company.modulejava.lecture15.ex1.ConcreteClass$ConcreteClassPublicClass,
//class com.company.modulejava.lecture15.ex1.ConcreteClass$ConcreteClassPublicEnum,
//interface com.company.modulejava.lecture15.ex1.ConcreteClass$ConcreteClassPublicInterface]

        Stream.of(explicitClasses).forEach(System.out::println);
//        System.out.println(Arrays.toString(classes));

    }
}

