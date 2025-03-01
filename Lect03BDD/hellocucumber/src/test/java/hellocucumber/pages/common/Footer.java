package hellocucumber.pages.common;

import hellocucumber.pages.BasePage;

public class Footer extends BasePage {

    @FindBy(xpath = '//a[contains(text(), "Contact Us")]')
    private WebElement contactUsLink;

    public void clickCountactUs() {
        contactUsLink.click();
    }
}
