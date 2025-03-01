package com.epam.waits;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImpWait {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String baseUrl = "http://www.google.com";
        WebElement element = driver.findElement(By.id("lst-ib"));
        element.sendKeys("Selenium WebDriver Interview questions");
        element.sendKeys(Keys.RETURN);
        List<WebElement> list = driver.findElements(By.className("_Rm"));
        System.out.println(list.size());
        driver.quit();
    }
}
