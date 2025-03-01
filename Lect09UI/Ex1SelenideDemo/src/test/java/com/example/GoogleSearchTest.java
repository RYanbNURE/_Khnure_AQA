package com.example;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1280x800";
        Configuration.headless = false; // Запуск в headless режиме
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 20000;
        Configuration.reportsFolder = "test-result/reports";
        Configuration.savePageSource = false;
    }

    @Test
    public void searchForSelenide() {
        // Открываем Google
        open("https://www.google.com");

        // Принимаем cookies, если появится такое окно
        if ($("button[id='L2AGLb']").is(Condition.visible)) {
            $("button[id='L2AGLb']").click();
        }

        // Вводим "Selenide" в поле поиска
        $("[name='q']").setValue("Selenide").pressEnter();

        // Проверяем, что результаты поиска содержат ссылку на сайт Selenide
        $$("div.g").shouldHave(CollectionCondition.sizeGreaterThan(0));
        $("div.g").shouldHave(Condition.text("selenide.org"));
    }
}