package com.company.modulejava.lecture4.methods;

public class Ex7HelperAdv {
    private String formatNumber(Integer integer) {
        System.out.println("inside integer");
        return String.format("%d", integer);
    }

    private String formatNumber(Number number) {
        System.out.println("inside number");
        return String.format("%.3f", number);
    }

//    private String formatNumber(String value) {
//        return String.format("%.2f", Double.parseDouble(value));
//    }

    public static void main(String[] args) {
        Ex7HelperAdv hs = new Ex7HelperAdv();
        hs.formatNumber(1);
    }
}
