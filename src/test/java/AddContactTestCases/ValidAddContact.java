package AddContactTestCases;

import AuthenticationTestCases.SignUpUtil;
import AuthenticationTestCases.user;
import Pages.AddContactPage;
import Pages.ContactListPage;
import Pages.HomePage;
import Pages.SignUpPage;
import mySeleniumFramework.self_selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;

public class ValidAddContact {
    private WebDriver browser;
    private HomePage homePage;
    private SignUpPage signUpPage;
    private ContactListPage contactList;
    private AddContactPage addContactPage;
    private self_selenium mySel;

    @BeforeMethod
    public void setUp() {
        browser = new ChromeDriver();
        homePage = new HomePage(browser);
        signUpPage = new SignUpPage(browser);
        contactList = new ContactListPage(browser);
        addContactPage = new AddContactPage(browser);
    }

    @AfterMethod
    public void tearDown() {
        browser.quit();
    }

    @BeforeClass
    @DataProvider(name = "AddContactData")
    public Object[][] setUpClass() throws FileNotFoundException {
        user[] users = SignUpUtil.ReadUsers("SignUpData.json");
        Contact[] contacts = AddContactUtil.ReadUsers("AddContact.json");
        // If you want to map them one-to-one (user[i] with formData[i]):
        int size = Math.min(users.length, contacts.length);
        Object[][] data = new Object[size][2];
        for (int i = 0; i < size; i++) {
            data[i][0] = users[i];
            data[i][1] = contacts[i];
        }

        return data;
    }

    @AfterClass
    public void afterClass() {

    }

    @Test(dataProvider = "AddContactData")
    public void testValidAddContact(user userData, Contact contactData) {
        Assert.assertEquals(homePage.initializeBrowser(), "https://thinking-tester-contact-list.herokuapp.com/");
        homePage.clickSignUpButton();
        Assert.assertEquals(signUpPage.GetSignUpPageTitle(), "Add User");
        signUpPage.EnterSignUpDetails(userData.firstName, userData.lastName, userData.email, userData.password);
        signUpPage.ClickSubmitButton();
        Assert.assertEquals(contactList.GetTitleText(), "Contact List");
        contactList.ClickAddNewContactButton();
        Assert.assertEquals(addContactPage.GetTitleText(), "Add Contact");
        addContactPage.AddContactDetails(contactData.firstName,
                contactData.lastName,
                contactData.birthDate,
                contactData.email,
                contactData.phone,
                contactData.streetAddress1,
                contactData.streetAddress2,
                contactData.city,
                contactData.state,
                contactData.postalCode,
                contactData.country);
        String[] actual = contactList.FetchContactData();
        Assert.assertTrue(actual[0].contains(contactData.firstName), "First name mismatch");
        Assert.assertTrue(actual[0].contains(contactData.lastName), "Last name mismatch");
        Assert.assertTrue(actual[1].contains(contactData.birthDate), "Birthdate mismatch");
        Assert.assertTrue(actual[2].contains(contactData.email), "Email mismatch");
        Assert.assertTrue(actual[3].contains(contactData.phone), "Phone mismatch");
        Assert.assertTrue(actual[4].contains(contactData.streetAddress1), "Address1 mismatch");
        Assert.assertTrue(actual[4].contains(contactData.streetAddress2), "Address2 mismatch");
        Assert.assertTrue(actual[5].contains(contactData.city), "city mismatch");
        Assert.assertTrue(actual[5].contains(contactData.state), "state mismatch");
        Assert.assertTrue(actual[5].contains(contactData.postalCode), "Postal Code mismatch");
        Assert.assertTrue(actual[6].contains(contactData.country), "country mismatch");

    }
}
