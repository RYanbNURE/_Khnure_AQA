package com.company.modulejava.lecture14.ex1_coffee.machine;

public class MachineProvider {

    public static CommonBeverageMachine getCommonBeverageMachine(String beverageMachineType) {
        if ("tea".equals(beverageMachineType)) {
            return new  TeaMachine();
        } else if ("coffee".equals(beverageMachineType)) {
            return new CoffeeMachine();
        }

        throw new RuntimeException("No macine type is implemented");
    }
}
