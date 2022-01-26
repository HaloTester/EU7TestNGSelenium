package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) {

        /* Verify confirmation message
        open Chrome browser
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says 'Your e-mail's been sent!'
        */

        // (1) open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // (2) go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // create fake data in Faker
        Faker faker = new Faker();
        String expectedEmail = faker.internet().emailAddress();

        // (3) enter any email ==> sendKeys()--> send keyboard action to the WebElement
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(expectedEmail);

        // saving actual email that we put any email before click retrieve password button
        // somehow we should get text from web elements
        // two main ways to get txt from web elements
        // 1.getText()--> it will work %99 and it will return string
        // 2.getAttribute("value") --> second way of getting text especially input boxes
        WebElement getEmail = driver.findElement(By.name("email"));
        String actualEmail = getEmail.getAttribute("value");

        // (4) verify that email is displayed in the input box
        if(actualEmail.equals(expectedEmail)){
            System.out.println("TEST 1:PASSED");
        }else{
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
            System.out.println("TEST 1:FAILED");
        }

        // (5) click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        // create expected message
        String expectedMessage = "Your e-mail's been sent!";

        // saving actual confirmation message after we enter any email and click retrieve password button
        WebElement message = driver.findElement(By.name("confirmation_message"));
        String actualMessage = message.getText();

        // (6) verify that confirmation message says 'Your e-mail's been sent!'
        if(actualMessage.equals(expectedMessage)){
            System.out.println("TEST 2:PASSED");
        }else{
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("TEST 2:FAILED");
        }

        // close your browser
        driver.quit();
    }
}
