package com.epam;

import static org.junit.jupiter.api.Assertions.*;

import com.epam.pages.newpf.GoogleSearchPage;
import com.epam.pages.newpf.GoogleSearchResultsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchTest {

    private WebDriver driver;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/mac/chromedriver");
        driver = new ChromeDriver();
    }

    @DisplayName("Perform a Google Search and verify results")
    @Test
    void testGoogleSearch() {
        // Step 1 Login to app - 3 pages to go through
        // Choose a ticket
        // Go to payment page


        driver.get("https://www.google.com");
        GoogleSearchPage googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);
        GoogleSearchResultsPage resultsPage = googleSearchPage.search("PageFactory and Selenium");

        assertNotEquals(0, resultsPage.getResultsCount(), "Results should not be zero.");
        assertTrue(resultsPage.getResultText(0).contains("Selenium"), "First result should contain 'Selenium'");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
