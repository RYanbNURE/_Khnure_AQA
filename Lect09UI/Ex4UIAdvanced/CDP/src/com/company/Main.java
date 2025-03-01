package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] students = new String[10];
        String studentName = "Peter Parker";
        students[0] = studentName;
        studentName = null;
        System.out.println(students[0]);

        new Student().test();

        int[] arr = new int[10];
        int a= 1;
        arr[0] = a;
        a = 0;
        System.out.println(arr[0]);

        Student[] students1 = new Student[10];
        Student test = new Student();
        test.setName("AAA");
        students1[0] = test;
        test.setName("BBB");
        System.out.println(students1[0]);

        List<Student> students2 = new ArrayList<>();
        Student test2 = new Student();
        test2.setName("BBB");
        students2.add(test2);
        test2.setName("CCC");
        students2.get(0).setName("TTT");
        System.out.println(students2.get(0));

    }
}
