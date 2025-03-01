package com.company.modulejava.lecture10.ex1;

public class Child  extends Parent{

    private String childName;

    public Child (String name) {
        this.childName = name;
    }

    public void printChildName() {
        System.out.println(this.childName);
    }
}
