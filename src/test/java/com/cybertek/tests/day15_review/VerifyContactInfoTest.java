package com.cybertek.tests.day15_review;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInfoTest extends TestBase {
    /**
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */
    @Test
    public void contactDetailsTest(){
        extentLogger = report.createTest("Contact Info Verification");

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        extentLogger.info("Username: " + username);
        extentLogger.info("Password: " + password);
        extentLogger.info("Login as a sales manager");
        loginPage.login(username,password);
        extentLogger.info("Navigate to customer -> contacts");
        // if you want to use one time, you can use short way
        new DashboardPage().navigateToModule("Customers","Contacts");

        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Click on email mbrackstone9@example.com");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactsInfoPage contactsInfoPage = new ContactsInfoPage();

        extentLogger.info("verify that full name is Mariam Brackstone");
        Assert.assertEquals(contactsInfoPage.fullName.getText(),"Mariam Brackstone");

        extentLogger.info("verify that email is mbrackstone9@example.com");
        Assert.assertEquals(contactsInfoPage.email.getText(),"mbrackstone9@example.com");

        extentLogger.info("verify that phone number is +18982323434");
        Assert.assertEquals(contactsInfoPage.phone.getText(),"+18982323434");

        extentLogger.pass("PASSED");
    }
}
