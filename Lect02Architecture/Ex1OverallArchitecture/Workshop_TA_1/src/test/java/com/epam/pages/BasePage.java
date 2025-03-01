package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this.getClass());
    }

    public void navigateTo (String pageURL) {
        this.driver.get(pageURL);
    }

    public String getTitle () {
        return driver.getTitle();
    }
}
