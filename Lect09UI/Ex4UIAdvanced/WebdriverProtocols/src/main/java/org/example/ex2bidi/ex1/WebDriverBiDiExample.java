package org.example.ex2bidi.ex1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.HasBiDi;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.bidi.BiDi;
import org.openqa.selenium.bidi.log.LogEntry;

public class WebDriverBiDiExample {
    public static void main(String[] args) {
        // Setup WebDriver path
        System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");

        // Setup Firefox options for WebDriver BiDi
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);

        // Get BiDi interface
        BiDi biDi = ((HasBiDi) driver).getBiDi();

        try {
            // Enable log domain
//            biDi.

            // Add listener for console logs
//            biDi.getLog().onLogEntryAdded((LogEntry logEntry) -> {
//                System.out.println("Log: " + logEntry.getText());
//            });
//
//            // Navigate to a website
//            driver.get("https://example.com");
//
//            // Perform actions
//            System.out.println("Page title is: " + driver.getTitle());

        } finally {
            // Cleanup
            driver.quit();
        }
    }
}