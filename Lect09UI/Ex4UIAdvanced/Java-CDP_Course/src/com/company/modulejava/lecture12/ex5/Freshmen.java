package com.company.modulejava.lecture12.ex5;

public class Freshmen extends Student{

    public Freshmen(String name, int mark) {
        super(name, mark);
    }

    @Override
    public void printName(){
        System.out.println("I am freshman " + super.getName());
    }

    @Override
    public void changeStudentInformation(String name, int mark) {
        System.out.println("Changing freshmen information");
        super.setName(name);
        super.setMark(mark);
    }
}
