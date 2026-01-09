package Pages;


import mySeleniumFramework.self_selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactListPage {
    private final self_selenium mySel;
    private final By contactListTitleText = By.cssSelector("header > h1");
    private final By addNewContactButton = By.cssSelector("button#add-contact");
    private final By errorContactFieldText = By.cssSelector("span#error");
    private final By[] contactTableData = {By.cssSelector("tr.contactTableBodyRow > td:nth-of-type(2)"), //firstName, lastName
            By.cssSelector("tr.contactTableBodyRow > td:nth-of-type(3)"), //birthdate
            By.cssSelector("tr.contactTableBodyRow > td:nth-of-type(4)"), //email
            By.cssSelector("tr.contactTableBodyRow > td:nth-of-type(5)"), //phone
            By.cssSelector("tr.contactTableBodyRow > td:nth-of-type(6)"), //address 1,2
            By.cssSelector("tr.contactTableBodyRow > td:nth-of-type(7)"), //city,state,postal code
            By.cssSelector("tr.contactTableBodyRow > td:nth-of-type(8)") //country
    };
    private final By selectContactButton = By.cssSelector("tr.contactTableBodyRow");

    public ContactListPage(WebDriver browser) {
        mySel = new self_selenium(browser);
    }

    public String GetTitleText() {
        return mySel.getText(contactListTitleText);
    }

    public void ClickAddNewContactButton() {
        mySel.click(addNewContactButton);
    }


    public String[] FetchContactData() {
        String[] data = new String[contactTableData.length];
        for (int i = 0; i < contactTableData.length; i++) {
            data[i] = mySel.getText(contactTableData[i]); // your wrapper
        }
        return data;
    }

    public boolean ErrorFieldContactText() {
        mySel.explicitWait(errorContactFieldText);
        return mySel.getText(errorContactFieldText).contains("Contact validation failed");
    }

    public void SelectContact() {
        mySel.click(selectContactButton);
    }

}
