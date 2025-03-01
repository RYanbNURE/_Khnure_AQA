package com.epam.interact;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T9TextContent {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

// Retrieves the text of the element
        String text = driver.findElement(By.cssSelector("h1")).getText();
        System.out.println(text);

//        driver.quit();
    }
}
