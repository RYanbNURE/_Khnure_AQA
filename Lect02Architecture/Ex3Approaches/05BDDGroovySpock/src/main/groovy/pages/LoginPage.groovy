package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class LoginPage {
    private final WebDriver driver
    private final By usernameSelector = By.id("username")
    private final By passwordSelector = By.id("password")
    private final By loginButtonSelector = By.id("loginButton")

    LoginPage(WebDriver driver) {
        this.driver = driver
    }

    void enterUsername(String username) {
        driver.findElement(usernameSelector).sendKeys(username)
    }

    void enterPassword(String password) {
        driver.findElement(passwordSelector).sendKeys(password)
    }

    void clickLogin() {
        driver.findElement(loginButtonSelector).click()
    }
}