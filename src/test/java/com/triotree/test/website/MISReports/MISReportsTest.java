package com.triotree.test.website.MISReports;

import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.test.base.ResultListener;
import com.triotree.test.website.TTWebsiteBaseTest;
import com.triotree.test.website.FrontOffice.PatientRegistrationTest;
import com.triotree.utils.CommonUtils;
import com.triotree.utils.ExcelReader;
import com.triotree.utils.ExcelWriter;
import com.triotree.website.pages.CommonPages.HISHomePage;
import com.triotree.website.pages.FrontOffice.FrontOfficeHomePage;
import com.triotree.website.pages.FrontOffice.PatientRegistrationPage;
import com.triotree.website.pages.Reports.DepartmentWiseSubDepartmentWiseRevenuePage;
import com.triotree.website.pages.Reports.IpDiscountReportPage;
import com.triotree.website.pages.Reports.OpDiscoutReportPage;
import com.triotree.website.pages.Reports.ReportPDFPage;

@Listeners(ResultListener.class)
public class MISReportsTest extends TTWebsiteBaseTest{

	private static final Logger logger = LogManager
			.getLogger(PatientRegistrationTest.class.getName());

	private HISHomePage hisHomePage;
	private FrontOfficeHomePage frontOfficeHomePage;
	private PatientRegistrationPage patientRegistrationPage;
	private DepartmentWiseSubDepartmentWiseRevenuePage departmentWiseSubDepartmentWiseRevenuePage;
	private ReportPDFPage reportPDFPage;
	private OpDiscoutReportPage opDiscoutReportPage;
	private IpDiscountReportPage ipDiscoutReportPage;
	private String patientRegistrationId = "RAJH.17154736";
	private String desc = null;
	private String title1 = null;
	private String desc1 = null;


	@Test(priority = 1) //fixed 02-06-2020---------------------
	public void patientRegistrationValidDataTest() throws Throwable {
		test=extent.createTest("patientRegistrationValidDataTest", "This test case verify the Patient Registration Valid Data Test Case");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnNo("IT");
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");
		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButton();	
		departmentWiseSubDepartmentWiseRevenuePage.clickOverAllSummaryButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateAs1StDate();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnPreviewButton();
		//assertTrue(reportPDFPage.isGrossAmountColumnDisplayed(), "Gross Amount Column is not displayed in Reports PDF");
		//assertTrue(reportPDFPage.isDiscountAmountColumnDisplayed(), "Discount Amount Column is not displayed in Reports PDF");
		//assertTrue(reportPDFPage.isNetAmountColumnDisplayed(), "Net Amount Column is not displayed in Reports PDF");
		//reportPDFPage.closeReportButton();
		departmentWiseSubDepartmentWiseRevenuePage.clickSummaryButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateAs1StDate();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnPreviewButton();

		// TO DO 
	}


	@Test(priority = 2) //not fixed 13-04-2020
	public void misDSDAndUserWiseCollectionAndIpDiscountReportTest() throws Throwable {
		test=extent.createTest("misDSDAndUserWiseCollectionAndIpDiscountReportTest", "This test case verify the mis DSD And User Wise Collection And Ip Discount Report Test Case");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);


		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");
		frontOfficeHomePage.expandMenu();

		//Geeting Discount Amount From IP Discount Report

		frontOfficeHomePage.clickOnIPThenBillingAndSelectAnOption("IP Discount Report");
		ipDiscoutReportPage.enterFromDate("01/Jun/2020");
		ipDiscoutReportPage.clickOnCSVButton();
		//Thread.sleep(10000);
		Thread.sleep(7000);
		File currentDirectory = new File(new File(".").getAbsolutePath());

		//Create Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"IP Discount Report Excel.xlsx"));

		//write operation workbook using file out object
		workbook.write(out);
		out.close();

		// Converting CSV to Excel File
		File myFile = new File(currentDirectory.getCanonicalPath() + "/Downloads/IP Discount Report.csv");
		ExcelWriter writer = new ExcelWriter();
		writer.setExcelFile(System.getProperty("user.dir")+"IP Discount Report Excel.xlsx");
		Thread.sleep(2000);
		try (FileInputStream fileInputStream = new FileInputStream(myFile);) {

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));) {
				XSSFSheet sheet = writer.createSheet("IP Discount");
				int i = 0;
				Iterator<String> ite = reader.lines().iterator();
				while (ite.hasNext()) {

					i = i + 1;
					XSSFRow row = writer.createRow(i);
					String[] strCollection = ite.next().split(",");

					for (int j = 0; j < strCollection.length; j++)
						row.createCell(j).setCellValue(strCollection[j]);
				}
				writer.write();
				System.out.println("Migration completed");
			}
		}

		Double sumOfDiscountValueFromIPReport = ExcelReader.readExcelIpDiscount(System.getProperty("user.dir")+"IP Discount Report Excel.xlsx", "IP Discount");
		System.out.println("sumOfDiscountValueFromIPReport"+sumOfDiscountValueFromIPReport);

		CommonUtils.saveDownloadedExcel("IP Discount Report Excel");

		//Delete Summary Report Excel File and CSV File

		File excelFile = new File(System.getProperty("user.dir")+"IP Discount Report Excel.xlsx");
		excelFile.delete();
		File csvFile = new File(currentDirectory.getCanonicalPath() + "/Downloads/IP Discount Report.csv");
		csvFile.delete();

		//Getting Discount Amount From DSD Report

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButton();	
		departmentWiseSubDepartmentWiseRevenuePage.clickSummaryButton();	
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButton();
		Thread.sleep(7000);

		//Create Blank workbook
