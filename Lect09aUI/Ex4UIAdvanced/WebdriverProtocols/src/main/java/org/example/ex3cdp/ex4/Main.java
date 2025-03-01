package org.example.ex3cdp.ex4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v131.log.Log;
import org.openqa.selenium.devtools.v131.network.Network;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("w3c", false);

        WebDriver driver = new ChromeDriver(options);
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();

// Enable necessary domains, features
        devTools.send(Log.enable());
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

// Listen to console logs
        devTools.addListener(Log.entryAdded(), entry -> {
            System.out.println("Log: " + entry.getText());
        });

        driver.get("https://example.com");
    }
}
