package com.epam.pages.newpf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class GoogleSearchPage extends BasePage {
    private WebDriver driver;

    // Using @FindBy annotation to locate the Google search box element
    @FindBy(name = "q")
    private WebElement searchBox;

    // Constructor to initialize the Page Factory elements and pass the driver
    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    // Method to perform a search
    public GoogleSearchResultsPage search(String keyword) {
        WebElement element = driver.findElement(By.id("test"));

        element.click();


        new WebDriverWait(driver, Duration.ofDays(1))
//                .pollingEvery(Duration.of(1,
                .until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBox.sendKeys(keyword);
        searchBox.submit();
        return new GoogleSearchResultsPage(driver);
    }
}
