package com.company.modulejava.lecture11.ex6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void printList(List<Object> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static void printList1(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }


    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String>  ls = Arrays.asList("one", "two", "three");
        List<Integer> myIntList = new ArrayList<>();

//        List<Number> myObj = myIntList;
//        myIntList.add()

        List<? extends Number> numList = myIntList;
//        printList(li);
//        printList(ls);
//
//        List<>


        printList1(li);
        printList1(ls);
    }
}
