package com.cybertek.tests.day02_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");
        Thread.sleep(5000);
        driver.close();

        driver = WebDriverFactory.getDriver("edge");
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
        driver.quit();

        driver = WebDriverFactory.getDriver("firefox");
        driver.get("https://www.google.com");
        Thread.sleep(3000);
        driver.navigate().to("https://www.facebook.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.quit();
    }
}
