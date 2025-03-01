package org.example;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SimpleAxeTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testAccessibility() {
        driver.get("https://www.example.com");

        AxeBuilder axeBuilder = new AxeBuilder();
        Results results = axeBuilder.analyze(driver);

        List<Rule> violations = results.getViolations();

        if (violations.isEmpty()) {
            System.out.println("No accessibility violations found.");
        } else {
            System.out.println("Found " + violations.size() + " accessibility violations:");
            for (Rule violation : violations) {
                System.out.println("Description: " + violation.getDescription());
                System.out.println("Impact: " + violation.getImpact());
                System.out.println("Help: " + violation.getHelp());
                System.out.println("Help URL: " + violation.getHelpUrl());
                System.out.println("-----");
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}