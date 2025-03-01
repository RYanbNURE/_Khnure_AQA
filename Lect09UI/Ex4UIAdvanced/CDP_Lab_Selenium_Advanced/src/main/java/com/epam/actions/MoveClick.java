package com.epam.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveClick {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.browserstack.com/");
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.linkText("Get started free"));

        action.moveToElement(element).click();
        driver.quit();
    }
}
