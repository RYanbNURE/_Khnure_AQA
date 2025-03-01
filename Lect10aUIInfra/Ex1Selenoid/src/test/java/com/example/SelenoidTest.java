package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SelenoidTest {
    private static final Logger logger = LoggerFactory.getLogger(SelenoidTest.class);
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        logger.info("Setting up WebDriver");
        try {
            driver = SelenoidDemo.getDriver();
            logger.info("WebDriver set up successfully");
        } catch (Exception e) {
            logger.error("Failed to set up WebDriver", e);
            throw e;
        }
    }

    @Test
    public void testGoogleSearch() {
        logger.info("Starting Google search test");
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenoid");
        searchBox.submit();

        WebElement firstResult = driver.findElement(By.cssSelector("h3"));
        assertEquals(firstResult.getText(), "Selenoid - A cross browser Selenium solution for Docker", "The first result should be about Selenoid");
        logger.info("Google search test completed successfully");
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Tearing down WebDriver");
        if (driver != null) {
            driver.quit();
        }
    }
}