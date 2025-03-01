package org.khnure.mockitodemo;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.mockito.Mockito.*;

public class Ex5ExceptionHandlingTest {

    @Test
    public void testHandleException() {
        // Створюємо макет об'єкта List
        List<String> mockedList = mock(List.class);

        // Встановлюємо виняток для методу get, коли індекс 1
        when(mockedList.get(1)).thenThrow(new IndexOutOfBoundsException("Index: 1, Size: 0"));

        try {
            mockedList.get(1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Виняток оброблено: " + e.getMessage());
        }
    }
}