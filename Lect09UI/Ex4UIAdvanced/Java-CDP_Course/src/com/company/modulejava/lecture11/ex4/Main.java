package com.company.modulejava.lecture11.ex4;

public class Main {
//    public static <T> int countGreaterThan(T[] anArray, T elem) {
//        int count = 0;
//        for (T e : anArray)
//            if (e > elem)  // compiler error
//                ++count;
//        return count;
//    }

    public static <T extends Comparable> boolean myComparisonMethod(T first, T second) {
        if (first.compareTo(second) > 1) {
            return true;
        } else {
            return false;
        }
    }


    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }
}
