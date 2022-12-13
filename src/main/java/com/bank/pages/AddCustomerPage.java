package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]")
    WebElement clickOnCustomer;
    //By clickOnCustomer = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]");

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")
    WebElement enterFirstName;
    //By enterFirstName = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]");

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/input[1]")
    WebElement enterLastName;
   //By enterLastName = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/input[1]");

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/input[1]")
    WebElement enterPostCode;
   // By enterPostCode = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/input[1]");

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]")
    WebElement clickOnAddCustomer;
    // By clickOnAddCustomer = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]");

    public void clickOnAddCustomerBtn() {
        Reporter.log("Click on Add Customer Button" + clickOnCustomer.toString());
        clickOnElement(clickOnCustomer);
        CustomListeners.test.log(Status.PASS, "Click on Add Customer Button");
    }

    public void enterFirstName(String firstname) {
        Reporter.log("Enter  Deposit" +firstname+ "on Deposit Field" + enterFirstName.toString());
        sendTextToElement(enterFirstName, firstname);
        CustomListeners.test.log(Status.PASS, "Enter First Name " + firstname);

    }
    public void enterLastName(String lastname) {
        Reporter.log("Enter  Deposit" +lastname+ "on Deposit Field" + enterLastName.toString());
        sendTextToElement(enterLastName, lastname);
        CustomListeners.test.log(Status.PASS, "Enter First Name " + lastname);
    }

    public void enterPostCode(String postcode) {
        Reporter.log("Enter  Deposit" +postcode+ "on Deposit Field" + enterPostCode.toString());
        sendTextToElement(enterPostCode, postcode);
        CustomListeners.test.log(Status.PASS, "Enter Post Code " + postcode);
    }

    public void clickOnAddCustomerButton() {
        Reporter.log("Click on Add Customer Button" + clickOnCustomer.toString());
        clickOnElement(clickOnAddCustomer);
        CustomListeners.test.log(Status.PASS, "Click on Add Customer Button");

    }
    public String getTextFromAlertAddCustomer(){
        String text =driver.switchTo().alert().getText();
        Reporter.log("Get Text from Alert " + text);
        CustomListeners.test.log(Status.PASS, "Get Text from Alert " + text);
        return text;
    }
    public void clickOkButton(){
        Reporter.log("Click on Ok button");
        acceptAlert();
    }

}
