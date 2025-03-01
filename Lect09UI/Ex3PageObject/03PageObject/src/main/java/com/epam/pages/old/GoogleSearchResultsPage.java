package com.epam.pages.old;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchResultsPage {
    private WebDriver driver;
    private List<WebElement> searchResults;

    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.searchResults = driver.findElements(By.cssSelector("[data-testid='result']"));
    }

    public int getNumberOfResults() {
        return searchResults.size();
    }

    public String getResultText(int index) {
        if(index >= 0 && index < searchResults.size()) {
            return searchResults.get(index).getText();
        } else {
            return "";
        }
    }
}
