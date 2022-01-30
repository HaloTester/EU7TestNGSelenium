package com.cybertek.tests.reviews.week07;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DataProviderExample {
    /*
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. And click on “Status Codes”.
    Step 3. Then click on “200”.
    Step 4. Verify that following message is displayed:
    “This page returned a 200 status code”
    */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @DataProvider
    public Object[][] dataTest(){
        String[][] data = {
                {"200","This page returned a 200 status code."},
                {"301","This page returned a 301 status code."},
                {"404","This page returned a 404 status code."},
                {"500","This page returned a 500 status code."}
        };
        return data;
    }

    @Test(dataProvider = "dataTest")
    public void test(String statusCode, String expectedMessage){
        driver.findElement(By.linkText(statusCode)).click();
        String actualMessage = driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}
