package com.company.modulejava.lecture16.ex1;

public class University implements Cloneable{

    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
