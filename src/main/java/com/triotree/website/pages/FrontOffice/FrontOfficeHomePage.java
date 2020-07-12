package com.triotree.website.pages.FrontOffice;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;



public class FrontOfficeHomePage extends HISWebsiteBasePage
{
	private static final Logger logger = LogManager
			.getLogger(FrontOfficeHomePage.class.getName());

	public FrontOfficeHomePage(TTWebsiteDriver driver) {
		super(driver);
	}


	private final By ADD_PATIENT_SECTION = By.xpath("//li[@id='FOAddPatientMenu']//i[2]");
	private final By BILLING_SECTION = By.xpath("//a[contains(text(),'Billing')]//i[@class='fa fa-caret-down']");
	private final By DOCTOR_SCHEDULE = By.xpath("//li[@id='FODoctorScheduleMenu']//i[2]");
	private final By INDENT_ITEM_SECTION = By.xpath("//a[@href='#'][contains(text(),'Indent Items')]");
	private final By INDENT_ISSUE = By.xpath("//a[@href='#'][contains(text(),'Indent Issue')]");
	private final By PURCHASE_ORDER = By.xpath("//a[@href='#'][contains(text(),'Purchase Order')]");
	private final By GRN=By.xpath("//a[@href='#'][text()='GRN']");
	private final By GRN_RETURN=By.xpath("//a[@href='#'][text()='GRN Return']");
	private final By COMMON_SECTION = By.xpath("//a[contains(text(),'COMMON')]//i[2]");
	private final By MIS_SECTION = By.xpath("//li[@id='COMMON_Menu']//a[contains(text(),'MIS')]//i");
	private final By OP_SECTION = By.xpath("//a[contains(text(),'OP')]//i[2]");
	private final By IP_SECTION = By.xpath("//a[contains(text(),'IP')]//i[2]");
	private final By BILLING_SECTION_UNDER_OP = By.xpath("//body[@id='body_clickable']/nav[@id='menu']/ul/li[3]/a[1]//following::a[contains(text(),'Billing')][1]//i");
	private final By BILLING_SECTION_UNDER_IP = By.xpath("//a[contains(text(),'IP')]//i[2]//following::a[contains(text(),'Billing')]//i");




	public void clickOnAddPatientAndSelectAnOption(String option) throws InterruptedException {
		driver.waitForElementPresent(ADD_PATIENT_SECTION);
		driver.click(ADD_PATIENT_SECTION);
		logger.info("Add Patient Section is Expanded");

		Thread.sleep(6000);

		WebElement options = driver.findElement(By.xpath("//a[text()='"+option+"']"));
		options.click();
		logger.info("Following Option has been selected from Add Patient Section " + option);
		driver.waitForPageLoad();
		Thread.sleep(18000);
	}

	public void clickOnIndentItemsAndSelectAnOption(String option) throws InterruptedException {
		driver.waitForElementPresent(INDENT_ITEM_SECTION);
		driver.click(INDENT_ITEM_SECTION);
		logger.info("Indent Item Section is Expanded");

		driver.waitForElementPresent(By.xpath("//ul[@style='display: block;']//a[text()='"+option+"']"), 120);
		WebElement options = driver.findElement(By.xpath("//ul[@style='display: block;']//a[text()='"+option+"']"));
		options.click();
		logger.info("Following Option has been selected from Indent Items Section " + option);
		driver.waitForPageLoad();
		Thread.sleep(30000);
	}
	
	
	public void clickOnIndentIssuesAndSelectAnOption(String option) throws InterruptedException {
		driver.waitForElementPresent(INDENT_ISSUE);
		driver.click(INDENT_ISSUE);
		logger.info("Indent Issue Section is Expanded");

		WebElement options = driver.findElement(By.xpath("//ul[@style='display: block;']//a[text()='"+option+"']"));
		options.click();
		logger.info("Following Option has been selected from Indent Issue Section " + option);
		driver.waitForPageLoad();
		Thread.sleep(30000);
	}

	public void clickOnPurchaseOrderAndSelectAnOption(String option) throws InterruptedException {
		driver.waitForElementPresent(PURCHASE_ORDER);
		driver.click(PURCHASE_ORDER);
		logger.info("Indent Issue Section is Expanded");

		WebElement options = driver.findElement(By.xpath("//ul[@style='display: block;']//a[text()='"+option+"']"));
		options.click();
		logger.info("Following Option has been selected from Purchase Order Section " + option);
		driver.waitForPageLoad();
		Thread.sleep(30000);
	}

	public void clickOnDoctorScheduleAndSelectAnOption(String option) throws InterruptedException {
		driver.waitForElementPresent(DOCTOR_SCHEDULE);
		driver.click(DOCTOR_SCHEDULE);
		logger.info("Doctor Schedule Section is Expanded");
		Thread.sleep(6000);
		WebElement options = driver.findElement(By.xpath("//li[@id='FODoctorScheduleMenu']//following-sibling::ul/li//a[text()='"+option+"']"));
		options.click();
		logger.info("Following Option has been selected from Doctor Schedule Section " + option);
		driver.waitForPageLoad();
		Thread.sleep(18000);
	}

