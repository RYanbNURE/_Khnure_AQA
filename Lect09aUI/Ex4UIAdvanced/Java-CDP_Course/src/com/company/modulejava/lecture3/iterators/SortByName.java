package com.company.modulejava.lecture3.iterators;

import java.util.Comparator;

public class SortByName implements Comparator<Student> {


    @Override
    public int compare(Student first, Student second) {
        return first.name.compareTo(second.name);
    }
}
