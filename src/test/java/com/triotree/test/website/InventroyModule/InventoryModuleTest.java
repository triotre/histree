package com.triotree.test.website.InventroyModule;

import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.triotree.test.base.ResultListener;
import com.triotree.test.website.TTWebsiteBaseTest;
import com.triotree.website.pages.CommonPages.HISHomePage;
import com.triotree.website.pages.FrontOffice.BillingPage;
import com.triotree.website.pages.FrontOffice.FrontOfficeHomePage;
import com.triotree.website.pages.FrontOffice.IndentApprovalPage;
import com.triotree.website.pages.FrontOffice.IndentIssuePage;
import com.triotree.website.pages.FrontOffice.IndentItemsPage;
import com.triotree.website.pages.FrontOffice.PatientRegistrationPage;
import com.triotree.website.pages.FrontOffice.PurchaseRequisitionPage;

@Listeners(ResultListener.class)
public class InventoryModuleTest extends TTWebsiteBaseTest{

	private static final Logger logger = LogManager
			.getLogger(InventoryModuleTest.class.getName());

	private HISHomePage hisHomePage;
	private FrontOfficeHomePage frontOfficeHomePage;
	private PatientRegistrationPage patientRegistrationPage;
	private IndentItemsPage indentItemsPage;
	private IndentApprovalPage indentApprovalPage;
	private IndentIssuePage indentIssuePage;
	private PurchaseRequisitionPage purchaseRequisitionPage;
	private BillingPage billingPage;

	private String patientRegistrationId = "RAJH.17152995";
	private String desc = null;
	private String title1 = null;
	private String desc1 = null;


	@Test(priority = 1) //pass and fixed 16-04-2020
	public void inventoryIndentOrderTest() throws Throwable {
		test=extent.createTest("inventoryIndentOrderTest", "This test case verify the inventory Indent Order Test");
		test.assignCategory("Inventory Module Test");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Items");
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please select atleast one Facility"), "Please select atleast one Facility error message not displayed");
		indentItemsPage.selectToFacilityFromDropdown("L1-SANITY-T3");
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please select Department!"), "Please select Department! error message not displayed");
		//driver.pauseExecutionFor(7000);
		Thread.sleep(4000);
		indentItemsPage.selectToDepartmentFromDropdown("Central General Store");
		indentItemsPage.selectSmartSearchCheckbox();
		indentItemsPage.clickOnRefreshStockLabel();
		//assertTrue(indentItemsPage.verifyActionMessage("Calculation for all item completed successfully!"), "Calculation for all item completed successfully! action message not displayed");
		indentItemsPage.clickOnSelectAllLabel();

		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("A TO Z SYP 200ML");
		//driver.pauseExecutionFor(7000);
		//		Thread.sleep(7000);
		//		indentItemsPage.selectMedicines("ACAMPROL TAB");
		Thread.sleep(3000);
		indentItemsPage.selectMedicines("ACETEN TAB 12.5MG");
		//driver.pauseExecutionFor(7000);
		Thread.sleep(3000);
		indentItemsPage.selectMedicines("BACLOF10 MG TAB");
		//		assertTrue(indentItemsPage.verifyActionMessage("AB PHYLLINE CAP already selected!"), "Duplicate Medicine message not displayed");
		///indentItemsPage.selectMedicines("AHAGLOW S SPRAY");
		//assertTrue(indentItemsPage.verifyActionMessage("This is Discontinued Item and Stock at other store"), "Discontinued Medicine Error message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicines("ANKLE SUPPORT LARGE");
		//driver.pauseExecutionFor(7000);
		Thread.sleep(3000);
		indentItemsPage.selectOthersTab();
		//driver.pauseExecutionFor(7000);
		Thread.sleep(3000);
		indentItemsPage.selectMedicines("DRESSING KIT SMALL");
		Thread.sleep(3000);
		indentItemsPage.selectMedicines("GENERAL MEDICINE");
		Thread.sleep(3000);
		indentItemsPage.selectMedicines("PAPANICOLAU OG6-BIO");
		Thread.sleep(3000);
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please enter quantity for following Items"), "Please enter quantity Error message not displayed");
		indentItemsPage.enterQuantityForSelectedMedicines();
		indentItemsPage.enterRemarksForSelectedMedicines();
		indentItemsPage.clickOnSaveButton();
		///assertTrue(indentItemsPage.isSavePopupShowing(), "Do you want to save popup not showing up");
		indentItemsPage.clickYesOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Saved Successfully,Print can be take"), "Saved Successfully message not displayed");
		indentItemsPage.clickOnNewRadioButton();
		//assertTrue(indentItemsPage.isNewIndentPopupDisplayed(), "New Indent Popup is not displayed");
		indentItemsPage.selectFirstIndentFromPopup();
		Thread.sleep(3000);
		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("AMITAX INJ 100MG");
		Thread.sleep(3000);
		indentItemsPage.enterQuantityForNewMedicines();
		indentItemsPage.enterRemarksForSelectedNewMedicines();
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.clickYesOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Indent modified successfully"), "Indent modified successfully message not displayed");

	}

	@Test(priority = 2) //pass and fixed  08-06-2020
	public void inventoryWithIndentApprovalTest() throws Throwable {
		test=extent.createTest("inventoryWithIndentApprovalTest", "This test case verify the inventory With Indent Approval Test");
		test.assignCategory("Inventory Module Test");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Items");
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please select atleast one Facility"), "Please select atleast one Facility error message not displayed");
		indentItemsPage.selectToFacilityFromDropdown("L1-SANITY-T3");
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please select Department!"), "Please select Department! error message not displayed");
		//driver.pauseExecutionFor(7000);
		Thread.sleep(2000);
		indentItemsPage.selectToDepartmentFromDropdown("Central General Store");
		indentItemsPage.selectSmartSearchCheckbox();
		indentItemsPage.selectQOHGreaterThanZeroTab();
		indentItemsPage.clickOnRefreshStockLabel();
		//assertTrue(indentItemsPage.verifyActionMessage("Calculation for all item completed successfully!"), "Calculation for all item completed successfully! action message not displayed");
		//driver.pauseExecutionFor(18000);
		Thread.sleep(3000);
		indentItemsPage.selectQOHLessThanROLTab();
		indentItemsPage.selectQOHGreaterThanROLTab();
		indentItemsPage.selectAllItemsTab();

		indentItemsPage.clickOnSelectAllLabel();

		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("A TO Z SYP 200ML");
		Thread.sleep(2000);		
		indentItemsPage.selectMedicines("ACETEN TAB 12.5MG");
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("BACLOF10 MG TAB");
		///driver.pauseExecutionFor(7000);
		//		driver.pauseExecutionFor(3000);
		//		indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		//		assertTrue(indentItemsPage.verifyActionMessage("AB PHYLLINE CAP already selected!"), "Duplicate Medicine message not displayed");
		//		indentItemsPage.selectConsumablesTab();
		//		indentItemsPage.selectMedicineTab();
		//		indentItemsPage.selectMedicines("AHAGLOW S SPRAY");
		//assertTrue(indentItemsPage.verifyActionMessage("This is Discontinued Item and Stock at other store"), "Discontinued Medicine Error message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicines("ANKLE SUPPORT SMALL");
		indentItemsPage.selectMedicines("ANKLE SUPPORT MEDIUM");
		indentItemsPage.selectMedicines("ANKLE SUPPORT LARGE");

		//assertTrue(indentItemsPage.verifyActionMessage("already"), "Already Selected message not displayed");


		//driver.pauseExecutionFor(7000);
		Thread.sleep(2000);
		indentItemsPage.selectOthersTab();
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("PAPANICOLAU EA36-BIO");
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("GENERAL MEDICINE");
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("PIPETTE STAND ROUND BEST");
		Thread.sleep(2000);
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please enter quantity for following Items"), "Please enter quantity Error message not displayed");
		indentItemsPage.selectDeleteButtonAgainstMedicines("PIPETTE STAND ROU");
		indentItemsPage.enterQuantityForSelectedMedicines();
		indentItemsPage.enterRemarksForSelectedMedicines();
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.isSavePopupShowing(), "Do you want to save popup not showing up");
		indentItemsPage.clickYesOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Saved Successfully,Print can be take"), "Saved Successfully message not displayed");

		indentItemsPage.enterFromDateIntendItemsScreen("04/Jun/2020");
		//		indentItemsPage.enterToDateIntendItemsScreen("11/Jan/2020");
		indentItemsPage.clickOnNewRadioButton();
		//assertTrue(indentItemsPage.isNewIndentPopupDisplayed(), "New Indent Popup is not displayed");
		indentItemsPage.selectFirstIndentFromPopup();
		Thread.sleep(2000);
		//		indentItemsPage.selectOthersTab();
		//		indentItemsPage.selectMedicines("PAPANICOLAU EA36-BIO");
		//		Thread.sleep(2000);
		//		indentItemsPage.enterQuantityForNewMedicines("PAPANICOLAU EA36-BIO");
		//		indentItemsPage.enterRemarksForSelectedNewMedicines("PAPANICOLAU EA36-BIO");
		//		indentItemsPage.clickOnSaveButton();
		//		indentItemsPage.clickYesOnSaveButton();
		//		assertTrue(indentItemsPage.verifyActionMessage("Indent modified successfully"), "Indent modified successfully message not displayed");

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Approval");
		indentApprovalPage.clickOnApproveButton();
		//assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Approve button without selecting any Indent");
		indentApprovalPage.clickOnRejectButton();
		//assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Reject button without selecting any Indent");
		indentApprovalPage.clickOnRefreshButton();
		indentApprovalPage.enterFromDate("01/Jun/2020");
		indentApprovalPage.selectStore("1st FLR T1 Transplant ICU");
		indentApprovalPage.clickOnNewIndentRadioButton();
		try {
			String indentNoFromNewIndent = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z SYP 200ML", "20");
		indentApprovalPage.clickOnApproveButton();
		//driver.pauseExecutionFor(4000);
		Thread.sleep(4000);
		indentApprovalPage.clickOnYesButtonOnApprovalConfirmationPopup();
		//driver.pauseExecutionFor(4000);
		Thread.sleep(4000);
		indentApprovalPage.enterFromDate("01/Jun/2020");		
		indentApprovalPage.clickOnNewIndentRadioButton();
		try {
			String indentNoFromNewIndent1 = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		}
		catch (Exception e) {

		}
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z SYP 200ML", "30");
		indentApprovalPage.clickOnRejectButton();
		indentApprovalPage.clickOnYesButtonOnRejectionConfirmationPopup();
		driver.pauseExecutionFor(4000);
		indentApprovalPage.enterFromDate("04/Jun/2020");
		indentApprovalPage.selectStore("Crash Cart  T1-CTVS");
		indentApprovalPage.clickOnNewIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.selectStore("Crash Cart  T1-CTVS");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.selectStore("Crash Cart  T1-CTVS");
		indentApprovalPage.clickOnRejectedIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.enterFromDate("25/Jun/2020");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		try {
			String indentNoFromApproveIndent = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		}
		catch (Exception e) {}
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");
		indentApprovalPage.enterFromDate("15/Jun/2020");
		indentApprovalPage.clickOnRejectedIndentRadioButton();
		//indentApprovalPage.selectFirstIndentFromRejectedIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");

		indentApprovalPage.enterFromDate("15/Jun/2020");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		try {
			String indentNoFromApproveIndent2 = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		}
		catch (Exception e) {}
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");
		indentApprovalPage.enterFromDate("15/Jun/2020");
		indentApprovalPage.clickOnRejectedIndentRadioButton();
		//indentApprovalPage.selectFirstIndentFromRejectedIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");

		//		frontOfficeHomePage.clickOnMenu();
		//		frontOfficeHomePage.clickOnHomeIcon();
		//
		//		hisHomePage.clickOnInventoryIcon(test);
		//		indentItemsPage.selectToDepartmentFromDropdown("Central General Store");

		//		  frontOfficeHomePage.clickOnIndentIssuesAndSelectAnOption("Indent Items");
		//		  driver.pauseExecutionFor(15000);
		//		  indentItemsPage.enterFromDateIntendItemsScreen("08/Mar/2019");
		//		  indentItemsPage.clickOnApprovedButtonOnIndentItems();
		//		  indentItemsPage.selectFirstIndentFromPopup(); driver.pauseExecutionFor(4000);
		//		  indentItemsPage.clickOnRejectedButtonOnIndentItems();
		//		  indentItemsPage.selectFirstIndentFromPopup(); driver.pauseExecutionFor(5000);


	}

	@Test(priority = 3) //pass and fixed 08-06-2020
	public void inventoryIntendIssue1Test() throws Throwable {
		test=extent.createTest("inventoryIntendIssue1Test", "This test case verify the inventory Intend Issue1 Test");
		test.assignCategory("Inventory Module Test");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Items");
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please select atleast one Facility"), "Please select atleast one Facility error message not displayed");
		indentItemsPage.selectToFacilityFromDropdown("L1-SANITY-T3");
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please select Department!"), "Please select Department! error message not displayed");
		Thread.sleep(2000);
		indentItemsPage.selectToDepartmentFromDropdown("Central General Store");
		indentItemsPage.selectSmartSearchCheckbox();
		indentItemsPage.selectQOHGreaterThanZeroTab();
		indentItemsPage.clickOnRefreshStockLabel();
		//assertTrue(indentItemsPage.verifyActionMessage("Calculation for all item completed successfully!"), "Calculation for all item completed successfully! action message not displayed");
		indentItemsPage.clickOnSelectAllLabel();
		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("A TO Z SYP 200ML");
		Thread.sleep(2000);		
		indentItemsPage.selectMedicines("ACETEN TAB 12.5MG");
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("BACLOF10 MG TAB");
		//		driver.pauseExecutionFor(3000);
		//		indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		//		assertTrue(indentItemsPage.verifyActionMessage("AB PHYLLINE CAP already selected!"), "Duplicate Medicine message not displayed");
		//indentItemsPage.selectMedicines("AHAGLOW S SPRAY");
		//assertTrue(indentItemsPage.verifyActionMessage("This is Discontinued Item and Stock at other store"), "Discontinued Medicine Error message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicines("ANKLE SUPPORT SMALL");
		indentItemsPage.selectMedicines("ANKLE SUPPORT MEDIUM");
		indentItemsPage.selectMedicines("ANKLE SUPPORT LARGE");
		indentItemsPage.selectOthersTab();
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("PAPANICOLAU EA36-BIO");
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("GENERAL MEDICINE");
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("PIPETTE STAND ROUND BEST");
		Thread.sleep(2000);
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please enter quantity for following Items"), "Please enter quantity Error message not displayed");
		indentItemsPage.enterQuantityForSelectedMedicines();
		indentItemsPage.enterRemarksForSelectedMedicines();
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.isSavePopupShowing(), "Do you want to save popup not showing up");
		indentItemsPage.clickYesOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Saved Successfully,Print can be take"), "Saved Successfully message not displayed");

