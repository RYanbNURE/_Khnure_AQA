package com.epam.interact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class T10FindElementsFromElement {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://example.com");

            // Get element with tag name 'div'
            WebElement footer = driver.findElement(By.tagName("footer"));

            // Get all the elements available with tag name 'p'
            List<WebElement> elements = footer.findElements(By.tagName("p"));
            for (WebElement e : elements) {
                System.out.println(e.getText());
            }
        } finally {
            driver.quit();
        }
    }
}

