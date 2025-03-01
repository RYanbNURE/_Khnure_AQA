package com.company.modulejava.lecture11.ex2;

import com.company.modulejava.lecture10.ex1.Student;
import com.company.modulejava.lecture11.ex1.Ex3Pair;
import com.company.modulejava.lecture11.ex1.Ex4OrderedPair;

public class Ex1Util {
    public static <K, V> boolean compare(Ex3Pair<K, V> p1, Ex3Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }

    public static <E> E print (E element){
        System.out.println(element.getClass());
        return element;
    }

    public static void main(String[] args) {
        String result1 = print("Test");
        Integer result2 = print(1);
        print(1.2);
        print(new Student());
        print(new int[2]);


        Ex3Pair<String, Integer> p1 = new Ex4OrderedPair<>("even", 2);
        Ex3Pair<String, Integer> p2 = new Ex4OrderedPair<>("odd", 3);

        System.out.println(Ex1Util.compare(p1, p2));
    }
}