//		XSSFWorkbook workbook1 = new XSSFWorkbook();
//		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));
//
//		//write operation workbook using file out object
//		workbook1.write(out1);
//		out1.close();
//
//		// Converting CSV to Excel File
//		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Department Wise SubDepartment Wise Revenue.csv");
//		ExcelWriter writer1 = new ExcelWriter();
//		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
//		Thread.sleep(6000);
//		try(FileInputStream fileInputStream1 = new FileInputStream(myFile1);)
//		{
//			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
//				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
//				int i = 0;
//				Iterator<String> ite1 = reader1.lines().iterator();
//				while (ite1.hasNext()) {
//
//					i = i + 1;
//					XSSFRow row1 = writer1.createRow(i);
//					String[] strCollection1 = ite1.next().split(",");
//
//					for (int j = 0; j < strCollection1.length; j++)
//						row1.createCell(j).setCellValue(strCollection1[j]);
//				}
//				try {
//					writer1.write();
//				}
//				catch (Exception e) {
//				}
//				System.out.println("Migration completed");
//			}
//
//		}
//		Double sumOfDiscountValueFromDSD = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W");
//		System.out.println("sumOfDiscountValueFromDSD"+sumOfDiscountValueFromDSD);
//
//		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise Revenue");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Department Wise SubDepartment Wise Revenue.csv");
		csvFile1.delete();
	}


	@Test(priority = 3) //fixed 1-06-2020
	public void misOpDiscountReportAndDSDReportTest() throws Throwable {
		test=extent.createTest("misOpDiscountReportAndDSDReportTest", "This test case verify the misOp Discount Report And DSD Report Test Case");
		test.assignCategory("MIS Report");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");
		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnOPThenBillingAndSelectAnOption("OP Discount Report");
		opDiscoutReportPage.clickSummaryButton();
		opDiscoutReportPage.enterFromDate("01/Apr/2020");
		opDiscoutReportPage.clickOnCSVButton();
		Thread.sleep(10000);

		File currentDirectory = new File(new File(".").getAbsolutePath());

		//Create Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"OP Discount Report Excel.xlsx"));

		//write operation workbook using file out object
		workbook.write(out);
		out.close();


		// Converting CSV to Excel File
		File myFile = new File(currentDirectory.getCanonicalPath() + "/Downloads/OP Discount Report.csv");
		ExcelWriter writer = new ExcelWriter();
		writer.setExcelFile(System.getProperty("user.dir")+"OP Discount Report Excel.xlsx");

		try (FileInputStream fileInputStream = new FileInputStream(myFile);) {

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));) {
				XSSFSheet sheet = writer.createSheet("OP Discount");
				int i = 0;
				Iterator<String> ite = reader.lines().iterator();
				while (ite.hasNext()) {

					i = i + 1;
					XSSFRow row = writer.createRow(i);
					String[] strCollection = ite.next().split(",");

					for (int j = 0; j < strCollection.length; j++)
						row.createCell(j).setCellValue(strCollection[j]);
				}
				writer.write();
				System.out.println("Migration completed");
			}

		}


		Double sumOfDiscountValueFromSummaryReport = ExcelReader.readExcelOpDiscount(System.getProperty("user.dir")+"OP Discount Report Excel.xlsx", "OP Discount");
		System.out.println("sumOfDiscountValue"+sumOfDiscountValueFromSummaryReport);

		CommonUtils.saveDownloadedExcel("OP Discount Report Excel");

		//Delete Summary Report Excel File and CSV File

		File excelFile = new File(System.getProperty("user.dir")+"OP Discount Report Excel.xlsx");
		excelFile.delete();
		File csvFile = new File(currentDirectory.getCanonicalPath() + "/Downloads/OP Discount Report.csv");
		csvFile.delete();


		//Getting Discount Amount From DSD Report

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickOPRadioButton();	
		departmentWiseSubDepartmentWiseRevenuePage.clickSummaryButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Apr/2020");
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButton();
		Thread.sleep(35000);

		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Department Wise SubDepartment Wise Revenue.csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W");
		System.out.println("sumOfDiscountValueFromDSD"+sumOfDiscountValueFromDSD);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Department Wise SubDepartment Wise Revenue.csv");
		csvFile1.delete();

		///Assert.assertEquals(sumOfDiscountValueFromSummaryReport, sumOfDiscountValueFromDSD, "Discount Amount of Sumary Report and DSD Report is not matching");
	}


	@Test(priority = 4) //not fixed 13-04-2020 
	public void misDsdMatchWithDeptWiseTestAndRevenueReportForIpEpisodeTest() throws Throwable {

		test=extent.createTest("misDsdMatchWithDeptWiseTestAndRevenueReportForIpEpisodeTest", "This test case verify the mis Dsd Match With DeptWise Test And Revenue Report For Ip Episode Test Case");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");
		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("16/Jul/2019");
		//		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("Select");
		//		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButton();

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButton();

		Thread.sleep(40000);


		File currentDirectory = new File(new File(".").getAbsolutePath());

		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Department Wise SubDepartment Wise Revenue.csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) 
		{
			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				//fileInputStream1.close();
				System.out.println("Migration completed");
			}
		}
		Double sumOfDiscountValueFromDSD = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W");
		System.out.println("sumOfDiscountValueFromDSD"+sumOfDiscountValueFromDSD);
		Double sumOfGrossValueFromDSD = ExcelReader.readExcelDSDGrossAmount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W");
		System.out.println("sumOfGrossValueFromDSD"+sumOfGrossValueFromDSD);
		Double sumOfNetValueFromDSD = ExcelReader.readExcelDSDNetAmount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W");
		System.out.println("sumOfNetValueFromDSD"+sumOfNetValueFromDSD);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Department Wise SubDepartment Wise Revenue.csv");
		csvFile1.delete();


		//Getting Amount from Department Wise Test and Revenue Report

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Test And Revenue");
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromDepartmentWiseTestAndRevenueReport("16/Jul/2019");
		departmentWiseSubDepartmentWiseRevenuePage.selectFacilityFromDepartmentWiseTestAndRevenueReport("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.selectAllServicesFromDepartmentWiseTestAndRevenueReport();
		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButtonFromDepartmentWiseTestAndRevenueReport();

		//Thread.sleep(35000);
		Thread.sleep(30000);
		//Create Blank workbook
		XSSFWorkbook workbook3 = new XSSFWorkbook();
		FileOutputStream out3 = new FileOutputStream(new File(System.getProperty("user.dir")+"'Departmentwise Test Revenue Summary For IP Report'.xlsx"));

		//write operation workbook using file out object
		workbook3.write(out3);
		out3.close();


		// Converting CSV to Excel File
		File myFile3 = new File(currentDirectory.getCanonicalPath() + "/Downloads/'Departmentwise Test Revenue Summary For IP Report'.csv");
		ExcelWriter writer3 = new ExcelWriter();
		writer3.setExcelFile(System.getProperty("user.dir")+"'Departmentwise Test Revenue Summary For IP Report'.xlsx");

		try (FileInputStream fileInputStream3 = new FileInputStream(myFile3);) {

			try (BufferedReader reader3 = new BufferedReader(new InputStreamReader(fileInputStream3));) {
				XSSFSheet sheet3 = writer3.createSheet("Departmentwise Test Revenue");
				int i = 0;
				Iterator<String> ite3 = reader3.lines().iterator();
				while (ite3.hasNext()) {

					i = i + 1;
					XSSFRow row3 = writer3.createRow(i);
					String[] strCollection3 = ite3.next().split(",");

					for (int j = 0; j < strCollection3.length; j++)
						row3.createCell(j).setCellValue(strCollection3[j]);
				}
				writer3.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfGrossAmoutFromDTRS = ExcelReader.readExcelDTRSGross(System.getProperty("user.dir")+"'Departmentwise Test Revenue Summary For IP Report'.xlsx", "Departmentwise Test Revenue");
		System.out.println("sumOfGrossAmoutFromDTRS"+sumOfGrossAmoutFromDTRS);
		Double sumOfDiscountAmoutFromDTRS = ExcelReader.readExcelDTRSDiscount(System.getProperty("user.dir")+"'Departmentwise Test Revenue Summary For IP Report'.xlsx", "Departmentwise Test Revenue");
		System.out.println("sumOfDiscountAmoutFromDTRS"+sumOfDiscountAmoutFromDTRS);
		Double sumOfNetAmoutFromDTRS = ExcelReader.readExcelDTRSNetAmount(System.getProperty("user.dir")+"'Departmentwise Test Revenue Summary For IP Report'.xlsx", "Departmentwise Test Revenue");
		System.out.println("sumOfNetAmoutFromDTRS"+sumOfNetAmoutFromDTRS);

		CommonUtils.saveDownloadedExcel("Department Wise Test Revenue Summary for IP");

		//Delete Summary Report Excel File and CSV File

		File excelFile3 = new File(System.getProperty("user.dir")+"Departmentwise Test Revenue Summary For IP Report.xlsx");
		excelFile3.delete();
		File csvFile3 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Departmentwise Test Revenue Summary For IP Report.csv");
		csvFile3.delete();

		Assert.assertEquals(sumOfDiscountValueFromDSD, sumOfDiscountAmoutFromDTRS, "Discount  Amount of DSD Report and Deprtment Wise Test Revenue Report is not matching");
		Assert.assertEquals(sumOfGrossValueFromDSD, sumOfGrossAmoutFromDTRS, "Gross  Amount of DSD Report and Deprtment Wise Test Revenue Report is not matching");
		Assert.assertEquals(sumOfNetValueFromDSD, sumOfNetAmoutFromDTRS, "Net  Amount of DSD Report and Deprtment Wise Test Revenue Report is not matching");
	}


	@Test(priority = 5) // pass and fixed 03-06-2020
	public void misUserWiseCollectionReportTest() throws Throwable {

		test=extent.createTest("misUserWiseCollectionReportTest", "This test case verify the mis User Wise Collection Report Test Case");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);
		File currentDirectory = new File(new File(".").getAbsolutePath());
		String downloadPath = System.getProperty("user.dir")+"/Downloads";

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");
		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("User Wise Collection Report");

		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromUserWiseCollectionReport("01-Jul-2019 06:05:01");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDateFromUserWiseCollectionReport("31-Jul-2019 23:59:59");
		departmentWiseSubDepartmentWiseRevenuePage.clickOPRadioButtonFromUserWiseCollectionReport();
		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButtonFromDepartmentWiseTestAndRevenueReport();
		Thread.sleep(40000);


		Assert.assertFalse(departmentWiseSubDepartmentWiseRevenuePage.isFileDownloaded(downloadPath, "User Wise Collection Report"), "User Wise Collection Report is not downloaded");
		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"User Wise Collection Report.csv");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/User Wise Collection Report.csv");
		csvFile1.delete();


		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("User Wise Collection Report");

		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromUserWiseCollectionReport("01-Jul-2019 06:05:01");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDateFromUserWiseCollectionReport("31-Jul-2019 23:59:59");
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButtonFromUserWiseCollectionReport();
		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButtonFromDepartmentWiseTestAndRevenueReport();
		Thread.sleep(40000);


		Assert.assertFalse(departmentWiseSubDepartmentWiseRevenuePage.isFileDownloaded(downloadPath, "User Wise Collection Report"), "User Wise Collection Report is not downloaded");

		CommonUtils.saveDownloadedExcel("User Wise Collection Report");

		//Delete Summary Report Excel File and CSV File

		File excelFile2 = new File(System.getProperty("user.dir")+"User Wise Collection Report.csv");
		excelFile2.delete();
		File csvFile2 = new File(currentDirectory.getCanonicalPath() + "/Downloads/User Wise Collection Report.csv");
		csvFile2.delete();

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("User Wise Collection Report");

		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromUserWiseCollectionReport("01-Jul-2019 06:05:01");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDateFromUserWiseCollectionReport("31-Jul-2019 23:59:59");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButtonFromUserWiseCollectionReport();
		departmentWiseSubDepartmentWiseRevenuePage.selectSummaryRadioButtonFromUserWiseCollectionReport();
		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButtonFromDepartmentWiseTestAndRevenueReport();
		Thread.sleep(40000);


		Assert.assertFalse(departmentWiseSubDepartmentWiseRevenuePage.isFileDownloaded(downloadPath, "User Wise Collection Report"), "User Wise Collection Report is not downloaded");
		//Delete Summary Report Excel File and CSV File



		File excelFile3 = new File(System.getProperty("user.dir")+"User Wise Collection Report.csv");
		excelFile3.delete();
		File csvFile3 = new File(currentDirectory.getCanonicalPath() + "/Downloads/User Wise Collection Report.csv");
		csvFile3.delete();

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("User Wise Collection Report");

		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromUserWiseCollectionReport("01-Jul-2019 06:05:01");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDateFromUserWiseCollectionReport("31-Jul-2019 23:59:59");
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButtonFromUserWiseCollectionReport();
		departmentWiseSubDepartmentWiseRevenuePage.selectWithScrollNoCheckboxFromUserWiseCollectionReport();

		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButtonFromDepartmentWiseTestAndRevenueReport();
		//Thread.sleep(40000);
		Thread.sleep(40000);

		Assert.assertFalse(departmentWiseSubDepartmentWiseRevenuePage.isFileDownloaded(downloadPath, "User Wise Collection Report"), "User Wise Collection Report is not downloaded");
		//Delete Summary Report Excel File and CSV File


		File excelFile4 = new File(System.getProperty("user.dir")+"User Wise Collection Report.csv");
		excelFile4.delete();
		File csvFile4 = new File(currentDirectory.getCanonicalPath() + "/Downloads/User Wise Collection Report.csv");
		csvFile4.delete();


		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("User Wise Collection Report");

		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromUserWiseCollectionReport("01-Jul-2019 06:05:01");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDateFromUserWiseCollectionReport("31-Jul-2019 23:59:59");
		departmentWiseSubDepartmentWiseRevenuePage.selectPharmacyRadioButtonFromUserWiseCollectionReport();
		departmentWiseSubDepartmentWiseRevenuePage.selectSummaryRadioButtonFromUserWiseCollectionReport();


		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButtonFromDepartmentWiseTestAndRevenueReport();
		Thread.sleep(40000);

		Assert.assertFalse(departmentWiseSubDepartmentWiseRevenuePage.isFileDownloaded(downloadPath, "User Wise Collection Report"), "User Wise Collection Report is not downloaded");
		//Delete Summary Report Excel File and CSV File

		File excelFile5 = new File(System.getProperty("user.dir")+"User Wise Collection Report.csv");
		excelFile5.delete();
		File csvFile5 = new File(currentDirectory.getCanonicalPath() + "/Downloads/User Wise Collection Report.csv");
		csvFile5.delete();


		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("User Wise Collection Report");

		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromUserWiseCollectionReport("01-Jul-2019 06:05:01");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDateFromUserWiseCollectionReport("31-Jul-2019 23:59:59");
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButtonFromUserWiseCollectionReport();
		departmentWiseSubDepartmentWiseRevenuePage.selectWithScrollNoCheckboxFromUserWiseCollectionReport();

		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButtonFromDepartmentWiseTestAndRevenueReport();
		//Thread.sleep(40000);
		Thread.sleep(40000);

		Assert.assertFalse(departmentWiseSubDepartmentWiseRevenuePage.isFileDownloaded(downloadPath, "User Wise Collection Report"), "User Wise Collection Report is not downloaded");
		//Delete Summary Report Excel File and CSV File

		File excelFile6 = new File(System.getProperty("user.dir")+"User Wise Collection Report.csv");
		excelFile6.delete();
		File csvFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/User Wise Collection Report.csv");
		csvFile6.delete();


		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("User Wise Collection Report");

		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromUserWiseCollectionReport("01-Jul-2019 06:05:01");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDateFromUserWiseCollectionReport("31-Jul-2019 23:59:59");
		departmentWiseSubDepartmentWiseRevenuePage.selectErButtonFromUserWiseCollectionReport();		
		departmentWiseSubDepartmentWiseRevenuePage.selectSummaryRadioButtonFromUserWiseCollectionReport();

		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButtonFromDepartmentWiseTestAndRevenueReport();
		Thread.sleep(40000);


		Assert.assertFalse(departmentWiseSubDepartmentWiseRevenuePage.isFileDownloaded(downloadPath, "User Wise Collection Report"), "User Wise Collection Report is not downloaded");
		//Delete Summary Report Excel File and CSV File

		File excelFile7 = new File(System.getProperty("user.dir")+"User Wise Collection Report.csv");
		excelFile7.delete();
		File csvFile7 = new File(currentDirectory.getCanonicalPath() + "/Downloads/User Wise Collection Report.csv");
		csvFile7.delete();


		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("User Wise Collection Report");

		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromUserWiseCollectionReport("01-Jul-2019 06:05:01");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDateFromUserWiseCollectionReport("31-Jul-2019 23:59:59");
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButtonFromUserWiseCollectionReport();		
		departmentWiseSubDepartmentWiseRevenuePage.selectWithScrollNoCheckboxFromUserWiseCollectionReport();

		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButtonFromDepartmentWiseTestAndRevenueReport();
		Thread.sleep(30000);


		Assert.assertFalse(departmentWiseSubDepartmentWiseRevenuePage.isFileDownloaded(downloadPath, "User Wise Collection Report"), "User Wise Collection Report is not downloaded");
		//Delete Summary Report Excel File and CSV File

		File excelFile8 = new File(System.getProperty("user.dir")+"User Wise Collection Report.csv");
		excelFile8.delete();
		File csvFile8 = new File(currentDirectory.getCanonicalPath() + "/Downloads/User Wise Collection Report.csv");
		csvFile8.delete();

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("User Wise Collection Report");

		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromUserWiseCollectionReport("01-Jul-2019 06:05:01");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDateFromUserWiseCollectionReport("31-Jul-2019 23:59:59");
		departmentWiseSubDepartmentWiseRevenuePage.selectErButtonFromUserWiseCollectionReport();	
		departmentWiseSubDepartmentWiseRevenuePage.selectSummaryRadioButtonFromUserWiseCollectionReport();

		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButtonFromDepartmentWiseTestAndRevenueReport();
		Thread.sleep(30000);


		Assert.assertFalse(departmentWiseSubDepartmentWiseRevenuePage.isFileDownloaded(downloadPath, "User Wise Collection Report"), "User Wise Collection Report is not downloaded");
		//Delete Summary Report Excel File and CSV File

		File excelFile9 = new File(System.getProperty("user.dir")+"User Wise Collection Report.csv");
		excelFile9.delete();
		File csvFile9 = new File(currentDirectory.getCanonicalPath() + "/Downloads/User Wise Collection Report.csv");
		csvFile9.delete();


		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("User Wise Collection Report");

		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromUserWiseCollectionReport("01-Jul-2019 06:05:01");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDateFromUserWiseCollectionReport("31-Jul-2019 23:59:59");
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButtonFromUserWiseCollectionReport();	
		departmentWiseSubDepartmentWiseRevenuePage.selectWithScrollNoCheckboxFromUserWiseCollectionReport();

		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButtonFromDepartmentWiseTestAndRevenueReport();
		Thread.sleep(30000);


		Assert.assertFalse(departmentWiseSubDepartmentWiseRevenuePage.isFileDownloaded(downloadPath, "User Wise Collection Report"), "User Wise Collection Report is not downloaded");
		//Delete Summary Report Excel File and CSV File

		File excelFile10 = new File(System.getProperty("user.dir")+"User Wise Collection Report.csv");
		excelFile10.delete();
		File csvFile10 = new File(currentDirectory.getCanonicalPath() + "/Downloads/User Wise Collection Report.csv");
		csvFile10.delete();


		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("User Wise Collection Report");

		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromUserWiseCollectionReport("01-Jul-2019 06:05:01");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDateFromUserWiseCollectionReport("31-Jul-2019 23:59:59");
		departmentWiseSubDepartmentWiseRevenuePage.selectAllRadioButtonFromUserWiseCollectionReport();	
		departmentWiseSubDepartmentWiseRevenuePage.selectSummaryRadioButtonFromUserWiseCollectionReport();

		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButtonFromDepartmentWiseTestAndRevenueReport();
		Thread.sleep(30000);


		Assert.assertFalse(departmentWiseSubDepartmentWiseRevenuePage.isFileDownloaded(downloadPath, "User Wise Collection Report"), "User Wise Collection Report is not downloaded");
		//Delete Summary Report Excel File and CSV File

		File excelFile11 = new File(System.getProperty("user.dir")+"User Wise Collection Report.csv");
		excelFile11.delete();
		File csvFile11 = new File(currentDirectory.getCanonicalPath() + "/Downloads/User Wise Collection Report.csv");
		csvFile11.delete();


		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("User Wise Collection Report");

		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromUserWiseCollectionReport("01-Jul-2019 06:05:01");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDateFromUserWiseCollectionReport("31-Jul-2019 23:59:59");
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButtonFromUserWiseCollectionReport();

		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButtonFromDepartmentWiseTestAndRevenueReport();
		Thread.sleep(30000);


		Assert.assertFalse(departmentWiseSubDepartmentWiseRevenuePage.isFileDownloaded(downloadPath, "User Wise Collection Report"), "User Wise Collection Report is not downloaded");
		//Delete Summary Report Excel File and CSV File

		File excelFile12 = new File(System.getProperty("user.dir")+"User Wise Collection Report.csv");
		excelFile12.delete();
		File csvFile12 = new File(currentDirectory.getCanonicalPath() + "/Downloads/User Wise Collection Report.csv");
		csvFile12.delete();


		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("User Wise Collection Report");

		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromUserWiseCollectionReport("01-Jul-2019 06:05:01");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDateFromUserWiseCollectionReport("31-Jul-2019 23:59:59");
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButtonFromUserWiseCollectionReport();

		departmentWiseSubDepartmentWiseRevenuePage.selectWithScrollNoCheckboxFromUserWiseCollectionReport();
		Thread.sleep(30000);


		Assert.assertFalse(departmentWiseSubDepartmentWiseRevenuePage.isFileDownloaded(downloadPath, "User Wise Collection Report"), "User Wise Collection Report is not downloaded");
		//Delete Summary Report Excel File and CSV File

		File excelFile13 = new File(System.getProperty("user.dir")+"User Wise Collection Report.csv");
		excelFile13.delete();
		File csvFile13 = new File(currentDirectory.getCanonicalPath() + "/Downloads/User Wise Collection Report.csv");
		csvFile13.delete();


		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("User Wise Collection Report");

		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromUserWiseCollectionReport("01-Jul-2019 06:05:01");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDateFromUserWiseCollectionReport("31-Jul-2019 23:59:59");
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButtonFromUserWiseCollectionReport();

		departmentWiseSubDepartmentWiseRevenuePage.selectWithCommonScrollNoCheckboxFromUserWiseCollectionReport();
		Thread.sleep(30000);


		Assert.assertFalse(departmentWiseSubDepartmentWiseRevenuePage.isFileDownloaded(downloadPath, "User Wise Collection Report"), "User Wise Collection Report is not downloaded");
		//Delete Summary Report Excel File and CSV File

		File excelFile14 = new File(System.getProperty("user.dir")+"User Wise Collection Report.csv");
		excelFile14.delete();
		File csvFile14 = new File(currentDirectory.getCanonicalPath() + "/Downloads/User Wise Collection Report.csv");
		csvFile14.delete();


	}

	@Test(priority = 6) //pass and fixed 04-06-2020
	public void misIpDiscountReportAndDsdReportAndUserWiseCollectionReportTest() throws Throwable {

		test=extent.createTest("misIpDiscountReportAndDsdReportAndUserWiseCollectionReportTest", "This test case verify the mis User Wise Collection Report Test Case");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);


		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");
		frontOfficeHomePage.expandMenu();

		//Getting Discount Amount From IP Discount Report

		frontOfficeHomePage.clickOnIPThenBillingAndSelectAnOption("IP Discount Report");
		ipDiscoutReportPage.enterFromDate("14/Jul/2019");
		ipDiscoutReportPage.clickOnCSVButton();
		Thread.sleep(10000);
		Thread.sleep(5000);
		File currentDirectory = new File(new File(".").getAbsolutePath());

		//Create Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"IP Discount Report Excel.xlsx"));

		//write operation workbook using file out object
		workbook.write(out);
		out.close();


		// Converting CSV to Excel File
		File myFile = new File(currentDirectory.getCanonicalPath() + "/Downloads/IP Discount Report.csv");
		ExcelWriter writer = new ExcelWriter();
		writer.setExcelFile(System.getProperty("user.dir")+"IP Discount Report Excel.xlsx");

		try (FileInputStream fileInputStream = new FileInputStream(myFile);) {

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));) {
				XSSFSheet sheet = writer.createSheet("IP Discount");
				int i = 0;
				Iterator<String> ite = reader.lines().iterator();
				while (ite.hasNext()) {

					i = i + 1;
					XSSFRow row = writer.createRow(i);
					String[] strCollection = ite.next().split(",");

					for (int j = 0; j < strCollection.length; j++)
						row.createCell(j).setCellValue(strCollection[j]);
				}
				writer.write();
				System.out.println("Migration completed");
			}

		}


		Double sumOfDiscountValueFromIPReport = ExcelReader.readExcelIpDiscount(System.getProperty("user.dir")+"IP Discount Report Excel.xlsx", "IP Discount");
		System.out.println("sumOfDiscountValueFromIPReport"+sumOfDiscountValueFromIPReport);

		CommonUtils.saveDownloadedExcel("IP Discount Report");

		//Delete Summary Report Excel File and CSV File

		File excelFile = new File(System.getProperty("user.dir")+"IP Discount Report Excel.xlsx");
		excelFile.delete();
		File csvFile = new File(currentDirectory.getCanonicalPath() + "/Downloads/IP Discount Report.csv");
		csvFile.delete();


		//Getting Discount Amount From DSD Report

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButton();	
		departmentWiseSubDepartmentWiseRevenuePage.clickSummaryButton();	
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButton();
		//Thread.sleep(25000);
		Thread.sleep(8000);
		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Department Wise SubDepartment Wise Revenue.csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W");
		System.out.println("sumOfDiscountValueFromDSD"+sumOfDiscountValueFromDSD);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Department Wise SubDepartment Wise Revenue.csv");
		csvFile1.delete();


		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("User Wise Collection Report");

		departmentWiseSubDepartmentWiseRevenuePage.enterFromDateFromUserWiseCollectionReport("14-Jul-2019 00:05:18");
		//		departmentWiseSubDepartmentWiseRevenuePage.enterToDateFromUserWiseCollectionReport("31-Jul-2019 23:59:59");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButtonFromUserWiseCollectionReport();
		departmentWiseSubDepartmentWiseRevenuePage.selectSummaryRadioButtonFromUserWiseCollectionReport();
		departmentWiseSubDepartmentWiseRevenuePage.clickOnCSVButtonFromDepartmentWiseTestAndRevenueReport();
		Thread.sleep(40000);


		//Create Blank workbook
		XSSFWorkbook workbook2 = new XSSFWorkbook();
		FileOutputStream out2 = new FileOutputStream(new File(System.getProperty("user.dir")+"User Wise Collection Report.xlsx"));

		//write operation workbook using file out object
		workbook2.write(out2);
		out2.close();


		// Converting CSV to Excel File
		File myFile2 = new File(currentDirectory.getCanonicalPath() + "/Downloads/User Wise Collection Report.csv");
		ExcelWriter writer2 = new ExcelWriter();
		writer2.setExcelFile(System.getProperty("user.dir")+"User Wise Collection Report.xlsx");

		try (FileInputStream fileInputStream2 = new FileInputStream(myFile2);) {

			try (BufferedReader reader2 = new BufferedReader(new InputStreamReader(fileInputStream2));) {
				XSSFSheet sheet2 = writer2.createSheet("User Wise Collection");
				int i = 0;
				Iterator<String> ite2 = reader2.lines().iterator();
				while (ite2.hasNext()) {

					i = i + 1;
					XSSFRow row2 = writer2.createRow(i);
					String[] strCollection2 = ite2.next().split(",");

					for (int j = 0; j < strCollection2.length; j++)
						row2.createCell(j).setCellValue(strCollection2[j]);
				}
				writer2.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromUserWiseReport = ExcelReader.readExcelUserWiseCollectionDiscount(System.getProperty("user.dir")+"User Wise Collection Report.xlsx", "User Wise Collection");
		System.out.println("sumOfDiscountValueFromUserWiseReport"+sumOfDiscountValueFromUserWiseReport);

		CommonUtils.saveDownloadedExcel("User Wise Collection Report");
		//Delete Summary Report Excel File and CSV File

		File excelFile2 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile2.delete();
		File csvFile2 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Department Wise SubDepartment Wise Revenue.csv");
		csvFile2.delete();
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromIPReport, sumOfDiscountValueFromDSD), "Sum Of Discount Value From IP Report is not matching with DSD Report");
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD, sumOfDiscountValueFromUserWiseReport), "Sum Of Discount Value From UserWise Report is not matching with DSD Report");

	}


	@Test(priority = 7) //pass and fixed 04-06-2020
	public void misOpDiscountReportTest() throws Throwable {

		test=extent.createTest("misOpDiscountReportTest", "This test case verify the mis Op Discount Report Test Case");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);

		System.out.println("Hellosssss"+System.getProperty("user.dir"));
		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");
		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnOPThenBillingAndSelectAnOption("OP Discount Report");
		opDiscoutReportPage.clickSummaryButton();
		opDiscoutReportPage.enterFromDate("01/Jun/2020");
		opDiscoutReportPage.clickOnCSVButton();
		//Thread.sleep(10000);
		Thread.sleep(7000);

		File currentDirectory = new File(new File(".").getAbsolutePath());

		//Create Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"OP Discount Report Excel.xlsx"));

		//write operation workbook using file out object
		workbook.write(out);
		out.close();


		// Converting CSV to Excel File
		File myFile = new File(currentDirectory.getCanonicalPath() + "/Downloads/OP Discount Report.csv");
		ExcelWriter writer = new ExcelWriter();
		writer.setExcelFile(System.getProperty("user.dir")+"OP Discount Report Excel.xlsx");

		try (FileInputStream fileInputStream = new FileInputStream(myFile);) {

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));) {
				XSSFSheet sheet = writer.createSheet("OP Discount");
				int i = 0;
				Iterator<String> ite = reader.lines().iterator();
				while (ite.hasNext()) {

					i = i + 1;
					XSSFRow row = writer.createRow(i);
					String[] strCollection = ite.next().split(",");

					for (int j = 0; j < strCollection.length; j++)
						row.createCell(j).setCellValue(strCollection[j]);
				}
				writer.write();
				System.out.println("Migration completed");
			}

		}


		Double sumOfDiscountValueFromSummaryReport = ExcelReader.readExcelOpDiscount(System.getProperty("user.dir")+"OP Discount Report Excel.xlsx", "OP Discount");
		System.out.println("sumOfDiscountValue"+sumOfDiscountValueFromSummaryReport);

		CommonUtils.saveDownloadedExcel("OP Discount Report Excel");

		//Delete Summary Report Excel File and CSV File

		File excelFile = new File(System.getProperty("user.dir")+"OP Discount Report Excel.xlsx");
		excelFile.delete();
		File csvFile = new File(currentDirectory.getCanonicalPath() + "/Downloads/OP Discount Report.csv");
		csvFile.delete();

		//Getting Discount Detailed Report
		opDiscoutReportPage.clickDetailedButton();
		opDiscoutReportPage.enterFromDate("01/Jun/2020");
		opDiscoutReportPage.selectDiscountHead("DISCOUNT");
		Thread.sleep(2000);
		opDiscoutReportPage.clickOnCSVButton();
		//Thread.sleep(10000);
		Thread.sleep(8000);


		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"OP Discount Report Excel.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/OP Discount Report.csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"OP Discount Report Excel.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("OP Discount");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDetailedReport = ExcelReader.readExcelOpDiscount(System.getProperty("user.dir")+"OP Discount Report Excel.xlsx", "OP Discount");
		System.out.println("sumOfDiscountValueFromDetailedReport"+sumOfDiscountValueFromDetailedReport);

		CommonUtils.saveDownloadedExcel("OP Discount Report Excel");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"OP Discount Report Excel.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/OP Discount Report.csv");
		csvFile1.delete();

		Assert.assertEquals(sumOfDiscountValueFromSummaryReport, sumOfDiscountValueFromDetailedReport, "Discount Amount of Sumary Report and Detailed Report is not matching");
	}

	@Test(priority = 8) //pass and fixed 04-06-2020....................................................
	public void misIpDiscountReportTest() throws Throwable {

		test=extent.createTest("misIpDiscountReportTest", "This test case verify the mis Ip Discount Report Test Case");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);


		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");
		frontOfficeHomePage.expandMenu();

		//Getting Discount Amount From IP Discount Report

		frontOfficeHomePage.clickOnIPThenBillingAndSelectAnOption("IP Discount Report");
		ipDiscoutReportPage.enterFromDate("01/Jun/2020");
		ipDiscoutReportPage.clickOnCSVButton();
		//Thread.sleep(10000);
		Thread.sleep(7000);

		File currentDirectory = new File(new File(".").getAbsolutePath());

		//Create Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"IP Discount Report Excel.xlsx"));

		//write operation workbook using file out object
		workbook.write(out);
		out.close();


		// Converting CSV to Excel File
		File myFile = new File(currentDirectory.getCanonicalPath() + "/Downloads/IP Discount Report.csv");
		ExcelWriter writer = new ExcelWriter();
		writer.setExcelFile(System.getProperty("user.dir")+"IP Discount Report Excel.xlsx");

		try (FileInputStream fileInputStream = new FileInputStream(myFile);) {

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));) {
				XSSFSheet sheet = writer.createSheet("IP Discount");
				int i = 0;
				Iterator<String> ite = reader.lines().iterator();
				while (ite.hasNext()) {

					i = i + 1;
					XSSFRow row = writer.createRow(i);
					String[] strCollection = ite.next().split(",");

					for (int j = 0; j < strCollection.length; j++)
						row.createCell(j).setCellValue(strCollection[j]);
				}
				writer.write();
				System.out.println("Migration completed");
			}

		}


		Double sumOfDiscountValueFromIPReport = ExcelReader.readExcelIpDiscount(System.getProperty("user.dir")+"IP Discount Report Excel.xlsx", "IP Discount");
		logger.info("sumOfDiscountValueFromIPReport"+sumOfDiscountValueFromIPReport);

		CommonUtils.saveDownloadedExcel("IP Discount Report");

		//Delete Summary Report Excel File and CSV File

		File excelFile = new File(System.getProperty("user.dir")+"IP Discount Report Excel.xlsx");
		excelFile.delete();
		File csvFile = new File(currentDirectory.getCanonicalPath() + "/Downloads/IP Discount Report.csv");
		csvFile.delete();
	}


	@Test(priority = 9) //pass and fixed 04-06-2020
	public void iPRadioButtonDistributionDSDReportTest() throws Throwable {

		test=extent.createTest("iPRadioButtonDistributionDSDReportTest", "This test case verify the iP Radio Button Distribution DSD Report Test Case");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);
		File currentDirectory = new File(new File(".").getAbsolutePath());

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectOverAllSummaryReportRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.selectAllServicesRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);


		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD1"+sumOfDiscountValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfDiscountValueFromDSD1), "sumOfDiscountValueFromDSD is not there in excel");
		Double sumOfGrossValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD1"+sumOfGrossValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfGrossValueFromDSD1), "sumOfGrossValueFromDSD is not there in excel");
		Double sumOfNetValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD1"+sumOfNetValueFromDSD1);
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfNetValueFromDSD1), "sumOfNetValueFromDSD is not there in excel");

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile1.delete();

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);

		//Create Blank workbook
		XSSFWorkbook workbook6 = new XSSFWorkbook();
		FileOutputStream out6 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook6.write(out6);
		out6.close();


		// Converting CSV to Excel File
		File myFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer6 = new ExcelWriter();
		writer6.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream6 = new FileInputStream(myFile6);) {

			try (BufferedReader reader6 = new BufferedReader(new InputStreamReader(fileInputStream6));) {
				XSSFSheet sheet6 = writer6.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite6 = reader6.lines().iterator();
				while (ite6.hasNext()) {

					i = i + 1;
					XSSFRow row6 = writer6.createRow(i);
					String[] strCollection6 = ite6.next().split(",");

					for (int j = 0; j < strCollection6.length; j++)
						row6.createCell(j).setCellValue(strCollection6[j]);
				}
				writer6.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD2"+sumOfDiscountValueFromDSD2);
		Double sumOfGrossValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD2"+sumOfGrossValueFromDSD2);
		Double sumOfNetValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD2"+sumOfNetValueFromDSD2);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile6 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile6.delete();
		File csvFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile6.delete();


		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);

		//Create Blank workbook
		XSSFWorkbook workbook7 = new XSSFWorkbook();
		FileOutputStream out7 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook7.write(out7);
		out7.close();


		// Converting CSV to Excel File
		File myFile7 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer7 = new ExcelWriter();
		writer7.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream7 = new FileInputStream(myFile7);) {

			try (BufferedReader reader7 = new BufferedReader(new InputStreamReader(fileInputStream7));) {
				XSSFSheet sheet7 = writer7.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite7 = reader7.lines().iterator();
				while (ite7.hasNext()) {

					i = i + 1;
					XSSFRow row7 = writer7.createRow(i);
					String[] strCollection7 = ite7.next().split(",");

					for (int j = 0; j < strCollection7.length; j++)
						row7.createCell(j).setCellValue(strCollection7[j]);
				}
				writer7.write();
				System.out.println("Migration completed");
			} 	

		}
		Double sumOfDiscountValueFromDSD3 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD3"+sumOfDiscountValueFromDSD3);
		Double sumOfGrossValueFromDSD3 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD3"+sumOfGrossValueFromDSD3);
		Double sumOfNetValueFromDSD3 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD3"+sumOfNetValueFromDSD3);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile7 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile7.delete();
		File csvFile7 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile7.delete();

		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD1, sumOfDiscountValueFromDSD2), "Sum Of Discount Value From IP Summary and Over All Summary is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfGrossValueFromDSD1, sumOfGrossValueFromDSD2), "Sum Of Gross Value From IP Summary and Over All Summary is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfNetValueFromDSD1, sumOfNetValueFromDSD2), "Sum Of Net Value From IP Summary and Over All Summary is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD3, sumOfDiscountValueFromDSD2), "Sum Of Discount Value From IP Detail and Over All Summary is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfGrossValueFromDSD3, sumOfGrossValueFromDSD2), "Sum Of Gross Value From IP Detail and Over All Summary is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfNetValueFromDSD3, sumOfNetValueFromDSD2), "Sum Of Net Value From IP Detail and Over All Summary is not matching");

	}


	@Test(priority = 10) //pass and fixed 04-06-2020
	public void oPRadioButtonDistributionDSDReportTest() throws Throwable {
		test=extent.createTest("oPRadioButtonDistributionDSDReportTest", "This test case verify the oP Radio Button Distribution DSD Report Test Case");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);
		File currentDirectory = new File(new File(".").getAbsolutePath());

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickOPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectOverAllSummaryReportRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.selectAllServicesRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();



		//Thread.sleep(40000);
		Thread.sleep(7000);

		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD1"+sumOfDiscountValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfDiscountValueFromDSD1), "sumOfDiscountValueFromDSD is not there in excel");
		Double sumOfGrossValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD1"+sumOfGrossValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfGrossValueFromDSD1), "sumOfGrossValueFromDSD is not there in excel");
		Double sumOfNetValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD1"+sumOfNetValueFromDSD1);
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfNetValueFromDSD1), "sumOfNetValueFromDSD is not there in excel");

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile1.delete();

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickOPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);

		//Create Blank workbook
		XSSFWorkbook workbook6 = new XSSFWorkbook();
		FileOutputStream out6 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook6.write(out6);
		out6.close();


		// Converting CSV to Excel File
		File myFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer6 = new ExcelWriter();
		writer6.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream6 = new FileInputStream(myFile6);) {

			try (BufferedReader reader6 = new BufferedReader(new InputStreamReader(fileInputStream6));) {
				XSSFSheet sheet6 = writer6.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite6 = reader6.lines().iterator();
				while (ite6.hasNext()) {

					i = i + 1;
					XSSFRow row6 = writer6.createRow(i);
					String[] strCollection6 = ite6.next().split(",");

					for (int j = 0; j < strCollection6.length; j++)
						row6.createCell(j).setCellValue(strCollection6[j]);
				}
				writer6.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD2"+sumOfDiscountValueFromDSD2);
		Double sumOfGrossValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD2"+sumOfGrossValueFromDSD2);
		Double sumOfNetValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD2"+sumOfNetValueFromDSD2);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile6 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile6.delete();
		File csvFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile6.delete();


		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickOPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);
		//Create Blank workbook
		XSSFWorkbook workbook7 = new XSSFWorkbook();
		FileOutputStream out7 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook7.write(out7);
		out7.close();


		// Converting CSV to Excel File
		File myFile7 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer7 = new ExcelWriter();
		writer7.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream7 = new FileInputStream(myFile7);) {

			try (BufferedReader reader7 = new BufferedReader(new InputStreamReader(fileInputStream7));) {
				XSSFSheet sheet7 = writer7.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite7 = reader7.lines().iterator();
				while (ite7.hasNext()) {

					i = i + 1;
					XSSFRow row7 = writer7.createRow(i);
					String[] strCollection7 = ite7.next().split(",");

					for (int j = 0; j < strCollection7.length; j++)
						row7.createCell(j).setCellValue(strCollection7[j]);
				}
				writer7.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD3 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD3"+sumOfDiscountValueFromDSD3);
		Double sumOfGrossValueFromDSD3 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD3"+sumOfGrossValueFromDSD3);
		Double sumOfNetValueFromDSD3 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD3"+sumOfNetValueFromDSD3);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile7 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile7.delete();
		File csvFile7 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile7.delete();

		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD1, sumOfDiscountValueFromDSD2), "Sum Of Discount Value From OP Summary and Over All Summary is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfGrossValueFromDSD1, sumOfGrossValueFromDSD2), "Sum Of Gross Value From OP Summary and Over All Summary is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfNetValueFromDSD1, sumOfNetValueFromDSD2), "Sum Of Net Value From OP Summary and Over All Summary is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD3, sumOfDiscountValueFromDSD2), "Sum Of Discount Value From OP Detail and Over All Summary is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfGrossValueFromDSD3, sumOfGrossValueFromDSD2), "Sum Of Gross Value From OP Detail and Over All Summary is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfNetValueFromDSD3, sumOfNetValueFromDSD2), "Sum Of Net Value From OP Detail and Over All Summary is not matching");

	}

	@Test(priority = 12) //pass and fixed 04-06-2020
	public void eMRadioButtonDistributionDSDReportTest() throws Throwable {
		test=extent.createTest("eMRadioButtonDistributionDSDReportTest", "This test case verify the eM Radio Button Distribution DSD Report Test Case");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);
		File currentDirectory = new File(new File(".").getAbsolutePath());

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickEMRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectOverAllSummaryReportRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.selectAllServicesRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();



		//Thread.sleep(40000);
		Thread.sleep(7000);

		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD1"+sumOfDiscountValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfDiscountValueFromDSD1), "sumOfDiscountValueFromDSD is not there in excel");
		Double sumOfGrossValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD1"+sumOfGrossValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfGrossValueFromDSD1), "sumOfGrossValueFromDSD is not there in excel");
		Double sumOfNetValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD1"+sumOfNetValueFromDSD1);
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfNetValueFromDSD1), "sumOfNetValueFromDSD is not there in excel");

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile1.delete();

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickEMRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);
		//Create Blank workbook
		XSSFWorkbook workbook6 = new XSSFWorkbook();
		FileOutputStream out6 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook6.write(out6);
		out6.close();


		// Converting CSV to Excel File
		File myFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer6 = new ExcelWriter();
		writer6.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream6 = new FileInputStream(myFile6);) {

			try (BufferedReader reader6 = new BufferedReader(new InputStreamReader(fileInputStream6));) {
				XSSFSheet sheet6 = writer6.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite6 = reader6.lines().iterator();
				while (ite6.hasNext()) {

					i = i + 1;
					XSSFRow row6 = writer6.createRow(i);
					String[] strCollection6 = ite6.next().split(",");

					for (int j = 0; j < strCollection6.length; j++)
						row6.createCell(j).setCellValue(strCollection6[j]);
				}
				writer6.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD2"+sumOfDiscountValueFromDSD2);
		Double sumOfGrossValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD2"+sumOfGrossValueFromDSD2);
		Double sumOfNetValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD2"+sumOfNetValueFromDSD2);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile6 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile6.delete();
		File csvFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile6.delete();


		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickEMRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);
		//Create Blank workbook
		XSSFWorkbook workbook7 = new XSSFWorkbook();
		FileOutputStream out7 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook7.write(out7);
		out7.close();


		// Converting CSV to Excel File
		File myFile7 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer7 = new ExcelWriter();
		writer7.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream7 = new FileInputStream(myFile7);) {

			try (BufferedReader reader7 = new BufferedReader(new InputStreamReader(fileInputStream7));) {
				XSSFSheet sheet7 = writer7.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite7 = reader7.lines().iterator();
				while (ite7.hasNext()) {

					i = i + 1;
					XSSFRow row7 = writer7.createRow(i);
					String[] strCollection7 = ite7.next().split(",");

					for (int j = 0; j < strCollection7.length; j++)
						row7.createCell(j).setCellValue(strCollection7[j]);
				}
				writer7.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD3 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD3"+sumOfDiscountValueFromDSD3);
		Double sumOfGrossValueFromDSD3 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD3"+sumOfGrossValueFromDSD3);
		Double sumOfNetValueFromDSD3 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD3"+sumOfNetValueFromDSD3);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile7 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile7.delete();
		File csvFile7 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile7.delete();

		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD1, sumOfDiscountValueFromDSD2), "Sum Of Discount Value From EM Summary and Over All Summary is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfGrossValueFromDSD1, sumOfGrossValueFromDSD2), "Sum Of Gross Value From EM Summary and Over All Summary is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfNetValueFromDSD1, sumOfNetValueFromDSD2), "Sum Of Net Value From EM Summary and Over All Summary is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD3, sumOfDiscountValueFromDSD2), "Sum Of Discount Value From EM Detail and Over All Summary is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfGrossValueFromDSD3, sumOfGrossValueFromDSD2), "Sum Of Gross Value From EM Detail and Over All Summary is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfNetValueFromDSD3, sumOfNetValueFromDSD2), "Sum Of Net Value From EM Detail and Over All Summary is not matching");
	}

	@Test(priority = 13) //pass and fixed 04-06-2020
	public void allRadioButtonDistributionDSDReportTest() throws Throwable {
		test=extent.createTest("allRadioButtonDistributionDSDReportTest", "This test case verify the all Radio Button Distribution DSD Report Test Case");
		test.assignCategory("MIS Report");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);
		File currentDirectory = new File(new File(".").getAbsolutePath());

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickEMRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectOverAllSummaryReportRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.selectAllServicesRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		//Thread.sleep(40000);
		Thread.sleep(7000);
		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();

		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD1"+sumOfDiscountValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfDiscountValueFromDSD1), "sumOfDiscountValueFromDSD is not there in excel");
		Double sumOfGrossValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD1"+sumOfGrossValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfGrossValueFromDSD1), "sumOfGrossValueFromDSD is not there in excel");
		Double sumOfNetValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD1"+sumOfNetValueFromDSD1);
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfNetValueFromDSD1), "sumOfNetValueFromDSD is not there in excel");

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile1.delete();
	}

	@Test(priority = 14) //pass and fixed 04-06-2020
	public void iPOverallRadioButtonDSDReportTest() throws Throwable {

		test=extent.createTest("iPOverallRadioButtonDSDReportTest", "This test case verify the iPOverallRadioButtonDSDReportTest");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);
		File currentDirectory = new File(new File(".").getAbsolutePath());

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectOverAllSummaryReportRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Radiology Services");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();



		///	Thread.sleep(40000);
		Thread.sleep(7000);


		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD1"+sumOfDiscountValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfDiscountValueFromDSD1), "sumOfDiscountValueFromDSD is not there in excel");
		Double sumOfGrossValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD1"+sumOfGrossValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfGrossValueFromDSD1), "sumOfGrossValueFromDSD is not there in excel");
		Double sumOfNetValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD1"+sumOfNetValueFromDSD1);
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfNetValueFromDSD1), "sumOfNetValueFromDSD is not there in excel");

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile1.delete();

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectOverAllSummaryReportRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Radiology Services");

		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartmentCheckbox();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pathology");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Radiology");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		Thread.sleep(40000);

		//Create Blank workbook
		XSSFWorkbook workbook6 = new XSSFWorkbook();
		FileOutputStream out6 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook6.write(out6);
		out6.close();


		// Converting CSV to Excel File
		File myFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer6 = new ExcelWriter();
		writer6.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream6 = new FileInputStream(myFile6);) {

			try (BufferedReader reader6 = new BufferedReader(new InputStreamReader(fileInputStream6));) {
				XSSFSheet sheet6 = writer6.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite6 = reader6.lines().iterator();
				while (ite6.hasNext()) {

					i = i + 1;
					XSSFRow row6 = writer6.createRow(i);
					String[] strCollection6 = ite6.next().split(",");

					for (int j = 0; j < strCollection6.length; j++)
						row6.createCell(j).setCellValue(strCollection6[j]);
				}
				writer6.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD2"+sumOfDiscountValueFromDSD2);
		Double sumOfGrossValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD2"+sumOfGrossValueFromDSD2);
		Double sumOfNetValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD2"+sumOfNetValueFromDSD2);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile6 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile6.delete();
		File csvFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile6.delete();



		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD1, sumOfDiscountValueFromDSD2), "Sum Of Discount Value From both IP reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfGrossValueFromDSD1, sumOfGrossValueFromDSD2), "Sum Of Gross Value From both IP reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfNetValueFromDSD1, sumOfNetValueFromDSD2), "Sum Of Net Value  From both IP reports is not matching");

	}

	@Test(priority = 15) //fixed 04-06-2020
	public void iPSummaryRadioButtonDSDReportTest() throws Throwable {
		test=extent.createTest("iPSummaryRadioButtonDSDReportTest", "This test case verify the iP Summary Radio Button DSD Report Test");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);
		File currentDirectory = new File(new File(".").getAbsolutePath());

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Pharmacy");

		//		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartmentCheckbox();
		//		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pathology");
		//		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Radiology");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);


		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD1"+sumOfDiscountValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfDiscountValueFromDSD1), "sumOfDiscountValueFromDSD is not there in excel");
		Double sumOfGrossValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD1"+sumOfGrossValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfGrossValueFromDSD1), "sumOfGrossValueFromDSD is not there in excel");
		Double sumOfNetValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD1"+sumOfNetValueFromDSD1);
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfNetValueFromDSD1), "sumOfNetValueFromDSD is not there in excel");

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile1.delete();

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Pharmacy");

		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartmentCheckbox();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pharmacy");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pathology");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);
		//Create Blank workbook
		XSSFWorkbook workbook6 = new XSSFWorkbook();
		FileOutputStream out6 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook6.write(out6);
		out6.close();


		// Converting CSV to Excel File
		File myFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer6 = new ExcelWriter();
		writer6.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream6 = new FileInputStream(myFile6);) {

			try (BufferedReader reader6 = new BufferedReader(new InputStreamReader(fileInputStream6));) {
				XSSFSheet sheet6 = writer6.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite6 = reader6.lines().iterator();
				while (ite6.hasNext()) {

					i = i + 1;
					XSSFRow row6 = writer6.createRow(i);
					String[] strCollection6 = ite6.next().split(",");

					for (int j = 0; j < strCollection6.length; j++)
						row6.createCell(j).setCellValue(strCollection6[j]);
				}
				writer6.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD2"+sumOfDiscountValueFromDSD2);
		Double sumOfGrossValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD2"+sumOfGrossValueFromDSD2);
		Double sumOfNetValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD2"+sumOfNetValueFromDSD2);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile6 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile6.delete();
		File csvFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile6.delete();

		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD1, sumOfDiscountValueFromDSD2), "Sum Of Discount Value From both IP Summary reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfGrossValueFromDSD1, sumOfGrossValueFromDSD2), "Sum Of Gross Value From both IP Summary reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfNetValueFromDSD1, sumOfNetValueFromDSD2), "Sum Of Net Value  From both IP Summary reports is not matching");


	}

	@Test(priority = 16) //pass and fixed 04-06-2020
	public void iPDetailsRadioButtonDSDReportTest() throws Throwable 
	{
		test=extent.createTest("iPDetailsRadioButtonDSDReportTest", "This test case verify the iP Details Radio Button DSD Report Test");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);
		File currentDirectory = new File(new File(".").getAbsolutePath());

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Radiology Services");

		//		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartmentCheckbox();
		//		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pathology");
		//		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Radiology");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);


		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD1"+sumOfDiscountValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfDiscountValueFromDSD1), "sumOfDiscountValueFromDSD is not there in excel");
		Double sumOfGrossValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD1"+sumOfGrossValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfGrossValueFromDSD1), "sumOfGrossValueFromDSD is not there in excel");
		Double sumOfNetValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD1"+sumOfNetValueFromDSD1);
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfNetValueFromDSD1), "sumOfNetValueFromDSD is not there in excel");

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile1.delete();

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Pharmacy");

		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartmentCheckbox();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Radiology");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pathology");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);
		//Create Blank workbook
		XSSFWorkbook workbook6 = new XSSFWorkbook();
		FileOutputStream out6 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook6.write(out6);
		out6.close();


		// Converting CSV to Excel File
		File myFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer6 = new ExcelWriter();
		writer6.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream6 = new FileInputStream(myFile6);) {

			try (BufferedReader reader6 = new BufferedReader(new InputStreamReader(fileInputStream6));) {
				XSSFSheet sheet6 = writer6.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite6 = reader6.lines().iterator();
				while (ite6.hasNext()) {

					i = i + 1;
					XSSFRow row6 = writer6.createRow(i);
					String[] strCollection6 = ite6.next().split(",");

					for (int j = 0; j < strCollection6.length; j++)
						row6.createCell(j).setCellValue(strCollection6[j]);
				}
				writer6.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD2"+sumOfDiscountValueFromDSD2);
		Double sumOfGrossValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD2"+sumOfGrossValueFromDSD2);
		Double sumOfNetValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD2"+sumOfNetValueFromDSD2);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile6 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile6.delete();
		File csvFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile6.delete();

		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD1, sumOfDiscountValueFromDSD2), "Sum Of Discount Value From both IP Summary reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfGrossValueFromDSD1, sumOfGrossValueFromDSD2), "Sum Of Gross Value From both IP Summary reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfNetValueFromDSD1, sumOfNetValueFromDSD2), "Sum Of Net Value  From both IP Summary reports is not matching");


	}

	@Test(priority = 17) //pass and fixed 04-06-2020
	public void oPOverallRadioButtonDSDReportTest() throws Throwable {

		test=extent.createTest("oPOverallRadioButtonDSDReportTest", "This test case verify the oP Overall Radio Button DSD Report Test");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);
		File currentDirectory = new File(new File(".").getAbsolutePath());

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickOPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectOverAllSummaryReportRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Radiology Services");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();



		///Thread.sleep(40000);
		Thread.sleep(7000);


		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD1"+sumOfDiscountValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfDiscountValueFromDSD1), "sumOfDiscountValueFromDSD is not there in excel");
		Double sumOfGrossValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD1"+sumOfGrossValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfGrossValueFromDSD1), "sumOfGrossValueFromDSD is not there in excel");
		Double sumOfNetValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD1"+sumOfNetValueFromDSD1);
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfNetValueFromDSD1), "sumOfNetValueFromDSD is not there in excel");

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile1.delete();

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickOPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectOverAllSummaryReportRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Radiology Services");

		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartmentCheckbox();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pathology");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Radiology");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		Thread.sleep(40000);

		//Create Blank workbook
		XSSFWorkbook workbook6 = new XSSFWorkbook();
		FileOutputStream out6 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook6.write(out6);
		out6.close();


		// Converting CSV to Excel File
		File myFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer6 = new ExcelWriter();
		writer6.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream6 = new FileInputStream(myFile6);) {

			try (BufferedReader reader6 = new BufferedReader(new InputStreamReader(fileInputStream6));) {
				XSSFSheet sheet6 = writer6.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite6 = reader6.lines().iterator();
				while (ite6.hasNext()) {

					i = i + 1;
					XSSFRow row6 = writer6.createRow(i);
					String[] strCollection6 = ite6.next().split(",");

					for (int j = 0; j < strCollection6.length; j++)
						row6.createCell(j).setCellValue(strCollection6[j]);
				}
				writer6.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD2"+sumOfDiscountValueFromDSD2);
		Double sumOfGrossValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD2"+sumOfGrossValueFromDSD2);
		Double sumOfNetValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD2"+sumOfNetValueFromDSD2);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile6 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile6.delete();
		File csvFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile6.delete();



		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD1, sumOfDiscountValueFromDSD2), "Sum Of Discount Value From both OP reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfGrossValueFromDSD1, sumOfGrossValueFromDSD2), "Sum Of Gross Value From both OP reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfNetValueFromDSD1, sumOfNetValueFromDSD2), "Sum Of Net Value  From both OP reports is not matching");

	}

	@Test(priority = 18) //pass and fixed 04-06-2020
	public void oPSummaryRadioButtonDSDReportTest() throws Throwable {

		test=extent.createTest("oPSummaryRadioButtonDSDReportTest", "This test case verify the oP Summary Radio Button DSD Report Test");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);
		File currentDirectory = new File(new File(".").getAbsolutePath());

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickOPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("OP Consultations");

		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartmentCheckbox();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pathology");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Radiology");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);
		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD1"+sumOfDiscountValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfDiscountValueFromDSD1), "sumOfDiscountValueFromDSD is not there in excel");
		Double sumOfGrossValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD1"+sumOfGrossValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfGrossValueFromDSD1), "sumOfGrossValueFromDSD is not there in excel");
		Double sumOfNetValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD1"+sumOfNetValueFromDSD1);
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfNetValueFromDSD1), "sumOfNetValueFromDSD is not there in excel");

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile1.delete();

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickOPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("OP Consultations");

		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartmentCheckbox();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Cardiology");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pathology");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Dental");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);
		//Create Blank workbook
		XSSFWorkbook workbook6 = new XSSFWorkbook();
		FileOutputStream out6 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook6.write(out6);
		out6.close();


		// Converting CSV to Excel File
		File myFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer6 = new ExcelWriter();
		writer6.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream6 = new FileInputStream(myFile6);) {

			try (BufferedReader reader6 = new BufferedReader(new InputStreamReader(fileInputStream6));) {
				XSSFSheet sheet6 = writer6.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite6 = reader6.lines().iterator();
				while (ite6.hasNext()) {

					i = i + 1;
					XSSFRow row6 = writer6.createRow(i);
					String[] strCollection6 = ite6.next().split(",");

					for (int j = 0; j < strCollection6.length; j++)
						row6.createCell(j).setCellValue(strCollection6[j]);
				}
				writer6.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD2"+sumOfDiscountValueFromDSD2);
		Double sumOfGrossValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD2"+sumOfGrossValueFromDSD2);
		Double sumOfNetValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD2"+sumOfNetValueFromDSD2);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile6 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile6.delete();
		File csvFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile6.delete();

		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD1, sumOfDiscountValueFromDSD2), "Sum Of Discount Value From both IP Summary reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfGrossValueFromDSD1, sumOfGrossValueFromDSD2), "Sum Of Gross Value From both IP Summary reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfNetValueFromDSD1, sumOfNetValueFromDSD2), "Sum Of Net Value  From both IP Summary reports is not matching");


	}

	@Test(priority = 19) //pass and fixed 04-06-2020
	public void oPDetailsRadioButtonDSDReportTest() throws Throwable {

		test=extent.createTest("oPDetailsRadioButtonDSDReportTest", "This test case verify the oP Details Radio Button DSD Report Test");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);
		File currentDirectory = new File(new File(".").getAbsolutePath());

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickOPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Radiology Services");

		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartmentCheckbox();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pathology");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Radiology");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();



		//Thread.sleep(40000);
		Thread.sleep(7000);

		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD1"+sumOfDiscountValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfDiscountValueFromDSD1), "sumOfDiscountValueFromDSD is not there in excel");
		Double sumOfGrossValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD1"+sumOfGrossValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfGrossValueFromDSD1), "sumOfGrossValueFromDSD is not there in excel");
		Double sumOfNetValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD1"+sumOfNetValueFromDSD1);
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfNetValueFromDSD1), "sumOfNetValueFromDSD is not there in excel");

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile1.delete();

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickOPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Radiology Services");

		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartmentCheckbox();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Radiology");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pathology");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);
		//Create Blank workbook
		XSSFWorkbook workbook6 = new XSSFWorkbook();
		FileOutputStream out6 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook6.write(out6);
		out6.close();


		// Converting CSV to Excel File
		File myFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer6 = new ExcelWriter();
		writer6.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream6 = new FileInputStream(myFile6);) {

			try (BufferedReader reader6 = new BufferedReader(new InputStreamReader(fileInputStream6));) {
				XSSFSheet sheet6 = writer6.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite6 = reader6.lines().iterator();
				while (ite6.hasNext()) {

					i = i + 1;
					XSSFRow row6 = writer6.createRow(i);
					String[] strCollection6 = ite6.next().split(",");

					for (int j = 0; j < strCollection6.length; j++)
						row6.createCell(j).setCellValue(strCollection6[j]);
				}
				writer6.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD2"+sumOfDiscountValueFromDSD2);
		Double sumOfGrossValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD2"+sumOfGrossValueFromDSD2);
		Double sumOfNetValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD2"+sumOfNetValueFromDSD2);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile6 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile6.delete();
		File csvFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile6.delete();

		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD1, sumOfDiscountValueFromDSD2), "Sum Of Discount Value From both OP Summary reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfGrossValueFromDSD1, sumOfGrossValueFromDSD2), "Sum Of Gross Value From both OP Summary reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfNetValueFromDSD1, sumOfNetValueFromDSD2), "Sum Of Net Value  From both OP Summary reports is not matching");


	}

	@Test(priority = 20) //fixed 15-04-2020
	public void eMOverallRadioButtonDSDReportTest() throws Throwable {
		test=extent.createTest("eMOverallRadioButtonDSDReportTest", "This test case verify the eM Over all Radio Button DSD Report Test");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);
		File currentDirectory = new File(new File(".").getAbsolutePath());

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickEMRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectOverAllSummaryReportRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Radiology Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Consultations");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);


		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD1"+sumOfDiscountValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfDiscountValueFromDSD1), "sumOfDiscountValueFromDSD is not there in excel");
		Double sumOfGrossValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD1"+sumOfGrossValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfGrossValueFromDSD1), "sumOfGrossValueFromDSD is not there in excel");
		Double sumOfNetValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD1"+sumOfNetValueFromDSD1);
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfNetValueFromDSD1), "sumOfNetValueFromDSD is not there in excel");

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile1.delete();

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickEMRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectOverAllSummaryReportRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2019");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2019");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Radiology Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Consultations");

		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartmentCheckbox();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pathology");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Radiology");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Emergency");


		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);
		//Create Blank workbook
		XSSFWorkbook workbook6 = new XSSFWorkbook();
		FileOutputStream out6 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook6.write(out6);
		out6.close();


		// Converting CSV to Excel File
		File myFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer6 = new ExcelWriter();
		writer6.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream6 = new FileInputStream(myFile6);) {

			try (BufferedReader reader6 = new BufferedReader(new InputStreamReader(fileInputStream6));) {
				XSSFSheet sheet6 = writer6.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite6 = reader6.lines().iterator();
				while (ite6.hasNext()) {

					i = i + 1;
					XSSFRow row6 = writer6.createRow(i);
					String[] strCollection6 = ite6.next().split(",");

					for (int j = 0; j < strCollection6.length; j++)
						row6.createCell(j).setCellValue(strCollection6[j]);
				}
				writer6.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD2"+sumOfDiscountValueFromDSD2);
		Double sumOfGrossValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD2"+sumOfGrossValueFromDSD2);
		Double sumOfNetValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD2"+sumOfNetValueFromDSD2);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile6 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile6.delete();
		File csvFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile6.delete();

		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD1, sumOfDiscountValueFromDSD2), "Sum Of Discount Value From both EM reports is not matching");
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfGrossValueFromDSD1, sumOfGrossValueFromDSD2), "Sum Of Gross Value From both EM reports is not matching");
		///assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfNetValueFromDSD1, sumOfNetValueFromDSD2), "Sum Of Net Value  From both EM reports is not matching");

	}

	@Test(priority = 21) //fixed 15-04-2020
	public void eMSummaryRadioButtonDSDReportTest() throws Throwable {
		test=extent.createTest("eMSummaryRadioButtonDSDReportTest", "This test case verify the eM Summary Radio Button DSD Report Test");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);
		File currentDirectory = new File(new File(".").getAbsolutePath());

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickEMRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Radiology Services");

		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartmentCheckbox();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pathology");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Radiology");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		Thread.sleep(7000);
		//Thread.sleep(40000);

		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD1"+sumOfDiscountValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfDiscountValueFromDSD1), "sumOfDiscountValueFromDSD is not there in excel");
		Double sumOfGrossValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD1"+sumOfGrossValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfGrossValueFromDSD1), "sumOfGrossValueFromDSD is not there in excel");
		Double sumOfNetValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD1"+sumOfNetValueFromDSD1);
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfNetValueFromDSD1), "sumOfNetValueFromDSD is not there in excel");

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile1.delete();

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickIPRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Radiology Services");

		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartmentCheckbox();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Radiology");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pathology");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);
		//Create Blank workbook
		XSSFWorkbook workbook6 = new XSSFWorkbook();
		FileOutputStream out6 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook6.write(out6);
		out6.close();


		// Converting CSV to Excel File
		File myFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer6 = new ExcelWriter();
		writer6.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream6 = new FileInputStream(myFile6);) {

			try (BufferedReader reader6 = new BufferedReader(new InputStreamReader(fileInputStream6));) {
				XSSFSheet sheet6 = writer6.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite6 = reader6.lines().iterator();
				while (ite6.hasNext()) {

					i = i + 1;
					XSSFRow row6 = writer6.createRow(i);
					String[] strCollection6 = ite6.next().split(",");

					for (int j = 0; j < strCollection6.length; j++)
						row6.createCell(j).setCellValue(strCollection6[j]);
				}
				writer6.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD2"+sumOfDiscountValueFromDSD2);
		Double sumOfGrossValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD2"+sumOfGrossValueFromDSD2);
		Double sumOfNetValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD2"+sumOfNetValueFromDSD2);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile6 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile6.delete();
		File csvFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile6.delete();

		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD1, sumOfDiscountValueFromDSD2), "Sum Of Discount Value From both EM Summary reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfGrossValueFromDSD1, sumOfGrossValueFromDSD2), "Sum Of Gross Value From both EM Summary reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfNetValueFromDSD1, sumOfNetValueFromDSD2), "Sum Of Net Value  From both EM Summary reports is not matching");

	}

	@Test(priority = 22) //fixed 15-04-2020
	public void eMDetailsRadioButtonDSDReportTest() throws Throwable {
		test=extent.createTest("eMDetailsRadioButtonDSDReportTest", "This test case verify the eM Details Radio Button DSD Report Test");
		test.assignCategory("MIS Report");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		departmentWiseSubDepartmentWiseRevenuePage = new DepartmentWiseSubDepartmentWiseRevenuePage(driver);
		reportPDFPage = new ReportPDFPage(driver);
		ipDiscoutReportPage = new IpDiscountReportPage(driver);
		opDiscoutReportPage = new OpDiscoutReportPage(driver);
		File currentDirectory = new File(new File(".").getAbsolutePath());

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnMISReportIcon();
		hisHomePage.selectStationAndClickOnYes("IT");

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickEMRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Radiology Services");

		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartmentCheckbox();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pathology");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Radiology");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);

		//Create Blank workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		FileOutputStream out1 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook1.write(out1);
		out1.close();


		// Converting CSV to Excel File
		File myFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer1 = new ExcelWriter();
		writer1.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream1 = new FileInputStream(myFile1);) {

			try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream1));) {
				XSSFSheet sheet1 = writer1.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite1 = reader1.lines().iterator();
				while (ite1.hasNext()) {

					i = i + 1;
					XSSFRow row1 = writer1.createRow(i);
					String[] strCollection1 = ite1.next().split(",");

					for (int j = 0; j < strCollection1.length; j++)
						row1.createCell(j).setCellValue(strCollection1[j]);
				}
				writer1.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD1"+sumOfDiscountValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfDiscountValueFromDSD1), "sumOfDiscountValueFromDSD is not there in excel");
		Double sumOfGrossValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD1"+sumOfGrossValueFromDSD1);
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfGrossValueFromDSD1), "sumOfGrossValueFromDSD is not there in excel");
		Double sumOfNetValueFromDSD1 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD1"+sumOfNetValueFromDSD1);
		//assertTrue(departmentWiseSubDepartmentWiseRevenuePage.isDataPresentInExcel(sumOfNetValueFromDSD1), "sumOfNetValueFromDSD is not there in excel");

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile1 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile1.delete();
		File csvFile1 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile1.delete();

		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnCommonThenMISAndSelectAnOption("Department Wise Sub-Department Wise Revenue Report");
		departmentWiseSubDepartmentWiseRevenuePage.clickEMRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectDetailRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.enterFromDate("01/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.enterToDate("04/Jun/2020");
		departmentWiseSubDepartmentWiseRevenuePage.clickSpecificServiceRadioButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Laboratory Services");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificService("Radiology Services");

		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartmentCheckbox();
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Radiology");
		departmentWiseSubDepartmentWiseRevenuePage.selectSpecificDepartment("Pathology");

		departmentWiseSubDepartmentWiseRevenuePage.selectFacility(" Select ");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();
		departmentWiseSubDepartmentWiseRevenuePage.selectFacility("L1-SANITY-T3");
		departmentWiseSubDepartmentWiseRevenuePage.clickOnExcelButton();

		//Thread.sleep(40000);
		Thread.sleep(7000);
		//Create Blank workbook
		XSSFWorkbook workbook6 = new XSSFWorkbook();
		FileOutputStream out6 = new FileOutputStream(new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx"));

		//write operation workbook using file out object
		workbook6.write(out6);
		out6.close();


		// Converting CSV to Excel File
		File myFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		ExcelWriter writer6 = new ExcelWriter();
		writer6.setExcelFile(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");

		try (FileInputStream fileInputStream6 = new FileInputStream(myFile6);) {

			try (BufferedReader reader6 = new BufferedReader(new InputStreamReader(fileInputStream6));) {
				XSSFSheet sheet6 = writer6.createSheet("Department Wise SubDepartment W");
				int i = 0;
				Iterator<String> ite6 = reader6.lines().iterator();
				while (ite6.hasNext()) {

					i = i + 1;
					XSSFRow row6 = writer6.createRow(i);
					String[] strCollection6 = ite6.next().split(",");

					for (int j = 0; j < strCollection6.length; j++)
						row6.createCell(j).setCellValue(strCollection6[j]);
				}
				writer6.write();
				System.out.println("Migration completed");
			}

		}
		Double sumOfDiscountValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "DiscountAmount");
		System.out.println("sumOfDiscountValueFromDSD2"+sumOfDiscountValueFromDSD2);
		Double sumOfGrossValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "GrossAmount");
		System.out.println("sumOfGrossValueFromDSD2"+sumOfGrossValueFromDSD2);
		Double sumOfNetValueFromDSD2 = ExcelReader.readExcelDSDDiscount(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx", "Department Wise SubDepartment W", "NetAmount");
		System.out.println("sumOfNetValueFromDSD2"+sumOfNetValueFromDSD2);

		CommonUtils.saveDownloadedExcel("Department Wise SubDepartment Wise");

		//Delete Summary Report Excel File and CSV File

		File excelFile6 = new File(System.getProperty("user.dir")+"Department Wise SubDepartment Wise Revenue.xlsx");
		excelFile6.delete();
		File csvFile6 = new File(currentDirectory.getCanonicalPath() + "/Downloads/Dept. wise sub dept. wise revenue report .csv");
		csvFile6.delete();

		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfDiscountValueFromDSD1, sumOfDiscountValueFromDSD2), "Sum Of Discount Value From both EM Summary reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfGrossValueFromDSD1, sumOfGrossValueFromDSD2), "Sum Of Gross Value From both EM Summary reports is not matching");
		assertTrue(departmentWiseSubDepartmentWiseRevenuePage.matchTheSumFromTwoSheets(sumOfNetValueFromDSD1, sumOfNetValueFromDSD2), "Sum Of Net Value  From both EM Summary reports is not matching");

	}
}
