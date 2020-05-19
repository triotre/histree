package com.triotree.website.pages.Reports;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class IpDiscountReportPage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(IpDiscountReportPage.class.getName());

	public IpDiscountReportPage(TTWebsiteDriver driver) {
		super(driver);
	}


	private final By FROM_DATE = By.xpath("//input[@id='fdt']");
	private final By PRINT_BUTTON = By.xpath("//i[@class='fa fa-print']");
	private final By CSV_BUTTON = By.xpath("//i[@class='fa fa-file-excel-o']");
	private final By DISCOUNT_HEAD_DROPDOWN = By.xpath("//select[@id='Cmbdischead']");




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