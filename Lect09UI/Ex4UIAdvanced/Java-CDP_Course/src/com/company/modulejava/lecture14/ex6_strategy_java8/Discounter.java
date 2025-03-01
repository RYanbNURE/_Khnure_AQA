package com.company.modulejava.lecture14.ex6_strategy_java8;

import java.math.BigDecimal;

public interface Discounter {
    BigDecimal applyDiscount(BigDecimal amount);

}
