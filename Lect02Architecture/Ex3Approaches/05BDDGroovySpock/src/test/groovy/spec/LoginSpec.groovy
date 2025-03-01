package spec

import pages.LoginPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import spock.lang.Specification

class LoginSpec extends Specification {
    WebDriver driver = new ChromeDriver()
    LoginPage loginPage = new LoginPage(driver)

    def "Login with valid credentials"() {
        setup:
        driver.get("http://example.com/login")

        when:
        loginPage.enterUsername("user")
        loginPage.enterPassword("pass")
        loginPage.clickLogin()

        then:
        // Here you would typically check for an element specific to the dashboard page as indicative of successful login.
        driver.currentUrl.contains("dashboard")

        cleanup:
        driver.close()
    }
}