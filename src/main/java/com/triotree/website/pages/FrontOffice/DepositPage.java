package com.triotree.website.pages.FrontOffice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class DepositPage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(DepositPage.class.getName());

	public DepositPage(TTWebsiteDriver driver) {
		super(driver);
	}


	private final By DEPOSIT_BUTTON_HEADER = By.xpath("//a[@id='Deposit_btn']");
	private final By CONFIRM_DEPOSIT_POPUP_MESSAGE = By.xpath("//label[contains(text(),'Confirm Deposit?')]");
	private final By CONFIRM_DEPOSIT_YES_BUTTON = By.xpath("//a[@id='btnDepConfirmYes']");
	private final By AMOUNT_CANNOT_BE_ZERO_MESSAGE = By.xpath("//p[contains(text(),'Amount cannot be zero!')]");
	private final By AMOUNT_TEXT_BOX = By.xpath("//input[@id='Amount']");
	private final By TOTAL_AMOUNT_IN_CASH_MESSAGE = By.xpath("//p[contains(text(),'The total amount in cash is equal to or Exceeds 20')]");
	private final By DEPOSIT_TAKEN_SUCCESSFULLY_MESSAGE = By.xpath("//p[contains(text(),'Deposit taken successfully!')]");
	private final By CREDIT_CARD_RADIO_BUTTON = By.xpath("//input[@id='Credit_']");
	private final By CARD_NO_TEXT_BOX = By.xpath("//div[@class='bhoechie-tab-content active']//div[4]//input[1]");
	private final By CARD_NAME_DROPDOWN = By.xpath("//select[@id='Crd_name']");
	private final By BANK_NAME_DROPDOWN = By.xpath("//select[@id='Bank_Name_cr']");
	private final By TRANSACTION_NO_TEXT_BOX = By.xpath("//input[@id='B_Number_credit']");
	private final By CHEQUE_RADIO_BUTTON = By.xpath("//input[@id='Cheque_']");
	private final By CHEQUE_NO_TEXT_BOX = By.xpath("//input[@id='cheque_no']");
	private final By BANK_NAME_CHEQUE_DROPDOWN = By.xpath("//select[@id='Bank_Name_cheque']");
	private final By BRANCH_NAME_TEXT_BOX = By.xpath("//input[@id='Brach_Number']");
	private final By PRINT_BUTTON_HEADER = By.xpath("//a[@title='Print Receipt']//i[@class='fa fa-print']");
	private final By PLEASE_SELECT_DEPOSIT_RECEIPT_MESSAGE = By.xpath("//p[contains(text(),'Please select the deposit receipt to be printed!')]");
	private final By FIRST_DEPOSIT_DETAILS = By.xpath("//table/thead//following::tbody/tr[1]/td[1]");
	private final By SELECT_MODE_OF_PAYMENT_MESSAGE = By.xpath("//p[contains(text(),'Please select the mode of payment!')]");

	public void clickOnDepositButtonOnHeader() {

		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnremarksOk']"), 120);
			driver.click(By.xpath("//a[@id='btnremarksOk']"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.waitForElementPresent(DEPOSIT_BUTTON_HEADER);
		driver.click(DEPOSIT_BUTTON_HEADER);
	}

	public boolean isConfirmDepositMessageDisplayed() {
		driver.waitForElementPresent(CONFIRM_DEPOSIT_POPUP_MESSAGE);
		return driver.isElementPresent(CONFIRM_DEPOSIT_POPUP_MESSAGE);
	}

	public void clickOnYesButtonOnConfirmDepositPopup() {
		driver.pauseExecutionFor(7000);
		driver.click(CONFIRM_DEPOSIT_YES_BUTTON);
		logger.info("Yes Button Clicked on Confirm Deposit Popup");
	}

	public boolean isAmountCanNotBeZeroMessageDisplayed() {
		driver.waitForElementPresent(AMOUNT_CANNOT_BE_ZERO_MESSAGE);
		return driver.isElementPresent(AMOUNT_CANNOT_BE_ZERO_MESSAGE);
	}

	public void enterEmountInAmountTextBox(String amount) {
		driver.waitForElementPresent(AMOUNT_TEXT_BOX);
		driver.clear(AMOUNT_TEXT_BOX);
		driver.findElement(AMOUNT_TEXT_BOX).sendKeys(amount);
		logger.info("Following Amount has been added in Amount Text Box"+amount);
		
		try {
			driver.findElement(By.xpath("//button[@id='btnEditReceivedBy']")).click();
			driver.pauseExecutionFor(5000);
			driver.findElement(By.xpath("//input[@id='txtReceivedBy']")).sendKeys("Automation");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isTotalAmountInCashMessageDisplayed() {
		driver.waitForElementPresent(TOTAL_AMOUNT_IN_CASH_MESSAGE);
		return driver.isElementPresent(TOTAL_AMOUNT_IN_CASH_MESSAGE);
	}

	public boolean isDepositTakenSuccessfullyMessageDisplayed() {
		driver.waitForElementPresent(DEPOSIT_TAKEN_SUCCESSFULLY_MESSAGE);
		return driver.isElementPresent(DEPOSIT_TAKEN_SUCCESSFULLY_MESSAGE);
	}

	public void clickOnCreditCardRadioButton() {
		driver.waitForElementPresent(CREDIT_CARD_RADIO_BUTTON);
		driver.click(CREDIT_CARD_RADIO_BUTTON);
		logger.info("Credit Card Radio Button Clicked");
	}

	public void enterCreditCardDetails(int cardNo, String cardName, String bankName, String transactionNo) throws InterruptedException {
		driver.waitForElementPresent(CARD_NO_TEXT_BOX);
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)TTWebsiteDriver.driver;
		String s1="document.getElementById('Card_no_Credit').value='123456789'";
		jse.executeScript(s1);


		//driver.findElement(CARD_NO_TEXT_BOX).sendKeys(cardName);
		Select cardNameDropdown = new Select(driver.findElement(CARD_NAME_DROPDOWN));
		cardNameDropdown.selectByVisibleText(cardName);
		Select bankdNameDropdown = new Select(driver.findElement(BANK_NAME_DROPDOWN));
		bankdNameDropdown.selectByVisibleText(bankName);
		driver.findElement(TRANSACTION_NO_TEXT_BOX).sendKeys(transactionNo);
		logger.info("Credit Card Details Entered");
	}

	public void clickOnChequeRadioButton() {
		driver.waitForElementPresent(CHEQUE_RADIO_BUTTON);
		driver.click(CHEQUE_RADIO_BUTTON);
		logger.info("Cheque Radio Button Clicked");
	}

	public void enterChequeDetails(String chequeNo, String bankName, String branchName) {
		driver.waitForElementPresent(CHEQUE_NO_TEXT_BOX);
		driver.findElement(CHEQUE_NO_TEXT_BOX).sendKeys(chequeNo);
		Select bankNameDropdown = new Select(driver.findElement(BANK_NAME_CHEQUE_DROPDOWN));
		bankNameDropdown.selectByVisibleText(bankName);
		driver.findElement(BRANCH_NAME_TEXT_BOX).sendKeys(branchName);
		logger.info("Cheque Details Entered");
	}

	public void clickOnPrintButtonOnHeader() {
		driver.waitForElementPresent(PRINT_BUTTON_HEADER);
		driver.click(PRINT_BUTTON_HEADER);
		logger.info("Print Button Clicked");
	}

	public boolean isPleaseSelectDepositReceiptMessageDisplayed() {
		driver.waitForElementPresent(PLEASE_SELECT_DEPOSIT_RECEIPT_MESSAGE);
		return driver.isElementPresent(PLEASE_SELECT_DEPOSIT_RECEIPT_MESSAGE);
	}

	public void clickOnFirstDepositDetails() {
		driver.waitForElementPresent(FIRST_DEPOSIT_DETAILS);
		driver.click(FIRST_DEPOSIT_DETAILS);
		logger.info("First Deposit Clicked");
	}

	public boolean isSelectModeOfPaymentMessageDisplayed() {
		driver.waitForElementPresent(SELECT_MODE_OF_PAYMENT_MESSAGE);
		return driver.isElementPresent(SELECT_MODE_OF_PAYMENT_MESSAGE);
	}

	public void clickOnClearButton() {
		driver.waitForElementPresent(By.xpath("//a[@id='Clear']//i[@class='fa fa-refresh']"));
		driver.click(By.xpath("//a[@id='Clear']//i[@class='fa fa-refresh']"));
	}

	public void clickYesButtonPatienIsMerged() {
		driver.waitForElementPresent(By.xpath("//a[@id='btnMergedUhidYes']"));
		driver.click(By.xpath("//a[@id='btnMergedUhidYes']"));
	}
	
	public void clickNoButtonPatienIsMerged() {
		driver.waitForElementPresent(By.xpath("//a[@id='btnMergedUhidNo']"));
		driver.click(By.xpath("//a[@id='btnMergedUhidNo']"));
	}
	
	
}
