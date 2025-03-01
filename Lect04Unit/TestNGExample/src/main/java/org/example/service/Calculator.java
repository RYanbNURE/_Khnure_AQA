package org.example.service;

// Калькулятор, що надає базові математичні операції
public class Calculator {
    // Додавання двох чисел
    public int add(int a, int b) {
        return a + b;
    }

    // Віднімання двох чисел
    public int subtract(int a, int b) {
        return a - b;
    }

    // Множення двох чисел
    public int multiply(int a, int b) {
        return a * b;
    }

    // Ділення двох чисел
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Дільник не може бути нулем.");
        }
        return a / b;
    }
}
