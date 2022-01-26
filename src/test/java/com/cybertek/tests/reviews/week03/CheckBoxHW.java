package com.cybertek.tests.reviews.week03;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/*
Test Case Verify CheckBox CheckAll and UncheckAll Buttons
1.    Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
2.    Login with-----Username: Tester, password: test
       // Test Case 1
3.    Click on check all button verify all the checkboxes are checked
4.    Click on uncheck all button verify that all the checkboxes are unchecked
       // Test Case 2
5.    Select one of the checkbox and delete one person
6.    Then verify that deleted item is no longer exists
    What is the precondition for both Test Cases? Login to webPage
    Can I out the same precondition to BeforeMethod? Yes
 */
public class CheckBoxHW {
    protected WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement usernameBox = driver.findElement(By.id("ctl00_MainContent_username"));
        usernameBox.sendKeys("Tester");

        WebElement passwordBox = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordBox.sendKeys("test");

        WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));
        loginBtn.click();
    }

    @Test
    public void checkAllBox(){
        WebElement checkAllBtn = driver.findElement(By.linkText("Check All"));
        checkAllBtn.click();

        for (int i = 1; i <= 8; i++) {
             String rowLocator = "(//input[@type='checkbox'])[" + i + "]";
             WebElement rowCheckBox = driver.findElement(By.xpath(rowLocator));
             Assert.assertTrue(rowCheckBox.isSelected(),"Check box IS NOT selected");
        }

        WebElement uncheckAllBtn = driver.findElement(By.linkText("Uncheck All"));
        uncheckAllBtn.click();

        for (int i = 1; i <= 8; i++) {
            String rowLocator = "(//input[@type='checkbox'])[" + i + "]";
            WebElement rowCheckBox = driver.findElement(By.xpath(rowLocator));
            Assert.assertFalse(rowCheckBox.isSelected(),"Check box IS selected");
        }
    }

    @Test
    public void deletePerson(){
        String name = "Steve Johns";
        String locatorCheckBoxOfPerson = "//*[contains(text(),'" + name + "')]/preceding-sibling::*/input";

        WebElement checkBoxOfPerson = driver.findElement(By.xpath(locatorCheckBoxOfPerson));
        checkBoxOfPerson.click();

        WebElement deleteBtn = driver.findElement(By.name("ctl00$MainContent$btnDelete"));
        deleteBtn.click();

        List<String> nameList = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            String eachNameLocator =  "(//*[@type='checkbox'])[" + i + "]/../../td[2]";
            WebElement eachNameElement = driver.findElement(By.xpath(eachNameLocator));
            String eachName = eachNameElement.getText();
            nameList.add(eachName);
        }

        Assert.assertFalse(nameList.contains(name),"Person is still there, COULD NOT delete");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
