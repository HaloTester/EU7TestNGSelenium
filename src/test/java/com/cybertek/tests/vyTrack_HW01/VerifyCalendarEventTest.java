package com.cybertek.tests.vyTrack_HW01;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class VerifyCalendarEventTest extends TestBase {

    @Test
    public void pageSubTitleTest(){
        extentLogger = report.createTest("Page Subtitle Verification");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoreManager();
        extentLogger.info("Navigate to Activities -> Calendar Events");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Verify that page subtitle \"Options\" is displayed");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertTrue(calendarEventsPage.pageSubTitle.isDisplayed(),"Options Is Not Displayed");
        extentLogger.pass("PASSED");
    }

    @Test
    public void pageNumberTest(){
        extentLogger = report.createTest("Page Number Verification");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoreManager();
        extentLogger.info("Navigate to Activities -> Calendar Events");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Verify that page number is equals to \"1\"");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"),"1");
        extentLogger.pass("PASSED");
    }

    @Test
    public void viewPerPageNumberTest(){
        extentLogger = report.createTest("View Per Page Number Verification");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoreManager();
        extentLogger.info("Navigate to Activities -> Calendar Events");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Verify that view per page number is equals to \"25\"");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        Assert.assertEquals(calendarEventsPage.viewPerPageNumber.getText(),"25");
        extentLogger.pass("PASSED");
    }

    @Test
    public void numberOfCalendarEventsTest(){
        extentLogger = report.createTest("Number of Calendar Events Verification");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoreManager();
        extentLogger.info("Navigate to Activities -> Calendar Events");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Verify that all calendar events were selected");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        Assert.assertEquals(calendarEventsPage.numberOfCalendarEventsRecord(),"45");
        extentLogger.pass("PASSED");
    }

    @Test
    public void selectAllCalendarEventsTest(){
        extentLogger = report.createTest("Select All Calendar Events Verification");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoreManager();
        extentLogger.info("Navigate to Activities -> Calendar Events");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Click on the top checkbox to select all");
        calendarEventsPage.selectAllCalendarEventsBtn.click();
        extentLogger.info("Verify that all calendar events were selected");
        calendarEventsPage.checkSelectedCalendarEvents();
        Assert.assertEquals(calendarEventsPage.viewPerPageNumber.getText(),"25");
        extentLogger.pass("PASSED");
    }

    @Test
    public void followingDataTest(){
        extentLogger = report.createTest("Following Data Verification");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoreManager();
        extentLogger.info("Navigate to Activities -> Calendar Events");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Select Testers meeting");
        calendarEventsPage.selectTitle("Testers Meeting").click();
        extentLogger.info("Verify that following data is displayed");
        List<String> expectedEventInfo = Arrays.asList("Title","Testers meeting","Description",
                "This is a a weekly testers meeting","Start","Nov 27, 2019, 9:30 AM","End",
                "Nov 27, 2019, 10:30 AM","All-Day Event","No","Organizer","John Doe","Call Via Hangout","No");
        Assert.assertEquals(calendarEventsPage.eventInfoPage(),expectedEventInfo);
        extentLogger.pass("PASSED");
    }
}
