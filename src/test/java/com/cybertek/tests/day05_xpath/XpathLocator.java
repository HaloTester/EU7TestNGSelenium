package com.cybertek.tests.day05_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.manage().window().maximize();

        // for attributes that have any TagName with value search
        WebElement button2 = driver.findElement(By.xpath("//button[@onclick='button2()']"));
        button2.click();

        Thread.sleep(2000);

        // for exact matching text() search
        WebElement button5 = driver.findElement(By.xpath("//button[text()='Button 5']"));
        button5.click();                       //By.xpath("//*[.='Button 5']");

        Thread.sleep(2000);

        // for partially text() search
        WebElement button1 = driver.findElement(By.xpath("//button[contains(text(),'ton 1')]"));
        button1.click();                      //By.xpath("//*[contains(text(),'ton 1')]");

        Thread.sleep(2000);

        // for dynamic id attributes in partially --> starts-with
        WebElement button3 = driver.findElement(By.xpath("//button[starts-with(@id,'button')]"));
        button3.click();                      //By.xpath("//*[starts-with(@id,'button')]");

        Thread.sleep(2000);

        // for dynamic id attributes in partially -->ends-with but not work in Chrome
        // instead of ends-with use //TagName[contains(@attributes,'value')]
        WebElement button4 = driver.findElement(By.xpath("//button[contains(@id,'_button')][1]"));
        button4.click();                      //By.xpath("//*[contains(@id,'_button')]");

        Thread.sleep(2000);

        driver.navigate().to("http://practice.cybertekschool.com/");

        // for multiple elements that not have same parent
        WebElement dynamicContent = driver.findElement(By.xpath("(//a[contains(text(),'Dynamic')])[1]"));
        dynamicContent.click();                       // (your formula)[indexNumber]

        driver.quit();
    }
}