	public void clickOnBillingAndSelectAnOption(String option) throws InterruptedException {
		driver.waitForElementPresent(BILLING_SECTION);
		WebElement billsection = driver.findElement(BILLING_SECTION);
		driver.clickByJS(TTWebsiteDriver.driver, billsection);
		logger.info("Billing Section is Expanded");
		Thread.sleep(5000);
		WebElement options = driver.findElement(By.xpath("//a[text()='"+option+"']"));
		options.click();
		logger.info("Following Option has been selected from Billing Section " + option);
		driver.waitForPageLoad();
		Thread.sleep(18000);
	}


	public void clickOnCommonThenMISAndSelectAnOption(String option) throws InterruptedException {
		driver.waitForElementPresent(COMMON_SECTION);
		driver.click(COMMON_SECTION);
		logger.info("Common Section is Expanded");
		driver.waitForElementPresent(MIS_SECTION);
		driver.click(MIS_SECTION);
		driver.waitForElementPresent(By.xpath("//a[text()='"+option+"']"));
		WebElement options = driver.findElement(By.xpath("//a[text()='"+option+"']"));
		options.click();
		logger.info("Following Option has been selected from MIS Section " + option);
		driver.waitForPageLoad();
		Thread.sleep(18000);
	} 

	public void clickOnOPThenBillingAndSelectAnOption(String option) throws InterruptedException {
		driver.waitForElementPresent(OP_SECTION);
		driver.click(OP_SECTION);
		logger.info("OP Section is Expanded");
		driver.waitForElementPresent(BILLING_SECTION_UNDER_OP);
		driver.click(BILLING_SECTION_UNDER_OP);
		driver.waitForElementPresent(By.xpath("//a[text()='"+option+"']"));
		WebElement options = driver.findElement(By.xpath("//a[text()='"+option+"']"));
		options.click();
		logger.info("Following Option has been selected from OP Section " + option);
		driver.waitForPageLoad();
		Thread.sleep(18000);
	} 

	public void clickOnIPThenBillingAndSelectAnOption(String option) throws InterruptedException {
		driver.waitForElementPresent(IP_SECTION);
		driver.click(IP_SECTION);
		logger.info("IP Section is Expanded");
		driver.waitForElementPresent(BILLING_SECTION_UNDER_IP);
		driver.click(BILLING_SECTION_UNDER_IP);
		driver.waitForElementPresent(By.xpath("//a[text()='"+option+"']"));
		WebElement options = driver.findElement(By.xpath("//a[text()='"+option+"']"));
		options.click();
		logger.info("Following Option has been selected from IP Section " + option);
		driver.waitForPageLoad();
		Thread.sleep(18000);
	} 
	public void clickOnGRNAndSelectAnOption(String option) throws InterruptedException {
		driver.waitForElementPresent(GRN);
		driver.click(GRN);
		logger.info("Indent Issue Section is Expanded");

		WebElement options = driver.findElement(By.xpath("//ul[@style='display: block;']//a[text()='"+option+"']"));
		options.click();
		logger.info("Following Option has been selected from Purchase Order Section " + option);
		driver.waitForPageLoad();
		Thread.sleep(30000);

	}

	public void clickOnGRNRETURNAndSelectAnOption(String option) throws InterruptedException {
		driver.waitForElementPresent(GRN_RETURN);
		driver.click(GRN_RETURN);
		logger.info("Indent Issue Section is Expanded");

		WebElement options = driver.findElement(By.xpath("//ul[@style='display: block;']//a[text()='"+option+"']"));
		options.click();
		logger.info("Following Option has been selected from Purchase Order Section " + option);
		driver.waitForPageLoad();
		Thread.sleep(30000);

	}
	public void selectReceiptTypewithPO(String text) 
	{
		driver.waitForElementPresent(By.xpath("//select[@id='ddlreceipttyp']"));
		Select sl=new Select(driver.findElement(By.xpath("//select[@id='ddlreceipttyp']")));
		sl.selectByVisibleText(text);
		logger.info("Following Option has been selected from Receipt Type with PO  " + text);

	}

	public void selectPurchaseTypewithoutreftoGRN(String text) 
	{
		driver.waitForElementPresent(By.xpath("//select[@id='drdPurchaseType']"));
		Select sl=new Select(driver.findElement(By.xpath("//select[@id='drdPurchaseType']")));
		sl.selectByVisibleText(text);
		logger.info("Following Option has been selected from Purchase Type without ref.to GRN " + text);

	}
	public void RightButtonOk() 
	{
		driver.waitForElementPresent(By.xpath("//i[@id='btnok']"));
		driver.findElement(By.xpath("//i[@id='btnok']")).click();
	}

	public void selectPurchaseOrder() 
	{
		driver.waitForElementPresent(By.xpath("(//table[@id='tblpurchaseo']//tr//td[text()='14'])[1]"));
		driver.findElement(By.xpath("(//table[@id='tblpurchaseo']//tr//td[text()='14'])[1]")).click();
		logger.info("Purchase Order is selected");
	}

