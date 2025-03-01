package com.company.modulejava.lecture13.ex17;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // String array
        String[] arr = {
                "One",
                "Two",
                "Three",
                "Four",
                "Five"
        };

        // array to Stream
        Stream < String > stream1 = Arrays.stream(arr);
        Stream < String > stream2 = Arrays.stream(arr, 0, 2);
        Stream < String > stream3 = Arrays.asList(arr).stream();
        Stream < String > stream4 = Arrays.asList(arr).subList(0, 2).stream();
        Stream < String > stream5 = Stream.of(arr);
        Stream < String > stream6 = Stream.of("One", "Two", "Three");

        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);
        stream3.forEach(System.out::println);
        stream4.forEach(System.out::println);
        stream5.forEach(System.out::println);
        stream6.forEach(System.out::println);

        // integers array
        int[] integers = {
                2,
                3,
                4,
                1
        };
        Integer[] boxedInt = {
                2,
                3,
                4,
                1
        };

        IntStream intStream1 = Arrays.stream(integers);
        IntStream intStream2 = IntStream.of(integers);
        IntStream intStream3 = IntStream.range(0, integers.length);;
        IntStream intStream4 = IntStream.rangeClosed(0, integers.length);
        Stream <Integer> intStream5 = Stream.of(boxedInt);

        int[] intArray1 = intStream1.toArray();
        int[] intArray2 = intStream5.mapToInt(i -> i).toArray();
    }
}
