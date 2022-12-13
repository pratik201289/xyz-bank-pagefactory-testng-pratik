package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[2]")
    WebElement depositTab;
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement depositAmount;

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement depositBtn;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement actualTextDeposit;
    @CacheLookup
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement withDrawTab;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withDrawAmount;
   // @CacheLookup
   // @FindBy(xpath = "//input[@ng-model='amount']")
   // WebElement amountField;
    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement WithDrawButton;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement VerifyWithDrawText;

    public void clickOnDepositTab(){
        Reporter.log("Click on Deposit Tab" + depositTab.toString());
        clickOnElement(depositTab);
        CustomListeners.test.log(Status.PASS, "Click on Deposit Tab");

    }
    public void enterDepositAmount(String amount){
        Reporter.log("Enter  Deposit" +amount+ "on Deposit Field" + depositAmount.toString());
        sendTextToElement(depositAmount,amount);
        CustomListeners.test.log(Status.PASS, "Enter amount " + amount);

    }
    public void clickOnDepositButton(){
        Reporter.log("Click on Deposit Button" + depositBtn.toString());
        clickOnElement(depositBtn);
        CustomListeners.test.log(Status.PASS, "Click on Deposit Button");

    }
    public String getTextDeposit(){
        Reporter.log("Verify the Text Deposit Successful" + actualTextDeposit.toString());
        CustomListeners.test.log(Status.PASS, "Verify the text Deposit Successful");
        return getTextFromElement(actualTextDeposit);

    }
    public void clickOnWithDrawTab(){
        Reporter.log("Click on Withdraw Tab" + withDrawTab.toString());
        clickOnElement(withDrawTab);
        CustomListeners.test.log(Status.PASS, "Click on Withdraw Tab");
    }
    public void enterWithdrawAmount(String amount){
        Reporter.log("Enter  Withdraw" +amount+ "on Withdraw Field" + withDrawAmount.toString());
        sendTextToElement(withDrawAmount,amount);
        CustomListeners.test.log(Status.PASS, "Enter Withdraw amount  " + amount);

    }
    public void clickOnWithDrawButton(){

        Reporter.log("Click on WithdrawButton" + WithDrawButton.toString());
        clickOnElement(WithDrawButton);
        CustomListeners.test.log(Status.PASS, "Click on WithdrawButton");

    }
    public String getTextWithDraw(){
        Reporter.log("Verify the Text Withdraw Transaction Successful" + VerifyWithDrawText.toString());
        CustomListeners.test.log(Status.PASS, "Verify the text Withdraw Transaction Successful");
        return getTextFromElement(VerifyWithDrawText);
    }

}
