package com.cybertek.tests.reviews.week05;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScrollDownHW {
    /*
    HW: This is from a real interview task:
    v.Test application www.IonicPartners.com:
    vi. Test 1: Go to <Blog> page and scroll it down
    vii. Test 2: Go to <About> page, scroll it down and click on Twitter icon at the bottom of the page
    */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.ionicpartners.com/");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void blogPage() throws InterruptedException {
        WebElement blogBtn = driver.findElement(By.id("slider-11-slide-47-layer-30"));
        blogBtn.click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scroll(0,document.body.scrollHeight)");

        Thread.sleep(2000);

        jse.executeScript("window.scroll(0,-document.body.scrollHeight)");

        Thread.sleep(2000);

        WebElement aboutUsPage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[1]/div/div/div[2]/ul/li[2]/a"));
        aboutUsPage.click();

        jse.executeScript("window.scroll(0,-document.body.scrollHeight)");

        Thread.sleep(2000);

        WebElement twitterIcon = driver.findElement(By.xpath("//*[@class='icons-work']/a[1]"));
        twitterIcon.click();

        String titleOfTwitterPage = driver.getCurrentUrl();
        System.out.println("titleOfTwitterPage = " + titleOfTwitterPage);
        Assert.assertTrue(titleOfTwitterPage.contains("IonicPartners"),"Verify that twitter page is displayed");
    }
}
