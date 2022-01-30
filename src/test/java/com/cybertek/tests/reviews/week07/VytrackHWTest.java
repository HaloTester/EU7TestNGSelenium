package com.cybertek.tests.reviews.week07;

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
}
