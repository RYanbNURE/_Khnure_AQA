package org.khnure.ex5powermock;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class StaticMethodTest {

//    @Test
    public void testStaticMethod() {
        try (MockedStatic<Math> mockedMath = mockStatic(Math.class)) {
            mockedMath.when(() -> Math.abs(-10)).thenReturn(10);
            assertEquals(10, Math.abs(-10));
        }
    }
}
