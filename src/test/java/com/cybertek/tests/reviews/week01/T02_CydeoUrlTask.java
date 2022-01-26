package com.cybertek.tests.reviews.week01;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class T02_CydeoUrlTask {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com");

        // to maximize web page
        driver.manage().window().maximize();

        Thread.sleep(3000);

        String actualUrlText = driver.getCurrentUrl();
        String expectedUrlText = "cybertekschool";

        System.out.println("actualUrlText = " + actualUrlText);
        System.out.println("expectedUrlText = " + expectedUrlText);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";

        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedTitle = " + expectedTitle);

        driver.close();

        if((actualUrlText.contains(expectedUrlText)) && (actualTitle.contains(expectedTitle))){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed!");
        }
    }
}
