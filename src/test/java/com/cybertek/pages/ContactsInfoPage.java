package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsInfoPage extends BasePage{

    @FindBy(xpath = "//h1[@class='user-name']")
    public WebElement fullName;

    @FindBy(xpath = "//a[@class='email']")
    public WebElement email;

    @FindBy(xpath = "//a[@class='phone']")
    public WebElement phone;

}
