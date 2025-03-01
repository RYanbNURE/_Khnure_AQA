package org.khnure.ex2mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Mock
    private MathService mathService;

    @InjectMocks
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculateSquare() {
        // Установка поведения mock-объекта
        when(mathService.multiply(2, 2)).thenReturn(4);

        // Проверка метода calculateSquare
        int result = calculator.calculateSquare(2);
        assertEquals(4, result);

        // Проверка вызова метода multiply на mock-объекте
        verify(mathService).multiply(2, 2);
    }
}
