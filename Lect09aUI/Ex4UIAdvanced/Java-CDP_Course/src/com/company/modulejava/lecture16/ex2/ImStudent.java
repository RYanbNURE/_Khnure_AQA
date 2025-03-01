package com.company.modulejava.lecture16.ex2;

public class ImStudent {
    private String name;

    private int age;

    private double averageMark;

    public ImStudent(String name, int age, double averageMark) {
        this.name = name;
        this.age = age;
        this.averageMark = averageMark;
    }

    public ImStudent setName(String newName){
        return new ImStudent(newName, this.age, this.averageMark);
    }

    public ImStudent setAge(int newAge){
        return new ImStudent(this.name, newAge, this.averageMark);
    }

    public ImStudent setAverageMark(double newAverageMark){
        return new ImStudent(this.name, this.age, newAverageMark);
    }
}
