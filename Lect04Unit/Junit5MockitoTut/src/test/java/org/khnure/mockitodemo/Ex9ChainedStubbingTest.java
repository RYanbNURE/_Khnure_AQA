package org.khnure.mockitodemo;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.mockito.Mockito.*;

public class Ex9ChainedStubbingTest {

    @Test
    public void testChainedStubbing() {
        // Створення макета
        List<String> mockedList = mock(List.class);

        // Ланцюгове відтворення поведінки: послідовне повернення різних значень
        when(mockedList.get(anyInt()))
                .thenReturn("first")
                .thenReturn("second")
                .thenReturn("third");

        // Перевірка послідовних значень
        assert "first".equals(mockedList.get(0)) : "Перший виклик має повернути 'first'";
        assert "second".equals(mockedList.get(0)) : "Другий виклик має повернути 'second'";
        assert "third".equals(mockedList.get(0)) : "Третій виклик має повернути 'third'";

        System.out.println("Ланцюгове відтворення поведінки працює коректно");
    }
}