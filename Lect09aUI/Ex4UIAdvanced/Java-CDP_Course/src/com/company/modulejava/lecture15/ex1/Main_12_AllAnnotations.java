package com.company.modulejava.lecture15.ex1;


import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main_12_AllAnnotations {


    public static void main(String[] args) throws ClassNotFoundException {
        java.lang.annotation.Annotation[] annotations = Class.forName("com.company.modulejava.lecture15.ex1.ConcreteClass").getAnnotations();
//prints [@java.lang.Deprecated()]
        System.out.println(Arrays.toString(annotations));
    }
}

