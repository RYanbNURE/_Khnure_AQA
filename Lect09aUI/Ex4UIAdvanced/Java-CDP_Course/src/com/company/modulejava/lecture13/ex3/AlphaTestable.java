package com.company.modulejava.lecture13.ex3;

public interface AlphaTestable {

//    int application = 100;
//
    void test();

    default void testDefault(){
        System.out.println("I am alpha tested");
    }
}
