package com.cybertek.tests.reviews.week05;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AdidasTask {
    /*
    Adidas Company QA Test
    You have to implement the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
    • Customer navigation through product categories: Phones, Laptops and Monitors
    • Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
    • Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
    • Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
    • Click on "Place order".
    • Fill in all web form fields.
    • Click on "Purchase"
    • Capture and log purchase Id and Amount.
    • Assert purchase amount equals expected.
    • Click on "Ok"
    */

    WebDriver driver;
    WebDriverWait wait;
    int expectedPurchaseAmount = 0;
    private int purchaseIDNumber;
    private int actualPurchaseAmount;
    Faker faker;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    public void navigateTo(String linkStr){
        driver.findElement(By.partialLinkText(linkStr)).click();
    }

    public int productAdder(String category,String product){
        navigateTo(category);
        navigateTo(product);
        navigateTo("Add to cart");

        WebElement priceElement = driver.findElement(By.tagName("h3"));
        String priceWholeText = priceElement.getText();
        String[] arr = priceWholeText.split(" ");
        int listPrice = Integer.parseInt(arr[0].substring(1));

        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();

        navigateTo("Home");

        return listPrice;
    }

    public int productRemover(String product){
        navigateTo("Cart");

        String productLocator = "//*[contains(text(),'" + product + "')]/../td[4]/a";
        String priceLocator = "//*[contains(text(),'" + product + "')]/../td[3]";

        WebElement priceElement = driver.findElement(By.xpath(priceLocator));
        String priceDeletedText = priceElement.getText();
        int listPriceRemove = Integer.parseInt(priceDeletedText);

        WebElement deleteBtn = driver.findElement(By.xpath(productLocator));
        deleteBtn.click();

        return listPriceRemove;
    }

    public void placeOrder() throws InterruptedException {
        faker = new Faker();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[contains(text(),'Place Order')]")).click();

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys(faker.name().fullName());

        WebElement country = driver.findElement(By.id("country"));
        country.sendKeys(faker.country().name());

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys(faker.address().cityName());

        WebElement creditCard = driver.findElement(By.id("card"));
        creditCard.sendKeys(faker.finance().creditCard());

        WebElement month = driver.findElement(By.id("month"));
        month.sendKeys("12");

        WebElement year = driver.findElement(By.id("year"));
        year.sendKeys("2022");

        driver.findElement(By.xpath("//*[contains(text(),'Purchase')]")).click();
    }

    public void completePurchase(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]")));
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
    }

    public void logger(){
        String purchaseLog = driver.findElement(By.xpath("//div[10]/p")).getText();
        String[] arr = purchaseLog.split(" ");
        purchaseIDNumber = Integer.parseInt(arr[1].substring(0,7));
        actualPurchaseAmount = Integer.parseInt(arr[2]);
        System.out.println("-------Log of Shopping-------");
        System.out.println("ID number of purchase: " + purchaseIDNumber + "\nAmount of purchase: " + actualPurchaseAmount);
        System.out.println("-----------------------------");
    }

    @Test
    public void test() throws InterruptedException {

        //Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
        expectedPurchaseAmount += productAdder("Laptops","Sony vaio i5");

        //Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
        expectedPurchaseAmount += productAdder("Laptops","Dell i7 8gb");

        //Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
        expectedPurchaseAmount -= productRemover("Dell i7 8gb");

        placeOrder();

        logger();

        completePurchase();

        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
        System.out.println("actualPurchaseAmount = " + actualPurchaseAmount);

        Assert.assertEquals(expectedPurchaseAmount,actualPurchaseAmount,"Verify that last amount is as expected");
    }
}