package com.company.modulejava.lecture10.ex1;

import java.util.ArrayList;
import java.util.List;

public class NewBox <T> {
    //E and T symbols are just conventions
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void processData () {
        System.out.println("Data processing " + this.data);
    }

    public static void main(String[] args) {
        NewBox<String> box2 = new NewBox<>();
        NewBox<Tutor> box3 = new NewBox<>();
        NewBox<Integer> box4 = new NewBox<>();

        OldBox oldBox1 = new OldBox();
        oldBox1.setData(new Student());
        String studentFromOldBox = (String) oldBox1.getData();

        NewBox<Student> box1 = new NewBox<>();
        box1.setData(new Student());
        Student studentFromNewBox = box1.getData();

        NewBox[] newBoxArray = {box1, box2, box3, box4};

        for (NewBox newBox: newBoxArray) {
            newBox.processData();
        }

        new ArrayList<>();


    }
}
