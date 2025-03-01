package com.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class DriverFactory {
    public static WebDriver createDriver() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("browserName", "chrome");
        options.setCapability("browserVersion", "latest");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVNC", true);
            put("enableVideo", false);
        }});
        String username = "test";
        String password = "password";
//        String urlWithAuth = String.format("http://localhost:4445/wd/hub", username, password);
        String urlWithAuth = String.format("http://%s:%s@localhost:4445/wd/hub", username, password);

        return new RemoteWebDriver(new URL(urlWithAuth), options);
    }
}