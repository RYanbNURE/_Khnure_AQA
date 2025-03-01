package org.khnure;

import org.testng.annotations.Test;

public class Ex4GroupTest {

    @Test(groups = { "functionality" })
    public void testMethod1() {
        // Тест перевіряє певну функціональність
        System.out.println("Функціональний тест 1.");
    }

    @Test(groups = { "performance" })
    public void testMethod2() {
        // Тест перевіряє швидкодію системи
        System.out.println("Тест швидкодії 2.");
    }

    @Test(groups = { "functionality", "security" })
    public void testMethod3() {
        // Тест, що входить у групи функціональності та безпеки
        System.out.println("Функціональний та безпечний тест 3.");
    }
}