package Pages;

import mySeleniumFramework.self_selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPage {
    private final self_selenium mySel;
    private final By editContactButton = By.cssSelector("button#edit-contact");

    public ContactDetailsPage(WebDriver browser) {
        mySel = new self_selenium(browser);
    }

    public void clickEditContactButton() {
        mySel.click(editContactButton);
    }


}
