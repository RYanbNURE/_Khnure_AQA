package com.epam;

import com.epam.pages.newpf.GoogleSearchPage;
import com.epam.pages.newpf.GoogleSearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/mac/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");

            GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
            GoogleSearchResultsPage resultsPage = googleSearchPage.search("PageObject with Selenium");

            System.out.println("Number of results: " + resultsPage.getResultsCount());
            System.out.println("First result: " + resultsPage.getResultText(0));

        } finally {
            driver.quit();
        }
    }
}