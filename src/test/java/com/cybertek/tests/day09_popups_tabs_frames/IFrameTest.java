package com.cybertek.tests.day09_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTest {
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
        driver.get("http://practice.cybertekschool.com/iframe");

        // how to switch frames
        // 1. Switch using by name or Id attribute of frame
        driver.switchTo().frame("mce_0_ifr");

        // clean before sendKeys()
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith");

        // goes back to first frame (Main HTML)
        // goes back to first frame, useful when we have switched multiple frames
        driver.switchTo().defaultContent();

        // 2. Switch using with INDEX number
        driver.switchTo().frame(0);
        Thread.sleep(1000);

        // clean before sendKeys()
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with INDEX");

        // second way of goes back to first frame
        driver.switchTo().parentFrame();
        Thread.sleep(1000);

        // 3. Switch using with WebElement object
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);

        // clean before sendKeys()
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with WEBELEMENT");
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        // Switch to frame-top
        driver.switchTo().frame("frame-top");
        // top has 3 frame under left middle and right
        // switch to frame middle
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.cssSelector("#content")).getText());

        // goes back to top frame
        driver.switchTo().parentFrame();

        // switch to frame left
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        // goes back to main frame
        driver.switchTo().defaultContent();

        // switch to frame bottom
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }

}
