package org.khnure.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public static WebDriver createDriver() {
        // Використовується WebDriverManager для автоматичного завантаження WebDriver
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
