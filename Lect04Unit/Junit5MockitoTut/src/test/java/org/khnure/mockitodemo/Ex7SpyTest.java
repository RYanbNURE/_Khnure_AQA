package org.khnure.mockitodemo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

public class Ex7SpyTest {

    @Test
    public void testUsingSpies() {
        // Створюємо шпигуна із справжнього об'єкта ArrayList
        List<String> list = new ArrayList<>();
        List<String> spyList = spy(list);

        // Використання шпигуна для перевірки фактичної роботи методів
        spyList.add("one");
        spyList.add("two");

        verify(spyList).add("one");
        verify(spyList).add("two");

        // Справжній об'єкт також змінюється при викликах
        assert list.size() == 2 : "Справжній список містить два елементи";

        System.out.println("Шпигун використано для перевірки додавання елементів");
    }
}