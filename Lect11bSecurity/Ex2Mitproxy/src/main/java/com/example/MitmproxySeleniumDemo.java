package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MitmproxySeleniumDemo {
    private static final Logger logger = LoggerFactory.getLogger(MitmproxySeleniumDemo.class);

    public static void main(String[] args) {
        // Встановлюємо системну властивість для використання нового HTTP клієнта
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        logger.info("Починаємо демонстрацію Mitmproxy з Selenium");

        WebDriverManager.chromedriver().setup();
        logger.info("WebDriverManager налаштовано");

        Proxy mitmproxy = new Proxy();
        mitmproxy.setHttpProxy("localhost:8080");
        mitmproxy.setSslProxy("localhost:8080");
        logger.info("Налаштовано Mitmproxy: {}", mitmproxy.getHttpProxy());

        ChromeOptions options = new ChromeOptions();
        options.setProxy(mitmproxy);
        options.setAcceptInsecureCerts(true);
        logger.info("Налаштовано опції Chrome");

        WebDriver driver = null;
        try {
            driver = new ChromeDriver(options);
            logger.info("Створено WebDriver");

            driver.get("https://example.com");
            logger.info("Відкрито сторінку: {}", driver.getCurrentUrl());

            String pageTitle = driver.getTitle();
            logger.info("Заголовок сторінки: {}", pageTitle);

        } catch (Exception e) {
            logger.error("Виникла помилка: ", e);
        } finally {
            if (driver != null) {
                driver.quit();
                logger.info("Браузер закрито");
            }
        }

        logger.info("Демонстрація завершена");
    }
}