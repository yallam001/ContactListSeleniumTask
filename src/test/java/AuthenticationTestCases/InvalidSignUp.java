package AuthenticationTestCases;

import Pages.HomePage;
import Pages.SignUpPage;
import mySeleniumFramework.self_selenium;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;

public class InvalidSignUp {
    private WebDriver browser;
    private HomePage h;
    private SignUpPage s;
    private self_selenium mySel;

    @BeforeClass
    @DataProvider(name = "signUpUserData")
    public Object[] setUpClass() throws FileNotFoundException {
        user[] users = SignUpUtil.ReadUsers("SignUpData.json");
        return users;
    }

//    @BeforeClass
//    @DataProvider(name = "addContactData")
//    public Object[] beforeClass() throws FileNotFoundException {
//        user[] users = SignUpUtil.ReadUsers("SignUpCredentials.json");
//        return users;
//    }

    @AfterClass
    public void afterClass() {

    }

    @BeforeMethod
    public void setUp() {
        browser = new ChromeDriver();
        h = new HomePage(browser);
        s = new SignUpPage(browser);
        mySel = new self_selenium(browser);

    }

    @AfterMethod
    public void tearDown() {
        browser.quit();
    }

    @Test(dataProvider = "signUpUserData")
    public void SignUpTest(@NonNull user userData) {
        String actualURL = h.initializeBrowser();
        Assert.assertEquals(actualURL, "https://thinking-tester-contact-list.herokuapp.com/");
        h.clickSignUpButton();
        String actualSignUpTitle = s.GetSignUpPageTitle();
        Assert.assertEquals(actualSignUpTitle, "Add User");
        s.EnterSignUpDetails(userData.firstName, userData.lastName, userData.email, userData.password);
        s.ClickSubmitButton();
        if (!(s.VerifySwitchContactListPage())) {
            browser.quit();
        }
    }
}
