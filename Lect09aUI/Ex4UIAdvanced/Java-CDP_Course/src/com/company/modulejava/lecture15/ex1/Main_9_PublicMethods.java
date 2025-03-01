package com.company.modulejava.lecture15.ex1;


import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main_9_PublicMethods {


    public static void main(String[] args) throws ClassNotFoundException {
        Method[] publicMethods = Class.forName("com.company.modulejava.lecture15.ex1.ConcreteClass").getMethods();
//prints public methods of ConcreteClass, BaseClass, Object
//        System.out.println(Arrays.toString(publicMethods));
        Stream.of(publicMethods).forEach(System.out::println);
    }
}

