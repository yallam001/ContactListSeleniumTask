package Pages;

import mySeleniumFramework.self_selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddContactPage {
    private final self_selenium mySel;
    protected final By contactListTitleText = By.cssSelector("header > h1");
    protected final By addContactTitleText = By.cssSelector("header > h1");
    protected final By contactFirstNameField = By.cssSelector("input#firstName");
    protected final By contactLastNameField = By.cssSelector("input#lastName");
    protected final By contactBirthDateField = By.cssSelector("input#birthdate");
    protected final By contactEmailField = By.cssSelector("input#email");
    protected final By contactPhoneField = By.cssSelector("input#phone");
    protected final By contactStreetAddress1Field = By.cssSelector("input#street1");
    protected final By contactStreetAddress2Field = By.cssSelector("input#street2");
    protected final By contactCityField = By.cssSelector("input#city");
    protected final By contactStateField = By.cssSelector("input#stateProvince");
    protected final By contactPostalCodeField = By.cssSelector("input#postalCode");
    protected final By contactCountryField = By.cssSelector("input#country");
    private final By submitButton = By.cssSelector("button#submit");

    public AddContactPage(WebDriver browser) {
        mySel = new self_selenium(browser);
    }

    public String GetTitleText() {
        return mySel.getText(addContactTitleText);
    }

    public void AddContactDetails(String firstName,
                                  String lastName,
                                  String birthDate,
                                  String email,
                                  String phone,
                                  String streetAddress1,
                                  String streetAddress2,
                                  String city,
                                  String state,
                                  String postalCode,
                                  String country) {
        mySel.sendKeys(firstName, contactFirstNameField);
        mySel.sendKeys(lastName, contactLastNameField);
        mySel.sendKeys(birthDate, contactBirthDateField);
        mySel.sendKeys(email, contactEmailField);
        mySel.sendKeys(phone, contactPhoneField);
        mySel.sendKeys(streetAddress1, contactStreetAddress1Field);
        mySel.sendKeys(streetAddress2, contactStreetAddress2Field);
        mySel.sendKeys(city, contactCityField);
        mySel.sendKeys(state, contactStateField);
        mySel.sendKeys(postalCode, contactPostalCodeField);
        mySel.sendKeys(country, contactCountryField);
        mySel.click(submitButton);
        mySel.explicitWait(contactListTitleText);
    }

}
