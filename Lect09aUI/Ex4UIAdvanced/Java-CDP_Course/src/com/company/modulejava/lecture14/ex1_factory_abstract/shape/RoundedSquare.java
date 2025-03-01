package com.company.modulejava.lecture14.ex1_factory_abstract.shape;

public class RoundedSquare implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside RoundedSquare::draw() method.");
    }
}
