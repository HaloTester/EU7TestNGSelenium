package com.cybertek.tests.reviews.week04;

import com.cybertek.utilities.WebDriverFactory;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownTest {

    /*
    Task3:
    1. Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    2. Login with username: Tester, password: test
    3. Click  Order button
    4. Verify under Product Information, selected option is “MyMoney”
    5. Then select FamilyAlbum, make quantity 2, and click Calculate,
    6. Then verify Total is equal to Quantity*PricePerUnit
    I am trying to see if I can push new stuff
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void selectedOptionTest(){
        WebElement username = driver.findElement(By.name("ctl00$MainContent$username"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));
        password.sendKeys("test");

        WebElement loginBtn = driver.findElement(By.name("ctl00$MainContent$login_button"));
        loginBtn.click();

        WebElement orderPage = driver.findElement(By.linkText("Order"));
        orderPage.click();

        String expectedResult = "MyMoney";

        WebElement productDropdown = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));

        Select select = new Select(productDropdown);
        String actualResult = select.getFirstSelectedOption().getText();

        Assert.assertEquals(actualResult,expectedResult,"Verify that selected option is MyMoney");
    }

    @Test
    public void totalPriceTest(){
        WebElement username = driver.findElement(By.name("ctl00$MainContent$username"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));
        password.sendKeys("test");

        WebElement loginBtn = driver.findElement(By.name("ctl00$MainContent$login_button"));
        loginBtn.click();

        WebElement orderPage = driver.findElement(By.linkText("Order"));
        orderPage.click();

        WebElement productDropdown = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));

        Select select = new Select(productDropdown);
        select.selectByVisibleText("FamilyAlbum");

        WebElement quantityBox = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
        quantityBox.clear();
        quantityBox.sendKeys("2");

        WebElement calculateBtn = driver.findElement(By.xpath("//*[@value='Calculate']"));
        calculateBtn.click();

        WebElement pricePerUnitBox = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtUnitPrice"));
        int pricePerUnit = Integer.parseInt(pricePerUnitBox.getAttribute("value"));

        int expectedPrice = pricePerUnit*2;

        WebElement totalBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal"));
        int actualPrice = Integer.parseInt(totalBox.getAttribute("value"));

        System.out.println("expectedPrice = " + expectedPrice);
        System.out.println("actualPrice = " + actualPrice);

        Assert.assertEquals(actualPrice,expectedPrice,"Verify that total price equals quantity * perUnitPrice");

    }


}
