package com.company.modulejava.lecture13.ex3;

public class MyApp extends MyAppParent implements Testable, BetaTestable, AlphaTestable {
    @Override
    public void test() {
        System.out.println("Testing my app as well");
    }

    public static void main(String[] args) {
        new MyApp().test();
        new MyApp().testDefault();
    }
}
