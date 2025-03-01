package com.company.modulejava.lecture12.ex5;

import java.util.ArrayList;
import java.util.List;

public class NewUniversity {
    private List<Student> students;

    public NewUniversity() {
        this.students = new ArrayList<>();
    }

    public void enterUniversity(Student student){
        students.add(student);
    }

    public void printStudents(){
        for (Student student:
                students) {
            System.out.println(student);
        }
    }
}
