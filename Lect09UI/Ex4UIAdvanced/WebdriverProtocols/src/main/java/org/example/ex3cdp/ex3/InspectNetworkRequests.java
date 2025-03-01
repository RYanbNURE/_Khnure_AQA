package org.example.ex3cdp.ex3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.idealized.Network;

public class InspectNetworkRequests {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "<path_to_chrome_driver>");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("goog:chromeOptions", options);

        WebDriver driver = new ChromeDriver(options);
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        driver.get("https://www.example.com");
    }
}
