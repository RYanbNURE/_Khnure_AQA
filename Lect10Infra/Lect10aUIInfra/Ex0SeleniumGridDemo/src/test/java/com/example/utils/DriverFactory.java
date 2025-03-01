package com.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    public static WebDriver createDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }
}