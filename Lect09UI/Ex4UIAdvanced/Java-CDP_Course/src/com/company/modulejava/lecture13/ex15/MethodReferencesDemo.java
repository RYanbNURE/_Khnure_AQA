package com.company.modulejava.lecture13.ex15;

import java.util.Arrays;
import java.util.function.Function;

public class MethodReferencesDemo {
    public static void main(String[] args) {

        // 3. Reference to the instance method of an arbitrary object
        // Sometimes, we call a method of argument in the lambda expression.
        // In that case, we can use a method reference to call an instance
        // method of an arbitrary object of a specific type.

        Function<String, String> stringFunction = (String input) -> input.toLowerCase();
        System.out.println(stringFunction.apply("Java Guides"));

        // using method reference
        Function<String, String> stringFunctionMethodRef = String::toLowerCase;
        System.out.println(stringFunctionMethodRef.apply("Java Guides"));

        String[] strArray = { "A", "E", "I", "O", "U", "a", "e", "i", "o", "u" };

        // using lambda
        Arrays.sort(strArray, (s1, s2) -> s1.compareToIgnoreCase(s2));

        // using method reference
        Arrays.sort(strArray, String::compareToIgnoreCase);
    }
}
