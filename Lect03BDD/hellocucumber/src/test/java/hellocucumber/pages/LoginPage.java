package hellocucumber.pages;

import hellocucumber.pages.common.Footer;
import hellocucumber.pages.common.Header;

public class LoginPage extends BasePage {

    @FindBy(xpath = '//a')
    private WebElement login;

    public void goToFooterContactUsLink () {
        footer.clickCountactUs();
    }

    public void inputUserName(String test_user) {
    }

    public void inputPassword(String s) {
    }
}
