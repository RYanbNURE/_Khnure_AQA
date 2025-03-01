package com.company.modulejava.lecture14.ex1_factory_abstract.shape;

public class CommonRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
