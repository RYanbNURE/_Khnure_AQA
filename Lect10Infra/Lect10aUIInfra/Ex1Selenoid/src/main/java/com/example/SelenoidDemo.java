package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidDemo {
    private static final Logger logger = LoggerFactory.getLogger(SelenoidDemo.class);

    public static WebDriver getDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", "chrome");
//        options.setCapability("browserVersion", "91.0");
//        options.setCapability("enableVNC", true);
//        options.setCapability("enableVideo", false);

        logger.info("Attempting to create RemoteWebDriver with capabilities: {}", options);

        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } catch (Exception e) {
            logger.error("Failed to create RemoteWebDriver", e);
            throw e;
        }
    }
}