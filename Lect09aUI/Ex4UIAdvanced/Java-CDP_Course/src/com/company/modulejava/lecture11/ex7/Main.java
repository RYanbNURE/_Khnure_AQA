package com.company.modulejava.lecture11.ex7;

import java.util.List;

public class Main {
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}
