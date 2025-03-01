package com.epam.capabilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        normal	complete	Used by default, waits for all resources to download
//        eager	interactive	DOM access is ready, but other resources like images may still be loading
//        none	Any	Does not block WebDriver at all
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);



        System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
//        WebDriver driver = new ChromeDriver(chromeOptions);
        URL localhost = new URL("https://localhost:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(localhost, firefoxOptions);


        try {
// Navigate to Url
            driver.get("https://google.com");
        } finally {
            driver.quit();
        }
    }
}
