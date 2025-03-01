package com.example.tests;

import com.example.config.DriverConfig;
import com.example.pages.GoogleSearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchTest {

    private WebDriver driver;
    private ClientApi zapClient;
    private GoogleSearchPage googleSearchPage;

    @BeforeEach
    public void setup() throws Exception {
        driver = DriverConfig.getDriver();
        zapClient = DriverConfig.getZapClient();
        googleSearchPage = new GoogleSearchPage(driver);
    }

    @Test
    public void testGoogleSearch() throws ClientApiException {
        googleSearchPage.navigateTo();
        googleSearchPage.searchFor("OWASP ZAP");
        assertTrue(googleSearchPage.getTitle().contains("OWASP ZAP"));

        // Generate ZAP security report
        String title = "ZAP Security Test Report";
        String template = "traditional-html";
        String description = "This is a ZAP security test report";
        String reportfilename = "zap-report.html";
        String targetFolder = System.getProperty("user.dir");

        zapClient.reports.generate(title, template, null, description, null, null, null, null, null, reportfilename, null, targetFolder, null);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}