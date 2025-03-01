package org.example.ex3cdp.ex2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v85.Page;
//import org.openqa.selenium.devtools.v85.Screencast;

public class TakeScreenshot {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "<path_to_chrome_driver>");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("goog:chromeOptions", options);

        WebDriver driver = new ChromeDriver(options);
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        driver.get("https://www.example.com");

//        Page page = devTools.getPage();
//        Screencast screencast = page.startScreencast();
//        byte[] screenshot = screencast.getFrame();
//        // save the screenshot to a file
//        Files.write(screenshot, new File("screenshot.png"));
    }
}
