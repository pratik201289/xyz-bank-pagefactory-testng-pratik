package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement clickLoginHomePageBtn;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLogin;

      public void clickOnHomePageBtn() {
          Reporter.log("Click on Login Home Page Button: " + clickLoginHomePageBtn.toString());
        clickOnElement(clickLoginHomePageBtn);
          CustomListeners.test.log(Status.PASS, "Click On Login Homepage Button");
      }

    public void clickOnCustomerLogin() {

        Reporter.log("Click on Customer Login Button: " + customerLogin.toString());
       // driver.navigate().refresh();
        clickOnElement(customerLogin);
        CustomListeners.test.log(Status.PASS, "Click On Customer Login Button");
    }

}
