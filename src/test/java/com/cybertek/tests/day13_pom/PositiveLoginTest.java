package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver() {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }

    @Test
    public void loginAsStoreManagerTest() {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        /*loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();*/
        // create a new method that pass two parameter, then put actions inside the method
        loginPage.login(username,password);
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }

    @Test
    public void loginAsStoreManager2Test() {
        LoginPage loginPage = new LoginPage();
        // create a new method then put actions inside the method
        loginPage.loginAsStoreManager();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }

    @Test
    public void loginAsSalesManagerTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }

    @Test
    public void loginAsDriverTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }
}
