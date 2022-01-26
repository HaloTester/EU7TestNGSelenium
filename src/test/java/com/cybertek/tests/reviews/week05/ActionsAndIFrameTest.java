package com.cybertek.tests.reviews.week05;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsAndIFrameTest {
    /*
    1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    2. Switch to iframe.
    3. Double click on the text “Double-click me to change my text color.”
    4. Assert: Text’s “style” attribute value contains “red”.
    */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test(){
        WebElement acceptCookies = driver.findElement(By.id("accept-choices"));
        acceptCookies.click();

        // Switch to IFrame
        driver.switchTo().frame("iframeResult");

        WebElement textToDoubleClick = driver.findElement(By.id("demo"));

        //For double click need to implement Action class
        Actions actions = new Actions(driver);
        actions.doubleClick(textToDoubleClick).perform();

        String expectedInStyle = "red";
        String actualInStyle = textToDoubleClick.getAttribute("style");

        Assert.assertTrue(actualInStyle.contains(expectedInStyle),"Verify that style color is changed to RED after double clicking ");
    }
}
