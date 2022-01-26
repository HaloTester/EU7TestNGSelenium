package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    /**
     * hover over each image in the website
     * verify each name:user text is displayed
     */

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        List<WebElement> hoverList = driver.findElements(By.className("figure"));

        Actions actions = new Actions(driver);

        int counter = 1;
        for (WebElement webElement : hoverList) {
            actions.moveToElement(webElement).perform();
            Thread.sleep(2000);
            if (webElement.getText().contains("user" + counter)) {
                Assert.assertTrue(webElement.isDisplayed(), "verify user" + counter + " is displayed");
            }
            counter++;
        }

    }

    @Test
    public void test2() throws InterruptedException{
        driver.get("http://practice.cybertekschool.com/hovers");

        for (int i = 1; i <= 3; i++) {
            String xpathImg = "(//img)[" + i + "]";
            WebElement img = driver.findElement(By.xpath(xpathImg));
            System.out.println(xpathImg);

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            String textXpath = "//h5[.='name: user" + i + "']";
            WebElement text = driver.findElement(By.xpath(textXpath));
            System.out.println(textXpath);
            System.out.println(text.getText());

            System.out.println("---------------");

            Assert.assertTrue(text.isDisplayed(),"verify text " + i + " is displayed");
        }
    }
}
