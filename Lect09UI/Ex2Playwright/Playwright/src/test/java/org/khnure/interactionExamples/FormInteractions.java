package org.khnure.interactionExamples;

import com.microsoft.playwright.*;

/**
 * Клас для демонстрації інтеракцій з формами.
 */
public class FormInteractions {

    public void run() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("http://example.com/login");

            // Введення тексту в поле вводу
            page.fill("input#username", "user");
            page.fill("input#password", "password");

            // Натискання кнопки для входу
            page.click("button#login");

            // Перевірка URL після входу
            System.out.println("Page URL: " + page.url());
        }
    }
}
