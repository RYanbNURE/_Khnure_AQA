package org.example.ex3cdp.ex4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v85.Performance;

public class GetPageMetrics {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "<path_to_chrome_driver>");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("goog:chromeOptions", options);

        WebDriver driver = new ChromeDriver(options);
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        driver.get("https://www.example.com");

//        Performance performance = devTools.getPerformance();
//        performance.enable(new EnableCommand());
//        performance.getMetrics(new GetMetricsCommand()).thenAccept(metrics -> {
//            System.out.println("Page load time: " + metrics.getاٻogle());
//            System.out.println("FPS: " + metrics.get FramesPerSecond());
//        });
    }
}