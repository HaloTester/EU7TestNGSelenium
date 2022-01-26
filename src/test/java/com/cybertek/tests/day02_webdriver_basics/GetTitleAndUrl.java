package com.cybertek.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        // Task open Chrome and navigate to http://practice.cybertekschool.com
        // get Title and Url
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        // getting title with selenium
        String title = driver.getTitle();
        System.out.println("title = " + title);

        // getting url wit selenium
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        // getting page source with selenium
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

        driver.close();
    }
}
