package com.company.modulejava.lecture4.construct;

public class Ex5 {
    String language;
    String complexity;

    // constructor with no parameter
    Ex5() {
        this.language = "Java";
    }

    // constructor with a single parameter
    Ex5(String language) {
        this.language = language;
    }

    Ex5(String language, String complexity) {
        this.language = language;
        this.complexity = complexity;
    }

    public void getName() {
        System.out.println("Programming Langauage: " + this.language);
    }

    public static void main(String[] args) {

        // call constructor with no parameter
        Ex5 obj1 = new Ex5();

        // call constructor with a single parameter
        Ex5 obj2 = new Ex5("Python");
        Ex5 obj3 = new Ex5("Python", "Medium");

        obj1.getName();
        obj2.getName();
    }
}