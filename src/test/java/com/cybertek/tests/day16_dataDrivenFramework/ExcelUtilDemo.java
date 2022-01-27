package com.cybertek.tests.day16_dataDrivenFramework;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilDemo {

    @Test
    public void readExcelFile(){

        String path = "src/test/resources/Vytracktestdata.xlsx";
        String sheetName = "QA3-short";
        ExcelUtil qa3Short = new ExcelUtil(path, sheetName);

        //how many rows in the sheet --> rowCount() method
        System.out.println("qa3Short.rowCount() = " + qa3Short.rowCount());

        //how many columns in the sheet --> columnCount() method
        System.out.println("qa3Short.columnCount() = " + qa3Short.columnCount());

        //get all column names --> getColumnNames() method
        System.out.println(qa3Short.getColumnsNames());

        //get all data in list of maps
        List<Map<String,String>> dataList= qa3Short.getDataList();
        for(Map<String,String> oneRow : dataList){
            System.out.println(oneRow);
        }

        //get Nona as a value
        System.out.println(dataList.get(2).get("firstname"));

        //get Harber as a value
        System.out.println(dataList.get(8).get("lastname"));

        //get all data in 2d array
        String[][] dataArray = qa3Short.getDataArrayWithoutFirstRow();

        //print 2d array --> Arrays.deepToString() method
        System.out.println(Arrays.deepToString(dataArray));
    }
}
