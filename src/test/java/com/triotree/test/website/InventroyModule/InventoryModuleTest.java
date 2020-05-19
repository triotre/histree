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

	private String patientRegistrationId = "AHHS.8996";
	private String desc = null;
	private String title1 = null;
	private String desc1 = null;


	@Test(priority = 1) //fixed 16-04-2020
	public void inventoryIndentOrderTest() throws Throwable {
		test=extent.createTest("inventoryIndentOrderTest", "This test case verify the inventory Indent Order Test");
		test.assignCategory("Front Office Inventory");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("CATH LAB ");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Items");
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please select atleast one Facility"), "Please select atleast one Facility error message not displayed");
		indentItemsPage.selectToFacilityFromDropdown("TRIOTREE HOSPITAL");
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please select Department!"), "Please select Department! error message not displayed");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectToDepartmentFromDropdown("Central Medicine Store");
		indentItemsPage.selectSmartSearchCheckbox();
		indentItemsPage.clickOnRefreshStockLabel();
		assertTrue(indentItemsPage.verifyActionMessage("Calculation for all item completed successfully!"), "Calculation for all item completed successfully! action message not displayed");
		indentItemsPage.clickOnSelectAllLabel();

		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("A TO Z NS SYP 200 ML");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("AB - FLO TAB");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		driver.pauseExecutionFor(7000);
		//		driver.pauseExecutionFor(3000);
		//		indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		//		assertTrue(indentItemsPage.verifyActionMessage("AB PHYLLINE CAP already selected!"), "Duplicate Medicine message not displayed");
		indentItemsPage.selectMedicines("AHAGLOW S SPRAY");
		assertTrue(indentItemsPage.verifyActionMessage("This is Discontinued Item and Stock at other store"), "Discontinued Medicine Error message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicines("ABDOMINAL BINDER- LARGE");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectOthersTab();
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("PAMPERS (SMALL)");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("GLUCON D ORANGE 100GM");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("PAMPERS PANTS 8PC LARGE");
		driver.pauseExecutionFor(7000);
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please enter quantity for following Items"), "Please enter quantity Error message not displayed");
		indentItemsPage.enterQuantityForSelectedMedicines();
		indentItemsPage.enterRemarksForSelectedMedicines();
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.isSavePopupShowing(), "Do you want to save popup not showing up");
		indentItemsPage.clickYesOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Saved Successfully,Print can be take"), "Saved Successfully message not displayed");
		indentItemsPage.clickOnNewRadioButton();
		assertTrue(indentItemsPage.isNewIndentPopupDisplayed(), "New Indent Popup is not displayed");
		indentItemsPage.selectFirstIndentFromPopup();
		driver.pauseExecutionFor(5000);
		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("8 X SHAMPOO");
		driver.pauseExecutionFor(5000);
		indentItemsPage.enterQuantityForNewMedicines();
		indentItemsPage.enterRemarksForSelectedNewMedicines();
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.clickYesOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Indent modified successfully"), "Indent modified successfully message not displayed");

	}

	@Test(priority =2 ) //fixed  27-04-2020
	public void inventoryWithIndentApprovalTest() throws Throwable {
		test=extent.createTest("inventoryWithIndentApprovalTest", "This test case verify the inventory With Indent Approval Test");
		test.assignCategory("Front Office Inventory");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("CATH LAB ");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Items");
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please select atleast one Facility"), "Please select atleast one Facility error message not displayed");
		indentItemsPage.selectToFacilityFromDropdown("TRIOTREE HOSPITAL");
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please select Department!"), "Please select Department! error message not displayed");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectToDepartmentFromDropdown("Central Medicine Store");
		indentItemsPage.selectSmartSearchCheckbox();
		indentItemsPage.selectQOHGreaterThanZeroTab();
		indentItemsPage.clickOnRefreshStockLabel();
		//assertTrue(indentItemsPage.verifyActionMessage("Calculation for all item completed successfully!"), "Calculation for all item completed successfully! action message not displayed");
		driver.pauseExecutionFor(18000);
		indentItemsPage.selectQOHLessThanROLTab();
		indentItemsPage.selectQOHGreaterThanROLTab();
		indentItemsPage.selectAllItemsTab();



		indentItemsPage.clickOnSelectAllLabel();

		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("A TO Z NS SYP 200 ML");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("AB - FLO TAB");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		driver.pauseExecutionFor(7000);
		//		driver.pauseExecutionFor(3000);
		//		indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		//		assertTrue(indentItemsPage.verifyActionMessage("AB PHYLLINE CAP already selected!"), "Duplicate Medicine message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicineTab();

		indentItemsPage.selectMedicines("AHAGLOW S SPRAY");
		assertTrue(indentItemsPage.verifyActionMessage("This is Discontinued Item and Stock at other store"), "Discontinued Medicine Error message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicines("ABDOMINAL BINDER- LARGE");
		indentItemsPage.selectMedicines("ABDOMINAL BINDER- MEDIUM");
		indentItemsPage.selectMedicines("ABDOMINAL BINDER- SMALL");
		indentItemsPage.selectMedicines("ABDOMINAL BINDER- LARGE");
		assertTrue(indentItemsPage.verifyActionMessage("already"), "Already Selected message not displayed");


		driver.pauseExecutionFor(7000);
		indentItemsPage.selectOthersTab();
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("PAMPERS (SMALL)");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("GLUCON D ORANGE 100GM");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("PAMPERS PANTS 8PC LARGE");
		driver.pauseExecutionFor(7000);
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please enter quantity for following Items"), "Please enter quantity Error message not displayed");
		indentItemsPage.selectDeleteButtonAgainstMedicines("PAMPERS PANTS 8PC");
		indentItemsPage.enterQuantityForSelectedMedicines();
		indentItemsPage.enterRemarksForSelectedMedicines();
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.isSavePopupShowing(), "Do you want to save popup not showing up");
		indentItemsPage.clickYesOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Saved Successfully,Print can be take"), "Saved Successfully message not displayed");

		indentItemsPage.enterFromDateIntendItemsScreen("04/Jan/2020");
		//		indentItemsPage.enterToDateIntendItemsScreen("11/Jan/2020");
		indentItemsPage.clickOnNewRadioButton();
		//assertTrue(indentItemsPage.isNewIndentPopupDisplayed(), "New Indent Popup is not displayed");
		indentItemsPage.selectFirstIndentFromPopup();
		driver.pauseExecutionFor(5000);
		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("8 X SHAMPOO");
		driver.pauseExecutionFor(5000);
		indentItemsPage.enterQuantityForNewMedicines("8 X SHAMPOO");
		indentItemsPage.enterRemarksForSelectedNewMedicines("8 X SHAMPOO");
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.clickYesOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Indent modified successfully"), "Indent modified successfully message not displayed");

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Approval");
		indentApprovalPage.clickOnApproveButton();
		assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Approve button without selecting any Indent");
		indentApprovalPage.clickOnRejectButton();
		assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Reject button without selecting any Indent");
		indentApprovalPage.clickOnRefreshButton();
		indentApprovalPage.enterFromDate("01/Mar/2019");
		indentApprovalPage.selectStore("CATH LAB");
		indentApprovalPage.clickOnNewIndentRadioButton();
		try {
			String indentNoFromNewIndent = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z NS SYP 200 ML", "20");
		indentApprovalPage.clickOnApproveButton();
		driver.pauseExecutionFor(4000);
		indentApprovalPage.clickOnYesButtonOnApprovalConfirmationPopup();
		driver.pauseExecutionFor(4000);

		indentApprovalPage.enterFromDate("01/Mar/2019");		
		indentApprovalPage.clickOnNewIndentRadioButton();
		try {
			String indentNoFromNewIndent1 = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		}
		catch (Exception e) {

		}
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z NS SYP 200 ML", "30");
		indentApprovalPage.clickOnRejectButton();
		indentApprovalPage.clickOnYesButtonOnRejectionConfirmationPopup();
		driver.pauseExecutionFor(4000);
		indentApprovalPage.enterFromDate("08/Mar/2019");
		indentApprovalPage.selectStore("IVF");
		indentApprovalPage.clickOnNewIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.selectStore("IVF");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.selectStore("IVF");
		indentApprovalPage.clickOnRejectedIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.enterFromDate("25/Mar/2019");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		try {
			String indentNoFromApproveIndent = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		}
		catch (Exception e) {}
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");
		indentApprovalPage.enterFromDate("15/Mar/2019");
		indentApprovalPage.clickOnRejectedIndentRadioButton();
		//indentApprovalPage.selectFirstIndentFromRejectedIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");

		indentApprovalPage.enterFromDate("15/Mar/2019");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		try {
			String indentNoFromApproveIndent2 = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		}
		catch (Exception e) {}
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");
		indentApprovalPage.enterFromDate("15/Mar/2019");
		indentApprovalPage.clickOnRejectedIndentRadioButton();
		//indentApprovalPage.selectFirstIndentFromRejectedIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnHomeIcon();

		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");

		//		  frontOfficeHomePage.clickOnIndentIssuesAndSelectAnOption("Indent Items");
		//		  driver.pauseExecutionFor(15000);
		//		  indentItemsPage.enterFromDateIntendItemsScreen("08/Mar/2019");
		//		  indentItemsPage.clickOnApprovedButtonOnIndentItems();
		//		  indentItemsPage.selectFirstIndentFromPopup(); driver.pauseExecutionFor(4000);
		//		  indentItemsPage.clickOnRejectedButtonOnIndentItems();
		//		  indentItemsPage.selectFirstIndentFromPopup(); driver.pauseExecutionFor(5000);


	}

	@Test(priority =3 ) //fixed 16-04-2020
	public void inventoryIntendIssue1Test() throws Throwable {
		test=extent.createTest("inventoryIntendIssue1Test", "This test case verify the inventory Intend Issue1 Test");
		test.assignCategory("Front Office Inventory");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("CATH LAB ");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Items");
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please select atleast one Facility"), "Please select atleast one Facility error message not displayed");
		indentItemsPage.selectToFacilityFromDropdown("TRIOTREE HOSPITAL");
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please select Department!"), "Please select Department! error message not displayed");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectToDepartmentFromDropdown("Central Medicine Store");
		indentItemsPage.selectSmartSearchCheckbox();
		indentItemsPage.clickOnRefreshStockLabel();
		assertTrue(indentItemsPage.verifyActionMessage("Calculation for all item completed successfully!"), "Calculation for all item completed successfully! action message not displayed");
		indentItemsPage.clickOnSelectAllLabel();
		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("A TO Z NS SYP 200 ML");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("AB - FLO TAB");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		driver.pauseExecutionFor(7000);
		//		driver.pauseExecutionFor(3000);
		//		indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		//		assertTrue(indentItemsPage.verifyActionMessage("AB PHYLLINE CAP already selected!"), "Duplicate Medicine message not displayed");
		indentItemsPage.selectMedicines("AHAGLOW S SPRAY");
		assertTrue(indentItemsPage.verifyActionMessage("This is Discontinued Item and Stock at other store"), "Discontinued Medicine Error message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicines("ABDOMINAL BINDER- LARGE");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("ABDOMINAL BELT -X-LARGE");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("ABDOMINAL DRAIN KIT NO. 16");
		indentItemsPage.selectOthersTab();
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("PAMPERS (SMALL)");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("GLUCON D ORANGE 100GM");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("PAMPERS PANTS 8PC LARGE");
		driver.pauseExecutionFor(7000);
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please enter quantity for following Items"), "Please enter quantity Error message not displayed");
		indentItemsPage.enterQuantityForSelectedMedicines();
		indentItemsPage.enterRemarksForSelectedMedicines();
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.isSavePopupShowing(), "Do you want to save popup not showing up");
		indentItemsPage.clickYesOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Saved Successfully,Print can be take"), "Saved Successfully message not displayed");


		indentItemsPage.clickOnNewRadioButton();
		assertTrue(indentItemsPage.isNewIndentPopupDisplayed(), "New Indent Popup is not displayed");
		indentItemsPage.selectFirstIndentFromPopup();
		driver.pauseExecutionFor(5000);

		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("8 X SHAMPOO");
		driver.pauseExecutionFor(5000);
		indentItemsPage.enterQuantityForNewMedicines();
		indentItemsPage.enterRemarksForSelectedNewMedicines();
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.clickYesOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Indent modified successfully"), "Indent modified successfully message not displayed");

		frontOfficeHomePage.clickOnMenu();

		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Approval");
		indentApprovalPage.clickOnApproveButton();
		assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Approve button without selecting any Indent");
		indentApprovalPage.clickOnRejectButton();
		assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Reject button without selecting any Indent");
		indentApprovalPage.clickOnNewIndentRadioButton();
		String indentNoFromNewIndent = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z NS SYP 200 ML", "20");
		indentApprovalPage.clickOnApproveButton();
		indentApprovalPage.clickOnYesButtonOnApprovalConfirmationPopup();
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		String indentNoFromApproveIndent = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		Assert.assertEquals(indentNoFromNewIndent, indentNoFromApproveIndent, "Approved Indent is not showing up in Approved Indent List ");

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnHomeIcon();

		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");
		frontOfficeHomePage.clickOnIndentIssuesAndSelectAnOption("Indent Issue");
		indentIssuePage.clickOnPrintCumulativeIssueButton();
		assertTrue(indentIssuePage.verifyActionMessage("There is no issued items"), "There is not Issued Items Message is not showing up after clicking print cumulative issue button without selecting ang indent");
		indentIssuePage.clickOnNewRadioButton();
		indentIssuePage.selectFirstIndentFromPopup();
		indentIssuePage.clickOnOrderedItemsMedicines("AB - FLO TAB");
		assertTrue(indentIssuePage.verifyActionMessage("No substute available for"), "No substute available for AB - FLO TAB Message is not showing up");

		indentIssuePage.clickOnOrderedItemsMedicines("ABDOMINAL BINDER- LARGE");
		indentIssuePage.selectSubtitutes("ALOXID CAP");
		assertTrue(indentIssuePage.verifyActionMessage("Stock is zero for this item"), "After selecting ALOXID CAP, stock is zero message not showing up");
		indentIssuePage.selectSubtitutes("ALPHADOL-0.25 CAPSULE");
		indentIssuePage.clickOnSaveFloppyIcon();		
		indentIssuePage.clickOnYesButtonOnSaveThisRecordPopup();
		//assertTrue(indentIssuePage.verifyIndentCreatedSuccessMessage("Data saved successfully"), "Data Saved Successfully message not showing up");
		indentIssuePage.clickOnYesButtonOnCreatedSuccessfullyPopup();
		indentIssuePage.clickOnClearButton();
		indentIssuePage.clickOnPendingRadioButton();
		//indentIssuePage.selectFirstIndentFromPopup();

	}


	@Test(priority = 4) //fixed 16-04-2020
	public void inventoryItemReceiptWithIndentOrderTest() throws Throwable {

		test=extent.createTest("inventoryIntendIssue1Test", "This test case verify the inventory Intend Issue1 Test");
		test.assignCategory("Front Office Inventory"); 

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("CATH LAB ");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Items");
		indentItemsPage.enterFromDateIntendItemsScreen("01/Mar/2019");
		indentItemsPage.clickOnIssuedRadioButton();
		indentItemsPage.selectFirstIndentFromPopup();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Item Receipt");
		indentItemsPage.enterFromDateItemReceiptScreen("01/May/2019");
		indentItemsPage.clickOnNewReceiptRadioButton();
		indentItemsPage.selectFirstIndentFromItemReceiptPopup();
		indentItemsPage.clickOnSaveButtonOnDirectIssuePage();
		indentItemsPage.clickYesButtonOnSaveItemReceiptPage();
		assertTrue(indentItemsPage.verifyActionMessage("Received"), "Received Message not Shown");
		driver.pauseExecutionFor(8000);
		indentItemsPage.clickClearButtonOnItemReceiptPage();
		indentItemsPage.clickOnReceivedReceiptRadioButton();
		indentItemsPage.selectFirstIndentFromItemReceiptPopup();
		driver.pauseExecutionFor(8000);
		indentItemsPage.clickClearButtonOnItemReceiptPage();


	}


	@Test(priority = 5) //fixed 16-04-2020
	public void inventoryPurchaseReqiuistion1Test() throws Throwable {

		test=extent.createTest("inventoryPurchaseReqiuistion1Test", "This test case verify the inventory Purchase Reqiuistion1 Test");
		test.assignCategory("Front Office Inventory"); 

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("CATH LAB ");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Items");
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please select atleast one Facility"), "Please select atleast one Facility error message not displayed");
		indentItemsPage.selectToFacilityFromDropdown("TRIOTREE HOSPITAL");
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please select Department!"), "Please select Department! error message not displayed");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectToDepartmentFromDropdown("Central Medicine Store");
		indentItemsPage.selectSmartSearchCheckbox();
		indentItemsPage.clickOnRefreshStockLabel();
		assertTrue(indentItemsPage.verifyActionMessage("Calculation for all item completed successfully!"), "Calculation for all item completed successfully! action message not displayed");
		indentItemsPage.clickOnSelectAllLabel();

		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("A TO Z NS SYP 200 ML");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("AB - FLO TAB");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		driver.pauseExecutionFor(7000);
		//		driver.pauseExecutionFor(3000);
		//		indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		//		assertTrue(indentItemsPage.verifyActionMessage("AB PHYLLINE CAP already selected!"), "Duplicate Medicine message not displayed");
		indentItemsPage.selectMedicines("AHAGLOW S SPRAY");
		assertTrue(indentItemsPage.verifyActionMessage("This is Discontinued Item and Stock at other store"), "Discontinued Medicine Error message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicines("ABDOMINAL BINDER- LARGE");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("ABDOMINAL BELT -X-LARGE");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("ABDOMINAL DRAIN KIT NO. 16");
		indentItemsPage.selectOthersTab();
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("PAMPERS (SMALL)");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("GLUCON D ORANGE 100GM");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectMedicines("PAMPERS PANTS 8PC LARGE");
		driver.pauseExecutionFor(7000);
		indentItemsPage.clickOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Please enter quantity for following Items"), "Please enter quantity Error message not displayed");
		indentItemsPage.enterQuantityForSelectedMedicines();
		indentItemsPage.enterRemarksForSelectedMedicines();
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.isSavePopupShowing(), "Do you want to save popup not showing up");
		indentItemsPage.clickYesOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Saved Successfully,Print can be take"), "Saved Successfully message not displayed");
		indentItemsPage.clickOnNewRadioButton();
		assertTrue(indentItemsPage.isNewIndentPopupDisplayed(), "New Indent Popup is not displayed");
		indentItemsPage.selectFirstIndentFromPopup();
		driver.pauseExecutionFor(5000);
		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("8 X SHAMPOO");
		driver.pauseExecutionFor(5000);
		indentItemsPage.enterQuantityForNewMedicines();
		indentItemsPage.enterRemarksForSelectedNewMedicines();
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.clickYesOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Indent modified successfully"), "Indent modified successfully message not displayed");
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Approval");
		indentApprovalPage.clickOnApproveButton();
		assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Approve button without selecting any Indent");
		indentApprovalPage.clickOnRejectButton();
		assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Reject button without selecting any Indent");
		indentApprovalPage.clickOnNewIndentRadioButton();
		String indentNoFromNewIndent = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z NS SYP 200 ML", "20");
		indentApprovalPage.clickOnApproveButton();
		indentApprovalPage.clickOnYesButtonOnApprovalConfirmationPopup();
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		String indentNoFromApproveIndent = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		Assert.assertEquals(indentNoFromNewIndent, indentNoFromApproveIndent, "Approved Indent is not showing up in Approved Indent List ");

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnHomeIcon();

		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");
		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Requisition");
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		assertTrue(purchaseRequisitionPage.verifyActionMessage("Please select GRN station"), "Please select GRN station Message not showing up");
		purchaseRequisitionPage.clickOnAgainstIntendradioButton();
		purchaseRequisitionPage.checkSelectCheckboxForFirstIntend();
		purchaseRequisitionPage.deleteLastItemFromBlowGrid();
		purchaseRequisitionPage.changeQuantityForItemsInBlowGrid();
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		assertTrue(purchaseRequisitionPage.verifyActionMessage("Please select GRN station"), "Please select GRN station Message not showing up");
		purchaseRequisitionPage.selectFirstGRNStation();
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		purchaseRequisitionPage.clickOnYesButtonOnSaveConfirmationPopup();
		assertTrue(purchaseRequisitionPage.verifyPurchaseSavedSuccessMessage("Purchase requisition"), "Purchase requisition generated successfully message is not showing up");
		purchaseRequisitionPage.printyesbutton();

	}

	@Test(priority =6 ) //fixed 16-04-2020
	public void inventoryPurchaseReqiuistion2Test() throws Throwable {

		test=extent.createTest("inventoryPurchaseReqiuistion2Test", "This test case verify the inventory Purchase Reqiuistion2 Test");
		test.assignCategory("Front Office Inventory"); 

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");
		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Requisition");
		purchaseRequisitionPage.selectInventory("Refresh Stock Level");
		assertTrue(purchaseRequisitionPage.verifyActionMessage("Calculation for all items completed successfully"), "Calculation for all items completed successfully! Message not showing up");
		driver.pauseExecutionFor(3000);
		purchaseRequisitionPage.selectInventory("QOH <ROL");
		driver.pauseExecutionFor(3000);
		purchaseRequisitionPage.selectInventory("QOH <ROL");
		driver.pauseExecutionFor(3000);
		purchaseRequisitionPage.selectInventory("All Items");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("A TO Z NS SYP 200 ML");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("AB - FLO TAB");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("AB PHYLLINE CAP");
		purchaseRequisitionPage.selectTab("Medical Consumables");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("ABDOMINAL BINDER- LARGE");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("ABDOMINAL BINDER- MEDIUM");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("ABDOMINAL BINDER- SMALL");
		purchaseRequisitionPage.selectTab("General and Miscellaneous");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("PAMPERS (SMALL)");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("GLUCON D ORANGE 100GM");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("PAMPERS PANTS 8PC LARGE");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("PAMPERS PANTS 8PC LARGE");
		assertTrue(purchaseRequisitionPage.verifyActionMessage("PAMPERS PANTS 8PC LARGE already selected"), "Duplicate Item is getting selected and error message is not getting thrown");	
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		assertTrue(purchaseRequisitionPage.verifyActionMessage("Please select GRN station"), "Please select GRN station message is not getting displayed");	
		purchaseRequisitionPage.selectFirstGRNStation();
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		assertTrue(purchaseRequisitionPage.verifyActionMessage("Quantity is 0 for following Items"), "Quantity is 0 for following Items, message is not getting displayed");	
		purchaseRequisitionPage.enterQuantityForSelectedItems();
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		purchaseRequisitionPage.clickOnYesButtonOnSaveConfirmationPopup();
		assertTrue(purchaseRequisitionPage.verifyPurchaseSavedSuccessMessage("Purchase requisition"), "Purchase requisition generated successfully message is not showing up");
		purchaseRequisitionPage.clickNoButtonOnPrintAlertPopup();
		purchaseRequisitionPage.clickOnClearButton();
		purchaseRequisitionPage.clickOnSearchButtonOnPurchaseRequisitionList();
		assertTrue(purchaseRequisitionPage.verifyPurchaseRequisitionPopupOpened(), "Purchase Requisition Popup is not getting opened");
		purchaseRequisitionPage.selectFirstPurchaseRequisitionFromPurchaseRequisitionPopup();
		purchaseRequisitionPage.selectTab("Drugs");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("4 QUIN EYE DROPS");
		purchaseRequisitionPage.enterQuantityForSelectedItems();
		purchaseRequisitionPage.clickOnModifyButton();
		purchaseRequisitionPage.clickOnYesButtonOnModifyAlertPopup();
		//assertTrue(purchaseRequisitionPage.verifyPurchaseReqModifiedSuccessPopup(), "Purchase Req Modified Success Popup is not showing up");


	}

	@Test(priority =7 ) //not fixed loading issue
	public void inventoryDirectIssueTest() throws Throwable 
	{
		test=extent.createTest("inventoryDirectIssueTest", "This test case verify the inventory Direct Issue Test");
		test.assignCategory("Front Office Inventory"); 

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");
		frontOfficeHomePage.clickOnIndentIssuesAndSelectAnOption("Direct Issue");
		indentItemsPage.clickOnSaveButtonOnDirectIssuePage();
		//assertTrue(indentItemsPage.verifyActionMessage("Please select facility"), "Please select atleast one Facility error message not displayed");
		indentItemsPage.selectToFacilityFromDropdownDirectIssuePage("TRIOTREE HOSPITAL");
		indentItemsPage.clickOnSaveButtonOnDirectIssuePage();
		assertTrue(indentItemsPage.verifyActionMessage("Please select store!"), "Please select store! error message not displayed");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectStoreFromDropdownDirectIssuePage("CATH LAB ");
		indentItemsPage.selectSmartSearchCheckboxDirectIssuePage();
		indentItemsPage.selectQOHTabDirectIssuePage();
		indentItemsPage.selectAllItemsTabDirectIssuePage();
		indentItemsPage.clickOnSaveButtonOnDirectIssuePage();
		assertTrue(indentItemsPage.verifyActionMessage("Please select an item!"), "Please select an item! error message not displayed");
		indentItemsPage.selectItemsDirectIssuePage("ALPHADOL-0.25 CAPSULE");
		indentItemsPage.clickOnClearButtonOnDirectIssuePage();
		indentItemsPage.selectSubstitudeDirectIssuePage("ABDOMINAL BINDER- LARGE");
		indentItemsPage.selectFirstBatchNoFromBatchDetailsDirectIssuePage();
		indentItemsPage.selectFirstBatchNoFromBatchDetailsDirectIssuePage();
		assertTrue(indentItemsPage.verifyActionMessage("Item already exists!"), "Item already exists! error message not displayed");
		indentItemsPage.selectConsumablesTabDirectIssuePage();
		indentItemsPage.selectItemsDirectIssuePage("3 PANEL CELL");
		indentItemsPage.selectBatchNoFromBatchDetailsDirectIssuePage("3SS523");
		indentItemsPage.selectBatchNoFromBatchDetailsDirectIssuePage("3SS523");
		assertTrue(indentItemsPage.verifyActionMessage("Item already exists!"), "Item already exists! error message not displayed");
		indentItemsPage.selectOthersTabDirectIssuePage();
		indentItemsPage.selectItemsDirectIssuePage("PAMPERS (SMALL)");
		indentItemsPage.selectBatchNoFromBatchDetailsDirectIssuePage("1111");
		indentItemsPage.selectBatchNoFromBatchDetailsDirectIssuePage("1111");
		assertTrue(indentItemsPage.verifyActionMessage("Item already exists!"), "Item already exists! error message not displayed");
		indentItemsPage.selectThirdSerialNumberDirectIssuePage();
		indentItemsPage.clickNoButtonOnDeletePopupDirectIssuePage();
		indentItemsPage.selectThirdSerialNumberDirectIssuePage();
		indentItemsPage.clickYesButtonOnDeletePopupDirectIssuePage();
		indentItemsPage.clickOnSaveButtonOnDirectIssuePage();
		assertTrue(indentItemsPage.verifyActionMessage("Issue Quantity cannot be blank!"), "Issue Quantity cannot be blank! error message not displayed");
		indentItemsPage.enterIssueQuantityDirectIssuePage("3 PANEL CELL", "10");
		indentItemsPage.enterIssueQuantityDirectIssuePage("ABDOMINAL BINDER- LARGE", "10");
		indentItemsPage.clickOnSaveButtonOnDirectIssuePage();
		indentItemsPage.clickNoButtonOnSavePopupDirectIssuePage();
		indentItemsPage.clickOnSaveButtonOnDirectIssuePage();
		indentItemsPage.clickYesButtonOnSavePopupDirectIssuePage();
		assertTrue(indentItemsPage.verifyActionMessage("saved successfully"), "Direct Issue is not saved");
		indentItemsPage.clickNoButtonOnPrintPopupDirectIssuePage();
		indentItemsPage.clickClearButtonOnheaderDirectIssuePage();
		indentItemsPage.enterFromDateDirectIssuePage("01/Jun/2019");
		indentItemsPage.enterToDateDirectIssuePage("07/Jun/2019");
		indentItemsPage.selectIssuedToFromDropdownDirectIssuePage("CATH LAB ");
		indentItemsPage.clickSearchButtonDirectIssuePage();
		indentItemsPage.clickOnFirstOrderFromSearchDirectIssuePage();

	}

	@Test(priority = 8) //fixed 17-04-2020
	public void inventoryDirectReceiptTest() throws Throwable {

		test=extent.createTest("inventoryDirectReceiptTest", "This test case verify the inventory Direct Receipt Test");
		test.assignCategory("Front Office Inventory");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("CATH LAB ");		
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Direct Receipt");

		indentItemsPage.searchAndSelectItemsDirectReceiptPage("ABFLO N TAB");
		indentItemsPage.searchAndSelectItemsDirectReceiptPage("MARKUP DRUG 12%");
		indentItemsPage.searchAndSelectItemsDirectReceiptPage("SP DRUG 5 %");
		indentItemsPage.selectConsumablesTabDirectReceiptPage();
		indentItemsPage.searchAndSelectItemsDirectReceiptPage("3 PANEL CELL");
		indentItemsPage.searchAndSelectItemsDirectReceiptPage("ABAZOLE 100ML IV");
		indentItemsPage.selectOthersTabDirectReceiptPage();
		indentItemsPage.searchAndSelectItemsDirectReceiptPage("GLUCON D ORANGE 100GM");
		indentItemsPage.clickDeleteButtonAgainstAnItem("ABAZOLE 100ML IV");
		indentItemsPage.clickNoButtonOnDeletePopupDirectReceiptPage();
		indentItemsPage.clickDeleteButtonAgainstAnItem("ABAZOLE 100ML IV");
		indentItemsPage.clickYesButtonOnDeletePopupDirectReceiptPage();
		indentItemsPage.clickCalculateButtonOnHeaderDirectReceiptPage();
		assertTrue(indentItemsPage.verifyActionMessage("Please enter receipt quantity"), "Please enter receipt quantity message not showing up");
		indentItemsPage.enterQuantityAgainstAnItem("ABFLO N TAB", "10");
		indentItemsPage.enterQuantityAgainstAnItem("MARKUP DRUG 12%", "10");
		indentItemsPage.enterQuantityAgainstAnItem("SP DRUG 5 %", "10");
		indentItemsPage.enterQuantityAgainstAnItem("3 PANEL CELL", "10");
		indentItemsPage.enterQuantityAgainstAnItem("GLUCON D ORANGE 100GM", "10");
		indentItemsPage.removePurRateAgainstAnItem("ABFLO N TAB");
		indentItemsPage.removePurRateAgainstAnItem("MARKUP DRUG 12%");
		indentItemsPage.removePurRateAgainstAnItem("SP DRUG 5 %");
		indentItemsPage.removePurRateAgainstAnItem("3 PANEL CELL");
		indentItemsPage.removePurRateAgainstAnItem("GLUCON D ORANGE 100GM");
		indentItemsPage.clickCalculateButtonOnHeaderDirectReceiptPage();
		assertTrue(indentItemsPage.verifyActionMessage("Please select batch number for following Items"), "Please select batch number for following Items message not showing up");
		indentItemsPage.enterPurRateAgainstAnItem("ABFLO N TAB", "25");
		indentItemsPage.enterPurRateAgainstAnItem("MARKUP DRUG 12%", "30");
		indentItemsPage.enterPurRateAgainstAnItem("SP DRUG 5 %", "35");
		indentItemsPage.enterPurRateAgainstAnItem("3 PANEL CELL", "40");
		indentItemsPage.enterPurRateAgainstAnItem("GLUCON D ORANGE 100GM", "45");
		indentItemsPage.removeMRPAgainstAnItem("ABFLO N TAB");
		//		indentItemsPage.removeMRPAgainstAnItem("MARKUP DRUG 12%");
		//		indentItemsPage.removeMRPAgainstAnItem("SP DRUG 5 %");
		indentItemsPage.removeMRPAgainstAnItem("3 PANEL CELL");
		indentItemsPage.removeMRPAgainstAnItem("GLUCON D ORANGE 100GM");
		indentItemsPage.enterMRPAgainstAnItem("ABFLO N TAB", "15");
		indentItemsPage.enterMRPAgainstAnItem("3 PANEL CELL", "55");
		indentItemsPage.enterMRPAgainstAnItem("GLUCON D ORANGE 100GM", "60");
		indentItemsPage.selectBatchTextBoxAgainstAnItemAndClosePopup("3 PANEL CELL");
		indentItemsPage.enterBatchTextBoxAgainstAnItemAndClosePopup("ABFLO N TAB", "Batch-Test1");
		indentItemsPage.enterBatchTextBoxAgainstAnItemAndClosePopup("MARKUP DRUG 12%", "Batch-Test2");
		indentItemsPage.enterBatchTextBoxAgainstAnItemAndClosePopup("SP DRUG 5 %", "Batch-Test3");
		indentItemsPage.enterBatchTextBoxAgainstAnItemAndClosePopup("3 PANEL CELL", "Batch-Test4");
		indentItemsPage.enterBatchTextBoxAgainstAnItemAndClosePopup("GLUCON D ORANGE 100GM", "Batch-Test5");
		indentItemsPage.clickCalculateButtonOnHeaderDirectReceiptPage();
		assertTrue(indentItemsPage.verifyActionMessage("Expiry date is earlier than current date"), "Expiry date is earlier than current date message not showing up");
		indentItemsPage.enterExpiryDateAgainstAnItem("ABFLO N TAB", "01/Jan/2030");
		indentItemsPage.enterExpiryDateAgainstAnItem("MARKUP DRUG 12%", "01/Jan/2030");
		indentItemsPage.enterExpiryDateAgainstAnItem("SP DRUG 5 %", "01/Jan/2030");
		indentItemsPage.enterExpiryDateAgainstAnItem("3 PANEL CELL", "01/Jan/2030");
		indentItemsPage.enterExpiryDateAgainstAnItem("GLUCON D ORANGE 100GM", "01/Jan/2030");
		indentItemsPage.clickCalculateButtonOnHeaderDirectReceiptPage();
		assertTrue(indentItemsPage.verifyActionMessage("MRP is less then Purchase rate"), "MRP is less then Purchase rate message not showing up");
		indentItemsPage.enterMRPAgainstAnItem("ABFLO N TAB", "50");
		indentItemsPage.enterMRPAgainstAnItem("3 PANEL CELL", "100");
		indentItemsPage.enterMRPAgainstAnItem("GLUCON D ORANGE 100GM", "101");
		indentItemsPage.clickCalculateButtonOnHeaderDirectReceiptPage();
		assertTrue(indentItemsPage.verifyActionMessage("Please enter MRP For "), "Please enter MRP For  message not showing up");
		indentItemsPage.enterMRPForSPMarkUpAgainstAnItem("MARKUP DRUG 12%", "200");
		indentItemsPage.enterMRPForSPMarkUpAgainstAnItem("SP DRUG 5 %", "10000");
		indentItemsPage.enterSGSTAgainstAnItem("ABFLO N TAB", "2.5");
		indentItemsPage.enterCGSTAgainstAnItem("ABFLO N TAB", "2.5");
		indentItemsPage.enterIGSTAgainstAnItem("ABFLO N TAB", "5");
		indentItemsPage.clickCalculateButtonOnHeaderDirectReceiptPage();
		assertTrue(indentItemsPage.verifyActionMessage("Tax value for SGST"), "Tax value for SGST message not showing up");
		indentItemsPage.removeSGSTAgainstAnItem("ABFLO N TAB");
		indentItemsPage.removeSGSTAgainstAnItem("MARKUP DRUG 12%");
		indentItemsPage.removeSGSTAgainstAnItem("SP DRUG 5 %");
		indentItemsPage.removeSGSTAgainstAnItem("3 PANEL CELL");
		indentItemsPage.removeSGSTAgainstAnItem("GLUCON D ORANGE 100GM");

		indentItemsPage.removeCGSTAgainstAnItem("ABFLO N TAB");
		indentItemsPage.removeCGSTAgainstAnItem("MARKUP DRUG 12%");
		indentItemsPage.removeCGSTAgainstAnItem("SP DRUG 5 %");
		indentItemsPage.removeCGSTAgainstAnItem("3 PANEL CELL");
		indentItemsPage.removeCGSTAgainstAnItem("GLUCON D ORANGE 100GM");

		indentItemsPage.removeIGSTAgainstAnItem("ABFLO N TAB");
		indentItemsPage.removeIGSTAgainstAnItem("MARKUP DRUG 12%");
		indentItemsPage.removeIGSTAgainstAnItem("SP DRUG 5 %");
		indentItemsPage.removeIGSTAgainstAnItem("3 PANEL CELL");
		indentItemsPage.removeIGSTAgainstAnItem("GLUCON D ORANGE 100GM");

		indentItemsPage.enterIGSTAgainstAnItem("ABFLO N TAB", "0");
		indentItemsPage.enterIGSTAgainstAnItem("MARKUP DRUG 12%", "0");
		indentItemsPage.enterIGSTAgainstAnItem("SP DRUG 5 %", "0");
		indentItemsPage.enterIGSTAgainstAnItem("3 PANEL CELL", "0");
		indentItemsPage.enterIGSTAgainstAnItem("GLUCON D ORANGE 100GM", "0");

		indentItemsPage.clickCalculateButtonOnHeaderDirectReceiptPage();
		indentItemsPage.clickSaveButtonOnHeaderDirectReceiptPage();
		indentItemsPage.clickNoButtonOnSavePopupDirectReceiptPage();
		indentItemsPage.clickSaveButtonOnHeaderDirectReceiptPage();
		indentItemsPage.clickYesButtonOnSavePopupDirectReceiptPage();
		indentItemsPage.clickNoButtonOnPrintPopupDirectReceiptPage();		
	}

	@Test(priority = 9) //fixed 17-04-2020
	public void purchaseRequisitionApprovalTest() throws Throwable {
		test=extent.createTest("purchaseRequisitionApprovalTest", "This test case verify the purchase Requisition Approval Test");
		test.assignCategory("Front Office Inventory");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");
		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Requisition Approval");
		purchaseRequisitionPage.enterFromDatePurchaseRequisitionApprovalPage("28-Mar-2019");
		purchaseRequisitionPage.enterToDatePurchaseRequisitionApprovalPage("16-Jan-2020");
		purchaseRequisitionPage.selectCheckboxPurchaseRequisitionApprovalPage("New Requisitions");
		assertTrue(purchaseRequisitionPage.verifyResultsPopupIsDispalyed("NEW REQUISITION(S)"), "NEW REQUISITION(S) popup is not showing up");
		purchaseRequisitionPage.selectFirstValueFromResults();
		purchaseRequisitionPage.clickEditBtnPurchaseRequisitionApprovalPage();		
		purchaseRequisitionPage.enterQuantityAgainstAnItem("A TO Z NS SYP 200 ML", "30");
		purchaseRequisitionPage.enterQuantityAgainstAnItem("AB - FLO TAB", "30");
		purchaseRequisitionPage.enterQuantityAgainstAnItem("AB PHYLLINE CAP", "30");
		purchaseRequisitionPage.enterQuantityAgainstAnItem("ABDOMINAL BINDER- LARGE", "30");
		purchaseRequisitionPage.enterQuantityAgainstAnItem("ABDOMINAL BINDER- MEDIUM", "30");
		purchaseRequisitionPage.enterQuantityAgainstAnItem("ABDOMINAL BINDER- SMALL", "40");
		purchaseRequisitionPage.enterQuantityAgainstAnItem("PAMPERS (SMALL)", "40");
		purchaseRequisitionPage.enterQuantityAgainstAnItem("GLUCON D ORANGE 100GM", "40");		
		purchaseRequisitionPage.clickAcceptBtnPurchaseRequisitionApprovalPage();
		assertTrue(purchaseRequisitionPage.verifyApprovalPopupIsDisplayed(), "Approval Popup Is Not Displayed");
		purchaseRequisitionPage.clickNoButtonOnApprovePopup();
		purchaseRequisitionPage.clickAcceptBtnPurchaseRequisitionApprovalPage();
		assertTrue(purchaseRequisitionPage.verifyApprovalPopupIsDisplayed(), "Approval Popup Is Not Displayed");
		purchaseRequisitionPage.clickYesButtonOnApprovePopup();
		assertTrue(indentItemsPage.verifyActionMessage("Requisition approved!"), "Requisition approved! message not showing up");
		driver.pauseExecutionFor(10000);		
		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Requisition Approval");
		purchaseRequisitionPage.enterFromDatePurchaseRequisitionApprovalPage("28-Mar-2019");
		purchaseRequisitionPage.enterToDatePurchaseRequisitionApprovalPage("16-Jan-2020");
		purchaseRequisitionPage.selectCheckboxPurchaseRequisitionApprovalPage("Approved Requisitions");
		assertTrue(purchaseRequisitionPage.verifyResultsPopupIsDispalyed("APPROVED REQUISITION(S)"), "APPROVED REQUISITION(S) popup is not showing up");
		purchaseRequisitionPage.selectFirstValueFromResults();		
		purchaseRequisitionPage.enterFromDatePurchaseRequisitionApprovalPage("28-Mar-2019");
		purchaseRequisitionPage.enterToDatePurchaseRequisitionApprovalPage("16-Jan-2020");
		purchaseRequisitionPage.selectCheckboxPurchaseRequisitionApprovalPage("New Requisitions");
		assertTrue(purchaseRequisitionPage.verifyResultsPopupIsDispalyed("NEW REQUISITION(S)"), "NEW REQUISITION(S) popup is not showing up");
		purchaseRequisitionPage.selectFirstValueFromResults();
		purchaseRequisitionPage.clickRejectBtnPurchaseRequisitionApprovalPage();
		assertTrue(indentItemsPage.verifyActionMessage("Please enter reason for rejection!"), "Please enter reason for rejection! message not showing up");
		purchaseRequisitionPage.clickEditBtnPurchaseRequisitionApprovalPage();
		purchaseRequisitionPage.enterRemarksPurchaseRequisitionApprovalPage();
		purchaseRequisitionPage.clickRejectBtnPurchaseRequisitionApprovalPage();		
		assertTrue(purchaseRequisitionPage.verifyRejectionPopupIsDisplayed(), "Rejection Popup Is Not Displayed");
		purchaseRequisitionPage.clickNoButtonOnRejectPopup();
		purchaseRequisitionPage.clickRejectBtnPurchaseRequisitionApprovalPage();
		purchaseRequisitionPage.clickYesButtonOnRejectPopup();
		assertTrue(indentItemsPage.verifyActionMessage("Requistion has been rejected"), "Requistion has been rejected. message not showing up");
		frontOfficeHomePage.expandMenu();
		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Requisition Approval");
		purchaseRequisitionPage.enterFromDatePurchaseRequisitionApprovalPage("28-Mar-2019");
		purchaseRequisitionPage.enterToDatePurchaseRequisitionApprovalPage("16-Jan-2020");
		purchaseRequisitionPage.selectCheckboxPurchaseRequisitionApprovalPage("Rejected Requistions");
		assertTrue(purchaseRequisitionPage.verifyResultsPopupIsDispalyed("REJECTED REQUISITION(S)"), "REJECTED REQUISITION(S) popup is not showing up");
		purchaseRequisitionPage.selectFirstValueFromResults();
	}

	@Test(priority = 10) //fixed 28-04-2020
	public void inventoryIndentIssueWithManualModeTest() throws Throwable 
	{
		test=extent.createTest("inventoryIndentIssueWithManualModeTest", "This test case verify the inventory Indent Issue With Manual Mode Test");
		test.assignCategory("Front Office Inventory");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);


		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("CATH LAB ");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Items");
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please select atleast one Facility"), "Please select atleast one Facility error message not displayed");
		indentItemsPage.selectToFacilityFromDropdown("TRIOTREE HOSPITAL");
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please select Department!"), "Please select Department! error message not displayed");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectToDepartmentFromDropdown("Central Medicine Store");
		indentItemsPage.selectSmartSearchCheckbox();
		indentItemsPage.clickOnRefreshStockLabel();
		assertTrue(indentItemsPage.verifyActionMessage("Calculation for all item completed successfully!"), "Calculation for all item completed successfully! action message not displayed");
		driver.pauseExecutionFor(15000);
		purchaseRequisitionPage.selectInventory("QOH<ROL");
		driver.pauseExecutionFor(6000);
		purchaseRequisitionPage.selectInventory("QOH>ROL");
		driver.pauseExecutionFor(6000);
		purchaseRequisitionPage.selectInventory("ALL ITEMS");

		indentItemsPage.selectMedicines("A TO Z NS SYP 200 ML");
		indentItemsPage.selectMedicines("AB - FLO TAB");
		indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		assertTrue(indentItemsPage.verifyActionMessage("already selected"), "already selected Item action message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicineTab();



		indentItemsPage.selectMedicines("AHAGLOW S SPRAY");
		assertTrue(indentItemsPage.verifyActionMessage("This is Discontinued Item and Stock at other store"), "Discontinued Medicine Error message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicines("ABDOMINAL BINDER- LARGE");
		indentItemsPage.selectMedicines("ABDOMINAL BELT -X-LARGE");
		indentItemsPage.selectMedicines("ABDOMINAL DRAIN KIT NO. 16");
		indentItemsPage.selectMedicines("ABDOMINAL DRAIN KIT NO. 16");
		assertTrue(indentItemsPage.verifyActionMessage("already selected"), "already selected Item action message not displayed");
		purchaseRequisitionPage.selectTab("Others");
		indentItemsPage.selectMedicines("PAMPERS (SMALL)");
		indentItemsPage.selectMedicines("GLUCON D ORANGE 100GM");
		indentItemsPage.selectMedicines("PAMPERS PANTS 8PC LARGE");

		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please enter quantity for following Items"), "Please enter quantity for following Items message is not getting displayed");	
		purchaseRequisitionPage.deleteSelectedItemFromBlowGrid("PAMPERS PANTS 8PC LARGE");

		indentItemsPage.enterQuantityForSelectedMedicines();
		indentItemsPage.enterRemarksForSelectedMedicines();
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.isSavePopupShowing(), "Do you want to save popup not showing up");
		indentItemsPage.clickYesOnSaveButton();
		indentItemsPage.enterFromDateIntendItemsScreen("04/Jan/2020");
		//		indentItemsPage.enterToDateIntendItemsScreen("11/Jan/2020");
		indentItemsPage.clickOnNewRadioButton();
		assertTrue(indentItemsPage.isNewIndentPopupDisplayed(), "New Indent Popup is not displayed");
		indentItemsPage.selectFirstIndentFromPopup();
		driver.pauseExecutionFor(5000);
		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("8 X SHAMPOO");
		driver.pauseExecutionFor(5000);
		indentItemsPage.enterQuantityForNewMedicines();
		indentItemsPage.enterRemarksForSelectedNewMedicines();
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.clickYesOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Indent modified successfully"), "Indent modified successfully message not displayed");

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Approval");
		indentApprovalPage.clickOnApproveButton();
		assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Approve button without selecting any Indent");
		indentApprovalPage.clickOnRejectButton();
		assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Reject button without selecting any Indent");
		indentApprovalPage.clickOnRefreshButton();
		indentApprovalPage.enterFromDate("01/Mar/2019");		
		indentApprovalPage.clickOnNewIndentRadioButton();
		try {
			String indentNoFromNewIndent = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		}
		catch (Exception e) {
		}
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z NS SYP 200 ML", "20");
		indentApprovalPage.clickOnApproveButton();
		indentApprovalPage.clickOnYesButtonOnApprovalConfirmationPopup();
		driver.pauseExecutionFor(4000);

		indentApprovalPage.enterFromDate("01/Mar/2019");		
		indentApprovalPage.clickOnNewIndentRadioButton();
		try {
			String indentNoFromNewIndent1 = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		}
		catch (Exception e) {

		}
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z NS SYP 200 ML", "30");
		indentApprovalPage.clickOnRejectButton();
		indentApprovalPage.clickOnYesButtonOnRejectionConfirmationPopup();
		driver.pauseExecutionFor(4000);
		indentApprovalPage.enterFromDate("01/Mar/2019");
		indentApprovalPage.selectStore("IVF");
		indentApprovalPage.clickOnNewIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.selectStore("IVF");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.selectStore("IVF");
		indentApprovalPage.clickOnRejectedIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.enterFromDate("25/Mar/2019");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		try {
			String indentNoFromApproveIndent = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		}
		catch (Exception e) {}
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");
		indentApprovalPage.enterFromDate("18/Mar/2019");
		indentApprovalPage.clickOnRejectedIndentRadioButton();
		//indentApprovalPage.selectFirstIndentFromRejectedIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");

		indentApprovalPage.enterFromDate("25/Mar/2019");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		try {
			String indentNoFromApproveIndent2 = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");
		indentApprovalPage.enterFromDate("25/Mar/2019");
		indentApprovalPage.clickOnRejectedIndentRadioButton();
		//indentApprovalPage.selectFirstIndentFromRejectedIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnHomeIcon();

		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");
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

	@Test(priority = 11) //fixed 27-04-2020
	public void purchaseOrderWithoutPRWithFreeItemsTest() throws Throwable {
		test=extent.createTest("purchaseOrderWithoutPRWithFreeItemsTest", "This test case verify the purchase Order Without PR With Free Items Test");
		test.assignCategory("Front Office Inventory");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");
		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Order");
		purchaseRequisitionPage.clickSaveButtonOnPurchaseOrderPage();
		assertTrue(indentItemsPage.verifyActionMessage("PO terms not defined"), "PO terms not defined message not displayed");
		purchaseRequisitionPage.clickCalculateButtonOnPurchaseOrderPage();
		assertTrue(indentItemsPage.verifyActionMessage("Item not found"), "Item not found! message not displayed");
		purchaseRequisitionPage.selectSuppliersFromPurchaseOrderPage("A.D AGENCIES");
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("A TO Z NS SYP 200 ML");
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("AB PHYLLINE CAP");
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("AB - FLO TAB");
		assertTrue(indentItemsPage.verifyActionMessage("Scheme exists"), "Scheme exists for the following items message not displayed");
		purchaseRequisitionPage.clickSchemeButtonOnPurchaseOrderPage();
		assertTrue(indentItemsPage.verifyActionMessage("Scheme exists for the following items"), "Scheme exists for the following items message not displayed");
		purchaseRequisitionPage.clickConsumablesTabOnPurchaseOrderPage();
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("ABDOMINAL BINDER- LARGE");
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("ABDOMINAL BINDER- MEDIUM");
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("ABDOMINAL BINDER- SMALL");
		purchaseRequisitionPage.clickOtherTabOnPurchaseOrderPage();
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("PAMPERS (SMALL)");
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("GLUCON D ORANGE 100GM");
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("SAT-ISABGOL 100GM POWDER");
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("SAT-ISABGOL 100GM POWDER");
		assertTrue(indentItemsPage.verifyActionMessage("ISABGOL"), "already selected message not displayed");
		purchaseRequisitionPage.clickOnItemCode("SYP0663");
		assertTrue(purchaseRequisitionPage.isDeletePopupDisplayedOnPurchaseOrderPage(), "Delete Popup is not displayed");
		purchaseRequisitionPage.clickNoOnDeletePopupOnPurchaseOrderPage();
		purchaseRequisitionPage.clickOnItemCode("SYP0663");
		assertTrue(purchaseRequisitionPage.isDeletePopupDisplayedOnPurchaseOrderPage(), "Delete Popup is not displayed");
		purchaseRequisitionPage.clickYesOnDeletePopupOnPurchaseOrderPage();
		purchaseRequisitionPage.clickSaveButtonOnPurchaseOrderPage();
		assertTrue(indentItemsPage.verifyActionMessage("for following Item"), "for following Item message not displayed");
		driver.pauseExecutionFor(3000);
		assertTrue(purchaseRequisitionPage.isSavePopupDisplayedOnPurchaseOrderPage(), "Save Popup is not displayed");
		driver.pauseExecutionFor(3000);
		purchaseRequisitionPage.clickNoOnSavePopupOnPurchaseOrderPage();
		purchaseRequisitionPage.clickCalculateButtonOnPurchaseOrderPage();
		assertTrue(indentItemsPage.verifyActionMessage("for following Item"), "QUantity is zero for following Item message not displayed");
		purchaseRequisitionPage.clickFreeButtonAgainstItem("AB - FLO TAB");
		assertTrue(purchaseRequisitionPage.isFreeItemsPopupDisplayedOnPurchaseOrderPage(), "Free Items Popup not displayed");
		purchaseRequisitionPage.closeFreeItemsPopup();
		purchaseRequisitionPage.clickFreeButtonAgainstItem("AB - FLO TAB");
		assertTrue(purchaseRequisitionPage.isFreeItemsPopupDisplayedOnPurchaseOrderPage(), "Free Items Popup not displayed");
		purchaseRequisitionPage.clickSameItemRadioButton();
		purchaseRequisitionPage.clickPurchaseDetailsTab();
		purchaseRequisitionPage.clickFreeButtonAgainstItem("AB PHYLLINE CAP");
		purchaseRequisitionPage.clickDifferentItemRadioButton();
		purchaseRequisitionPage.clickMedicineTabOnPurchaseOrderPage();
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("ABFLO N TAB");
		purchaseRequisitionPage.clickCalculateButtonOnPurchaseOrderPage();
		assertTrue(indentItemsPage.verifyActionMessage("for following Item"), "Please enter Quantity for following Item message not displayed");
		purchaseRequisitionPage.enterFreeQuantityForSelectedMedicinesOnPurchaseOrderPage();
		purchaseRequisitionPage.clickPurchaseDetailsTab();
		purchaseRequisitionPage.enterQuantityForSelectedMedicinesOnPurchaseDetailsTabS();
		purchaseRequisitionPage.enterRPUForSelectedMedicinesOnPurchaseDetailsTabS();
		purchaseRequisitionPage.clickCalculateButtonOnPurchaseOrderPage();
		purchaseRequisitionPage.clickSaveButtonOnPurchaseOrderPage();
		driver.pauseExecutionFor(6000);
		purchaseRequisitionPage.clickYesOnSavePopupOnPurchaseOrderPage();
		driver.pauseExecutionFor(6000);
		assertTrue(purchaseRequisitionPage.isPrintPopupDisplayedOnPurchaseOrderPage(), "Print popup is not displayed");
		purchaseRequisitionPage.clickNoButtonPrintPopupOnPurchaseOrderPage();
		purchaseRequisitionPage.clickNoButtonOnPlaceMoreOrderPopupOnPurchaseOrderPage();
		purchaseRequisitionPage.clickPendingForApprovalRadioButton();
		purchaseRequisitionPage.selectFirstPurchaseOrderFromPurchaseOrderPopup();
		purchaseRequisitionPage.checkSmartCheckbox();
		purchaseRequisitionPage.searchItemsPurchaseOrderPageAndVerifyItsSearchable("4 QUIN KT EYE DROPS");
		purchaseRequisitionPage.enterQuantityForSelectedMedicinesOnPurchaseDetailsTabS("4 QUIN KT EYE DROPS");
		purchaseRequisitionPage.enterRPUForSelectedMedicinesOnPurchaseDetailsTabS("4 QUIN KT EYE DROPS");
		purchaseRequisitionPage.clickSaveButtonOnPurchaseOrderPage();
		assertTrue(purchaseRequisitionPage.isApprovalProcessPopupDisplayedOnPurchaseOrderPage(), "Approval Process Popup is not displayed");
		purchaseRequisitionPage.clickNoButtonApprovalProcessPopupOnPurchaseOrderPage();
		purchaseRequisitionPage.clickSaveButtonOnPurchaseOrderPage();
		assertTrue(purchaseRequisitionPage.isApprovalProcessPopupDisplayedOnPurchaseOrderPage(), "Approval Process Popup is not displayed");
		purchaseRequisitionPage.clickYesButtonApprovalProcessPopupOnPurchaseOrderPage();
		assertTrue(purchaseRequisitionPage.isSavePopupDisplayedOnPurchaseOrderPage(), "Save Popup is not displayed");
		driver.pauseExecutionFor(3000);
		purchaseRequisitionPage.clickYesOnSavePopupOnPurchaseOrderPage();

	}

	@Test(priority =12 ) //fixed 27-04-2020
	public void inventoryPurchaseReqiuistionWithoutIndentsTest() throws Throwable {
		test=extent.createTest("inventoryPurchaseReqiuistionWithoutIndentsTest", "This test case verify the inventory Purchase Reqiuistion Without Indents Test");
		test.assignCategory("Front Office Inventory");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");
		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Requisition");
		purchaseRequisitionPage.selectInventory("Refresh Stock Level");
		assertTrue(purchaseRequisitionPage.verifyActionMessage("Calculation for all items completed successfully"), "Calculation for all items completed successfully! Message not showing up");
		driver.pauseExecutionFor(3000);
		purchaseRequisitionPage.selectInventory("QOH <ROL");
		driver.pauseExecutionFor(3000);
		purchaseRequisitionPage.selectInventory("QOH >ROL");
		driver.pauseExecutionFor(3000);
		purchaseRequisitionPage.selectInventory("All Items");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("A TO Z NS SYP 200 ML");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("AB - FLO TAB");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("AB PHYLLINE CAP");
		purchaseRequisitionPage.selectTab("Medical Consumables");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("ABDOMINAL BINDER- LARGE");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("ABDOMINAL BINDER- MEDIUM");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("ABDOMINAL BINDER- SMALL");
		purchaseRequisitionPage.selectTab("General and Miscellaneous");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("PAMPERS (SMALL)");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("GLUCON D ORANGE 100GM");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("PAMPERS PANTS 8PC LARGE");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("PAMPERS PANTS 8PC LARGE");
		assertTrue(purchaseRequisitionPage.verifyActionMessage("PAMPERS PANTS 8PC LARGE already selected"), "Duplicate Item is getting selected and error message is not getting thrown");	
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		assertTrue(purchaseRequisitionPage.verifyActionMessage("Please select GRN station"), "Please select GRN station message is not getting displayed");	
		purchaseRequisitionPage.selectFirstGRNStation();
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		assertTrue(purchaseRequisitionPage.verifyActionMessage("Quantity is 0 for following Items"), "Quantity is 0 for following Items, message is not getting displayed");	
		purchaseRequisitionPage.enterQuantityForSelectedItems();
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		purchaseRequisitionPage.clickOnYesButtonOnSaveConfirmationPopup();
		assertTrue(purchaseRequisitionPage.verifyPurchaseSavedSuccessMessage("Purchase requisition"), "Purchase requisition generated successfully message is not showing up");
		purchaseRequisitionPage.clickNoButtonOnPrintAlertPopup();
		purchaseRequisitionPage.clickOnClearButton();
		purchaseRequisitionPage.clickOnSearchButtonOnPurchaseRequisitionList();
		assertTrue(purchaseRequisitionPage.verifyPurchaseRequisitionPopupOpened(), "Purchase Requisition Popup is not getting opened");
		purchaseRequisitionPage.selectFirstPurchaseRequisitionFromPurchaseRequisitionPopup();
		purchaseRequisitionPage.selectTab("Drugs");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("4 QUIN EYE DROPS");
		purchaseRequisitionPage.enterQuantityForSelectedItems();
		purchaseRequisitionPage.clickOnModifyButton();
		purchaseRequisitionPage.clickOnYesButtonOnModifyAlertPopup();
		//assertTrue(purchaseRequisitionPage.verifyPurchaseReqModifiedSuccessPopup(), "Purchase Req Modified Success Popup is not showing up");


	}

	@Test(priority = 13)
	public void inventoryAcknowledgereturnTest() throws Throwable {
		test=extent.createTest("inventoryWithIndentApprovalTest", "This test case verify the inventory With Indent Approval Test");
		test.assignCategory("Front Office Inventory");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage=new IndentIssuePage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");
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

	@Test(priority = 14)
	public void Inventoryindentclosuretestcase() throws InterruptedException {

		test=extent.createTest("Inventoryindentclosuretestcase", "This test case verify the Inventory Indent Closure Test Case");
		test.assignCategory("Front Office Inventory");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("CATH LAB ");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Items");
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please select atleast one Facility"), "Please select atleast one Facility error message not displayed");
		indentItemsPage.selectToFacilityFromDropdown("TRIOTREE HOSPITAL");
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please select Department!"), "Please select Department! error message not displayed");
		driver.pauseExecutionFor(7000);
		indentItemsPage.selectToDepartmentFromDropdown("Central Medicine Store");
		indentItemsPage.selectSmartSearchCheckbox();
		indentItemsPage.clickOnRefreshStockLabel();
		assertTrue(indentItemsPage.verifyActionMessage("Calculation for all item completed successfully!"), "Calculation for all item completed successfully! action message not displayed");
		driver.pauseExecutionFor(15000);
		purchaseRequisitionPage.selectInventory("QOH<ROL");
		driver.pauseExecutionFor(6000);
		purchaseRequisitionPage.selectInventory("QOH>ROL");
		driver.pauseExecutionFor(6000);
		purchaseRequisitionPage.selectInventory("ALL ITEMS");

		indentItemsPage.selectMedicines("A TO Z NS SYP 200 ML");
		indentItemsPage.selectMedicines("AB - FLO TAB");
		indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		indentItemsPage.selectMedicines("AB PHYLLINE CAP");
		assertTrue(indentItemsPage.verifyActionMessage("already selected"), "already selected Item action message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicineTab();



		indentItemsPage.selectMedicines("AHAGLOW S SPRAY");
		assertTrue(indentItemsPage.verifyActionMessage("This is Discontinued Item and Stock at other store"), "Discontinued Medicine Error message not displayed");
		indentItemsPage.selectConsumablesTab();
		indentItemsPage.selectMedicines("ABDOMINAL BINDER- LARGE");
		indentItemsPage.selectMedicines("ABDOMINAL BELT -X-LARGE");
		indentItemsPage.selectMedicines("ABDOMINAL DRAIN KIT NO. 16");
		indentItemsPage.selectMedicines("ABDOMINAL DRAIN KIT NO. 16");
		assertTrue(indentItemsPage.verifyActionMessage("already selected"), "already selected Item action message not displayed");
		purchaseRequisitionPage.selectTab("Others");
		indentItemsPage.selectMedicines("PAMPERS (SMALL)");
		indentItemsPage.selectMedicines("GLUCON D ORANGE 100GM");
		indentItemsPage.selectMedicines("PAMPERS PANTS 8PC LARGE");

		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.verifyActionMessage("Please enter quantity for following Items"), "Please enter quantity for following Items message is not getting displayed");	
		purchaseRequisitionPage.deleteSelectedItemFromBlowGrid("PAMPERS PANTS 8PC LARGE");

		indentItemsPage.enterQuantityForSelectedMedicines();
		indentItemsPage.enterRemarksForSelectedMedicines();
		indentItemsPage.clickOnSaveButton();
		assertTrue(indentItemsPage.isSavePopupShowing(), "Do you want to save popup not showing up");
		indentItemsPage.clickYesOnSaveButton();
		indentItemsPage.enterFromDateIntendItemsScreen("04/Jan/2020");
		//		indentItemsPage.enterToDateIntendItemsScreen("11/Jan/2020");
		indentItemsPage.clickOnNewRadioButton();
		assertTrue(indentItemsPage.isNewIndentPopupDisplayed(), "New Indent Popup is not displayed");
		indentItemsPage.selectFirstIndentFromPopup();
		driver.pauseExecutionFor(5000);
		indentItemsPage.selectMedicineTab();
		indentItemsPage.selectMedicines("8 X SHAMPOO");
		driver.pauseExecutionFor(5000);
		indentItemsPage.enterQuantityForNewMedicines();
		indentItemsPage.enterRemarksForSelectedNewMedicines();
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.clickYesOnSaveButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Indent modified successfully"), "Indent modified successfully message not displayed");

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("Indent Approval");
		indentApprovalPage.clickOnApproveButton();
		assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Approve button without selecting any Indent");
		indentApprovalPage.clickOnRejectButton();
		assertTrue(indentApprovalPage.verifyActionMessage("Please select item!"), "Please Select item message is not displaying after clickon on Reject button without selecting any Indent");
		indentApprovalPage.clickOnRefreshButton();
		indentApprovalPage.enterFromDate("01/Mar/2019");		
		indentApprovalPage.clickOnNewIndentRadioButton();
		try {
			String indentNoFromNewIndent = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		}
		catch (Exception e) {
		}
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z NS SYP 200 ML", "20");
		indentApprovalPage.clickOnApproveButton();
		indentApprovalPage.clickOnYesButtonOnApprovalConfirmationPopup();
		driver.pauseExecutionFor(4000);

		indentApprovalPage.enterFromDate("01/Mar/2019");		
		indentApprovalPage.clickOnNewIndentRadioButton();
		try {
			String indentNoFromNewIndent1 = indentApprovalPage.getValueOfIndentNoFromNewIndentPopup();
		}
		catch (Exception e) {

		}
		indentApprovalPage.selectFirstIndentFromNewIntendPopup();
		indentApprovalPage.changeQuantityAgainSelectedItem("A TO Z NS SYP 200 ML", "30");
		indentApprovalPage.clickOnRejectButton();
		indentApprovalPage.clickOnYesButtonOnRejectionConfirmationPopup();
		driver.pauseExecutionFor(4000);
		indentApprovalPage.enterFromDate("01/Mar/2019");
		indentApprovalPage.selectStore("IVF");
		indentApprovalPage.clickOnNewIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.selectStore("IVF");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.selectStore("IVF");
		indentApprovalPage.clickOnRejectedIndentRadioButton();
		//assertTrue(indentItemsPage.verifyActionMessage("Records Found"), "No Records Found message not displayed");
		indentApprovalPage.enterFromDate("25/Mar/2019");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		try {
			String indentNoFromApproveIndent = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		}
		catch (Exception e) {}
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");
		indentApprovalPage.enterFromDate("18/Mar/2019");
		indentApprovalPage.clickOnRejectedIndentRadioButton();

		indentApprovalPage.enterFromDate("25/Mar/2019");
		indentApprovalPage.clickOnApprovedIndentRadioButton();
		try {
			String indentNoFromApproveIndent2 = indentApprovalPage.getValueOfIndentNoFromApproveIndentPopup();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		indentApprovalPage.selectFirstIndentFromApproveIntendPopup();
		//assertTrue(indentApprovalPage.verifyIntendCanNotBeModified(), "Approved Indent can be modified");
		indentApprovalPage.enterFromDate("25/Mar/2019");
		indentApprovalPage.clickOnRejectedIndentRadioButton();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnHomeIcon();

		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");
		frontOfficeHomePage.clickOnIndentIssuesAndSelectAnOption("Indent Issue");

	}

	@Test(priority =15)
	public void InventorywithOPBillabeConsumption1TestCase() throws InterruptedException 
	{
		test=extent.createTest("InventorywithOPBillabeConsumption1TestCase", "This test case is verifies Patient Registration Valid Data");
		test.assignCategory("Front Office Inventory");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);
		indentIssuePage = new IndentIssuePage(driver);


		System.out.println("idCard>>>>"+idCard);
		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnNo("Front Office");
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown("Mr.");
		patientRegistrationPage.enterFirstName("Automation");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
		patientRegistrationPage.enterAge("16");
		assertTrue(patientRegistrationPage.verifyLesserAgeAlertMessage("Please enter Date of Birth Age is less than 18 year"), "System is not throwing lesser age than 18 years message");
		patientRegistrationPage.enterAge("23");
		patientRegistrationPage.selectMartialStatusFromDropDown("Single");
		patientRegistrationPage.enterMotherMaidenName("Automation Test Mother");
		patientRegistrationPage.enterFathersName("AutomationFather@123 ");
		patientRegistrationPage.selectNationalityFromDropDown("Indian");
		patientRegistrationPage.checkVipCheckBoxAndEnterData("This VIP Data has been added by Test Automation Scripts");
		patientRegistrationPage.checkRemarksCheckBoxAndEnterData("This Remarks Data has been added by Test Automation Scripts");
		patientRegistrationPage.checkNRIChecbox();
		assertTrue(patientRegistrationPage.verifyIDCardDropDownIsEnabled(), "After checking NRI Checkbox, ID Card Dropdown is not getting enabled");
		patientRegistrationPage.selectIdCardTypeFromDropDown(idCard);
		patientRegistrationPage.enterNationalID("12345");
		patientRegistrationPage.enterTelephoneNumber("1234567891011123");
		patientRegistrationPage.enterMobileNumber("12345");
		patientRegistrationPage.clickOnRegisterIcon();
		assertTrue(patientRegistrationPage.verifyInvalidMobileNoAlertMessage("mobile number should not be less than 10 digit"), "Alert not showing up when invalid mobile No is added");
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Automation Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur", "247001");
		patientRegistrationPage.enterEmailId("%^%^%^%^");
		patientRegistrationPage.clickOnRegisterIcon();
		//assertTrue(patientRegistrationPage.verifyInvalidEmailIdAlertMessage("Please enter correct email Id!"), "Invalid Email ID is getting accepted by the system");
		patientRegistrationPage.enterEmailId("test@automation.com");
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
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("CATH LAB ");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("OP Billable Consumption");
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.EnterUHIDnumber(patientRegistrationId);
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.selectDoctorName("Ajeet Jain");
		indentItemsPage.clickonZeroStockItems();
		indentItemsPage.selectdrugandconsumables("AB - FLO TAB ");
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
		indentItemsPage.selectDoctorName("Ajeet Jain");
		indentItemsPage.enterFromDateItemReceiptScreen("03/Apr/2020");
		indentItemsPage.opbillableTODate("01/May/2020");
		indentItemsPage.clickonsearchButton();
		indentItemsPage.clickonpatientdetails();
		indentItemsPage.clickoncancelbutton();
		indentItemsPage.clickoncancelcheckbox();
		indentItemsPage.clickoncancelbutton();
		indentItemsPage.clickonNoSaverecord();
		indentItemsPage.EnterUHIDnumber(patientRegistrationId);
		indentItemsPage.selectDoctorName("Ajeet Jain");
		indentItemsPage.enterFromDateItemReceiptScreen("03/Apr/2020");
		indentItemsPage.opbillableTODate("01/May/2020");
		indentItemsPage.clickonsearchButton();
		indentItemsPage.clickonpatientdetails();
		indentItemsPage.clickoncancelbutton();
		indentItemsPage.clickoncancelcheckbox();
		indentItemsPage.clickoncancelbutton();
		indentItemsPage.clickonYesSaverecord();
		indentItemsPage.clickonconsumptioncancelOKbutton();
	}

	@Test(priority =16)
	public void InventoryGRNTestCase() throws InterruptedException 
	{
		test=extent.createTest("InventoryGRNTestCase", "This test case verify the Inventory GRN Test Case");
		test.assignCategory("Front Office Inventory");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");
		frontOfficeHomePage.clickOnPurchaseOrderAndSelectAnOption("Purchase Requisition");
		purchaseRequisitionPage.selectInventory("Refresh Stock Level");
		assertTrue(purchaseRequisitionPage.verifyActionMessage("Calculation for all items completed successfully"), "Calculation for all items completed successfully! Message not showing up");
		driver.pauseExecutionFor(3000);
		purchaseRequisitionPage.selectInventory("QOH <ROL");
		driver.pauseExecutionFor(3000);
		purchaseRequisitionPage.selectInventory("QOH <ROL");
		driver.pauseExecutionFor(3000);
		purchaseRequisitionPage.selectInventory("All Items");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("A TO Z NS SYP 200 ML");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("AB - FLO TAB");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("AB PHYLLINE CAP");
		purchaseRequisitionPage.selectTab("Medical Consumables");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("ABDOMINAL BINDER- LARGE");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("ABDOMINAL BINDER- MEDIUM");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("ABDOMINAL BINDER- SMALL");
		purchaseRequisitionPage.selectTab("General and Miscellaneous");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("PAMPERS (SMALL)");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("GLUCON D ORANGE 100GM");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("PAMPERS PANTS 8PC LARGE");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("PAMPERS PANTS 8PC LARGE");
		assertTrue(purchaseRequisitionPage.verifyActionMessage("PAMPERS PANTS 8PC LARGE already selected"), "Duplicate Item is getting selected and error message is not getting thrown");	
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		assertTrue(purchaseRequisitionPage.verifyActionMessage("Please select GRN station"), "Please select GRN station message is not getting displayed");	
		purchaseRequisitionPage.selectFirstGRNStation();
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		assertTrue(purchaseRequisitionPage.verifyActionMessage("Quantity is 0 for following Items"), "Quantity is 0 for following Items, message is not getting displayed");	
		purchaseRequisitionPage.enterQuantityForSelectedItems();
		purchaseRequisitionPage.clickOnSaveFloppyIcon();
		purchaseRequisitionPage.clickOnYesButtonOnSaveConfirmationPopup();
		assertTrue(purchaseRequisitionPage.verifyPurchaseSavedSuccessMessage("Purchase requisition"), "Purchase requisition generated successfully message is not showing up");
		purchaseRequisitionPage.clickNoButtonOnPrintAlertPopup();
		purchaseRequisitionPage.clickOnClearButton();
		purchaseRequisitionPage.clickOnSearchButtonOnPurchaseRequisitionList();
		assertTrue(purchaseRequisitionPage.verifyPurchaseRequisitionPopupOpened(), "Purchase Requisition Popup is not getting opened");
		purchaseRequisitionPage.selectFirstPurchaseRequisitionFromPurchaseRequisitionPopup();
		purchaseRequisitionPage.selectTab("Drugs");
		purchaseRequisitionPage.searchItemsFromSmartSearchAndSelect("4 QUIN EYE DROPS");
		purchaseRequisitionPage.enterQuantityForSelectedItems();
		purchaseRequisitionPage.clickOnModifyButton();
		purchaseRequisitionPage.clickOnYesButtonOnModifyAlertPopup();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnGRNAndSelectAnOption("GRN");
		frontOfficeHomePage.selectReceiptTypewithPO("With PO");
		frontOfficeHomePage.RightButtonOk();
		frontOfficeHomePage.selectPurchaseOrder();
		frontOfficeHomePage.ReceiptDetailsQty("A TO Z GOLD CAP","20");
		frontOfficeHomePage.ReceiptDetailsQty("AB - FLO TAB","25");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();
		frontOfficeHomePage.EnterBatchNumber("A TO Z GOLD CAP","1");
		frontOfficeHomePage.EnterBatchNumber("3 PANEL CELL","2");
		frontOfficeHomePage.EnterBatchNumber("AB - FLO TAB","008B8AJQ");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();
		frontOfficeHomePage.clickonEditButton();
		frontOfficeHomePage.EnterExpiryDate("A TO Z GOLD CAP","01/Jan/2110");
		frontOfficeHomePage.EnterExpiryDate("3 PANEL CELL","01/Jan/2110");
		frontOfficeHomePage.EnterExpiryDate("AB - FLO TAB","01/Jan/2110");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();
		frontOfficeHomePage.EnterRPSPMRPNumber("A TO Z GOLD CAP","40.32");
		frontOfficeHomePage.EnterRPSPMRPNumber("3 PANEL CELL","21.23");
		frontOfficeHomePage.EnterRPSPMRPNumber("AB - FLO TAB","30.32");
		frontOfficeHomePage.clickonFreeDetails("A TO Z GOLD CAP", "1");
		frontOfficeHomePage.clickonFreeDetails("GLUCON D ORANGE 100GM", "1111");
		frontOfficeHomePage.clickonDraftCheckBox();
		frontOfficeHomePage.EnterInvoiceNumber("Testing Invoice");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();
		frontOfficeHomePage.clickonSaveButton();	
		frontOfficeHomePage.saveRecordNoButton();
		frontOfficeHomePage.clickonSaveButton();	
		frontOfficeHomePage.saveRecordYesButton();
		frontOfficeHomePage.clearButton();
		frontOfficeHomePage.ClearFilledDetails();
		frontOfficeHomePage.EnterFromDate("5-05-2020");
		frontOfficeHomePage.EnterToDate("10-05-2020");
		frontOfficeHomePage.clickonOpenDraftCheckBox();
		frontOfficeHomePage.clickonLoadButton();
		frontOfficeHomePage.CloseGRNList();
		frontOfficeHomePage.GRNNumberRadioButton();
		frontOfficeHomePage.SelectReciptType("Without PO");
		frontOfficeHomePage.EnterInvoiceNumber("abcdef");
		frontOfficeHomePage.SelectSupplierName("A.M.SURGICAL");
		frontOfficeHomePage.clickonReceiptDetails();
		frontOfficeHomePage.OKReciptTypeButton();
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "2BACONIL 14MG PATCH");
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.ReceiptDetailsQty("MARKUP DRUG 12% RECTAL   0 ", "1");
		frontOfficeHomePage.EnterBatchNumber("MARKUP DRUG 12% RECTAL   0 ", "ew");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonLoadButton();
		frontOfficeHomePage.clickonCSVButton();
		frontOfficeHomePage.clickonDeleteButton();
		frontOfficeHomePage.clickonGRNList();
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSaveButton();
		frontOfficeHomePage.saveRecordNoButton();
		frontOfficeHomePage.clickonSaveButton();
		frontOfficeHomePage.saveRecordYesButton();


	}

	@Test(priority =17)
	public void InventoryGRNTestCase1() throws InterruptedException 
	{
		test=extent.createTest("InventoryGRNTestCase1", "This test case verify the Inventory GRN Test Case1");
		test.assignCategory("Front Office Inventory");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");

		//frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnGRNAndSelectAnOption("GRN");
		frontOfficeHomePage.selectReceiptTypewithPO("Without PO");
		frontOfficeHomePage.SelectSupplierName("A.D AGENCIES");
		frontOfficeHomePage.EnterInvoiceNumber("abcdef");
		frontOfficeHomePage.OKReciptTypeButton();
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "2BACONIL 14MG PATCH");
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.selectAgaistChallanCheckBox();
		frontOfficeHomePage.EnterInvoiceNumber("12345678");
		frontOfficeHomePage.clickonReloadButton();
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "A TO Z GOLD CAP");
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "SP DRUG 5 % ORAL   0 ");
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "MARKUP DRUG 12% RECTAL   0 ");
		frontOfficeHomePage.selectGRNDrugItem("Medical Consumables", "ABDOMINAL BELT - MEDIUM");
		frontOfficeHomePage.selectGRNDrugItem("Medical Consumables", "ABDOMINAL BELT - SMALL");
		frontOfficeHomePage.selectGRNDrugItem("General & Miscellaneous", "GLUCON D ORANGE 100GM");
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.clickonReloadButton();
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.clearButton();
		frontOfficeHomePage.clickonClearNoButton();
		frontOfficeHomePage.clearButton();
		frontOfficeHomePage.clickonClearYesButton();

		//same cycle should be run

		frontOfficeHomePage.selectReceiptTypewithPO("Without PO");
		frontOfficeHomePage.SelectSupplierName("A.D AGENCIES");
		frontOfficeHomePage.EnterInvoiceNumber("abcdef");
		frontOfficeHomePage.OKReciptTypeButton();
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "2BACONIL 14MG PATCH");
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.selectAgaistChallanCheckBox();
		frontOfficeHomePage.EnterInvoiceNumber("12345678");
		frontOfficeHomePage.clickonReloadButton();

		frontOfficeHomePage.selectGRNDrugItem("Medicine", "A TO Z GOLD CAP");
		//frontOfficeHomePage.selectGRNDrugItem("Medicine", "SP DRUG 5 % ORAL   0 ");
		//frontOfficeHomePage.selectGRNDrugItem("Medicine", "MARKUP DRUG 12% RECTAL   0 ");
		frontOfficeHomePage.selectGRNDrugItem("Medical Consumables", "ABDOMINAL BELT - MEDIUM");
		frontOfficeHomePage.selectGRNDrugItem("Medical Consumables", "ABDOMINAL BELT - SMALL");
		frontOfficeHomePage.selectGRNDrugItem("General & Miscellaneous", "GLUCON D ORANGE 100GM");
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.clickonReloadButton();
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.clearButton();
		frontOfficeHomePage.clickonClearNoButton();
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		//Enter Receipt Details Qty
		frontOfficeHomePage.ReceiptDetailsQty("2BACONIL 14MG PATCH","10");
		frontOfficeHomePage.ReceiptDetailsQty("A TO Z GOLD CAP","10");
		//frontOfficeHomePage.ReceiptDetailsQty("SP DRUG 5 % ORAL   0 ","10");
		//frontOfficeHomePage.ReceiptDetailsQty("MARKUP DRUG 12% RECTAL   0 ","10");
		frontOfficeHomePage.ReceiptDetailsQty("ABDOMINAL BELT - MEDIUM","10");
		frontOfficeHomePage.ReceiptDetailsQty("ABDOMINAL BELT - SMALL","10");
		frontOfficeHomePage.ReceiptDetailsQty("GLUCON D ORANGE 100GM","10");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		// Enter Batch Number
		frontOfficeHomePage.EnterBatchNumber("2BACONIL 14MG PATCH","1");
		frontOfficeHomePage.EnterBatchNumber("A TO Z GOLD CAP","2");
		//frontOfficeHomePage.EnterBatchNumber("SP DRUG 5 % ORAL   0 ","sad");
		//frontOfficeHomePage.EnterBatchNumber("MARKUP DRUG 12% RECTAL   0 ","test2");
		frontOfficeHomePage.EnterBatchNumber("ABDOMINAL BELT - MEDIUM","OC2187");
		frontOfficeHomePage.EnterBatchNumber("ABDOMINAL BELT - SMALL","++++");
		frontOfficeHomePage.EnterBatchNumber("GLUCON D ORANGE 100GM","1111");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		//Enter Expiry Date
		frontOfficeHomePage.EnterExpiryDate("2BACONIL 14MG PATCH","01/Dec/2110");
		frontOfficeHomePage.EnterExpiryDate("A TO Z GOLD CAP","01/Dec/2110");
		//frontOfficeHomePage.EnterExpiryDate("SP DRUG 5 % ORAL   0 ","01/Dec/2110");
		//frontOfficeHomePage.EnterExpiryDate("MARKUP DRUG 12% RECTAL   0 ","01/Dec/2110");
		frontOfficeHomePage.EnterExpiryDate("ABDOMINAL BELT - MEDIUM","01/Dec/2110");
		frontOfficeHomePage.EnterExpiryDate("ABDOMINAL BELT - SMALL","01/Dec/2110");
		frontOfficeHomePage.EnterExpiryDate("GLUCON D ORANGE 100GM","01/Dec/2110");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();
		frontOfficeHomePage.clickonEditButton();

		//Enter PR Rate
		frontOfficeHomePage.EnterPRRate("2BACONIL 14MG PATCH","15");
		frontOfficeHomePage.EnterPRRate("A TO Z GOLD CAP","20");
		//frontOfficeHomePage.EnterPRRate("SP DRUG 5 % ORAL   0 ","30");
		//frontOfficeHomePage.EnterPRRate("MARKUP DRUG 12% RECTAL   0 ","25");
		frontOfficeHomePage.EnterPRRate("ABDOMINAL BELT - MEDIUM","35");
		frontOfficeHomePage.EnterPRRate("ABDOMINAL BELT - SMALL","40");
		frontOfficeHomePage.EnterPRRate("GLUCON D ORANGE 100GM","45");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		//Enter RP/SP/MRP
		frontOfficeHomePage.EnterRPSPMRPNumber("2BACONIL 14MG PATCH","100");
		frontOfficeHomePage.EnterRPSPMRPNumber("A TO Z GOLD CAP","100");
		frontOfficeHomePage.EnterRPSPMRPNumber("ABDOMINAL BELT - MEDIUM","100");
		frontOfficeHomePage.EnterRPSPMRPNumber("ABDOMINAL BELT - SMALL","100");
		frontOfficeHomePage.EnterRPSPMRPNumber("GLUCON D ORANGE 100GM","100");


		//Enter SGST
		frontOfficeHomePage.clickonEditButton();
		frontOfficeHomePage.EnterSGSTPercentage("2BACONIL 14MG PATCH","6");
		frontOfficeHomePage.EnterSGSTPercentage("A TO Z GOLD CAP","6");
		frontOfficeHomePage.EnterSGSTPercentage("ABDOMINAL BELT - MEDIUM","6");
		frontOfficeHomePage.EnterSGSTPercentage("ABDOMINAL BELT - SMALL","6");
		frontOfficeHomePage.EnterSGSTPercentage("GLUCON D ORANGE 100GM","6");

		//Enter CGST
		frontOfficeHomePage.clickonEditButton();
		frontOfficeHomePage.EnterCGSTPercentage("2BACONIL 14MG PATCH","6");
		frontOfficeHomePage.EnterCGSTPercentage("A TO Z GOLD CAP","6");
		frontOfficeHomePage.EnterCGSTPercentage("ABDOMINAL BELT - MEDIUM","6");
		frontOfficeHomePage.EnterCGSTPercentage("ABDOMINAL BELT - SMALL","6");
		frontOfficeHomePage.EnterCGSTPercentage("GLUCON D ORANGE 100GM","6");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();
		frontOfficeHomePage.clickonDraftCheckBox();
		frontOfficeHomePage.clickonSaveButton();
		frontOfficeHomePage.saveRecordNoButton();
		frontOfficeHomePage.clickonSaveButton();	
		frontOfficeHomePage.saveRecordYesButton();
	}

	@Test(priority =18)
	public void purchaseorderapprovaltestcase() throws InterruptedException 
	{
		test=extent.createTest("purchaseorderapprovaltestcase", "This test case verify the Purchase Order Approval Test Case");
		test.assignCategory("Front Office Inventory");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");
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

	@Test(priority =19)
	public void InventoryGRNReturnwithoutGRNTestCase() throws InterruptedException 
	{

		test=extent.createTest("InventoryGRNReturnwithoutGRNTestCase", "This test case verify the Inventory GRN Test Case1");
		test.assignCategory("Front Office Inventory");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");

		//frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnGRNRETURNAndSelectAnOption("GRN Return");
		frontOfficeHomePage.clickonSaveButton();
		assertTrue(patientRegistrationPage.verifymessagedisplay("Please enter reason for returning the following Items:!"), "Please enter reason for returning the following Items:!");
		frontOfficeHomePage.selectPurchaseTypewithoutreftoGRN("Without ref. to GRN");
		frontOfficeHomePage.SelectGRNReturnSupplierName("A.D AGENCIES");
		frontOfficeHomePage.clickonLoadButtonNearSupplierName();
		purchaseRequisitionPage.searchItems("A TO Z GOLD CAP");
		purchaseRequisitionPage.searchItems("AB - FLO TAB");
		purchaseRequisitionPage.searchItems("A TO Z GOLD CAP");
		assertTrue(patientRegistrationPage.verifymessagedisplay("A TO Z GOLD CAP already selected!"), "A TO Z GOLD CAP already selected!");
		frontOfficeHomePage.clickonBatch("A TO Z GOLD CAP","2");
		frontOfficeHomePage.clickonBatch("AB - FLO TAB","008B8AJQ");
		frontOfficeHomePage.clickonDoYouWantContinueNoOption();
		frontOfficeHomePage.clickonBatch("AB - FLO TAB","008B8AJQ");
		frontOfficeHomePage.clickonDoYouWantContinueYesOption();
		frontOfficeHomePage.EnterGRNReturnQTY("A TO Z GOLD CAP", "23");
		frontOfficeHomePage.EnterGRNReturnQTY("AB - FLO TAB", "415");
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
		frontOfficeHomePage.clickonGRNReturnCloseReport();
		frontOfficeHomePage.clickonMainReportCloseButton();
		frontOfficeHomePage.EnterFromDate("03/Mar/2020");
		frontOfficeHomePage.EnterToDate("12/May/2020");
		frontOfficeHomePage.clickonLoad();
		frontOfficeHomePage.clickonPurchaseReturnApproveButton();
		frontOfficeHomePage.clickonCSVButton();
		frontOfficeHomePage.clickonclosePurchaseOrderButton();
	}

	@Test(priority =20)
	public void InventorywithOPBillabeConsumption2TestCase() throws InterruptedException 
	{
		test=extent.createTest("InventorywithOPBillabeConsumption2TestCase", "This test case is verifies Patient Registration Valid Data");
		test.assignCategory("Front Office Inventory");
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
		hisHomePage.selectStationAndClickOnNo("Front Office");
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown("Mr.");
		patientRegistrationPage.enterFirstName("Automation");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
		patientRegistrationPage.enterAge("16");
		assertTrue(patientRegistrationPage.verifyLesserAgeAlertMessage("Please enter Date of Birth Age is less than 18 year"), "System is not throwing lesser age than 18 years message");
		patientRegistrationPage.enterAge("23");
		patientRegistrationPage.selectMartialStatusFromDropDown("Single");
		patientRegistrationPage.enterMotherMaidenName("Automation Test Mother");
		patientRegistrationPage.enterFathersName("AutomationFather@123 ");
		patientRegistrationPage.selectNationalityFromDropDown("Indian");
		patientRegistrationPage.checkVipCheckBoxAndEnterData("This VIP Data has been added by Test Automation Scripts");
		patientRegistrationPage.checkRemarksCheckBoxAndEnterData("This Remarks Data has been added by Test Automation Scripts");
		patientRegistrationPage.checkNRIChecbox();
		assertTrue(patientRegistrationPage.verifyIDCardDropDownIsEnabled(), "After checking NRI Checkbox, ID Card Dropdown is not getting enabled");
		patientRegistrationPage.selectIdCardTypeFromDropDown(idCard);
		patientRegistrationPage.enterNationalID("12345");
		patientRegistrationPage.enterTelephoneNumber("1234567891011123");
		patientRegistrationPage.enterMobileNumber("12345");
		patientRegistrationPage.clickOnRegisterIcon();
		assertTrue(patientRegistrationPage.verifyInvalidMobileNoAlertMessage("mobile number should not be less than 10 digit"), "Alert not showing up when invalid mobile No is added");
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Automation Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur", "247001");
		patientRegistrationPage.enterEmailId("%^%^%^%^");
		patientRegistrationPage.clickOnRegisterIcon();
		//assertTrue(patientRegistrationPage.verifyInvalidEmailIdAlertMessage("Please enter correct email Id!"), "Invalid Email ID is getting accepted by the system");
		patientRegistrationPage.enterEmailId("test@automation.com");
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
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("CATH LAB ");
		frontOfficeHomePage.clickOnIndentItemsAndSelectAnOption("OP Billable Consumption");
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.EnterUHIDnumber(patientRegistrationId);
		indentItemsPage.clickOnSaveButton();
		indentItemsPage.selectDoctorName("Ajeet Jain");
		indentItemsPage.clickonZeroStockItems();
		indentItemsPage.selectdrugandconsumables("AB - FLO TAB ");
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
		indentItemsPage.selectDoctorName("Ajeet Jain");
		indentItemsPage.enterFromDateItemReceiptScreen("03/Apr/2020");
		indentItemsPage.opbillableTODate("01/May/2020");
		indentItemsPage.clickonsearchButton();
		indentItemsPage.clickonpatientdetails();
		indentItemsPage.clickoncancelbutton();
		indentItemsPage.clickoncancelcheckbox();
		indentItemsPage.clickoncancelbutton();
		indentItemsPage.clickonNoSaverecord();
		indentItemsPage.EnterUHIDnumber(patientRegistrationId);
		indentItemsPage.selectDoctorName("Ajeet Jain");
		indentItemsPage.enterFromDateItemReceiptScreen("03/Apr/2020");
		indentItemsPage.opbillableTODate("01/May/2020");
		indentItemsPage.clickonsearchButton();
		indentItemsPage.clickonpatientdetails();
		indentItemsPage.clickoncancelbutton();
		indentItemsPage.clickoncancelcheckbox();
		indentItemsPage.clickoncancelbutton();
		indentItemsPage.clickonYesSaverecord();
		indentItemsPage.clickonconsumptioncancelOKbutton();
		indentItemsPage.clickonPrintButton();
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnHomeIcon();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();

		try {
			billingPage.clickandclosebuttonDocumentChecklist();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "0", "50");
		billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme", "Management Decision", "Today Testing");
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
		billingPage.selectSpecialityFromChooseSpecialityDropdown("Pathologist");
		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Megha");
		billingPage.selectSpecialityFromChooseSpecialityDropdown("Cardiology");
		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Deepak");
		billingPage.clickOnDiagnosticIcon();
		billingPage.selectTestsByName("24hrs Urinary Calcium");
		assertTrue(billingPage.verifyPriceNotDefinedMessage("Price not defined for this service"), "Price Not Defined Message is not showing up");
		billingPage.selectTestsByName("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectTestsByName("17-Ketosteroids, 24hrs Urine");
		billingPage.selectTestsByName("X-ray Dorso Lumbar Spine LAT");
		billingPage.selectTestsByName("X-ray Both Leg Skyline");
		billingPage.selectAllTestSpecialityAndDoctorName("Cardiac Surgeon", "Ajeet Jain");
		billingPage.clickOnManualIcon();
		billingPage.selectServiceNameFromDropdown("Cardiology Services");
		billingPage.enterDescriptionInManualSection("Cardic");
		billingPage.selectQuantityInManualSection("50");
		billingPage.enterPriceInManualSection("100");
		billingPage.clickOnVerifyButton();
		billingPage.clickOnOtherServicesIcon();
		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
		assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Dialysis Procedures" , "AV Fistula Day Care Package With Anesthesia");
		//billingPage.selectSpecialityAndDoctor();
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnAddToBillButton();
		assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("Amount Automation Testing");
		billingPage.enterDiscountAmount("500");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		billingPage.selectAuthorisedByFromDropdown("Management Decision");
		billingPage.selectOnCompanyRadioButton();
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		assertTrue(billingPage.isCompOnlyDiscoutErrorMessageDisplayed(), "Comp Only Discount Error Message is NOT Displayed");
		billingPage.selectOnPatientRadioButton();
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		billingPage.enterPatientPaidAmount("5000");
		billingPage.clickOnNewPaymentModeButton();
		billingPage.selectSecondPaymentModeAsCheque();
		billingPage.enterChequeDetailsAndSaveDetails("123456789", "State Bank of India", "Noida");		
		billingPage.clickOnVerifyButtonOnProcessPayment();
		assertTrue(billingPage.verifyBillGotGenerated("generated successfully"), "Bill did not got generated");
		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
	}

	@Test(priority = 21)
	public void InventoryPaymentAdvicesTestCase() throws InterruptedException 
	{
		test=extent.createTest("InventoryPaymentAdvicesTestCase", "This test case verify the Inventory Payment Advices Test Case");
		test.assignCategory("Front Office Inventory");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		indentItemsPage = new IndentItemsPage(driver);
		purchaseRequisitionPage = new PurchaseRequisitionPage(driver);
		indentApprovalPage = new IndentApprovalPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");

		frontOfficeHomePage.clickOnGRNAndSelectAnOption("GRN");
		frontOfficeHomePage.selectReceiptTypewithPO("Without PO");
		frontOfficeHomePage.SelectSupplierName("A.D AGENCIES");
		frontOfficeHomePage.OKReciptTypeButton();
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "2BACONIL 14MG PATCH");
		assertTrue(patientRegistrationPage.verifymessagedisplay("Please enter invoice!"), "patientRegistrationPage.verifymessagedisplay");
		frontOfficeHomePage.clickonGRNItemsCloseButton();

		frontOfficeHomePage.selectAgaistChallanCheckBox();
		frontOfficeHomePage.EnterInvoiceNumber("Testing Invoice Number");
		frontOfficeHomePage.clickonReloadButton();

		// Select GRN Durg Item
		frontOfficeHomePage.selectGRNDrugItem("Medicine", "A TO Z GOLD CAP");
		//frontOfficeHomePage.selectGRNDrugItem("Medicine", "SP DRUG 5 % ORAL   0 ");
		//frontOfficeHomePage.selectGRNDrugItem("Medicine", "MARKUP DRUG 12% RECTAL   0 ");
		frontOfficeHomePage.clickonGRNItemsCloseButton();
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		//Enter Qty
		frontOfficeHomePage.ReceiptDetailsQty("A TO Z GOLD CAP","10");
		//frontOfficeHomePage.ReceiptDetailsQty("SP DRUG 5 % ORAL   0 ","10");
		//frontOfficeHomePage.ReceiptDetailsQty("MARKUP DRUG 12% RECTAL   0 ","10");
		frontOfficeHomePage.clickonCalculateButton();
		frontOfficeHomePage.clickonSchemeDetailsOkButton();

		// Enter Batch Number
		frontOfficeHomePage.EnterBatchNumber("A TO Z GOLD CAP","1");
		//frontOfficeHomePage.EnterBatchNumber("SP DRUG 5 % ORAL   0 ","sad");
		//frontOfficeHomePage.EnterBatchNumber("MARKUP DRUG 12% RECTAL   0 ","test2");

		//Enter Expiry Date
		frontOfficeHomePage.EnterExpiryDate("A TO Z GOLD CAP","01/Dec/2110");
		//frontOfficeHomePage.EnterExpiryDate("SP DRUG 5 % ORAL   0 ","01/Dec/2110");
		//frontOfficeHomePage.EnterExpiryDate("MARKUP DRUG 12% RECTAL   0 ","01/Dec/2110");
		frontOfficeHomePage.clickonEditButton();

		//Enter PR Rate
		frontOfficeHomePage.EnterPRRate("A TO Z GOLD CAP","20");
		//frontOfficeHomePage.EnterPRRate("SP DRUG 5 % ORAL   0 ","25");
		//frontOfficeHomePage.EnterPRRate("MARKUP DRUG 12% RECTAL   0 ","30");
		frontOfficeHomePage.clickonEditButton();

		//Enter RP/SP/MRP
		frontOfficeHomePage.EnterRPSPMRPNumber("A TO Z GOLD CAP","100");
		//frontOfficeHomePage.EnterRPSPMRPNumber("SP DRUG 5 % ORAL   0 ","100");
		//frontOfficeHomePage.EnterRPSPMRPNumber("MARKUP DRUG 12% RECTAL   0 ","100");

		//Enter SGST
		frontOfficeHomePage.clickonEditButton();
		frontOfficeHomePage.EnterSGSTPercentage("A TO Z GOLD CAP","6");
		//frontOfficeHomePage.EnterSGSTPercentage("SP DRUG 5 % ORAL   0 ","6");
		//frontOfficeHomePage.EnterSGSTPercentage("MARKUP DRUG 12% RECTAL   0 ","6");

		//Enter CGST
		frontOfficeHomePage.clickonEditButton();
		frontOfficeHomePage.EnterCGSTPercentage("A TO Z GOLD CAP","6");
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
		hisHomePage.clickOnInventoryIcon();
		hisHomePage.selectStationAndClickOnYes("Central Medicine Store");

		frontOfficeHomePage.clickOnGRNAndSelectAnOption("Payment Advice");
		frontOfficeHomePage.clickonSaveButton();
		assertTrue(patientRegistrationPage.verifymessagedisplay("Please select suppiler !"), "Please select suppiler !");
		frontOfficeHomePage.PaymentAdviceSelectSupplierName("ANIL CHEMISTS");
//		frontOfficeHomePage.selectDateRangeCheckBox();
//		frontOfficeHomePage.selectPaymentAdviceFromDate("03/Mar/2020");
//		frontOfficeHomePage.selectPaymentAdviceToDate("12/May/2020");
		frontOfficeHomePage.clickonPaymentAdviceSearchButton();
		assertTrue(patientRegistrationPage.verifymessagedisplay("Record not found!"), "Record not found!");
		frontOfficeHomePage.PaymentAdviceSelectSupplierName("A.D AGENCIES");
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
		frontOfficeHomePage.PaymentAdviceSelectSupplierName("A.D AGENCIES");
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
