package org.khnure;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Ex2ParameterizedTest {

    @Test(dataProvider = "inputNumbers")
    public void testSquareRoot(int number, int expected) {
        // Перевірка, що обчислення квадратного кореня відповідає очікуваному
        Assert.assertEquals(Math.sqrt(number), expected, "Корінь квадратний має бути правильним.");
    }

    @DataProvider(name = "inputNumbers")
    public Object[][] provideNumbers() {
        // Параметри для тестування: число та його квадратний корінь
        return new Object[][] {
                { 4, 2 },
                { 9, 3 },
                { 16, 4 },
                { 25, 5 }
        };
    }
}
