package com.example;

public class Calculator {
    public int add(int x, int y) {
        return x + y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public double divide(int x, int y) {
        if (y == 0) throw new IllegalArgumentException("Cannot divide by zero");
        return (double) x / y;
    }
}
