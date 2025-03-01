package org.khnure.mockitodemo;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.mockito.Mockito.*;

public class Ex8TimeoutVerificationTest {

    @Test
    public void testMethodInvocationWithinTime() {
        // Створюємо макет
        List<String> mockedList = mock(List.class);

        // Симуляція додавання елемента двічі в список
        mockedList.add("item");
        mockedList.add("item");

        // Верифікація, що метод add викликається протягом заданого часу
        verify(mockedList, timeout(100).times(2)).add("item");

        System.out.println("Метод add викликається разом протягом 100 мс");
    }
}