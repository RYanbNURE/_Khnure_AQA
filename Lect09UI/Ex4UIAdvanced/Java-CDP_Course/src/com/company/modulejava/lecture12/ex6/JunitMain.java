package com.company.modulejava.lecture12.ex6;

import com.company.modulejava.lecture12.ex1.ClassWithAnnotations;
import com.company.modulejava.lecture12.ex2.CanRun;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JunitMain {

    public static void main(String[] args) {

        TestClass testClass = new TestClass();
        Method[] methods = TestClass.class.getMethods();

        for (Method method :
                methods) {
            Test testAnnotation = method.getAnnotation(Test.class);
            if (testAnnotation != null) {
                try {
                    method.invoke(testClass);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}