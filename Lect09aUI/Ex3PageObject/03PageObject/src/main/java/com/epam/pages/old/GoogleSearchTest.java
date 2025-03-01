package com.epam.pages.old;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        try {
            GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
            googleSearchPage.enterSearchTerm("example search");

            GoogleSearchResultsPage resultsPage = googleSearchPage.triggerSearch();


            System.out.println("Number of results: " + resultsPage.getNumberOfResults());
            if (resultsPage.getNumberOfResults() > 0) {
                System.out.println("First result: " + resultsPage.getResultText(0));
            }

        } finally {
            driver.quit();
        }
    }
}
