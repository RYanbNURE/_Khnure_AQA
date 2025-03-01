package com.epam.interact;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class T12Actions {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.findElement(By.cssSelector("[name='q']")).click();

        new Actions(driver)
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .perform();

        new Actions(driver)
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("b")
                .build()
                .perform();

        new Actions(driver)
                .sendKeys("abc")
                .perform();

//        Keys cmdCtrl = platformName.is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;
//
//        WebElement textField = driver.findElement(By.id("textInput"));
//        new Actions(driver)
//                .sendKeys(textField, "Selenium!")
//                .sendKeys(Keys.ARROW_LEFT)
//                .keyDown(Keys.SHIFT)
//                .sendKeys(Keys.ARROW_UP)
//                .keyUp(Keys.SHIFT)
//                .keyDown(cmdCtrl)
//                .sendKeys("xvv")
//                .keyUp(cmdCtrl)
//                .perform();
    }
}
