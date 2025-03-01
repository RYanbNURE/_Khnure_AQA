package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchPage {

    private WebDriver driver;
    private By searchBox = By.name("q");
    private By searchButton = By.name("btnK");

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://www.google.com");
    }

    public void searchFor(String query) {
        WebElement element = driver.findElement(searchBox);
        element.sendKeys(query);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}