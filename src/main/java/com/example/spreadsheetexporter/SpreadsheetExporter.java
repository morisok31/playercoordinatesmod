package com.example.spreadsheetexporter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class SpreadsheetExporter {

    public static void exportToSpreadsheet(double x, double y, double z) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Player Coordinates");

            Row row = sheet.createRow(0);
            Cell cellX = row.createCell(0);
            Cell cellY = row.createCell(1);
            Cell cellZ = row.createCell(2);

            cellX.setCellValue(x);
            cellY.setCellValue(y);
            cellZ.setCellValue(z);

            // Save the workbook to a file
            try (FileOutputStream outputStream = new FileOutputStream("player_coordinates.xlsx")) {
                workbook.write(outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
