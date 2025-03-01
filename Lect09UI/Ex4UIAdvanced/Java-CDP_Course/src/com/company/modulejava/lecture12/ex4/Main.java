package com.company.modulejava.lecture12.ex4;

import com.company.modulejava.lecture12.ex3.TheClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        Class aClass = TheNewClass.class;
        Method method = aClass.getMethod("doSomething"); //obtain method object
        Annotation[] annotations = method.getDeclaredAnnotations();

        for(Annotation annotation : annotations){
            if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }

//        Method method = ... // obtain method object
        Annotation annotation = method.getAnnotation(MyAnnotation.class);

        if(annotation instanceof MyAnnotation){
            MyAnnotation myAnnotation = (MyAnnotation) annotation;
            System.out.println("name: " + myAnnotation.name());
            System.out.println("value: " + myAnnotation.value());
        }

    }
}
