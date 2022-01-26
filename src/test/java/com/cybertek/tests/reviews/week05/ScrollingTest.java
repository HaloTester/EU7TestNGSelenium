package com.cybertek.tests.reviews.week05;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScrollingTest {

   /*
    P.I.Q.: How many ways do you know to scroll using Selenium?
    1.  action.moveToElement().perform()
    2.  PageUp, PageDown keys for scrolling
          action.sendKeys(Keys.PAGE_UP, PAGE_DOWN)
    3.  jse.executeScript("window.scrollBy(0,250)");
    4.  jse.executeScript("arguments[0].scrollIntoView(true)",cybertekSchoolLink);
    */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void moveToElementTest() throws InterruptedException{
        //Scroll down to "Powered by Cybertek"
        Actions actions = new Actions(driver);
        //Locate the element
        WebElement ctekLink = driver.findElement(By.linkText("Cybertek School"));

        Thread.sleep(3000); // checked exception
        //Scroll down to element
        actions.moveToElement(ctekLink).perform();
    }

    @Test
    public void moveDownUp(){
        //Advanced keyboard actions
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        try{
            Thread.sleep(2000);
        }catch (Exception e){

        }

        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    @Test
    public void jsScrollDownUp() throws InterruptedException{

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        Thread.sleep(1000);
        //Scroll down all page
        jse.executeScript("window.scroll(0,document.body.scrollHeight)");

        Thread.sleep(1000);
        //Scroll up all page
        jse.executeScript("window.scroll(0,-document.body.scrollHeight)");

        Thread.sleep(1000);
        //Scroll down in a certain way
        jse.executeScript("window.scrollBy(0,500)");

        Thread.sleep(1000);
        //Scroll up in a certain way
        jse.executeScript("window.scrollBy(0,-500)");
    }

    @Test
    public void jsMoveToLocatedElement() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Locate the element
        WebElement ctekLink = driver.findElement(By.linkText("Cybertek School"));

        Thread.sleep(2000);
        //Move to located web element
        jse.executeScript("arguments[0].scrollIntoView(true)",ctekLink);
    }

}
