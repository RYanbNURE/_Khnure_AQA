package org.khnure.mockitodemo;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.mockito.Mockito.*;

public class Ex2BehaviourVerificationTest {

    @Test
    public void testVerifyBehaviour() {
        // Створюємо макет об'єкта List
        List<String> mockedList = mock(List.class);

        // Викликаємо метод add на макеті
        mockedList.add("one");
        mockedList.add("two");

        // Перевірка, чи були викликані методи з правильними аргументами
        verify(mockedList).add("one");
        verify(mockedList).add("two");

        // Перевірка, чи був метод add викликаний двічі
        verify(mockedList, times(2)).add(anyString());

        System.out.println("Поведінку вірно верифіковано");
    }
}