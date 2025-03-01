package com.company.modulejava.lecture13.ex13;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferencesDemo {
    public static int addition(int a, int b){
        return ( a + b);
    }

    public static void main(String[] args) {

        // 1. Method reference to a static method
        // lambda expression
        Function<Integer, Double> function = (input) -> Math.sqrt(input);
        System.out.println(function.apply(4));

        // using method reference
        Function<Integer, Double> functionMethodRef = Math::sqrt;
        System.out.println(functionMethodRef.apply(4));

        // lambda expression
        BiFunction<Integer, Integer, Integer> biFunctionLambda = (a , b) -> MethodReferencesDemo.addition(a, b);
        System.out.println(biFunctionLambda.apply(10, 20));

        // using method reference
        BiFunction<Integer, Integer, Integer> biFunction = MethodReferencesDemo::addition;
        System.out.println(biFunction.apply(10, 20));
    }
}
