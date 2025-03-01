package com.company.modulejava.lecture14.ex1_factory_abstract.factory;

import com.company.modulejava.lecture14.ex1_factory_abstract.shape.CommonRectangle;
import com.company.modulejava.lecture14.ex1_factory_abstract.shape.Shape;
import com.company.modulejava.lecture14.ex1_factory_abstract.shape.CommonSquare;

public class CommonShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new CommonRectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new CommonSquare();
        }
        return null;
    }
}
