package com.example.utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static final String MOON_URL = "http://localhost:4444/wd/hub";

    public static WebDriver createDriver(String browser) throws MalformedURLException {
        Capabilities capabilities;
        switch (browser.toLowerCase()) {
            case "firefox":
                capabilities = new FirefoxOptions();
                break;
            case "chrome":
            default:
                capabilities = new ChromeOptions();
        }

        Map<String, Object> moonOptions = new HashMap<>();
        moonOptions.put("enableVNC", true);
        moonOptions.put("name", "Test on " + browser);

        ((ChromeOptions) capabilities).setCapability("moon:options", moonOptions);

        return new RemoteWebDriver(new URL(MOON_URL), capabilities);
    }
}