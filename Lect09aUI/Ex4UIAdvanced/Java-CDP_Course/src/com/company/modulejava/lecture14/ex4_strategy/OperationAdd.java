package com.company.modulejava.lecture14.ex4_strategy;

public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
