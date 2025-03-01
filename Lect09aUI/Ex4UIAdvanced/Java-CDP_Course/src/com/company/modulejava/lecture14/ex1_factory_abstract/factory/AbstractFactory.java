package com.company.modulejava.lecture14.ex1_factory_abstract.factory;

import com.company.modulejava.lecture14.ex1_factory_abstract.shape.Shape;

public abstract class AbstractFactory {
    public abstract Shape getShape(String shapeType) ;
}