		indentItemsPage.enterFromDateIntendItemsScreen("04/Jun/2020");
		indentItemsPage.clickOnNewRadioButton();
		//assertTrue(indentItemsPage.isNewIndentPopupDisplayed(), "New Indent Popup is not displayed");
		indentItemsPage.selectFirstIndentFromPopup();
		//driver.pauseExecutionFor(5000);

		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("BENIDIN 8 MG TAB");
		Thread.sleep(2000);
		indentItemsPage.enterQuantityForNewMedicines();
		indentItemsPage.enterRemarksForSelectedNewMedicines();
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.clickYesOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Indent modified successfully"), "Indent modified successfully message not displayed");

		frontOfficeHomePage.clickOnMenu();

		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Approval");
		indentApprovalPage.clickOnApproveButton();
		///assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Approve button without selecting any Indent");
		indentApprovalPage.clickOnRejectButton();
		///assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Reject button without selecting any Indent");
		indentApprovalPage.clickOnNewIndentRadioButton();
		String indentNoFromNewIndent = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z SYP 200ML", "20");
		indentApprovalPage.clickOnApproveButton();
		indentApprovalPage.clickOnYesButtonOnApprovalConfirmationPopup();
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		String indentNoFromApproveIndent = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		//Assert.assertEquals(indentNoFromNewIndent, indentNoFromApproveIndent, "Approved Indent is not showing up in Approved Indent List ");

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnHomeIcon();

		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("Central General Store");
		frontOfficeHomePage.clickOnIndentIssuesAndSelectAnOption("Indent Issue");
		indentIssuePage.clickOnPrintCumulativeIssueButton();
		//assertTrue(indentIssuePage.verifyActionMessage("There is no issued items"), "There is not Issued Items Message is not showing up after clicking print cumulative issue button without selecting ang indent");
		indentIssuePage.clickOnNewRadioButton();
		indentIssuePage.selectFirstIndentFromPopup();
		indentIssuePage.clickOnOrderedItemsMedicines("ACETEN TAB 12.5MG");
		//assertTrue(indentIssuePage.verifyActionMessage("No substute available for"), "No substute available for AB - FLO TAB Message is not showing up");

