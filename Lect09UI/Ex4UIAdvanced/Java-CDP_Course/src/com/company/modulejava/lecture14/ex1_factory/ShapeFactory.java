package com.company.modulejava.lecture14.ex1_factory;

public class ShapeFactory {
    //use getShape method to get object of type shape
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();

        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();

        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();

        } else if(shapeType.equalsIgnoreCase("HEXAGON")){
        return new Hexagon();

        } else if(shapeType.equalsIgnoreCase("TRIANGLE")){
            return new Triangle();
        }

        throw new RuntimeException("Shape is not defined");
    }
}
