package com.company.modulejava.lecture13.ex21;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("a", "b", "c");
        String[] stringArray = stringStream.toArray(size -> new String[size]);
        Arrays.stream(stringArray).forEach(System.out::println);
    }
}
