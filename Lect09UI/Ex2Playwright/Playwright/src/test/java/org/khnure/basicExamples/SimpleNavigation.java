package org.khnure.basicExamples;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * Простий клас для навігації у браузері.
 */
public class SimpleNavigation {
    public void run(String url) {
        // Створення інстансу Playwright
        try (Playwright playwright = Playwright.create()) {
            // Створення інстансу Browser
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            // Створення нової сторінки
            Page page = browser.newPage();
            // Переход за URL
            page.navigate(url);
            // Вивід заголовку сторінки
            System.out.println("Page Title: " + page.title());
            // Закриття браузера
        }
    }
}