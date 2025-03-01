package org.khnure.ex1simple;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    @Test
    public void testCalculate() {
        Factorial factorial = new Factorial();
        assertEquals(1, factorial.calculate(0), "Factorial of 0 should be 1");
        assertEquals(1, factorial.calculate(1), "Factorial of 1 should be 1");
        assertEquals(2, factorial.calculate(2), "Factorial of 2 should be 2");
        assertEquals(6, factorial.calculate(3), "Factorial of 3 should be 6");
        assertEquals(24, factorial.calculate(4), "Factorial of 4 should be 24");
        assertEquals(120, factorial.calculate(5), "Factorial of 5 should be 120");
    }

    @Test
    public void testCalculateNegative() {
        Factorial factorial = new Factorial();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            factorial.calculate(-1);
        });
        assertEquals("Number must be non-negative", exception.getMessage());
    }
}