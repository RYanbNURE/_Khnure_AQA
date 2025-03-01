package com.company.modulejava.lecture14.ex1_factory_abstract.factory;

import com.company.modulejava.lecture14.ex1_factory_abstract.shape.RoundedRectangle;
import com.company.modulejava.lecture14.ex1_factory_abstract.shape.RoundedSquare;
import com.company.modulejava.lecture14.ex1_factory_abstract.shape.Shape;

public class RoundedShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RoundedRectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new RoundedSquare();
        }
        return null;
    }
}
