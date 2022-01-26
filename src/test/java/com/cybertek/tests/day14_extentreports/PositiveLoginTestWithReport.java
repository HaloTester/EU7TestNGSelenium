package com.cybertek.tests.day14_extentreports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTestWithReport extends TestBase {

    @Test
    public void loginAsDriver() {
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Login as Driver");

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        extentLogger.info("Enter username: " + username);
        loginPage.usernameInput.sendKeys(username);
        extentLogger.info("Enter password: " + password);
        loginPage.passwordInput.sendKeys(password);
        extentLogger.info("Click login button");
        loginPage.loginBtn.click();
        extentLogger.info("Verify Page Url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
        extentLogger.pass("Login as Driver Test is passed");
    }

    @Test
    public void loginAsStoreManagerTest() {
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Login as Store Manager");
        extentLogger.info("Enter valid credentials");
        loginPage.loginAsStoreManager();
        extentLogger.info("Verify Page Url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
        extentLogger.pass("Login as Store Manager Test is passed");
    }

    @Test
    public void loginAsSalesManagerTest(){
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Login as Sales Manager");
        extentLogger.info("Enter valid credentials");
        loginPage.loginAsSalesManager();
        extentLogger.info("Verify Page Url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
        extentLogger.pass("Login as Sales Manager Test is passed");
    }

    @Test
    public void loginAsDriverTest(){
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Login as Driver");
        extentLogger.info("Enter valid credentials");
        loginPage.loginAsDriver();
        extentLogger.info("Verify Page Url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
        extentLogger.pass("Login as Driver Test is passed");
    }
}
