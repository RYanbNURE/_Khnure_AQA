package com.company.modulejava.lecture12;

public class OldStyleArrayList {

    Object [] data;
    int count = 0;

    public OldStyleArrayList(){
        data = new Object[100];
    }

    public void add(Object object) {
        data[count] = object;
        count ++;
    }

    public Object get(int position) {
        return data[count];
    }

    public void printList(){
        for (Object o:
             data) {
            System.out.println("Printing " + o);
        }
    }
}
