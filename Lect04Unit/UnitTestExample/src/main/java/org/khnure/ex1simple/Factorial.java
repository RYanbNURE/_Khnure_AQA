package org.khnure.ex1simple;

public class Factorial {
    public int calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        return (n <= 1) ? 1 : n * calculate(n - 1);
    }
}