	public void ReceiptDetailsQty(String itemnumber,String qty) throws InterruptedException 
	{
		List<WebElement> ReceiptDetailsQty_list = driver.findElements(By.xpath("//input[@class='required clsvalinteger clskeyup']/../..//td[text()]"));
		for(int i=1;i<=ReceiptDetailsQty_list.size();i++) 
		{
			String value = driver.findElement(By.xpath("(//input[@class='required clsvalinteger clskeyup']/../..//td[text()])["+i+"]")).getText();

			if(value.equals(itemnumber)) 
			{
				//				WebDriverWait wait = new WebDriverWait(driver, 50);
				//				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[text()='"+value+"']//following-sibling::td//input[@class='required clsvalinteger clskeyup']")))); 
				driver.findElement(By.xpath("//td[text()='"+value+"']//following-sibling::td//input[@class='required clsvalinteger clskeyup']")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+value+"']//following-sibling::td//input[@class='required clsvalinteger clskeyup']")).sendKeys(qty);
				logger.info("Receipt Details Qty " + value+" "+qty);
			}
		}
	}

	public void clickonCalculateButton()
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btncal']"));
		WebElement CalculateButton_element = driver.findElement(By.xpath("//a[@id='btncal']"));
		driver.clickByJS(TTWebsiteDriver.driver, CalculateButton_element);
		logger.info("Click on Calculate Button");
	}

	public void clickonEditButton()
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btnedit']"));
		WebElement clickonEditButton_element = driver.findElement(By.xpath("//a[@id='btnedit']"));
		driver.clickByJS(TTWebsiteDriver.driver, clickonEditButton_element);
		logger.info("Click on Edit Button");
	}
	public void clickonSchemeDetailsOkButton() 
	{
		try {
		driver.waitForElementPresent(By.xpath("//input[@id='btnsyes']"));
		driver.findElement(By.xpath("//input[@id='btnsyes']")).click();
		logger.info("Click on Scheme Details Ok Button");
		}
		catch (Exception e) {}
	}

	public void EnterBatchNumber(String itemname,String batchnumber) throws InterruptedException 
	{
		List<WebElement> EnterBatchNumber_list = driver.findElements(By.xpath("//input[@class='required clsvalinteger clskeyup']/../..//td[text()]"));
		for(int i=1;i<=EnterBatchNumber_list.size();i++) 
		{
			String value = driver.findElement(By.xpath("(//input[@class='required clsvalinteger clskeyup']/../..//td[text()])["+i+"]")).getText();

			if(value.equals(itemname)) 
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+value+"']//following-sibling::td//input[@class='required']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[@class='clsfillitembatch' and text()='"+batchnumber+"']")).click();
				logger.info("Enter Batch Number "+value+" "+batchnumber);
			}
		}
	}

	public void EnterExpiryDate(String itemnumber, String expirydate) throws InterruptedException 
	{
		List<WebElement> EnterBatchNumber_list = driver.findElements(By.xpath("//input[@class='required clsvalinteger clskeyup']/../..//td[text()]"));
		for(int i=1;i<=EnterBatchNumber_list.size();i++) 
		{
			String value = driver.findElement(By.xpath("(//input[@class='required clsvalinteger clskeyup']/../..//td[text()])["+i+"]")).getText();

			if(value.equals(itemnumber)) 
			{
				Thread.sleep(2000);
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[text()='"+value+"']//following-sibling::td//input[contains(@class,'date-picker1') or type='text']")))); 
				driver.findElement(By.xpath("//td[text()='"+value+"']//following-sibling::td//input[contains(@class,'date-picker1') or type='text']")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+value+"']//following-sibling::td//input[contains(@class,'date-picker1') or type='text']")).sendKeys(expirydate);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+value+"']//following-sibling::td//input[contains(@class,'date-picker1') or type='text']")).sendKeys(Keys.ENTER);
				logger.info("Enter Batch Number "+value+" "+expirydate);
			}
		}
	}

	public void EnterRPSPMRPNumber(String itemname,String RPSPMRP) throws InterruptedException 
	{
		//		List<WebElement> EnterBatchNumber_list = driver.findElements(By.xpath("//input[@class='required clsvalinteger clskeyup']/../..//td[text()]"));
		//		for(int i=1;i<=EnterBatchNumber_list.size();i++) 
		//		{
		//			String value = driver.findElement(By.xpath("(//input[@class='required clsvalinteger clskeyup']/../..//td[text()])["+i+"]")).getText();
		//
		//			if(value.equals(itemname)) 
		//			{
		driver.findElement(By.xpath("//td[text()='"+itemname+"']//following-sibling::td//input[contains(@class,'required clsvalinput clsoldmrp')]")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		driver.findElement(By.xpath("//td[text()='"+itemname+"']//following-sibling::td//input[contains(@class,'required clsvalinput clsoldmrp')]")).sendKeys(RPSPMRP);
		logger.info("Enter Batch Number "+itemname+" "+RPSPMRP);
		//}
		//}
	}

	public void EnterPRRate(String itemname,String PRrate) throws InterruptedException 
	{
		driver.findElement(By.xpath("//td[text()='"+itemname+"']//following-sibling::td//input[@class='required clsvalinput']")).clear();
		driver.findElement(By.xpath("//td[text()='"+itemname+"']//following-sibling::td//input[@class='required clsvalinput']")).sendKeys(PRrate);
		logger.info("Enter PR Rate "+itemname+" "+PRrate);
	}

	public void EnterSGSTPercentage(String itemname,String SGST) 
	{
		driver.findElement(By.xpath("(//td[text()='"+itemname+"']//following-sibling::td//input[contains(@class,'clsvalinput')])[6]")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		driver.findElement(By.xpath("(//td[text()='"+itemname+"']//following-sibling::td//input[contains(@class,'clsvalinput')])[6]")).sendKeys(SGST);
		logger.info("Enter SGST Percentage "+itemname+" "+SGST);
	}

	public void EnterCGSTPercentage(String itemname,String CGST) 
	{
		driver.findElement(By.xpath("(//td[text()='"+itemname+"']//following-sibling::td//input[contains(@class,'clsvalinput')])[8]")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		driver.findElement(By.xpath("(//td[text()='"+itemname+"']//following-sibling::td//input[contains(@class,'clsvalinput')])[8]")).sendKeys(CGST);
		logger.info("Enter CGST Percentage "+itemname+" "+CGST);
	}
	public void clickonSaveButton() 
	{
		driver.waitForElementPresent(By.xpath("//a[@title='Save']"));
		WebElement save_element = driver.findElement(By.xpath("//a[@title='Save']"));
		driver.clickByJS(TTWebsiteDriver.driver, save_element);
		logger.info("Click on Save Button");
	}

	public void clickonDraftCheckBox()
	{
		driver.waitForElementPresent(By.xpath("//input[@id='chkdraftsave']"));
		WebElement draftcheckbox_element = driver.findElement(By.xpath("//input[@id='chkdraftsave']"));
		driver.clickByJS(TTWebsiteDriver.driver, draftcheckbox_element);
		logger.info("Click on Draft Check Box");	
	}

	public void clickonFreeDetails(String value,String batchnumber) throws InterruptedException 
	{
		driver.waitForElementPresent(By.xpath("//a[text()='Free Details']"));
		WebElement FreeDetails_element = driver.findElement(By.xpath("//a[text()='Free Details']"));
		driver.clickByJS(TTWebsiteDriver.driver, FreeDetails_element);
		logger.info("Click on Free Details");
		driver.findElement(By.xpath("//td[text()='"+value+"']//following-sibling::td//input[@class='required clsfreebatch clsfreebatchkeyup']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@class='clsfreefillitembatch' and text()='"+batchnumber+"']")).click();
		logger.info("Enter Free Details Batch Number "+value+" "+batchnumber);
	}

	public void saveRecordYesButton() 
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btngrnyes']"));
		WebElement saveRecordYes_btn_element = driver.findElement(By.xpath("//a[@id='btngrnyes']"));
		driver.clickByJS(TTWebsiteDriver.driver, saveRecordYes_btn_element);
		logger.info("Click on Save Button");
	}

	public void saveRecordNoButton() 
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btngrnno']"));
		WebElement saveRecordNO_btn_element = driver.findElement(By.xpath("//a[@id='btngrnno']"));
		driver.clickByJS(TTWebsiteDriver.driver, saveRecordNO_btn_element);
		logger.info("Click on Save Button");
	}

	public void EnterInvoiceNumber(String invoicenumber) 
	{
		driver.waitForElementPresent(By.xpath("//input[@id='txtinvoice']"));
		driver.findElement(By.xpath("//input[@id='txtinvoice']")).clear();
		driver.findElement(By.xpath("//input[@id='txtinvoice']")).sendKeys(invoicenumber);
		logger.info("Enter Invoice Number");
	}

	public void EnterFromDate(String fromdate) 
	{
		driver.waitForElementPresent(By.xpath("//input[@id='txtFromDate']"));
		driver.findElement(By.xpath("//input[@id='txtFromDate']")).clear();
		driver.findElement(By.xpath("//input[@id='txtFromDate']")).sendKeys(fromdate);
		driver.findElement(By.xpath("//input[@id='txtFromDate']")).sendKeys(Keys.ENTER);
		logger.info("Enter From Date "+fromdate);
	}

	public void EnterToDate(String todate) 
	{
		driver.waitForElementPresent(By.xpath("//input[@id='txtToDate']"));
		driver.findElement(By.xpath("//input[@id='txtToDate']")).clear();
		driver.findElement(By.xpath("//input[@id='txtToDate']")).sendKeys(todate);
		driver.findElement(By.xpath("//input[@id='txtToDate']")).sendKeys(Keys.ENTER);
		logger.info("Enter To Date "+todate);
	}

	public void clickonOpenDraftCheckBox()
	{
		driver.waitForElementPresent(By.xpath("//input[@id='chkdraft']"));
		WebElement draftcheckbox_element = driver.findElement(By.xpath("//input[@id='chkdraft']"));
		driver.clickByJS(TTWebsiteDriver.driver, draftcheckbox_element);
		logger.info("Click on Open Draft Check Box");	
	}

	public void clickonLoadButton() 
	{	
		driver.waitForElementPresent(By.xpath("//i[@id='iLoad']"));
		WebElement loadbutton_element = driver.findElement(By.xpath("//i[@id='iLoad']"));
		driver.clickByJS(TTWebsiteDriver.driver, loadbutton_element);
		logger.info("Click on Load Button");	
	}

	public void clickonLoadButtonNearSupplierName() 
	{
		driver.waitForElementPresent(By.xpath("//i[@id='btnRefreshSupplier']"));
		WebElement loadbuttonNearSupplierName_element = driver.findElement(By.xpath("//i[@id='btnRefreshSupplier']"));
		driver.clickByJS(TTWebsiteDriver.driver, loadbuttonNearSupplierName_element);
		logger.info("Click on Load Button Near Supplier Name");
	}
	public void GRNNumberRadioButton() 
	{
		driver.waitForElementPresent(By.xpath("//input[@value='rbGRNNo']"));
		WebElement GRNNumberRadioButton_element = driver.findElement(By.xpath("//input[@value='rbGRNNo']"));
		driver.clickByJS(TTWebsiteDriver.driver, GRNNumberRadioButton_element);
		logger.info("Click on GRN Number Radio Button");
	}

	public void CloseGRNList() 
	{
		driver.waitForElementPresent(By.xpath("//a[@id='grnistmodalclose']"));
		WebElement CloseGRNList_element = driver.findElement(By.xpath("//a[@id='grnistmodalclose']"));
		driver.clickByJS(TTWebsiteDriver.driver, CloseGRNList_element);
		logger.info("Click on Close GRN List Button");
	}

	public void SelectReciptType(String text) 
	{
		Select sl=new Select(driver.findElement(By.xpath("//select[@id='ddlreceipttyp']")));
		sl.selectByVisibleText(text);
		logger.info("Recipt Type value "+text);
	}
	public void SelectSupplierName(String text) 
	{
		Select sl=new Select(driver.findElement(By.xpath("//select[@id='ddlsupplier']")));
		sl.selectByVisibleText(text);
		logger.info("Supplier Name "+text);
	}

	public void PaymentAdviceSelectSupplierName(String text) 
	{
		Select sl=new Select(driver.findElement(By.xpath("//select[@id='ddl_SupplierName']")));
		sl.selectByVisibleText(text);
		logger.info("Supplier Name "+text);
	}
	public void SelectGRNReturnSupplierName(String text) 
	{
		Select sl=new Select(driver.findElement(By.xpath("//select[@id='drdSuplierName']")));
		sl.selectByVisibleText(text);
		logger.info("Supplier Name "+text);
	}

	public void OKReciptTypeButton() 
	{
		driver.waitForElementPresent(By.xpath("//i[@id='btnserachsupp']"));
		WebElement OKReciptTypeButton_element = driver.findElement(By.xpath("//i[@id='btnserachsupp']"));
		driver.clickByJS(TTWebsiteDriver.driver, OKReciptTypeButton_element);
		logger.info("Click on OK Recipt Type Button");
	}

	public void clickonReceiptDetails() 
	{
		driver.waitForElementPresent(By.xpath("//a[text()='Receipt Details']"));
		driver.findElement(By.xpath("//a[text()='Receipt Details']")).click();
		logger.info("Click on Receipt Details Button");
	}

	public void clearButton() 
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btnclear']"));
		WebElement clearButton_element = driver.findElement(By.xpath("//a[@id='btnclear']"));
		driver.clickByJS(TTWebsiteDriver.driver, clearButton_element);
		logger.info("Click on Clear Button");
	}

	public void paymentAdviceclearButton() 
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btnClear']"));
		WebElement clearButton_element = driver.findElement(By.xpath("//a[@id='btnClear']"));
		driver.clickByJS(TTWebsiteDriver.driver, clearButton_element);
		logger.info("Click on Clear Button");
	}
	public void ClearFilledDetails()
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btnclearyes']"));
		WebElement DeleteClearFilledDetails_element = driver.findElement(By.xpath("//a[@id='btnclearyes']"));
		driver.clickByJS(TTWebsiteDriver.driver, DeleteClearFilledDetails_element);
		logger.info("Click on Clear Filled Details");
	}

	public void clickonGRNItemsCloseButton() 
	{
		driver.waitForElementPresent(By.xpath("//span[@id='withoutpomodalclose']//i"));
		driver.findElement(By.xpath("//span[@id='withoutpomodalclose']//i")).click();
		logger.info("Click on GRN Items Close Button");
	}

	public void clickonCSVButton() 
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btncsvgrnrpt']//i"));
		WebElement clickonCSVButton_element = driver.findElement(By.xpath("//a[@id='btncsvgrnrpt']//i"));
		driver.clickByJS(TTWebsiteDriver.driver, clickonCSVButton_element);
		logger.info("Click on CSV Button");
	}

	public void clickonDeleteButton() 
	{
		driver.waitForElementPresent(By.xpath("//input[@value='Delete']"));
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		logger.info("Click on Delete Button");
	}

	public void clickonGRNList()
	{
		driver.waitForElementPresent(By.xpath("//table[@id='tblgrnlist']//tr[@id]"));
		driver.findElement(By.xpath("//table[@id='tblgrnlist']//tr[@id]")).click();
		logger.info("Click on GRN List");
	}

	public void selectAgaistChallanCheckBox() 
	{
		driver.waitForElementPresent(By.xpath("//input[@id='chkchllan']"));
		WebElement AgaistChallanCheckBox_element = driver.findElement(By.xpath("//input[@id='chkchllan']"));
		driver.clickByJS(TTWebsiteDriver.driver, AgaistChallanCheckBox_element);
		logger.info("Click on Agaist Challan Check Box");
	}

	public void clickonReloadButton() 
	{
		driver.waitForElementPresent(By.xpath("//i[@id='btnrefreshsupp']"));
		WebElement clickonReloadButton_element = driver.findElement(By.xpath("//i[@id='btnrefreshsupp']"));
		driver.clickByJS(TTWebsiteDriver.driver, clickonReloadButton_element);
		logger.info("Click on Reload Button");
	}

	public void selectGRNDrugItem(String drugtab,String value) 
	{
		String drugtab_attribute = driver.findElement(By.xpath("(//a[text()='"+drugtab+"']/..)[1]")).getAttribute("class");
		if(!drugtab_attribute.equals("active")) 
		{
			driver.findElement(By.xpath("(//a[text()='"+drugtab+"']/..)[1]")).click();
		}
		driver.waitForElementPresent(By.xpath("//table[@id='tblmedicine']//tr"));
		driver.findElement(By.xpath("//input[@id='Chksmart_search']/..//input[@id='txtitemsearch']")).clear();
		driver.findElement(By.xpath("//input[@id='Chksmart_search']/..//input[@id='txtitemsearch']")).sendKeys(value);
		driver.findElement(By.xpath("//input[@id='Chksmart_search']/..//input[@id='txtitemsearch']")).sendKeys(Keys.ENTER);
		if(driver.findElements(By.xpath("(//td[text()='"+value+"'])")).size()>0) 
		{
			driver.findElement(By.xpath("(//td[text()='"+value+"'])")).click();
		}
	}

	public void clickonClearNoButton() 
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btnclrarno']"));
		WebElement clickonClearNoButton_element = driver.findElement(By.xpath("//a[@id='btnclrarno']"));
		driver.clickByJS(TTWebsiteDriver.driver, clickonClearNoButton_element);
		logger.info("Click on Clear No Button");
	}

	public void clickonClearYesButton() 
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btnclearyes']"));
		WebElement clickonClearYesButton_element = driver.findElement(By.xpath("//a[@id='btnclearyes']"));
		driver.clickByJS(TTWebsiteDriver.driver, clickonClearYesButton_element);
		logger.info("Click on Clear No Button");

	}

	public void EnterPurcahseorderFromDate(String fromdate) 
	{
		driver.waitForElementPresent(By.xpath("//input[@id='frmdate']"));
		driver.findElement(By.xpath("//input[@id='frmdate']")).clear();
		driver.findElement(By.xpath("//input[@id='frmdate']")).sendKeys(fromdate);
		driver.findElement(By.xpath("//input[@id='frmdate']")).sendKeys(Keys.ENTER);
		logger.info("Enter Purcahse Order From Date "+fromdate);
	}

	public void EnterPurcahseorderToDate(String todate) 
	{
		driver.waitForElementPresent(By.xpath("//input[@id='todate']"));
		driver.findElement(By.xpath("//input[@id='todate']")).clear();
		driver.findElement(By.xpath("//input[@id='todate']")).sendKeys(todate);
		driver.findElement(By.xpath("//input[@id='todate']")).sendKeys(Keys.ENTER);
		logger.info("Enter Purcahse Order To Date "+todate);
	}

	public void selectNewRadioButton() 
	{
		//driver.waitForElementPresent(By.xpath("//input[@id='radNew']"));
		List<WebElement> radio_btn_list = driver.findElements(By.xpath("//input[@type='radio']"));
		for(int i=1;i<=radio_btn_list.size();i++)
		{
			if(driver.findElement(By.xpath("(//input[@type='radio'])["+i+"]")).isDisplayed()) 
			{
				driver.findElement(By.xpath("(//input[@type='radio'])["+i+"]")).click();

				if(driver.findElement(By.xpath("//span[text()='Approved Purchased Order']")).isDisplayed())
				{
					clickonPOPendingForApproval();
					logger.info("Approved Purchased Order is Displayed");

				}

				if(driver.findElement(By.xpath("//span[text()='Rejected Purchased Order']")).isDisplayed())
				{
					clickonPOPendingForApproval();
					logger.info("Rejected Purchased Order is Displayed");

				}
			}
			//			else {
			//				selectApprovedRadioButton();
			//			}

		}
		//logger.info("Select New Radio Button");
	}

	public void selectApprovedRadioButton() 
	{
		driver.waitForElementPresent(By.xpath("//input[@id='radApproved']"));
		driver.findElement(By.xpath("//input[@id='radApproved']")).click();
		logger.info("Select Approved Radio Button");
	}
	public void clickonPOPendingForApproval() 
	{
		//driver.waitForElementPresent(By.xpath("//div[@class='popuptable150 mar-b10']//table//tbody//tr[1]"));
		List<WebElement> POPendingForApproval_list = driver.findElements(By.xpath("(//table[@id='newitemreceipt']//tbody//tr[1])"));

		for(int j=1;j<=POPendingForApproval_list.size();j++) 
		{
			if(driver.findElement(By.xpath("(//table[@id='newitemreceipt']//tbody//tr[1])["+j+"]")).isDisplayed()) 
			{
				driver.findElement(By.xpath("(//table[@id='newitemreceipt']//tbody//tr[1])["+j+"]")).click(); 
				logger.info("Click on PO Pending For Approval");
			}
		}

	}

	public void clickonApprovalButton() 
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btnApprove']//i"));
		driver.findElement(By.xpath("//a[@id='btnApprove']//i")).click();
		logger.info("Click on Approval Button");
	}

	public void clickonYesApproveButton() 
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btnyesPrintModal']"));
		driver.findElement(By.xpath("//a[@id='btnyesPrintModal']")).click();
		logger.info("Click on Approve Yes Button");
	}

	public void clickonNoApproveButton() 
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btnno']"));
		driver.findElement(By.xpath("//a[@id='btnno']")).click();
		logger.info("Click on Approve No Button");
	}

	public void clickonBatch(String text,String batchnumber)
	{
		try 
		{
			driver.waitForElementPresent(By.xpath("//td[text()='"+text+"']//following::td[@class='required'][1]"));
			driver.findElement(By.xpath("//td[text()='"+text+"']//following::td[@class='required'][1]")).click();

//			List<WebElement> batchdetails_list =driver.findElements(By.xpath("//table[@id='batchDetailTbl']//tbody//tr//td[text()='"+batchnumber+"']/.."));
//
//			for(int i=1;i<=batchdetails_list.size();i++) 
//			{
				WebElement clickbatch = driver.findElement(By.xpath("//table[@id='batchDetailTbl']//tbody//tr//td[text()='"+batchnumber+"']/.."));
				driver.clickByJS(TTWebsiteDriver.driver, clickbatch);
				//break;
			//}
			logger.info("Click on Batch "+text+" "+batchnumber);
		}
		catch (Exception e) {
			driver.findElement(By.xpath("//div[@class='modal-block-new top30']//span[@class='inventory_close_modal']//i")).click();
		}
	}

	public void clickonDoYouWantContinueNoOption() 
	{
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnbatchSuppierAlertNo']"));
			driver.findElement(By.xpath("//a[@id='btnbatchSuppierAlertNo']")).click();
			logger.info("Click on Do You Want Continue No Option");
		}
		catch (Exception e) {}
	}

	public void clickonDoYouWantContinueYesOption() 
	{
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnbatchSuppierAlertYes']"));
			driver.findElement(By.xpath("//a[@id='btnbatchSuppierAlertYes']")).click();
			logger.info("Click on Do You Want Continue Yes Option");
		}
		catch (Exception e) {
		}
	}

	public void EnterGRNReturnQTY(String text,String qty)
	{
		try {
			driver.waitForElementPresent(By.xpath("//td[text()='"+text+"']//following-sibling::td//input[@type='text'][@ ctype='QTY']"));
			driver.findElement(By.xpath("//td[text()='"+text+"']//following-sibling::td//input[@type='text'][@ ctype='QTY']")).clear();
			driver.findElement(By.xpath("//td[text()='"+text+"']//following-sibling::td//input[@type='text'][@ ctype='QTY']")).sendKeys(qty);;

			logger.info("Enter GRN Return QTY "+text+" "+qty);
		}
		catch (Exception e) {}
	}

	public void EnterReasonandSelectReason(String text) 
	{
		driver.waitForElementPresent(By.xpath("//input[@id='txtReason']"));
		driver.findElement(By.xpath("//input[@id='txtReason']")).clear();
		driver.findElement(By.xpath("//input[@id='txtReason']")).sendKeys(text);
		logger.info("Enter Reason and Select Reason "+text);
	}

	public void EnterInvoiceNumberandReferenceNumber(String text) 
	{
		driver.waitForElementPresent(By.xpath("//input[@id='txtInvoiceNoRefNo']"));
		driver.findElement(By.xpath("//input[@id='txtInvoiceNoRefNo']")).sendKeys(text);	
		logger.info("Enter Invoice Number and Reference Number "+text);
	}

	public void SelectRGPandNRGP(String text) 
	{
		Select sl=new Select(driver.findElement(By.xpath("//select[@id='drdRGPNRGP']")));
		sl.selectByVisibleText(text);
		logger.info("Supplier Name "+text);
	}

	public void GRNReturnSaveNo()
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btnSaveAlertNo']"));
		driver.findElement(By.xpath("//a[@id='btnSaveAlertNo']")).click();	
		logger.info("GRN Return Save No");

	}

	public void GRNReturnSaveYes()
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btnSaveAlertYes']"));
		driver.findElement(By.xpath("//a[@id='btnSaveAlertYes']")).click();	
		logger.info("GRN Return Save Yes");
	}

	public void GRNReturnPrintYes() 
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btnAfterSavePrintAlertYes']"));
		driver.findElement(By.xpath("//a[@id='btnAfterSavePrintAlertYes']")).click();	
		logger.info("GRN Return Print Yes");

	}

	public void GRNReturnAfterSavePrintCreditNoteAlertYes() 
	{	
		driver.waitForElementPresent(By.xpath("//a[@id='btnAfterSavePrintCreditNoteAlertYes']"));
		driver.findElement(By.xpath("//a[@id='btnAfterSavePrintCreditNoteAlertYes']")).click();	
		logger.info("GRN Return After Save Print Credit Note Alert Yes");
	}

	public void GRNReturnAfterSavePrintCreditNoteAlertNo() 
	{	
		driver.waitForElementPresent(By.xpath("//a[@id='btnAfterSavePrintCreditNoteAlertNo']"));
		driver.findElement(By.xpath("//a[@id='btnAfterSavePrintCreditNoteAlertNo']")).click();	
		logger.info("GRN Return After Save Print Credit Note Alert Yes");
	}
	public void clickonGRNReturnCloseReport() 
	{
		try {
		driver.waitForElementPresent(By.xpath("//a[@id='printmodalclose']//i"));
		driver.findElement(By.xpath("//a[@id='printmodalclose']//i")).click();	
		logger.info("Click on GRN Return Close Report");
		}
		catch (Exception e) {}
	}

	public void clickonMainReportCloseButton() {

		driver.waitForElementPresent(By.xpath("//span[@id='printcreditmodalclose']//i"));
		driver.findElement(By.xpath("//span[@id='printcreditmodalclose']//i")).click();	
		logger.info("Click on Main Report Close Button");
	}

	public void clickonPurchaseReturnApproveButton() 
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btnapprovegrnret']//i"));
		driver.findElement(By.xpath("//a[@id='btnapprovegrnret']//i")).click();	
		logger.info("Click on Purchase Return Approve Button");
	}

	public void clickonLoad() 
	{
		driver.waitForElementPresent(By.xpath("//i[@id='btnSearchGrnReturn']"));
		driver.findElement(By.xpath("//i[@id='btnSearchGrnReturn']")).click();	
		logger.info("Click on Load Button");
	}

	public void clickonclosePurchaseOrderButton() 
	{
		driver.waitForElementPresent(By.xpath("//a[@class='inventory_close_modal']//i"));
		driver.findElement(By.xpath("//a[@class='inventory_close_modal']//i")).click();	
		logger.info("Click on close Purchase Order Button");
	}

	public void selectDateRangeCheckBox() 
	{
		driver.waitForElementPresent(By.xpath("//input[@id='chk_DateRange']"));
		driver.findElement(By.xpath("//input[@id='chk_DateRange']")).click();	
		logger.info("Select Date Range Check Box");
	}

	public void selectPaymentAdviceFromDate(String fromdate) 
	{
		driver.waitForElementPresent(By.xpath("//input[@id='txt_From']"));
		driver.findElement(By.xpath("//input[@id='txt_From']")).clear();
		driver.findElement(By.xpath("//input[@id='txt_From']")).sendKeys(fromdate);
		logger.info("Select Payment Advice From Date "+fromdate);
	}

	public void selectPaymentAdviceToDate(String todate) 
	{
		driver.waitForElementPresent(By.xpath("//input[@id='txt_To']"));
		driver.findElement(By.xpath("//input[@id='txt_To']")).clear();
		driver.findElement(By.xpath("//input[@id='txt_To']")).sendKeys(todate);
		logger.info("Select Payment Advice To Date "+todate);
	}

	public void clickonPaymentAdviceSearchButton() 
	{
		driver.waitForElementPresent(By.xpath("//a[@id='btn_Search']//i"));
		driver.findElement(By.xpath("//a[@id='btn_Search']//i")).click();	
		logger.info("Click on Payment Advice Search Button");
	}

	public void selectCheckBox() 
	{
		try {
			driver.waitForElementPresent(By.xpath("//input[@class='SelectedRow']"));
			List<WebElement> selectcheckbox_list = driver.findElements(By.xpath("//input[@class='SelectedRow']"));	
			for(int i=1;i<=selectcheckbox_list.size();i++) 
			{
				driver.findElement(By.xpath("(//input[@class='SelectedRow'])["+i+"]")).click();	
				logger.info("Select select Check Box");	
				break;
			}
		}
		catch (Exception e) {}
	}

	public void clickonModifyButton() 
	{	
		try {
		driver.waitForElementPresent(By.xpath("//a[@id='btn_Modify']//i"));
		WebElement modify_btn = driver.findElement(By.xpath("//a[@id='btn_Modify']//i"));
		driver.clickByJS(TTWebsiteDriver.driver, modify_btn);
		logger.info("click on Modify Button");
		}
		catch (Exception e) {}
	}

	public void PaymentAdviceInvoiceNumber(String invoicenumber) 
	{	
		try {
		driver.waitForElementPresent(By.xpath("//input[@ctype='InvNo']"));
		List<WebElement> invoice_list = driver.findElements(By.xpath("//input[@ctype='InvNo']"));
		for(int i=1;i<=invoice_list.size();i++) 
		{
			driver.findElement(By.xpath("(//input[@ctype='InvNo'])["+i+"]")).clear();
			driver.findElement(By.xpath("(//input[@ctype='InvNo'])["+i+"]")).sendKeys(invoicenumber);
			logger.info("Payment Advice Invoice Number "+invoicenumber); 
			break;
		}
		}
		catch (Exception e) {}
	}

	public void paymentAdviceclickonYesButton() 
	{	
		try {
		driver.waitForElementPresent(By.xpath("//a[@id='btn_printYes']"));
		driver.findElement(By.xpath("//a[@id='btn_printYes']")).click();	
		logger.info("Payment Advice click on Yes Button");
		}
		catch (Exception e) {
		}
	}
	public void paymentAdvicePrintButton() 
	{	
		try {
		driver.waitForElementPresent(By.xpath("//a[@id='btn_PaymentAdvicePrint']//i"));
		driver.findElement(By.xpath("//a[@id='btn_PaymentAdvicePrint']//i")).click();	
		logger.info("Payment Advice click on Print Button");
		}
		catch (Exception e) {}
	}

	public void selectsummaryRadioButton() 
	{	
		try {
		driver.waitForElementPresent(By.xpath("//input[@id='rbl_Summary']"));
		driver.findElement(By.xpath("//input[@id='rbl_Summary']")).click();	
		logger.info("select summary Radio Button");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void showExistingAdvicesTab() 
	{
		driver.waitForElementPresent(By.xpath("//a[text()='Show Existing Advices']"));
		driver.findElement(By.xpath("//a[text()='Show Existing Advices']")).click();	
		logger.info("Show Existing Advices Tab");
	}
}
