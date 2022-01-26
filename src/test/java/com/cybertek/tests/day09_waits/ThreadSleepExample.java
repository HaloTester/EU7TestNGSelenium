package com.cybertek.tests.day09_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {

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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

        // static wait time
        Thread.sleep(6000);
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        Thread.sleep(1000);
        driver.findElement(By.id("pwd")).sendKeys("SuperSecretPassword");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[.='Submit']")).click();
    }
}
