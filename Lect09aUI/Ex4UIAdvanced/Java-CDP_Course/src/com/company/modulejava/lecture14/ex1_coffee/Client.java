package com.company.modulejava.lecture14.ex1_coffee;

import com.company.modulejava.lecture14.ex1_coffee.common.CommonBeverage;
import com.company.modulejava.lecture14.ex1_coffee.machine.CoffeeMachine;
import com.company.modulejava.lecture14.ex1_coffee.coffee_types.Coffee;
import com.company.modulejava.lecture14.ex1_coffee.machine.CommonBeverageMachine;
import com.company.modulejava.lecture14.ex1_coffee.machine.MachineProvider;
import com.company.modulejava.lecture14.ex1_coffee.machine.TeaMachine;
import com.company.modulejava.lecture14.ex1_coffee.tea_types.Tea;

public class Client {

    public void orderBeverage (String beverageFamily, String beverageType) {

        CommonBeverageMachine commonBeverageMachine = MachineProvider.getCommonBeverageMachine(beverageFamily);

        CommonBeverage beverage = commonBeverageMachine.getBeverage(beverageType);

        beverage.getBeverage();

        System.out.println("I am drinking " + beverage.getClass().getSimpleName());
    }
}
