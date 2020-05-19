package com.triotree.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static final Logger logger = LogManager.getLogger(ExcelReader.class.getName());

	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

		Object[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			// ExcelWSheet = ExcelWBook.getSheetAt(0);

			int startRow = 1;

			int startCol = 0;

			int ci, cj;

			int totalRows = ExcelWSheet.getLastRowNum();
			System.out.println("Total No of rows are" + totalRows);

			int totalCols = ExcelWSheet.getRow(1).getLastCellNum();
			System.out.println("Total No of Columns are" + totalCols);
			tabArray = new String[totalRows][totalCols];

			ci = 0;

			for (int i = startRow; i <= totalRows; i++, ci++) {

				cj = 0;

				for (int j = startCol; j < totalCols; j++, cj++) {
					try {
						tabArray[ci][cj] = getCellData(i, j);
					} catch (Exception e) {
						break;
					}

				}
			}

		}

		catch (FileNotFoundException e) {

			logger.info("Could not find the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e) {

			logger.info("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return (tabArray);

	}

	public static Object getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			int dataType = Cell.getCellType();

			if (dataType == 3) {

				return "";

			} else if (dataType == 0) {
				Object CellData = Cell.getDateCellValue();
				return CellData;

			} else {

				Object CellData = Cell.getStringCellValue();
				return CellData;
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

			throw (e);

		}
	}

	public static Double readExcelOpDiscount(String filePath, String sheetName) {
		Double SumOfValues = 0.00;
		List<List<String>> ret = new ArrayList();
		List<String> valuesArray = new ArrayList();
		if (filePath != null && !"".equals(filePath.trim()) && sheetName != null && !"".equals(sheetName.trim())) {
			try {
				/* First need to open the file. */
				FileInputStream fInputStream = new FileInputStream(filePath.trim());

				/* Create the workbook object. */
				Workbook excelWookBook = new XSSFWorkbook(fInputStream);

				/* Get the sheet by name. */
				Sheet employeeSheet = excelWookBook.getSheet(sheetName);

				System.out.println("inside excel reader");
				Sheet sheet = excelWookBook.getSheet(sheetName);
				Iterator rowIterator = sheet.iterator();
				/* Defining column name which needs to find in excel */
				String discountColumnName = "DiscAmt";
				// iterating over each row
				int colnum = -1;
				while (rowIterator.hasNext()) {

					Row row = (Row) rowIterator.next();
					Iterator cellIterator = row.cellIterator();

					// Iterating over each cell (column wise) in a particular row.
					while (cellIterator.hasNext()) {

						Cell cell = (org.apache.poi.ss.usermodel.Cell) cellIterator.next();
						// The Cell Containing String will is name.
						if (Cell.CELL_TYPE_STRING == cell.getCellType()) {

							// checking value with column name if matches Column Number to be saved other
							// wise ignored
							if (cell.getStringCellValue().trim().equalsIgnoreCase(discountColumnName)) {
								System.out.println("row number - " + row.getRowNum() + "  col no = " + colnum);
								if (colnum == -1) {
									System.out.println("checking for first time");
									colnum = cell.getColumnIndex();
									System.out.println("breaking at col no -> "+colnum);
									break;
								}
							}

						} else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
						}
					}
					// end iterating a row, add all the elements of a row in list
					if (colnum != 0) {
						// getting selected column of match found for specific column name
						Cell cell1 = row.getCell(colnum);

						try {
							if (Cell.CELL_TYPE_STRING == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									if (!cell1.getStringCellValue().trim().isEmpty()) {
										valuesArray.add(cell1.getStringCellValue());
									}
								}
							} else if (Cell.CELL_TYPE_NUMERIC == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									valuesArray.add("" + cell1.getNumericCellValue());
								}
							}
						} catch (Exception e) {
							System.out.println("numeric value not found or null value found ");

						}
					}

				}

				System.out.println("List value  -->>" + valuesArray.toString());
				// removing column name from list
				valuesArray.remove(discountColumnName);

				System.out.println("  final list >>  " + valuesArray.toString());
				SumOfValues = 0.0;
				Iterator iter = valuesArray.iterator();
				int count = 0;
				while (valuesArray.size() > count) {
					SumOfValues += Double.parseDouble(valuesArray.get(count).toString());

					count++;
				}
				System.out.println("  resultss >>  " + SumOfValues);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		DecimalFormat formatter = new DecimalFormat("#.0");
		Double Roundedvalue = Double.parseDouble(formatter.format(SumOfValues));
		return Roundedvalue;
	}

	public static Double readExcelIpDiscount(String filePath, String sheetName) {
		Double SumOfValues = 0.00;
		List<List<String>> ret = new ArrayList();
		List<String> valuesArray = new ArrayList();
		if (filePath != null && !"".equals(filePath.trim()) && sheetName != null && !"".equals(sheetName.trim())) {
			try {
				/* First need to open the file. */
				FileInputStream fInputStream = new FileInputStream(filePath.trim());

				/* Create the workbook object. */
				Workbook excelWookBook = new XSSFWorkbook(fInputStream);

				/* Get the sheet by name. */
				Sheet employeeSheet = excelWookBook.getSheet(sheetName);

				System.out.println("inside excel reader");
				Sheet sheet = excelWookBook.getSheet(sheetName);
				Iterator rowIterator = sheet.iterator();
				/* Defining column name which needs to find in excel */
				String discountColumnName = "Discount Amount";
				System.out.println(" inside method = readExcelIpDiscount()");
				// iterating over each row
				int colnum = -1;
				while (rowIterator.hasNext()) {

					Row row = (Row) rowIterator.next();
					Iterator cellIterator = row.cellIterator();

					// Iterating over each cell (column wise) in a particular row.
					while (cellIterator.hasNext()) {
						
						Cell cell = (org.apache.poi.ss.usermodel.Cell) cellIterator.next();
							// The Cell Containing String will is name.
							if (Cell.CELL_TYPE_STRING == cell.getCellType()) {

								// checking value with column name if matches Column Number to be saved other
								// wise ignored
								if (cell.getStringCellValue().trim().equalsIgnoreCase(discountColumnName)) {
									System.out.println("row number - " + row.getRowNum() + "  col no = " + colnum);
									if (colnum == -1) {
										System.out.println("checking for first time");
										colnum = cell.getColumnIndex();
										System.out.println("breaking at col no -> "+colnum);
										break;
									}
									//System.out.println("row number - " + row.getRowNum() + "  col no = " + colnum);
									
								}

							 else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
							}
						}
					}
					// end iterating a row, add all the elements of a row in list
					if (colnum != -1) {
						// getting selected column of match found for specific column name
						Cell cell1 = row.getCell(colnum);

						try {
							if (Cell.CELL_TYPE_STRING == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									if (!cell1.getStringCellValue().trim().isEmpty()) {
										valuesArray.add(cell1.getStringCellValue());
									}
								}
							} else if (Cell.CELL_TYPE_NUMERIC == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									valuesArray.add("" + cell1.getNumericCellValue());
								}
							}
						} catch (Exception e) {
							System.out.println("numeric value not found or null value found ");

						}
					}

				}

				System.out.println("List value  -->>" + valuesArray.toString());
				// removing column name from list
				valuesArray.remove(discountColumnName);

				System.out.println("  final list >>  " + valuesArray.toString());
				SumOfValues = 0.0;
				Iterator iter = valuesArray.iterator();
				int count = 0;
				while (valuesArray.size() > count) {
					SumOfValues += Double.parseDouble(valuesArray.get(count).toString());

					count++;
				}
				System.out.println("  resultss >>  " + SumOfValues);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		DecimalFormat formatter = new DecimalFormat("#.0");
		Double Roundedvalue = Double.parseDouble(formatter.format(SumOfValues));
		return Roundedvalue;
	}

	public static Double readExcelDSDDiscount(String filePath, String sheetName) {
		Double SumOfValues = 0.00;
		List<List<String>> ret = new ArrayList();
		List<String> valuesArray = new ArrayList();
		if (filePath != null && !"".equals(filePath.trim()) && sheetName != null && !"".equals(sheetName.trim())) {
			try {
				/* First need to open the file. */
				FileInputStream fInputStream = new FileInputStream(filePath.trim());

				/* Create the workbook object. */
				Workbook excelWookBook = new XSSFWorkbook(fInputStream);

				/* Get the sheet by name. */
				Sheet employeeSheet = excelWookBook.getSheet(sheetName);

				System.out.println("inside excel reader");
				Sheet sheet = excelWookBook.getSheet(sheetName);
				Iterator rowIterator = sheet.iterator();
				/* Defining column name which needs to find in excel */
				String discountColumnName = "discount";
				// iterating over each row
				int colnum = -1;
				while (rowIterator.hasNext()) {

					Row row = (Row) rowIterator.next();
					Iterator cellIterator = row.cellIterator();

					// Iterating over each cell (column wise) in a particular row.
					while (cellIterator.hasNext()) {

						Cell cell = (org.apache.poi.ss.usermodel.Cell) cellIterator.next();
						// The Cell Containing String will is name.
						if (Cell.CELL_TYPE_STRING == cell.getCellType()) {

							// checking value with column name if matches Column Number to be saved other
							// wise ignored
							if (cell.getStringCellValue().trim().equalsIgnoreCase(discountColumnName)) {
								System.out.println("row number - " + row.getRowNum() + "  col no = " + colnum);
								if (colnum == -1) {
									System.out.println("checking for first time");
									colnum = cell.getColumnIndex();
									System.out.println("breaking at col no -> "+colnum);
									break;
								}
							}

						} else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
						}
					}
					// end iterating a row, add all the elements of a row in list
					if (colnum != 0) {
						// getting selected column of match found for specific column name
						Cell cell1 = row.getCell(colnum);

						try {
							if (Cell.CELL_TYPE_STRING == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									if (!cell1.getStringCellValue().trim().isEmpty()) {
										valuesArray.add(cell1.getStringCellValue());
									}
								}
							} else if (Cell.CELL_TYPE_NUMERIC == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									valuesArray.add("" + cell1.getNumericCellValue());
								}
							}
						} catch (Exception e) {
							System.out.println("numeric value not found or null value found ");

						}
					}

				}

				System.out.println("List value  -->>" + valuesArray.toString());
				// removing column name from list
				valuesArray.remove(discountColumnName);

				System.out.println("  final list >>  " + valuesArray.toString());
				SumOfValues = 0.0;
				Iterator iter = valuesArray.iterator();
				int count = 0;
				while (valuesArray.size() > count) {
					SumOfValues += Double.parseDouble(valuesArray.get(count).toString());

					count++;
				}
				System.out.println("  resultss >>  " + SumOfValues);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		DecimalFormat formatter = new DecimalFormat("#.0");
		Double Roundedvalue = Double.parseDouble(formatter.format(SumOfValues));
		return Roundedvalue;
	}
	
	public static Double readExcelDSDGrossAmount(String filePath, String sheetName) {
		Double SumOfValues = 0.00;
		List<List<String>> ret = new ArrayList();
		List<String> valuesArray = new ArrayList();
		if (filePath != null && !"".equals(filePath.trim()) && sheetName != null && !"".equals(sheetName.trim())) {
			try {
				/* First need to open the file. */
				FileInputStream fInputStream = new FileInputStream(filePath.trim());

				/* Create the workbook object. */
				Workbook excelWookBook = new XSSFWorkbook(fInputStream);

				/* Get the sheet by name. */
				Sheet employeeSheet = excelWookBook.getSheet(sheetName);

				System.out.println("inside excel reader");
				Sheet sheet = excelWookBook.getSheet(sheetName);
				Iterator rowIterator = sheet.iterator();
				/* Defining column name which needs to find in excel */
				String discountColumnName = "Gross";
				// iterating over each row
				int colnum = -1;
				while (rowIterator.hasNext()) {

					Row row = (Row) rowIterator.next();
					Iterator cellIterator = row.cellIterator();

					// Iterating over each cell (column wise) in a particular row.
					while (cellIterator.hasNext()) {

						Cell cell = (org.apache.poi.ss.usermodel.Cell) cellIterator.next();
						// The Cell Containing String will is name.
						if (Cell.CELL_TYPE_STRING == cell.getCellType()) {

							// checking value with column name if matches Column Number to be saved other
							// wise ignored
							if (cell.getStringCellValue().trim().equalsIgnoreCase(discountColumnName)) {
								System.out.println("row number - " + row.getRowNum() + "  col no = " + colnum);
								if (colnum == -1) {
									System.out.println("checking for first time");
									colnum = cell.getColumnIndex();
									System.out.println("breaking at col no -> "+colnum);
									break;
								}
							}

						} else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
						}
					}
					// end iterating a row, add all the elements of a row in list
					if (colnum != 0) {
						// getting selected column of match found for specific column name
						Cell cell1 = row.getCell(colnum);

						try {
							if (Cell.CELL_TYPE_STRING == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									if (!cell1.getStringCellValue().trim().isEmpty()) {
										valuesArray.add(cell1.getStringCellValue());
									}
								}
							} else if (Cell.CELL_TYPE_NUMERIC == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									valuesArray.add("" + cell1.getNumericCellValue());
								}
							}
						} catch (Exception e) {
							System.out.println("numeric value not found or null value found ");

						}
					}

				}

				System.out.println("List value  -->>" + valuesArray.toString());
				// removing column name from list
				valuesArray.remove(discountColumnName);

				System.out.println("  final list >>  " + valuesArray.toString());
				SumOfValues = 0.0;
				Iterator iter = valuesArray.iterator();
				int count = 0;
				while (valuesArray.size() > count) {
					SumOfValues += Double.parseDouble(valuesArray.get(count).toString());

					count++;
				}
				System.out.println("  resultss >>  " + SumOfValues);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		DecimalFormat formatter = new DecimalFormat("#.0");
		Double Roundedvalue = Double.parseDouble(formatter.format(SumOfValues));
		return Roundedvalue;
	}
	
	public static Double readExcelDSDNetAmount(String filePath, String sheetName) {
		Double SumOfValues = 0.00;
		List<List<String>> ret = new ArrayList();
		List<String> valuesArray = new ArrayList();
		if (filePath != null && !"".equals(filePath.trim()) && sheetName != null && !"".equals(sheetName.trim())) {
			try {
				/* First need to open the file. */
				FileInputStream fInputStream = new FileInputStream(filePath.trim());

				/* Create the workbook object. */
				Workbook excelWookBook = new XSSFWorkbook(fInputStream);

				/* Get the sheet by name. */
				Sheet employeeSheet = excelWookBook.getSheet(sheetName);

				System.out.println("inside excel reader");
				Sheet sheet = excelWookBook.getSheet(sheetName);
				Iterator rowIterator = sheet.iterator();
				/* Defining column name which needs to find in excel */
				String discountColumnName = "Net";
				// iterating over each row
				int colnum = -1;
				while (rowIterator.hasNext()) {

					Row row = (Row) rowIterator.next();
					Iterator cellIterator = row.cellIterator();

					// Iterating over each cell (column wise) in a particular row.
					while (cellIterator.hasNext()) {

						Cell cell = (org.apache.poi.ss.usermodel.Cell) cellIterator.next();
						// The Cell Containing String will is name.
						if (Cell.CELL_TYPE_STRING == cell.getCellType()) {

							// checking value with column name if matches Column Number to be saved other
							// wise ignored
							if (cell.getStringCellValue().trim().equalsIgnoreCase(discountColumnName)) {
								System.out.println("row number - " + row.getRowNum() + "  col no = " + colnum);
								if (colnum == -1) {
									System.out.println("checking for first time");
									colnum = cell.getColumnIndex();
									System.out.println("breaking at col no -> "+colnum);
									break;
								}
							}

						} else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
						}
					}
					// end iterating a row, add all the elements of a row in list
					if (colnum != 0) {
						// getting selected column of match found for specific column name
						Cell cell1 = row.getCell(colnum);

						try {
							if (Cell.CELL_TYPE_STRING == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									if (!cell1.getStringCellValue().trim().isEmpty()) {
										valuesArray.add(cell1.getStringCellValue());
									}
								}
							} else if (Cell.CELL_TYPE_NUMERIC == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									valuesArray.add("" + cell1.getNumericCellValue());
								}
							}
						} catch (Exception e) {
							System.out.println("numeric value not found or null value found ");

						}
					}

				}

				System.out.println("List value  -->>" + valuesArray.toString());
				// removing column name from list
				valuesArray.remove(discountColumnName);

				System.out.println("  final list >>  " + valuesArray.toString());
				SumOfValues = 0.0;
				Iterator iter = valuesArray.iterator();
				int count = 0;
				while (valuesArray.size() > count) {
					SumOfValues += Double.parseDouble(valuesArray.get(count).toString());

					count++;
				}
				System.out.println("  resultss >>  " + SumOfValues);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		DecimalFormat formatter = new DecimalFormat("#.0");
		Double Roundedvalue = Double.parseDouble(formatter.format(SumOfValues));
		return Roundedvalue;
	}

	public static Double readExcelDTRSGross(String filePath, String sheetName) {
		Double SumOfValues = 0.00;
		List<List<String>> ret = new ArrayList();
		List<String> valuesArray = new ArrayList();
		if (filePath != null && !"".equals(filePath.trim()) && sheetName != null && !"".equals(sheetName.trim())) {
			try {
				/* First need to open the file. */
				FileInputStream fInputStream = new FileInputStream(filePath.trim());

				/* Create the workbook object. */
				Workbook excelWookBook = new XSSFWorkbook(fInputStream);

				/* Get the sheet by name. */
				Sheet employeeSheet = excelWookBook.getSheet(sheetName);

				System.out.println("inside excel reader");
				Sheet sheet = excelWookBook.getSheet(sheetName);
				Iterator rowIterator = sheet.iterator();
				/* Defining column name which needs to find in excel */
				String discountColumnName = "Gross Amount";
				// iterating over each row
				int colnum = -1;
				while (rowIterator.hasNext()) {

					Row row = (Row) rowIterator.next();
					Iterator cellIterator = row.cellIterator();

					// Iterating over each cell (column wise) in a particular row.
					while (cellIterator.hasNext()) {

						Cell cell = (org.apache.poi.ss.usermodel.Cell) cellIterator.next();
						// The Cell Containing String will is name.
						if (Cell.CELL_TYPE_STRING == cell.getCellType()) {

							// checking value with column name if matches Column Number to be saved other
							// wise ignored
							if (cell.getStringCellValue().trim().equalsIgnoreCase(discountColumnName)) {
								System.out.println("row number - " + row.getRowNum() + "  col no = " + colnum);
								if (colnum == -1) {
									System.out.println("checking for first time");
									colnum = cell.getColumnIndex();
									System.out.println("breaking at col no -> "+colnum);
									break;
								}
							}

						} else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
						}
					}
					// end iterating a row, add all the elements of a row in list
					if (colnum != 0) {
						// getting selected column of match found for specific column name
						Cell cell1 = row.getCell(colnum);

						try {
							if (Cell.CELL_TYPE_STRING == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									if (!cell1.getStringCellValue().trim().isEmpty()) {
										valuesArray.add(cell1.getStringCellValue());
									}
								}
							} else if (Cell.CELL_TYPE_NUMERIC == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									valuesArray.add("" + cell1.getNumericCellValue());
								}
							}
						} catch (Exception e) {
							System.out.println("numeric value not found or null value found ");

						}
					}

				}

				System.out.println("List value  -->>" + valuesArray.toString());
				// removing column name from list
				valuesArray.remove(discountColumnName);

				System.out.println("  final list >>  " + valuesArray.toString());
				SumOfValues = 0.0;
				Iterator iter = valuesArray.iterator();
				int count = 0;
				while (valuesArray.size() > count) {
					SumOfValues += Double.parseDouble(valuesArray.get(count).toString());

					count++;
				}
				System.out.println("  resultss >>  " + SumOfValues);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		DecimalFormat formatter = new DecimalFormat("#.0");
		Double Roundedvalue = Double.parseDouble(formatter.format(SumOfValues));
		return Roundedvalue;
	}
	
	public static Double readExcelDTRSDiscount(String filePath, String sheetName) {
		Double SumOfValues = 0.00;
		List<List<String>> ret = new ArrayList();
		List<String> valuesArray = new ArrayList();
		if (filePath != null && !"".equals(filePath.trim()) && sheetName != null && !"".equals(sheetName.trim())) {
			try {
				/* First need to open the file. */
				FileInputStream fInputStream = new FileInputStream(filePath.trim());

				/* Create the workbook object. */
				Workbook excelWookBook = new XSSFWorkbook(fInputStream);

				/* Get the sheet by name. */
				Sheet employeeSheet = excelWookBook.getSheet(sheetName);

				System.out.println("inside excel reader");
				Sheet sheet = excelWookBook.getSheet(sheetName);
				Iterator rowIterator = sheet.iterator();
				/* Defining column name which needs to find in excel */
				String discountColumnName = "Discount Amount";
				// iterating over each row
				int colnum = -1;
				while (rowIterator.hasNext()) {

					Row row = (Row) rowIterator.next();
					Iterator cellIterator = row.cellIterator();

					// Iterating over each cell (column wise) in a particular row.
					while (cellIterator.hasNext()) {

						Cell cell = (org.apache.poi.ss.usermodel.Cell) cellIterator.next();
						// The Cell Containing String will is name.
						if (Cell.CELL_TYPE_STRING == cell.getCellType()) {

							// checking value with column name if matches Column Number to be saved other
							// wise ignored
							if (cell.getStringCellValue().trim().equalsIgnoreCase(discountColumnName)) {
								System.out.println("row number - " + row.getRowNum() + "  col no = " + colnum);
								if (colnum == -1) {
									System.out.println("checking for first time");
									colnum = cell.getColumnIndex();
									System.out.println("breaking at col no -> "+colnum);
									break;
								}
							}

						} else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
						}
					}
					// end iterating a row, add all the elements of a row in list
					if (colnum != 0) {
						// getting selected column of match found for specific column name
						Cell cell1 = row.getCell(colnum);

						try {
							if (Cell.CELL_TYPE_STRING == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									if (!cell1.getStringCellValue().trim().isEmpty()) {
										valuesArray.add(cell1.getStringCellValue());
									}
								}
							} else if (Cell.CELL_TYPE_NUMERIC == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									valuesArray.add("" + cell1.getNumericCellValue());
								}
							}
						} catch (Exception e) {
							System.out.println("numeric value not found or null value found ");

						}
					}

				}

				System.out.println("List value  -->>" + valuesArray.toString());
				// removing column name from list
				valuesArray.remove(discountColumnName);

				System.out.println("  final list >>  " + valuesArray.toString());
				SumOfValues = 0.0;
				Iterator iter = valuesArray.iterator();
				int count = 0;
				while (valuesArray.size() > count) {
					SumOfValues += Double.parseDouble(valuesArray.get(count).toString());

					count++;
				}
				System.out.println("  resultss >>  " + SumOfValues);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		DecimalFormat formatter = new DecimalFormat("#.0");
		Double Roundedvalue = Double.parseDouble(formatter.format(SumOfValues));
		return Roundedvalue;
	}
	
	public static Double readExcelDTRSNetAmount(String filePath, String sheetName) {
		Double SumOfValues = 0.00;
		List<List<String>> ret = new ArrayList();
		List<String> valuesArray = new ArrayList();
		if (filePath != null && !"".equals(filePath.trim()) && sheetName != null && !"".equals(sheetName.trim())) {
			try {
				/* First need to open the file. */
				FileInputStream fInputStream = new FileInputStream(filePath.trim());

				/* Create the workbook object. */
				Workbook excelWookBook = new XSSFWorkbook(fInputStream);

				/* Get the sheet by name. */
				Sheet employeeSheet = excelWookBook.getSheet(sheetName);

				System.out.println("inside excel reader");
				Sheet sheet = excelWookBook.getSheet(sheetName);
				Iterator rowIterator = sheet.iterator();
				/* Defining column name which needs to find in excel */
				String discountColumnName = "Net Amount";
				// iterating over each row
				int colnum = -1;
				while (rowIterator.hasNext()) {

					Row row = (Row) rowIterator.next();
					Iterator cellIterator = row.cellIterator();

					// Iterating over each cell (column wise) in a particular row.
					while (cellIterator.hasNext()) {

						Cell cell = (org.apache.poi.ss.usermodel.Cell) cellIterator.next();
						// The Cell Containing String will is name.
						if (Cell.CELL_TYPE_STRING == cell.getCellType()) {

							// checking value with column name if matches Column Number to be saved other
							// wise ignored
							if (cell.getStringCellValue().trim().equalsIgnoreCase(discountColumnName)) {
								System.out.println("row number - " + row.getRowNum() + "  col no = " + colnum);
								if (colnum == -1) {
									System.out.println("checking for first time");
									colnum = cell.getColumnIndex();
									System.out.println("breaking at col no -> "+colnum);
									break;
								}
							}

						} else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
						}
					}
					// end iterating a row, add all the elements of a row in list
					if (colnum != 0) {
						// getting selected column of match found for specific column name
						Cell cell1 = row.getCell(colnum);

						try {
							if (Cell.CELL_TYPE_STRING == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									if (!cell1.getStringCellValue().trim().isEmpty()) {
										valuesArray.add(cell1.getStringCellValue());
									}
								}
							} else if (Cell.CELL_TYPE_NUMERIC == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									valuesArray.add("" + cell1.getNumericCellValue());
								}
							}
						} catch (Exception e) {
							System.out.println("numeric value not found or null value found ");

						}
					}

				}

				System.out.println("List value  -->>" + valuesArray.toString());
				// removing column name from list
				valuesArray.remove(discountColumnName);

				System.out.println("  final list >>  " + valuesArray.toString());
				SumOfValues = 0.0;
				Iterator iter = valuesArray.iterator();
				int count = 0;
				while (valuesArray.size() > count) {
					SumOfValues += Double.parseDouble(valuesArray.get(count).toString());

					count++;
				}
				System.out.println("  resultss >>  " + SumOfValues);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		DecimalFormat formatter = new DecimalFormat("#.0");
		Double Roundedvalue = Double.parseDouble(formatter.format(SumOfValues));
		return Roundedvalue;
	}

	public static Double readExcelUserWiseCollectionDiscount(String filePath, String sheetName) {
		Double SumOfValues = 0.00;
		List<List<String>> ret = new ArrayList();
		List<String> valuesArray = new ArrayList();
		if (filePath != null && !"".equals(filePath.trim()) && sheetName != null && !"".equals(sheetName.trim())) {
			try {
				/* First need to open the file. */
				FileInputStream fInputStream = new FileInputStream(filePath.trim());

				/* Create the workbook object. */
				Workbook excelWookBook = new XSSFWorkbook(fInputStream);

				/* Get the sheet by name. */
				Sheet employeeSheet = excelWookBook.getSheet(sheetName);

				System.out.println("inside excel reader");
				Sheet sheet = excelWookBook.getSheet(sheetName);
				Iterator rowIterator = sheet.iterator();
				/* Defining column name which needs to find in excel */
				String discountColumnName = "Discount";
				// iterating over each row
				int colnum = -1;
				while (rowIterator.hasNext()) {

					Row row = (Row) rowIterator.next();
					Iterator cellIterator = row.cellIterator();

					// Iterating over each cell (column wise) in a particular row.
					while (cellIterator.hasNext()) {

						Cell cell = (org.apache.poi.ss.usermodel.Cell) cellIterator.next();
						// The Cell Containing String will is name.
						if (Cell.CELL_TYPE_STRING == cell.getCellType()) {

							// checking value with column name if matches Column Number to be saved other
							// wise ignored
							if (cell.getStringCellValue().trim().equalsIgnoreCase(discountColumnName)) {
								System.out.println("row number - " + row.getRowNum() + "  col no = " + colnum);
								if (colnum == -1) {
									System.out.println("checking for first time");
									colnum = cell.getColumnIndex();
									System.out.println("breaking at col no -> "+colnum);
									break;
								}
							}

						} else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
						}
					}
					// end iterating a row, add all the elements of a row in list
					if (colnum != 0) {
						// getting selected column of match found for specific column name
						Cell cell1 = row.getCell(colnum);

						try {
							if (Cell.CELL_TYPE_STRING == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									if (!cell1.getStringCellValue().trim().isEmpty()) {
										valuesArray.add(cell1.getStringCellValue());
									}
								}
							} else if (Cell.CELL_TYPE_NUMERIC == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									valuesArray.add("" + cell1.getNumericCellValue());
								}
							}
						} catch (Exception e) {
							System.out.println("numeric value not found or null value found ");

						}
					}

				}

				System.out.println("List value  -->>" + valuesArray.toString());
				// removing column name from list
				valuesArray.remove(discountColumnName);

				System.out.println("  final list >>  " + valuesArray.toString());
				SumOfValues = 0.0;
				Iterator iter = valuesArray.iterator();
				int count = 0;
				while (valuesArray.size() > count) {
					SumOfValues += Double.parseDouble(valuesArray.get(count).toString());

					count++;
				}
				System.out.println("  resultss >>  " + SumOfValues);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		DecimalFormat formatter = new DecimalFormat("#.0");
		Double Roundedvalue = Double.parseDouble(formatter.format(SumOfValues));
		return Roundedvalue;
	}
	
	
	public static Double readExcelDSDDiscount(String filePath, String sheetName, String columnName) {
		Double SumOfValues = 0.00;
		List<List<String>> ret = new ArrayList();
		List<String> valuesArray = new ArrayList();
		if (filePath != null && !"".equals(filePath.trim()) && sheetName != null && !"".equals(sheetName.trim())) {
			try {
				/* First need to open the file. */
				FileInputStream fInputStream = new FileInputStream(filePath.trim());

				/* Create the workbook object. */
				Workbook excelWookBook = new XSSFWorkbook(fInputStream);

				/* Get the sheet by name. */
				Sheet employeeSheet = excelWookBook.getSheet(sheetName);

				System.out.println("inside excel reader");
				Sheet sheet = excelWookBook.getSheet(sheetName);
				Iterator rowIterator = sheet.iterator();
				/* Defining column name which needs to find in excel */
				String discountColumnName = columnName;
				// iterating over each row
				int colnum = -1;
				while (rowIterator.hasNext()) {

					Row row = (Row) rowIterator.next();
					Iterator cellIterator = row.cellIterator();

					// Iterating over each cell (column wise) in a particular row.
					while (cellIterator.hasNext()) {

						Cell cell = (org.apache.poi.ss.usermodel.Cell) cellIterator.next();
						// The Cell Containing String will is name.
						if (Cell.CELL_TYPE_STRING == cell.getCellType()) {

							// checking value with column name if matches Column Number to be saved other
							// wise ignored
							if (cell.getStringCellValue().trim().equalsIgnoreCase(discountColumnName)) {
								System.out.println("row number - " + row.getRowNum() + "  col no = " + colnum);
								if (colnum == -1) {
									System.out.println("checking for first time");
									colnum = cell.getColumnIndex();
									System.out.println("breaking at col no -> "+colnum);
									break;
								}
							}

						} else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
						}
					}
					// end iterating a row, add all the elements of a row in list
					if (colnum != 0) {
						// getting selected column of match found for specific column name
						Cell cell1 = row.getCell(colnum);

						try {
							if (Cell.CELL_TYPE_STRING == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									if (!cell1.getStringCellValue().trim().isEmpty()) {
										valuesArray.add(cell1.getStringCellValue());
									}
								}
							} else if (Cell.CELL_TYPE_NUMERIC == cell1.getCellType()) {
								if (cell1.getStringCellValue() != null) {
									valuesArray.add("" + cell1.getNumericCellValue());
								}
							}
						} catch (Exception e) {
							System.out.println("numeric value not found or null value found ");

						}
					}

				}

				System.out.println("List value  -->>" + valuesArray.toString());
				// removing column name from list
				valuesArray.remove(discountColumnName);

				System.out.println("  final list >>  " + valuesArray.toString());
				SumOfValues = 0.0;
				Iterator iter = valuesArray.iterator();
				int count = 0;
				while (valuesArray.size() > count) {
					SumOfValues += Double.parseDouble(valuesArray.get(count).toString());

					count++;
				}
				System.out.println("  resultss >>  " + SumOfValues);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		DecimalFormat formatter = new DecimalFormat("#.0");
		Double Roundedvalue = Double.parseDouble(formatter.format(SumOfValues));
		return Roundedvalue;
	}

	
}
