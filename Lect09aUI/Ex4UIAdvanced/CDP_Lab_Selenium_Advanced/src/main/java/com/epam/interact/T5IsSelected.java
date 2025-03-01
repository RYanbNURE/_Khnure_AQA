package com.epam.interact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5IsSelected {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
        // Navigate to the url
        driver.get("https://the-internet.herokuapp.com/checkboxes");

// Get boolean value for is element display
        Thread.sleep(7000);
        WebElement firstCheckBox = driver.findElement(By.cssSelector("input[type='checkbox']:first-of-type"));
        boolean isFirstCheckBoxSelected = firstCheckBox.isSelected();
        WebElement secondCheckBox = driver.findElement(By.cssSelector("input[type='checkbox']:last-of-type"));
        boolean isSecondCheckBoxSelected = secondCheckBox.isSelected();
        System.out.println(isFirstCheckBoxSelected);
        System.out.println(isSecondCheckBoxSelected);
//        driver.quit();
    }
}
