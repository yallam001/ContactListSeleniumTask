package Pages;

import mySeleniumFramework.self_selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddContactPage {
    private final self_selenium mySel;
    private final By contactListTitleText = By.cssSelector("header > h1");
    private final By addContactTitleText = By.cssSelector("header > h1");
    private final By contactFirstNameField = By.cssSelector("input#firstName");
    private final By contactLastNameField = By.cssSelector("input#lastName");
    private final By contactBirthDateField = By.cssSelector("input#birthdate");
    private final By contactEmailField = By.cssSelector("input#email");
    private final By contactPhoneField = By.cssSelector("input#phone");
    private final By contactStreetAddress1Field = By.cssSelector("input#street1");
    private final By contactStreetAddress2Field = By.cssSelector("input#street2");
    private final By contactCityField = By.cssSelector("input#city");
    private final By contactStateField = By.cssSelector("input#stateProvince");
    private final By contactPostalCodeField = By.cssSelector("input#postalCode");
    private final By contactCountryField = By.cssSelector("input#country");
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
