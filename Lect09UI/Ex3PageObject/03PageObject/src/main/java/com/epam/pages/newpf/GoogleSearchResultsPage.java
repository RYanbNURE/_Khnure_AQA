package com.epam.pages.newpf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class GoogleSearchResultsPage extends BasePage {
    private WebDriver driver;

    // List of Web Elements to store the search results
    @FindBy(xpath = "//div[@id='search']//div[@class='g']")
    private List<WebElement> searchResults;

    // Constructor to initialize the Page Factory elements and pass the driver
    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    // Method to get the number of search results
    public int getResultsCount() {
        return searchResults.size();
    }

    // Method to get a specific search result text by index
    public String getResultText(int index) {
        if(index >= 0 && index < searchResults.size()) {
            return searchResults.get(index).getText();
        } else {
            return "";
        }
    }
}
