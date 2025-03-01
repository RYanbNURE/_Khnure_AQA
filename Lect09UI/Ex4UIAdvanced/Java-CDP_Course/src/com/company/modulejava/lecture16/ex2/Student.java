package com.company.modulejava.lecture16.ex2;

public class Student {

    private String name;

    private int age;

    private double averageMark;

    public Student(String name, int age, double averageMark) {
        this.name = name;
        this.age = age;
        this.averageMark = averageMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", averageMark=" + averageMark +
                '}';
    }
}
