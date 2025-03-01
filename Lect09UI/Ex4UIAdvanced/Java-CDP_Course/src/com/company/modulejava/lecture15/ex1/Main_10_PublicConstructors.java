package com.company.modulejava.lecture15.ex1;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main_10_PublicConstructors {


    public static void main(String[] args) throws ClassNotFoundException {
//Get All public constructors
        Constructor<?>[] publicConstructors = Class.forName("com.company.modulejava.lecture15.ex1.ConcreteClass").getConstructors();
//prints public constructors of ConcreteClass
        System.out.println(Arrays.toString(publicConstructors));
    }
}

