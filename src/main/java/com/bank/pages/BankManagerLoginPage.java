package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement clickBankManagerLoginBtn;


    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[2]")
    WebElement clickOnOpenAccount;

    public void clickOnBankMangerBtn(){
        //driver.navigate().to("https://www.way2automation.com/angularjs-protractor/banking/#/login");
        Reporter.log("Click on Bank Manager Button" + clickBankManagerLoginBtn.toString());
        clickOnElement(clickBankManagerLoginBtn);
        CustomListeners.test.log(Status.PASS, "Click on Bank Manager Button");

    }
    public void clickOnOpenAccountBtn(){
        Reporter.log("Click on Open Account Button" + clickOnOpenAccount.toString());
        clickOnElement(clickOnOpenAccount);
        CustomListeners.test.log(Status.PASS, "Click on OPen Account Button");

    }


}
