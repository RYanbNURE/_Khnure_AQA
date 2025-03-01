package com.epam.interact.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverFactory {

    public static WebDriver getDriver () {
            System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
            return new ChromeDriver();


//        String browser = null;
//        String screenResolution;
//        String geolocation;
//
//        try (InputStream input = new FileInputStream("src/main/resources/browser.properties")) {
//
//            Properties prop = new Properties();
//
//            // load a properties file
//            prop.load(input);
//
//            // get the property value and print it out
//            browser =  prop.getProperty("browser");
//            screenResolution =  prop.getProperty("screenResolution");
//            geolocation =  prop.getProperty("geolocation");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }


//        if (browser.equals(Browser.CHROME.name()) && System.getenv("resolution").equals(ScreenResolution.MOBILE.name())) {
//            System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
//            return new ChromeDriver();
//        }
//        else if (System.getenv("browser").equals(Browser.FIROFOX.name())){
//            System.setProperty("webdriver.gecko.driver", "/Users/Ravil_Yanbekov/Documents/geckodriver");
//            return new FirefoxDriver();
//        }
//        else if (System.getenv("browser").equals(Browser.IE)) {
//            System.setProperty("webdriver.ie.driver", "/Users/Ravil_Yanbekov/Documents/iedriver");
//            return new InternetExplorerDriver();
//        }
//        throw new IllegalArgumentException("No driver supported");
//        return Browser.valueOf(browser).getDriver();
    }
}
