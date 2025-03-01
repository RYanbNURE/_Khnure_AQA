package com.example;

import com.github.kklisura.cdt.launch.ChromeLauncher;
import com.github.kklisura.cdt.protocol.commands.Network;
import com.github.kklisura.cdt.protocol.types.network.Request;
import com.github.kklisura.cdt.protocol.types.network.Response;
import com.github.kklisura.cdt.services.ChromeDevToolsService;
import com.github.kklisura.cdt.services.ChromeService;
import com.github.kklisura.cdt.services.types.ChromeTab;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeleniumWireDemo {
    // Створюємо логер для класу
    private static final Logger logger = LoggerFactory.getLogger(SeleniumWireDemo.class);

    public static void main(String[] args) {
        logger.info("Починаємо демонстрацію Selenium Wire"); // Логуємо початок роботи

        // Налаштовуємо WebDriverManager для Chrome
        WebDriverManager.chromedriver().setup();
        logger.info("WebDriverManager налаштовано"); // Логуємо налаштування WebDriverManager

        // Створюємо ChromeLauncher
        ChromeLauncher launcher = new ChromeLauncher();
        logger.info("ChromeLauncher створено"); // Логуємо створення ChromeLauncher

        // Запускаємо Chrome
        ChromeService chromeService = launcher.launch(false);
        logger.info("Chrome запущено"); // Логуємо запуск Chrome

        // Створюємо нову вкладку
        ChromeTab tab = chromeService.createTab();
        logger.info("Створено нову вкладку Chrome"); // Логуємо створення нової вкладки

        // Створюємо ChromeDevToolsService
        ChromeDevToolsService devToolsService = chromeService.createDevToolsService(tab);
        logger.info("ChromeDevToolsService створено"); // Логуємо створення ChromeDevToolsService

        // Отримуємо доступ до Network команд
        Network network = devToolsService.getNetwork();
        logger.info("Отримано доступ до Network команд"); // Логуємо отримання доступу до Network команд

        // Налаштовуємо перехоплення запитів та відповідей
        network.onRequestWillBeSent(event -> {
            Request request = event.getRequest();
            logger.info("Запит: {} {}", request.getMethod(), request.getUrl()); // Логуємо кожен запит
        });

        network.onResponseReceived(event -> {
            Response response = event.getResponse();
            logger.info("Відповідь: {} {}", response.getStatus(), response.getUrl()); // Логуємо кожну відповідь
        });

        // Вмикаємо Network
        network.enable();
        logger.info("Network увімкнено"); // Логуємо вмикання Network

        // Налаштовуємо опції Chrome
        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("debuggerAddress", "localhost:" + chromeService.getPort());
        logger.info("Налаштовано опції Chrome"); // Логуємо налаштування опцій Chrome

        // Створюємо екземпляр WebDriver
        WebDriver driver = new ChromeDriver(options);
        logger.info("Створено WebDriver"); // Логуємо створення WebDriver

        try {
            // Відкриваємо веб-сторінку
            driver.get("https://example.com");
            logger.info("Відкрито сторінку: {}", driver.getCurrentUrl()); // Логуємо відкриття сторінки

            // Виводимо заголовок сторінки
            String pageTitle = driver.getTitle();
            logger.info("Заголовок сторінки: {}", pageTitle); // Логуємо заголовок сторінки

            // Чекаємо трохи, щоб побачити логи запитів та відповідей
            Thread.sleep(5000);

        } catch (Exception e) {
            logger.error("Виникла помилка: ", e); // Логуємо будь-які помилки
        } finally {
            // Закриваємо браузер та зупиняємо сервіси
            driver.quit();
            devToolsService.close();
            chromeService.closeTab(tab);
            launcher.close();
            logger.info("Браузер та сервіси закрито"); // Логуємо закриття браузера та сервісів
        }

        logger.info("Демонстрація завершена"); // Логуємо завершення роботи
    }
}