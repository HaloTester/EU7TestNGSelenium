package com.cybertek.tests.day16_dataDrivenFramework;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object[][] testData(){
        String path = "src/test/resources/Vytracktestdata.xlsx";
        String sheetName = "QA2-short";
        ExcelUtil qa2Short = new ExcelUtil(path,sheetName);
        String[][] data = qa2Short.getDataArrayWithoutFirstRow();
        return data;
    }

    @Test(dataProvider = "testData")
    public void loginTest(String username, String password, String firstName, String lastName){
        extentLogger = report.createTest("Login with DDF Verification \n Username: "
                + username + "\nPassword: " + password);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullname = dashboardPage.userName.getText();
        String expectedFullname = firstName + " " + lastName;

        extentLogger.info("Verify that " + firstName + " " + lastName + " is same with expected");
        Assert.assertEquals(actualFullname,expectedFullname);

        extentLogger.pass("PASSED");
    }

}
