package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {

    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    CustomerPage customerPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customerLoginPage = new CustomerLoginPage();
        customerPage = new CustomerPage();
        accountPage = new AccountPage();
    }

    /* public void storeCookie() {
         Set<Cookie> allCookies = driver.manage().getCookies();

         for (org.openqa.selenium.Cookie cookie : allCookies) {
             driver.manage().addCookie((org.openqa.selenium.Cookie) cookie);
         }

     }*/
    @Test(groups = {"sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {

        bankManagerLoginPage.clickOnBankMangerBtn();
        //Thread.sleep(2000);
        addCustomerPage.clickOnAddCustomerBtn();
        addCustomerPage.enterFirstName("Pratik");
        addCustomerPage.enterLastName("Vyas");
        addCustomerPage.enterPostCode("CR76JG");
        addCustomerPage.clickOnAddCustomerButton();
        Assert.assertTrue(addCustomerPage.getTextFromAlertAddCustomer().contains("Customer added successfully"), "Customer added successfully");
        addCustomerPage.clickOkButton();
        // storeCookie();

    }

    @Test(groups = {"smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {

        //storeCookie();
        bankManagerShouldAddCustomerSuccessfully();
        Thread.sleep(2000);
        homePage.clickOnHomePageBtn();
        bankManagerLoginPage.clickOnBankMangerBtn();
        bankManagerLoginPage.clickOnOpenAccountBtn();
        openAccountPage.selectName("Pratik Vyas");
        openAccountPage.selectCurrency("Pound");
        openAccountPage.clickOnProcessBtn();
        Assert.assertTrue(openAccountPage.getTextFromAlert().contains("Account created successfully"), "Account created successfully");
        openAccountPage.clickOnOkBtn();

    }

    @Test(groups = "regression")
    public void customerShouldLoginAndLogoutSuceessfully() {
        bankManagerShouldAddCustomerSuccessfully();
        homePage.clickOnHomePageBtn();
        homePage.clickOnCustomerLogin();
        customerPage.selectNameFromDropDown("Pratik Vyas");
        customerPage.clickOnLoginBtn();
        System.out.println(customerLoginPage.verifyLogOutText());
        customerLoginPage.clickOnLogOut();
        Assert.assertEquals(customerLoginPage.getActualText(), "Your Name :", "Not displayed");
    }

    @Test(groups = "regression")
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        bankManagerShouldAddCustomerSuccessfully();
        homePage.clickOnHomePageBtn();
        homePage.clickOnCustomerLogin();
        customerPage.selectNameFromDropDown("Harry Potter");
        Thread.sleep(2000);
        customerPage.clickOnLoginBtn();
        Thread.sleep(4000);
        accountPage.clickOnDepositTab();
        accountPage.enterDepositAmount("100");
        accountPage.clickOnDepositButton();
        Assert.assertEquals(accountPage.getTextDeposit(), "Deposit Successful", "Not displayed");
        //customerLoginPage.clickOnLogOut();
    }

    @Test(groups = "regression")
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        customerShouldDepositMoneySuccessfully();
        Thread.sleep(2000);
        //  homePage.clickOnHomePageBtn();
        // homePage.clickOnCustomerLogin();
        Thread.sleep(2000);
        accountPage.clickOnWithDrawTab();
        Thread.sleep(1000);
        accountPage.enterWithdrawAmount("50");
        accountPage.clickOnWithDrawButton();
        Thread.sleep(2000);
        Assert.assertEquals(accountPage.getTextWithDraw(), "Transaction successful", "Transaction successful Not displayed");

    }
}