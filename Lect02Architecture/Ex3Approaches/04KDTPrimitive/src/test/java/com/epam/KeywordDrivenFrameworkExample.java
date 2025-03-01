package com.epam;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

public class KeywordDrivenFrameworkExample {
    WebDriver driver;

    @Test
    public void runKeywordDrivenTest() throws Exception {
        FileInputStream file = new FileInputStream("./TestInstructions.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            String action = row.getCell(0).getStringCellValue();
            String elementLocator = row.getCell(1).getStringCellValue();
            String value = row.getCell(2).getStringCellValue();

            performAction(action, elementLocator, value);
        }

        workbook.close();
        driver.quit();
    }

    private void performAction(String action, String elementLocator, String value) throws Exception {
        switch (action) {
            case "OpenBrowser":
                System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Navigate":
                driver.get(value);
                break;
            case "Type":
                driver.findElement(By.id(elementLocator)).sendKeys(value);
                break;
            case "Click":
                driver.findElement(By.id(elementLocator)).click();
                break;
            case "Submit":
                driver.findElement(By.id(elementLocator)).submit();
                break;
            case "Wait":
                TimeUnit.SECONDS.sleep(Long.parseLong(value));
                break;
            default:
                throw new Exception("Invalid action " + action);
        }
    }
}
