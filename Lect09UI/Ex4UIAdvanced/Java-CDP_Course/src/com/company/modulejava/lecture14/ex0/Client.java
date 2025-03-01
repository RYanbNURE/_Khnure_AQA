package com.company.modulejava.lecture14.ex0;

public class Client {
    public static void main(String[] args) {
        CrossCompiler iphone = new IPhoneCompiler();
        iphone.crossCompile();
        CrossCompiler android = new AndroidCompiler();
        android.crossCompile();
    }
}
