package com.company.modulejava.lecture14.ex2_factory.animal;

import com.company.modulejava.lecture14.ex2_factory.animal.Animal;

public class Duck implements Animal {
    @Override
    public String getAnimal() {
        return "Duck";
    }

    @Override
    public String makeSound() {
        return "Squeks";
    }
}
