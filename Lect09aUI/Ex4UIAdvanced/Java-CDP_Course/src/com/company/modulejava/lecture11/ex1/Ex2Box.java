package com.company.modulejava.lecture11.ex1;

public class Ex2Box<E> {
    // T stands for "Type"
    private E t;

    public void set(E t) { this.t = t; }
    public E get() { return t; }
}
