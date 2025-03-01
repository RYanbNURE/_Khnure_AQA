package com.company.modulejava.lecture11.ex3;

public class D <T extends A & B & C>{

    private T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public static void main(String[] args) {
        D d = new D();

        d.setType(new ChildOfA());
        d.setType(new ChildOfB());
        d.setType(new ChildOfC());
    }
}
