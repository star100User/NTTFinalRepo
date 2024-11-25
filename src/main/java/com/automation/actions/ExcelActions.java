package com.automation.actions;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class ExcelActions {

	public String readData(String filePath, String sheetName, int rowNum, int colNum) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // For .xlsx files
		Sheet sheet = workbook.getSheet(sheetName);

		// Ensure the row exists
		Row row = sheet.getRow(rowNum);
		if (row == null) {
			workbook.close();
			fis.close();
			return "Row does not exist!";
		}

		// Ensure the cell exists
		Cell cell = row.getCell(colNum);
		if (cell == null) {
			workbook.close();
			fis.close();
			return "Cell does not exist!";
		}

		// Return the cell value as string
		String cellValue = cell.toString();

		// Closing resources
		workbook.close();
		fis.close();

		return cellValue;
	}

	// Method to write data to Excel sheet
	public void writeData(String filePath, String sheetName, int rowNum, int colNum, String data) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis); // For .xlsx files
		Sheet sheet = workbook.getSheet(sheetName);

		if (sheet == null) {
			sheet = workbook.createSheet(sheetName); // Create a new sheet if it doesn't exist
		}

		Row row = sheet.getRow(rowNum);
		if (row == null) {
			row = sheet.createRow(rowNum); // Create a new row if it doesn't exist
		}

		Cell cell = row.createCell(colNum);
		cell.setCellValue(data);

		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);

		fos.close();
		workbook.close();
		fis.close();
	}

	// Method to read all data from a specific sheet
	public void readAllData(String filePath, String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis); // For .xlsx files
		Sheet sheet = workbook.getSheet(sheetName);

		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				System.out.print(cell.toString() + "\t");
			}
			System.out.println();
		}

		workbook.close();
		fis.close();
	}

	// Method to get the total number of rows in the sheet
	public int getRowCount(String filePath, String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis); // For .xlsx files
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		workbook.close();
		fis.close();
		return rowCount;
	}

	// Method to get the total number of columns in the sheet
	public int getColumnCount(String filePath, String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis); // For .xlsx files
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(0); // Get the first row to determine column count
		int colCount = row.getPhysicalNumberOfCells();
		workbook.close();
		fis.close();
		return colCount;
	}
}
