package com.company.modulejava.lecture15.ex1;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main_11_PublicFields {


    public static void main(String[] args) throws ClassNotFoundException {
//Get All public fields
        Field[] publicFields = Class.forName("com.company.modulejava.lecture15.ex1.ConcreteClass").getFields();
//prints public fields of ConcreteClass, it's superclass and super interfaces
        Stream.of(publicFields).forEach(System.out::println);
    }
}

