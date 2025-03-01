package com.company.modulejava.lecture12.ex2;

import java.lang.reflect.Method;

public class MyTest {
    public static void main(String[] args) {
        AnnotationRunner runner = new AnnotationRunner();
        Method[] methods = runner.getClass().getMethods();

//        runner.method2();
//        runner.method5();

        for (Method method : methods) {
            CanRun annos = method.getAnnotation(CanRun.class);
            if (annos != null) {
                try {
                    method.invoke(runner);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
