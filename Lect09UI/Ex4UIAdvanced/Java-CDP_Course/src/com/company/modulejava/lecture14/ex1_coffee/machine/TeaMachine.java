package com.company.modulejava.lecture14.ex1_coffee.machine;

import com.company.modulejava.lecture14.ex1_coffee.common.CommonBeverage;
import com.company.modulejava.lecture14.ex1_coffee.tea_types.ColdTea;
import com.company.modulejava.lecture14.ex1_coffee.tea_types.GreenTea;
import com.company.modulejava.lecture14.ex1_coffee.tea_types.HotTea;
import com.company.modulejava.lecture14.ex1_coffee.tea_types.Tea;

public class TeaMachine extends CommonBeverageMachine{

    public CommonBeverage getBeverage(String teaType) {
        System.out.println("Water for tea boiling");

        if ("cold tea".equals(teaType)) {
            return new ColdTea();
        } else if ("hot tea".equals(teaType)) {
            return new HotTea();
        }else if ("green tea".equals(teaType)) {
            return new GreenTea();
        }

        throw new RuntimeException("No such tea type");
    }
}
