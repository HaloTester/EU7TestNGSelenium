package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChanged {

    public static void main(String[] args) {

        /* Verify URL changed
        open chrome browser
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        click on Retrieve password
        verify that url changed to http://practice.cybertekschool.com/email_sent
        */

        // (1) open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // create fake data in Faker
        Faker faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();

        // (2) go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // (3) enter any email ==> sendKeys()--> send keyboard action to the WebElement
        WebElement enterEmail = driver.findElement(By.name("email"));
        enterEmail.sendKeys(fakeEmail);

        // (4) click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        // create expected Url
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        // saving actual url from browser after we enter any email and click retrieve password button
        String actualUrl = driver.getCurrentUrl();

        // (5) verify that url changed to http://practice.cybertekschool.com/email_sent
        if(actualUrl.equals(expectedUrl)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
            System.out.println("actualUrl = " + actualUrl);
            System.out.println("expectedUrl = " + expectedUrl);
        }

        // close your browser
        driver.quit();





    }
}
