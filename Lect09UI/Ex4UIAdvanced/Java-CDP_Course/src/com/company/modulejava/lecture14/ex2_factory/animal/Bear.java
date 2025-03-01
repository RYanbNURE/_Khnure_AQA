package com.company.modulejava.lecture14.ex2_factory.animal;

import com.company.modulejava.lecture14.ex2_factory.animal.Animal;

public class Bear implements Animal {
    @Override
    public String getAnimal() {
        return "Bear";
    }

    @Override
    public String makeSound() {
        return "Bear Sound";
    }
}
