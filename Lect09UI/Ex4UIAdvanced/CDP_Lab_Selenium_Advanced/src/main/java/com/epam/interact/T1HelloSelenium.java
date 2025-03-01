package com.epam.interact;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class T1HelloSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/Ravil_Yanbekov/Documents/chromedriver");
    WebDriver driver = new ChromeDriver();
    try {
        // Navigate to Url
        driver.get("https://google.com");
        WebElement search = driver.findElement(By.name("q"));
        System.out.println(search.getTagName());
//        Select select = new Select(searchBar);







//        WebElement searchButton = driver.findElement(By.name("btnK"));
//        List<WebElement> btnKList = driver.findElements(By.cssSelector("[name='btnK']:first-of-type"));
//        System.out.println(btnKList.size());
//        for (WebElement elem : btnKList) {
//            System.out.println(elem.isDisplayed());
////            elem.click();
//        }
//        WebElement searchButton = btnKList.get(1);
//        searchButton.click();
//        System.out.println(searchButton.isDisplayed());
        // Enter text "q" and perform keyboard action "Enter"
//        WebElement googleSearchBar = driver.findElement(By.name("q"));
//        WebElement googleSearchBar = driver.findElement(By.cssSelector("[name='q']"));
//        WebElement googleSearchBar = driver.findElement(By.xpath("//*[@name='q']"));
//        WebElement elemGoogleOffers = driver.findElement(By.linkText("Google offered in:  "));
//        googleSearchBar.click();
//        googleSearchBar.sendKeys("q" + Keys.ENTER);
    } finally {
//        driver.quit();
    }
}
}
