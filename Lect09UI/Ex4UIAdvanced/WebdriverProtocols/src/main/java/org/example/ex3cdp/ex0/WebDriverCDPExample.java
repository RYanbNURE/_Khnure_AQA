package org.example.ex3cdp.ex0;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.network.model.ResponseReceived;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.RequestWillBeSent;

public class WebDriverCDPExample {
    public static void main(String[] args) {
        // Set GeckoDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Tutorial\\AQA\\Frontend\\WebdriverProtocols\\src\\main\\resources\\drivers\\chrome\\chromedriver.exe");

        // Setup Firefox WebDriver
        ChromeOptions options = new ChromeOptions();
//        options.setCapability("webSocketUrl", true);  // Ensure WebDriver BiDi is enabled

        WebDriver driver = new ChromeDriver(options);

        // Obtain DevTools interface
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();

        // Enable network events
        devTools.send(Network.enable(java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));

        // Add listener for network request events
        devTools.addListener(Network.requestWillBeSent(), (RequestWillBeSent request) -> {
            System.out.println("Request URL: " + request.getRequest().getUrl());
            System.out.println("Request Method: " + request.getRequest().getMethod());
            System.out.println("Request Headers: " + request.getRequest().getHeaders());
        });

//         Add a listener for Network response events
//        devTools.addListener(Network.responseReceived(), (ResponseReceived response) -> {
//            System.out.println("Response URL: " + response.getResponse().getUrl());
//            System.out.println("Response Status: " + response.getResponse().getStatus());
//            System.out.println("Response Headers: " + response.getResponse().getHeaders());
//        });

        // Enable logging
        devTools.send(Log.enable());

        // Add listener for console logs
        devTools.addListener(Log.entryAdded(), logEntry -> {
            System.out.println("Log: " + logEntry.getText());
        });

        // Navigate to a website
        driver.get("https://example.com");

        // Perform other actions
        // ...

        // Cleanup
        driver.quit();
    }
}