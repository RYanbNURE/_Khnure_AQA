package com.company.modulejava.lecture14.ex1_factory;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactoryPatternDemo {
    public static void main(String[] args) throws IOException {
        ShapeFactory shapeFactory = new ShapeFactory();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String shapeType = reader.readLine();

        Shape shape = shapeFactory.getShape(shapeType);

        shape.draw();
//        //get an object of Circle and call its draw method.
//        Shape circle = shapeFactory.getShape("TRIANGLE");
//
//        //call draw method of Circle
////        circle.draw();
//
//        //get an object of Rectangle and call its draw method.
//        Shape rectangle = shapeFactory.getShape("RECTANGLE");
//
//        //call draw method of Rectangle
//        rectangle.draw();
//
//        //get an object of Square and call its draw method.
//        Shape square = shapeFactory.getShape("SQUARE");
//
//        //call draw method of square
//        square.draw();
    }
}
