package com.cybertek.tests.day04_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        Faker faker = new Faker();

        // make browser full screen
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        String fullName = faker.name().fullName();

        WebElement fullNameInput = driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys(fullName);

        String email = faker.internet().emailAddress();

        // proper way
        // WebElement eMailInput = driver.findElement(By.name("email"));
        // eMailInput.sendKeys(email);

        // lazy way
        driver.findElement(By.name("email")).sendKeys(email);

        // proper way
        // WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        // signUpButton.click();

        // lazy way
        driver.findElement(By.name("wooden_spoon")).click();







    }
}
