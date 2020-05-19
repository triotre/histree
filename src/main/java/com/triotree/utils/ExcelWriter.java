package com.triotree.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	 
		private static Logger Log = Logger.getLogger(ExcelWriter.class);
	 
		private XSSFSheet ExcelWSheet;
		private XSSFWorkbook ExcelWBook;
		private XSSFCell Cell;
		private XSSFRow Row;
		private String path;
	 
		public void setExcelFile(String Path) throws Exception {
	 
			File myFile = new File(Path);
			path = Path;
			try (FileInputStream ExcelFile = new FileInputStream(myFile)) {
				ExcelWBook = new XSSFWorkbook(ExcelFile);
			
			}
		}
	 
		public void createRecord(String sheetName, int rowNumber, int cellNumber, String value) {
			XSSFSheet ExcelWSheet = ExcelWBook.getSheet(sheetName);
			if (ExcelWSheet != null)
				ExcelWSheet.createRow((short) rowNumber).createCell(cellNumber).setCellValue(value);
		}
		public XSSFRow createRow(int rowNumber) {
			XSSFRow row = ExcelWSheet.createRow((int) rowNumber);
			return row;
		}
		public XSSFRow createRow(XSSFSheet sheet, short rowNumber) {
			XSSFRow row = ExcelWSheet.createRow((short) rowNumber);
			return row;
		}
	 
		public XSSFCell createCell(XSSFRow row, short cellNumber) {
			XSSFCell cell = row.createCell((short) cellNumber);
			return cell;
		}
	 
		public XSSFSheet createSheet(String sheetName) {
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			if (ExcelWSheet == null)
				ExcelWSheet = ExcelWBook.createSheet(sheetName);
			return ExcelWSheet;
		}
	 
		public void setCellValue(XSSFCell cell, String value) {
			cell.setCellValue(value);
		}
	 
		public void write() throws FileNotFoundException, IOException {
			File myFile = new File(path);
	 
			try (FileOutputStream outputStream = new FileOutputStream(myFile)) {
				ExcelWBook.write(outputStream);
				
			}
		}
	 
	}
