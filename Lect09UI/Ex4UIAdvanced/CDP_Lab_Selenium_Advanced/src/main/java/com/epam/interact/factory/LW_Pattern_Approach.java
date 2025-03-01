package com.epam.interact.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;

public class LW_Pattern_Approach {

    public static final Map<String, WebDriver> webDriverMap;

    static {
        webDriverMap = new HashMap<>();
        webDriverMap.put("chrome", Browser.CHROME.getDriver());
        webDriverMap.put("firefox", Browser.FIREFOX.getDriver());
        webDriverMap.put("ie", Browser.IE.getDriver());
    }
}
