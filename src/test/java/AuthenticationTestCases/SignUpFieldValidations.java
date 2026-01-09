package AuthenticationTestCases;

import Pages.HomePage;
import Pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SignUpFieldValidations {
    private HomePage h;
    private SignUpPage su;
    private WebDriver browser;

    @BeforeClass
    public void beforeClass() {

    }

    @AfterClass
    public void afterClass() {

    }

    @BeforeMethod
    public void setUp() {
        browser = new ChromeDriver();
        h = new HomePage(browser);
        su = new SignUpPage(browser);
    }

    @AfterMethod
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void testNoDataEntry() {
        String actualURL = h.initializeBrowser();
        Assert.assertEquals(actualURL, "https://thinking-tester-contact-list.herokuapp.com/");
        h.clickSignUpButton();
        String actualSignUpTitle = su.GetSignUpPageTitle();
        Assert.assertEquals(actualSignUpTitle, "Add User");
        su.ClickSubmitButton();
        Assert.assertTrue(su.VerifyUserValidationText());
    }

    @Test
    public void testFieldInput() {
        String actualURL = h.initializeBrowser();
        Assert.assertEquals(actualURL, "https://thinking-tester-contact-list.herokuapp.com/");
        h.clickSignUpButton();
        String actualSignUpTitle = su.GetSignUpPageTitle();
        Assert.assertEquals(actualSignUpTitle, "Add User");
        su.EnterSignUpDetails("abcd123@#", "abcd123@#", "ashh#", "qwyr");
        su.ClickSubmitButton();
        Assert.assertTrue(su.VerifyIncorrectEmailAndPassword());
    }
}
