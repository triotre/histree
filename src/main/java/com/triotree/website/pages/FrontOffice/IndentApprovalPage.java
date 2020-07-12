package com.triotree.website.pages.FrontOffice;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class IndentApprovalPage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(IndentApprovalPage.class.getName());

	public IndentApprovalPage(TTWebsiteDriver driver) {
		super(driver);
	}

	private final By APPROVE_BUTTON = By.xpath("//i[@class='fa fa-check-square-o']");
	private final By REJECT_BUTTON = By.xpath("//i[@class='fa fa-times-circle']");
	private final By REFRESH_BUTTON = By.xpath("//i[@class='fa fa-refresh']");
	private final By NEW_INDENT_RADIO_BUTTON  = By.xpath("//input[@id='radNew']");
	private final By APPROVED_INDENT_RADIO_BUTTON = By.xpath("//input[@id='radApproved']");
	private final By REJECT_INDENT_RADIO_BUTTON = By.xpath("//input[@id='radRejected']");
	private final By FIRST_INDENT_NO = By.xpath("//div[@id='indentPopup']//section[@class='popupBody']//tbody/tr[1]");
	private final By FIRST_INDENT_NUMBER_VALUE_NEW_INDENT = By.xpath("//div[@id='indentPopup']//section[@class='popupBody']//tbody/tr[1]/td[2]");
	private final By YES_BUTTON_APPROVAL_CONFIRMATION_POPUP = By.xpath("//a[@id='btnyes']");
	private final By FIRST_INDENT_NO_APPROVE_POPUP = By.xpath("//div[@id='approvepopup']//section[@class='popupBody']//tbody/tr[1]");
	private final By FIRST_INDENT_NUMBER_VALUE_APPROVE_INDENT = By.xpath("//div[@id='approvepopup']//section[@class='popupBody']//tbody/tr[1]/td[2]");
	private final By YES_BUTTON_REJECTTION_CONFIRMATION_POPUP = By.xpath("//a[@id='btnRyes']");
	private final By FIRST_INDENT_NO_REJECTED_POPUP = By.xpath("//div[@id='rejectpopup']//section[@class='popupBody']//tbody/tr[1]");



	public void clickOnApproveButton() {
		driver.waitForElementPresent(APPROVE_BUTTON);
		WebElement element =driver.findElement(APPROVE_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Approve Button on Indent Approval Page clicked");
	}



	public void clickOnRejectButton() {
		driver.waitForElementPresent(REJECT_BUTTON);
		WebElement element =driver.findElement(REJECT_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Reject Button on Indent Approval Page clicked");
	}

	public void clickOnRefreshButton() {
		driver.waitForElementPresent(REFRESH_BUTTON);
		WebElement element =driver.findElement(REFRESH_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Refresh Button on Indent Approval Page clicked");
	}

	public void clickOnNewIndentRadioButton() {
		WebElement element = driver.findElement(NEW_INDENT_RADIO_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("New Indent Radio Button clicked");
	}

	public void selectFirstIndentFromNewIntendPopup() {
		try {
			driver.waitForElementPresent(FIRST_INDENT_NO);
			driver.click(FIRST_INDENT_NO);
			logger.info("Indent No clicked");
		}
		catch (Exception e) {}
	}

	public void changeQuantityAgainSelectedItem(String medicine, String quantity) {
		try {

			driver.findElement(By.xpath("//td[contains(text(),'"+medicine+"')]/..//following-sibling::td//input[@name='txtNewQuantity']")).clear();
			driver.findElement(By.xpath("//td[contains(text(),'"+medicine+"')]/..//following-sibling::td//input[@name='txtNewQuantity']")).sendKeys(quantity);
			logger.info("Quantity changed");
		}
		catch (Exception e) {}
	}

	public void clickOnYesButtonOnApprovalConfirmationPopup() {
		try {
			driver.findElement(YES_BUTTON_APPROVAL_CONFIRMATION_POPUP).click();
			logger.info("Yes Button On Approval Confirmation Popup Clicked");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickOnYesButtonOnRejectionConfirmationPopup() {
		try {
			driver.findElement(YES_BUTTON_REJECTTION_CONFIRMATION_POPUP).click();
			logger.info("Yes Button On Rejection Confirmation Popup Clicked");
		}
		catch (Exception e) {}
	}

	public void selectFirstIndentFromApproveIntendPopup() {
		try {
			driver.waitForElementPresent(FIRST_INDENT_NO_APPROVE_POPUP);
			driver.click(FIRST_INDENT_NO_APPROVE_POPUP);
			logger.info("Indent No From Approve Popupclicked");
		}
		catch (Exception e) {}
	}

	public void selectFirstIndentFromRejectedIntendPopup() {
		driver.waitForElementPresent(FIRST_INDENT_NO_REJECTED_POPUP);
		driver.click(FIRST_INDENT_NO_REJECTED_POPUP);
		logger.info("Indent No From Rejected Popupclicked");
	}

	public void clickOnApprovedIndentRadioButton() {
		WebElement element = driver.findElement(APPROVED_INDENT_RADIO_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Approve Indent Radio Button clicked");
	}

	public void clickOnRejectedIndentRadioButton() {
		WebElement element = driver.findElement(REJECT_INDENT_RADIO_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Reject Indent Radio Button clicked");
	}

	public String getValueOfIndentNoFromNewIndentPopup() {

		driver.waitForElementPresent(FIRST_INDENT_NUMBER_VALUE_NEW_INDENT);
		return driver.findElement(FIRST_INDENT_NUMBER_VALUE_NEW_INDENT).getText();

	}

	public String getValueOfIndentNoFromApproveIndentPopup() throws InterruptedException {
		//driver.waitForElementPresent(FIRST_INDENT_NUMBER_VALUE_APPROVE_INDENT);
		Thread.sleep(2000);
		return driver.findElement(FIRST_INDENT_NUMBER_VALUE_APPROVE_INDENT).getText();
		
	}

	public void enterFromDate(String date) {
		driver.pauseExecutionFor(4000);
		driver.waitForElementPresent(By.xpath("//input[@id='frmdate']"));
		driver.findElement(By.xpath("//input[@id='frmdate']")).clear();
		driver.findElement(By.xpath("//input[@id='frmdate']")).sendKeys(date);
		driver.findElement(By.xpath("//input[@id='frmdate']")).sendKeys(Keys.ENTER);
	}

	public void selectStore(String store) {
		driver.pauseExecutionFor(4000);
		driver.click(By.xpath("//select[@id='ddlStore']"));
		driver.waitForElementPresent(By.xpath("//select[@id='ddlStore']"));
		Select stationDropDown = new Select(driver.findElement(By.xpath("//select[@id='ddlStore']")));
		stationDropDown.selectByVisibleText(store);


	}

	public boolean verifyIntendCanNotBeModified() {
		return driver.isElementPresent(By.xpath("//div[@class='inventory-maincontainer indent-approval']//tr[1]//td[9]"), 60);
	}


}
