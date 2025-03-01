package com.company.modulejava.lecture12.ex5;

public class Student {

    private String name;

    private int mark;

    public Student(String name, int mark){
        this.name = name;
        this.mark = mark;
    }

    public void printName(){
        System.out.println(name);
    }

    public void printMark(){
        System.out.println(mark);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void changeStudentInformation(String name, int mark){
        System.out.println("Changing student data");
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }
}
