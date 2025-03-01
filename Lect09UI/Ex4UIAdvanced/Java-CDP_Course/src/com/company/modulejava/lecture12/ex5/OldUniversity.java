package com.company.modulejava.lecture12.ex5;


import java.util.ArrayList;
import java.util.List;
@Deprecated
public class OldUniversity {

    private List<Student> students;

    public OldUniversity() {
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
