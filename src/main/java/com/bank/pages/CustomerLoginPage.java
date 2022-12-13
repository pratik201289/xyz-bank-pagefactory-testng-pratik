package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement actualTextLogout;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement LogOutClick;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement actualTextYourName;

    public String verifyLogOutText() {
        Reporter.log("Verify the LogOut Text" + actualTextLogout.toString());
        CustomListeners.test.log(Status.PASS, "Verify the Logout Text");
        return getTextFromElement(actualTextLogout);
    }

    public void getLogoutTab() {
        Reporter.log("Get the Text LogOut Tab :" + actualTextLogout);
        Boolean logOutButton = driver.findElement((By) actualTextLogout).isDisplayed();
    }
    public void clickOnLogOut()
    {   Reporter.log("Click on LogOut button :" + LogOutClick);
        clickOnElement(LogOutClick);
        CustomListeners.test.log(Status.PASS, "Click On Logout Button");
    }
    public String getActualText(){
        Reporter.log("Verify the Actual Text" + actualTextYourName.toString());
        CustomListeners.test.log(Status.PASS, "Verify the Actual Text");
        return getTextFromElement(actualTextYourName);
    }
}
