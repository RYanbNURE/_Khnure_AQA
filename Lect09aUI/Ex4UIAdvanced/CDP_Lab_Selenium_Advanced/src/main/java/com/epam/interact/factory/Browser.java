package com.epam.interact.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum Browser implements IBrowser {

    CHROME {
        @Override
        public WebDriver getDriver() {
            System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
            return new ChromeDriver();
        }
    },

    CHROME_MOBILE {
        @Override
        public WebDriver getDriver() {
            System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
            //logic of mobile settings
            return new ChromeDriver();
        }
    },

    FIREFOX {
        @Override
        public WebDriver getDriver() {
            System.setProperty("webdriver.gecko.driver", "/Users/Ravil_Yanbekov/Documents/geckodriver");
            return new FirefoxDriver();
        }
    },

    SAFARI {
        @Override
        public WebDriver getDriver() {
            return null;
        }
    },

    IE {
        @Override
        public WebDriver getDriver() {
            System.setProperty("webdriver.ie.driver", "/Users/Ravil_Yanbekov/Documents/iedriver");
            return new InternetExplorerDriver();
        }
    };


}
