package com.boot.wego.util.excel.usermode;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProcessXLSLUtil {
    public void processSheet(String filename){
        try {
            Workbook wb = null;
            File file = new File(filename);
            InputStream fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.println("row:" + row.getRowNum() + ",cell:" + cell.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProcessXLSLUtil userModelForExcel = new ProcessXLSLUtil();
        userModelForExcel.processSheet("C:\\Users\\YanC\\Desktop\\OM00_QA管理表_鄭州_BAK 的副本.xlsx");
    }
}
