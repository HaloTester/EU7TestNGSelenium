package com.cybertek.tests.day09_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button[.='Start']")).click();

        WebElement usernameInput = driver.findElement(By.id("username"));

        //How to wait Explicitly?
        //create Explicit wait object
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // with wait object --> use ExpectedConditions --> until element be visible
        wait.until(ExpectedConditions.visibilityOf(usernameInput));

        usernameInput.sendKeys("tomsmith");
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        // click enable
        driver.findElement(By.xpath("//*[.='Enable']")).click();

        // finding input box
        WebElement inputBox = driver.findElement(By.xpath("//*[@id='input-example']//input"));

        // create wait object for Explicitly wait
        WebDriverWait wait = new WebDriverWait(driver,20);
        // with wait object --> use ExpectedConditions --> until element be clickable
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("MikeSmith");
    }
}
