package com.epam.scenarios;

import com.epam.pages.GoogleResultsPage;
import com.epam.pages.GoogleSearchPage;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchingBarTest extends BaseTest {

    private static GoogleSearchPage googleSearchPage;
    private static GoogleResultsPage googleResultsPage;

    @BeforeEach
    public void navigateToResource() {
        googleSearchPage = new GoogleSearchPage(getDriver());
        googleResultsPage = new GoogleResultsPage(getDriver());
        googleSearchPage.navigateTo(googleSearchPage.PAGE_URL);
        assertTrue(googleSearchPage.getTitle().contains("Google"));
    }

//    @Test
//    public void test () {
//        Assertions.assertTrue(true);
//    }

    @Test
    public void testSearchAndPressEnter() {
        googleSearchPage.searchAndPressEnter("Webdriver");
        assertTrue(googleResultsPage.getTitle().contains("webdriver - Google Search"));
    }
//
//    @Test
//    public void testSearchAndPressSearchButton() {
//        googleSearchPage.searchAndPressSearchButton("Webdriver");
//        assertTrue(googleResultsPage.getTitle().contains("webdriver - Google Search"));
//    }
//
//    @Test
//    public void testClearButtonOnSearchBar() {
//        googleSearchPage.typeSearchQueryInSearchBar("Webdriver");
//        googleSearchPage.clearSearchBar();
//        assertTrue(googleSearchPage.getTitle().contains("Google"));
//    }
}
