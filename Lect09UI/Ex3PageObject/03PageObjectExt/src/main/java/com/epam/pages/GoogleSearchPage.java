package com.epam.pages;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class GoogleSearchPage {
    private SearchBarComponent searchBar;

    public GoogleSearchPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public void performSearch(String query) {
        searchBar.search(query);
    }

    public SearchBarComponent getSearchBar() {
        return searchBar;
    }
}
