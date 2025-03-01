package com.epam.custom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class ExamplePage {
    @Button
    private WebElement someButton;

    public ExamplePage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(new DefaultElementLocatorFactory(driver)), this);
    }

    public void clickButton() {
        someButton.click();
    }
}
