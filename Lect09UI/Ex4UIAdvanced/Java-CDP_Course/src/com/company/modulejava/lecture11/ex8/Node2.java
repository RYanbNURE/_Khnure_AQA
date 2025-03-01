package com.company.modulejava.lecture11.ex8;

public class Node2 <T extends Comparable<T>>{
    private T data;
    private Node2<T> next;

    public Node2(T data, Node2<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() { return data; }
    // ...
}


//public class Node {
//
//    private Comparable data;
//    private Node next;
//
//    public Node(Comparable data, Node next) {
//        this.data = data;
//        this.next = next;
//    }
//
//    public Comparable getData() { return data; }
//    // ...
//}