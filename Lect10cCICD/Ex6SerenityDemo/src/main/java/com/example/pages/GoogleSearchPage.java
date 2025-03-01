package com.example.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class GoogleSearchPage extends PageObject {

    @FindBy(name = "q")
    private WebElementFacade searchBox;

    @FindBy(name = "btnK")
    private WebElementFacade searchButton;

    public void enterSearchTerm(String term) {
        searchBox.type(term);
    }

    public void clickSearch() {
        searchButton.click();
    }
}