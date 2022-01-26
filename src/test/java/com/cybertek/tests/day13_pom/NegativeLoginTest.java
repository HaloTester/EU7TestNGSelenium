package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){

        /*driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");
        driver.findElement(By.id("_submit")).click();*/

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginBtn.click();

        String expectedUrl = "https://qa1.vytrack.com/user/login";
        String message = "Verify that user is login page after invalid credential";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, message);
    }

    @Test
    public void wrongUsernameTest() {
        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();

        String expectedUrl = "https://qa1.vytrack.com/user/login";
        String message = "Verify that user is login page after invalid credential";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,message);
    }

}
