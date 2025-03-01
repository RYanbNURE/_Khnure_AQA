package com.company;

public class Student {
    private String name;

    public void test(){
        System.out.println("AAAAAAAAAA");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
