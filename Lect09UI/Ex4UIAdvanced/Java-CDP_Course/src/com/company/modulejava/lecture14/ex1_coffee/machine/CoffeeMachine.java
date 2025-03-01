package com.company.modulejava.lecture14.ex1_coffee.machine;

import com.company.modulejava.lecture14.ex1_coffee.coffee_types.*;
import com.company.modulejava.lecture14.ex1_coffee.common.CommonBeverage;

public class CoffeeMachine extends CommonBeverageMachine{

    public CommonBeverage getBeverage(String cofeeType) {
        System.out.println("Water for coffee boiling");
        if ("cappuccino".equals(cofeeType)){
            return new Cappuccino();
        } else if ("bru".equals(cofeeType)) {
            return new Bru();
        } else if ("latte".equals(cofeeType)) {
            return new Latte();
        } else if ("sunrise".equals(cofeeType)) {
            return new Sunrise();
        } else if ("irish".equals(cofeeType)) {
            return new Irish();
        }
        throw new RuntimeException("Don't have your choice in our machine");
    }
}
