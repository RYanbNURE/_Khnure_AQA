package org.khnure.asyncExamples;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

/**
 * Клас для асинхронних операцій з Playwright.
 */
public class AsyncOperations {

    public void runWithScreenshot(String url) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate(url);

            // Створення скріншоту сторінки
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
            System.out.println("Screenshot saved: screenshot.png");
        }
    }
}
