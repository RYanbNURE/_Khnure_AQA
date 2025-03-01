package com.epam.interact;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T7SizeAndPosition {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
        // Navigate to url
        driver.get("https://www.example.com");

// Returns height, width, x and y coordinates referenced element
        Rectangle res =  driver.findElement(By.cssSelector("h1")).getRect();

// Rectangle class provides getX,getY, getWidth, getHeight methods
        System.out.println(res.getX());
        System.out.println(res.getY());
        System.out.println(res.getWidth());
        System.out.println(res.getHeight());


//        driver.quit();
    }
}
