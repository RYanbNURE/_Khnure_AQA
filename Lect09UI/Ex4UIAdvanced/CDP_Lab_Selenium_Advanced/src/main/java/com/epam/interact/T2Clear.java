package com.epam.interact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class T2Clear {
    public static void main(String[] args) throws InterruptedException {

        try {
            // Navigate to Urldriver.get("https://www.google.com");
            // Store 'SearchInput' element
            WebElement searchInput = driver.findElement(By.name("q"));
            //InputElement searchInput = driver.findElement(By.name("q"));
            //Button searchButton = driver.findElement(By.name("q"));
            searchInput.sendKeys("selenium");
            // Clears the entered text
            searchInput.clear();
        } finally {
//            driver.quit();
        }
    }
}
