package com.cybertek.tests.day14_extentreports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){
        // name of the test
        extentLogger = report.createTest("Wrong password test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username: user1");
        loginPage.usernameInput.sendKeys("user1");

        extentLogger.info("Enter password: somepassword");
        loginPage.passwordInput.sendKeys("somepassword");

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify Page Url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Password Test is passed");
    }

    @Test
    public void wrongUsernameTest() {
        //name of the test
        extentLogger = report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username: someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("Enter password: UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify Page Url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Username Test is passed");
    }

}
