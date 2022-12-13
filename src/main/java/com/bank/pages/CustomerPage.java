package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage extends Utility {


   @CacheLookup
   @FindBy(xpath = "//select[@id='userSelect']")
    WebElement selectName;

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement selectNameDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement clickLogin;

    public void selectNameFromDropDown(String name) {
        Reporter.log("Select " +name+ "From DropDown List" + selectNameDropDown.toString());
        selectByVisibleTextFromDropDown(selectName, name);
        CustomListeners.test.log(Status.PASS, "select Name from drop list : " + name);

    }

    public void clickOnLoginBtn() {
        Reporter.log("Click on Login Button " + clickLogin);
        clickOnElement(clickLogin);
        CustomListeners.test.log(Status.PASS, "Click On Login Button");
    }


}
