package com.cybertek.tests.day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        // locating radio button
        WebElement blueRadioBtn = driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioBtn = driver.findElement(By.id("red"));

        // how to check radio button is selected
        System.out.println("blueRadioBtn.isSelected() = " + blueRadioBtn.isSelected());
        System.out.println("redRadioBtn.isSelected() = " + redRadioBtn.isSelected());

        // verify blue is selected red is not selected
        Assert.assertTrue(blueRadioBtn.isSelected(), "Verify that blueRadioBtn is selected");
        Assert.assertFalse(redRadioBtn.isSelected(), "Verify that redRadioBtn is not selected");

        // how to click radio button
        redRadioBtn.click();

        // verify blue is not selected red is selected
        Assert.assertFalse(blueRadioBtn.isSelected(), "Verify that blueRadioBtn is not selected");
        Assert.assertTrue(redRadioBtn.isSelected(), "Verify that redRadioBtn is selected");

        Thread.sleep(3000);

        driver.quit();

    }
}
