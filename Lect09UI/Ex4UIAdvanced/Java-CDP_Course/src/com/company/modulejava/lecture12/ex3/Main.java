package com.company.modulejava.lecture12.ex3;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        Class aClass = TheClass.class;
        Annotation[] annotations = aClass.getAnnotations();

        for(Annotation annotation : annotations){
            if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }


        Class myClass = TheClass.class;
        Annotation annotation = myClass.getAnnotation(MyAnnotation.class);

        if(annotation instanceof MyAnnotation){
            MyAnnotation myAnnotation = (MyAnnotation) annotation;
            System.out.println("name: " + myAnnotation.name());
            System.out.println("value: " + myAnnotation.value());
        }
    }
}
