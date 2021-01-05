package com.triotree.website.pages.ADT;

import java.io.File;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Test;
import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class IPDepositRefundformPage extends HISWebsiteBasePage
{


	private static final Logger logger = LogManager.getLogger(ADTHomePage.class.getName());

	public IPDepositRefundformPage(TTWebsiteDriver driver) 
	{
		super(driver);
	}
	int i=0;
	private final By IP_DEPOSIT_REFUND = By.xpath("//li[@id='FOBedTranferMenu']//a[text()='IP Deposit Refund']");
	private final By Bed_Transfer = By.xpath("//li[@id='FOBedTranferMenu']//a[text()=' Bed Transfer']");
	private final By POPUP_TEXT=By.xpath("//div[@class='gritter-without-image']//p");
	private final By UHID_SEARCH_BOX = By.id("uHid");
	private final By AMOUNT=By.id("Amount");
	private final By DEPOSIT_BUTTON=By.id("Deposit");
	private final By REFUND_BUTTON=By.id("Refund");
	private final By OPDEPOSIT_BUTTON=By.id("OpDeposit");
	private final By PATIENT_UHID=By.id("patient_UHId");
	private final By CLEAR_BUTTON=By.id("btnclear");
	private final By OPDEPOSIT_SIDE_BUTTON=By.id("opDeposit");
	private final By TRANSFERRING_AMOUNT=By.id("TAmt");
	private final By IP_NUMBER=By.id("ErNo");
	private final By DEPOSIT_YES=By.id("btnDepositeYes");
	private final By BILL_DETAIL_UHID=By.id("txt_uhid");
	private final By BILL_DETAIL_SEARCH=By.xpath("//a[@id='btn_uhid']//i");
	private final By BILL_DETAIL_IPNUMBER=By.id("txtIpId");
	private final By BILL_DETAIL_REFERSH_BTN=By.id("btnrefresh");
	private final By BILL_DETAIL_CLEAR=By.xpath("//div[@class='popup-icon-top']//a[@id='btnclear']//i");
	private final By RECEPIT_UTILITY=By.id("btnReceiptUti");
	private final By RECEPIT_NUMBER=By.id("txtReceipt");
	private final By PRINT_BUTTON=By.xpath("(//a[@title='Print']//i[@class='fa fa-print print'])[1]");
	private final By BILL_DETAIL_CLOSE=By.id("btnCloseRefund");
	private final By IP_DEPOSIT=By.xpath("//li[@id='FOAddPatientMenu']//a//following-sibling::a[text()='IP Deposit/Refund']");
	private final By FROM_DATE=By.id("dtpfdate");
	private final By TO_DATE=By.id("dtptodate");
	private final By CHECK_IN_HAND_SEARCH=By.id("btnsearch");
	private final By CSV_BUTTON=By.xpath("//a[@id='btnExcel']//i");
	private final By MENU = By.xpath("//i[@class='fa fa-bars']");
	private final By STATION_DROPDOWN = By.id("Department"); 
	private final By YES_STATION_DROPDOWN = By.id("btn_yes_desh");
	private final By VERIFY_CHECK_IN_HAND_DETAIL=By.xpath("//table[@id='Tblviewdata']//tbody//tr");
	private final By SIDE_REFUND_BUTTON=By.id("opbilldiagnostic");
	private final By CASH_RADIO_BUTTON=By.id("Refund_cash");
	private final By REFUND_AMOUNT=By.id("RA_Refund");
	private final By PAYABLE_NAME=By.id("Payble_Refund");
	private final By REFUND_REMARK=By.id("Remarks_Refund"); 
	private final By REFUND_DEPOSIT_YES=By.id("btnRefundYes");
	private final By DD_CHECK_NUMBER=By.id("cheque_no");
	private final By ISSUE_DATE=By.id("Issue_name");
	private final By BANK_NAME=By.id("Bank_Name_cheque");
	private final By BRANCH_NAME=By.id("Brach_Number");
	private final By CHEQUE_AMOUNT=By.id("chequeamt");
	private final By DEPOSIT_CHEQUE_NUMBER=By.id("refund_cheque_no");
	private final By DEPOSIT_ISSUE_DATE=By.id("refund_Issue_name");
	private final By DEPOSIT_BANK_NAME=By.id("refund_Bank_Name_cheque");
	private final By DEPOSIT_BRANCH_NAME=By.id("refund_Brach_Number");
	private final By DEPOSIT_BANK_AMOUNT=By.id("Cheque_Amount_refund_Number");
	private final By DEPOSIT_CHEQUE_RADIO_BUTTON=By.id("Cheque_");
	private final By Refund_CHEQUE_RADIO_BUTTON=By.id("Cheque_refund");
	private final By DEPOSIT_CARD_NUMBER=By.id("Card_no");
	private final By DEPOSIT_CARD_NAME=By.id("Crd_name");
	private final By DEPOSIT_CREDIT_BANK_NAME=By.id("Bank_Name_Credit");
	private final By TRANS_NUMBER=By.id("B_Number");
	private final By CREDIT_AMOUNT=By.id("CreditAmt");



	public void clickOnAdmitPatientAndSelectAnOption(String option) throws InterruptedException {
		driver.waitForElementPresent(IP_DEPOSIT_REFUND);
		driver.click(IP_DEPOSIT_REFUND);
		logger.info("IP Deposit/Refund Section is Expanded");

		driver.waitForElementPresent(By.xpath("//ul[@style='display: block;']//a[text()='" + option + "']"), 120);
		WebElement options = driver.findElement(By.xpath("//ul[@style='display: block;']//a[text()='" + option + "']"));
		options.click();
		logger.info("Following Option has been selected from IP Deposit/Refund Section " + option);

		driver.waitForPageLoad();
		Thread.sleep(5000);
	}

	public void clickOnBedTransferAndSelectAnOption(ExtentTest test,String option) throws InterruptedException {
		driver.waitForElementPresent(Bed_Transfer);
		driver.click(Bed_Transfer);
		logger.info("Bed Transfer Section is Expanded");
		Markup m1=MarkupHelper.createLabel("Bed Transfer Section is Expanded", ExtentColor.GREEN);
		test.info(m1);
		
		driver.waitForElementPresent(By.xpath("//ul[@style='display: block;']//a[text()='" + option + "']"), 120);
		WebElement options = driver.findElement(By.xpath("//ul[@style='display: block;']//a[text()='" + option + "']"));
		options.click();
		logger.info("Following Option has been selected from Bed Transfer Section " + option);
		Markup m2=MarkupHelper.createLabel("Following Option has been selected from Bed Transfer Section " + option, ExtentColor.GREEN);
		test.info(m2);
		
		driver.waitForPageLoad();
		Thread.sleep(5000);
	}
	public void selectStationAndClickOnYes(ExtentTest test,String station) throws InterruptedException {
		try {
			Select stationDropDown = new Select(driver.findElement(STATION_DROPDOWN));
			Thread.sleep(2000);		
			stationDropDown.selectByVisibleText(station);
			Markup m=MarkupHelper.createLabel("Following Station has been selected from Station Dropdown : " + station, ExtentColor.GREEN);
			test.info(m);
			logger.info("Following Station has been selected from Station Dropdown : " + station);
		}
		catch (Exception e) {
			Markup m=MarkupHelper.createLabel("Following Station has been not selected from Station Dropdown : " + station, ExtentColor.RED);
			test.info(m);
		}
		try {
			driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(YES_STATION_DROPDOWN));
			logger.info("YES has been clicked from Station Dropdown");
			Markup m=MarkupHelper.createLabel("YES has been clicked from Station Dropdown", ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {
			Markup m=MarkupHelper.createLabel("YES has been not clicked from Station Dropdown", ExtentColor.RED);
			test.info(m);
		}

	}

	public void clickOnMenu(ExtentTest test) throws InterruptedException {
		try {
			driver.waitForElementPresent(MENU);
			WebElement clickOnMenu_element = driver.findElement(MENU);
			driver.clickByJS(TTWebsiteDriver.driver, clickOnMenu_element);
			logger.info("Menu Clicked");
			Markup m=MarkupHelper.createLabel("Menu Clicked", ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(2000);
		}
		catch (Exception e) {
		}
	}

	public void clickOnIpDepositandRefund(ExtentTest test,String option) throws InterruptedException {
		driver.waitForElementPresent(IP_DEPOSIT);
		driver.click(IP_DEPOSIT);
		logger.info("IP Deposit/Refund Section is Expanded");
		Markup m=MarkupHelper.createLabel("IP Deposit/Refund Section is Expanded", ExtentColor.GREEN);
		test.info(m);
		driver.waitForElementPresent(By.xpath("//ul[@style='display: block;']//a[text()='" + option + "']"), 120);
		WebElement options = driver.findElement(By.xpath("//ul[@style='display: block;']//a[text()='" + option + "']"));
		options.click();
		logger.info("Following Option has been selected from IP Deposit/Refund Section " + option);
		Markup m1=MarkupHelper.createLabel("Following Option has been selected from IP Deposit/Refund Section " + option, ExtentColor.GREEN);
		test.info(m1);
		driver.waitForPageLoad();
		Thread.sleep(3000);
	}

	public void searchUHIDFromSearchBoxOnHeader(String uhid) throws InterruptedException {
		try {
			driver.waitForElementPresent(UHID_SEARCH_BOX);
			driver.findElement(UHID_SEARCH_BOX).clear();
			driver.findElement(UHID_SEARCH_BOX).sendKeys(uhid);
			Thread.sleep(4000);

			driver.findElement(UHID_SEARCH_BOX).sendKeys(Keys.ENTER);
			logger.info("Following UHID has been searched from Search Box" + uhid);	

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void validatepopuptext(ExtentTest test) {
		String text = driver.findElement(POPUP_TEXT).getText();

		if(text.equals("The patient has been discharged!")) 
		{
			//Test.class.
			Assert.assertEquals("The patient has been discharged!", "The patient has been discharged!");
			logger.info(text+" is equal to "+"The patient has been discharged!");
		}

		if(text.equals("Please enter IP number and select!")) 
		{
			Assert.assertEquals("Please enter IP number and select!", "Please enter IP number and select!");
			logger.info(text+" is equal to "+"Please enter IP number and select!");
			Markup m=MarkupHelper.createLabel(text+" PopUp message is Appear", ExtentColor.GREEN);
			test.info(m);
		}

		if(text.equals("Transferring amount can not be greater than balance!"))
		{
			Assert.assertEquals("Transferring amount can not be greater than balance!", "Transferring amount can not be greater than balance!");
			logger.info(text+" is equal to "+"Transferring amount can not be greater than balance!");

		}

		if(text.equals("Amount cannot be zero!"))
		{
			Assert.assertEquals("Amount cannot be zero!","Amount cannot be zero!");
			logger.info(text+" is equal to "+"Amount cannot be zero!");
			Markup m=MarkupHelper.createLabel("Amount cannot be zero!", ExtentColor.GREEN);
			test.info(m);
		}

		if(text.equals("Deposit taken successfully!")) 
		{
			logger.info(text+" is equal to "+"Deposit taken successfully!");
			Markup m=MarkupHelper.createLabel("Deposit taken successfully!", ExtentColor.GREEN);
			test.info(m);
		}
		if(text.equals("From date Can not be Greater Then To Date"))
		{
			Assert.assertEquals("From date Can not be Greater Then To Date","From date Can not be Greater Then To Date");
			logger.info(text+" is equal to "+"From date Can not be Greater Then To Date");
			Markup m=MarkupHelper.createLabel("From date Can not be Greater Then To Date", ExtentColor.GREEN);
			test.info(m);
		}

		if(text.equals("No Records")) {
			Assert.assertEquals("No Records","No Records");
			logger.info(text+" is equal to "+"No Records");
			Markup m=MarkupHelper.createLabel("No Records", ExtentColor.GREEN);
			test.info(m);	
			Markup m1=MarkupHelper.createLabel("File not get downloaded", ExtentColor.GREEN);
			test.info(m1);	
		}

		if(text.equals("Refund given successfully!")) {
			Assert.assertEquals("Refund given successfully!","Refund given successfully!");
			logger.info(text+" is equal to "+"Refund given successfully!");	
			Markup m1=MarkupHelper.createLabel("Refund given successfully!", ExtentColor.GREEN);
			test.info(m1);		
		}

		if(text.equals("Please select a mode of Payment and then enter the amount")) 
		{
			Assert.assertEquals("Please select a mode of Payment and then enter the amount","Please select a mode of Payment and then enter the amount");
			logger.info(text+" is equal to "+"Please select a mode of Payment and then enter the amount");	
			Markup m1=MarkupHelper.createLabel("Please select a mode of Payment and then enter the amount", ExtentColor.GREEN);
			test.info(m1);		

		}
	}

	public void enterAmount(ExtentTest test,String amount) throws InterruptedException 
	{
		if(i==1) 
		{
			driver.findElement(AMOUNT).clear();
		}
		driver.findElement(AMOUNT).sendKeys(amount);
		driver.findElement(AMOUNT).sendKeys(Keys.ENTER);
		logger.info("Deposit Amount= "+amount);
		Markup m1=MarkupHelper.createLabel("Deposit Amount= "+amount, ExtentColor.GREEN);
		test.info(m1);	
		Thread.sleep(4000);
		i++;

	}

	public void clickondepositbutton() throws InterruptedException 
	{
		WebElement deposit = driver.findElement(DEPOSIT_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, deposit);
		logger.info("Click on Deposit Button");
		Thread.sleep(2000);
	}

	public void clickonHeaderrefundbutton(ExtentTest test) throws InterruptedException 
	{
		WebDriverWait wt= new WebDriverWait(driver, 120);
		wt.until(ExpectedConditions.elementToBeClickable(REFUND_BUTTON));

		WebElement REFUND_BUTTON_element = driver.findElement(REFUND_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, REFUND_BUTTON_element);
		logger.info("Click on Refund Button");
		Thread.sleep(2000);
		if(driver.findElements(REFUND_DEPOSIT_YES).size()>0) 
		{
			logger.info("Header Refund Button is Clickable");
			Markup m=MarkupHelper.createLabel("Header Refund Button is Clickable", ExtentColor.GREEN);
			test.info(m);	
		}
		else {
			logger.info("Header Refund Button is not Clickable");
			Markup m=MarkupHelper.createLabel("Header Refund Button is not Clickable", ExtentColor.RED);
			test.info(m);
		}
	}

	public void clickonopdepositbutton() throws InterruptedException 
	{
		driver.findElement(OPDEPOSIT_BUTTON).click();
		logger.info("Click on OP Deposit Button");
		Thread.sleep(2000);
	}

	public void validatepatientuhid(ExtentTest test) throws InterruptedException
	{
		if(driver.findElements(PATIENT_UHID).size()>0) 
		{
			String patient_uhid = driver.findElement(PATIENT_UHID).getText();
			logger.info("Patient Details are getting fetched up= "+patient_uhid);
			Markup m=MarkupHelper.createLabel("Patient Details are getting fetched up "+patient_uhid, ExtentColor.GREEN);
			test.info(m);
		}
		Thread.sleep(2000);
	}

	public void clickonclearbutton() throws InterruptedException 
	{
		WebElement clear = driver.findElement(CLEAR_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, clear);
		logger.info("Click on Clear button");
		Thread.sleep(2000);
	}

	public void clickonSideOPButton(ExtentTest test) throws InterruptedException {

		WebElement OPDEPOSelement = driver.findElement(OPDEPOSIT_SIDE_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, OPDEPOSelement);
		logger.info("Click on Side OP Button");
		Thread.sleep(2000);
		List<WebElement> transfer_checkbox = driver.findElements(By.id("cbdeposite")); 
		for(int i=1;i<=transfer_checkbox.size();i++)
		{
			WebElement transfer_checkbox_element = driver.findElement(By.xpath("(//input[@id='cbdeposite'])["+i+"]"));
			if(transfer_checkbox_element.isSelected()) 
			{
				String Receipt_No = driver.findElement(By.xpath("(//input[@id='cbdeposite'])["+i+"]//preceding::td[@ctype='receiptno']")).getText();

				logger.info("Transfer To (IP) Check Box got selected ");
				Markup m=MarkupHelper.createLabel("Transfer To (IP) Check Box got selected. Receipt No.= "+Receipt_No, ExtentColor.GREEN);
				test.info(m);	
			}
			else {
				logger.info("Transfer To (IP) Check Box got selected ");
				Markup m=MarkupHelper.createLabel("Transfer To (IP) Check Box is not got selected ", ExtentColor.RED);
				test.info(m);		
			}
		}
	}

	public void enterTransferringAmount(ExtentTest test,String amount) 
	{
		List<WebElement> balance = driver.findElements(By.xpath("//table[@id='optbldeposit']//tbody//td[@ctype='balance']"));
		for(int i=1;i<=balance.size();i++) 
		{
			String balance_amount = driver.findElement(By.xpath("(//table[@id='optbldeposit']//tbody//td[@ctype='balance'])["+i+"]")).getText();
			driver.findElement(TRANSFERRING_AMOUNT).sendKeys(amount);
			try {
				driver.findElement(OPDEPOSIT_BUTTON).click();
			}
			catch (Exception e) {
				logger.info("Deposit is not got transferred in IP Deposit/Refund");
				Markup m=MarkupHelper.createLabel("Deposit is not got transferred in IP Deposit/Refund", ExtentColor.RED);
				test.info(m);			
			}
			break; 
		}	

	}

	public void enterIPNumber(ExtentTest test,String ipnumber) throws InterruptedException 
	{
		driver.findElement(IP_NUMBER).sendKeys(ipnumber);
		driver.findElement(IP_NUMBER).sendKeys(Keys.ENTER);
		logger.info("IP Number= "+ipnumber);
		Markup m1=MarkupHelper.createLabel("IP Number= "+ipnumber, ExtentColor.GREEN);
		test.info(m1);	
		Thread.sleep(2000);
	}

	public void clickonDeposityesbutton() 
	{
		driver.findElement(DEPOSIT_YES).click();
		logger.info("Click on Deposit yes Button");
	}

	public void enterbilldetailsuhid(String uhid) throws InterruptedException 
	{
		driver.findElement(BILL_DETAIL_UHID).clear();
		driver.findElement(BILL_DETAIL_UHID).sendKeys(uhid);
		Thread.sleep(2000);
		driver.findElement(BILL_DETAIL_SEARCH).click();
	}

	public void enterbilldetailsIPNumber(ExtentTest test,String ipnumber) throws InterruptedException 
	{
		driver.findElement(BILL_DETAIL_IPNUMBER).sendKeys(ipnumber);
		logger.info("IP Number= "+ipnumber);
		Thread.sleep(2000);
		driver.findElement(BILL_DETAIL_IPNUMBER).sendKeys(Keys.ENTER);

		if(driver.findElements(By.xpath("//table[@id='dgbilldetails']//tbody//tr")).size()>0) 
		{
			logger.info("Patient Details are getting fetched according to this IP Number= "+ipnumber);	
			Markup m=MarkupHelper.createLabel("Patient Details are getting fetched according to this IP Number= "+ipnumber, ExtentColor.GREEN);
			test.info(m);
		}
		else {
			logger.info("Patient Details are not getting fetched according to this IP Number= "+ipnumber);	
			Markup m=MarkupHelper.createLabel("Patient Details are not getting fetched according to this IP Number= "+ipnumber, ExtentColor.RED);
			test.info(m);
		}
	}

	public void clickonRefershbutton() 
	{
		driver.findElement(BILL_DETAIL_REFERSH_BTN).click();
		logger.info("Click on Refersh Button");
	}

	public void clickonbilldetailclearbutton() throws InterruptedException {
		driver.findElement(BILL_DETAIL_CLEAR).click();
		logger.info("Click on Bill Detail Clear Button");
		Thread.sleep(2000);
	}

	public void clickonReceiptUtility(ExtentTest test) 
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(RECEPIT_UTILITY));
			driver.findElement(RECEPIT_UTILITY).click();
			logger.info("Click on Receipt Utility");
			Markup m=MarkupHelper.createLabel("Receipt Utility got selected", ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {
			logger.info("Not click on Receipt Utility");
			Markup m=MarkupHelper.createLabel("Receipt Utility is not clickable", ExtentColor.RED);
			test.info(m);
		}
		if(driver.findElements(By.xpath("//div[@id='popup1150']//header//span")).size()>0)
		{
			logger.info("Receipt Utility is form is opening");
			Markup m=MarkupHelper.createLabel("Receipt Utility form is opening", ExtentColor.GREEN);
			test.info(m);
		}
		else {
			logger.info("Receipt Utility is not form is opening");
			Markup m=MarkupHelper.createLabel("Receipt Utility form is not opening", ExtentColor.RED);
			test.info(m);
		}
	}

	public void enterRecepitNumber(ExtentTest test,String recepit) throws InterruptedException 
	{
		driver.findElement(RECEPIT_NUMBER).sendKeys(recepit);
		driver.findElement(RECEPIT_NUMBER).sendKeys(Keys.ENTER);

		logger.info("Recepit Number= "+recepit);

		if(driver.findElements(By.xpath("//table[@id='dgbilldetails']//tbody//tr")).size()>0) 
		{
			logger.info("Patient Details are getting fetched according to this Recepit Number= "+recepit);	
			Markup m=MarkupHelper.createLabel("Patient Details are getting fetched according to this Recepit Number= "+recepit, ExtentColor.GREEN);
			test.info(m);
			clickonPrintButton(test);
		}
		else {
			logger.info("Patient Details are not getting fetched according to this Recepit Number= "+recepit);	
			Markup m=MarkupHelper.createLabel("Patient Details are not getting fetched according to this Recepit Number= "+recepit, ExtentColor.RED);
			test.info(m);
		}
	}

	public void clickonPrintButton(ExtentTest test) throws InterruptedException 
	{
		driver.findElement(PRINT_BUTTON).click();
		logger.info("Click on Print Button");
		driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
		if(driver.getWindowHandles().size()>0) 
		{
			logger.info("Receipt gets printed");
			Markup m=MarkupHelper.createLabel("Receipt gets printed", ExtentColor.GREEN);
			test.info(m);
		}
		else {
			logger.info("Receipt not gets printed");
			Markup m=MarkupHelper.createLabel("Receipt not gets printed", ExtentColor.RED);
			test.info(m);	
		}
		Thread.sleep(5000);

		driver.close();
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

	}

	public void clickonBillDetailclosebutton() 
	{
		driver.findElement(BILL_DETAIL_CLOSE).click();
		logger.info("Click on Bill Detail Close Button");
	}

	public void getheading(ExtentTest test,String heading) 
	{
		String heading_text = driver.findElement(By.xpath("//div//following-sibling::h2[text()]")).getText();
		if(heading_text.equals(heading)) 
		{
			logger.info("Form is getting open="+heading_text);	
			Markup m=MarkupHelper.createLabel(heading_text+" Form Got Opened", ExtentColor.GREEN);
			test.info(m);
		}
		else {
			Markup m=MarkupHelper.createLabel(heading_text+" Form not Got Opened", ExtentColor.RED);
			test.info(m);
		}
	}

	public void enterFromDate(ExtentTest test,String fromdate) 
	{
		driver.findElement(FROM_DATE).clear();
		driver.findElement(FROM_DATE).sendKeys(fromdate);
		driver.findElement(FROM_DATE).sendKeys(Keys.ENTER);
		logger.info("From Date= "+fromdate);
		Markup m=MarkupHelper.createLabel("Date Range from="+fromdate, ExtentColor.GREEN);
		test.info(m);
	}

	public void enterToDate(ExtentTest test,String todate) 
	{
		driver.findElement(TO_DATE).clear();
		driver.findElement(TO_DATE).sendKeys(todate);
		driver.findElement(TO_DATE).sendKeys(Keys.ENTER);
		logger.info("TO Date= "+todate);
		Markup m=MarkupHelper.createLabel("TO Date= "+todate, ExtentColor.GREEN);
		test.info(m);
	}

	public void clickoncheckInHandSearch(ExtentTest test)
	{
		driver.findElement(CHECK_IN_HAND_SEARCH).click();
		logger.info("Click on Search Button");
		Markup m=MarkupHelper.createLabel("Click on Search Button", ExtentColor.GREEN);
		test.info(m);
	}


	public void clickonCSVButton(ExtentTest test) throws InterruptedException 
	{
		driver.findElement(CSV_BUTTON).click();
		logger.info("Click on CSV Button");
		Thread.sleep(4000);
		File file=new File("./Downloads");
		File []listoffiles=file.listFiles();

		for(int i=0;i<listoffiles.length;i++) 
		{
			if(listoffiles[i].isFile()) 
			{
				String filename=listoffiles[i].getName();
				if(filename.contains("Cheque In Hand ") && filename.endsWith("csv")) 
				{
					Markup m=MarkupHelper.createLabel("File get downloaded", ExtentColor.GREEN);
					test.info(m);
				}
			}
		}

	}

	public void verifycheckInHandDetails(ExtentTest test) 
	{
		if(driver.findElements(VERIFY_CHECK_IN_HAND_DETAIL).size()>0) 
		{
			logger.info("Data is getting fetched according to the selected date range");
			Markup m=MarkupHelper.createLabel("Data is getting fetched according to the selected date range", ExtentColor.GREEN);
			test.info(m);
		}
		else {
			logger.info("Data is not getting fetched according to the selected date range");
			Markup m=MarkupHelper.createLabel("Data is not getting fetched according to the selected date range", ExtentColor.RED);
			test.info(m);	
		}
	}

	public void clickonRefundbutton(ExtentTest test,String amount,String name,String remark) throws InterruptedException 
	{
		List<WebElement> DepositRefundDetails = driver.findElements(By.xpath("//table[@id='tbldeposit']//tbody//tr"));
		int depositsize=DepositRefundDetails.size();
		if(depositsize>0)
		{
			logger.info("Refund Data is getting fetched");
			Markup m=MarkupHelper.createLabel("Refund Data is getting fetched", ExtentColor.GREEN);
			test.info(m);	
			WebDriverWait wt=new WebDriverWait(driver, 120);
			wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//table[@id='tbldeposit']//tbody//tr)["+depositsize+"]"))));
			WebElement deposit_element = driver.findElement(By.xpath("(//table[@id='tbldeposit']//tbody//tr)["+depositsize+"]"));
			driver.clickByJS(TTWebsiteDriver.driver, deposit_element);
		}
		else {
			logger.info("Refund Data is not getting fetched");
			Markup m=MarkupHelper.createLabel("Refund Data is not getting fetched", ExtentColor.GREEN);
			test.info(m);	
		}
		driver.findElement(CASH_RADIO_BUTTON).click();
		driver.findElement(REFUND_AMOUNT).sendKeys(amount);
		Thread.sleep(2000);
		driver.findElement(PAYABLE_NAME).sendKeys(name);
		Thread.sleep(2000);
		driver.findElement(REFUND_REMARK).sendKeys(remark);
		Thread.sleep(2000);
		logger.info("Refund Amount= "+amount+" Payable Name= "+name+" Refund Remark= "+ remark);
		Markup m=MarkupHelper.createLabel("Refund Amount= "+amount+" Payable Name= "+name+" Refund Remark= "+ remark, ExtentColor.GREEN);
		test.info(m);
	}

	public void clickonRefundDeposit(ExtentTest test) 
	{
		try {
			WebDriverWait wt =new WebDriverWait(driver, 120);
			wt.until(ExpectedConditions.elementToBeClickable(REFUND_DEPOSIT_YES));
			WebElement REFUND_DEPOSIT = driver.findElement(REFUND_DEPOSIT_YES);
			driver.clickByJS(TTWebsiteDriver.driver, REFUND_DEPOSIT);
			logger.info("Click Yes on Refund Deposit");
			Markup m=MarkupHelper.createLabel("Click Yes on Refund Deposit", ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {}
	}

	public void enterChequeNumber(ExtentTest test,String chequenumber) throws InterruptedException 
	{
		try {
			driver.findElement(DD_CHECK_NUMBER).sendKeys(chequenumber);	
			Thread.sleep(1000);
			logger.info("Check Number= "+chequenumber);
			Markup m=MarkupHelper.createLabel("Check Number= "+chequenumber, ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void enterIssueDate(ExtentTest test,String issuedate) throws InterruptedException 
	{
		try {
			driver.findElement(ISSUE_DATE).clear();
			driver.findElement(ISSUE_DATE).sendKeys(issuedate);
			Thread.sleep(1000);
			logger.info("Issue Date= "+issuedate);
			Markup m=MarkupHelper.createLabel("Issue Date= "+issuedate, ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {}
	}

	public void selectBankName(ExtentTest test,String bankname) throws InterruptedException
	{
		try {
			TTWebsiteDriver.selectByvisibletext(BANK_NAME, bankname);
			Thread.sleep(1000);
			logger.info("Bank Name= "+bankname);
			Markup m=MarkupHelper.createLabel("Bank Name= "+bankname, ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {}
	}

	public void enterBranchName(ExtentTest test,String branchname) throws InterruptedException 
	{
		try {
			driver.findElement(BRANCH_NAME).sendKeys(branchname);
			Thread.sleep(1000);
			logger.info("Branch Name= "+branchname);
			Markup m=MarkupHelper.createLabel("Branch Name= "+branchname, ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {}
	}

	public void enterchequeAmount(ExtentTest test,String chequeamount) throws InterruptedException 
	{
		try {
			driver.findElement(CHEQUE_AMOUNT).sendKeys(chequeamount);
			Thread.sleep(1000);
			logger.info("Cheque Amount= "+chequeamount);
			Markup m=MarkupHelper.createLabel("Cheque Amount= "+chequeamount, ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {}
	}

	public void enterdepositchequenumber(ExtentTest test,String chequenumber) throws InterruptedException 
	{
		try {
			driver.findElement(DEPOSIT_CHEQUE_NUMBER).sendKeys(chequenumber);
			logger.info("Deposit Cheque Number= "+chequenumber);
			Markup m=MarkupHelper.createLabel("Deposit Cheque Number= "+chequenumber, ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(1000);
		}
		catch (Exception e) {}
	}

	public void enterDepositIssueDate(ExtentTest test,String issuedate) throws InterruptedException 
	{
		try {
			driver.findElement(DEPOSIT_ISSUE_DATE).clear();
			driver.findElement(DEPOSIT_ISSUE_DATE).sendKeys(issuedate);
			Thread.sleep(1000);
			logger.info("Deposit Issue Date= "+issuedate);
			Markup m=MarkupHelper.createLabel("Deposit Issue Date= "+issuedate, ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {}
	}

	public void selectDepositBankName(ExtentTest test,String bankname) throws InterruptedException
	{
		try {
			TTWebsiteDriver.selectByvisibletext(DEPOSIT_BANK_NAME, bankname);
			Thread.sleep(1000);
			logger.info("Deposit Bank Name= "+bankname);
			Markup m=MarkupHelper.createLabel("Deposit Bank Name= "+bankname, ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {}
	}

	public void enterDepositBranchName(ExtentTest test,String branchname) throws InterruptedException 
	{
		try {
			driver.findElement(DEPOSIT_BRANCH_NAME).sendKeys(branchname);
			Thread.sleep(1000);
			logger.info("Deposit Branch Name= "+branchname);
			Markup m=MarkupHelper.createLabel("Deposit Branch Name= "+branchname, ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(2000);
		}
		catch (Exception e) {}
	}

	public void enterDepositchequeAmount(ExtentTest test,String chequeamount) throws InterruptedException 
	{
		try {
			driver.findElement(DEPOSIT_BANK_AMOUNT).sendKeys(chequeamount);
			Thread.sleep(1000);
			logger.info("Deposit Cheque Amount= "+chequeamount);
			Markup m=MarkupHelper.createLabel("Deposit Cheque Amount= "+chequeamount, ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(2000);
		}
		catch (Exception e) {}
	}

	public void clickonRefundAmount(ExtentTest test) throws InterruptedException {

		List<WebElement> DepositRefundDetails = driver.findElements(By.xpath("//table[@id='tbldeposit']//tbody//tr"));
		int depositsize=DepositRefundDetails.size();
		if(depositsize>0)
		{
			logger.info("Refund Data is getting fetched");
			Markup m=MarkupHelper.createLabel("Refund Data is getting fetched", ExtentColor.GREEN);
			test.info(m);	
			Thread.sleep(2000);
			WebElement deposit = driver.findElement(By.xpath("(//table[@id='tbldeposit']//tbody//tr)["+depositsize+"]//td[@ctype='balance']"));
			driver.clickByJS(TTWebsiteDriver.driver, deposit);

		}
		else {
			logger.info("Refund Data is not getting fetched");
			Markup m=MarkupHelper.createLabel("Refund Data is not getting fetched", ExtentColor.GREEN);
			test.info(m);	
		}
	}

	public void clickonDepositchequeradiobutton(ExtentTest test) throws InterruptedException 
	{
		try {
			WebElement chequeradiobutton = driver.findElement(DEPOSIT_CHEQUE_RADIO_BUTTON);
			driver.clickByJS(TTWebsiteDriver.driver, chequeradiobutton);
			logger.info("Click on Cheque Radio Button");
			Markup m=MarkupHelper.createLabel("Click on Cheque Radio Button", ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(2000);
		}
		catch (Exception e) {}
	}

	public void clickonRefundchequeradiobutton(ExtentTest test) throws InterruptedException 
	{
		try {
			WebElement chequeradiobutton = driver.findElement(Refund_CHEQUE_RADIO_BUTTON);
			driver.clickByJS(TTWebsiteDriver.driver, chequeradiobutton);
			logger.info("Click on Cheque Radio Button");
			Markup m=MarkupHelper.createLabel("Click on Cheque Radio Button", ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(2000);
		}
		catch (Exception e) {}
	}

	public void clickonsiderefundbutton(ExtentTest test) throws InterruptedException
	{
		try {
			driver.findElement(SIDE_REFUND_BUTTON).click();
			logger.info("Click on Refund Button");
			Markup m=MarkupHelper.createLabel("Click on Refund Button", ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(2000);
		}
		catch (Exception e) {}
	}

	public void enterCreditCardNumber(ExtentTest test,String cardnumber) throws InterruptedException 
	{
		try {
			driver.findElement(DEPOSIT_CARD_NUMBER).sendKeys(cardnumber);
			logger.info("Deposit Card Number= "+cardnumber);
			Markup m=MarkupHelper.createLabel("Deposit Card Number= "+cardnumber, ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(2000);
		}
		catch (Exception e) {}
	}

	public void selectcreditcardName(ExtentTest test,String cardname) throws InterruptedException 
	{
		try {
			TTWebsiteDriver.selectByvisibletext(DEPOSIT_CARD_NAME, cardname);
			logger.info("Deposit Credit Card Name= "+cardname);
			Markup m=MarkupHelper.createLabel("Deposit Credit Card Name= "+cardname, ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(2000);
		}
		catch (Exception e) {}
	}

	public void selectcreditcardBankName(ExtentTest test,String cardname) throws InterruptedException 
	{
		try {
			TTWebsiteDriver.selectByvisibletext(DEPOSIT_CREDIT_BANK_NAME, cardname);
			logger.info("Deposit Bank Name= "+cardname);
			Markup m=MarkupHelper.createLabel("Deposit Bank Name= "+cardname, ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(2000);
		}
		catch (Exception e) {}
	}

	public void enterTransNumber(ExtentTest test,String transnumber) 
	{
		try {
			driver.findElement(TRANS_NUMBER).sendKeys(transnumber);
			logger.info("Deposit Trans Number= "+transnumber);
			Markup m=MarkupHelper.createLabel("Deposit Trans Number= "+transnumber, ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {}
	}

	public void entercreditcardamount(ExtentTest test,String amount) {
		try {
			driver.findElement(CREDIT_AMOUNT).sendKeys(amount);
			logger.info("Deposit Number= "+amount);
			Markup m=MarkupHelper.createLabel("Deposit Number= "+amount, ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {}
	}

	public void clickoncredticardradiobutton(ExtentTest test)
	{
		WebDriverWait wt=new WebDriverWait(driver, 20);
		wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("Credit_"))));
		driver.findElement(By.id("Credit_")).click();
		logger.info("Click on Credit Card radio Button");
		Markup m=MarkupHelper.createLabel("Click on Credit Card radio Button", ExtentColor.GREEN);
		test.info(m);
	}

	public void clickonRefundcreditcardradiobutton() throws InterruptedException
	{
		try {
			WebElement Credit_refund = driver.findElement(By.id("Credit_refund"));
			driver.clickByJS(TTWebsiteDriver.driver, Credit_refund);
			logger.info("Click on Refund Credit Card radio Button");
			Thread.sleep(2000);
		}
		catch (Exception e) {}
	}

	public void enterRefundDDchecknumber(ExtentTest test,String cardnumber) throws InterruptedException 
	{
		try {
			driver.findElement(By.id("refund_Card_no")).sendKeys(cardnumber);
			logger.info("Refund Check Number= "+cardnumber);
			Markup m=MarkupHelper.createLabel("Refund Check Number= "+cardnumber, ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(2000);
		}
		catch (Exception e) {}
	}

	public void selectRefundCreditCardName(ExtentTest test,String cardname) throws InterruptedException 
	{
		try {
			TTWebsiteDriver.selectByvisibletext(By.id("refund_Crd_name"), cardname);
			logger.info("Refund card Name= "+cardname);
			Markup m=MarkupHelper.createLabel("Refund card Name= "+cardname, ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(2000);
		}
		catch (Exception e) {}
	}

	public void selectRefundCreditCardBankName(ExtentTest test,String bankname) throws InterruptedException
	{
		try {
			TTWebsiteDriver.selectByvisibletext(By.id("refund_Bank_Name"), bankname);
			logger.info("Refund Bank Name= "+bankname);
			Markup m=MarkupHelper.createLabel("Refund Bank Name= "+bankname, ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(2000);
		}
		catch (Exception e) {}
	}

	public void enterRefundCreditCardBatchNumber(ExtentTest test,String batchnumber) throws InterruptedException 
	{
		try {
			driver.findElement(By.id("refund_B_Number")).sendKeys(batchnumber);
			logger.info("Refund Batch Number= "+batchnumber);
			Markup m=MarkupHelper.createLabel("Refund Batch Number= "+batchnumber, ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(2000);
		}
		catch (Exception e) {}
	}

	public void enterRedundCreditCardAmount(ExtentTest test,String amount) throws InterruptedException
	{
		try {
			driver.findElement(By.id("Credit_Amount_refund_Number")).sendKeys(amount);
			logger.info("Refund Amount= "+amount);	
			Markup m=MarkupHelper.createLabel("Refund Amount= "+amount, ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(2000);
		}
		catch (Exception e) {}
	}

	public void clickonDepositDebitCardRadioButton() 
	{
		WebElement DebitCardRadio = driver.findElement(By.id("Debit_"));	
		driver.clickByJS(TTWebsiteDriver.driver, DebitCardRadio);
		logger.info("Click on Deposit Debit Card Radio Button");
	}

	public void clickonRefundDebitCardRadioButton() 
	{
		WebElement DebitCardRadio = driver.findElement(By.id("Debit_refund"));	
		driver.clickByJS(TTWebsiteDriver.driver, DebitCardRadio);
		logger.info("Click on Refund Debit Card Radio Button");
	}
}
