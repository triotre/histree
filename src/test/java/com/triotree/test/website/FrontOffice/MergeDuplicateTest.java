package com.triotree.test.website.FrontOffice;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.triotree.test.base.ResultListener;
import com.triotree.test.website.TTWebsiteBaseTest;
import com.triotree.website.pages.CommonPages.HISHomePage;
import com.triotree.website.pages.FrontOffice.FrontOfficeHomePage;
import com.triotree.website.pages.FrontOffice.MergeAndUnmergeDuplicatePage;
import com.triotree.website.pages.FrontOffice.PatientRegistrationPage;

@Listeners(ResultListener.class)
public class MergeDuplicateTest extends TTWebsiteBaseTest{

	private static final Logger logger = LogManager
			.getLogger(MergeDuplicateTest.class.getName());

	private HISHomePage hisHomePage;
	private FrontOfficeHomePage frontOfficeHomePage;
	private PatientRegistrationPage patientRegistrationPage;
	private MergeAndUnmergeDuplicatePage mergeAndUnmergeDuplicatePage;

	private String patientRegistrationId = "AHHS.8996";
	private String mergedUHID = null;
	private String title1 = null;
	private String desc1 = null;


	@Test(enabled = false)
	public void mergeAndUnmergePatientDuplicateTest() throws Throwable {
		
		test=extent.createTest("mergeAndUnmergePatientDuplicateTest", "This test case is merge And Unmerge Patient Duplicate Test");
		test.assignCategory("Front Office");
		
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		mergeAndUnmergeDuplicatePage = new MergeAndUnmergeDuplicatePage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Merge Duplicates");
		mergeAndUnmergeDuplicatePage.enterFirstNameAndPressEnter(" ");
		mergeAndUnmergeDuplicatePage.enterFirstNameAndPressEnter("$#$!2131575");
		assertTrue(mergeAndUnmergeDuplicatePage.verifyPleaseFillDetailMessage("Please fill atleast one detail"), "Please fill atleast one detail Alert Message no showing up");
		assertTrue(mergeAndUnmergeDuplicatePage.verifyPleaseFillDetailMessage("Please fill atleast one detail"), "Please fill atleast one detail Alert Message no showing up");
		mergeAndUnmergeDuplicatePage.enterFirstNameAndPressEnter("Automation");
		mergeAndUnmergeDuplicatePage.selectFirstPrimaryCheckBox();
		mergeAndUnmergeDuplicatePage.clickOnMergeButton();
		assertTrue(mergeAndUnmergeDuplicatePage.selectUHIDAlertMessage("Please Select UHID"), "Please Select UHID Alert Message Not showing Up");
		mergeAndUnmergeDuplicatePage.selectSecondPrimaryCheckBox();
		mergeAndUnmergeDuplicatePage.clickOnMergeButton();
		assertTrue(mergeAndUnmergeDuplicatePage.verifyUHIDMergedMessage("Selected UHID have been merged with"), "Selected UHID have been merged Message not showing up");
		String mergedUHID = mergeAndUnmergeDuplicatePage.getMergedUHID();

		//Below Steps are for Unmerge Patient Duplicate Test
		hisHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("UnMerge Duplicates");
		//patientRegistrationPage.searchUHIDFromSearchBoxOnHeader("AHHS."+mergedUHID);
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader("RAJH."+mergedUHID);
		Thread.sleep(3000);
		patientRegistrationPage.clickOnSelectCheckboxatUnmerge();
		patientRegistrationPage.clickOnUnmergeButtonatUnmerge();
		
		
		//String secondaryPatientid = mergeAndUnmergeDuplicatePage.getTheFirstSecondaryId();
		//patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(secondaryPatientid);
		//mergeAndUnmergeDuplicatePage.selectFirstResultCheckbox();
		//mergeAndUnmergeDuplicatePage.clickOnUnmergeButton();

	}
	
