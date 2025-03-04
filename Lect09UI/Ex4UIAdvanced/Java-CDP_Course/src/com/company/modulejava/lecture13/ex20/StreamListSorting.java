package com.company.modulejava.lecture13.ex20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Sort List of String objects in Ascending order using Java 8 Stream APIs

public class StreamListSorting {
    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Kiwi");

        fruits.sort((o1, o2) -> o1.compareTo(o2));
        fruits.sort((o1, o2) -> o2.length() - o1.length());

        for (String fruit: fruits) {
            System.out.println(fruit);
        }

//        List <String> sortedList = fruits.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
//        System.out.println(sortedList);
//
//        List < String > sortedList1 = fruits.stream().sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());
//        System.out.println(sortedList1);
//
//        List < String > sortedList2 = fruits.stream().sorted().collect(Collectors.toList());
//        System.out.println(sortedList2);
    }
}
