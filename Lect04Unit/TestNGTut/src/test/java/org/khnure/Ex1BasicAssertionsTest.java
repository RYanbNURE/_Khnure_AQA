package org.khnure;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex1BasicAssertionsTest {

    @Test
    public void testEquality() {
        // Перевірка рівності двох значень
        Assert.assertEquals(5, 5, "Числа мають бути рівними.");
    }

    @Test
    public void testTrueCondition() {
        // Перевірка істинності умови
        Assert.assertTrue(3 < 5, "Умова має бути істинною.");
    }
}