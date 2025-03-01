package com.example.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zaproxy.clientapi.core.ClientApi;

import java.net.MalformedURLException;

public class DriverConfig {

    private static final Logger logger = LoggerFactory.getLogger(DriverConfig.class);


    private static final String ZAP_PROXY_ADDRESS = "localhost";
    private static final int ZAP_PROXY_PORT = 8080;
    private static final String ZAP_API_KEY = null; // Change if you set an API key in ZAP

    public static WebDriver getDriver() throws MalformedURLException {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        logger.info("Починаємо демонстрацію Mitmproxy з Selenium");
        WebDriverManager.chromedriver().browserVersion("131").setup();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(ZAP_PROXY_ADDRESS + ":" + ZAP_PROXY_PORT);
        proxy.setSslProxy(ZAP_PROXY_ADDRESS + ":" + ZAP_PROXY_PORT);

        ChromeOptions options = new ChromeOptions();
        options.setProxy(proxy);
        options.setAcceptInsecureCerts(true);

        return new ChromeDriver(options);
    }

    public static ClientApi getZapClient() {
        return new ClientApi(ZAP_PROXY_ADDRESS, ZAP_PROXY_PORT, ZAP_API_KEY);
    }
}