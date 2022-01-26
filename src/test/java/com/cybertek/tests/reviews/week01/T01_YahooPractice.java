package com.cybertek.tests.reviews.week01;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class T01_YahooPractice {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.yahoo.com");

        String expectedTitle = "Yahoo";
        String actualTitle = driver.getTitle();

        Thread.sleep(2000);

        driver.quit();

        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Test passed");
        }else{
           System.out.println("Test failed!");
        }
    }
}
