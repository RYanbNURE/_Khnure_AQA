package com.company.modulejava.lecture14.ex2_factory.factory;

import com.company.modulejava.lecture14.ex2_factory.color.Black;
import com.company.modulejava.lecture14.ex2_factory.color.Color;
import com.company.modulejava.lecture14.ex2_factory.color.White;
import com.company.modulejava.lecture14.ex2_factory.factory.AbstractFactory;

public class ColorFactory implements AbstractFactory<Color> {

    @Override
    public Color create(String colorType) {
        if ("Black".equalsIgnoreCase(colorType)) {
            return new Black();
        } else if ("White".equalsIgnoreCase(colorType)) {
            return new White();
        }

        return null;
    }
}
