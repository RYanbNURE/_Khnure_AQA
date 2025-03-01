package com.company.modulejava.lecture13.ex3;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        List<Person> myList = new ArrayList<>();
        myList.add(new Person(100, "Ramesh"));
        myList.add(new Person(101, "A"));
        myList.add(new Person(102, "B"));
        myList.add(new Person(103, "C"));
        myList.add(new Person(104, "D"));

        Person personInResult = null;

        for (Person p :
                myList) {
            if (p.getName().equals("R")) {
                personInResult = p;
            }
        }

        if (personInResult != null) {
            System.out.println("Ramesh id = " + personInResult.getId());
        } else {
            System.out.println("No person with a name R");
        }

        Person ramesh = myList.stream().filter(person -> person.getName().equals("Ramesh")).findAny().get();

        System.out.println(ramesh.getId());

//        Map<Integer, Person> myMap = new HashMap<>();
//
//        myMap.put(1, new Person(100, "Ramesh"));
//        myMap.put(2, new Person(101, "A"));
//
//        Set<Person> mySet = new HashSet<>();
//        mySet.add(new Person(100, "Ramesh"));
//        mySet.add(new Person(101, "A"));
//
////        mySet.forEach();
////
////        myMap.forEach();
//
////        Consumer<Person> myConsumer = person -> {
////            System.out.println("Send to DB");
////            System.out.println(person.getName());
////        };
//
//        myList.forEach(person -> {
//            System.out.println("Send to DB");
//            System.out.println(person.getName());
//        });
////        myList.forEach(item -> System.out.println(item.getName()));
//
//        myList.contains()
//
//
//
//
//        //Output : C
//        myList.forEach(item -> {
//        if ("C".equals(item)) {
//            System.out.println(item);
//        }
//    });
//
//        //method reference
//        //Output : A,B,C,D,E
//        myList.forEach(System.out::println);
//
//        //Stream and filter
//        //Output : B
//        myList.stream()
//                .filter(s -> s.getName().equals("Ramesh"))
//                .forEach(person -> System.out.println(person.getName()));
//    }
//
//    public static void forEachWithMap() {
//
//        // Before Java 8, how to loop map
//        final Map<Integer, Person> map = new HashMap< >();
//        map.put(1, new Person(100, "Ramesh"));
//        map.put(2, new Person(100, "Ram"));
//        map.put(3, new Person(100, "Prakash"));
//        map.put(4, new Person(100, "Amir"));
//        map.put(5, new Person(100, "Sharuk"));
//
//        //  In Java 8, you can loop a Map with forEach + lambda expression.
//        map.forEach((k, p) -> {
//                System.out.println(k);
//        System.out.println(p.getName());
//    });
//    }
//
//    public static void main(String[] args) {
//
//    }
    }
}
