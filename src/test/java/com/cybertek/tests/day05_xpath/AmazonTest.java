package com.cybertek.tests.day05_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    /*
      TASK
      go to amazon.com
      search for selenium
      click search button
      verify 1-48 of 304 results for "Java"
    */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com/");

        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("selenium");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@value='Go']")).click();

        WebElement getSearchResult = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));

        String actualResult = getSearchResult.getText();
        String expectedResult = "1-48 of 201 results for";

        if(actualResult.equals(expectedResult)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualResult = " + actualResult);
            System.out.println("expectedResult = " + expectedResult);
        }

        driver.quit();
    }
}
