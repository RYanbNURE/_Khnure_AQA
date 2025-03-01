package com.epam.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

public class GoogleResultsPage extends BasePage {


    public GoogleResultsPage (WebDriver driver) {
        super(driver);
    }

    public void assertSearchResults (String searchResults) {
        List<WebElement> searchResultLinks = driver.findElements(By.xpath("//div/a/h3[contains(@class, 'LC20lb')]"));
        for (WebElement result: searchResultLinks) {
            String searchResultPageLinkText = result.getText();
            if (!searchResultPageLinkText.isEmpty()) {
                Assertions.assertTrue(searchResultPageLinkText.toLowerCase(Locale.ROOT).contains(searchResults));
            }
        }
    }

    public String getTitle () {
        return driver.getTitle();
    }
}
