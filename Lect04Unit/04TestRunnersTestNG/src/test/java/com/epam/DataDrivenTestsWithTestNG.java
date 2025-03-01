package com.epam;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataDrivenTestsWithTestNG {

    // Method for providing data using a two-dimensional object array
    @DataProvider(name = "dataMethod")
    public static Object[][] dataProviderMethod() {
        return new Object[][]{{"data1", 1}, {"data2", 2}, {"data3", 3}};
    }

    @Test(dataProvider = "dataMethod")
    public void testMethodDataProvider(String data, int number) {
        System.out.println("Data is: " + data + ", Number is: " + number);
        assert data.contains("data");
        assert number > 0;
    }

    // Data provider for Excel data source
    @DataProvider(name = "dataFromExcel")
    public static Iterator<Object[]> dataProviderFromExcel() throws IOException {
        FileInputStream inputStream = new FileInputStream("path/to/your/excel.xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        List<Object[]> data = new ArrayList<>();

        for (Row row : sheet) {
            String dataField = row.getCell(0).getStringCellValue();
            int numberField = (int)row.getCell(1).getNumericCellValue();

            data.add(new Object[]{dataField, numberField});
        }

        workbook.close();
        inputStream.close();

        return data.iterator();
    }

    @Test(dataProvider = "dataFromExcel")
    public void testExcelDataProvider(String data, int number) {
        System.out.println("Excel Data is: " + data + ", Number is: " + number);
        assert data != null;
        assert number > 0;
    }
}
