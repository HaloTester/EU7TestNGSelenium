package com.cybertek.tests.day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class NewCheckBoxHW {

    @Test
    public void test1(){

        // open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // (1) Go to
        // http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        // (2) login with --> username:Tester; password:test
        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        usernameInput.sendKeys("Tester");

        WebElement passwordInput = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordInput.sendKeys("test");

        WebElement loginBtn = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginBtn.click();

        // (3) click on check all button
        WebElement checkAll = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        checkAll.click();

        WebElement controlCheck = driver.findElement(By.xpath("//input[starts-with(@id,'ctl00_MainContent_orderGrid_')]"));

        // verify all the checkboxes are checked
        String temp = controlCheck.getAttribute("id");
        for(int i=102; i<=109; i++){
            if(temp.contains(Integer.toString(i))){
                Assert.assertTrue(controlCheck.isSelected());
            }
        }

        // (4) click on uncheck all button
        WebElement unCheckAll = driver.findElement(By.id("ctl00_MainContent_btnUncheckAll"));
        unCheckAll.click();

        // verify all the checkboxes are unchecked
        for(int i=102; i<=109; i++){
            if(temp.contains(Integer.toString(i))){
                Assert.assertFalse(controlCheck.isSelected());
            }
        }

        // create List of checkBox before deleting selected item
        List<WebElement> checkBoxBefore = driver.findElements(By.xpath("//*[@type='checkbox']"));

        // (5) Select one of the checkbox and delete one person
        WebElement selectOne = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl07_OrderSelector"));
        selectOne.click();

        WebElement deleteSelected = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteSelected.click();

        // create List of checkBox after deleting selected item
        List<WebElement> checkBoxAfter = driver.findElements(By.xpath("//*[@type='checkbox']"));

        // (6) verify that deleted item is no longer exists
        Assert.assertNotEquals(checkBoxBefore, checkBoxAfter, "verify that deleted item is no longer exists");

        // close browser
        driver.quit();
    }
}
