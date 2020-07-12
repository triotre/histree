package com.triotree.website.pages.FrontOffice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class ApproveRefundPage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(ApproveRefundPage.class.getName());

	public ApproveRefundPage(TTWebsiteDriver driver) {
		super(driver);
	}


	private final By APPROVE_BUTTON = By.xpath("(//a[@id='btnApprove'])[last()]");
	private final By REJECT_BUTTON = By.xpath("(//a[@id='btnReject'])[last()]");
	

	public void clickOnApproveButton() {
		try {
		driver.pauseExecutionFor(6000);
		driver.waitForElementPresent(APPROVE_BUTTON, 120);
		WebElement element = driver.findElement(APPROVE_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Approve Button Clicked");
		}
		catch (Exception e) {}
	}
	
	
	public void clickOnRejectButton() {
		try {
		driver.pauseExecutionFor(6000);
		driver.waitForElementPresent(REJECT_BUTTON, 120);
		WebElement element = driver.findElement(REJECT_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Reject Button Clicked");
		}
		catch (Exception e) {}
	}
	public void selectFromDate() {
		try {
		driver.waitForElementPresent(By.xpath("//input[@id='FromDate']"), 120);
		driver.clear(By.xpath("//input[@id='FromDate']"));
		driver.findElement(By.xpath("//input[@id='FromDate']")).sendKeys("04/May/2020");
		}
		catch (Exception e) {}
	}
	
	public void clickOnSearchButton() {
		try {
		driver.waitForElementPresent(By.xpath("//a[@id='search_data']//i[@class='fa fa-search']"), 120);
		driver.click(By.xpath("//a[@id='search_data']//i[@class='fa fa-search']"));
		}
		catch (Exception e) {}
	}
	
	public void selectApprovedRadioButton() {
		try {
		driver.waitForElementPresent(By.xpath("//input[@id='approved1']"), 120);
		driver.click(By.xpath("//input[@id='approved1']"));
		}
		catch (Exception e) {}
	}
	
	public void selectRejectRadioButton() {
		try {
		driver.waitForElementPresent(By.xpath("//input[@id='reject1']"), 120);
		driver.click(By.xpath("//input[@id='reject1']"));
		}
		catch (Exception e) {}
	}
}