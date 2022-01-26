package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void printTable() {
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));

        System.out.println(table.getText());

        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));
    }

    @Test
    public void getAllHeaders() {
        // how many columns we have?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }

    @Test
    public void printTableSize() {
        // how many columns we have?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        System.out.println("headers.size() = " + headers.size());

        // number of rows
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("allRowsWithHeader.size() = " + allRowsWithHeader.size());

        // number of rows without Header (we prefer this)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("allRowsWithoutHeader.size() = " + allRowsWithoutHeader.size());
    }

    @Test
    public void getRow() {
        // print the second row information
        WebElement secondRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(secondRow.getText());

        //get all rows dynamically
        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i = 1; i <= numRows.size(); i++) {
            String xpathRows = "//table[@id='table1']/tbody/tr[" + i + "]";
            WebElement rows = driver.findElement(By.xpath(xpathRows));
            System.out.println(i + "-" + rows.getText());
        }
    }

    @Test
    public void getAllCellInOneRow() {
        List<WebElement> allCellInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        for (WebElement webElement : allCellInOneRow) {
            System.out.println(webElement.getText());
        }

    }

    @Test
    public void getASingleCellByIndex() {

        WebElement singleCell1 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
        System.out.println(singleCell1.getText());

        WebElement singleCell2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[3]"));
        System.out.println(singleCell2.getText());

    }

    @Test
    public void printAllCellsByIndex() {

        int rowNumber = getNumberOfRows();      //create a method for dynamic row size
        int colNumber = getNumberOfColumns();   //create a method for dynamic column size

        System.out.println("rowNumber = " + rowNumber);
        System.out.println("colNumber = " + colNumber);

        for (int i = 1; i <= rowNumber; i++) {
            for (int j = 1; j<=colNumber; j++) {
                String xpathCell = "//table[@id='table1']/tbody/tr["+ i +"]/td["+ j + "]";
                System.out.println(xpathCell);

                WebElement allCell = driver.findElement(By.xpath(xpathCell));
                System.out.println(allCell.getText());
            }
        }
    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow() {
        String firstName = "John";
        String xpath = "//table[@id='table1']//td[.='" + firstName + "']/..//td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println("email.getText() = " + email.getText());
    }

    private int getNumberOfColumns() {
        List<WebElement> numberOfColumns = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return numberOfColumns.size();
    }

    private int getNumberOfRows() {
        List<WebElement> numberOfRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return numberOfRows.size();
    }

}
