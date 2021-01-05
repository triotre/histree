package com.triotree.website.pages.FrontOffice;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class IndentItemsPage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(IndentItemsPage.class.getName());

	public IndentItemsPage(TTWebsiteDriver driver) {
		super(driver);
	}

	private final By SAVE_BUTTON = By.xpath("//a[@id='btnSave']//i[@class='fa fa-save']");
	private final By TO_FACILITY_DROPDOWN = By.xpath("//select[@id='ddlToFacility']");
	private final By TO_DEPARTMENT_DROPDOWN = By.xpath("//select[@id='ddlToDepartment']");
	private final By SMART_SEARCH_CHECKBOX = By.xpath("//input[@id='chkSmart']");
	private final By REFRESH_STOCK_LABEL = By.xpath("//a[@id='btnRefreshStock']");
	private final By MEDICINE_TAB = By.xpath("//a[contains(text(),'Medicine')]");
	private final By SELECT_ALL_LABEL = By.xpath("//a[@id='btnAllItem']");
	//By.xpath("//a[@id='btnSelectAll']");
	private final By CONSUMABLES_TAB = By.xpath("//li[@id='liConsumables']//a[contains(text(),'Consumables')]");
	private final By OTHERS_TAB = By.xpath("//a[contains(text(),'Others')]");
	private final By SAVE_POPUP = By.xpath("//label[contains(text(),'Do you want to Save this Record?')]");
	private final By YES_BUTTON_SAVE_POPUP = By.xpath("//a[@id='btnYes']");
	private final By NEW_RADIO_BUTTON = By.xpath("//input[@id='rblNew']");
	private final By NEW_INDENT_POPUP = By.xpath("//span[contains(text(),'New Indent')]");
	private final By FIRST_INDENT_NO = By.xpath("//span[@id='SpanHeaderImplecitly']//following::tbody[1]//tr[1]");
	private final By CLOSE_INDENT_POPUP = By.xpath("//a[@id='btnClose']//i[@class='fa fa-times']");
	private final By NEW_INDENT_RETURN=By.xpath("//input[@id='rdbnewindret']");
	// Below Locators are for Direct Issue Page
	private final By SAVE_BUTTON_DIRECT_ISSUE = By.xpath("//i[@class='fa fa-save']");
	private final By TO_FACILITY_DROPDOWN_DIRECT_ISSUE = By.xpath("//select[@id='ddlissuedFacility']");
	private final By STORE_DROPDOWN_DIRECT_ISSUE = By.xpath("//select[@id='ddlissuedStore']");
	private final By FROM_DATE = By.xpath("//input[@id='txtFromDate']");
	private final By TO_DATE = By.xpath("//input[@id='txtToDate']");

	// Below Locators are for Direct Receipt Page


	public void clickOnSaveButton() 
	{
		WebElement element =driver.findElement(SAVE_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Save Button on Indent Items Page clicked");
	}

	public void clickOnApprovedButtonOnIndentItems() 
	{
		WebElement element =driver.findElement(By.xpath("//input[@id='rblApproved']"));
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Save Button on Indent Items Page clicked");
	}

	public void clickOnRejectedButtonOnIndentItems() {

		WebElement element =driver.findElement(By.xpath("//input[@id='rblRejected']"));
		driver.clickByJS(TTWebsiteDriver.driver, element);
	}

	public boolean verifyActionMessage(String message) {

		if (driver.findElement(By.xpath("//p[contains(text(),'"+message+"')]")).isDisplayed()) {
			try {
				driver.click(By.xpath("//div[@class='gritter-close']"));
			} catch (Exception e) {}
			return true;
		}
		else {
			return false;
		}
	}

	public void selectToFacilityFromDropdown(String facility) {
		Select facilityDropDown = new Select(driver.findElement(TO_FACILITY_DROPDOWN));
		facilityDropDown.selectByVisibleText(facility);
		logger.info("Following facilityfacility has been selected from facility Dropdown : " + facility);
	}

	public void selectToDepartmentFromDropdown(String department) {
		Select departmentDropDown = new Select(driver.findElement(TO_DEPARTMENT_DROPDOWN));
		departmentDropDown.selectByVisibleText(department);
		logger.info("Following department has been selected from department Dropdown : " + department);
	}

	public void selectSmartSearchCheckbox() {
		WebElement element = driver.findElement(SMART_SEARCH_CHECKBOX);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Smart Search Checkbox clicked");
	}

	public void clickOnRefreshStockLabel() {
		WebElement element = driver.findElement(REFRESH_STOCK_LABEL);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Refresh Stock Label Clicked");
	}

	public void clickOnSelectAllLabel() {
		WebElement element = driver.findElement(SELECT_ALL_LABEL);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Select all Label Clicked");
	}


	public void selectMedicineTab() 
	{
		WebElement MEDICINE_element = driver.findElement(MEDICINE_TAB);
		driver.clickByJS(TTWebsiteDriver.driver, MEDICINE_element);
		logger.info("Medicine Tab clicked");
	}

	public void selectConsumablesTab() 
	{
		WebElement tab = driver.findElement(CONSUMABLES_TAB);
		driver.clickByJS(TTWebsiteDriver.driver, tab);
		logger.info("Consumables Tab clicked");
	}

	public void selectOthersTab() 
	{
		driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(OTHERS_TAB));
		logger.info("Others Tab clicked");
	}



	public void selectMedicines(String medicine) 
	{
		WebDriverWait wd=new WebDriverWait(TTWebsiteDriver.driver, 100);
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+medicine+"')]")));
		
		WebElement medicine_elements = driver.findElement(By.xpath("//td[contains(text(),'"+medicine+"')]"));
		driver.clickByJS(TTWebsiteDriver.driver, medicine_elements);
		logger.info("Following Medicine has been selected"+ medicine);
	}

	public void selectDeleteButtonAgainstMedicines(String medicine) {

		driver.findElement(By.xpath("//table[@id='tblSelectedItem']//td[contains(text(),'"+medicine+"')]//following::i[1]")).click();;
	}

	public void enterQuantityForSelectedMedicines() {


		List<WebElement> elements = driver.findElements(By.xpath("//td[@ctype='QTY']/input"));
		//int totalMedicines = elements.size();

		for(int i=1;i<=elements.size();i++) {
			driver.findElement(By.xpath("(//td[@ctype='QTY']/input)["+i+"]")).sendKeys("10");
		}

	}

	public void enterRemarksForSelectedMedicines() 
	{
		List<WebElement> elements = driver.findElements(By.xpath("//td[@ctype='REMARKS']/input"));

		for(int i=1;i<=elements.size();i++) 
		{
			driver.findElement(By.xpath("(//td[@ctype='REMARKS']/input)["+i+"]")).sendKeys("Auto Remarks"+i+"");	
		}
	}

	public void enterQuantityForNewMedicines() {

		List<WebElement> elements = driver.findElements(By.xpath("//td[@ctype='QTY']/input"));
		int totalMedicines = elements.size();
		driver.findElement(By.xpath("//input[@id='tblSelectedItemTxtQtyNew_"+totalMedicines+"']")).sendKeys("11");
	}

	public void enterQuantityForNewMedicines(String medicine) {

		driver.findElement(By.xpath("//table[@id='tblSelectedItem']//td[contains(text(),'"+medicine+"')]//following::input[1]")).clear();
		driver.findElement(By.xpath("//table[@id='tblSelectedItem']//td[contains(text(),'"+medicine+"')]//following::input[1]")).sendKeys("11");
	}

	public void enterRemarksForSelectedNewMedicines(String medicine) {

		driver.findElement(By.xpath("//table[@id='tblSelectedItem']//td[contains(text(),'"+medicine+"')]//following::input[2]")).clear();
		driver.findElement(By.xpath("//table[@id='tblSelectedItem']//td[contains(text(),'"+medicine+"')]//following::input[2]")).sendKeys("Automation Remarks");
	}

	public void enterRemarksForSelectedNewMedicines() {

		List<WebElement> elements = driver.findElements(By.xpath("//td[@ctype='remarksi']/input"));
		int totalMedicines = elements.size()+1;

		driver.findElement(By.xpath("//input[@id='tblSelectedItemTxtRemarks"+totalMedicines+"']")).sendKeys("Auto Remarks11");

	}

	public boolean isSavePopupShowing() {
		return driver.isElementPresent(SAVE_POPUP);
	}

	public void clickYesOnSaveButton() {
		try {
			driver.findElement(YES_BUTTON_SAVE_POPUP).click();
			logger.info("Save button clicked");
		}
		catch (Exception e) {}
	}

	public void clickOnNewRadioButton() {
		WebElement element = driver.findElement(NEW_RADIO_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("New Radio Button clicked");
	}


	public void clickOnIssuedRadioButton() {
		WebElement element = driver.findElement(By.xpath("//input[@id='rblIssued']"));
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Issued Radio Button clicked");
	}


	public void clickOnNewReceiptRadioButton() {
		WebElement element = driver.findElement(By.xpath("//input[@id='radNewReceipt']"));
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Issued Radio Button clicked");
	}

	public void clickOnReceivedReceiptRadioButton() {
		WebElement element = driver.findElement(By.xpath("//input[@id='radrcvReceipt']"));
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Issued Radio Button clicked");
	}



	public boolean isNewIndentPopupDisplayed() {
		return driver.isElementPresent(NEW_INDENT_POPUP);
	}

	public void selectFirstIndentFromPopup() {
		try {
			driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(FIRST_INDENT_NO));
			logger.info("Indent No clicked");
		}
		catch (Exception e) {}
	}

	public void selectFirstIndentFromItemReceiptPopup() 
	{
		driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(By.xpath("//table[@id='newitemreceipt']//following::tbody[1]//tr[1]")));
		logger.info("Indent No clicked");
	}

	//----------------------------------------------------------------------

	public void closeIndentFromPopup() 
	{
		driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(CLOSE_INDENT_POPUP));
		logger.info("Indent Popup is closed.");

	}


	// Below methods are for Direct Issue Page

	public void clickOnSaveButtonOnDirectIssuePage() {
		try {
			driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(SAVE_BUTTON_DIRECT_ISSUE));
			logger.info("Save Button clicked");
		}
		catch (Exception e) {}
	}

	public void selectToFacilityFromDropdownDirectIssuePage(String facility) 
	{
		Select facilityDropDown = new Select(driver.findElement(TO_FACILITY_DROPDOWN_DIRECT_ISSUE));
		facilityDropDown.selectByVisibleText(facility);
		logger.info("Following facilityfacility has been selected from facility Dropdown : " + facility);
	}

	public void selectStoreFromDropdownDirectIssuePage(String department) 
	{
		Select departmentDropDown = new Select(driver.findElement(STORE_DROPDOWN_DIRECT_ISSUE));
		List<WebElement> department_list = departmentDropDown.getOptions();
		if(department_list.size()>0) {
			departmentDropDown.selectByVisibleText(department);
		}
		logger.info("Following Store has been selected from department Dropdown : " + department);
	}

	public void selectSmartSearchCheckboxDirectIssuePage() 
	{
		driver.click(By.xpath("//input[@id='Chksmart_search']"));
	}

	public void selectQOHTabDirectIssuePage() 
	{
		driver.click(By.xpath("//a[@id='tabitemwithqoh']"));
	}

	public void selectAllItemsTabDirectIssuePage() {

		driver.click(By.xpath("//a[@id='tabshowallitems']"));
	}

	public void selectItemsDirectIssuePage(String items) {
		try {
			driver.findElement(By.xpath("//input[@id='searchDirectIssueDrugs']")).clear();
			driver.findElement(By.xpath("//input[@id='searchDirectIssueDrugs']")).sendKeys(items);
			Thread.sleep(2000);		
			driver.findElement(By.xpath("//td[contains(text(),'"+items+"')]")).click();
			Thread.sleep(2000);		
		}
		catch (Exception e) {}
	}
	public void clickOnClearButtonOnDirectIssuePage() {
		try {
			WebElement element =driver.findElement(By.xpath("//a[@id='btnsubtitute']//i[@class='fa fa-refresh']"));
			driver.clickByJS(TTWebsiteDriver.driver, element);
			logger.info("Save Button clicked");
		}
		catch (Exception e) {}
	}

	public void selectFirstBatchNoFromBatchDetailsDirectIssuePage() {
		WebElement element =driver.findElement(By.xpath("//table[@id='tbldrugdtaillist']//tbody/tr[1]"));
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("First Batch No Clicked");
	}

	public void selectConsumablesTabDirectIssuePage() 
	{
		driver.click(By.xpath("//li[@class='active']//a[contains(text(),'Consumables')]"));
	}

	public void selectBatchNoFromBatchDetailsDirectIssuePage(String batchNo) {
		WebElement element =driver.findElement(By.xpath("//td[contains(text(),'"+batchNo+"')]"));
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Batch No Clicked");
	}

	public void selectOthersTabDirectIssuePage() {

		driver.click(By.xpath("(//a[contains(text(),'Other')])[2]"));
	}

	public void selectThirdSerialNumberDirectIssuePage() {
		try {

			WebElement element =driver.findElement(By.xpath("//table[@id='tbldrugitemdesc']//tbody/tr[3]/td[contains(text(),'3')][1]"));
			driver.clickByJS(TTWebsiteDriver.driver, element);
			logger.info("Third Serial No Clicked");
		}
		catch (Exception e) {}
	}

	public void clickNoButtonOnDeletePopupDirectIssuePage() {
		try {

			driver.findElement(By.xpath("//a[@id='NoCheckfordeleterow']")).click();
		}
		catch (Exception e) {}
	}

	public void clickYesButtonOnDeletePopupDirectIssuePage() 
	{
		driver.findElement(By.xpath("//a[@id='YesCheckfordeleterow']")).click();
	}

	public void selectSubstitudeDirectIssuePage(String substitude) {
		try {
			driver.findElement(By.xpath("//table[@id='tblSubstitute']//td[contains(text(),'"+substitude+"')]")).click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterIssueQuantityDirectIssuePage(String item, String quantity) 
	{	
		driver.findElement(By.xpath("//table[@id='tbldrugitemdesc']//td[contains(text(),'"+item+"')]//following::input[1]")).sendKeys(quantity);

	}

	public void clickNoButtonOnSavePopupDirectIssuePage() 
	{
		driver.findElement(By.xpath("//a[@id='btnsaveno']")).click();
	}

	public void clickYesButtonOnSavePopupDirectIssuePage() 
	{
		driver.findElement(By.xpath("//a[@id='btnyessaveModal']")).click();
	}

	public void clickYesButtonOnSaveItemReceiptPage() 
	{
		driver.findElement(By.xpath("//a[@id='btnSaveYes']")).click();
	}

	public void clickNoButtonOnPrintPopupDirectIssuePage() 
	{
		driver.findElement(By.xpath("//a[@id='btnno']")).click();
	}

	public void clickClearButtonOnheaderDirectIssuePage() {

		driver.findElement(By.xpath("//a[@id='repeat']//i[@class='fa fa-refresh']")).click();

	}

	public void clickClearButtonOnItemReceiptPage() 
	{
		WebElement clear_btn_element = driver.findElement(By.xpath("//i[@class='fa fa-refresh']"));
		driver.clickByJS(TTWebsiteDriver.driver, clear_btn_element);

	}

	public void enterFromDateDirectIssuePage(String date) {
		driver.clear(FROM_DATE);
		driver.findElement(FROM_DATE).sendKeys(date);
	}



	public void enterToDateDirectIssuePage(String date) {
		driver.clear(TO_DATE);
		driver.findElement(TO_DATE).sendKeys(date);
	}

	public void selectIssuedToFromDropdownDirectIssuePage(String department) {
		Select departmentDropDown = new Select(driver.findElement(By.xpath("//select[@id='ddlisssuestostation']")));
		departmentDropDown.selectByVisibleText(department);
		logger.info("Following Issued to has been selected from Dropdown : " + department);
	}

	public void clickSearchButtonDirectIssuePage() 
	{
		driver.findElement(By.xpath("//i[@class='fa fa-search fa-lg faactnicn']")).click();
	}

	public void clickOnFirstOrderFromSearchDirectIssuePage() {

		driver.findElement(By.xpath("//table[@id='tblschIssued']//tbody/tr[1]")).click();
	}


	// Below Methods are for Direct Receipt Page

	public void searchAndSelectItemsDirectReceiptPage(String items) {

		driver.findElement(By.xpath("//input[@id='txtSearch']")).clear();
		driver.findElement(By.xpath("//input[@id='txtSearch']")).sendKeys(items);
		driver.findElement(By.xpath("//td[contains(text(),'"+items+"')]")).click();
	}

	public void selectConsumablesTabDirectReceiptPage() 
	{
		driver.click(By.xpath("//a[@id='tbConsumables']"));
	}

	public void selectOthersTabDirectReceiptPage() 
	{
		driver.click(By.xpath("//a[@id='tbOthers']"));
	}

	public void clickDeleteButtonAgainstAnItem(String item) 
	{
		driver.click(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::i[1]"));
	}

	public void clickNoButtonOnDeletePopupDirectReceiptPage() {

		driver.findElement(By.xpath("//a[@id='btnDeleteNo']")).click();
	}

	public void clickYesButtonOnDeletePopupDirectReceiptPage() {

		driver.findElement(By.xpath("//a[@id='btnDeleteYes']")).click();
	}

	public void clickCalculateButtonOnHeaderDirectReceiptPage() {
		try {

			WebElement cal_btn = driver.findElement(By.xpath("//i[@class='fa fa-calculator']"));
			driver.clickByJS(TTWebsiteDriver.driver, cal_btn);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void enterQuantityAgainstAnItem(String item, String qty) {
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[2]")).clear();
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[2]")).sendKeys(qty);

	}

	public void removePurRateAgainstAnItem(String item) 
	{
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[3]")).clear();
	}

	public void enterPurRateAgainstAnItem(String item, String rate) {

		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[3]")).clear();
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[3]")).sendKeys(rate);
	}

	public void removeMRPAgainstAnItem(String item) 
	{
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[4]")).clear();
	}

	public void enterMRPAgainstAnItem(String item, String rate) 
	{
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[4]")).clear();
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[4]")).sendKeys(rate);
	}

	public void selectBatchTextBoxAgainstAnItemAndClosePopup(String item) {

		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[11]")).click();
		try {
			driver.findElement(By.xpath("//i[@id='batchpop']")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterBatchTextBoxAgainstAnItemAndClosePopup(String item, String message) 
	{
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[11]")).click();
		try {
			driver.findElement(By.xpath("//i[@id='batchpop']")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[11]")).sendKeys(message);
	}

	public void enterExpiryDateAgainstAnItem(String item, String date) 
	{
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[12]")).clear();
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[12]")).sendKeys(date);
	}

	public void enterMRPForSPMarkUpAgainstAnItem(String item, String rate) 
	{
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[13]")).clear();
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[13]")).sendKeys(rate);
	}

	public void enterSGSTAgainstAnItem(String item, String rate) 
	{
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[5]")).clear();
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[5]")).sendKeys(rate);
	}

	public void enterCGSTAgainstAnItem(String item, String rate) 
	{
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[7]")).clear();
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[7]")).sendKeys(rate);
	}

	public void enterIGSTAgainstAnItem(String item, String rate) 
	{
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[10]")).clear();
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[10]")).sendKeys(rate);
	}

	public void removeSGSTAgainstAnItem(String item) 
	{
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[5]")).clear();
	}

	public void removeCGSTAgainstAnItem(String item) 
	{
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[7]")).clear();
	}

	public void removeIGSTAgainstAnItem(String item) 
	{
		driver.findElement(By.xpath("//table[@id='tblgrid']//td[contains(text(),'"+item+"')]//following::input[10]")).clear();
	}

	public void clickSaveButtonOnHeaderDirectReceiptPage() {
		try {
			WebElement SaveBut = driver.findElement(By.xpath("//i[@id='btnsave']"));
			driver.clickByJS(TTWebsiteDriver.driver, SaveBut);
		}
		catch (Exception e) {
		}
	}

	public void clickNoButtonOnSavePopupDirectReceiptPage() {
		try {
			driver.findElement(By.xpath("//a[@id='btnSaveNo']")).click();
		}
		catch (Exception e) {}
	}

	public void clickYesButtonOnSavePopupDirectReceiptPage() {
		try {
			driver.findElement(By.xpath("//a[@id='btnSaveYes']")).click();
		}
		catch (Exception e) {
		}
	}

	public void clickNoButtonOnPrintPopupDirectReceiptPage() {
		try {
			driver.findElement(By.xpath("//a[@id='btnPrintNo']")).click();
		}
		catch (Exception e) {}
	}

	public void enterFromDateIntendItemsScreen(String date) 
	{
		driver.findElement(By.xpath("//input[@id='TxtFrom']")).clear();
		driver.findElement(By.xpath("//input[@id='TxtFrom']")).sendKeys(date);
		driver.findElement(By.xpath("//input[@id='TxtFrom']")).sendKeys(Keys.ENTER);
	}

	public void enterToDateIntendItemsScreen(String date) 
	{
		driver.findElement(By.xpath("//input[@id='TxtTo']")).sendKeys(date);
	}

	public void enterFromDateItemReceiptScreen(String date) 
	{
		driver.findElement(By.xpath("//input[@id='frmdate']")).clear();
		driver.findElement(By.xpath("//input[@id='frmdate']")).sendKeys(date);
		driver.findElement(By.xpath("//input[@id='frmdate']")).sendKeys(Keys.ENTER);
	}

	public void selectQOHGreaterThanZeroTab() 
	{
		driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(By.xpath("//a[@id='btnQOHgraterthenZero']")));
	}

	public void selectQOHLessThanROLTab() 
	{
		driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(By.xpath("//a[@id='btnQOHlessthenROL']")));
	}

	public void selectQOHGreaterThanROLTab() 
	{
		driver.clickByJS(TTWebsiteDriver.driver,driver.findElement(By.xpath("//a[@id='btnQOHgreaterthenROL']")));
	}

	public void selectAllItemsTab() 
	{
		driver.clickByJS(TTWebsiteDriver.driver,driver.findElement(By.xpath("//a[@id='btnAllItem']")));
	}
	public void clickOnnewIndentreturnRadioButton() 
	{
		driver.click(NEW_INDENT_RETURN);
		if(!driver.findElement(By.xpath("//a[@id='btnreturnackprint']")).isDisplayed()) 
		{
			driver.findElement(By.xpath("//input[@id='indretack']")).click();
		}
	}

	public void clickonprintbutton() 
	{
		try {
			WebElement print_element = driver.findElement(By.xpath("//i[@id='RcvprintdataforSave']"));
			driver.clickByJS(TTWebsiteDriver.driver, print_element);
		}
		catch (Exception e) {}
	}

	public void EnterFromDate(String date) 
	{
		driver.findElement(By.xpath("//input[@id='txtfrmdate']")).clear();
		driver.findElement(By.xpath("//input[@id='txtfrmdate']")).sendKeys(date);
		driver.findElement(By.xpath("//input[@id='txtfrmdate']")).sendKeys(Keys.ENTER);

	}
	public void EnterTODate(String date)
	{
		driver.findElement(By.xpath("//input[@id='txttodate']")).clear();
		driver.findElement(By.xpath("//input[@id='txttodate']")).sendKeys(date);
		driver.findElement(By.xpath("//input[@id='txttodate']")).sendKeys(Keys.ENTER);
	}

	public void SelectRegularStockRadioButton() 
	{
		try {
			WebElement RegularStockRadioButton_element = driver.findElement(By.xpath("//input[@id='rbladdtoregstock']"));
			driver.clickByJS(TTWebsiteDriver.driver, RegularStockRadioButton_element);
		}
		catch (Exception e) {
		}
	}

	public void selectIndentReturnAcknowledge()
	{
		try {
			driver.findElement(By.xpath("//input[@id='indretack']")).click();
		}
		catch (Exception e) {}
	}

	public void clickonNewIndentReturn() 
	{
		try {
			driver.findElement(By.xpath("(//table[@id='newackitemreceipt']//following::tbody//tr[@onclick])[1]")).click();
		}
		catch (Exception e) {}
	}
	public void clickonPrintNoButton() 
	{	
		try 
		{
			driver.findElement(By.xpath("//a[@id='btnnoAckRetPrint']")).click();	
		}
		catch (Exception e) {}
	}
	public void EnterUHIDnumber(String uhidnumber) 
	{
		driver.findElement(By.xpath("//input[@id='uHidtxt']")).clear();
		driver.findElement(By.xpath("//input[@id='uHidtxt']")).sendKeys(uhidnumber);
		driver.findElement(By.xpath("//input[@id='uHidtxt']")).sendKeys(Keys.ENTER);
	}

	public void selectDoctorName(String doctorname) 
	{
		Select sl=new Select(driver.findElement(By.xpath("//select[@id='ddlDoctor']")));
		sl.selectByVisibleText(doctorname);
	}

	public void clickonZeroStockItems() 
	{
		driver.findElement(By.id("chkzerostock")).click();
	}
	public void selectdrugandconsumables(String drug) 
	{
		driver.findElement(By.xpath("//td[text()='"+drug+"']")).click();
	}

	public void clickonBatchNumber(String batchno) 
	{
		try {
			driver.findElement(By.xpath("(//table[@id='tbldrugdtaillist']//tr//td[text()='"+batchno +"'])[1]")).click();
		}
		catch (Exception e) {}
	}

	public void Itemdescriptionquantity(String quantity) 
	{
		try {
			driver.findElement(By.xpath("//input[contains(@id,'qty_')]")).sendKeys(quantity);
		}
		catch (Exception e) {}
	}

	public void saveNothisrecord() 
	{
		try {
			driver.findElement(By.xpath("//a[@id='btnno']")).click();
		}
		catch (Exception e) {}

	}
	public void saveYesthisrecord() 
	{
		try {
			driver.findElement(By.xpath("//a[@id='btnyes']")).click();
		}
		catch (Exception e) {}
	}

	public void clickonOKbutton() 
	{
		try {
			driver.findElement(By.xpath("//a[@id='btnyesPrintModal']")).click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void printrecordYesbutton() 
	{
		try {
			driver.findElement(By.xpath("//a[@id='btnprintyes']")).click();
		}
		catch (Exception e) {}
	}

	public void opbillableTODate(String date) throws InterruptedException 
	{
		driver.findElement(By.xpath("//input[@id='todate']")).clear();
		driver.findElement(By.xpath("//input[@id='todate']")).sendKeys(date);
		driver.findElement(By.xpath("//input[@id='todate']")).sendKeys(Keys.ENTER);
	}

	public void clickonsearchButton() 
	{
		try {
			WebElement searchButton_element = driver.findElement(By.xpath("//a[@id='btnsearch']//i"));
			driver.clickByJS(TTWebsiteDriver.driver, searchButton_element);
			logger.info("Click on Search Button");
		}
		catch (Exception e) {}
	}

	public void clickonpatientdetails() 
	{
		try {
			List<WebElement> onpatientdetails_list = driver.findElements(By.xpath("//table[@id='tblPatientDetail']//tr[@onclick]//td"));
			for(int i=1;i<=onpatientdetails_list.size();i++) 
			{
				String onpatientdetails_text = driver.findElement(By.xpath("(//table[@id='tblPatientDetail']//tr[@onclick]//td)["+i+"]")).getText();
				boolean statusfound=false;
				if(onpatientdetails_text.equals("Active")) 
				{
					driver.findElement(By.xpath("(//table[@id='tblPatientDetail']//tr[@onclick]//td)["+i+"]")).click();
					statusfound=true;
					break;
				}
				if(statusfound==false) 
				{
					driver.findElement(By.xpath("//a[@id='btnclosePatientDetail']//i")).click();
				}
			}
		}
		catch (Exception e) {}
	}

	public void clickoncancelbutton() 
	{
		try {
			WebElement cancel_btn_element = driver.findElement(By.xpath("//a[@id='btnCancleOrder']//i"));
			driver.clickByJS(TTWebsiteDriver.driver, cancel_btn_element);
		}
		catch (Exception e) {}
	}

	public void clickoncancelcheckbox()
	{
		try {
			WebElement cancelcheckbox_element = driver.findElement(By.xpath("//input[@id='checked']"));
			driver.clickByJS(TTWebsiteDriver.driver, cancelcheckbox_element);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonNoSaverecord() 
	{
		try {
			WebElement clickonNoSaverecord = driver.findElement(By.xpath("//a[@id='btnCancleno']"));
			driver.clickByJS(TTWebsiteDriver.driver, clickonNoSaverecord);
		}
		catch (Exception e) {}
	}

	public void clickonYesSaverecord() 
	{
		try {
			WebElement clickonYesSaverecord = driver.findElement(By.xpath("//a[@id='btnCancleyes']"));
			driver.clickByJS(TTWebsiteDriver.driver, clickonYesSaverecord);
		}
		catch (Exception e) {}
	}

	public void clickonconsumptioncancelOKbutton() 
	{
		try {
			WebElement clickonconsumptioncancelOKbutton = driver.findElement(By.xpath("//a[@id='btnyesCancleModelHide']"));
			driver.clickByJS(TTWebsiteDriver.driver, clickonconsumptioncancelOKbutton);
		}
		catch (Exception e) {}
	}

	public void clickonPrintButton() 
	{
		try {
			WebElement clickonPrintButton = driver.findElement(By.xpath("//a[@id='btnPoPrint']"));
			driver.clickByJS(TTWebsiteDriver.driver, clickonPrintButton);
		}
		catch (Exception e) {}
	}
}

