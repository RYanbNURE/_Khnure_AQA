package com.epam;

import static org.junit.jupiter.api.Assertions.*;

import com.epam.pages.GoogleSearchPage;
import com.epam.pages.GoogleSearchResultsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @DisplayName("Test Google Search Functionality with Component")
    @Test
    void testGoogleSearchComponent() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.performSearch("Component-based Selenium");

        GoogleSearchResultsPage resultsPage = new GoogleSearchResultsPage(driver);

        assertNotEquals(0, resultsPage.getResultsCount(), "Results should not be zero.");
        assertTrue(resultsPage.getResultText(0).contains("Selenium"), "The first result should contain 'Selenium'.");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
