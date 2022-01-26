package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    // driver.findElement(By.Id("prependedInput"));
    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    /* @FindBys
    * if all locators are matching with the web element then it will return it
    * AND logic
    */
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    /*@FindAll
     * if at least one of the locator is matching it will find the web element
     * OR logic
    */
    @FindBy(id = "_submit")
    public WebElement loginBtn;

    public void login(String username,String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsDriver() {
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsStoreManager() {
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsSalesManager() {
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}
