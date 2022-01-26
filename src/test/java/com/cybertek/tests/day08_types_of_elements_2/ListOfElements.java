package com.cybertek.tests.day08_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.bouncycastle.jcajce.provider.symmetric.RC2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // save your web elements inside the list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("buttons.size() = " + buttons.size());
        // verify button size
        Assert.assertEquals(buttons.size(),6,"verify button size");

        // iter + Enter --> to get each loop with shortcut
        for (WebElement button : buttons) {
            System.out.println(button.getText());
        }

        for (WebElement button : buttons) {
            System.out.println("button.isDisplayed() = " + button.isDisplayed());
            Assert.assertTrue(button.isDisplayed(), "buttons are displayed");
        }
        // click second button
        buttons.get(1).click();
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // regular findElement method will throw NoSuchElement if locator does not exist
        //driver.findElement(By.tagName("buttonnnnnas"));

        // passing locator which does not exist, it will not throw NoSuchElement
        List<WebElement> buttons = driver.findElements(By.tagName("buttonasdasd"));

        System.out.println("buttons.size() = " + buttons.size());


    }
}
