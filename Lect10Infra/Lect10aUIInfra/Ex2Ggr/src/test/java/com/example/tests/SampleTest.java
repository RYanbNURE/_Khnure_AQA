package com.example.tests;

import com.example.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SampleTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.createDriver();
    }

    @Test
    public void testGoogleTitle() {
        driver.get("https://www.google.com");
        assertTrue(driver.getTitle().contains("Google"), "Title should contain 'Google'");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}