	@Test(priority = 1)
	public void frontOfficeMergeDuplicateWithDepositOnPatientTest() throws Throwable {
		test=extent.createTest("mergeAndUnmergePatientDuplicateTest", "This test case is merge And Unmerge Patient Duplicate Test");
		test.assignCategory("Front Office");
		
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		mergeAndUnmergeDuplicatePage = new MergeAndUnmergeDuplicatePage(driver);
	
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
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
		//		patientRegistrationPage.checkVipCheckBoxAndEnterData("This VIP Data has been added by Test Automation Scripts");
		//		patientRegistrationPage.checkRemarksCheckBoxAndEnterData("This Remarks Data has been added by Test Automation Scripts");
		patientRegistrationPage.checkNRIChecbox();
		assertTrue(patientRegistrationPage.verifyIDCardDropDownIsEnabled(), "After checking NRI Checkbox, ID Card Dropdown is not getting enabled");
		patientRegistrationPage.selectIdCardTypeFromDropDown("PAN CARD");
		patientRegistrationPage.enterNationalID("12345");
		patientRegistrationPage.enterTelephoneNumber("1234567891011123");
		patientRegistrationPage.enterMobileNumber("12345");
		patientRegistrationPage.clickOnRegisterIcon();
		assertTrue(patientRegistrationPage.verifyInvalidMobileNoAlertMessage("mobile number should not be less than 10 digit"), "Alert not showing up when invalid mobile No is added");
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Demo Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Ghaziabad");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Ghaziabad", "201001");
		patientRegistrationPage.enterEmailId("%^%^%^%^");
		patientRegistrationPage.clickOnRegisterIcon();
		//assertTrue(patientRegistrationPage.verifyInvalidEmailIdAlertMessage("Please enter correct email Id!"), "Invalid Email ID is getting accepted by the system");
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
		//
		//		driver.getURL();
		//		hisHomePage.loginToTriotreeHIS();
		//		hisHomePage.clickOnFronOfficeIcon();
		//		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnMenu();
		//frontOfficeHomePage.clickOnBillingAndSelectAnOption("Deposits");	
		
	
	    //hisHomePage.loginToTriotreeHIS();
		//hisHomePage.clickOnFronOfficeIcon();
		//hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Merge Duplicates");
		mergeAndUnmergeDuplicatePage.enterFirstNameAndPressEnter(" ");
		mergeAndUnmergeDuplicatePage.enterFirstNameAndPressEnter("$#$!2131575");
		assertTrue(mergeAndUnmergeDuplicatePage.verifyPleaseFillDetailMessage("Please fill atleast one detail"), "Please fill atleast one detail Alert Message no showing up");
		assertTrue(mergeAndUnmergeDuplicatePage.verifyPleaseFillDetailMessage("Please fill atleast one detail"), "Please fill atleast one detail Alert Message no showing up");
		mergeAndUnmergeDuplicatePage.enterFirstNameAndPressEnter("Automation");
		mergeAndUnmergeDuplicatePage.selectFirstPrimaryCheckBox();
		mergeAndUnmergeDuplicatePage.clickOnMergeButton();
		assertTrue(mergeAndUnmergeDuplicatePage.selectUHIDAlertMessage("Please Select UHID"), "Please Select UHID Alert Message Not showing Up");
		mergeAndUnmergeDuplicatePage.selectSecondPrimaryCheckBox();
		mergeAndUnmergeDuplicatePage.clickOnMergeButton();
		assertTrue(mergeAndUnmergeDuplicatePage.verifyUHIDMergedMessage("Selected UHID have been merged with"), "Selected UHID have been merged Message not showing up");
		String mergedUHID = mergeAndUnmergeDuplicatePage.getMergedUHID();

		//Below Steps are for Unmerge Patient Duplicate Test
		hisHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("UnMerge Duplicates");
		
		//patientRegistrationPage.searchUHIDFromSearchBoxOnHeader("AHHS."+mergedUHID);
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader("RAJH."+mergedUHID);
		
		//String secondaryPatientid = mergeAndUnmergeDuplicatePage.getTheFirstSecondaryId();
		//patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(secondaryPatientid);
		//mergeAndUnmergeDuplicatePage.selectFirstResultCheckbox();
		//mergeAndUnmergeDuplicatePage.clickOnUnmergeButton();
		
		Thread.sleep(3000);
		patientRegistrationPage.clickOnSelectCheckboxatUnmerge();
		patientRegistrationPage.clickOnUnmergeButtonatUnmerge();

	}
	
	

}
