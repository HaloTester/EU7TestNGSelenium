package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlNotChange {

    public static void main(String[] args) {
        /*Verify URL not changed
	    -open chrome browser
	    -go to http://practice.cybertekschool.com/forgot_password Links to an external site.
	    -click on Retrieve password
	    -verify that url did not change
	    */

        // (1) open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // (2) go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // get Url before click the button
        String expectedUrl = driver.getCurrentUrl();

        // (3) click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        // get Url after click the button
        String actualUrl = driver.getCurrentUrl();

        // (4) verify that url did not change
        if (expectedUrl.equals(actualUrl)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        // close your browser
        driver.quit();
    }
}
