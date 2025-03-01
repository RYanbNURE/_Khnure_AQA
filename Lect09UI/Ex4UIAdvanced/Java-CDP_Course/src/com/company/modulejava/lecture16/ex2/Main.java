package com.company.modulejava.lecture16.ex2;

public class Main {

    public static void main(String[] args) {
        Student mark = new Student("Mark", 20, 4.3);

        mark.setName("Joe");
        mark.setAge(21);
        mark.setAverageMark(4.0);

        //----program flow

        mark.setAge(21);

        mark.setAverageMark(5);

        ImStudent joe = new ImStudent("Joe", 18, 4.5);

        ImStudent newJoe = joe.setAge(19);
    }
}
