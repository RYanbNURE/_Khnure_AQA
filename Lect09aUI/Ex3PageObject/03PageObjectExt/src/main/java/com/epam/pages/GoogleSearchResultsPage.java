package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

public class GoogleSearchResultsPage extends BasePage {
    @FindBy(xpath = "//div[@id='search']//div[@class='g']")
    private List<HtmlElement> searchResults;

    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getResultsCount() {
        return searchResults.size();
    }

    public String getResultText(int index) {
        return searchResults.get(index).getText();
    }
}
