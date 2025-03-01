package com.company.modulejava.lecture14.ex2_factory.factory;

import com.company.modulejava.lecture14.ex2_factory.animal.Animal;
import com.company.modulejava.lecture14.ex2_factory.animal.Dog;
import com.company.modulejava.lecture14.ex2_factory.animal.Duck;
import com.company.modulejava.lecture14.ex2_factory.factory.AbstractFactory;

public class AnimalFactory implements AbstractFactory<Animal> {

    @Override
    public Animal create(String animalType) {
        if ("Dog".equalsIgnoreCase(animalType)) {
            return new Dog();
        } else if ("Duck".equalsIgnoreCase(animalType)) {
            return new Duck();
        }

        return null;
    }
}
