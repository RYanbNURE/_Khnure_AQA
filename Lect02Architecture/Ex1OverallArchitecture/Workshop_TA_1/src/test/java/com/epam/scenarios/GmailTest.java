package com.epam.scenarios;

import com.epam.pages.GoogleGmailPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


public class GmailTest extends BaseTest {

    private static WebDriver driver;
    private static GoogleGmailPage googleGmailPage;

    @BeforeEach
    public void navigateToResource() {
        googleGmailPage = new GoogleGmailPage(driver);
        googleGmailPage.navigateTo(googleGmailPage.PAGE_URL);
    }

    @Test
    public void testNavigateToGmailPage() {
        Assertions.assertTrue(googleGmailPage.getTitle().contains("Inbox"));
    }


}
