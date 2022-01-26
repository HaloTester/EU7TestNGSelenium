package com.cybertek.tests.day09_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() { // HTML POP UPS
        driver.get("https://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        // click the Confirm button
        driver.findElement(By.xpath("//span[.='Confirm']")).click();

        // click No button
        driver.findElement(By.xpath("//span[.='No']")).click();
    }

    @Test
    public void test2() throws InterruptedException { // JAVASCRIPT POP UPS
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        // click Click For JS Alert button
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();

        // switch to JS alert pop up with Alert class
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        // click Click For JS Confirm button then click Cancel button
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        alert.dismiss();

        // click Click For JS Prompt button then sendKeys after click accept button
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        // send keys to JS Prompt
        alert.sendKeys("Baba");
        Thread.sleep(4000);
        alert.accept();
    }
}
