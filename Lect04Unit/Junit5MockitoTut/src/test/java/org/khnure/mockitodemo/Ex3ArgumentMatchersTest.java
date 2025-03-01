package org.khnure.mockitodemo;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class Ex3ArgumentMatchersTest {

    @Test
    public void testUseArgumentMatchers() {
        // Створюємо макет об'єкта List
        List<String> mockedList = mock(List.class);

        // Відтворення поведінки: виклик методу add будь-якого рядка поверне true
        when(mockedList.add(anyString())).thenReturn(true);

        // Викликаємо метод add з рядком "test"
        boolean result = mockedList.add("test");

        // Перевірка результату
        assert result : "Метод add повинен повернути 'true'";

        System.out.println("Метод add з аргументом 'test' повернув " + result);
    }
}