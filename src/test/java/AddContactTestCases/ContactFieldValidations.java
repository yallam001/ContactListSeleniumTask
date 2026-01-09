package AddContactTestCases;

import Pages.AddContactPage;
import Pages.ContactListPage;
import Pages.HomePage;
import Pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;

public class ContactFieldValidations {
    private WebDriver browser;
    private HomePage homePage;
    private AddContactPage addContactPage;
    private SignUpPage signUpPage;
    private ContactListPage contactList;

    @BeforeClass
    @DataProvider(name = "IncorrectContactData")
    public Object[] beforeClass() throws FileNotFoundException {
        return AddContactUtil.ReadUsers("IncorrectContactData.json");
    }

    @AfterClass
    public void afterClass() {

    }

    @BeforeMethod
    public void setUp() {
        browser = new ChromeDriver();
        homePage = new HomePage(browser);
        addContactPage = new AddContactPage(browser);
        signUpPage = new SignUpPage(browser);
        contactList = new ContactListPage(browser);
    }

    @AfterMethod
    public void tearDown() {
        browser.quit();
    }

    @Test(dataProvider = "IncorrectContactData")
    public void testContactFieldValidations(Contact contactData) {
        Assert.assertEquals(homePage.initializeBrowser(), "https://thinking-tester-contact-list.herokuapp.com/");
        homePage.clickSignUpButton();
        Assert.assertEquals(signUpPage.GetSignUpPageTitle(), "Add User");
        signUpPage.EnterSignUpDetails("abcd123@#", "abcde123@#", "abcde123@gmail.com", "dkfhkdfhkdfhkh");
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
        Assert.assertTrue(contactList.ErrorFieldContactText());
    }
}
