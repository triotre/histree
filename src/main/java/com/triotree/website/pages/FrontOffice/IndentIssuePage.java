package com.triotree.website.pages.FrontOffice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class IndentIssuePage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(IndentIssuePage.class.getName());

	public IndentIssuePage(TTWebsiteDriver driver) {
		super(driver);
	}

	private final By PRINT_CUMULATIVE_ISSUE_BTN = By.xpath("//div[@class='user_sp_menu']//i[@class='fa fa-line-chart']");
	private final By NEW_RADIO_BUTTON = By.xpath("//input[@id='rbl_New']");
	private final By FIRST_INDENT_NO = By.xpath("//div[@id='IndentIssue_popup']//section[@class='popupBody']//tbody/tr[1]");
	private final By SAVE_FLOPPY_ICON = By.xpath("//a[@id='btnSave']");
	private final By YES_BTN_SAVE_THIS_RECORD_POPUP = By.xpath("//a[contains(text(),'Yes')]");
	private final By YES_BTN_CREATED_SUCCESSFULLY_POPUP = By.xpath("//a[@id='btnYes']");
	private final By CLEAR_BUTTON = By.xpath("//i[@class='fa fa-refresh']");
	private final By PENDING_RADIO_BUTTON = By.xpath("//input[@id='rbl_Pending']");
	private final By MANUAL_MODE_RADIO_BUTTON = By.xpath("//input[@id='rbl_ManualMode']");


	public void clickOnPrintCumulativeIssueButton() {
		try {
		WebElement element =driver.findElement(PRINT_CUMULATIVE_ISSUE_BTN);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Print Cumulative Issue Button clicked");
		}
		catch (Exception e) {
		}
	}

	public void clickOnNewRadioButton() {
		WebElement element = driver.findElement(NEW_RADIO_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("New Radio Button clicked");
	}

	public void selectFirstIndentFromPopup() {
		driver.waitForElementPresent(FIRST_INDENT_NO);
		driver.click(FIRST_INDENT_NO);
		logger.info("Indent No clicked");
	}

	public void clickOnOrderedItemsMedicines(String medicine) {
		driver.waitForElementPresent(By.xpath("//table[@id='tbl_OrderedItems']//td[contains(text(),'"+medicine+"')]"));
		driver.click(By.xpath("//table[@id='tbl_OrderedItems']//td[contains(text(),'"+medicine+"')]"));
	}

	public void selectSubtitutes(String subtitute) {
		driver.findElement(By.xpath("//table[@id='tbl_substute']//td[contains(text(),'"+subtitute+"')]")).click();
	}

	public void clickOnYesButtonOnSaveThisRecordPopup() {
		try {
		driver.waitForElementPresent(YES_BTN_SAVE_THIS_RECORD_POPUP);
		driver.click(YES_BTN_SAVE_THIS_RECORD_POPUP);
		}
		catch (Exception e) {
		}
	}

	public boolean verifyIndentCreatedSuccessMessage(String message) {
		driver.waitForElementPresent(By.xpath("//label[contains(text(),'"+message+"')]"));
		if (driver.findElement(By.xpath("//label[contains(text(),'"+message+"')]")).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}

	public void clickOnYesButtonOnCreatedSuccessfullyPopup() {
		try {
		driver.waitForElementPresent(YES_BTN_CREATED_SUCCESSFULLY_POPUP);
		driver.findElement(YES_BTN_CREATED_SUCCESSFULLY_POPUP).click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnNoButtonOnCreatedSuccessfullyPopup() {
		driver.waitForElementPresent(By.xpath("//a[@id='btnNo']"));
		driver.findElement(By.xpath("//a[@id='btnNo']")).click();
	}
	
	
	public void clickOnClearButton() {
		try {
		WebElement element =driver.findElement(CLEAR_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Clear Button clicked");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickOnPendingRadioButton() {
		WebElement element = driver.findElement(PENDING_RADIO_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Pending Radio Button clicked");
	}
	
	public void clickOnManualModeRadioButton() {
		WebElement element = driver.findElement(MANUAL_MODE_RADIO_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Manual Mode Radio Button clicked");
	}
	
	public void clickOnSaveFloppyIcon() {
		try {
		driver.waitForElementPresent(SAVE_FLOPPY_ICON);
		driver.click(SAVE_FLOPPY_ICON);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void enterFromDate(String date) {
		driver.pauseExecutionFor(4000);
		driver.waitForElementPresent(By.xpath("//input[@id='txt_From']"));
		driver.findElement(By.xpath("//input[@id='txt_From']")).clear();
		driver.findElement(By.xpath("//input[@id='txt_From']")).sendKeys(date);
	}
	
	
	
}
