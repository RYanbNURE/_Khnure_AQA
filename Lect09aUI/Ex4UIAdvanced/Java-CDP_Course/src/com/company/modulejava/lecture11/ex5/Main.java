package com.company.modulejava.lecture11.ex5;

import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.List;

public class Main {
//    public static void process(List<? extends Foo> list) { /* ... */ }

//    public static void process(List<? extends Foo> list) {
//        for (Foo elem : list) {
//            // ...
//        }
//    }

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public static <T extends Number> double sumOfList1(T v) {
        System.out.println(v);
        return 1.2;
    }



    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));

        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld));
    }

}
