package com.cybertek.tests.day14_extentreports;

import com.cybertek.pages.ContactsInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
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
    public void contactDetailTest(){
        extentLogger = report.createTest("Contact Info Verification");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a sales manager");
        loginPage.loginAsSalesManager();

        extentLogger.info("Navigate to customer -> contacts");
        new DashboardPage().navigateToModule("Customers","Contacts");
        new DashboardPage().waitUntilLoaderScreenDisappear();

        extentLogger.info("Click on email mbrackstone9@example.com");
        ContactsPage contactsPage = new ContactsPage();
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
