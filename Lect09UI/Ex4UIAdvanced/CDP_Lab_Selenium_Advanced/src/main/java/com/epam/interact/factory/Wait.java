package com.epam.interact.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

    public static void waitForVisibilityLocated(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }
}
