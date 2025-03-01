package org.khnure.mockitodemo;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.List;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Ex4AnnotatedMocksTest {

    @Mock
    List<String> mockedList;

    @Test
    public void testAnnotatedMock() {
        mockedList.add("mock");
        verify(mockedList).add("mock");
        System.out.println("Анотації для моку успешно використано");
    }
}
