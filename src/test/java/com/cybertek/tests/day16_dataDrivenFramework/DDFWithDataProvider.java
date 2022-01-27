package com.cybertek.tests.day16_dataDrivenFramework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    @DataProvider
    public Object[][] testData(){
        String[][] data = {
                {"Person of Interest","10"},
                {"Sherlock","9"},
                {"Breaking Bad","9"},
                {"The Office","8"},
                {"La Casa De Papel","10"},
                {"Friends","7"},
                {"Gotham","9"},
        };
        return data;
    }

    @Test(dataProvider = "testData")
    public void test1(String tvShow, String rating){
        System.out.println("TV show " + tvShow + " has rating " + rating);
    }
}
