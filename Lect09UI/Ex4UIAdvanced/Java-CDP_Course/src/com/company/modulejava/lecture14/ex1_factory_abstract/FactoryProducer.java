package com.company.modulejava.lecture14.ex1_factory_abstract;


import com.company.modulejava.lecture14.ex1_factory_abstract.factory.AbstractFactory;
import com.company.modulejava.lecture14.ex1_factory_abstract.factory.RoundedShapeFactory;
import com.company.modulejava.lecture14.ex1_factory_abstract.factory.CommonShapeFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded) {
        if (rounded) {
            return new RoundedShapeFactory();
        } else {
            return new CommonShapeFactory();
        }

    }
}