		indentItemsPage.selectMedicines("ANKLE SUPPORT LARGE");
		//indentIssuePage.selectSubtitutes("ALOXID CAP");
		//assertTrue(indentIssuePage.verifyActionMessage("Stock is zero for this item"), "After selecting ALOXID CAP, stock is zero message not showing up");
		//indentIssuePage.selectSubtitutes("ALPHADOL-0.25 CAPSULE");
		indentIssuePage.clickOnSaveFloppyIcon();		
		indentIssuePage.clickOnYesButtonOnSaveThisRecordPopup();
		//assertTrue(indentIssuePage.verifyIndentCreatedSuccessMessage("Data saved successfully"), "Data Saved Successfully message not showing up");
		indentIssuePage.clickOnYesButtonOnCreatedSuccessfullyPopup();
		indentIssuePage.clickOnClearButton();
		indentIssuePage.clickOnPendingRadioButton();
		//indentIssuePage.selectFirstIndentFromPopup();

	}


	@Test(priority =4) //pass and fixed 08-06-2020
	public void inventoryItemReceiptWithIndentOrderTest() throws Throwable {

		test=extent.createTest("inventoryIntendIssue1Test", "This test case verify the inventory Intend Issue1 Test");
		test.assignCategory("Inventory Module Test"); 

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Items");
		indentItemsPage.enterFromDateIntendItemsScreen("01/Jun/2020");
		indentItemsPage.clickOnIssuedRadioButton();
		///indentItemsPage.selectFirstIndentFromPopup();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Item Receipt");
		indentItemsPage.enterFromDateItemReceiptScreen("01/Jun/2020");
		indentItemsPage.clickOnNewReceiptRadioButton();
		indentItemsPage.selectFirstIndentFromItemReceiptPopup();
		indentItemsPage.clickOnSaveButtonOnDirectIssuePage();
		indentItemsPage.clickYesButtonOnSaveItemReceiptPage();
		//assertTrue(indentItemsPage.verifyActionMessage("Received"), "Received Message not Shown");
		//driver.pauseExecutionFor(8000);
		Thread.sleep(2000);
		indentItemsPage.clickClearButtonOnItemReceiptPage();
		indentItemsPage.clickOnReceivedReceiptRadioButton();
		indentItemsPage.selectFirstIndentFromItemReceiptPopup();
		Thread.sleep(2000);
		indentItemsPage.clickClearButtonOnItemReceiptPage();


	}


	@Test(priority = 5) //pass and fixed 08-06-2020
	public void inventoryPurchaseReqiuistion1Test() throws Throwable {

		test=extent.createTest("inventoryPurchaseReqiuistion1Test", "This test case verify the inventory Purchase Reqiuistion1 Test");
		test.assignCategory("Inventory Module Test"); 

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Items");
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please select atleast one Facility"), "Please select atleast one Facility error message not displayed");
		indentItemsPage.selectToFacilityFromDropdown("L1-SANITY-T3");
		indentItemsPage.clickOnSaveButton();
		///assertTrue(indentItemsPage.verifyActionMessage("Please select Department!"), "Please select Department! error message not displayed");
		Thread.sleep(2000);
		indentItemsPage.selectToDepartmentFromDropdown("Central General Store");
		indentItemsPage.selectSmartSearchCheckbox();
		indentItemsPage.clickOnRefreshStockLabel();
		///assertTrue(indentItemsPage.verifyActionMessage("Calculation for all item completed successfully!"), "Calculation for all item completed successfully! action message not displayed");
		indentItemsPage.clickOnSelectAllLabel();

		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("A TO Z SYP 200ML");
		Thread.sleep(2000);		
		indentItemsPage.selectMedicines("ACETEN TAB 12.5MG");
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("BACLOF10 MG TAB");
		//		driver.pauseExecutionFor(3000);
		//		indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		//		assertTrue(indentItemsPage.verifyActionMessage("AB PHYLLINE CAP already selected!"), "Duplicate Medicine message not displayed");
		///indentItemsPage.selectMedicines("AHAGLOW S SPRAY");
		//assertTrue(indentItemsPage.verifyActionMessage("This is Discontinued Item and Stock at other store"), "Discontinued Medicine Error message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicines("ANKLE SUPPORT SMALL");
		indentItemsPage.selectMedicines("ANKLE SUPPORT MEDIUM");
		indentItemsPage.selectMedicines("ANKLE SUPPORT LARGE");
		indentItemsPage.selectOthersTab();
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("PAPANICOLAU EA36-BIO");
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("GENERAL MEDICINE");
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("PIPETTE STAND ROUND BEST");
		Thread.sleep(2000);
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please enter quantity for following Items"), "Please enter quantity Error message not displayed");
		indentItemsPage.enterQuantityForSelectedMedicines();
		indentItemsPage.enterRemarksForSelectedMedicines();
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.isSavePopupShowing(), "Do you want to save popup not showing up");
		indentItemsPage.clickYesOnSaveButton();
		///assertTrue(indentItemsPage.verifyActionMessage("Saved Successfully,Print can be take"), "Saved Successfully message not displayed");
		indentItemsPage.clickOnNewRadioButton();
		//assertTrue(indentItemsPage.isNewIndentPopupDisplayed(), "New Indent Popup is not displayed");
		indentItemsPage.selectFirstIndentFromPopup();
		Thread.sleep(2000);
		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("BENIDIN 8 MG TAB");
		Thread.sleep(2000);
		indentItemsPage.enterQuantityForNewMedicines();
		///indentItemsPage.enterRemarksForSelectedNewMedicines();
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.clickYesOnSaveButton();
		///assertTrue(indentItemsPage.verifyActionMessage("Indent modified successfully"), "Indent modified successfully message not displayed");
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Approval");
		indentApprovalPage.clickOnApproveButton();
		///assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Approve button without selecting any Indent");
		indentApprovalPage.clickOnRejectButton();
		///assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Reject button without selecting any Indent");
		indentApprovalPage.clickOnNewIndentRadioButton();
		String indentNoFromNewIndent = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z SYP 200ML", "20");
		indentApprovalPage.clickOnApproveButton();
		indentApprovalPage.clickOnYesButtonOnApprovalConfirmationPopup();
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		String indentNoFromApproveIndent = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		///Assert.assertEquals(indentNoFromNewIndent, indentNoFromApproveIndent, "Approved Indent is not showing up in Approved Indent List ");

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnHomeIcon();

		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("2 nd floor nursing station");
		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Requisition");
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		///assertTrue(purchaseRequisitionPage.verifyActionMessage("Please select GRN station"), "Please select GRN station Message not showing up");
		purchaseRequisitionPage.clickOnAgainstIntendradioButton();
		//		purchaseRequisitionPage.checkSelectCheckboxForFirstIntend();
		//		purchaseRequisitionPage.deleteLastItemFromBlowGrid();
		//		purchaseRequisitionPage.changeQuantityForItemsInBlowGrid();
		//		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		///assertTrue(purchaseRequisitionPage.verifyActionMessage("Please select GRN station"), "Please select GRN station Message not showing up");
		//		purchaseRequisitionPage.selectFirstGRNStation();
		//		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		//		purchaseRequisitionPage.clickOnYesButtonOnSaveConfirmationPopup();
		//		///assertTrue(purchaseRequisitionPage.verifyPurchaseSavedSuccessMessage("Purchase requisition"), "Purchase requisition generated successfully message is not showing up");
		//		purchaseRequisitionPage.printyesbutton();

	}

	@Test(priority = 6) //pass and fixed 09-06-2020
	public void inventoryPurchaseReqiuistion2Test() throws Throwable {

		test=extent.createTest("inventoryPurchaseReqiuistion2Test", "This test case verify the inventory Purchase Reqiuistion2 Test");
		test.assignCategory("Inventory Module Test"); 

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("2 nd floor nursing station");
		//hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");
		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Requisition");
		purchaseRequisitionPage.selectInventory("Refresh Stock Level");
		assertTrue(purchaseRequisitionPage.verifyActionMessage("Calculation for all items completed successfully"), "Calculation for all items completed successfully! Message not showing up");
		//driver.pauseExecutionFor(3000);
		purchaseRequisitionPage.selectInventory("QOH <ROL");
		//driver.pauseExecutionFor(3000);
		purchaseRequisitionPage.selectInventory("QOH <ROL");
		//driver.pauseExecutionFor(3000);
		purchaseRequisitionPage.selectInventory("All Items");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("A TO Z SYP 200ML");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("A TO Z SYRUP (100ML)");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("ALASPAN 10MG TAB");
		purchaseRequisitionPage.selectTab("Medical Consumables");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("ABDOMINAL CORSET L");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("ABDOMINAL CORSET M");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("ABDOMINAL CORSET S");
		purchaseRequisitionPage.selectTab("General and Miscellaneous");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("PAPANICOLAU OG6-BIO");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("SIEMENS GLUC (REVISED)1440T");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("PAPANICOLAU EA36-BIO");
		//purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("PAMPERS PANTS 8PC LARGE");
		//assertTrue(purchaseRequisitionPage.verifyActionMessage("PAMPERS PANTS 8PC LARGE already selected"), "Duplicate Item is getting selected and error message is not getting thrown");	
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		///assertTrue(purchaseRequisitionPage.verifyActionMessage("Please select GRN station"), "Please select GRN station message is not getting displayed");	
		//		purchaseRequisitionPage.selectFirstGRNStation();
		//		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		//		///assertTrue(purchaseRequisitionPage.verifyActionMessage("Quantity is 0 for following Items"), "Quantity is 0 for following Items, message is not getting displayed");	
		//		purchaseRequisitionPage.enterQuantityForSelectedItems();
		//		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		//		purchaseRequisitionPage.clickOnYesButtonOnSaveConfirmationPopup();
		//		///assertTrue(purchaseRequisitionPage.verifyPurchaseSavedSuccessMessage("Purchase requisition"), "Purchase requisition generated successfully message is not showing up");
		//		purchaseRequisitionPage.clickNoButtonOnPrintAlertPopup();
		purchaseRequisitionPage.clickOnClearButton();
		purchaseRequisitionPage.clickOnSearchButtonOnPurchaseRequisitionList();
		///assertTrue(purchaseRequisitionPage.verifyPurchaseRequisitionPopupOpened(), "Purchase Requisition Popup is not getting opened");
		///purchaseRequisitionPage.selectFirstPurchaseRequisitionFromPurchaseRequisitionPopup();
		purchaseRequisitionPage.selectTab("Drugs");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("4 QUIN EYE DROPS(5ML)");
		purchaseRequisitionPage.enterQuantityForSelectedItems();
		purchaseRequisitionPage.clickOnModifyButton();
		purchaseRequisitionPage.clickOnYesButtonOnModifyAlertPopup();
		//assertTrue(purchaseRequisitionPage.verifyPurchaseReqModifiedSuccessPopup(), "Purchase Req Modified Success Popup is not showing up");


	}

	@Test(priority = 7) //pass and fixed loading issue
	public void inventoryDirectIssueTest() throws Throwable 
	{
		test=extent.createTest("inventoryDirectIssueTest", "This test case verify the inventory Direct Issue Test");
		test.assignCategory("Inventory Module Test"); 

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("2 nd floor nursing station");
		frontOfficeHomePage.clickOnIndentIssuesAndSelectAnOption("Direct Issue");
		indentItemsPage.clickOnSaveButtonOnDirectIssuePage();
		//assertTrue(indentItemsPage.verifyActionMessage("Please select facility"), "Please select atleast one Facility error message not displayed");
		indentItemsPage.selectToFacilityFromDropdownDirectIssuePage("L1-SANITY-T3");
		indentItemsPage.clickOnSaveButtonOnDirectIssuePage();
		///assertTrue(indentItemsPage.verifyActionMessage("Please select store!"), "Please select store! error message not displayed");
		Thread.sleep(2000);	
		indentItemsPage.selectStoreFromDropdownDirectIssuePage("CATH LAB ");
		indentItemsPage.selectSmartSearchCheckboxDirectIssuePage();
		indentItemsPage.selectQOHTabDirectIssuePage();
		indentItemsPage.selectAllItemsTabDirectIssuePage();
		indentItemsPage.clickOnSaveButtonOnDirectIssuePage();
		//assertTrue(indentItemsPage.verifyActionMessage("Please select an item!"), "Please select an item! error message not displayed");
		indentItemsPage.selectItemsDirectIssuePage("ALPHADOL 0.5MCG CAP");
		indentItemsPage.clickOnClearButtonOnDirectIssuePage();
		indentItemsPage.selectSubstitudeDirectIssuePage("ALPHADOL 0.5MCG CAP");
		indentItemsPage.selectFirstBatchNoFromBatchDetailsDirectIssuePage();
		//indentItemsPage.selectFirstBatchNoFromBatchDetailsDirectIssuePage();
		//assertTrue(indentItemsPage.verifyActionMessage("Item already exists!"), "Item already exists! error message not displayed");
		//frontOfficeHomePage.selectGRNDrugItem("Consumables", "DEN -3 PIN ARTICULATOR");
		//indentItemsPage.selectItemsDirectIssuePage("DEN -3 PIN ARTICULATOR");
		///indentItemsPage.selectBatchNoFromBatchDetailsDirectIssuePage("3SS523");
		//assertTrue(indentItemsPage.verifyActionMessage("Item already exists!"), "Item already exists! error message not displayed");
		indentItemsPage.selectOthersTabDirectIssuePage();
		indentItemsPage.selectItemsDirectIssuePage("PAPANICOLAU EA36-BIO");
		///indentItemsPage.selectBatchNoFromBatchDetailsDirectIssuePage("1111");
		//assertTrue(indentItemsPage.verifyActionMessage("Item already exists!"), "Item already exists! error message not displayed");
//		indentItemsPage.selectThirdSerialNumberDirectIssuePage();
//		indentItemsPage.clickNoButtonOnDeletePopupDirectIssuePage();
//		indentItemsPage.selectThirdSerialNumberDirectIssuePage();
//		indentItemsPage.clickYesButtonOnDeletePopupDirectIssuePage();
//		indentItemsPage.clickOnSaveButtonOnDirectIssuePage();
//		///assertTrue(indentItemsPage.verifyActionMessage("Issue Quantity cannot be blank!"), "Issue Quantity cannot be blank! error message not displayed");
//		indentItemsPage.enterIssueQuantityDirectIssuePage("3 PANEL CELL", "10");
//		indentItemsPage.enterIssueQuantityDirectIssuePage("ABDOMINAL BINDER- LARGE", "10");
//		indentItemsPage.clickOnSaveButtonOnDirectIssuePage();
//		indentItemsPage.clickNoButtonOnSavePopupDirectIssuePage();
//		indentItemsPage.clickOnSaveButtonOnDirectIssuePage();
//		indentItemsPage.clickYesButtonOnSavePopupDirectIssuePage();
//		assertTrue(indentItemsPage.verifyActionMessage("saved successfully"), "Direct Issue is not saved");
//		indentItemsPage.clickNoButtonOnPrintPopupDirectIssuePage();
//		indentItemsPage.clickClearButtonOnheaderDirectIssuePage();
//		indentItemsPage.enterFromDateDirectIssuePage("01/Jun/2019");
//		indentItemsPage.enterToDateDirectIssuePage("07/Jun/2019");
//		indentItemsPage.selectIssuedToFromDropdownDirectIssuePage("CATH LAB ");
//		indentItemsPage.clickSearchButtonDirectIssuePage();
//		indentItemsPage.clickOnFirstOrderFromSearchDirectIssuePage();

	}

	@Test(priority = 8) //pass and fixed 17-04-2020
	public void inventoryDirectReceiptTest() throws Throwable {

		test=extent.createTest("inventoryDirectReceiptTest", "This test case verify the inventory Direct Receipt Test");
		test.assignCategory("Inventory Module Test");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");		
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Direct Receipt");

		indentItemsPage.searchAndSelectItemsDirectReceiptPage("A TO Z SYP 200ML");
		indentItemsPage.searchAndSelectItemsDirectReceiptPage("ACETEN TAB 12.5MG");
		indentItemsPage.searchAndSelectItemsDirectReceiptPage("BACLOF10 MG TAB");
		indentItemsPage.selectConsumablesTabDirectReceiptPage();
		indentItemsPage.searchAndSelectItemsDirectReceiptPage("ANKLE SUPPORT SMALL");
		indentItemsPage.searchAndSelectItemsDirectReceiptPage("ANKLE SUPPORT MEDIUM");
		indentItemsPage.selectOthersTabDirectReceiptPage();
		indentItemsPage.searchAndSelectItemsDirectReceiptPage("PAPANICOLAU EA36-BIO");
		indentItemsPage.clickDeleteButtonAgainstAnItem("ACETEN TAB 12.5MG");
		indentItemsPage.clickNoButtonOnDeletePopupDirectReceiptPage();
		indentItemsPage.clickDeleteButtonAgainstAnItem("ACETEN TAB 12.5MG");
		indentItemsPage.clickYesButtonOnDeletePopupDirectReceiptPage();
		indentItemsPage.clickCalculateButtonOnHeaderDirectReceiptPage();
		//assertTrue(indentItemsPage.verifyActionMessage("Please enter receipt quantity"), "Please enter receipt quantity message not showing up");
		indentItemsPage.enterQuantityAgainstAnItem("A TO Z SYP 200ML", "10");
		indentItemsPage.enterQuantityAgainstAnItem("BACLOF10 MG TAB", "10");
		indentItemsPage.enterQuantityAgainstAnItem("ANKLE SUPPORT SMALL", "10");
		indentItemsPage.enterQuantityAgainstAnItem("ANKLE SUPPORT MEDIUM", "10");
		indentItemsPage.enterQuantityAgainstAnItem("PAPANICOLAU EA36-BIO", "10");
		
		indentItemsPage.removePurRateAgainstAnItem("A TO Z SYP 200ML");
		indentItemsPage.removePurRateAgainstAnItem("BACLOF10 MG TAB");
		indentItemsPage.removePurRateAgainstAnItem("ANKLE SUPPORT SMALL");
		indentItemsPage.removePurRateAgainstAnItem("ANKLE SUPPORT MEDIUM");
		indentItemsPage.removePurRateAgainstAnItem("PAPANICOLAU EA36-BIO");
		indentItemsPage.clickCalculateButtonOnHeaderDirectReceiptPage();
		//assertTrue(indentItemsPage.verifyActionMessage("Please select batch number for following Items"), "Please select batch number for following Items message not showing up");
		indentItemsPage.enterPurRateAgainstAnItem("A TO Z SYP 200ML", "25");
		indentItemsPage.enterPurRateAgainstAnItem("BACLOF10 MG TAB", "30");
		indentItemsPage.enterPurRateAgainstAnItem("ANKLE SUPPORT SMALL", "35");
		indentItemsPage.enterPurRateAgainstAnItem("ANKLE SUPPORT MEDIUM", "40");
		indentItemsPage.enterPurRateAgainstAnItem("PAPANICOLAU EA36-BIO", "45");
		
		//remove MPR
		indentItemsPage.removeMRPAgainstAnItem("A TO Z SYP 200ML");
		indentItemsPage.removeMRPAgainstAnItem("BACLOF10 MG TAB");
		indentItemsPage.removeMRPAgainstAnItem("PAPANICOLAU EA36-BIO");
		
		//Enter MPR
		indentItemsPage.enterMRPAgainstAnItem("A TO Z SYP 200ML", "15");
		indentItemsPage.enterMRPAgainstAnItem("BACLOF10 MG TAB", "55");
		indentItemsPage.enterMRPAgainstAnItem("PAPANICOLAU EA36-BIO", "60");
		////////////////////////////////////////////////////////////////////////////////
		indentItemsPage.enterBatchTextBoxAgainstAnItemAndClosePopup("A TO Z SYP 200ML", "0030415");
		indentItemsPage.enterBatchTextBoxAgainstAnItemAndClosePopup("BACLOF10 MG TAB", "KW0986");
		indentItemsPage.enterBatchTextBoxAgainstAnItemAndClosePopup("PAPANICOLAU EA36-BIO", "7619T");
//		indentItemsPage.enterBatchTextBoxAgainstAnItemAndClosePopup("SP DRUG 5 %", "0030415");
//		indentItemsPage.enterBatchTextBoxAgainstAnItemAndClosePopup("3 PANEL CELL", "Batch-Test4");
//		indentItemsPage.enterBatchTextBoxAgainstAnItemAndClosePopup("GLUCON D ORANGE 100GM", "Batch-Test5");
		indentItemsPage.clickCalculateButtonOnHeaderDirectReceiptPage();
		//assertTrue(indentItemsPage.verifyActionMessage("Expiry date is earlier than current date"), "Expiry date is earlier than current date message not showing up");
		indentItemsPage.enterExpiryDateAgainstAnItem("A TO Z SYP 200ML", "01/Jan/2030");
		indentItemsPage.enterExpiryDateAgainstAnItem("BACLOF10 MG TAB", "01/Jan/2030");
		indentItemsPage.enterExpiryDateAgainstAnItem("PAPANICOLAU EA36-BIO", "01/Jan/2030");
//		indentItemsPage.enterExpiryDateAgainstAnItem("3 PANEL CELL", "01/Jan/2030");
//		indentItemsPage.enterExpiryDateAgainstAnItem("GLUCON D ORANGE 100GM", "01/Jan/2030");
		indentItemsPage.clickCalculateButtonOnHeaderDirectReceiptPage();
		///assertTrue(indentItemsPage.verifyActionMessage("MRP is less then Purchase rate"), "MRP is less then Purchase rate message not showing up");
		indentItemsPage.enterMRPAgainstAnItem("A TO Z SYP 200ML", "50");
		indentItemsPage.enterMRPAgainstAnItem("BACLOF10 MG TAB", "100");
		indentItemsPage.enterMRPAgainstAnItem("PAPANICOLAU EA36-BIO", "101");
		
		indentItemsPage.clickCalculateButtonOnHeaderDirectReceiptPage();
		//assertTrue(indentItemsPage.verifyActionMessage("Please enter MRP For "), "Please enter MRP For  message not showing up");
		
		indentItemsPage.enterMRPForSPMarkUpAgainstAnItem("A TO Z SYP 200ML", "200");
		indentItemsPage.enterMRPForSPMarkUpAgainstAnItem("BACLOF10 MG TAB", "10000");
		//indentItemsPage.enterMRPForSPMarkUpAgainstAnItem("PAPANICOLAU EA36-BIO", "5000");

		indentItemsPage.enterSGSTAgainstAnItem("A TO Z SYP 200ML", "2.5");
		indentItemsPage.enterCGSTAgainstAnItem("A TO Z SYP 200ML", "2.5");
		indentItemsPage.enterIGSTAgainstAnItem("A TO Z SYP 200ML", "5");
		indentItemsPage.clickCalculateButtonOnHeaderDirectReceiptPage();
		//assertTrue(indentItemsPage.verifyActionMessage("Tax value for SGST"), "Tax value for SGST message not showing up");
		indentItemsPage.removeSGSTAgainstAnItem("A TO Z SYP 200ML");
		indentItemsPage.removeSGSTAgainstAnItem("BACLOF10 MG TAB");
		indentItemsPage.removeSGSTAgainstAnItem("PAPANICOLAU EA36-BIO");
//		indentItemsPage.removeSGSTAgainstAnItem("3 PANEL CELL");
//		indentItemsPage.removeSGSTAgainstAnItem("GLUCON D ORANGE 100GM");

		indentItemsPage.removeCGSTAgainstAnItem("A TO Z SYP 200ML");
		indentItemsPage.removeCGSTAgainstAnItem("BACLOF10 MG TAB");
		indentItemsPage.removeCGSTAgainstAnItem("PAPANICOLAU EA36-BIO");
//		indentItemsPage.removeCGSTAgainstAnItem("3 PANEL CELL");
//		indentItemsPage.removeCGSTAgainstAnItem("GLUCON D ORANGE 100GM");

		indentItemsPage.removeIGSTAgainstAnItem("A TO Z SYP 200ML");
		indentItemsPage.removeIGSTAgainstAnItem("BACLOF10 MG TAB");
		indentItemsPage.removeIGSTAgainstAnItem("PAPANICOLAU EA36-BIO");

		indentItemsPage.enterIGSTAgainstAnItem("A TO Z SYP 200ML", "0");
		indentItemsPage.enterIGSTAgainstAnItem("BACLOF10 MG TAB", "0");
		indentItemsPage.enterIGSTAgainstAnItem("PAPANICOLAU EA36-BIO", "0");

		indentItemsPage.clickCalculateButtonOnHeaderDirectReceiptPage();
		indentItemsPage.clickSaveButtonOnHeaderDirectReceiptPage();
		indentItemsPage.clickNoButtonOnSavePopupDirectReceiptPage();
		indentItemsPage.clickSaveButtonOnHeaderDirectReceiptPage();
		indentItemsPage.clickYesButtonOnSavePopupDirectReceiptPage();
		indentItemsPage.clickNoButtonOnPrintPopupDirectReceiptPage();		
	}

	@Test(enabled = false) //not fixed 
	public void purchaseRequisitionApprovalTest() throws Throwable {
		test=extent.createTest("purchaseRequisitionApprovalTest", "This test case verify the purchase Requisition Approval Test");
		test.assignCategory("Inventory Module Test");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("2 nd floor nursing station");
		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Requisition Approval");
		purchaseRequisitionPage.enterFromDatePurchaseRequisitionApprovalPage("28-Mar-2019");
		purchaseRequisitionPage.enterToDatePurchaseRequisitionApprovalPage("16-Jan-2020");
		purchaseRequisitionPage.selectCheckboxPurchaseRequisitionApprovalPage("New Requisitions");
		//assertTrue(purchaseRequisitionPage.verifyResultsPopupIsDispalyed("NEW REQUISITION(S)"), "NEW REQUISITION(S) popup is not showing up");
		purchaseRequisitionPage.selectFirstValueFromResults();
		purchaseRequisitionPage.clickEditBtnPurchaseRequisitionApprovalPage();		
//		purchaseRequisitionPage.enterQuantityAgainstAnItem("A TO Z NS SYP 200 ML", "30");
////		purchaseRequisitionPage.enterQuantityAgainstAnItem("AB - FLO TAB", "30");
////		purchaseRequisitionPage.enterQuantityAgainstAnItem("AB PHYLLINE CAP", "30");
//		purchaseRequisitionPage.enterQuantityAgainstAnItem("ABDOMINAL BINDER- LARGE", "30");
//		purchaseRequisitionPage.enterQuantityAgainstAnItem("ABDOMINAL BINDER- MEDIUM", "30");
//		purchaseRequisitionPage.enterQuantityAgainstAnItem("ABDOMINAL BINDER- SMALL", "40");
//		purchaseRequisitionPage.enterQuantityAgainstAnItem("PAMPERS (SMALL)", "40");
//		purchaseRequisitionPage.enterQuantityAgainstAnItem("GLUCON D ORANGE 100GM", "40");		
//		purchaseRequisitionPage.clickAcceptBtnPurchaseRequisitionApprovalPage();
//		assertTrue(purchaseRequisitionPage.verifyApprovalPopupIsDisplayed(), "Approval Popup Is Not Displayed");
//		purchaseRequisitionPage.clickNoButtonOnApprovePopup();
//		purchaseRequisitionPage.clickAcceptBtnPurchaseRequisitionApprovalPage();
//		assertTrue(purchaseRequisitionPage.verifyApprovalPopupIsDisplayed(), "Approval Popup Is Not Displayed");
//		purchaseRequisitionPage.clickYesButtonOnApprovePopup();
//		assertTrue(indentItemsPage.verifyActionMessage("Requisition approved!"), "Requisition approved! message not showing up");
//		driver.pauseExecutionFor(10000);		
//		frontOfficeHomePage.expandMenu();
//		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Requisition Approval");
//		purchaseRequisitionPage.enterFromDatePurchaseRequisitionApprovalPage("28-Mar-2019");
//		purchaseRequisitionPage.enterToDatePurchaseRequisitionApprovalPage("16-Jan-2020");
//		purchaseRequisitionPage.selectCheckboxPurchaseRequisitionApprovalPage("Approved Requisitions");
//		assertTrue(purchaseRequisitionPage.verifyResultsPopupIsDispalyed("APPROVED REQUISITION(S)"), "APPROVED REQUISITION(S) popup is not showing up");
//		purchaseRequisitionPage.selectFirstValueFromResults();		
//		purchaseRequisitionPage.enterFromDatePurchaseRequisitionApprovalPage("28-Mar-2019");
//		purchaseRequisitionPage.enterToDatePurchaseRequisitionApprovalPage("16-Jan-2020");
//		purchaseRequisitionPage.selectCheckboxPurchaseRequisitionApprovalPage("New Requisitions");
//		assertTrue(purchaseRequisitionPage.verifyResultsPopupIsDispalyed("NEW REQUISITION(S)"), "NEW REQUISITION(S) popup is not showing up");
//		purchaseRequisitionPage.selectFirstValueFromResults();
//		purchaseRequisitionPage.clickRejectBtnPurchaseRequisitionApprovalPage();
//		assertTrue(indentItemsPage.verifyActionMessage("Please enter reason for rejection!"), "Please enter reason for rejection! message not showing up");
//		purchaseRequisitionPage.clickEditBtnPurchaseRequisitionApprovalPage();
//		purchaseRequisitionPage.enterRemarksPurchaseRequisitionApprovalPage();
//		purchaseRequisitionPage.clickRejectBtnPurchaseRequisitionApprovalPage();		
//		assertTrue(purchaseRequisitionPage.verifyRejectionPopupIsDisplayed(), "Rejection Popup Is Not Displayed");
//		purchaseRequisitionPage.clickNoButtonOnRejectPopup();
//		purchaseRequisitionPage.clickRejectBtnPurchaseRequisitionApprovalPage();
//		purchaseRequisitionPage.clickYesButtonOnRejectPopup();
//		assertTrue(indentItemsPage.verifyActionMessage("Requistion has been rejected"), "Requistion has been rejected. message not showing up");
//		frontOfficeHomePage.expandMenu();
//		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Requisition Approval");
//		purchaseRequisitionPage.enterFromDatePurchaseRequisitionApprovalPage("28-Mar-2019");
//		purchaseRequisitionPage.enterToDatePurchaseRequisitionApprovalPage("16-Jan-2020");
//		purchaseRequisitionPage.selectCheckboxPurchaseRequisitionApprovalPage("Rejected Requistions");
//		assertTrue(purchaseRequisitionPage.verifyResultsPopupIsDispalyed("REJECTED REQUISITION(S)"), "REJECTED REQUISITION(S) popup is not showing up");
//		purchaseRequisitionPage.selectFirstValueFromResults();
	}

	@Test(priority = 9) //pass and fixed 09-06-2020
	public void inventoryIndentIssueWithManualModeTest() throws Throwable 
	{
		test=extent.createTest("inventoryIndentIssueWithManualModeTest", "This test case verify the inventory Indent Issue With Manual Mode Test");
		test.assignCategory("Inventory Module Test");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);


		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Items");
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please select atleast one Facility"), "Please select atleast one Facility error message not displayed");
		indentItemsPage.selectToFacilityFromDropdown("L1-SANITY-T3");
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please select Department!"), "Please select Department! error message not displayed");
		Thread.sleep(2000);
		indentItemsPage.selectToDepartmentFromDropdown("Central General Store");
		indentItemsPage.selectSmartSearchCheckbox();
		indentItemsPage.clickOnRefreshStockLabel();
		///assertTrue(indentItemsPage.verifyActionMessage("Calculation for all item completed successfully!"), "Calculation for all item completed successfully! action message not displayed");
		Thread.sleep(2000);
		purchaseRequisitionPage.selectInventory("QOH<ROL");
		Thread.sleep(2000);
		purchaseRequisitionPage.selectInventory("QOH>ROL");
		//driver.pauseExecutionFor(6000);
		purchaseRequisitionPage.selectInventory("ALL ITEMS");

		indentItemsPage.selectMedicines("A TO Z SYP 200ML");
		Thread.sleep(2000);		
		indentItemsPage.selectMedicines("ACETEN TAB 12.5MG");
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("BACLOF10 MG TAB");
		///assertTrue(indentItemsPage.verifyActionMessage("already selected"), "already selected Item action message not displayed");
		//		indentItemsPage.selectConsumablesTab();
		//		indentItemsPage.selectMedicineTab();
		//
		//		indentItemsPage.selectMedicines("AHAGLOW S SPRAY");
		//		assertTrue(indentItemsPage.verifyActionMessage("This is Discontinued Item and Stock at other store"), "Discontinued Medicine Error message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicines("ANKLE SUPPORT SMALL");
		indentItemsPage.selectMedicines("ANKLE SUPPORT MEDIUM");
		indentItemsPage.selectMedicines("ANKLE SUPPORT LARGE");
		///assertTrue(indentItemsPage.verifyActionMessage("already selected"), "already selected Item action message not displayed");
		purchaseRequisitionPage.selectTab("Others");
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("PAPANICOLAU EA36-BIO");
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("GENERAL MEDICINE");
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("PIPETTE STAND ROUND BEST");
		Thread.sleep(2000);
		indentItemsPage.clickOnSaveButton();
		///assertTrue(indentItemsPage.verifyActionMessage("Please enter quantity for following Items"), "Please enter quantity for following Items message is not getting displayed");	
		purchaseRequisitionPage.deleteSelectedItemFromBlowGrid("PIPETTE STAND ROU");

		indentItemsPage.enterQuantityForSelectedMedicines();
		indentItemsPage.enterRemarksForSelectedMedicines();
		indentItemsPage.clickOnSaveButton();
		///assertTrue(indentItemsPage.isSavePopupShowing(), "Do you want to save popup not showing up");
		indentItemsPage.clickYesOnSaveButton();
		indentItemsPage.enterFromDateIntendItemsScreen("04/Jan/2020");
		//		indentItemsPage.enterToDateIntendItemsScreen("11/Jan/2020");
		indentItemsPage.clickOnNewRadioButton();
		//assertTrue(indentItemsPage.isNewIndentPopupDisplayed(), "New Indent Popup is not displayed");
		indentItemsPage.selectFirstIndentFromPopup();
		Thread.sleep(2000);
		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("A TO Z SYP 200ML");
		Thread.sleep(2000);
		indentItemsPage.enterQuantityForNewMedicines();
		indentItemsPage.enterRemarksForSelectedNewMedicines();
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.clickYesOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Indent modified successfully"), "Indent modified successfully message not displayed");

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Approval");
		indentApprovalPage.clickOnApproveButton();
		//assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Approve button without selecting any Indent");
		indentApprovalPage.clickOnRejectButton();
		//assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Reject button without selecting any Indent");
		indentApprovalPage.clickOnRefreshButton();
		indentApprovalPage.enterFromDate("01/Mar/2019");		
		indentApprovalPage.clickOnNewIndentRadioButton();
		try {
			String indentNoFromNewIndent = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		}
		catch (Exception e) {
		}
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z SYP 200ML", "20");
		indentApprovalPage.clickOnApproveButton();
		indentApprovalPage.clickOnYesButtonOnApprovalConfirmationPopup();
		Thread.sleep(2000);
		indentApprovalPage.enterFromDate("01/Mar/2019");		
		indentApprovalPage.clickOnNewIndentRadioButton();
		try {
			String indentNoFromNewIndent1 = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		}
		catch (Exception e) {

		}
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z SYP 200ML", "30");
		indentApprovalPage.clickOnRejectButton();
		indentApprovalPage.clickOnYesButtonOnRejectionConfirmationPopup();
		Thread.sleep(2000);
		indentApprovalPage.enterFromDate("04/Jun/2020");
		indentApprovalPage.selectStore("Crash Cart  T1-CTVS");
		indentApprovalPage.clickOnNewIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.selectStore("Crash Cart  T1-CTVS");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.selectStore("Crash Cart  T1-CTVS");
		indentApprovalPage.clickOnRejectedIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.enterFromDate("25/Jun/2020");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		try {
			String indentNoFromApproveIndent = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		}
		catch (Exception e) {}
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");
		indentApprovalPage.enterFromDate("15/Jun/2020");
		indentApprovalPage.clickOnRejectedIndentRadioButton();
		//indentApprovalPage.selectFirstIndentFromRejectedIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");

		indentApprovalPage.enterFromDate("15/Jun/2020");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		try {
			String indentNoFromApproveIndent2 = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");
		indentApprovalPage.enterFromDate("25/Jun/2020");
		indentApprovalPage.clickOnRejectedIndentRadioButton();
		//indentApprovalPage.selectFirstIndentFromRejectedIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnHomeIcon();

		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("2 nd floor nursing station");
		frontOfficeHomePage.clickOnIndentIssuesAndSelectAnOption("Indent Issue");
		//		try {
		//		indentIssuePage.clickOnPrintCumulativeIssueButton();//////////////////////////////////////null pointer Exception
		//		}
		//		catch (Exception e) {}
		//		//assertTrue(indentIssuePage.verifyActionMessage("There is no issued items"), "There is not Issued Items Message is not showing up after clicking print cumulative issue button without selecting ang indent");
		//		indentIssuePage.enterFromDate("01/Mar/2019");
		//		indentIssuePage.clickOnManualModeRadioButton();
		//
		//		indentIssuePage.clickOnNewRadioButton();
		//		indentIssuePage.selectFirstIndentFromPopup();
		//		indentIssuePage.clickOnOrderedItemsMedicines("A TO Z NS SYP 200 ML");
		//		indentIssuePage.clickOnOrderedItemsMedicines("AB PHYLLINE CAP");
		//		indentIssuePage.clickOnOrderedItemsMedicines("AB - FLO TAB");
		//		assertTrue(indentIssuePage.verifyActionMessage("No substute available for"), "No substute available for AB - FLO TAB Message is not showing up");
		//
		//		indentIssuePage.clickOnOrderedItemsMedicines("ABDOMINAL BINDER- LARGE");
		//		indentIssuePage.selectSubtitutes("ALOXID CAP");
		//		assertTrue(indentIssuePage.verifyActionMessage("Stock is zero for this item"), "After selecting ALOXID CAP, stock is zero message not showing up");
		//		indentIssuePage.selectSubtitutes("ALPHADOL-0.25 CAPSULE");
		//		indentIssuePage.clickOnSaveFloppyIcon();
		//		indentIssuePage.clickOnYesButtonOnSaveThisRecordPopup();
		//		assertTrue(indentIssuePage.verifyIndentCreatedSuccessMessage("Data saved successfully"), "Data Saved Successfully message not showing up");
		//		indentIssuePage.clickOnNoButtonOnCreatedSuccessfullyPopup();
		//
		//		//Need to update steps from this line	
		//
		//		indentIssuePage.clickOnOrderedItemsMedicines("AB - FLO TAB");
		//		assertTrue(indentIssuePage.verifyActionMessage("No substute available for"), "No substute available for AB - FLO TAB Message is not showing up");
		//
		//		indentIssuePage.clickOnOrderedItemsMedicines("ABDOMINAL BINDER- LARGE");
		//		indentIssuePage.selectSubtitutes("ALOXID CAP");
		//		assertTrue(indentIssuePage.verifyActionMessage("Stock is zero for this item"), "After selecting ALOXID CAP, stock is zero message not showing up");
		//		indentIssuePage.selectSubtitutes("ALPHADOL-0.25 CAPSULE");
		//		indentIssuePage.clickOnSaveFloppyIcon();		
		//		indentIssuePage.clickOnYesButtonOnSaveThisRecordPopup();
		//		assertTrue(indentIssuePage.verifyIndentCreatedSuccessMessage("Data saved successfully"), "Data Saved Successfully message not showing up");
		//		indentIssuePage.clickOnYesButtonOnCreatedSuccessfullyPopup();
		//		indentIssuePage.clickOnClearButton();
		//		indentIssuePage.clickOnPendingRadioButton();
		//		indentIssuePage.selectFirstIndentFromPopup();
	}

	@Test(priority = 10) //pass and fixed 09-06-2020
	public void purchaseOrderWithoutPRWithFreeItemsTest() throws Throwable {
		test=extent.createTest("purchaseOrderWithoutPRWithFreeItemsTest", "This test case verify the purchase Order Without PR With Free Items Test");
		test.assignCategory("Inventory Module Test");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("2 nd floor nursing station");
		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Order");
		purchaseRequisitionPage.clickSaveButtonOnPurchaseOrderPage();
		//assertTrue(indentItemsPage.verifyActionMessage("PO terms not defined"), "PO terms not defined message not displayed");
		purchaseRequisitionPage.clickCalculateButtonOnPurchaseOrderPage();
		///assertTrue(indentItemsPage.verifyActionMessage("Item not found"), "Item not found! message not displayed");
		purchaseRequisitionPage.selectSuppliersFromPurchaseOrderPage("ABC MEDICAL");
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("0% ASPIRIN ,ASPIRIN");
		//purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("Amiodarone HCl Tab 200 MG");
		//purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("AB - FLO TAB");
		//assertTrue(indentItemsPage.verifyActionMessage("Scheme exists"), "Scheme exists for the following items message not displayed");
		purchaseRequisitionPage.clickSchemeButtonOnPurchaseOrderPage();
		///assertTrue(indentItemsPage.verifyActionMessage("Scheme exists for the following items"), "Scheme exists for the following items message not displayed");
		purchaseRequisitionPage.clickConsumablesTabOnPurchaseOrderPage();
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("ENDOBUTTON CL ULTRA 10MM");
		//		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("ENDOBUTTON CL ULTRA 15MM");
		//		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("ENDOBUTTON CL ULTRA 20MM");
		purchaseRequisitionPage.clickOtherTabOnPurchaseOrderPage();
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("DRUG GM");
		//		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("GLUCON D ORANGE 100GM");
		//		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("SAT-ISABGOL 100GM POWDER");
		//		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("SAT-ISABGOL 100GM POWDER");
		//assertTrue(indentItemsPage.verifyActionMessage("ISABGOL"), "already selected message not displayed");
		purchaseRequisitionPage.clickOnItemCode("CA0019");
		//assertTrue(purchaseRequisitionPage.isDeletePopupDisplayedOnPurchaseOrderPage(), "Delete Popup is not displayed");
		purchaseRequisitionPage.clickNoOnDeletePopupOnPurchaseOrderPage();
		purchaseRequisitionPage.clickOnItemCode("CA0019");
		//assertTrue(purchaseRequisitionPage.isDeletePopupDisplayedOnPurchaseOrderPage(), "Delete Popup is not displayed");
		purchaseRequisitionPage.clickYesOnDeletePopupOnPurchaseOrderPage();
		purchaseRequisitionPage.clickSaveButtonOnPurchaseOrderPage();
		///assertTrue(indentItemsPage.verifyActionMessage("for following Item"), "for following Item message not displayed");
		///assertTrue(purchaseRequisitionPage.isSavePopupDisplayedOnPurchaseOrderPage(), "Save Popup is not displayed");
		Thread.sleep(2000);
		purchaseRequisitionPage.clickNoOnSavePopupOnPurchaseOrderPage();
		purchaseRequisitionPage.clickCalculateButtonOnPurchaseOrderPage();
		//assertTrue(indentItemsPage.verifyActionMessage("for following Item"), "QUantity is zero for following Item message not displayed");
		//purchaseRequisitionPage.clickFreeButtonAgainstItem("Amiodarone HCl Tab 200 MG");
		//assertTrue(purchaseRequisitionPage.isFreeItemsPopupDisplayedOnPurchaseOrderPage(), "Free Items Popup not displayed");
		//purchaseRequisitionPage.closeFreeItemsPopup();
		purchaseRequisitionPage.clickFreeButtonAgainstItem("0% ASPIRIN ,ASPIRIN");
		///assertTrue(purchaseRequisitionPage.isFreeItemsPopupDisplayedOnPurchaseOrderPage(), "Free Items Popup not displayed");
		purchaseRequisitionPage.clickSameItemRadioButton();
		purchaseRequisitionPage.clickPurchaseDetailsTab();
		purchaseRequisitionPage.clickFreeButtonAgainstItem("0% ASPIRIN ,ASPIRIN");
		purchaseRequisitionPage.clickDifferentItemRadioButton();
		purchaseRequisitionPage.clickMedicineTabOnPurchaseOrderPage();
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("0.45% DNS 500ML BAXTER");
		purchaseRequisitionPage.clickCalculateButtonOnPurchaseOrderPage();
		///assertTrue(indentItemsPage.verifyActionMessage("for following Item"), "Please enter Quantity for following Item message not displayed");
		purchaseRequisitionPage.enterFreeQuantityForSelectedMedicinesOnPurchaseOrderPage();
		purchaseRequisitionPage.clickPurchaseDetailsTab();
		purchaseRequisitionPage.enterQuantityForSelectedMedicinesOnPurchaseDetailsTabS();
		purchaseRequisitionPage.enterRPUForSelectedMedicinesOnPurchaseDetailsTabS();
		purchaseRequisitionPage.clickCalculateButtonOnPurchaseOrderPage();
		purchaseRequisitionPage.clickSaveButtonOnPurchaseOrderPage();
		Thread.sleep(2000);
		purchaseRequisitionPage.clickYesOnSavePopupOnPurchaseOrderPage();
		Thread.sleep(2000);
		///assertTrue(purchaseRequisitionPage.isPrintPopupDisplayedOnPurchaseOrderPage(), "Print popup is not displayed");
		purchaseRequisitionPage.clickNoButtonPrintPopupOnPurchaseOrderPage();
		purchaseRequisitionPage.clickNoButtonOnPlaceMoreOrderPopupOnPurchaseOrderPage();
		purchaseRequisitionPage.clickPendingForApprovalRadioButton();
		//purchaseRequisitionPage.selectFirstPurchaseOrderFromPurchaseOrderPopup();
		purchaseRequisitionPage.checkSmartCheckbox();
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("0.45% DNS 500ML BAXTER");
		//		purchaseRequisitionPage.enterQuantityForSelectedMedicinesOnPurchaseDetailsTabS("0.45% DNS 500ML BAXTER");
		//		purchaseRequisitionPage.enterRPUForSelectedMedicinesOnPurchaseDetailsTabS("0.45% DNS 500ML BAXTER");
		//		purchaseRequisitionPage.clickSaveButtonOnPurchaseOrderPage();
		//		//assertTrue(purchaseRequisitionPage.isApprovalProcessPopupDisplayedOnPurchaseOrderPage(), "Approval Process Popup is not displayed");
		//		purchaseRequisitionPage.clickNoButtonApprovalProcessPopupOnPurchaseOrderPage();
		//		purchaseRequisitionPage.clickSaveButtonOnPurchaseOrderPage();
		//		//assertTrue(purchaseRequisitionPage.isApprovalProcessPopupDisplayedOnPurchaseOrderPage(), "Approval Process Popup is not displayed");
		//		purchaseRequisitionPage.clickYesButtonApprovalProcessPopupOnPurchaseOrderPage();
		//		//assertTrue(purchaseRequisitionPage.isSavePopupDisplayedOnPurchaseOrderPage(), "Save Popup is not displayed");
		//		Thread.sleep(2000);
		//		purchaseRequisitionPage.clickYesOnSavePopupOnPurchaseOrderPage();

	}

	@Test(priority = 11) //pass and fixed 09-06-2020
	public void inventoryPurchaseReqiuistionWithoutIndentsTest() throws Throwable {
		test=extent.createTest("inventoryPurchaseReqiuistionWithoutIndentsTest", "This test case verify the inventory Purchase Reqiuistion Without Indents Test");
		test.assignCategory("Inventory Module Test");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("2 nd floor nursing station");
		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Requisition");
		purchaseRequisitionPage.selectInventory("Refresh Stock Level");
		//assertTrue(purchaseRequisitionPage.verifyActionMessage("Calculation for all items completed successfully"), "Calculation for all items completed successfully! Message not showing up");
		Thread.sleep(2000);
		purchaseRequisitionPage.selectInventory("QOH <ROL");
		Thread.sleep(2000);
		purchaseRequisitionPage.selectInventory("QOH >ROL");
		Thread.sleep(2000);
		purchaseRequisitionPage.selectInventory("All Items");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("A TO Z SYP 200ML");
		//		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("AB - FLO TAB");
		//		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("AB PHYLLINE CAP");
		purchaseRequisitionPage.selectTab("Medical Consumables");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("DEN G P PIONT 15 DENTSPLY");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("DEN G P PIONT 20 DENTSPLY");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("DEN G P PIONT 30 DENTSPLY");
		purchaseRequisitionPage.selectTab("General and Miscellaneous");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("ARM SLING ATTACHED-R-L");
		//		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("GLUCON D ORANGE 100GM");
		//		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("PAMPERS PANTS 8PC LARGE");
		//		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("PAMPERS PANTS 8PC LARGE");
		//assertTrue(purchaseRequisitionPage.verifyActionMessage("PAMPERS PANTS 8PC LARGE already selected"), "Duplicate Item is getting selected and error message is not getting thrown");	
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		//assertTrue(purchaseRequisitionPage.verifyActionMessage("Please select GRN station"), "Please select GRN station message is not getting displayed");	
		//purchaseRequisitionPage.selectFirstGRNStation();
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		//assertTrue(purchaseRequisitionPage.verifyActionMessage("Quantity is 0 for following Items"), "Quantity is 0 for following Items, message is not getting displayed");	
		purchaseRequisitionPage.enterQuantityForSelectedItems();
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		purchaseRequisitionPage.clickOnYesButtonOnSaveConfirmationPopup();
		//assertTrue(purchaseRequisitionPage.verifyPurchaseSavedSuccessMessage("Purchase requisition"), "Purchase requisition generated successfully message is not showing up");
		purchaseRequisitionPage.clickNoButtonOnPrintAlertPopup();
		purchaseRequisitionPage.clickOnClearButton();
		purchaseRequisitionPage.clickOnSearchButtonOnPurchaseRequisitionList();
		//assertTrue(purchaseRequisitionPage.verifyPurchaseRequisitionPopupOpened(), "Purchase Requisition Popup is not getting opened");
		purchaseRequisitionPage.selectFirstPurchaseRequisitionFromPurchaseRequisitionPopup();
		purchaseRequisitionPage.selectTab("Drugs");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("4 QUIN EYE DROPS(5ML)");
		purchaseRequisitionPage.enterQuantityForSelectedItems();
		purchaseRequisitionPage.clickOnModifyButton();
		purchaseRequisitionPage.clickOnYesButtonOnModifyAlertPopup();
		//assertTrue(purchaseRequisitionPage.verifyPurchaseReqModifiedSuccessPopup(), "Purchase Req Modified Success Popup is not showing up");


	}

	@Test(priority = 12) //pass and fixed 09-06-2020
	public void inventoryAcknowledgereturnTest() throws Throwable {
		test=extent.createTest("inventoryWithIndentApprovalTest", "This test case verify the inventory With Indent Approval Test");
		test.assignCategory("Inventory Module Test");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage=new IndentIssuePage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("2 nd floor nursing station");
		frontOfficeHomePage.clickOnIndentIssuesAndSelectAnOption("Acknowledge Return");
		//indentItemsPage.clickOnSaveButton();
		indentItemsPage.EnterFromDate("03/Mar/2020");
		indentItemsPage.EnterTODate("30/Apr/2020");
		indentItemsPage.clickOnnewIndentreturnRadioButton();
		indentItemsPage.clickonNewIndentReturn();
		indentItemsPage.clickonprintbutton();

		indentItemsPage.SelectRegularStockRadioButton();
		indentItemsPage.clickOnSaveButtonOnDirectIssuePage();
		driver.switchTo().activeElement();
		indentItemsPage.clickonPrintNoButton();
		indentItemsPage.selectIndentReturnAcknowledge();
		indentItemsPage.clickonprintbutton();
	}

	@Test(priority = 13) //pass and fixed 09-06-2020
	public void Inventoryindentclosuretestcase() throws InterruptedException {

		test=extent.createTest("Inventoryindentclosuretestcase", "This test case verify the Inventory Indent Closure Test Case");
		test.assignCategory("Inventory Module Test");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Items");
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please select atleast one Facility"), "Please select atleast one Facility error message not displayed");
		indentItemsPage.selectToFacilityFromDropdown("L1-SANITY-T3");
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please select Department!"), "Please select Department! error message not displayed");
		Thread.sleep(4000);
		indentItemsPage.selectToDepartmentFromDropdown("Central General Store");
		indentItemsPage.selectSmartSearchCheckbox();
		indentItemsPage.clickOnRefreshStockLabel();
		///assertTrue(indentItemsPage.verifyActionMessage("Calculation for all item completed successfully!"), "Calculation for all item completed successfully! action message not displayed");
		Thread.sleep(4000);
		purchaseRequisitionPage.selectInventory("QOH<ROL");
		Thread.sleep(4000);
		purchaseRequisitionPage.selectInventory("QOH>ROL");
		Thread.sleep(4000);
		purchaseRequisitionPage.selectInventory("ALL ITEMS");

		indentItemsPage.selectMedicines("A TO Z SYP 200ML");
		indentItemsPage.selectMedicines("ACETEN TAB 12.5MG");
		indentItemsPage.selectMedicines("BACLOF10 MG TAB");
		//indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		//assertTrue(indentItemsPage.verifyActionMessage("already selected"), "already selected Item action message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicineTab();

		indentItemsPage.selectMedicines("ABCIXIREL 10MG INJ(5ML)");
		//assertTrue(indentItemsPage.verifyActionMessage("This is Discontinued Item and Stock at other store"), "Discontinued Medicine Error message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicines("ANKLE SUPPORT SMALL");
		indentItemsPage.selectMedicines("ANKLE SUPPORT MEDIUM");
		indentItemsPage.selectMedicines("ANKLE SUPPORT LARGE");
		///assertTrue(indentItemsPage.verifyActionMessage("already selected"), "already selected Item action message not displayed");
		purchaseRequisitionPage.selectTab("Others");
		indentItemsPage.selectMedicines("PAPANICOLAU EA36-BIO");
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("GENERAL MEDICINE");
		Thread.sleep(2000);
		indentItemsPage.selectMedicines("PIPETTE STAND ROUND BEST");
		Thread.sleep(2000);

		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please enter quantity for following Items"), "Please enter quantity for following Items message is not getting displayed");	
		//purchaseRequisitionPage.deleteSelectedItemFromBlowGrid("PAMPERS PANTS 8PC LARGE");

		indentItemsPage.enterQuantityForSelectedMedicines();
		indentItemsPage.enterRemarksForSelectedMedicines();
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.isSavePopupShowing(), "Do you want to save popup not showing up");
		indentItemsPage.clickYesOnSaveButton();
		indentItemsPage.enterFromDateIntendItemsScreen("04/Jan/2020");
		//		indentItemsPage.enterToDateIntendItemsScreen("11/Jan/2020");
		indentItemsPage.clickOnNewRadioButton();
		//assertTrue(indentItemsPage.isNewIndentPopupDisplayed(), "New Indent Popup is not displayed");
		indentItemsPage.selectFirstIndentFromPopup();
		Thread.sleep(2000);
		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("BENIDIN 8 MG TAB");
		Thread.sleep(2000);
		indentItemsPage.enterQuantityForNewMedicines();
		indentItemsPage.enterRemarksForSelectedNewMedicines();
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.clickYesOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Indent modified successfully"), "Indent modified successfully message not displayed");

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Approval");
		indentApprovalPage.clickOnApproveButton();
		//assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Approve button without selecting any Indent");
		indentApprovalPage.clickOnRejectButton();
		//assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Reject button without selecting any Indent");
		indentApprovalPage.clickOnRefreshButton();
		indentApprovalPage.enterFromDate("01/Jun/2020");
		indentApprovalPage.selectStore("1st FLR T1 Transplant ICU");
		indentApprovalPage.clickOnNewIndentRadioButton();
		try {
			String indentNoFromNewIndent = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z SYP 200ML", "20");
		indentApprovalPage.clickOnApproveButton();
		indentApprovalPage.clickOnYesButtonOnApprovalConfirmationPopup();
		driver.pauseExecutionFor(4000);

		Thread.sleep(4000);
		indentApprovalPage.enterFromDate("01/Jun/2020");		
		indentApprovalPage.clickOnNewIndentRadioButton();
		try {
			String indentNoFromNewIndent1 = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		}
		catch (Exception e) {

		}
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z SYP 200ML", "30");
		indentApprovalPage.clickOnRejectButton();
		indentApprovalPage.clickOnYesButtonOnRejectionConfirmationPopup();
		driver.pauseExecutionFor(4000);
		indentApprovalPage.enterFromDate("04/Jun/2020");
		indentApprovalPage.selectStore("Crash Cart  T1-CTVS");
		indentApprovalPage.clickOnNewIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.selectStore("Crash Cart  T1-CTVS");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.selectStore("Crash Cart  T1-CTVS");
		indentApprovalPage.clickOnRejectedIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.enterFromDate("25/Jun/2020");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		try {
			String indentNoFromApproveIndent = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		}
		catch (Exception e) {}
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");
		indentApprovalPage.enterFromDate("15/Jun/2020");
		indentApprovalPage.clickOnRejectedIndentRadioButton();
		//indentApprovalPage.selectFirstIndentFromRejectedIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");

		indentApprovalPage.enterFromDate("15/Jun/2020");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		try {
			String indentNoFromApproveIndent2 = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		}
		catch (Exception e) {}
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");
		indentApprovalPage.enterFromDate("15/Jun/2020");
		indentApprovalPage.clickOnRejectedIndentRadioButton();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnHomeIcon();

		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("2 nd floor nursing station");
		frontOfficeHomePage.clickOnIndentIssuesAndSelectAnOption("Indent Issue");

	}

	@Test(priority = 14) //pass and fixed 08-06-2020
	public void InventorywithOPBillabeConsumption1TestCase() throws InterruptedException 
	{
		test=extent.createTest("InventorywithOPBillabeConsumption1TestCase", "This test case is verifies Patient Registration Valid Data");
		test.assignCategory("Inventory Module Test");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);


		System.out.println("idCard>>>>"+idCard);
		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnNo("1st FLR T1 Transplant ICU");
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown("Mr.");
		patientRegistrationPage.enterFirstName("Demo");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.checkVipCheckBoxAndEnterData("This VIP Data has been added by Test Automation Scripts");
		patientRegistrationPage.checkRemarksCheckBoxAndEnterData("This Remarks Data has been added by Test Automation Scripts");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
		patientRegistrationPage.enterAge("16");
		assertTrue(patientRegistrationPage.verifyLesserAgeAlertMessage("Please enter Date of Birth Age is less than 18 year"), "System is not throwing lesser age than 18 years message");
		patientRegistrationPage.enterAge("23");
		patientRegistrationPage.selectMartialStatusFromDropDown("Single");
		patientRegistrationPage.enterMotherMaidenName("Demo Test Mother");
		patientRegistrationPage.enterFathersName("DemoFather@123 ");
		patientRegistrationPage.selectNationalityFromDropDown("Indian");
		patientRegistrationPage.checkNRIChecbox();
		assertTrue(patientRegistrationPage.verifyIDCardDropDownIsEnabled(), "After checking NRI Checkbox, ID Card Dropdown is not getting enabled");
		patientRegistrationPage.selectIdCardTypeFromDropDown("PAN CARD");
		patientRegistrationPage.enterNationalID("12345");
		patientRegistrationPage.enterTelephoneNumber("1234567891011123");
		patientRegistrationPage.enterMobileNumber("12345");
		patientRegistrationPage.clickOnRegisterIcon();
		//assertTrue(patientRegistrationPage.verifyInvalidMobileNoAlertMessage("mobile number should not be less than 10 digit"), "Alert not showing up when invalid mobile No is added");
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Demo Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Ghaziabad");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Ghaziabad", "201001");
		patientRegistrationPage.enterEmailId("%^%^%^%^");
		patientRegistrationPage.clickOnRegisterIcon();
		patientRegistrationPage.enterEmailId("test@demo.com");
		patientRegistrationPage.enterRefferdBy("Self");
		patientRegistrationPage.selectPrefferedLanguageFromDropdown("English");
		patientRegistrationPage.selectOccupationFromDropdown(occupation);
		patientRegistrationPage.selectQualificationFromDropdown(qualification);
		patientRegistrationPage.selectReligionFromDropdown("Hindu");
		patientRegistrationPage.selectReferedFromDropdown(referredFrom);
		patientRegistrationPage.checkFinancialDetailsCheckBox();
		patientRegistrationPage.selectCompanyTypeFromDropdown("Corporate");
		patientRegistrationPage.selectCompanyFromDropdown(1);
		patientRegistrationPage.showAllCheckBox();
		patientRegistrationPage.selectRateContractFromDropdown(1);
		patientRegistrationPage.checkSchemeCheckBox();
		patientRegistrationPage.selectSchemeFromDropdown(1);
		patientRegistrationPage.clickOnRegisterIcon();
		//assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
		patientRegistrationPage.yesButtonOnConfirmPopup();
		//assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
		String patientRegistrationId =	patientRegistrationPage.getUHIDOfPatient();
		System.out.println("Patient Registration Id is " +patientRegistrationId);

		patientRegistrationPage.clickOnNoButtonOnRegisteredSuccessfullyPopup();

		//patientRegistrationPage = new PatientRegistrationPage(driver);

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnHomeIcon();
		//hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("2 nd floor nursing station");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("OP Billable Consumption");
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.EnterUHIDnumber(patientRegistrationId);
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.selectDoctorName("MANNAT  DEVGAN");
		indentItemsPage.clickonZeroStockItems();
		indentItemsPage.selectdrugandconsumables("0% ASPIRIN ,ASPIRIN ");
		indentItemsPage.clickonBatchNumber("005b8ajq ");
		//assertTrue(purchaseRequisitionPage.verifyActionMessage("This batch is already selected!"), "Confirm This batch is already selected! Message is not showing up");
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.Itemdescriptionquantity("1");
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.saveNothisrecord();
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.saveYesthisrecord();
		indentItemsPage.clickonOKbutton();
		indentItemsPage.printrecordYesbutton();
		indentItemsPage.clickClearButtonOnItemReceiptPage();
		indentItemsPage.EnterUHIDnumber(patientRegistrationId);
		indentItemsPage.selectDoctorName("MANNAT  DEVGAN");
		indentItemsPage.enterFromDateItemReceiptScreen("03/Apr/2020");
		indentItemsPage.opbillableTODate("01/May/2020");
		indentItemsPage.clickonsearchButton();
		indentItemsPage.clickonpatientdetails();
		indentItemsPage.clickoncancelbutton();
		///indentItemsPage.clickoncancelcheckbox();
		indentItemsPage.clickoncancelbutton();
		indentItemsPage.clickonNoSaverecord();
		indentItemsPage.EnterUHIDnumber(patientRegistrationId);
		indentItemsPage.selectDoctorName("MANNAT  DEVGAN");
		indentItemsPage.enterFromDateItemReceiptScreen("03/Apr/2020");
		indentItemsPage.opbillableTODate("01/May/2020");
		indentItemsPage.clickonsearchButton();
		indentItemsPage.clickonpatientdetails();
		indentItemsPage.clickoncancelbutton();
		//indentItemsPage.clickoncancelcheckbox();
		indentItemsPage.clickoncancelbutton();
		indentItemsPage.clickonYesSaverecord();
		indentItemsPage.clickonconsumptioncancelOKbutton();
	}

	@Test(enabled = false) //not fixed /////////////////////////////////////////
	public void InventoryGRNTestCase() throws InterruptedException 
	{
		test=extent.createTest("InventoryGRNTestCase", "This test case verify the Inventory GRN Test Case");
		test.assignCategory("Inventory Module Test");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");

		//frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnGRNAndSelectAnOption("GRN");
		frontOfficeHomePage.selectReceiptTypewithPO("Without PO");
		frontOfficeHomePage.SelectSupplierName("ABC MEDICAL");
		frontOfficeHomePage.EnterInvoiceNumber("abcdef");
		frontOfficeHomePage.OKReciptTypeButton();
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "0% ASPIRIN ,ASPIRIN");
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.selectAgaistChallanCheckBox();
		frontOfficeHomePage.EnterInvoiceNumber("12345678");
		frontOfficeHomePage.clickonReloadButton();
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "ATENOLOL ORAL SOLID ORDINARY   0 ");
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "Azathioprine Tab 50 MG_WK_WK");
		//		frontOfficeHomePage.selectGRNDrugItem("Medicine", "MARKUP DRUG 12% RECTAL   0 ");
		//		frontOfficeHomePage.selectGRNDrugItem("Medical Consumables", "ABDOMINAL BELT - MEDIUM");
		//		frontOfficeHomePage.selectGRNDrugItem("Medical Consumables", "ABDOMINAL BELT - SMALL");
		//		frontOfficeHomePage.selectGRNDrugItem("General & Miscellaneous", "GLUCON D ORANGE 100GM");
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.clickonReloadButton();
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.clearButton();
		frontOfficeHomePage.clickonClearNoButton();
		frontOfficeHomePage.clearButton();
		frontOfficeHomePage.clickonClearYesButton();

		//same cycle should be run

		frontOfficeHomePage.selectReceiptTypewithPO("Without PO");
		frontOfficeHomePage.SelectSupplierName("ABC MEDICAL");
		frontOfficeHomePage.EnterInvoiceNumber("abcdef");
		frontOfficeHomePage.OKReciptTypeButton();
		//frontOfficeHomePage.selectGRNDrugItem("Medicine", "AUTO TESTING 1");
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.selectAgaistChallanCheckBox();
		frontOfficeHomePage.EnterInvoiceNumber("12345678");
		frontOfficeHomePage.clickonReloadButton();

		//frontOfficeHomePage.selectGRNDrugItem("Medicine", "ATENOLOL ORAL SOLID ORDINARY   0 ");
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "Azathioprine Tab 50 MG_WK_WK");
		//frontOfficeHomePage.selectGRNDrugItem("Medicine", "SP DRUG 5 % ORAL   0 ");
		//frontOfficeHomePage.selectGRNDrugItem("Medicine", "MARKUP DRUG 12% RECTAL   0 ");
		frontOfficeHomePage.selectGRNDrugItem("Medical Consumables", "ENDOBUTTON CL ULTRA 15MM");
		frontOfficeHomePage.selectGRNDrugItem("Medical Consumables", "ENDOBUTTON CL ULTRA 20MM");
		//frontOfficeHomePage.selectGRNDrugItem("General & Miscellaneous", "TESTING 12 ORAL LIQUID ORDINARY   0 ");
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.clickonReloadButton();
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.clearButton();
		frontOfficeHomePage.clickonClearNoButton();
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		//Enter Receipt Details Qty
		//frontOfficeHomePage.ReceiptDetailsQty("ATENOLOL ORAL SOLID ORDINARY   0 ","10");
		frontOfficeHomePage.ReceiptDetailsQty("Azathioprine Tab 50 MG_WK_WK","10");
		//frontOfficeHomePage.ReceiptDetailsQty("SP DRUG 5 % ORAL   0 ","10");
		//frontOfficeHomePage.ReceiptDetailsQty("MARKUP DRUG 12% RECTAL   0 ","10");
		//		frontOfficeHomePage.ReceiptDetailsQty("ENDOBUTTON CL ULTRA 15MM","10");
		//		frontOfficeHomePage.ReceiptDetailsQty("ENDOBUTTON CL ULTRA 20MM","10");
		//frontOfficeHomePage.ReceiptDetailsQty("TESTING 12 ORAL LIQUID ORDINARY   0 ","10");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		// Enter Batch Number
		//frontOfficeHomePage.EnterBatchNumber("ATENOLOL ORAL SOLID ORDINARY   0 ","1");
		frontOfficeHomePage.EnterBatchNumber("Azathioprine Tab 50 MG_WK_WK","dfv");
		//frontOfficeHomePage.EnterBatchNumber("SP DRUG 5 % ORAL   0 ","sad");
		//frontOfficeHomePage.EnterBatchNumber("MARKUP DRUG 12% RECTAL   0 ","test2");
		//		frontOfficeHomePage.EnterBatchNumber("ENDOBUTTON CL ULTRA 15MM","OC2187");
		//		frontOfficeHomePage.EnterBatchNumber("ENDOBUTTON CL ULTRA 20MM","++++");
		///frontOfficeHomePage.EnterBatchNumber("TESTING 12 ORAL LIQUID ORDINARY   0 ","1111");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		//Enter Expiry Date
		//frontOfficeHomePage.EnterExpiryDate("ATENOLOL ORAL SOLID ORDINARY   0 ","01/Dec/2110");
		frontOfficeHomePage.EnterExpiryDate("Azathioprine Tab 50 MG_WK_WK","01/Dec/2110");
		//frontOfficeHomePage.EnterExpiryDate("SP DRUG 5 % ORAL   0 ","01/Dec/2110");
		//frontOfficeHomePage.EnterExpiryDate("MARKUP DRUG 12% RECTAL   0 ","01/Dec/2110");
		//		frontOfficeHomePage.EnterExpiryDate("ENDOBUTTON CL ULTRA 15MM","01/Dec/2110");
		//		frontOfficeHomePage.EnterExpiryDate("ENDOBUTTON CL ULTRA 20MM","01/Dec/2110");
		///frontOfficeHomePage.EnterExpiryDate("TESTING 12 ORAL LIQUID ORDINARY   0 ","01/Dec/2110");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();
		frontOfficeHomePage.clickonEditButton();

		//Enter PR Rate
		//frontOfficeHomePage.EnterPRRate("ATENOLOL ORAL SOLID ORDINARY   0 ","15");
		frontOfficeHomePage.EnterPRRate("Azathioprine Tab 50 MG_WK_WK","20");
		//frontOfficeHomePage.EnterPRRate("SP DRUG 5 % ORAL   0 ","30");
		//frontOfficeHomePage.EnterPRRate("MARKUP DRUG 12% RECTAL   0 ","25");
		//		frontOfficeHomePage.EnterPRRate("ENDOBUTTON CL ULTRA 15MM","35");
		//		frontOfficeHomePage.EnterPRRate("ENDOBUTTON CL ULTRA 20MM","40");
		///frontOfficeHomePage.EnterPRRate("TESTING 12 ORAL LIQUID ORDINARY   0 ","45");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		//Enter RP/SP/MRP
		//frontOfficeHomePage.EnterRPSPMRPNumber("ATENOLOL ORAL SOLID ORDINARY   0 ","100");
		frontOfficeHomePage.EnterRPSPMRPNumber("Azathioprine Tab 50 MG_WK_WK","100");
		//		frontOfficeHomePage.EnterRPSPMRPNumber("ENDOBUTTON CL ULTRA 15MM","100");
		//		frontOfficeHomePage.EnterRPSPMRPNumber("ENDOBUTTON CL ULTRA 20MM","100");
		//frontOfficeHomePage.EnterRPSPMRPNumber("TESTING 12 ORAL LIQUID ORDINARY   0 ","100");


		//Enter SGST
		frontOfficeHomePage.clickonEditButton();
		//frontOfficeHomePage.EnterSGSTPercentage("ATENOLOL ORAL SOLID ORDINARY   0 ","6");
		frontOfficeHomePage.EnterSGSTPercentage("Azathioprine Tab 50 MG_WK_WK","6");
		//		frontOfficeHomePage.EnterSGSTPercentage("ENDOBUTTON CL ULTRA 15MM","6");
		//		frontOfficeHomePage.EnterSGSTPercentage("ENDOBUTTON CL ULTRA 20MM","6");
		///frontOfficeHomePage.EnterSGSTPercentage("TESTING 12 ORAL LIQUID ORDINARY   0 ","6");

		//Enter CGST
		frontOfficeHomePage.clickonEditButton();
		//frontOfficeHomePage.EnterCGSTPercentage("ATENOLOL ORAL SOLID ORDINARY   0 ","6");
		frontOfficeHomePage.EnterCGSTPercentage("Azathioprine Tab 50 MG_WK_WK","6");
		//		frontOfficeHomePage.EnterCGSTPercentage("ENDOBUTTON CL ULTRA 15MM","6");
		//		frontOfficeHomePage.EnterCGSTPercentage("ENDOBUTTON CL ULTRA 20MM","6");
		///frontOfficeHomePage.EnterCGSTPercentage("TESTING 12 ORAL LIQUID ORDINARY   0 ","6");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();
		frontOfficeHomePage.clickonDraftCheckBox();
		frontOfficeHomePage.clickonSaveButton();
		frontOfficeHomePage.saveRecordNoButton();
		frontOfficeHomePage.clickonSaveButton();	
		frontOfficeHomePage.saveRecordYesButton();


	}

	@Test(priority = 15) //pass and fixed 08-06-2020
	public void InventoryGRNTestCase1() throws InterruptedException 
	{
		test=extent.createTest("InventoryGRNTestCase1", "This test case verify the Inventory GRN Test Case1");
		test.assignCategory("Inventory Module Test");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");

		//frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnGRNAndSelectAnOption("GRN");
		frontOfficeHomePage.selectReceiptTypewithPO("Without PO");
		frontOfficeHomePage.SelectSupplierName("ABC MEDICAL");
		frontOfficeHomePage.EnterInvoiceNumber("abcdef");
		frontOfficeHomePage.OKReciptTypeButton();
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "0% ASPIRIN ,ASPIRIN");
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.selectAgaistChallanCheckBox();
		frontOfficeHomePage.EnterInvoiceNumber("12345678");
		frontOfficeHomePage.clickonReloadButton();
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "ATENOLOL ORAL SOLID ORDINARY   0 ");
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "Azathioprine Tab 50 MG_WK_WK");
		//		frontOfficeHomePage.selectGRNDrugItem("Medicine", "MARKUP DRUG 12% RECTAL   0 ");
		//		frontOfficeHomePage.selectGRNDrugItem("Medical Consumables", "ABDOMINAL BELT - MEDIUM");
		//		frontOfficeHomePage.selectGRNDrugItem("Medical Consumables", "ABDOMINAL BELT - SMALL");
		//		frontOfficeHomePage.selectGRNDrugItem("General & Miscellaneous", "GLUCON D ORANGE 100GM");
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.clickonReloadButton();
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.clearButton();
		frontOfficeHomePage.clickonClearNoButton();
		frontOfficeHomePage.clearButton();
		frontOfficeHomePage.clickonClearYesButton();

		//same cycle should be run

		frontOfficeHomePage.selectReceiptTypewithPO("Without PO");
		frontOfficeHomePage.SelectSupplierName("ABC MEDICAL");
		frontOfficeHomePage.EnterInvoiceNumber("abcdef");
		frontOfficeHomePage.OKReciptTypeButton();
		//frontOfficeHomePage.selectGRNDrugItem("Medicine", "AUTO TESTING 1");
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.selectAgaistChallanCheckBox();
		frontOfficeHomePage.EnterInvoiceNumber("12345678");
		frontOfficeHomePage.clickonReloadButton();

		//frontOfficeHomePage.selectGRNDrugItem("Medicine", "ATENOLOL ORAL SOLID ORDINARY   0 ");
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "Azathioprine Tab 50 MG_WK_WK");
		//frontOfficeHomePage.selectGRNDrugItem("Medicine", "SP DRUG 5 % ORAL   0 ");
		//frontOfficeHomePage.selectGRNDrugItem("Medicine", "MARKUP DRUG 12% RECTAL   0 ");
		frontOfficeHomePage.selectGRNDrugItem("Medical Consumables", "ENDOBUTTON CL ULTRA 15MM");
		frontOfficeHomePage.selectGRNDrugItem("Medical Consumables", "ENDOBUTTON CL ULTRA 20MM");
		//frontOfficeHomePage.selectGRNDrugItem("General & Miscellaneous", "TESTING 12 ORAL LIQUID ORDINARY   0 ");
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.clickonReloadButton();
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.clearButton();
		frontOfficeHomePage.clickonClearNoButton();
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		//Enter Receipt Details Qty
		//frontOfficeHomePage.ReceiptDetailsQty("ATENOLOL ORAL SOLID ORDINARY   0 ","10");
		frontOfficeHomePage.ReceiptDetailsQty("Azathioprine Tab 50 MG_WK_WK","10");
		//frontOfficeHomePage.ReceiptDetailsQty("SP DRUG 5 % ORAL   0 ","10");
		//frontOfficeHomePage.ReceiptDetailsQty("MARKUP DRUG 12% RECTAL   0 ","10");
		//		frontOfficeHomePage.ReceiptDetailsQty("ENDOBUTTON CL ULTRA 15MM","10");
		//		frontOfficeHomePage.ReceiptDetailsQty("ENDOBUTTON CL ULTRA 20MM","10");
		//frontOfficeHomePage.ReceiptDetailsQty("TESTING 12 ORAL LIQUID ORDINARY   0 ","10");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		// Enter Batch Number
		//frontOfficeHomePage.EnterBatchNumber("ATENOLOL ORAL SOLID ORDINARY   0 ","1");
		frontOfficeHomePage.EnterBatchNumber("Azathioprine Tab 50 MG_WK_WK","dfv");
		//frontOfficeHomePage.EnterBatchNumber("SP DRUG 5 % ORAL   0 ","sad");
		//frontOfficeHomePage.EnterBatchNumber("MARKUP DRUG 12% RECTAL   0 ","test2");
		//		frontOfficeHomePage.EnterBatchNumber("ENDOBUTTON CL ULTRA 15MM","OC2187");
		//		frontOfficeHomePage.EnterBatchNumber("ENDOBUTTON CL ULTRA 20MM","++++");
		///frontOfficeHomePage.EnterBatchNumber("TESTING 12 ORAL LIQUID ORDINARY   0 ","1111");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		//Enter Expiry Date
		//frontOfficeHomePage.EnterExpiryDate("ATENOLOL ORAL SOLID ORDINARY   0 ","01/Dec/2110");
		frontOfficeHomePage.EnterExpiryDate("Azathioprine Tab 50 MG_WK_WK","01/Dec/2110");
		//frontOfficeHomePage.EnterExpiryDate("SP DRUG 5 % ORAL   0 ","01/Dec/2110");
		//frontOfficeHomePage.EnterExpiryDate("MARKUP DRUG 12% RECTAL   0 ","01/Dec/2110");
		//		frontOfficeHomePage.EnterExpiryDate("ENDOBUTTON CL ULTRA 15MM","01/Dec/2110");
		//		frontOfficeHomePage.EnterExpiryDate("ENDOBUTTON CL ULTRA 20MM","01/Dec/2110");
		///frontOfficeHomePage.EnterExpiryDate("TESTING 12 ORAL LIQUID ORDINARY   0 ","01/Dec/2110");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();
		frontOfficeHomePage.clickonEditButton();

		//Enter PR Rate
		//frontOfficeHomePage.EnterPRRate("ATENOLOL ORAL SOLID ORDINARY   0 ","15");
		frontOfficeHomePage.EnterPRRate("Azathioprine Tab 50 MG_WK_WK","20");
		//frontOfficeHomePage.EnterPRRate("SP DRUG 5 % ORAL   0 ","30");
		//frontOfficeHomePage.EnterPRRate("MARKUP DRUG 12% RECTAL   0 ","25");
		//		frontOfficeHomePage.EnterPRRate("ENDOBUTTON CL ULTRA 15MM","35");
		//		frontOfficeHomePage.EnterPRRate("ENDOBUTTON CL ULTRA 20MM","40");
		///frontOfficeHomePage.EnterPRRate("TESTING 12 ORAL LIQUID ORDINARY   0 ","45");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		//Enter RP/SP/MRP
		//frontOfficeHomePage.EnterRPSPMRPNumber("ATENOLOL ORAL SOLID ORDINARY   0 ","100");
		frontOfficeHomePage.EnterRPSPMRPNumber("Azathioprine Tab 50 MG_WK_WK","100");
		//		frontOfficeHomePage.EnterRPSPMRPNumber("ENDOBUTTON CL ULTRA 15MM","100");
		//		frontOfficeHomePage.EnterRPSPMRPNumber("ENDOBUTTON CL ULTRA 20MM","100");
		//frontOfficeHomePage.EnterRPSPMRPNumber("TESTING 12 ORAL LIQUID ORDINARY   0 ","100");


		//Enter SGST
		frontOfficeHomePage.clickonEditButton();
		//frontOfficeHomePage.EnterSGSTPercentage("ATENOLOL ORAL SOLID ORDINARY   0 ","6");
		frontOfficeHomePage.EnterSGSTPercentage("Azathioprine Tab 50 MG_WK_WK","6");
		//		frontOfficeHomePage.EnterSGSTPercentage("ENDOBUTTON CL ULTRA 15MM","6");
		//		frontOfficeHomePage.EnterSGSTPercentage("ENDOBUTTON CL ULTRA 20MM","6");
		///frontOfficeHomePage.EnterSGSTPercentage("TESTING 12 ORAL LIQUID ORDINARY   0 ","6");

		//Enter CGST
		frontOfficeHomePage.clickonEditButton();
		//frontOfficeHomePage.EnterCGSTPercentage("ATENOLOL ORAL SOLID ORDINARY   0 ","6");
		frontOfficeHomePage.EnterCGSTPercentage("Azathioprine Tab 50 MG_WK_WK","6");
		//		frontOfficeHomePage.EnterCGSTPercentage("ENDOBUTTON CL ULTRA 15MM","6");
		//		frontOfficeHomePage.EnterCGSTPercentage("ENDOBUTTON CL ULTRA 20MM","6");
		///frontOfficeHomePage.EnterCGSTPercentage("TESTING 12 ORAL LIQUID ORDINARY   0 ","6");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();
		frontOfficeHomePage.clickonDraftCheckBox();
		frontOfficeHomePage.clickonSaveButton();
		frontOfficeHomePage.saveRecordNoButton();
		frontOfficeHomePage.clickonSaveButton();	
		frontOfficeHomePage.saveRecordYesButton();
	}

	@Test(priority = 16) //pass and fixed 08-06-2020
	public void purchaseorderapprovaltestcase() throws InterruptedException 
	{
		test=extent.createTest("purchaseorderapprovaltestcase", "This test case verify the Purchase Order Approval Test Case");
		test.assignCategory("Inventory Module Test");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("2 nd floor nursing station");
		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Order Approval");
		frontOfficeHomePage.EnterPurcahseorderFromDate("03/Mar/2020");
		frontOfficeHomePage.EnterPurcahseorderToDate("12/May/2020");
		frontOfficeHomePage.selectNewRadioButton();

		//frontOfficeHomePage.clickonPOPendingForApproval();
		try {
			frontOfficeHomePage.clickonApprovalButton();
			frontOfficeHomePage.clickonNoApproveButton();
			frontOfficeHomePage.clickonApprovalButton();
			frontOfficeHomePage.clickonYesApproveButton();
			frontOfficeHomePage.clickonYesApproveButton();
			frontOfficeHomePage.clearButton();
			frontOfficeHomePage.EnterPurcahseorderFromDate("03/Apr/2020");
			frontOfficeHomePage.EnterPurcahseorderToDate("04/May/2020");
			frontOfficeHomePage.selectApprovedRadioButton();
		}

		catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test(priority = 17) //pass and fixed 08-06-2020
	public void InventoryGRNReturnwithoutGRNTestCase() throws InterruptedException 
	{

		test=extent.createTest("InventoryGRNReturnwithoutGRNTestCase", "This test case verify the Inventory GRN Test Case1");
		test.assignCategory("Inventory Module Test");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");

		//frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnGRNRETURNAndSelectAnOption("GRN Return");
		frontOfficeHomePage.clickonSaveButton();
		//assertTrue(patientRegistrationPage.verifymessagedisplay("Please enter reason for returning the following Items:!"), "Please enter reason for returning the following Items:!");
		frontOfficeHomePage.selectPurchaseTypewithoutreftoGRN("Without ref. to GRN");
		frontOfficeHomePage.SelectGRNReturnSupplierName("ABN MEDICAL SPECIALITIES");
		frontOfficeHomePage.clickonLoadButtonNearSupplierName();
		purchaseRequisitionPage.searchItems("0% ASPIRIN ,ASPIRIN");
		purchaseRequisitionPage.searchItems("Amiodarone HCl Tab 200 MG");
		//purchaseRequisitionPage.searchItems("A TO Z GOLD CAP");
		//assertTrue(patientRegistrationPage.verifymessagedisplay("A TO Z GOLD CAP already selected!"), "A TO Z GOLD CAP already selected!");
		frontOfficeHomePage.clickonBatch("0% ASPIRIN ,ASPIRIN","212312");
		frontOfficeHomePage.clickonDoYouWantContinueYesOption();
		frontOfficeHomePage.clickonBatch("Amiodarone HCl Tab 200 MG","DOBIK0956");
		frontOfficeHomePage.clickonDoYouWantContinueYesOption();
		frontOfficeHomePage.EnterGRNReturnQTY("0% ASPIRIN ,ASPIRIN", "23");
		frontOfficeHomePage.EnterGRNReturnQTY("Amiodarone HCl Tab 200 MG", "415");
		frontOfficeHomePage.clickonSaveButton();
		frontOfficeHomePage.EnterReasonandSelectReason("Testing Reason 1");
		frontOfficeHomePage.clickonSaveButton();
		frontOfficeHomePage.EnterReasonandSelectReason("Testing Reason 2");
		frontOfficeHomePage.clickonSaveButton();
		assertTrue(patientRegistrationPage.verifymessagedisplay("Please enter invoice number!"), "Please enter invoice number!");
		frontOfficeHomePage.EnterInvoiceNumberandReferenceNumber("Testing 123");
		frontOfficeHomePage.clickonSaveButton();
		frontOfficeHomePage.SelectRGPandNRGP("Returnable");
		frontOfficeHomePage.clickonSaveButton();
		frontOfficeHomePage.GRNReturnSaveNo();
		frontOfficeHomePage.clickonSaveButton();
		frontOfficeHomePage.GRNReturnSaveYes();
		frontOfficeHomePage.GRNReturnPrintYes();
		frontOfficeHomePage.GRNReturnAfterSavePrintCreditNoteAlertYes();
		frontOfficeHomePage.GRNReturnAfterSavePrintCreditNoteAlertNo();
		//frontOfficeHomePage.clickonMainReportCloseButton();
		frontOfficeHomePage.EnterFromDate("03/Mar/2020");
		frontOfficeHomePage.EnterToDate("12/May/2020");
		frontOfficeHomePage.clickonLoad();
		///frontOfficeHomePage.clickonPurchaseReturnApproveButton();
		//		frontOfficeHomePage.clickonCSVButton();
		//		frontOfficeHomePage.clickonclosePurchaseOrderButton();
	}

	@Test(priority = 18) //pass and fixed 08-06-2020
	public void InventorywithOPBillabeConsumption2TestCase() throws InterruptedException 
	{
		test=extent.createTest("InventorywithOPBillabeConsumption2TestCase", "This test case is verifies Patient Registration Valid Data");
		test.assignCategory("Inventory Module Test");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);
		billingPage = new BillingPage(driver);

		System.out.println("idCard>>>>"+idCard);
		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnNo("1st FLR T1 Transplant ICU");
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown("Mr.");
		patientRegistrationPage.enterFirstName("Demo");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.checkVipCheckBoxAndEnterData("This VIP Data has been added by Test Automation Scripts");
		patientRegistrationPage.checkRemarksCheckBoxAndEnterData("This Remarks Data has been added by Test Automation Scripts");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
		patientRegistrationPage.enterAge("16");
		assertTrue(patientRegistrationPage.verifyLesserAgeAlertMessage("Please enter Date of Birth Age is less than 18 year"), "System is not throwing lesser age than 18 years message");
		patientRegistrationPage.enterAge("23");
		patientRegistrationPage.selectMartialStatusFromDropDown("Single");
		patientRegistrationPage.enterMotherMaidenName("Demo Test Mother");
		patientRegistrationPage.enterFathersName("DemoFather@123 ");
		patientRegistrationPage.selectNationalityFromDropDown("Indian");
		patientRegistrationPage.checkNRIChecbox();
		assertTrue(patientRegistrationPage.verifyIDCardDropDownIsEnabled(), "After checking NRI Checkbox, ID Card Dropdown is not getting enabled");
		patientRegistrationPage.selectIdCardTypeFromDropDown("PAN CARD");
		patientRegistrationPage.enterNationalID("12345");
		patientRegistrationPage.enterTelephoneNumber("1234567891011123");
		patientRegistrationPage.enterMobileNumber("12345");
		patientRegistrationPage.clickOnRegisterIcon();
		//assertTrue(patientRegistrationPage.verifyInvalidMobileNoAlertMessage("mobile number should not be less than 10 digit"), "Alert not showing up when invalid mobile No is added");
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Demo Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Ghaziabad");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Ghaziabad", "201001");
		patientRegistrationPage.enterEmailId("%^%^%^%^");
		patientRegistrationPage.clickOnRegisterIcon();
		patientRegistrationPage.enterEmailId("test@demo.com");
		patientRegistrationPage.enterRefferdBy("Self");
		patientRegistrationPage.selectPrefferedLanguageFromDropdown("English");
		patientRegistrationPage.selectOccupationFromDropdown(occupation);
		patientRegistrationPage.selectQualificationFromDropdown(qualification);
		patientRegistrationPage.selectReligionFromDropdown("Hindu");
		patientRegistrationPage.selectReferedFromDropdown(referredFrom);
		patientRegistrationPage.checkFinancialDetailsCheckBox();
		patientRegistrationPage.selectCompanyTypeFromDropdown("Corporate");
		patientRegistrationPage.selectCompanyFromDropdown(1);
		patientRegistrationPage.showAllCheckBox();
		patientRegistrationPage.selectRateContractFromDropdown(1);
		patientRegistrationPage.checkSchemeCheckBox();
		patientRegistrationPage.selectSchemeFromDropdown(1);
		patientRegistrationPage.clickOnRegisterIcon();
		//assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
		patientRegistrationPage.yesButtonOnConfirmPopup();
		//assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
		String patientRegistrationId =	patientRegistrationPage.getUHIDOfPatient();
		System.out.println("Patient Registration Id is " +patientRegistrationId);

		patientRegistrationPage.clickOnNoButtonOnRegisteredSuccessfullyPopup();


		//patientRegistrationPage = new PatientRegistrationPage(driver);

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnHomeIcon();
		//hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("OP Billable Consumption");
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.EnterUHIDnumber(patientRegistrationId);
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.selectDoctorName("MANNAT  DEVGAN");
		indentItemsPage.clickonZeroStockItems();
		indentItemsPage.selectdrugandconsumables("0% ASPIRIN ,ASPIRIN ");
		//indentItemsPage.clickonBatchNumber("005b8ajq ");
		//assertTrue(purchaseRequisitionPage.verifyActionMessage("This batch is already selected!"), "Confirm This batch is already selected! Message is not showing up");
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.Itemdescriptionquantity("1");

		indentItemsPage.clickOnSaveButton();
		indentItemsPage.saveNothisrecord();
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.saveYesthisrecord();
		indentItemsPage.clickonOKbutton();
		indentItemsPage.printrecordYesbutton();
		indentItemsPage.clickClearButtonOnItemReceiptPage();
		indentItemsPage.EnterUHIDnumber(patientRegistrationId);
		indentItemsPage.selectDoctorName("MANNAT  DEVGAN");
		indentItemsPage.enterFromDateItemReceiptScreen("03/Apr/2020");
		indentItemsPage.opbillableTODate("01/May/2020");
		indentItemsPage.clickonsearchButton();
		indentItemsPage.clickonpatientdetails();
		indentItemsPage.clickoncancelbutton();
		//indentItemsPage.clickoncancelcheckbox();
		indentItemsPage.clickoncancelbutton();
		indentItemsPage.clickonNoSaverecord();
		indentItemsPage.EnterUHIDnumber(patientRegistrationId);
		indentItemsPage.selectDoctorName("MANNAT  DEVGAN");
		indentItemsPage.enterFromDateItemReceiptScreen("03/Apr/2020");
		indentItemsPage.opbillableTODate("01/May/2020");
		indentItemsPage.clickonsearchButton();
		indentItemsPage.clickonpatientdetails();
		indentItemsPage.clickoncancelbutton();
		//indentItemsPage.clickoncancelcheckbox();
		indentItemsPage.clickoncancelbutton();
		indentItemsPage.clickonYesSaverecord();
		indentItemsPage.clickonconsumptioncancelOKbutton();
		indentItemsPage.clickonPrintButton();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnHomeIcon();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();

		try {
			billingPage.clickandclosebuttonDocumentChecklist();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "CGHS COMPANY", "Trio Tree Noida", "NEW CGHS", "5", "10");
		billingPage.clickonschemedetails();
		//billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme", "Management Decision", "Today Testing");
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			billingPage.closeRemarksPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.selectSpecialityFromChooseSpecialityDropdown("Cardiology");
		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined(" MANNAT  DEVGAN");
		billingPage.selectScheduleSlotAndToken("54"); // new functionality is added
		billingPage.clickOnDiagnosticIcon();
		billingPage.selectTestsByName("24 hour urine 5HIAA");
		//assertTrue(billingPage.verifyPriceNotDefinedMessage("Price not defined for this service"), "Price Not Defined Message is not showing up");
		//		billingPage.selectTestsByName("24 hour Urine Aldosterone");
		//		billingPage.selectTestsByName("24 hour Urine Free Cortisol");
		//		billingPage.selectTestsByName("Phosphorus - Inorganic 24hr Urine");
		billingPage.selectAllTestSpecialityAndDoctorName("Cardiology", "MANNAT  DEVGAN");
		billingPage.clickOnYesButtonOnPatientMappedPopup();
		billingPage.clickOnManualIcon();
		billingPage.selectServiceNameFromDropdown("Cardiology Services");
		billingPage.enterDescriptionInManualSection("cardic");
		billingPage.selectQuantityInManualSection("50");
		billingPage.enterPriceInManualSection("100");
		billingPage.clickOnVerifyButton();
		billingPage.clickOnOtherServicesIcon();
		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
		//assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Blood Bank" , "Cross matching");
		//billingPage.selectSpecialityAndDoctor();
		billingPage.selectSpecialityAndDoctor("Cardiology", "MANNAT  DEVGAN");
		billingPage.enterRefferedBy("demo");
		billingPage.selectFacilitatorFromDropdown(1);

		billingPage.clickOnAddToBillButton();
		//assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.clickOnYesButtonOnAvailDepositPopup();

		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("24 hour urine 5HIAA");
		billingPage.selectDiscountHeadFromDropdown("Special Discount");
		billingPage.selectDiscountReasonFromDropdown("Specail Discount 10%");

		//billingPage.enterDiscountAmount("500");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		billingPage.selectAuthorisedByFromDropdown("anshul agarwal");
		billingPage.selectOnCompanyRadioButton();
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		///assertTrue(billingPage.isCompOnlyDiscoutErrorMessageDisplayed(), "Comp Only Discount Error Message is NOT Displayed");
		//		billingPage.selectOnPatientRadioButton();
		//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//		billingPage.clickOnBillingButtonOnHeader();
		//		billingPage.clickOnyesBtnOnGenrateBillPopup();
		//		billingPage.enterPatientPaidAmount("5000");
		//		billingPage.clickOnNewPaymentModeButton();
		//		billingPage.selectSecondPaymentModeAsCheque();
		//		billingPage.enterChequeDetailsAndSaveDetails("123456789", "State Bank of India", "Noida");		
		//		billingPage.clickOnVerifyButtonOnProcessPayment();
		//		//assertTrue(billingPage.verifyBillGotGenerated("generated successfully"), "Bill did not got generated");
		//		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
	}

	@Test(priority = 19) //pass and fixed 08-06-2020
	public void InventoryPaymentAdvicesTestCase() throws InterruptedException 
	{
		test=extent.createTest("InventoryPaymentAdvicesTestCase", "This test case verify the Inventory Payment Advices Test Case");
		test.assignCategory("Inventory Module Test");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");

		frontOfficeHomePage.clickOnGRNAndSelectAnOption("GRN");
		frontOfficeHomePage.selectReceiptTypewithPO("Without PO");
		frontOfficeHomePage.SelectSupplierName("ABN MEDICAL SPECIALITIES");
		frontOfficeHomePage.OKReciptTypeButton();
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "0% ASPIRIN ,ASPIRIN");
		//assertTrue(patientRegistrationPage.verifymessagedisplay("Please enter invoice!"), "patientRegistrationPage.verifymessagedisplay");
		frontOfficeHomePage.clickonGRNItemsCloseButton();

		frontOfficeHomePage.selectAgaistChallanCheckBox();
		frontOfficeHomePage.EnterInvoiceNumber("Testing Invoice Number");
		frontOfficeHomePage.clickonReloadButton();

		// Select GRN Durg Item
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "Amiodarone HCl Tab 200 MG");
		//frontOfficeHomePage.selectGRNDrugItem("Medicine", "SP DRUG 5 % ORAL   0 ");
		//frontOfficeHomePage.selectGRNDrugItem("Medicine", "MARKUP DRUG 12% RECTAL   0 ");
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		//Enter Qty
		frontOfficeHomePage.ReceiptDetailsQty("Amiodarone HCl Tab 200 MG","10");
		//frontOfficeHomePage.ReceiptDetailsQty("SP DRUG 5 % ORAL   0 ","10");
		//frontOfficeHomePage.ReceiptDetailsQty("MARKUP DRUG 12% RECTAL   0 ","10");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		// Enter Batch Number
		frontOfficeHomePage.EnterBatchNumber("Amiodarone HCl Tab 200 MG","1");
		//frontOfficeHomePage.EnterBatchNumber("SP DRUG 5 % ORAL   0 ","sad");
		//frontOfficeHomePage.EnterBatchNumber("MARKUP DRUG 12% RECTAL   0 ","test2");

		//Enter Expiry Date
		frontOfficeHomePage.EnterExpiryDate("Amiodarone HCl Tab 200 MG","01/Dec/2110");
		//frontOfficeHomePage.EnterExpiryDate("SP DRUG 5 % ORAL   0 ","01/Dec/2110");
		//frontOfficeHomePage.EnterExpiryDate("MARKUP DRUG 12% RECTAL   0 ","01/Dec/2110");
		frontOfficeHomePage.clickonEditButton();

		//Enter PR Rate
		frontOfficeHomePage.EnterPRRate("Amiodarone HCl Tab 200 MG","20");
		//frontOfficeHomePage.EnterPRRate("SP DRUG 5 % ORAL   0 ","25");
		//frontOfficeHomePage.EnterPRRate("MARKUP DRUG 12% RECTAL   0 ","30");
		frontOfficeHomePage.clickonEditButton();

		//Enter RP/SP/MRP
		frontOfficeHomePage.EnterRPSPMRPNumber("Amiodarone HCl Tab 200 MG","100");
		//frontOfficeHomePage.EnterRPSPMRPNumber("SP DRUG 5 % ORAL   0 ","100");
		//frontOfficeHomePage.EnterRPSPMRPNumber("MARKUP DRUG 12% RECTAL   0 ","100");

		//Enter SGST
		frontOfficeHomePage.clickonEditButton();
		frontOfficeHomePage.EnterSGSTPercentage("Amiodarone HCl Tab 200 MG","6");
		//frontOfficeHomePage.EnterSGSTPercentage("SP DRUG 5 % ORAL   0 ","6");
		//frontOfficeHomePage.EnterSGSTPercentage("MARKUP DRUG 12% RECTAL   0 ","6");

		//Enter CGST
		frontOfficeHomePage.clickonEditButton();
		frontOfficeHomePage.EnterCGSTPercentage("Amiodarone HCl Tab 200 MG","6");
		//frontOfficeHomePage.EnterCGSTPercentage("SP DRUG 5 % ORAL   0 ","6");
		//frontOfficeHomePage.EnterCGSTPercentage("MARKUP DRUG 12% RECTAL   0 ","6");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();
		frontOfficeHomePage.clickonDraftCheckBox();
		frontOfficeHomePage.clickonSaveButton();
		frontOfficeHomePage.saveRecordNoButton();
		frontOfficeHomePage.clickonSaveButton();	
		frontOfficeHomePage.saveRecordYesButton();
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnHomeIcon();
		hisHomePage.clickOnInventoryIcon(test);
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");

		frontOfficeHomePage.clickOnGRNAndSelectAnOption("Payment Advice");
		frontOfficeHomePage.clickonSaveButton();
		//assertTrue(patientRegistrationPage.verifymessagedisplay("Please select suppiler !"), "Please select suppiler !");
		frontOfficeHomePage.PaymentAdviceSelectSupplierName("ABN MEDICAL SPECIALITIES");
		//		frontOfficeHomePage.selectDateRangeCheckBox();
		//		frontOfficeHomePage.selectPaymentAdviceFromDate("03/Mar/2020");
		//		frontOfficeHomePage.selectPaymentAdviceToDate("12/May/2020");
		frontOfficeHomePage.clickonPaymentAdviceSearchButton();
		///assertTrue(patientRegistrationPage.verifymessagedisplay("Record not found!"), "Record not found!");
		frontOfficeHomePage.PaymentAdviceSelectSupplierName("ABC MEDICAL");
		frontOfficeHomePage.clickonPaymentAdviceSearchButton();
		frontOfficeHomePage.selectCheckBox();
		frontOfficeHomePage.clickonSaveButton();
		//assertTrue(patientRegistrationPage.verifymessagedisplay("Please enter invoice no."), "Please enter invoice no.");
		frontOfficeHomePage.clickonModifyButton();
		frontOfficeHomePage.PaymentAdviceInvoiceNumber("Testing Invoice 1");
		frontOfficeHomePage.clickonSaveButton();
		frontOfficeHomePage.paymentAdviceclickonYesButton();
		frontOfficeHomePage.paymentAdvicePrintButton();
		//assertTrue(patientRegistrationPage.verifymessagedisplay("Please select Summary or Details for print first!"), "Please select Summary or Details for print first!");

		frontOfficeHomePage.selectsummaryRadioButton();
		frontOfficeHomePage.paymentAdvicePrintButton();


		frontOfficeHomePage.paymentAdviceclearButton();
		frontOfficeHomePage.clickonPaymentAdviceSearchButton();
		frontOfficeHomePage.PaymentAdviceSelectSupplierName("ABC MEDICAL");
		//frontOfficeHomePage.selectDateRangeCheckBox();
		//		frontOfficeHomePage.selectPaymentAdviceFromDate("03/Mar/2020");
		//		frontOfficeHomePage.selectPaymentAdviceToDate("12/May/2020");

		// Click on Show Existing Tab
		frontOfficeHomePage.showExistingAdvicesTab();
		frontOfficeHomePage.clickonPaymentAdviceSearchButton();
		frontOfficeHomePage.paymentAdvicePrintButton();
		frontOfficeHomePage.selectsummaryRadioButton();
		frontOfficeHomePage.paymentAdvicePrintButton();

	}
}
