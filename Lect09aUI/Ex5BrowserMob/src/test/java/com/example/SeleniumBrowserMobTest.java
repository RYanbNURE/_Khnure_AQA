package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumBrowserMobTest {

    private static final Logger logger = LoggerFactory.getLogger(SeleniumBrowserMobTest.class);
    private WebDriver driver;
    private BrowserMobProxy proxy;

    @BeforeEach
    public void setUp() {
        // Налаштування BrowserMob Proxy
        proxy = new BrowserMobProxyServer();
        proxy.start(0);

        // Налаштування Selenium WebDriver
        WebDriverManager.chromedriver().setup();
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        ChromeOptions options = new ChromeOptions();
        options.setProxy(seleniumProxy);
        options.setAcceptInsecureCerts(true);

        driver = new ChromeDriver(options);

        // Налаштування перехоплення HTTP-трафіку
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
    }

    @Test
    public void testWithModifiedHeadersAndSlowNetwork() {
        // Модифікація заголовків
        proxy.addRequestFilter((request, contents, messageInfo) -> {
            request.headers().add("X-Custom-Header", "TestValue");
            return null;
        });

        // Симуляція повільної мережі (3G)
//        proxy.setDownstreamKbps(750, TimeUnit.MILLISECONDS);  // 750 kbps
//        proxy.setUpstreamKbps(250, TimeUnit.MILLISECONDS);    // 250 kbps
        proxy.setLatency(100, TimeUnit.MILLISECONDS);  // 100 ms latency

        proxy.newHar("Slow Network Test");

        driver.get("https://example.com");

        // Тут можна додати більше дій з веб-сторінкою

        Har har = proxy.getHar();
        assertTrue(har.getLog().getEntries().size() > 0, "HAR should contain entries");

        // Аналіз перехопленого трафіку
        har.getLog().getEntries().forEach(entry -> {
            logger.info("URL: " + entry.getRequest().getUrl());
            logger.info("Status: " + entry.getResponse().getStatus());
            logger.info("Load Time: " + entry.getTime() + " ms");
//            logger.info("Custom Header: " + entry.getRequest().getHeaders().getFirstValue("X-Custom-Header"));
        });

        // Збереження HAR файлу
        try {
            har.writeTo(new File("slow_network_test.har"));
        } catch (IOException e) {
            logger.error("Failed to write HAR file", e);
        }
    }

    @Test
    public void testWithModifiedRequestAndDelay() {
        // Модифікація запиту
        proxy.addRequestFilter((request, contents, messageInfo) -> {
            if (request.getUri().contains("example.com")) {
                request.setUri(request.getUri().replace("example.com", "example.org"));
            }
            return null;
        });

        // Додавання затримки для певних запитів
        proxy.addRequestFilter((request, contents, messageInfo) -> {
            if (request.getUri().contains("example.org")) {
                try {
                    TimeUnit.SECONDS.sleep(2);  // Затримка 2 секунди
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        });

        proxy.newHar("Modified Request Test");

        driver.get("https://example.com");

        // Тут можна додати більше дій з веб-сторінкою

        Har har = proxy.getHar();
        assertTrue(har.getLog().getEntries().size() > 0, "HAR should contain entries");

        // Аналіз перехопленого трафіку
        har.getLog().getEntries().forEach(entry -> {
            logger.info("URL: " + entry.getRequest().getUrl());
            logger.info("Status: " + entry.getResponse().getStatus());
            logger.info("Load Time: " + entry.getTime() + " ms");
        });

        // Збереження HAR файлу
        try {
            har.writeTo(new File("modified_request_test.har"));
        } catch (IOException e) {
            logger.error("Failed to write HAR file", e);
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (proxy != null) {
            proxy.stop();
        }
    }
}