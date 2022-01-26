package com.cybertek.tests.day07_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @BeforeMethod
    public void setUp(){
        System.out.println("Open Browser");
    }

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title", "title ");

        System.out.println("Second Assertion");
        Assert.assertEquals("url", "url");
    }

    @Test
    public void test2(){
        Assert.assertEquals("test2","test2");
    }

    @Test
    public void test3(){
        String expectedTitle = "Cyb";
        String actualTitle = "Cytertek";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "Verify title starts with Cyb");
    }

    @Test
    public void test4(){
        // verify email contains @ sign
        String email = "mike@smith.com";

        Assert.assertTrue(email.contains("@"), "Verify emails contains @");
    }

    @Test
    public void test5(){
        Assert.assertFalse(0>1, "Verify that 0 is not greater than 1");
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("one","two","Verify expectedResult is not equal to actualResult");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close Browser");
    }

}
