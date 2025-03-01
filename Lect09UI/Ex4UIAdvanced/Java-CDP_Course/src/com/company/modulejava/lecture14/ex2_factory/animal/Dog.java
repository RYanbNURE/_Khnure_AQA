package com.company.modulejava.lecture14.ex2_factory.animal;

import com.company.modulejava.lecture14.ex2_factory.animal.Animal;

public class Dog implements Animal {
    @Override
    public String getAnimal() {
        return "Dog";
    }

    @Override
    public String makeSound() {
        return "Bark";
    }
}
