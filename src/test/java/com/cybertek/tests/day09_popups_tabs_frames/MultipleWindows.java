package com.cybertek.tests.day09_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Set;

public class MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void switchWindowTest() {
        driver.get("http://practice.cybertekschool.com/windows");

        // get title
        System.out.println("Title before new window: " + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("Title after new window: " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        String currentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }

        System.out.println("Title after new window: " + driver.getTitle());
    }

    @Test
    public void moreThan2Window(){
        driver.get("http://practice.cybertekschool.com/windows");

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("Before switch: " + driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();

        // loop through each window
        for (String handle : windowHandles) {
            // one by one change it
            driver.switchTo().window(handle);
            // whenever your title equals to your expected window title
            if(driver.getTitle().equals("New Window")){
                // stop on that window
                break;
            }
        }

        System.out.println("After switch: " + driver.getTitle());
    }
}
