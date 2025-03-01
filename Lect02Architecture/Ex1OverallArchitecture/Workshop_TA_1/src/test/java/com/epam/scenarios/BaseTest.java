package com.epam.scenarios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    private static WebDriver driver;

    @BeforeAll
    public static void driverSetup() {
        System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Downloads/chromedriver105");
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver () {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }


//    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}
