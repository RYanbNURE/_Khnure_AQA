package com.company.modulejava.lecture12.ex5;

import java.util.Stack;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {



        @Active
        //This is an active student
        Student jack = new Student("Jack", 4);

        @Sabbatical
        Student john = new Student("John", 5);

        Student marry = new Freshmen("Marry", 3);

        marry.printName();

        marry.changeStudentInformation("Jane", 5);
//        marry.changeStudentInformation(5, "Jane");

        OldUniversity university = new OldUniversity();

        university.enterUniversity(john);
        university.enterUniversity(jack);
        university.enterUniversity(marry);

        university.printStudents();
    }
}
