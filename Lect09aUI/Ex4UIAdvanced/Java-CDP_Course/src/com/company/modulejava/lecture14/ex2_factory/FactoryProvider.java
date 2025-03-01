package com.company.modulejava.lecture14.ex2_factory;

import com.company.modulejava.lecture14.ex2_factory.factory.AbstractFactory;
import com.company.modulejava.lecture14.ex2_factory.factory.AnimalFactory;
import com.company.modulejava.lecture14.ex2_factory.factory.ColorFactory;

public class FactoryProvider {
    public static AbstractFactory getFactory(String choice){

        if("Animal".equalsIgnoreCase(choice)){
            return new AnimalFactory();
        }
        else if("Color".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }

        return null;
    }
}
