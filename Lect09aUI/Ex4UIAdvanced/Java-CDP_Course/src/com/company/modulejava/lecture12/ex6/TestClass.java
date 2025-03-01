package com.company.modulejava.lecture12.ex6;

public class TestClass {

    @Test
    public void test1 (){
        System.out.println("First method");
        assert 1 == 1;
    }

    @Test
    public void test2 (){
        System.out.println("Second method");

        assert 1 == 2;
    }

    @Test
    public void test3 (){
        System.out.println("Third method");

        assert 2 == 2;
    }
}
