package com.cybertek.tests.reviews.week07;

import com.cybertek.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelTestExample {

    List<Map<String,String>> users = new ArrayList<>();

    @Test
    public void createExcelFile() throws IOException {
        String path = "src/test/resources/Vytracktestdata.xlsx";
        String sheetName = "QA2-short";
        ExcelUtil readFile = new ExcelUtil(path,sheetName);

        int rowCount = readFile.rowCount();
        for (int i = 1; i < rowCount; i++) {
            Map<String,String> userDataOfEachRow = new HashMap<>();
            String username = readFile.getCellData(i,0);
            String password = readFile.getCellData(i, 1);
            String firstname = readFile.getCellData(i,2);
            String lastname = readFile.getCellData(i, 3);
            userDataOfEachRow.put(readFile.getColumnsNames().get(0),username);
            userDataOfEachRow.put(readFile.getColumnsNames().get(1),password);
            userDataOfEachRow.put(readFile.getColumnsNames().get(2),firstname);
            userDataOfEachRow.put(readFile.getColumnsNames().get(3),lastname);
            users.add(userDataOfEachRow);
        }

        System.out.println("users = " + users);
        System.out.println("users.get(5).get(\"firstname\") = " + users.get(1).get("firstname"));

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("MyUsers");

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < readFile.columnCount() ; i++) {
            Cell cell = headerRow.createCell(i);                   // create a cell
            cell.setCellValue(readFile.getColumnsNames().get(i));  // put data in the cell
        }

        for (int i = 1; i < readFile.rowCount()-1; i++) {
            Row eachRow = sheet.createRow(i);
            eachRow.createCell(0).setCellValue(users.get(i-1).get("username"));
            eachRow.createCell(1).setCellValue(users.get(i-1).get("password"));
            eachRow.createCell(2).setCellValue(users.get(i-1).get("firstname"));
            eachRow.createCell(3).setCellValue(users.get(i-1).get("lastname"));
        }

        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/MyUsers.xlsx");

        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
    }
}
