package com.example.service;

import org.example.service.Calculator;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

// Тести для калькулятора
public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        int result = calculator.add(2, 3);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(5, 3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testMultiply() {
        int result = calculator.multiply(2, 3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testDivide() {
        int result = calculator.divide(6, 3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testDivideByZero() {
        assertThatThrownBy(() -> calculator.divide(1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Дільник не може бути нулем.");
    }
}