package org.khnure.ex2mockito;

public class Calculator {
    private MathService mathService;

    public Calculator(MathService mathService) {
        this.mathService = mathService;
    }

    public int calculateSquare(int number) {
        return mathService.multiply(number, number);
    }
}
