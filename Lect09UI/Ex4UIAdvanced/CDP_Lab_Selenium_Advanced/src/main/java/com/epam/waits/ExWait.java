package com.epam.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ExWait {

    public static void main(String[] args) {

            System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
            WebDriver driver = new ChromeDriver();

// launching gmail.com on the browser
            driver.get("https://gmail.com");
// maximized the browser window
            driver.manage().window().maximize();
            WebElement element = driver.findElement(By.id("Email"));
// entering username
            element.sendKeys("dummy@gmail.com");
            element.sendKeys(Keys.RETURN);
// entering password
            driver.findElement(By.id("Passwd")).sendKeys("password");
// clicking signin button
            driver.findElement(By.id("signIn")).click();
// explicit wait - to wait for the compose button to be click-able
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(3000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
// click on the compose button as soon as the "compose" button is visible
            driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();


        //Declare and initialise a fluent wait
        FluentWait waitF = new FluentWait(driver);
//Specify the timout of the wait
        waitF.withTimeout(Duration.ofMillis(5000));
//Specify polling time
        waitF.pollingEvery(Duration.ofMillis(250));
//Specify what exceptions to ignore
        wait.ignoring(NoSuchElementException.class);

//This is how we specify the condition to wait on.
        wait.until(ExpectedConditions.alertIsPresent());

// closes all the browser windows opened by web driver
            driver.quit();


        }
}
