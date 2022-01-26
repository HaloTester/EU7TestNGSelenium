package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
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

    @Test
    public void test1() { // static file path
        driver.get("http://practice.cybertekschool.com/upload");

        // locating choose file button
        WebElement chooseFile = driver.findElement(By.name("file"));

        // sending file with sendKeys() method
        chooseFile.sendKeys("C:\\Users\\Admin\\IdeaProjects\\EU7TestNGSelenium\\src\\test\\resources\\file.txt");

        // clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //getting the file name from browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();

        // verify file name is file.txt
        Assert.assertEquals(actualFileName, "file.txt");
    }

    @Test
    public void test2() { // dynamic file path
        driver.get("http://practice.cybertekschool.com/upload");

        // locating choose file button
        WebElement chooseFile = driver.findElement(By.name("file"));

        // sending file with sendKeys() method

        // create file path dynamically
        // first create project path --> System.getProperty("user.dir"); (DYNAMIC PATH)
        String projectPath = System.getProperty("user.dir");

        // second create file path --> right click file and choose content root section (STATIC PATH)
        String filePath = "src/test/resources/textfile.txt";

        //last concatenate project path and file path then create fullPath dynamically
        String fullPath = projectPath + "/" + filePath;

        chooseFile.sendKeys(fullPath);

        // clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //getting the file name from browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();

        // verify file name is file.txt
        Assert.assertEquals(actualFileName, "textfile.txt");
    }
}
