package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.khnure.base.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // Відкриття сторінки входу
        loginPage.open();

        // Введення імені користувача та пароля
        loginPage.enterUsername("testuser");
        loginPage.enterPassword("password123");

        // Натискання кнопки входу
        loginPage.clickLoginButton();

        // Перевірка, що користувач успішно увійшов (в цьому випадку перевірка URL)
        assertEquals("https://example.com/dashboard", driver.getCurrentUrl());
    }
}
