package com.epam.interact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3IsDisplayed {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
        // Navigate to the url
        driver.get("https://www.google.com");

// Get boolean value for is element display
        WebElement input = driver.findElement(By.cssSelector("[name='q']"));
        boolean isButtonVisible = input.isDisplayed();
        System.out.println(isButtonVisible);
        driver.quit();
    }
}
