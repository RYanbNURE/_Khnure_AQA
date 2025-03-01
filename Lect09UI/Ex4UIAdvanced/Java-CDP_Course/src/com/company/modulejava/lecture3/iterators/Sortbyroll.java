package com.company.modulejava.lecture3.iterators;

import java.util.Comparator;

public class Sortbyroll implements Comparator<Student> {

    public int compare(Student a, Student b)
    {
        return a.rollno - b.rollno;
    }
}
