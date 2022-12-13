package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement selectName;

    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']")
    WebElement currency;

   @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processBtn;

    public void selectName(String name) {
        Reporter.log("Select " +name+ "From name dropdown list"+selectName.toString());
        selectByVisibleTextFromDropDown(selectName, name);
        CustomListeners.test.log(Status.PASS, "select Name from drop list : " + name);

    }
    public void selectCurrency(String curr) {
        Reporter.log("Select " +curr+ "From currency dropdown list"+currency.toString());
        selectByVisibleTextFromDropDown(currency, curr);
        CustomListeners.test.log(Status.PASS, "Select Currency from drop list : " + curr);

    }
    public void clickOnProcessBtn() {
        Reporter.log("Click on Process Button"+processBtn.toString() );
        clickOnElement(processBtn);
        CustomListeners.test.log(Status.PASS, "Click on Process Button");

    }

    public String getTextFromAlert() {
        String text = driver.switchTo().alert().getText();
        Reporter.log("Get Text from ALert is : "+text );
        CustomListeners.test.log(Status.PASS, "Get text from Alert is : " +text);
        return text;
    }

    public void clickOnOkBtn() {
        Reporter.log("Click on Ok Button");
        acceptAlert();

    }


}
