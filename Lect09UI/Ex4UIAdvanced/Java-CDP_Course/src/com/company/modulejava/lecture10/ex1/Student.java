package com.company.modulejava.lecture10.ex1;

public class Student {
    private String name;
    private int mark;

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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }
}
