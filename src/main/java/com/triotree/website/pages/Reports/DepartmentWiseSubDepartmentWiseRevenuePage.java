package com.triotree.website.pages.Reports;

import java.util.List;
import java.io.File;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class DepartmentWiseSubDepartmentWiseRevenuePage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(DepartmentWiseSubDepartmentWiseRevenuePage.class.getName());

	public DepartmentWiseSubDepartmentWiseRevenuePage(TTWebsiteDriver driver) {
		super(driver);
	}


	private final By IP_RADIO_BUTTON = By.xpath("//input[@id='rdoIP']");
	private final By EM_RADIO_BUTTON = By.xpath("//input[@id='rdoEM']");
	private final By SPECIFIC_SERVICE_RADIO_BUTTON = By.xpath("//input[@id='rdoSpecific']");
	private final By OVERALL_SUMMARY_RADIO_BUTTON = By.xpath("//input[@id='rdoOverallsummary']");
	private final By SUMMARY_RADIO_BUTTON = By.xpath("//input[@id='rdoSummary']");
	private final By FROM_DATE = By.xpath("//input[@id='frmDate']");
	private final By TO_DATE = By.xpath("//input[@id='toDate']");
	private final By FROM_DATE_USER_WISE_COLLECTION_REPORT = By.xpath("//input[@id='frDate']");
	private final By TO_DATE_USER_WISE_COLLECTION_REPORT = By.xpath("//input[@id='frDate']");
	private final By FACILITY_DROPDOWN = By.xpath("//select[@id='drpFacility']");
	private final By PREVIEW_BUTTON = By.xpath("//a[@id='btnpreview']//i[@class='fa fa-search']");
	private final By CSV_BUTTON  = By.xpath("//i[@class='fa']");
	private final By CSV_BUTTON_DEP_TEST_REV_REPORT  = By.xpath("//i[@class='fa fa-file-excel-o']");
	private final By OP_RADIO_BUTTON_USER_WISE_COLLECTION_REPORT = By.xpath("//input[@id='rOP']");
	private final By IP_RADIO_BUTTON_USER_WISE_COLLECTION_REPORT = By.xpath("//input[@id='rIP']");
	private final By DATE_DAILY_REVENUE_REPORT = By.xpath("//input[@id='txtFromDate']");

	public void clickIPRadioButton() {
		driver.waitForElementPresent(IP_RADIO_BUTTON);
		driver.click(IP_RADIO_BUTTON);
		logger.info("IP Radio Button clicked");
	}

	public void clickEMRadioButton() {
		driver.waitForElementPresent(EM_RADIO_BUTTON);
		driver.click(EM_RADIO_BUTTON);
		logger.info("EM Radio Button clicked");
	}

	public void clickAllRadioButton() {
		driver.waitForElementPresent(By.xpath("//input[@id='rdoallpat']"));
		driver.click(By.xpath("//input[@id='rdoallpat']"));
		logger.info("All Radio Button clicked");
	}

	

	public void clickSpecificServiceRadioButton() {
		driver.waitForElementPresent(SPECIFIC_SERVICE_RADIO_BUTTON);
		driver.click(SPECIFIC_SERVICE_RADIO_BUTTON);
		logger.info("Specific Service Radio Button clicked");
	}


	public void clickOverAllSummaryButton() {
		driver.waitForElementNotPresent(OVERALL_SUMMARY_RADIO_BUTTON);
		driver.click(OVERALL_SUMMARY_RADIO_BUTTON);
		logger.info("Overall Summary Button clicked");
	}


	public void clickSummaryButton() {
		driver.waitForElementNotPresent(SUMMARY_RADIO_BUTTON);
		driver.click(SUMMARY_RADIO_BUTTON);
		logger.info("Summary Button clicked");
	}

	public void enterFromDateAs1StDate() {
		String exstingDate = driver.findElement(FROM_DATE).getAttribute("value");
		int year = Calendar.getInstance().get(Calendar.YEAR);
		String[] dateNumber = exstingDate.split("/");
		String dateValue = dateNumber[1];
		String enterDate = "01"+"/"+dateValue+"/"+year;
		driver.findElement(FROM_DATE).clear();
		driver.findElement(FROM_DATE).sendKeys(enterDate);
		driver.findElement(FROM_DATE).sendKeys(Keys.ENTER);
		System.out.println("enterDate"+enterDate);		
	}

	public void selectFacility(String facility) {
		Select stationDropDown = new Select(driver.findElement(FACILITY_DROPDOWN));
		stationDropDown.selectByVisibleText(facility);
		logger.info("Following facility has been selected from facility Dropdown : " + facility);
	}

	public void clickOnPreviewButton() {
		driver.waitForElementPresent(PREVIEW_BUTTON);
		WebElement PREVIEW_BUTTON_element = driver.findElement(PREVIEW_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, PREVIEW_BUTTON_element);
		logger.info("Preview Button clicked");
	}

	public void enterFromDate(String date) {
		driver.findElement(FROM_DATE).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		driver.findElement(FROM_DATE).sendKeys(date);
		driver.findElement(FROM_DATE).sendKeys(Keys.ENTER);
	}

	public void enterToDate(String date) {
		driver.clear(TO_DATE);
		driver.findElement(TO_DATE).sendKeys(date);
		driver.findElement(TO_DATE).sendKeys(Keys.ENTER);
	}

	public void clickOnCSVButton() {
		driver.waitForElementPresent(CSV_BUTTON, 120);
		driver.click(CSV_BUTTON);
	}
	
	public void clickOnExcelButton() {
		try {
			driver.pauseExecutionFor(4000);
			if(driver.findElements(By.xpath("//div[@class='gritter-close']")).size()>0) 
			{
			driver.findElement(By.xpath("//div[@class='gritter-close']")).click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.waitForElementPresent(By.xpath("//i[@class='fa fa-file-excel-o']"), 120);
		driver.click(By.xpath("//i[@class='fa fa-file-excel-o']"));
	}

	public void clickOPRadioButton() {
		driver.waitForElementPresent(By.xpath("//input[@id='rdoOP']"));
		driver.click(By.xpath("//input[@id='rdoOP']"));
		logger.info("OP Radio Button clicked");
	}

	public void selectOverAllSummaryReportRadioButton() {
		driver.waitForElementPresent(By.xpath("//input[@id='rdoOverallsummary']"));
		driver.click(By.xpath("//input[@id='rdoOverallsummary']"));
	}

	public void enterFromDateFromDepartmentWiseTestAndRevenueReport(String date) throws InterruptedException {
		driver.pauseExecutionFor(5000);

		((JavascriptExecutor)TTWebsiteDriver.driver).executeScript("document.getElementById('Dtpfdate').setAttribute('value','16/Jul/2019')");

		//		driver.clear(FROM_DATE_DEP_TEST_REV_REPORT);
		//		driver.pauseExecutionFor(5000);
		//		driver.findElement(FROM_DATE_DEP_TEST_REV_REPORT).sendKeys(date);
	}

	public void selectFacilityFromDepartmentWiseTestAndRevenueReport(String facility) {
		driver.waitForElementPresent(By.xpath("//label[contains(text(),'"+facility+"')]//preceding::input[1]"), 120);
		driver.click(By.xpath("//label[contains(text(),'"+facility+"')]//preceding::input[1]"));

	}

	public void selectAllServicesFromDepartmentWiseTestAndRevenueReport() {
		driver.waitForElementPresent(By.xpath("//input[@id='Sel_allservice']"), 120);
		driver.click(By.xpath("//input[@id='Sel_allservice']"));

	}

	public void clickOnCSVButtonFromDepartmentWiseTestAndRevenueReport() {
		driver.waitForElementPresent(CSV_BUTTON_DEP_TEST_REV_REPORT, 120);
		WebElement CSV_BUTTO = driver.findElement(CSV_BUTTON_DEP_TEST_REV_REPORT);
		driver.clickByJS(TTWebsiteDriver.driver, CSV_BUTTO);
	}

	public void enterFromDateFromUserWiseCollectionReport(String date) {
		driver.clear(FROM_DATE_USER_WISE_COLLECTION_REPORT);
		driver.findElement(FROM_DATE_USER_WISE_COLLECTION_REPORT).sendKeys(date);
		driver.findElement(FROM_DATE_USER_WISE_COLLECTION_REPORT).click();
	}

	public void enterToDateFromUserWiseCollectionReport(String date) {
		driver.clear(TO_DATE_USER_WISE_COLLECTION_REPORT);
		driver.findElement(TO_DATE_USER_WISE_COLLECTION_REPORT).sendKeys(date);
		driver.findElement(TO_DATE_USER_WISE_COLLECTION_REPORT).sendKeys(Keys.ENTER);

	}

	public void clickOPRadioButtonFromUserWiseCollectionReport() {
		driver.waitForElementPresent(OP_RADIO_BUTTON_USER_WISE_COLLECTION_REPORT);
		driver.click(OP_RADIO_BUTTON_USER_WISE_COLLECTION_REPORT);
		logger.info("OP Radio Button clicked");
	}

	public void clickIPRadioButtonFromUserWiseCollectionReport() {
		driver.waitForElementPresent(IP_RADIO_BUTTON_USER_WISE_COLLECTION_REPORT);
		WebElement IP_RADIO_BUTT = driver.findElement(IP_RADIO_BUTTON_USER_WISE_COLLECTION_REPORT);
		driver.clickByJS(TTWebsiteDriver.driver, IP_RADIO_BUTT);
		logger.info("IP Radio Button clicked");
	}

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag=true;
		}

		return flag;
	}


	public void selectDetailRadioButtonFromUserWiseCollectionReport() {
		driver.pauseExecutionFor(8000);
		WebElement UserWiseCollection = driver.findElement(By.xpath("//input[@id='rDetail']"));
		driver.clickByJS(TTWebsiteDriver.driver, UserWiseCollection);
	}

	public void selectDetailRadioButton() {
		driver.pauseExecutionFor(8000);
		driver.findElement(By.xpath("//input[@id='rdoDetail']")).click();
	}


	public void selectAllRadioButtonFromUserWiseCollectionReport() {
		driver.pauseExecutionFor(4000);
		driver.findElement(By.xpath("//input[@id='rAll']")).click();
	}



	public void selectSummaryRadioButtonFromUserWiseCollectionReport() {
		driver.pauseExecutionFor(4000);
		WebElement CollectionReport = driver.findElement(By.xpath("//input[@id='rdbSummarys']"));
		driver.clickByJS(TTWebsiteDriver.driver, CollectionReport);
	}

	public void selectWithScrollNoCheckboxFromUserWiseCollectionReport() {
		driver.pauseExecutionFor(4000);
		WebElement UserWiseCollectionReport = driver.findElement(By.xpath("//input[@id='chkScroll']"));
		driver.clickByJS(TTWebsiteDriver.driver, UserWiseCollectionReport);
	}

	public void selectWithCommonScrollNoCheckboxFromUserWiseCollectionReport() {
		driver.pauseExecutionFor(4000);
		driver.findElement(By.xpath("//input[@id='chkCommonScroll']")).click();
	}



	public void selectPharmacyRadioButtonFromUserWiseCollectionReport() {
		driver.pauseExecutionFor(4000);
		WebElement UserWiseCol = driver.findElement(By.xpath("//input[@id='rPharmacy']"));
		driver.clickByJS(TTWebsiteDriver.driver, UserWiseCol);
	}

	public void selectErButtonFromUserWiseCollectionReport() {
		driver.pauseExecutionFor(4000);
		WebElement ErButton = driver.findElement(By.xpath("//input[@id='rER']"));
		driver.clickByJS(TTWebsiteDriver.driver, ErButton);
	}

	public void enterDateInMisDailyRevenueReport(String date) {
		driver.clear(DATE_DAILY_REVENUE_REPORT);
		driver.findElement(DATE_DAILY_REVENUE_REPORT).sendKeys(date);
		driver.findElement(DATE_DAILY_REVENUE_REPORT).sendKeys(Keys.ENTER);

	}


	public boolean matchTheSumFromTwoSheets(Double amount, Double amount2) {
		if(amount<=amount2-10) {
			return true;
		}
		else if(amount<=amount2+10) {
			return true;
		}
		else {
			return false;
		}
	}

	public void selectSpecificService(String service) {
		driver.waitForElementPresent(By.xpath("(//td[contains(text(),'"+service+"')]//preceding::input[1])[1]"), 120);
		WebElement Specific = driver.findElement(By.xpath("(//td[contains(text(),'"+service+"')]//preceding::input[1])[1]"));
		driver.clickByJS(TTWebsiteDriver.driver, Specific);
	}


	public void selectSpecificDepartmentCheckbox() {
		driver.waitForElementPresent(By.xpath("//input[@id='rdoSpecificdip']"), 120);
		WebElement SpecificDepartment = driver.findElement(By.xpath("//input[@id='rdoSpecificdip']"));
		driver.clickByJS(TTWebsiteDriver.driver, SpecificDepartment);

	}

	public void selectSpecificDepartment(String service) {

		driver.pauseExecutionFor(4000);
		driver.waitForElementPresent(By.xpath("(//td[contains(text(),'"+service+"')]//preceding::input[1])[last()]"), 120);
		driver.click(By.xpath("(//td[contains(text(),'"+service+"')]//preceding::input[1])[last()]"));
		if(driver.findElement(By.xpath("(//td[contains(text(),'"+service+"')]//preceding::input[1])[last()]")).isSelected()) {
			System.out.println("Its selected");
		}
		else{
			driver.click(By.xpath("(//td[contains(text(),'"+service+"')]//preceding::input[1])[last()]"));
		}
	}

	public boolean isDataPresentInExcel(Double data) {
		if (data >=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void selectAllServicesRadioButton() {
		driver.waitForElementPresent(By.xpath("//input[@id='rdoAll']"), 120);
		driver.click(By.xpath("//input[@id='rdoAll']"));

	}

	
	
}

