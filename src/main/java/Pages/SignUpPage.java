package Pages;

import mySeleniumFramework.self_selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private final self_selenium mySel;
    private final By signUpPageTitle = By.cssSelector("div.main-content > h1");
    private final By failedSubmissionText = By.cssSelector("span#error");
    private final By firstNameField = By.cssSelector("input#firstName");
    private final By lastNameField = By.cssSelector("input#lastName");
    private final By emailField = By.cssSelector("input#email");
    private final By passwordField = By.cssSelector("input#password");
    private final By errorEmailAlreadyInUse = By.cssSelector("span#error");
    private final By submitButton = By.cssSelector("button#submit");


    public SignUpPage(WebDriver browser) {
        this.mySel = new self_selenium(browser);
    }

    public String GetSignUpPageTitle() {
        return mySel.getText(signUpPageTitle);
    }

    public void EnterSignUpDetails(String firstName, String lastName, String email, String password) {
        mySel.sendKeys(firstName, firstNameField);
        mySel.sendKeys(lastName, lastNameField);
        mySel.sendKeys(email, emailField);
        mySel.sendKeys(password, passwordField);
    }

    public void ClickSubmitButton() {
        mySel.click(submitButton);
    }

    public boolean VerifySwitchContactListPage() {
        return mySel.getPageTitle().contains("Contact List");
    }
}
