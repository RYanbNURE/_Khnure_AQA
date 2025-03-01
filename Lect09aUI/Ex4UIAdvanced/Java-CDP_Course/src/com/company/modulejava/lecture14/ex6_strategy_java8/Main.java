package com.company.modulejava.lecture14.ex6_strategy_java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Discounter easterDiscounter = new EasterDiscounter();

        BigDecimal discountedValue = easterDiscounter
                .applyDiscount(BigDecimal.valueOf(100));

        System.out.println(discountedValue.equals(BigDecimal.valueOf(50)));



        //--------------------Java 8 ---------------------------------------

        Discounter easterDiscounter1 = amount -> amount.multiply(BigDecimal.valueOf(0.5));
    }
}
