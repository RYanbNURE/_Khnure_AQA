package com.epam.pages;


import org.openqa.selenium.WebDriver;

public class GoogleGmailPage extends BasePage{

    public static final String PAGE_URL = "https://mail.google.com/mail/u/0/?pli=1";

    public GoogleGmailPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle () {
        return driver.getTitle();
    }
}
