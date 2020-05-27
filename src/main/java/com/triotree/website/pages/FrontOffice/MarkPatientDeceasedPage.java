package com.triotree.website.pages.FrontOffice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class MarkPatientDeceasedPage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(MarkPatientDeceasedPage.class.getName());

	public MarkPatientDeceasedPage(TTWebsiteDriver driver) {
		super(driver);
	}
	
	private final By DECEASED_CHECKBOX = By.id("Deceased");
	private final By SAVE_ICON = By.xpath("//i[@class='fa fa-save']");
	private final By INFORMED_BY = By.id("Informed_By");
	private final By YES_BUTTON_ON_MARK_PATIENT_DECEASED_POPUP = By.id("btnyes");
	private final By SEARCH_BUTTON = By.id("searchnew");
	
	public void checkDeceasedCheckbox() {
		driver.waitForElementPresent(DECEASED_CHECKBOX);
		WebElement checkBox = driver.findElement(DECEASED_CHECKBOX);
		driver.clickByJS(TTWebsiteDriver.driver, checkBox);
		logger.info("Deceased Checkbox checked");
	}
	
	public void unCheckDeceasedCheckbox() {
		driver.waitForElementPresent(DECEASED_CHECKBOX);
		WebElement checkBox = driver.findElement(DECEASED_CHECKBOX);
		driver.clickByJS(TTWebsiteDriver.driver, checkBox);
		logger.info("Deceased Checkbox checked");
	}
	
	public void clickOnSaveIcon() {
		driver.waitForElementPresent(SAVE_ICON);
		WebElement SaveIcon_element = driver.findElement(SAVE_ICON);
		driver.clickByJS(TTWebsiteDriver.driver, SaveIcon_element);
		logger.info("Save Icon Clicked");
	}
	
	public void enterInformedBy(String informedBy) {
		driver.findElement(INFORMED_BY).sendKeys(informedBy);
		logger.info("Followinf Informed By has been added " +informedBy);
	}
	
	public void yesButtonOnMarkPatientDeceasedPopup() {
		driver.waitForElementPresent(YES_BUTTON_ON_MARK_PATIENT_DECEASED_POPUP);
		driver.click(YES_BUTTON_ON_MARK_PATIENT_DECEASED_POPUP);
		logger.info("Yes Button On Mark Patient Deceased Popup Clicked");
	}

	public void clickOnSearchIcon() {
		driver.waitForElementPresent(SEARCH_BUTTON);
		WebElement button = driver.findElement(SEARCH_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, button);
		logger.info("Search Icon Near Save Button clicked");
	}
	
	public void enterDOBInSearchPopup(String dob) {
		driver.pauseExecutionFor(5000);
		driver.waitForElementPresent(By.xpath("//input[@id='modal_DOB']"), 120);
		driver.findElement(By.xpath("//input[@id='modal_DOB']")).clear();
		driver.findElement(By.xpath("//input[@id='modal_DOB']")).sendKeys(dob);
	}
	
	public void clickOnSearchButtonOnSearchPopup() {
		driver.waitForElementPresent(By.xpath("//a[@id='search_button']//i[@class='fa fa-search']"), 120);
		driver.click(By.xpath("//a[@id='search_button']//i[@class='fa fa-search']"));
		
	}
	

	
	public boolean verifyUserIsOnMarkPatientDeceasedPage() {
		return driver.isElementPresent(By.xpath("//legend[contains(text(),'Mark Patient Deceased')]"), 120);
	}
	
	
}
