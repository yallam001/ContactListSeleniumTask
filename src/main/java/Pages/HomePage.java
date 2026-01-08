package Pages;

import mySeleniumFramework.self_selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final self_selenium mySel;

    private final By homePage_Title = By.cssSelector("body > h1");
    private final By signUpButton = By.cssSelector("div.main-content > button#signup");

    public HomePage(WebDriver browser) {
        this.mySel = new self_selenium(browser);
    }

    public String initializeBrowser() {
        mySel.initializeBrowser("https://thinking-tester-contact-list.herokuapp.com/");
        mySel.explicitWait(homePage_Title);
        return mySel.getCurrentURL();
    }

    public void clickSignUpButton() {
        mySel.click(signUpButton);
    }
}
