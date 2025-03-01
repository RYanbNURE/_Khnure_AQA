package com.company.modulejava.lecture14.ex2_factory;

import com.company.modulejava.lecture14.ex2_factory.factory.ColorFactory;

public class Main {
    public static void main(String[] args) {
        FactoryProvider.<ColorFactory>getFactory("Color").create("Black");
        FactoryProvider.getFactory("Animal").create("Dog");

    }
}
