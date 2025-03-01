package org.khnure.mockitodemo;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.mockito.Mockito.*;

public class Ex6ReturningValuesTest {

    @Test
    public void testReturningValues() {
        // Створюємо макет об'єкта List
        List<String> mockedList = mock(List.class);

        // Відтворення поведінки: метод get(0) і get(1) повертають рядки "first" і "second"
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenReturn("second");

        // Ассерти підтверджують правильність повернених значень
        assert "first".equals(mockedList.get(0)) : "Перший елемент має бути 'first'";
        assert "second".equals(mockedList.get(1)) : "Другий елемент має бути 'second'";

        System.out.println("Методи get(0) та get(1) правильно повертають значення");
    }
}