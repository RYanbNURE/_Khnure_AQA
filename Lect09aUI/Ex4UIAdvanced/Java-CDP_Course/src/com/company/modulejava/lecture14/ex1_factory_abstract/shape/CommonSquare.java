package com.company.modulejava.lecture14.ex1_factory_abstract.shape;

public class CommonSquare implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
