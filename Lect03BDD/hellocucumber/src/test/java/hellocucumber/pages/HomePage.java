package hellocucumber.pages;

public class HomePage extends BasePage {

    @FindBy(xpath="...")
    private WebElement loginLink;

    public void clickLoginLink () {
        new WebdriverWait().until(EX.visibi)
        loginLink = driver.findElement(By.xpath("xpath"));
        System.out.println(loginLink.getClass());
        loginLink.click();
    }

    public void visit() {
        driver.get(url)
    }
}
