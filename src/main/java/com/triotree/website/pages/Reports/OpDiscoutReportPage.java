package com.triotree.website.pages.Reports;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class OpDiscoutReportPage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(OpDiscoutReportPage.class.getName());

	public OpDiscoutReportPage(TTWebsiteDriver driver) {
		super(driver);
	}


	private final By SUMMARY_RADIO_BUTTON = By.xpath("//input[@id='rbtSummary']");
	private final By FROM_DATE = By.xpath("//input[@id='dtpFromDate']");
	private final By PRINT_BUTTON = By.xpath("//i[@class='fa fa-print']");
	private final By CSV_BUTTON = By.xpath("//i[@class='fa fa-file-excel-o']");
	private final By DETAILED_RADIO_BUTTON = By.xpath("//input[@id='rbtDetail']");
	private final By DISCOUNT_HEAD_DROPDOWN = By.xpath("//select[@id='Cmbdischead']");
	



	public void clickSummaryButton() {
		driver.waitForElementPresent(SUMMARY_RADIO_BUTTON);
		driver.click(SUMMARY_RADIO_BUTTON);
		logger.info("Summary Button clicked");
	}
	
	public void clickDetailedButton() {
		driver.waitForElementPresent(DETAILED_RADIO_BUTTON);
		driver.click(DETAILED_RADIO_BUTTON);
		logger.info("Detailed Readio Button clicked");
	}
	
	public void enterFromDate(String date) {
		driver.clear(FROM_DATE);
		driver.findElement(FROM_DATE).sendKeys(date);
	}
	
	public void clickOnPrintButton() {
		driver.click(PRINT_BUTTON);
	}

	public void clickOnCSVButton() {
		driver.click(CSV_BUTTON);
	}
	
	public void selectDiscountHead(String discountHead) {
		driver.waitForElementPresent(DISCOUNT_HEAD_DROPDOWN);
		Select genderDropDown = new Select(driver.findElement(DISCOUNT_HEAD_DROPDOWN));
		genderDropDown.selectByVisibleText(discountHead);
		logger.info("Following discountHead has been selected from discountHead Dropdown : " + discountHead);
	}
	
}

