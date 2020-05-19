package com.triotree.website.pages.FrontOffice;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.oracle.tools.packager.Log;
import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class BillsUtilityPage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(BillsUtilityPage.class.getName());

	public BillsUtilityPage(TTWebsiteDriver driver) {
		super(driver);
	}


	private final By REFUND_BUTTON = By.xpath("//a[@id='refund']");
	private final By SEARCH_BUTTON = By.xpath("//a[@id='search_huiddata']//i[@title='Search']");


	public void clickOnSelectRefundButton() {
		driver.pauseExecutionFor(6000);
		driver.waitForElementPresent(REFUND_BUTTON, 120);
		WebElement element = driver.findElement(REFUND_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Select Refund Button Clicked");
	}

	public void selectServices(String services) {
		//driver.waitForElementPresent(By.xpath("//label[contains(text(),'"+services+"')]//preceding::input[1]"), 120);
		driver.waitForElementPresent(By.xpath("//label[text()='"+services+"']/../input"), 120);
		driver.click(By.xpath("//label[text()='"+services+"']/../input"));

	}
	public void closerefund() 
	{
		driver.findElement(By.xpath("//a[@id='modalcloserefund']")).click();
	}
	public void selectAllServices() {
		List<WebElement> list = driver.findElements(By.xpath("//input[@class='checkbox1 uncheckall12']"));

		for(int i =1; i<=list.size(); i++) {
			driver.pauseExecutionFor(3000);
			driver.findElement(By.xpath("(//input[@class='checkbox1 uncheckall12'])["+i+"]")).click();
		}


	}

	public void clickOnSaveButton() {
		try {
			driver.waitForElementPresent(By.xpath("//i[@class='fa fa-save']"), 120);
			driver.pauseExecutionFor(5000);
			WebElement clickOnSaveButton_element = driver.findElement(By.xpath("//i[@class='fa fa-save']"));
			driver.clickByJS(TTWebsiteDriver.driver, clickOnSaveButton_element);
		}
		catch (Exception e) {
			logger.error("error in clickOnSaveButton billutility");
		}
	}

	public void processDueSettlement() {
		driver.pauseExecutionFor(6000);
		driver.click(By.xpath("//a[@title='Dues Settlement']"));
		driver.pauseExecutionFor(4000);
		driver.click(By.xpath("//i[@class='fa fa-plus']"));
		driver.pauseExecutionFor(4000);
		driver.click(By.xpath("//a[@title='Make Receipt']"));
	}

	public void clickOnServicesIcon() {
		driver.findElement(By.xpath("//a[@id='opbillvisit']")).click();
	}

	public void selectReasonAndSendApprovalRequest(String reason) {
		driver.waitForElementPresent(By.xpath("//select[@id='ReasonForRefund']"), 100);
		Select serviceDropdown = new Select(driver.findElement(By.xpath("//select[@id='ReasonForRefund']")));
		serviceDropdown.selectByVisibleText(reason);
		driver.findElement(By.xpath("//input[@id='RemarksForRefund']")).sendKeys("Automation Remarks");
		driver.pauseExecutionFor(4000);
		driver.click(By.xpath("//button[@id='btnsendReqApproval']"));
	}

	public void clickOnYesButtonApprovalAgainstBillNoPopup() {
		driver.waitForElementPresent(By.xpath("//a[@id='btnyesupdateapproval']"), 120);
		driver.click(By.xpath("//a[@id='btnyesupdateapproval']"));
	}

	public void selectDueSettlementTab() {
		driver.waitForElementPresent(By.xpath("//a[@title='Dues Settlement']"), 120);
		driver.click(By.xpath("//a[@title='Dues Settlement']"));
	}

	public void selectModeOfPayment(String payment) {
		driver.waitForElementPresent(By.xpath("//select[@id='paymentModeDues']"), 100);
		Select serviceDropdown = new Select(driver.findElement(By.xpath("//select[@id='paymentModeDues']")));
		serviceDropdown.selectByVisibleText(payment);
	}

	public void selectModeOfPaymentFromBillUtility(String payment) {
		driver.waitForElementPresent(By.xpath("//select[@id='paymentMode']"), 100);
		Select serviceDropdown = new Select(driver.findElement(By.xpath("//select[@id='paymentMode']")));
		serviceDropdown.selectByVisibleText(payment);
	}

	public void enterChequeDetails() {
		driver.waitForElementPresent(By.xpath("//input[@id='chequeNo']"), 120);
		driver.findElement(By.xpath("//input[@id='chequeNo']")).sendKeys("23456789");

		Select serviceDropdown = new Select(driver.findElement(By.xpath("//select[@id='BankName']")));
		serviceDropdown.selectByVisibleText("Andhra Bank");
		driver.findElement(By.xpath("//input[@id='branchName']")).sendKeys("Testing Branch");
	}




	public void enterCreditCardDetails() {
		driver.waitForElementPresent(By.xpath("//select[@id='creditCardname']"), 100);
		Select serviceDropdown = new Select(driver.findElement(By.xpath("//select[@id='creditCardname']")));
		serviceDropdown.selectByVisibleText("DINERS");
		driver.findElement(By.xpath("//input[@id='cardNumber1']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@id='batchNumber1']")).sendKeys("Testing");
		Select serviceDropdown1 = new Select(driver.findElement(By.xpath("//select[@id='cardBankName']")));
		serviceDropdown1.selectByVisibleText("Bank of America");

	}




	public void selectPlusButton() {
		driver.pauseExecutionFor(5000);
		driver.click(By.xpath("//i[@class='fa fa-plus']"));

	}

	public void searchPatientDetails() {
		driver.waitForElementPresent(SEARCH_BUTTON, 120);
		driver.click(SEARCH_BUTTON);
		driver.waitForElementPresent(By.xpath("//input[@id='modal_chkfromdate']"));
		driver.click(By.xpath("//input[@id='modal_chkfromdate']"));
		driver.findElement(By.xpath("//input[@id='frmdate']")).clear();
		driver.findElement(By.xpath("//input[@id='frmdate']")).sendKeys("01/Aug/2019");
		driver.findElement(By.xpath("//a[@id='search_buttondata']//i[@class='fa fa-search search_buttondata']")).click();
	}

	public void searchPatientDetailsWithoutClickingSearchButton() {

		driver.waitForElementPresent(By.xpath("//input[@id='modal_chkfromdate']"));
		driver.click(By.xpath("//input[@id='modal_chkfromdate']"));
		driver.findElement(By.xpath("//input[@id='frmdate']")).clear();
		driver.findElement(By.xpath("//input[@id='frmdate']")).sendKeys("01/Aug/2019");
		driver.findElement(By.xpath("//a[@id='search_buttondata']//i[@class='fa fa-search search_buttondata']")).click();
	}


	public void clickSearchButton() {
		driver.waitForElementPresent(SEARCH_BUTTON, 120);
		//driver.click(SEARCH_BUTTON);
		WebElement SEARCH_BUTTON_element = driver.findElement(SEARCH_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, SEARCH_BUTTON_element);
	}


	public void selectRegisteredPatient(String patient) {
		String id = patient.trim();

		System.out.println("Hello"+patient+"World");
		driver.waitForElementPresent(By.xpath("//td[contains(text(),'"+id+"')]//ancestor::tr"), 120);
		driver.findElement(By.xpath("//td[contains(text(),'"+id+"')]//ancestor::tr")).click();

	}

	public void enterUsernamePasswordAndSelectApproveButton(String userName, String password) {
		try {
			driver.waitForElementPresent(By.xpath("//input[@id='usrName']"), 120);
			driver.findElement(By.xpath("//input[@id='usrName']")).sendKeys(userName);
			driver.findElement(By.xpath("//input[@id='pswd']")).sendKeys(password);
			driver.findElement(By.xpath("//button[@id='btnRefundApprove']")).click();
		}
		catch (Exception e) {

		}
	}

	public void selectReasonFromReasonDropdown(String reason) {
		try {
			driver.waitForElementPresent(By.xpath("//select[@id='ReasonForRefund']"), 120);
			Select serviceDropdown = new Select(driver.findElement(By.xpath("//select[@id='ReasonForRefund']")));
			serviceDropdown.selectByVisibleText(reason);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterRemarks() {
		try {
			driver.waitForElementPresent(By.xpath("//textarea[@id='remarks']"), 120);
			driver.findElement(By.xpath("//textarea[@id='remarks']")).sendKeys("Automation Remarks");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickYesButtonRefundByCashPopup() {
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnyespayment']"), 120);
			driver.click(By.xpath("//a[@id='btnyespayment']"));
		}
		catch (Exception e) {
			logger.error("error clickYesButtonRefundByCashPopup");
		}
	}

	public void clickNoButtonRefundByCashPopup() {
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnnopayement']"), 120);
			driver.click(By.xpath("//a[@id='btnnopayement']"));
		}
		catch (Exception e) {
			logger.error("error in clickNoButtonRefundByCashPopup");
		}
	}

	public void clickClearButton() {
		driver.waitForElementPresent(By.xpath("//a[@id='Clear']//i[@class='fa fa-refresh']"), 120);
		driver.pauseExecutionFor(12000);
		WebElement element = driver.findElement(By.xpath("//a[@id='Clear']//i[@class='fa fa-refresh']"));
		driver.clickByJS(TTWebsiteDriver.driver, element);
	}


	public boolean verifyRefundIsInPinkColour() {
		return driver.isElementPresent(By.xpath("(//tr[@style='background-color:pink'])[1]"), 120);
	}

	public void selectShowIpCheckbox() {
		driver.waitForElementPresent(By.xpath("//input[@id='modal_IP']"), 120);
		driver.click(By.xpath("//input[@id='modal_IP']"));
	}

	public void selectOpPatientType() {
		driver.waitForElementPresent(By.xpath("(//td[contains(text(),'OP')])[1]"), 120);
		driver.click(By.xpath("(//td[contains(text(),'OP')])[1]"));
	}

	public void selectIPPatientType() {
		driver.waitForElementPresent(By.xpath("(//tr/td[11]//following-sibling::td[contains(text(),'IP')][1])[1]"), 120);
		driver.click(By.xpath("(//tr/td[11]//following-sibling::td[contains(text(),'IP')][1])[1]"));
	}

	public void clearuhidandBillNo() throws InterruptedException 
	{
		driver.findElement(By.xpath("//input[@id='uHid']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='BillNo']")).clear();
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
	public boolean verifyPatientIsOpened() {
		return driver.isElementPresent(By.xpath("//p[contains(text(),'This Remarks Data has been added')]"), 120);
	}

	public void clickSendApprovalRequestButton() {
		driver.waitForElementPresent(By.xpath("//button[@id='btnsendReqApproval']"), 120);
		driver.click(By.xpath("//button[@id='btnsendReqApproval']"));
	}

	public void selectReasonForRefund() {
		driver.pauseExecutionFor(4000);
		Select serviceDropdown = new Select(driver.findElement(By.xpath("//select[@id='ReasonForRefund']")));
		serviceDropdown.selectByVisibleText("Automation Refund Reason");

	}

	public void closeRefundPopup() {
		driver.waitForElementPresent(By.xpath("//a[@id='modalcloserefund']//i[@class='fa fa-times']"));
		driver.click(By.xpath("//a[@id='modalcloserefund']//i[@class='fa fa-times']"));
	}

	public void enterAmountToBeSettled(String amount) {
		driver.waitForElementPresent(By.xpath("//input[@id='settleAmt1']"), 120);
		driver.clear(By.xpath("//input[@id='settleAmt1']"));
		driver.findElement(By.xpath("//input[@id='settleAmt1']")).sendKeys(amount);
	}

	public void clickMakeReceiptButton() {
		driver.pauseExecutionFor(5000);
		driver.waitForElementPresent(By.xpath("//a[@title='Make Receipt']"), 120);
		driver.click(By.xpath("//a[@title='Make Receipt']"));
	}

	public void selectYesApprovalRequestPopup() {
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnyesupdateapproval']"), 120);
			driver.click(By.xpath("//a[@id='btnyesupdateapproval']"));
		}
		catch (Exception e) {
		}
	}
	

}

