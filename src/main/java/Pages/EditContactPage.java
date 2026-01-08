package Pages;

import mySeleniumFramework.self_selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditContactPage extends AddContactPage {
    private final self_selenium mySel;
    private final By editContactTitleText = By.cssSelector("header > h1");
    private final By[] editedContactDetailsList = {
            By.cssSelector("form#contactDetails > p:nth-of-type(1) > span"),
            By.cssSelector("form#contactDetails > p:nth-of-type(2) > span"),
            By.cssSelector("form#contactDetails > p:nth-of-type(3) > span"),
            By.cssSelector("form#contactDetails > p:nth-of-type(4) > span"),
            By.cssSelector("form#contactDetails > p:nth-of-type(5) > span"),
            By.cssSelector("form#contactDetails > p:nth-of-type(6) > span"),
            By.cssSelector("form#contactDetails > p:nth-of-type(7) > span"),
            By.cssSelector("form#contactDetails > p:nth-of-type(8) > span"),
            By.cssSelector("form#contactDetails > p:nth-of-type(9) > span"),
            By.cssSelector("form#contactDetails > p:nth-of-type(10) > span"),
            By.cssSelector("form#contactDetails > p:nth-of-type(11) > span"),
    };

    public EditContactPage(WebDriver browser) {
        super(browser);
        mySel = new self_selenium(browser);
    }

    public String GetTitleText() {
        return mySel.getText(editContactTitleText);
    }

    @Override
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
        mySel.clearText(contactFirstNameField);
        mySel.clearText(contactLastNameField);
        mySel.clearText(contactBirthDateField);
        mySel.clearText(contactEmailField);
        mySel.clearText(contactPhoneField);
        mySel.clearText(contactStreetAddress1Field);
        mySel.clearText(contactStreetAddress2Field);
        mySel.clearText(contactCityField);
        mySel.clearText(contactStateField);
        mySel.clearText(contactPostalCodeField);
        mySel.clearText(contactCountryField);
        super.AddContactDetails(firstName,
                lastName,
                birthDate,
                email,
                phone,
                streetAddress1,
                streetAddress2,
                city,
                state,
                postalCode,
                country);
    }


}
