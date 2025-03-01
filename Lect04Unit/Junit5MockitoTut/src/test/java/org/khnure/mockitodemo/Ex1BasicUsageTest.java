package org.khnure.mockitodemo;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Ex1BasicUsageTest {

    @Test
    public void testMock() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
        verify(mockedList).clear();

        System.out.println("Тестування з використанням Mockito для перевірки дій");
    }
}
