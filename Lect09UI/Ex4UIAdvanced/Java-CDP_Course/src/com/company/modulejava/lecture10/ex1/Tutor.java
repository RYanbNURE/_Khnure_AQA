package com.company.modulejava.lecture10.ex1;

public class Tutor {

    private String name;

    private int salary;

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
