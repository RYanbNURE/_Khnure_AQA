package com.epam.interact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T6TagName {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
        // Navigate to the url
        //navigates to url
        driver.get("https://www.example.com");

        //returns TagName of the element
        WebElement header = driver.findElement(By.cssSelector("h1"));
        String value = header.getTagName();
        System.out.println(value);
        driver.quit();
    }
}
