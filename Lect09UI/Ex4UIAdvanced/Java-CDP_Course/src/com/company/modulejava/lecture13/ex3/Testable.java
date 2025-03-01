package com.company.modulejava.lecture13.ex3;

public interface Testable {

//    int application = 100;
//
    void test();

    default void testDefault(){
        System.out.println("I am tested");
    }
}
