package com.company.modulejava.lecture13.ex11;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DifferentWaysListIterateProgram {
    public static void main(String...args) {

        List<String> courses = Arrays.asList("C", "C++", "Core Java", "J2EE", "Spring", "Hibernate", "Python");

        // Basic loop
        for (int i = 0; i < courses.size(); i++) {
            String course = courses.get(i);
            printCourse(course);
        }

        // Enhanced for loop
        for (String course: courses) {
            printCourse(course);
        }

        // Basic loop with iterator
        for (Iterator<String> it = courses.iterator(); it.hasNext();) {
            String course = it.next();
            printCourse(course);
        }

        // Iterator with while loop
        Iterator <String> it = courses.iterator();
        while (it.hasNext()) {
            String course = it.next();
            printCourse(course);
        }

        // JDK 8 streaming example lambda expression
        courses.stream().forEach(course -> printCourse(course));

        // JDK 8 streaming example method reference
        courses.stream().forEach(DifferentWaysListIterateProgram::printCourse);

        // JDK 8 for each with lambda
        courses.forEach(course -> printCourse(course));

        // JDK 8 for each
        courses.forEach(DifferentWaysListIterateProgram::printCourse);
    }

    // common method to print course
    private static void printCourse(String course) {
        System.out.println("course name :: " + course);
    }
}
