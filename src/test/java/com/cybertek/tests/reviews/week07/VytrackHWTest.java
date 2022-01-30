package com.cybertek.tests.reviews.week07;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VytrackHWTest extends TestBaseHW{

    @Test
    public void verifyOptionsTest(){
        extentLogger = report.createTest("Verify Options Link");
        extentLogger.info("Preconditions loaded");
        extentLogger.info("Verify that Options Link Displayed");
        Assert.assertTrue(calendarEventsPage.pageSubTitle.isDisplayed(),"Link is NOT displayed");
        extentLogger.info("Options Link is Displayed");
        extentLogger.pass("PASSED");
    }

    @Test
    public void verifyPageNumber(){
        extentLogger = report.createTest("Verify Page Number");
        extentLogger.info("Preconditions loaded");
        extentLogger.info("Verify that Page Number is 1 or not");
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"),"1");
        extentLogger.info("Page number equals to expected");
        extentLogger.pass("PASSED");
    }

    @Test
    public void verifyViewPerPageNumber() throws InterruptedException {
        extentLogger = report.createTest("Verify View Per Page Number");
        extentLogger.info("Preconditions loaded");
        extentLogger.info("Verify that View Per Page Number is 25");
        wait.until(ExpectedConditions.visibilityOf(calendarEventsPage.viewPerPageNumber));
        Assert.assertEquals(calendarEventsPage.viewPerPageNumber.getText(),"25");
        extentLogger.info("View Per Page Number equals to expected");
        extentLogger.pass("PASSED");
    }
}
