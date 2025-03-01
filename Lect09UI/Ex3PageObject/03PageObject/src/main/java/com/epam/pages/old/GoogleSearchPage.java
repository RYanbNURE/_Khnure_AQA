package com.epam.pages.old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

    private WebDriver driver;
    private WebElement searchBox;
    private WebElement searchButton;
//    private WebElement checkBox;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        this.searchBox = driver.findElement(By.name("q"));
        // Depending on the browser and settings, the search button may not always be necessary
        // this.searchButton = driver.findElement(By.name("btnK"));
    }

    public void enterSearchTerm(String searchTerm) {
        searchBox.sendKeys(searchTerm);
    }

    public GoogleSearchResultsPage triggerSearch() {
//        checkBox = driver.findElement(By.name("checkbox"));
//        checkBox.click();
        searchButton.click();
//        searchBox.submit(); // Alternatively, you could use searchButton.click() if necessary
        return new GoogleSearchResultsPage(driver);
    }
}
