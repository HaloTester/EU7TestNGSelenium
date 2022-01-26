package com.cybertek.tests.day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id("username"));

        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());

        // TASK
        // (1) verify username inputBox is not displayed on the screen
        Assert.assertFalse(usernameInput.isDisplayed(), "verify username inputBox is not displayed");

        // (2) click start button
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        // wait until elements are displayed
        Thread.sleep(6000);

        // (3) verify username inputBox is displayed on the screen
        Assert.assertTrue(usernameInput.isDisplayed(),"verify username inputBox is displayed");

        driver.quit();
    }
}
