package com.company.modulejava.lecture13.ex1;

public class LambdaExpressionExampleNew {
    public static void main(String[] args) {
        //with lambda
        Drawable withLambda=()-> System.out.println("Drawing");
        withLambda.draw();
    }
}
