package com.epam;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        String title = driver.getTitle();
        System.out.println(title);
        int iframe = driver.findElements(By.tagName("iframe")).size();
        System.out.println(iframe);
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000)); //outdated
//        100 tests waiting for element NOT present = + 20 sec * 100 tests
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
//        WebElement searchBox = driver.findElement(By.cssSelector("[name='q']"));
//        wait.
//                pollingEvery(Duration.ofMillis(500)).
//                withTimeout(Duration.ofMillis(2000)).
//                ignoring(StaleElementReferenceException.class);
//        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name='a']")));
//        wait.until((ExpectedCondition<Boolean>) webDriver -> {
//            WebElement webElement = webDriver.findElement(By.cssSelector("[name='q']"));
//            return webElement.getAttribute("color").equals("red");
//        });
//        searchBox.sendKeys("Selenium");
//        WebElement select = driver.findElement(By.tagName("select"));
//        Select mySelect = new Select(select);
        //Buttons, Inputs etc. - provided by custom solution
//        mySelect.selectByIndex(1);
//        mySelect.selectByValue("ACCEPTED");
//        mySelect.selectByVisibleText("Visible");
//        WebElement wrappedElement = mySelect.getWrappedElement();
//        wrappedElement.equals(select);//returns true
//        Actions actions = new Actions(driver);
//        actions.
//                keyDown(Keys.CONTROL).
//                click(searchBox).
//                contextClick().
//                keyUp(Keys.CONTROL)
//                .build().perform();
//        ;
//        WebElement searchBox = driver.findElement(By.name("q"));
//        WebElement searchBox = driver.findElement(By.xpath("//*[@name='q']"));
//        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
//        WebElement gmailPartialLink = driver.findElement(By.partialLinkText("Gmail"));
//        WebElement gmailPartialLink = driver.findElement(By.id("uniqueID")); //example
//        WebElement gmailPartialLink = driver.findElement(By.className("uniqueClassName")); //example
//        WebElement byTagName = driver.findElement(By.tagName("div")); //example
//        WebElement searchButton = driver.findElement(By.name("btnK"));
//        searchButton.click();
        driver.quit();
    }
}
