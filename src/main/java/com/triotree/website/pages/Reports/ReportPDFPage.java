package com.triotree.website.pages.Reports;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class ReportPDFPage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(ReportPDFPage.class.getName());

	public ReportPDFPage(TTWebsiteDriver driver) {
		super(driver);
	}


	private final By GROSS_AMOUNT_COLUMN = By.xpath("//span[contains(text(),'Gross Amount')]");
	private final By DISCOUNT_AMOUNT_COLUMN = By.xpath("//span[contains(text(),'Discount Amount')]");
	private final By NET_AMOUNT_COLUMN = By.xpath("//span[contains(text(),'Net Amount')]");
	private final By CLOSE_REPORT_BUTTON = By.xpath("//i[@id='popupclose']");
	
	
	public boolean isGrossAmountColumnDisplayed() {
		return driver.isElementPresent(GROSS_AMOUNT_COLUMN, 120);
	}
	
	public boolean isDiscountAmountColumnDisplayed() {
		return driver.isElementPresent(DISCOUNT_AMOUNT_COLUMN, 120);
	}
	
	public boolean isNetAmountColumnDisplayed() {
		return driver.isElementPresent(NET_AMOUNT_COLUMN, 120);
	}
	
	public void closeReportButton() {
		driver.click(CLOSE_REPORT_BUTTON);
		logger.info("Report Closed");
	}
}

