package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchPage extends BasePage{

    public static final String PAGE_URL = "https://google.com";



    //lazy  initialization
    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchBar;

    @FindBy(xpath = "//input[@aria-label='Google Search']")
    private List<WebElement> searchButtons;

    @FindBy(xpath = "//div[@aria-label='Clear']")
    private WebElement clearButton;


    //eager initialization //
//    private WebElement searchBar = driver.findElement(By.xpath("//input[@name='q']"));
//    private List<WebElement> searchButtons = driver.findElements(By.xpath("//input[@aria-label='Google Search']"));
//    private WebElement clearButton = driver.findElement(By.xpath("//div[@aria-label='Clear']"));

    public GoogleSearchPage (WebDriver driver) {
        super(driver);
    }

    public void hoverSearchBar () {
        new Actions(driver).moveToElement(searchBar).build().perform();
    }

    public void clearSearchQueryWithDoubleClick(String query) {
        typeSearchQueryInSearchBar(query);
        new Actions(driver).doubleClick(searchBar).sendKeys(Keys.CLEAR).build().perform();
    }

    public void typeSearchQueryInSearchBar(String query) {
        searchBar.sendKeys(query);
    }

    public void searchAndPressEnter(String searchQuery) {
        typeSearchQueryInSearchBar(searchQuery);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void searchAndPressSearchButton(String searchQuery) {
        typeSearchQueryInSearchBar(searchQuery);
        System.out.println(searchButtons.size());
        for (WebElement button : searchButtons) {
            if (button.isDisplayed()) {
                button.click();
            }
        }
    }

    public void clearSearchBar() {
        clearButton.click();
    }
}
