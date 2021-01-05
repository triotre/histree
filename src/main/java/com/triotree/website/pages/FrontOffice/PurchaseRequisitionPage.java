package com.triotree.website.pages.FrontOffice;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class PurchaseRequisitionPage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(PurchaseRequisitionPage.class.getName());

	public PurchaseRequisitionPage(TTWebsiteDriver driver) {
		super(driver);
	}

	private final By SAVE_FLOPPY_ICON = By.xpath("//a[@id='btnSave']//i[@class='fa fa-save']");
	private final By AGAINST_INTEND_RADIO_BTN = By.xpath("//input[@id='againstIndentsRdbBtn']");
	private final By SELECT_CHECKBOX_FIRST_INTEND = By.xpath("//input[@id='tblIndentListChkBx0']");
	private final By DELETE_ICON_LAST_ITEM = By.xpath("//table[@id='tblSelectedItem']//tbody/tr[last()]/td[@class='tblSelectedItem_delete_row']/i");
	private final By FIRST_GRN_STATION = By.xpath("//input[@id='tblGrnStationChkBx0']");
	private final By YES_BTN_SAVE_CONFIRMATION_POPUP = By.xpath("//a[@id='btnSaveAlertYes']");
	private final By SMART_SEARCH_TEXTBOX = By.xpath("//input[@id='txtSmartSearch']");
	private final By NO_BTN_PRINT_ALERT = By.xpath("//a[@id='btnAfterSavePrintAlertNo']");
	private final By CLEAR_BUTTON = By.xpath("//a[@id='btnClear']");
	private final By SEARCH_BTN_REQ_LIST = By.xpath("//i[@id='btnSearchSavedPurReq']");
	private final By PURCHASE_REQUISITION_POPUP_HEADER = By.xpath("//span[contains(text(),'Purchase requisition')]");
	private final By FIRST_PURCHASE_REQ_FROM_POPUP = By.xpath("//table[@id='purReqListTbl']//tbody//tr[1]/td[1]");
	private final By MODIFY_BUTTON = By.xpath("//a[@id='btnModify']//i[@class='fa fa-save']");
	private final By YES_BUTTON_MODIFY_ALERT = By.xpath("//a[@id='btnModifyAlertYes']");
	private final By PRINT_REQ_MODIFIED_POPUP = By.xpath("//label[@id='lblAfterSavePrintMsg']");
	private final By PRINT_YES=By.xpath("//a[@id='btnAfterSavePrintAlertYes']");
	private final By Item_Search=By.xpath("//input[@id='txtSearchItem']");

	public void clickOnSaveFloppyIcon() {
		WebElement element =driver.findElement(SAVE_FLOPPY_ICON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Save Floppy Icon clicked");
	}

	public void clickOnAgainstIntendradioButton() {
		WebElement element = driver.findElement(AGAINST_INTEND_RADIO_BTN);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Against Intend Radio Button clicked");
	}

	public void checkSelectCheckboxForFirstIntend() {
		WebElement element = driver.findElement(SELECT_CHECKBOX_FIRST_INTEND);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Select Checkbox for First Intend Checked");
	}

	public void deleteLastItemFromBlowGrid() 
	{
		driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(DELETE_ICON_LAST_ITEM));
	}

	public void deleteSelectedItemFromBlowGrid(String item) {

		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'"+item+"')]//following::td[@class='tblSelectedItem_delete_row']/i"));
		driver.clickByJS(TTWebsiteDriver.driver, element);
	}

	public void changeQuantityForItemsInBlowGrid() {
		List<WebElement> elements = driver.findElements(By.xpath("//td[@ctype='TOTAL_QOH']//following::td/input"));
		int totalItems = elements.size();
		for(int i=totalItems;i>=1;i--) {
			driver.findElement(By.xpath("//input[@id='tblSelectedItemTxtQtyNew"+i+"']")).clear();
			driver.findElement(By.xpath("//input[@id='tblSelectedItemTxtQtyNew"+i+"']")).sendKeys("10");
		}
	}

	public void selectFirstGRNStation() {
		WebElement element = driver.findElement(FIRST_GRN_STATION);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("First GRN Station Selected");

	}

	public void clickOnYesButtonOnSaveConfirmationPopup() {
		try {
			driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(YES_BTN_SAVE_CONFIRMATION_POPUP));
			logger.info("Yes Button on save confirmation popup clicked");
		}
		catch (Exception e) {}
	}

	public boolean verifyPurchaseSavedSuccessMessage(String message) 
	{
		if (driver.findElement(By.xpath("//label[contains(text(),'"+message+"')]")).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}

	public void selectInventory(String inventory) {
		try {
			driver.findElement(By.xpath("//a[contains(text(),'"+inventory+"')]")).click();
			Thread.sleep(8000);
		}
		catch (Exception e) {}
	}

	public void searchItemsFromSmartSearchAndSelect(String items) {
		driver.findElement(SMART_SEARCH_TEXTBOX).clear();
		driver.findElement(SMART_SEARCH_TEXTBOX).sendKeys(items);

		driver.findElement(By.xpath("//td[contains(text(),'"+items+"')]")).click();
		logger.info("Following item has been searched from Smart Search Text Box "+items);

	}

	public void searchItems(String items) {
		try {
			driver.findElement(Item_Search).clear();
			driver.findElement(Item_Search).sendKeys(items);

			driver.findElement(By.xpath("//td[contains(text(),'"+items+"')]")).click();
			logger.info("Following item has been searched from Smart Search Text Box "+items);
		}
		catch (Exception e) {
		}

	}
	public void selectTab(String tab) {
		try {
			WebElement element =driver.findElement(By.xpath("//a[contains(text(),'"+tab+"')]"));
			driver.clickByJS(TTWebsiteDriver.driver, element);
			logger.info("Following tab has been clicked "+tab);
		}
		catch (Exception e) {
		}
	}

	public void enterQuantityForSelectedItems() {		
		List<WebElement> elements = driver.findElements(By.xpath("//table[@id='tblSelectedItem']//tbody//tr"));
		int totalMedicines = elements.size();
		for(int i=totalMedicines;i>=1;i--) {
			driver.findElement(By.xpath("//input[@id='tblSelectedItemTxtQtyNew"+i+"']")).sendKeys("11");
		}



	}

	public void clickNoButtonOnPrintAlertPopup() {
		try {
			driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(NO_BTN_PRINT_ALERT));
			logger.info("No Button on Print Alert Popup clicked");
		}
		catch (Exception e) {
		}
	}

	public void clickOnClearButton() {
		try {
			driver.clickByJS(TTWebsiteDriver.driver,driver.findElement(CLEAR_BUTTON));
			logger.info("Clear Button Clicked");
		}
		catch (Exception e) {
		}
	}

	public void clickOnSearchButtonOnPurchaseRequisitionList() {
		try {
			driver.clickByJS(TTWebsiteDriver.driver,driver.findElement(SEARCH_BTN_REQ_LIST));
		}
		catch (Exception e) {
		}
	}

	public boolean verifyPurchaseRequisitionPopupOpened() {
		if (driver.findElement(PURCHASE_REQUISITION_POPUP_HEADER).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}

	public void selectFirstPurchaseRequisitionFromPurchaseRequisitionPopup() {
		try {
			driver.clickByJS(TTWebsiteDriver.driver,driver.findElement(FIRST_PURCHASE_REQ_FROM_POPUP));
		}
		catch (Exception e) {
		}
	}

	public void clickOnModifyButton() {
		try {
			WebElement MODIFY_BU = driver.findElement(MODIFY_BUTTON);
			driver.clickByJS(TTWebsiteDriver.driver, MODIFY_BU);
			logger.info("Modify Button Clicked");
		}
		catch (Exception e) {}
	}

	public void clickOnYesButtonOnModifyAlertPopup() {
		try {
			driver.clickByJS(TTWebsiteDriver.driver,driver.findElement(YES_BUTTON_MODIFY_ALERT));
			logger.info("Yes Button on Modify Alert Popup clicked");
		}
		catch (Exception e) {}
	}

	public boolean verifyPurchaseReqModifiedSuccessPopup() 
	{
		if(driver.findElement(PRINT_REQ_MODIFIED_POPUP).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}

	// Below methods are for Purchase Requisition Approval Page
	public void enterFromDatePurchaseRequisitionApprovalPage(String date) {
		driver.clear(By.xpath("//input[@id='dtpFrm']"));
		driver.findElement(By.xpath("//input[@id='dtpFrm']")).sendKeys(date);
	}

	public void enterToDatePurchaseRequisitionApprovalPage(String date) {
		driver.clear(By.xpath("//input[@id='dtpTo']"));
		driver.findElement(By.xpath("//input[@id='dtpTo']")).sendKeys(date);
	}

	public void selectCheckboxPurchaseRequisitionApprovalPage(String box) {
		driver.click(By.xpath("//label[contains(text(),'"+box+"')]//preceding::input[1]"));
	}

	public boolean verifyResultsPopupIsDispalyed(String popup) {
		return driver.isElementPresent(By.xpath("//div[@id='NewRequistionModal']//span[@class='header_title'][contains(text(),'"+popup+"')]"), 60);
	}

	public void selectFirstValueFromResults() {
		driver.click(By.xpath("//table[@id='newlst']//tr[1]/td[2]"));
	}

	public void clickEditBtnPurchaseRequisitionApprovalPage() {
		driver.click(By.xpath("//i[@class='fa fa-save']"));
	}

	public void enterQuantityAgainstAnItem(String item, String qty) {
		try {
			driver.findElement(By.xpath("//td[contains(text(),'"+item+"')]//following::input[1]")).clear();
			driver.findElement(By.xpath("//td[contains(text(),'"+item+"')]//following::input[1]")).sendKeys(qty);
		}
		catch (Exception e) {

		}
	}

	public void clickAcceptBtnPurchaseRequisitionApprovalPage() {
		driver.click(By.xpath("//i[@class='fa fa-check-square']"));
	}

	public boolean verifyApprovalPopupIsDisplayed() {
		return driver.isElementPresent(By.xpath("//label[@id='lblmodal' and contains(text(),'Approve')]"), 40);
	}

	public boolean verifyRejectionPopupIsDisplayed() {
		return driver.isElementPresent(By.xpath("//label[@id='lblmodal' and contains(text(),'Reject')]"), 40);
	}

	public void clickNoButtonOnApprovePopup() {
		try {
			driver.findElement(By.xpath("//a[@id='Rejectednoid']")).click();
		}
		catch (Exception e) {
		}
	}

	public void clickYesButtonOnApprovePopup() {
		try {
			driver.findElement(By.xpath("//a[@id='Rejectedyesid']")).click();
		}
		catch (Exception e) {
		}
	}

	public void clickRejectBtnPurchaseRequisitionApprovalPage() {
		try {
			driver.pauseExecutionFor(4000);
			driver.waitForElementPresent(By.xpath("//a[@id='btnreject']//i[@class='fa fa-times']"), 10);
			driver.click(By.xpath("//a[@id='btnreject']//i[@class='fa fa-times']"));
		}
		catch (Exception e) {
		}
	}

	public void enterRemarksPurchaseRequisitionApprovalPage() {
		try {
			driver.pauseExecutionFor(3000);
			driver.waitForElementPresent(By.xpath("//textarea[@id='txtpurchase']"), 10);
			driver.findElement(By.xpath("//textarea[@id='txtpurchase']")).sendKeys("Testing Remarks");
		}
		catch (Exception e) {
		}
	}

	public void clickNoButtonOnRejectPopup() {
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='Rejectednoid']"), 10);
			driver.findElement(By.xpath("//a[@id='Rejectednoid']")).click();
		}
		catch (Exception e) {
		}
	}

	public void clickYesButtonOnRejectPopup() {
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='Rejectedyesid']"), 10);
			driver.findElement(By.xpath("//a[@id='Rejectedyesid']")).click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	//Below locators are for Purchase Order Test


	public void clickSaveButtonOnPurchaseOrderPage() {
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='save']//i[@class='fa fa-save']"), 10);
			driver.findElement(By.xpath("//a[@id='save']//i[@class='fa fa-save']")).click();
		}
		catch (Exception e) {}
	}

	public void clickCalculateButtonOnPurchaseOrderPage() {
		try {
			driver.pauseExecutionFor(4000);
			driver.waitForElementPresent(By.xpath("//i[@class='fa fa-calculator']"), 10);
			driver.findElement(By.xpath("//i[@class='fa fa-calculator']")).click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickSchemeButtonOnPurchaseOrderPage() {
		try {
			driver.pauseExecutionFor(4000);
			driver.waitForElementPresent(By.xpath("//i[@class='fa fa-gift']"), 10);
			driver.findElement(By.xpath("//i[@class='fa fa-gift']")).click();
		}
		catch (Exception e) {
		}
	}


	public void clickConsumablesTabOnPurchaseOrderPage() {
		try {
			driver.pauseExecutionFor(4000);
			driver.waitForElementPresent(By.xpath("//ul[@id='tabdrugs']//a[contains(text(),'Consumables')]"), 10);
			driver.findElement(By.xpath("//ul[@id='tabdrugs']//a[contains(text(),'Consumables')]")).click();
		}
		catch (Exception e) {
		}
	}

	public void clickMedicineTabOnPurchaseOrderPage() {
		try {
			driver.pauseExecutionFor(4000);
			driver.waitForElementPresent(By.xpath("//a[contains(text(),'Medicine')]"), 10);
			driver.findElement(By.xpath("//a[contains(text(),'Medicine')]")).click();
		}
		catch (Exception e) {}
	}

	public void clickOtherTabOnPurchaseOrderPage() {
		try {
			driver.pauseExecutionFor(4000);
			driver.waitForElementPresent(By.xpath("//ul[@id='tabdrugs']//a[contains(text(),'Other')]"), 10);
			driver.findElement(By.xpath("//ul[@id='tabdrugs']//a[contains(text(),'Other')]")).click();
		}
		catch (Exception e) {}
	}


	public void selectSuppliersFromPurchaseOrderPage(String station) {
		try {
			driver.waitForElementPresent(By.xpath("//select[@id='ddlsupplierlist']"), 10);
			Select stationDropDown = new Select(driver.findElement(By.xpath("//select[@id='ddlsupplierlist']")));
			stationDropDown.selectByVisibleText(station);
		}
		catch (Exception e) {
		}
	}

	public void searchItemsPurchaseOrderPageAndVerifyItsSearchable(String station) {
		try {
			driver.pauseExecutionFor(2000);
			driver.waitForElementPresent(By.xpath("//input[@id='searchDirectIssueDrugs']"), 10);
			driver.findElement(By.xpath("//input[@id='searchDirectIssueDrugs']")).clear();
			driver.findElement(By.xpath("//input[@id='searchDirectIssueDrugs']")).sendKeys(station);
			driver.pauseExecutionFor(3000);
			driver.findElement(By.xpath("//table[@class='table']//td[contains(text(),'"+station+"')]")).click();
		}
		catch (Exception e) {
		}
	}

	public void clickOnItemCode(String item) {
		try {
			driver.pauseExecutionFor(3000);
			driver.waitForElementPresent(By.xpath("//td[contains(text(),'"+item+"')]"), 10);
			driver.click(By.xpath("//td[contains(text(),'"+item+"')]"));
		}
		catch (Exception e) {
		}
	}

	public boolean isDeletePopupDisplayedOnPurchaseOrderPage() {
		return driver.isElementPresent(By.xpath("//div[@id='podetaillist_Modal']//label[contains(text(),'Do you want to delete?')]"), 60);
	}

	public boolean isPrintPopupDisplayedOnPurchaseOrderPage() {
		return driver.isElementPresent(By.xpath("//section[contains(text(),'generated successfully. Print?')]"), 60);
	}

	public boolean isApprovalProcessPopupDisplayedOnPurchaseOrderPage() {
		return driver.isElementPresent(By.xpath("//label[contains(text(),'On modifying this PO ,the approval process will st')]"), 60);
	}

	public void clickNoButtonPrintPopupOnPurchaseOrderPage() {
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnsavedprintpono']"), 10);
			driver.click(By.xpath("//a[@id='btnsavedprintpono']"));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickNoButtonApprovalProcessPopupOnPurchaseOrderPage() {
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnisModifypono']"), 10);
			driver.click(By.xpath("//a[@id='btnisModifypono']"));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickYesButtonApprovalProcessPopupOnPurchaseOrderPage() {
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnisModifypoyes']"), 10);
			driver.click(By.xpath("//a[@id='btnisModifypoyes']"));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickNoButtonOnPlaceMoreOrderPopupOnPurchaseOrderPage() {
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnplaceotherPOno']"), 10);
			driver.click(By.xpath("//a[@id='btnplaceotherPOno']"));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean isSavePopupDisplayedOnPurchaseOrderPage() {
		return driver.isElementPresent(By.xpath("//label[contains(text(),'Save this record ?')]"), 10);
	}

	public boolean isFreeItemsPopupDisplayedOnPurchaseOrderPage() {
		return driver.isElementPresent(By.xpath("//span[contains(text(),'Free Items')]"), 10);
	}

	public void closeFreeItemsPopup() {
		try {
			driver.isElementPresent(By.xpath("//div[@id='pofreeItems_Modal']//i[@class='fa fa-times']"), 10);
			driver.click(By.xpath("//div[@id='pofreeItems_Modal']//i[@class='fa fa-times']"));
		}
		catch (Exception e) {
		}
	}

	public void clickNoOnDeletePopupOnPurchaseOrderPage() {
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnchkmrgno']"), 10);
			driver.findElement(By.xpath("//a[@id='btnchkmrgno']")).click();
		}
		catch (Exception e) {
		}
	}

	public void clickYesOnDeletePopupOnPurchaseOrderPage() {
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnchkmrgyes']"), 10);
			driver.findElement(By.xpath("//a[@id='btnchkmrgyes']")).click();
		}
		catch (Exception e) {
		}
	}

	public void clickNoOnSavePopupOnPurchaseOrderPage() {
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnsavepono']"), 10);
			driver.findElement(By.xpath("//a[@id='btnsavepono']")).click();
		}
		catch (Exception e) {}
	}

	public void clickYesOnSavePopupOnPurchaseOrderPage() {
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnsavepoyes']"), 10);
			driver.findElement(By.xpath("//a[@id='btnsavepoyes']")).click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickFreeButtonAgainstItem(String item) {
		try {
			driver.waitForElementPresent(By.xpath("//table[@id='tblpurchseOrder']//td[contains(text(),'"+item+"')]//following::input[@value='Free'][1]"), 60);
			driver.findElement(By.xpath("//table[@id='tblpurchseOrder']//td[contains(text(),'"+item+"')]//following::input[@value='Free'][1]")).click();
		}
		catch (Exception e) {
		}
	}

	public void clickSameItemRadioButton() {
		try {
			driver.waitForElementPresent(By.xpath("//div[@id='pofreeItems_Modal']//span[1]//input[1]"));
			driver.click(By.xpath("//div[@id='pofreeItems_Modal']//span[1]//input[1]"));
		}
		catch (Exception e) {
		}
	}

	public void clickDifferentItemRadioButton() {
		try {
			driver.waitForElementPresent(By.xpath("//div[@id='pofreeItems_Modal']//span[2]//input[1]"));
			driver.click(By.xpath("//div[@id='pofreeItems_Modal']//span[2]//input[1]"));
		}
		catch (Exception e) {}
	}	

	public void clickPurchaseDetailsTab() {
		try {
			driver.waitForElementPresent(By.xpath("//a[contains(text(),'Purchase Details')]"));
			driver.click(By.xpath("//a[contains(text(),'Purchase Details')]"));
		}
		catch (Exception e) {}
	}

	public void enterFreeQuantityForSelectedMedicinesOnPurchaseOrderPage() {
		try {
			List<WebElement> elements = driver.findElements(By.xpath("//input[@name='txtFreeNewQuantity']"));
			int totalMedicines = elements.size();

			for(int i=totalMedicines;i>=1;i--) {
				driver.pauseExecutionFor(3000);
				driver.findElement(By.xpath("(//input[@name='txtFreeNewQuantity'])["+i+"]")).clear();
				driver.findElement(By.xpath("(//input[@name='txtFreeNewQuantity'])["+i+"]")).sendKeys("20");
			}
		}
		catch (Exception e) {}
	}

	public void enterQuantityForSelectedMedicinesOnPurchaseDetailsTabS() {
		try {
			driver.pauseExecutionFor(3000);
			List<WebElement> elements = driver.findElements(By.xpath("//input[@name='txtNewQuantity']"));
			int totalMedicines = elements.size();

			for(int i=totalMedicines;i>=1;i--) {
				driver.findElement(By.xpath("(//input[@name='txtNewQuantity'])["+i+"]")).clear();
				driver.findElement(By.xpath("(//input[@name='txtNewQuantity'])["+i+"]")).sendKeys("10");
			}
		}
		catch (Exception e) {
		}
	}

	public void enterRPUForSelectedMedicinesOnPurchaseDetailsTabS() {

		driver.pauseExecutionFor(3000);
		List<WebElement> elements = driver.findElements(By.xpath("//input[@name='txtNewQuantity']//following::input[@class='txtPOInputBox clsnumeric'][1]"));
		int totalMedicines = elements.size();

		for(int i=totalMedicines;i>=1;i--) {
			driver.findElement(By.xpath("(//input[@name='txtNewQuantity']//following::input[@class='txtPOInputBox clsnumeric'][1])["+i+"]")).clear();
			driver.findElement(By.xpath("(//input[@name='txtNewQuantity']//following::input[@class='txtPOInputBox clsnumeric'][1])["+i+"]")).sendKeys("50");
		}

	}


	public void clickPendingForApprovalRadioButton() {
		driver.pauseExecutionFor(4000);
		driver.navigate().refresh();
		driver.pauseExecutionFor(4000);
		WebElement RadioButton_element = driver.findElement(By.xpath("//fieldset[@class='schPODetailsDiv']//span[3]//input[1]"));
		driver.clickByJS(TTWebsiteDriver.driver, RadioButton_element);
	}

	public void selectFirstPurchaseOrderFromPurchaseOrderPopup() {
		try {
			driver.waitForElementPresent(By.xpath("//div[@id='popup900']//section[@class='popupBody']//tbody//tr[1]/td[1]"));
			driver.click(By.xpath("//div[@id='popup900']//section[@class='popupBody']//tbody//tr[1]/td[1]"));
		}
		catch (Exception e) {}
	}

	public void checkSmartCheckbox() {
		try {
			driver.waitForElementPresent(By.xpath("//input[@id='Chksmart_search']"), 10);
			driver.click(By.xpath("//input[@id='Chksmart_search']"));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void enterQuantityForSelectedMedicinesOnPurchaseDetailsTabS(String medicine) {
		driver.pauseExecutionFor(3000);
		driver.findElement(By.xpath("//table[@id='tblpurchseOrder']//td[contains(text(),'"+medicine+"')]//following::input[@name='txtNewQuantity'][1]")).clear();
		driver.findElement(By.xpath("//table[@id='tblpurchseOrder']//td[contains(text(),'"+medicine+"')]//following::input[@name='txtNewQuantity'][1]")).sendKeys("10");
	}

	public void enterRPUForSelectedMedicinesOnPurchaseDetailsTabS(String medicine) {

		driver.pauseExecutionFor(3000);
		driver.findElement(By.xpath("//table[@id='tblpurchseOrder']//td[contains(text(),'"+medicine+"')]//following::input[@class='txtPOInputBox clsnumeric'][2]")).clear();
		driver.findElement(By.xpath("//table[@id='tblpurchseOrder']//td[contains(text(),'"+medicine+"')]//following::input[@class='txtPOInputBox clsnumeric'][2]")).sendKeys("50");
	}
	public void printyesbutton() {
		driver.pauseExecutionFor(3000);
		driver.findElement(PRINT_YES).click();
	}

}
