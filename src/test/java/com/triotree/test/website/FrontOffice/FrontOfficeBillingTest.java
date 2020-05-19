package com.triotree.test.website.FrontOffice;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.test.base.ResultListener;
import com.triotree.test.website.TTWebsiteBaseTest;
import com.triotree.utils.DBUtil;
import com.triotree.website.pages.CommonPages.HISHomePage;
import com.triotree.website.pages.FrontOffice.BillingPage;
import com.triotree.website.pages.FrontOffice.FrontOfficeHomePage;
import com.triotree.website.pages.FrontOffice.MarkPatientDeceasedPage;
import com.triotree.website.pages.FrontOffice.MergeAndUnmergeDuplicatePage;
import com.triotree.website.pages.FrontOffice.PatientRegistrationPage;
@Listeners(ResultListener.class)
public class FrontOfficeBillingTest extends TTWebsiteBaseTest{

	private static final Logger logger = LogManager
			.getLogger(PatientRegistrationTest.class.getName());

	private HISHomePage hisHomePage;
	private FrontOfficeHomePage frontOfficeHomePage;
	private PatientRegistrationPage patientRegistrationPage;
	private BillingPage billingPage;
	private MarkPatientDeceasedPage markPatientDeceasedPage;
	private MergeAndUnmergeDuplicatePage mergeAndUnmergeDuplicatePage;

	private String patientRegistrationId = "AHHS.8996";

	private String desc = null;
	private String title1 = null;
	private String desc1 = null;


	@Test(priority = 1)
	public void frontOfficeBillingenterChequeDetailsAndSaveDetailsTestCase() throws Throwable 
	{
		test=extent.createTest("frontOfficeBillingFirstTestCase", "This test case verify the Fornt Office Billing First Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown(title);
		patientRegistrationPage.enterFirstName("Automation");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
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
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Automation Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur", "247001");
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
		assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
		patientRegistrationPage.yesButtonOnConfirmPopup();
		assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
		String patientRegistrationId =	patientRegistrationPage.getUHIDOfPatient();
		System.out.println("Patient Registration Id is " +patientRegistrationId);
		patientRegistrationPage.clickOnYesButtonOnRegisteredSuccessfullyPopup();
		assertTrue(patientRegistrationPage.verifyUserIsOnBillingScreen("Billing"), "User is not on Billing Screen");
		billingPage.closeCompanyDetailsPopup();
		billingPage.unCheckSchemeDetailsPopup();
		billingPage.closeSchemeDetailsPopup();
		billingPage.closeRemarksPopup();
		billingPage.selectSpecialityFromChooseSpecialityDropdown("Pathologist");
		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Megha");
		billingPage.selectSpecialityFromChooseSpecialityDropdown("Cardiology");
		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Deepak");
		billingPage.clickOnDiagnosticIcon();
		billingPage.selectTestsByName("24hrs Urinary Calcium");
		assertTrue(billingPage.verifyPriceNotDefinedMessage("Price not defined for this service"), "Price Not Defined Message is not showing up");
		billingPage.selectTestsByName("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectTestsByName("17-Ketosteroids, 24hrs Urine");
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
		billingPage.enterRefferedBy("Self");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnAddToBillButton();
		assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		billingPage.enterPatientPaidAmount("500");
		billingPage.clickOnNewPaymentModeButton();
		billingPage.selectSecondPaymentModeAsCheque();
		billingPage.enterChequeDetailsAndSaveDetails("123456789", "State Bank of India", "Noida");
		assertTrue(billingPage.verifyBillGotGenerated("generated successfully"), "Bill did not got generated");
		billingPage.clickonYesButtonOnBillGotGenertedPopup(); //add by nishant

	}
	@Test(priority = 2)
	public void frontOfficeBillingclickOnAddToBillButtonTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingSecondTestCase", "This test case verify the Fornt Office Billing Second Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown(title);
		patientRegistrationPage.enterFirstName("Automation");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
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
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Automation Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur", "247001");
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
		patientRegistrationPage.clickOnYesButtonOnRegisteredSuccessfullyPopup();
		assertTrue(patientRegistrationPage.verifyUserIsOnBillingScreen("Billing"), "User is not on Billing Screen");
		//billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "INDIA AIRLINES LIMITED", "OTHER", "INDIA AIRLINES LIMITED", "100", "50");
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
		//assertTrue(billingPage.verifyDailyDiscountLimitMessage("Daily discount limit for the patient in this schem"), "Daily Discount Limit Message is not showing up");

	}
	@Test(priority = 3)
	public void frontOfficeBillingandselectSecondPaymentModeAsChequeTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingThirdTestCase", "This test case verify the Fornt Office Billing Third Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown(title);
		patientRegistrationPage.enterFirstName("Automation");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
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
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Automation Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur", "247001");
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
		patientRegistrationPage.clickOnYesButtonOnRegisteredSuccessfullyPopup();
		//assertTrue(patientRegistrationPage.verifyUserIsOnBillingScreen("Billing"), "User is not on Billing Screen");
		try {
			billingPage.clickandclosebuttonDocumentChecklist();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "INDIA AIRLINES LIMITED", "OTHER", "INDIA AIRLINES LIMITED", "100", "50");
			billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
		}
		catch (Exception e) {
		}
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.closeRemarksPopup();
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
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnAddToBillButton();
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
		//		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		//		billingPage.clickOnBillingButtonOnHeader();
		//		billingPage.clickOnyesBtnOnGenrateBillPopup();
		//		billingPage.enterPatientPaidAmount("500");
		//		billingPage.clickOnNewPaymentModeButton();
		//		billingPage.selectSecondPaymentModeAsCheque();
		//		billingPage.enterChequeDetailsAndSaveDetails("123456789", "State Bank of India", "Noida");
		//		assertTrue(billingPage.verifyBillGotGenerated("generated successfully"), "Bill did not got generated");
		//		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		//assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
		//billingPage.clickOnYesButtonOnOpdPopup();

	}
	@Test(priority = 4)
	public void frontOfficeBillingclickOnNoButtonOnBillGotGeneratedPopupTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingFourTestCase", "This test case verify the Fornt Office Billing Four Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown(title);
		patientRegistrationPage.enterFirstName("Automation");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
		patientRegistrationPage.enterAge("65");
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
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Automation Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur", "247001");
		patientRegistrationPage.enterEmailId("test@automation.com");
		patientRegistrationPage.enterRefferdBy("Self");
		patientRegistrationPage.selectPrefferedLanguageFromDropdown("English");
		patientRegistrationPage.selectOccupationFromDropdown(occupation);
		patientRegistrationPage.selectQualificationFromDropdown(qualification);
		patientRegistrationPage.selectReligionFromDropdown("Hindu");
		patientRegistrationPage.selectReferedFromDropdown(referredFrom);
		patientRegistrationPage.checkFinancialDetailsCheckBox();
		patientRegistrationPage.selectCompanyTypeFromDropdown("Corporate");
		patientRegistrationPage.selectCompanyFromDropdownByName("STATE BANK OF INDIA");
		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");
		patientRegistrationPage.checkSchemeCheckBox();
		patientRegistrationPage.selectSchemeFromDropdown(1);
		patientRegistrationPage.clickOnRegisterIcon();
		assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
		patientRegistrationPage.yesButtonOnConfirmPopup();
		assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
		String patientRegistrationId =	patientRegistrationPage.getUHIDOfPatient();
		System.out.println("Patient Registration Id is " +patientRegistrationId);


		patientRegistrationPage.clickOnNoButtonOnRegisteredSuccessfullyPopup();
		//
		//		driver.getURL();
		//		hisHomePage.loginToTriotreeHIS();
		//		hisHomePage.clickOnFronOfficeIcon();
		//		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		//assertTrue(billingPage.verifyMandatoryDocumentMessage("Please select mandatory document"), "Alert not showing up Clicking on save without selecting Mandatory Documents");
		//		billingPage.checkCaseRecordCheckboxFromDocumentCheckList();
		//		billingPage.checkPanCardCheckboxFromDocumentCheckList();
		//		billingPage.checkForm60CheckboxFromDocumentCheckList();
		//		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		billingPage.closeCompanyDetailsPopup();
		billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.closeRemarksPopup();
		billingPage.selectSpecialityFromChooseSpecialityDropdown("Pathologist");
		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Megha");
		billingPage.selectSpecialityFromChooseSpecialityDropdown("Cardiology");
		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Deepak");	
		billingPage.clickOnDiagnosticIcon();
		billingPage.selectTestsByName("24hrs Urinary Calcium");
		//assertTrue(billingPage.verifyPriceNotDefinedMessage("Price not defined for this service"), "Price Not Defined Message is not showing up");
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
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnInsuranceCompanyButton();
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "100", "50");
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		billingPage.enterPatientPaidAmount("500");
		billingPage.clickOnNewPaymentModeButton();
		billingPage.selectSecondPaymentModeAsCheque();
		billingPage.enterChequeDetailsAndSaveDetails("123456789", "State Bank of India", "Noida");
		assertTrue(billingPage.verifyBillGotGenerated("generated successfully"), "Bill did not got generated");
		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		//assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
		//billingPage.clickOnYesButtonOnOpdPopup();

	}

	@Test(priority = 5)
	public void frontOfficeBillingclickOnYesBtnPercentageProcessDiscountPopupTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingFiveTestCase", "This test case verify the Fornt Office Billing Five Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown(title);
		patientRegistrationPage.enterFirstName("Automation");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
		patientRegistrationPage.enterAge("65");
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
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Automation Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur", "247001");
		patientRegistrationPage.enterEmailId("test@automation.com");
		patientRegistrationPage.enterRefferdBy("Self");
		patientRegistrationPage.selectPrefferedLanguageFromDropdown("English");
		patientRegistrationPage.selectOccupationFromDropdown(occupation);
		patientRegistrationPage.selectQualificationFromDropdown(qualification);
		patientRegistrationPage.selectReligionFromDropdown("Hindu");
		patientRegistrationPage.selectReferedFromDropdown(referredFrom);
		patientRegistrationPage.checkFinancialDetailsCheckBox();
		patientRegistrationPage.selectCompanyTypeFromDropdown("Corporate");
		patientRegistrationPage.selectCompanyFromDropdownByName("STATE BANK OF INDIA");
		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");
		patientRegistrationPage.checkSchemeCheckBox();
		patientRegistrationPage.selectSchemeFromDropdown(1);
		patientRegistrationPage.clickOnRegisterIcon();
		assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
		patientRegistrationPage.yesButtonOnConfirmPopup();
		assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
		String patientRegistrationId =	patientRegistrationPage.getUHIDOfPatient();
		System.out.println("Patient Registration Id is " +patientRegistrationId);


		patientRegistrationPage.clickOnNoButtonOnRegisteredSuccessfullyPopup();
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();

		//assertTrue(billingPage.verifyMandatoryDocumentMessage("Please select mandatory document"), "Alert not showing up Clicking on save without selecting Mandatory Documents");
		//		billingPage.checkCaseRecordCheckboxFromDocumentCheckList();
		//		billingPage.checkPanCardCheckboxFromDocumentCheckList();
		//		billingPage.checkForm60CheckboxFromDocumentCheckList();
		//		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		billingPage.closeCompanyDetailsPopup();
		billingPage.uncheckSchemeCheckBox();
		try {
			billingPage.okButtonSchemePopup();
		}
		catch (Exception e) {}
		try {
			billingPage.cancelSchemeForPatientPopup();
		}
		catch (Exception e) {}
		//billingPage.selectSchemeFromSchemeForPatientPopup("Today Testing");

		billingPage.closeRemarksPopup();

		billingPage.selectSpecialityFromChooseSpecialityDropdown("Pathologist");
		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Megha");
		billingPage.selectSpecialityFromChooseSpecialityDropdown("Cardiology");
		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Deepak");	
		billingPage.clickOnDiagnosticIcon();
		billingPage.selectTestsByName("24hrs Urinary Calcium");
		//assertTrue(billingPage.verifyPriceNotDefinedMessage("Price not defined for this service"), "Price Not Defined Message is not showing up");
		billingPage.selectTestsByName("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectTestsByName("17-Ketosteroids, 24hrs Urine");
		billingPage.selectTestsByName("X-ray Dorso Lumbar Spine LAT");
		billingPage.selectTestsByName("X-ray Both Leg Skyline");
		billingPage.selectAllTestSpecialityAndDoctorName("Cardiac Surgeon", "Ajeet Jain");
		//Manual Icon
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
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnInsuranceCompanyButton();
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "100", "50");
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		assertTrue(billingPage.isPercentageProcessDiscountMessageDisplayed(), "Percentage Process Discount Message is NOT Displayed");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		assertTrue(billingPage.isEnterDiscountErrorMessageDisplayed(), "Enter Discount Error Message is NOT Displayed");
		billingPage.selectDiscountOnFromDropdown("On Bill");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		assertTrue(billingPage.isEnterDiscountErrorMessageDisplayed(), "Enter Discount Error Message is NOT Displayed");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("10% Automation Testing");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		billingPage.selectAuthorisedByFromDropdown("Management Decision");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		billingPage.clickOnDraftButtonOnHeader();
		Thread.sleep(10000);		

		//TO DO NEED TO ADD AFTER STOPS BLOCKED DUE TO BUG
		//
		//		billingPage.clickOnBillingButtonOnHeader();
		//		billingPage.clickOnyesBtnOnGenrateBillPopup();
		//		billingPage.enterPatientPaidAmount("500");
		//		billingPage.clickOnNewPaymentModeButton();
		//		billingPage.selectSecondPaymentModeAsCheque();
		//		billingPage.enterChequeDetailsAndSaveDetails("123456789", "State Bank of India", "Noida");
		//		assertTrue(billingPage.verifyBillGotGenerated("generated successfully"), "Bill did not got generated");
		//		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		//		assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
		//		billingPage.clickOnYesButtonOnOpdPopup();

	}

	@Test(priority = 6)
	public void frontOfficeBillingclickOnVerifyButtonOnProcessPaymentTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingSixTestCase", "This test case verify the Fornt Office Billing Six Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown(title);
		patientRegistrationPage.enterFirstName("Automation");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
		patientRegistrationPage.enterAge("65");
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
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Automation Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur", "247001");
		patientRegistrationPage.enterEmailId("test@automation.com");
		patientRegistrationPage.enterRefferdBy("Self");
		patientRegistrationPage.selectPrefferedLanguageFromDropdown("English");
		patientRegistrationPage.selectOccupationFromDropdown(occupation);
		patientRegistrationPage.selectQualificationFromDropdown(qualification);
		patientRegistrationPage.selectReligionFromDropdown("Hindu");
		patientRegistrationPage.selectReferedFromDropdown(referredFrom);
		patientRegistrationPage.checkFinancialDetailsCheckBox();
		patientRegistrationPage.selectCompanyTypeFromDropdown("Corporate");
		patientRegistrationPage.selectCompanyFromDropdownByName("STATE BANK OF INDIA");
		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");
		patientRegistrationPage.checkSchemeCheckBox();
		patientRegistrationPage.selectSchemeFromDropdown(1);
		patientRegistrationPage.clickOnRegisterIcon();
		assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
		patientRegistrationPage.yesButtonOnConfirmPopup();
		assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
		String patientRegistrationId =	patientRegistrationPage.getUHIDOfPatient();
		System.out.println("Patient Registration Id is " +patientRegistrationId);
		patientRegistrationPage.clickOnNoButtonOnRegisteredSuccessfullyPopup();
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		//		assertTrue(billingPage.verifyMandatoryDocumentMessage("Please select mandatory document"), "Alert not showing up Clicking on save without selecting Mandatory Documents");
		//billingPage.checkCaseRecordCheckboxFromDocumentCheckList();
		//		billingPage.checkPanCardCheckboxFromDocumentCheckList();
		//		billingPage.checkForm60CheckboxFromDocumentCheckList();
		//		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "100", "50");
		billingPage.uncheckSchemeCheckBox();
		billingPage.closeSchemeDetailsPopup();
		billingPage.closeRemarksPopup();
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

		//Manual Icon
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
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.clickOnSchemeButtonNearAddToBill();
		billingPage.uncheckSchemeCheckBox();
		billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");

		try {
			billingPage.okButtonSchemePopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.clickOnAddToBillButton();
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		billingPage.enterPatientPaidAmount("500");
		billingPage.clickOnNewPaymentModeButton();
		billingPage.selectSecondPaymentModeAsCheque();
		billingPage.enterPatientPaidAmountForCheque("1000");
		billingPage.enterChequeDetailsAndSaveDetails("123456789", "State Bank of India", "Noida");		
		billingPage.selectAuthorisedByFromProcessPaymentDropdown("Management Decision");
		billingPage.enterRemarsInProcessPaymentPopup("Testing Remarks");
		billingPage.clickOnVerifyButtonOnProcessPayment();
		assertTrue(billingPage.verifyBillGotGenerated("generated successfully"), "Bill did not got generated");
		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		//assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
		//billingPage.clickOnYesButtonOnOpdPopup();

	}


	@Test(priority = 7)
	public void frontOfficeBillingverifyPrintOPDMessageIsDisplayingTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingSevenTestCase", "This test case verify the Fornt Office Billing Seven Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

		String schemeExpiredPatienId = propertyFile.getProperty("schemeExpiredPatient");

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");		
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeaderSecondMethod(schemeExpiredPatienId);
		//assertTrue(billingPage.verifySchemeExpiryPopupMessage("The validity of this patients association with scheme is expired. Please extend the validity or remove scheme!"), "Scheme Expiry Popup is not showing up");
		//billingPage.closeSchemeExpiryPopup();
		try {
			billingPage.cancelSchemeForPatientPopup();
		}
		catch (Exception e) {}
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		//assertTrue(billingPage.verifyMandatoryDocumentMessage("Please select mandatory document"), "Alert not showing up Clicking on save without selecting Mandatory Documents");
		//billingPage.checkCaseRecordCheckboxFromDocumentCheckList();
		//billingPage.checkPanCardCheckboxFromDocumentCheckList();
		//billingPage.checkForm60CheckboxFromDocumentCheckList();
		//billingPage.clickOnSaveButtonOnDocumentChecklistPopup();

		billingPage.closeCompanyDetailsPopup();

		billingPage.closeRemarksPopup();
		billingPage.clickPreviousVisitIcon();
		assertTrue(billingPage.isPreviousVisitPopupOpened(), "Previous Visit Popup is not opened");
		billingPage.closePreviousVisitPopup();

		//choose speciality
		billingPage.selectSpecialityFromChooseSpecialityDropdown("Pathologist");
		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Megha");
		billingPage.selectSpecialityFromChooseSpecialityDropdown("Cardiology");
		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Deepak");

		//Diagnostic Test
		billingPage.clickOnDiagnosticIcon();
		billingPage.selectTestsByName("24hrs Urinary Calcium");
		//assertTrue(billingPage.verifyPriceNotDefinedMessage("Price not defined for this service"), "Price Not Defined Message is not showing up");
		billingPage.selectTestsByName("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectTestsByName("17-Ketosteroids, 24hrs Urine");
		billingPage.selectTestsByName("X-ray Dorso Lumbar Spine LAT");
		billingPage.selectTestsByName("X-ray Both Leg Skyline");
		billingPage.selectAllTestSpecialityAndDoctorName("Cardiac Surgeon", "Ajeet Jain");

		//Manual Icon 
		billingPage.clickOnManualIcon();
		billingPage.selectServiceNameFromDropdown("Cardiology Services");
		billingPage.enterDescriptionInManualSection("cardio");
		billingPage.selectQuantityInManualSection("50");
		billingPage.enterPriceInManualSection("100");
		billingPage.clickOnVerifyButton();
		billingPage.clickOnOtherServicesIcon();
		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
		assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Dialysis Procedures" , "AV Fistula Day Care Package With Anesthesia");
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");


		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnInsuranceCompanyButton();
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "100", "50");


		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		assertTrue(billingPage.isPercentageProcessDiscountMessageDisplayed(), "Percentage Process Discount Message is NOT Displayed");
		billingPage.selectDiscountOnFromDropdown("On Service");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("20% Automation Testing");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		billingPage.selectAuthorisedByFromDropdown("Management Decision");
		billingPage.selectOnCompanyRadioButton();
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
		//assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
		//billingPage.clickOnYesButtonOnOpdPopup();
	}
	
	@Test(priority = 8)
	public void frontOfficeBillingclickOnNewPaymentModeButtonTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingEightTestCase", "This test case verify the Fornt Office Billing Eight Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown(title);
		patientRegistrationPage.enterFirstName("Automation");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
		patientRegistrationPage.enterAge("65");
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
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Automation Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur", "247001");
		patientRegistrationPage.enterEmailId("test@automation.com");
		patientRegistrationPage.enterRefferdBy("Self");
		patientRegistrationPage.selectPrefferedLanguageFromDropdown("English");
		patientRegistrationPage.selectOccupationFromDropdown(occupation);
		patientRegistrationPage.selectQualificationFromDropdown(qualification);
		patientRegistrationPage.selectReligionFromDropdown("Hindu");
		patientRegistrationPage.selectReferedFromDropdown(referredFrom);
		patientRegistrationPage.checkFinancialDetailsCheckBox();
		patientRegistrationPage.selectCompanyTypeFromDropdown("Corporate");
		patientRegistrationPage.selectCompanyFromDropdownByName("STATE BANK OF INDIA");
		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");
		patientRegistrationPage.checkSchemeCheckBox();
		patientRegistrationPage.selectSchemeFromDropdown(1);
		patientRegistrationPage.clickOnRegisterIcon();
		//assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
		patientRegistrationPage.yesButtonOnConfirmPopup();
		//assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
		String patientRegistrationId =	patientRegistrationPage.getUHIDOfPatient();
		System.out.println("Patient Registration Id is " +patientRegistrationId);
		patientRegistrationPage.clickOnNoButtonOnRegisteredSuccessfullyPopup();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);

		//		//billingPage.clickClearButtonCompDetails();
		//		billingPage.closeCompanyDetailsPopup();
		//		billingPage.unCheckSchemeDetailsPopup();
		//		billingPage.closeSchemeDetailsPopup();
		//		try {
		//			billingPage.cancelSchemeForPatientPopup();
		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//		try {
		//		billingPage.closeRemarksPopup();
		//		}
		//		catch (Exception e) {
		//			// TODO: handle exception
		//		}
		try {
			billingPage.clickOnCloseButtonOnDocumentChecklistPopup();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//billingPage.clickClearButtonCompDetails();
		try {
			billingPage.cancelSchemeForPatientPopup();
		}
		catch (Exception e) {}
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		billingPage.closeCompanyDetailsPopup();
		try {
			billingPage.unCheckSchemeDetailsPopup();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			billingPage.cancelSchemeForPatientPopup();
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
		billingPage.enterDescriptionInManualSection("cardic");
		billingPage.selectQuantityInManualSection("50");
		billingPage.enterPriceInManualSection("100");
		billingPage.clickOnVerifyButton();
		billingPage.clickOnOtherServicesIcon();
		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
		assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Dialysis Procedures" , "AV Fistula Day Care Package With Anesthesia");
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnAddToBillButton();
		assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		assertTrue(billingPage.isPercentageProcessDiscountMessageDisplayed(), "Percentage Process Discount Message is NOT Displayed");
		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("Amount Automation Testing");
		billingPage.enterDiscountAmount("20000");
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
		//assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
		//billingPage.clickOnYesButtonOnOpdPopup();
	}
	@Test(priority = 9)
	public void frontOfficeBillingMarkPatientDeceasedTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingNineTestCase", "This test case verify the Fornt Office Billing Nine Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		markPatientDeceasedPage = new MarkPatientDeceasedPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown(title);
		patientRegistrationPage.enterFirstName("Automation");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
		patientRegistrationPage.enterAge("65");
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
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Automation Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur", "247001");
		patientRegistrationPage.enterEmailId("test@automation.com");
		patientRegistrationPage.enterRefferdBy("Self");
		patientRegistrationPage.selectPrefferedLanguageFromDropdown("English");
		patientRegistrationPage.selectOccupationFromDropdown(occupation);
		patientRegistrationPage.selectQualificationFromDropdown(qualification);
		patientRegistrationPage.selectReligionFromDropdown("Hindu");
		patientRegistrationPage.selectReferedFromDropdown(referredFrom);
		patientRegistrationPage.checkFinancialDetailsCheckBox();
		patientRegistrationPage.selectCompanyTypeFromDropdown("Corporate");
		patientRegistrationPage.selectCompanyFromDropdownByName("STATE BANK OF INDIA");
		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");
		patientRegistrationPage.checkSchemeCheckBox();
		patientRegistrationPage.selectSchemeFromDropdown(1);
		patientRegistrationPage.clickOnRegisterIcon();
		assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
		patientRegistrationPage.yesButtonOnConfirmPopup();
		assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
		String patientRegistrationId =	patientRegistrationPage.getUHIDOfPatient();
		System.out.println("Patient Registration Id is " +patientRegistrationId);
		patientRegistrationPage.clickOnNoButtonOnRegisteredSuccessfullyPopup();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Mark Patient Deceased");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		markPatientDeceasedPage.checkDeceasedCheckbox();
		markPatientDeceasedPage.enterInformedBy("DOCTOR");
		markPatientDeceasedPage.clickOnSaveIcon();
		markPatientDeceasedPage.yesButtonOnMarkPatientDeceasedPopup();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		patientRegistrationPage.patientdeceasedok();
		try {
			billingPage.clickOnCloseButtonOnDocumentChecklistPopup();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//billingPage.clickClearButtonCompDetails();
		try {
			billingPage.cancelSchemeForPatientPopup();
		}
		catch (Exception e) {}
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		billingPage.closeCompanyDetailsPopup();
		try {
			billingPage.unCheckSchemeDetailsPopup();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			billingPage.cancelSchemeForPatientPopup();
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
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnAddToBillButton();
		assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		assertTrue(billingPage.isPercentageProcessDiscountMessageDisplayed(), "Percentage Process Discount Message is NOT Displayed");
		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("Amount Automation Testing");
		billingPage.enterDiscountAmount("20000");
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
		//		assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
		//		billingPage.clickOnYesButtonOnOpdPopup();

	}

	@Test(priority = 10 )
	public void frontOfficeBillingsearchPatientWithMobileNumberTestCase() throws Throwable {


		test=extent.createTest("frontOfficeBillingTenTestCase", "This test case verify the Fornt Office Billing Ten Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown(title);
		patientRegistrationPage.enterFirstName("Automation");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
		patientRegistrationPage.enterAge("65");
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
		patientRegistrationPage.enterMobileNumber("1223122311");
		patientRegistrationPage.enterHouseNumber("Automation Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur", "247001");
		patientRegistrationPage.enterEmailId("test@automation.com");
		patientRegistrationPage.enterRefferdBy("Self");
		patientRegistrationPage.selectPrefferedLanguageFromDropdown("English");
		patientRegistrationPage.selectOccupationFromDropdown(occupation);
		patientRegistrationPage.selectQualificationFromDropdown(qualification);
		patientRegistrationPage.selectReligionFromDropdown("Hindu");
		patientRegistrationPage.selectReferedFromDropdown(referredFrom);
		patientRegistrationPage.checkFinancialDetailsCheckBox();
		patientRegistrationPage.selectCompanyTypeFromDropdown("Corporate");
		patientRegistrationPage.selectCompanyFromDropdownByName("STATE BANK OF INDIA");
		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");
		patientRegistrationPage.checkSchemeCheckBox();
		patientRegistrationPage.selectSchemeFromDropdown(1);
		patientRegistrationPage.clickOnRegisterIcon();
		//assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
		patientRegistrationPage.yesButtonOnConfirmPopup();
		//assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
		String patientRegistrationId =	patientRegistrationPage.getUHIDOfPatient();
		System.out.println("Patient Registration Id is " +patientRegistrationId);
		patientRegistrationPage.clickOnNoButtonOnRegisteredSuccessfullyPopup();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		billingPage.clickOnSearchNewButtonOnHeader();
		billingPage.searchPatientWithMobileNumber("1223122311");
		billingPage.clickOnPatientIdFromSearch(patientRegistrationId.trim());		
		//		billingPage.clickOnCloseButtonOnDocumentChecklistPopup();
		//		billingPage.clickClearButtonCompDetails();
		//		billingPage.closeCompanyDetailsPopup();
		//		billingPage.unCheckSchemeDetailsPopup();
		//		billingPage.closeSchemeDetailsPopup();
		//		try {
		//			billingPage.cancelSchemeForPatientPopup();
		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//		billingPage.closeRemarksPopup();
		try {
			billingPage.clickOnCloseButtonOnDocumentChecklistPopup();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//billingPage.clickClearButtonCompDetails();
		try {
			billingPage.cancelSchemeForPatientPopup();
		}
		catch (Exception e) {}
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		billingPage.closeCompanyDetailsPopup();
		try {
			billingPage.unCheckSchemeDetailsPopup();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			billingPage.cancelSchemeForPatientPopup();
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
		billingPage.enterDescriptionInManualSection("cardic");
		billingPage.selectQuantityInManualSection("50");
		billingPage.enterPriceInManualSection("100");
		billingPage.clickOnVerifyButton();
		billingPage.clickOnOtherServicesIcon();
		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
		assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Dialysis Procedures" , "AV Fistula Day Care Package With Anesthesia");
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnAddToBillButton();
		assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		assertTrue(billingPage.isPercentageProcessDiscountMessageDisplayed(), "Percentage Process Discount Message is NOT Displayed");
		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("Amount Automation Testing");
		billingPage.enterDiscountAmount("20000");
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
		//assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
		//billingPage.clickOnYesButtonOnOpdPopup();
	}

	@Test(priority = 11)
	public void frontOfficeBillingMergeDuplicatesTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingElevenTestCase", "This test case verify the Fornt Office Billing Eleven Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		mergeAndUnmergeDuplicatePage = new MergeAndUnmergeDuplicatePage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");

		//First Patient Registration

		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown(title);
		patientRegistrationPage.enterFirstName("Automation");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
		patientRegistrationPage.enterAge("65");
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
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Automation Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur", "247001");
		patientRegistrationPage.enterEmailId("test@automation.com");
		patientRegistrationPage.enterRefferdBy("Self");
		patientRegistrationPage.selectPrefferedLanguageFromDropdown("English");
		patientRegistrationPage.selectOccupationFromDropdown(occupation);
		patientRegistrationPage.selectQualificationFromDropdown(qualification);
		patientRegistrationPage.selectReligionFromDropdown("Hindu");
		patientRegistrationPage.selectReferedFromDropdown(referredFrom);
		patientRegistrationPage.checkFinancialDetailsCheckBox();
		patientRegistrationPage.selectCompanyTypeFromDropdown("Corporate");
		patientRegistrationPage.selectCompanyFromDropdownByName("STATE BANK OF INDIA");
		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");
		patientRegistrationPage.checkSchemeCheckBox();
		patientRegistrationPage.selectSchemeFromDropdown(1);
		patientRegistrationPage.clickOnRegisterIcon();
		//assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
		patientRegistrationPage.yesButtonOnConfirmPopup();
		//assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
		String patientRegistrationId =	patientRegistrationPage.getUHIDOfPatient();
		System.out.println("Patient Registration Id is " +patientRegistrationId);
		patientRegistrationPage.clickOnNoButtonOnRegisteredSuccessfullyPopup();

		//Second Patient Registration
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown(title);
		patientRegistrationPage.enterFirstName("Automation");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
		patientRegistrationPage.enterAge("65");
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
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Automation Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur", "247001");
		patientRegistrationPage.enterEmailId("test@automation.com");
		patientRegistrationPage.enterRefferdBy("Self");
		patientRegistrationPage.selectPrefferedLanguageFromDropdown("English");
		patientRegistrationPage.selectOccupationFromDropdown(occupation);
		patientRegistrationPage.selectQualificationFromDropdown(qualification);
		patientRegistrationPage.selectReligionFromDropdown("Hindu");
		patientRegistrationPage.selectReferedFromDropdown(referredFrom);
		patientRegistrationPage.checkFinancialDetailsCheckBox();
		patientRegistrationPage.selectCompanyTypeFromDropdown("Corporate");
		patientRegistrationPage.selectCompanyFromDropdownByName("STATE BANK OF INDIA");
		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");
		patientRegistrationPage.checkSchemeCheckBox();
		patientRegistrationPage.selectSchemeFromDropdown(1);
		patientRegistrationPage.clickOnRegisterIcon();
		//assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
		patientRegistrationPage.yesButtonOnConfirmPopup();
		//assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
		String patientRegistrationId2 =	patientRegistrationPage.getUHIDOfPatient();
		System.out.println("Second Patient Registration Id is " +patientRegistrationId2);
		patientRegistrationPage.clickOnNoButtonOnRegisteredSuccessfullyPopup();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Merge Duplicates");
		mergeAndUnmergeDuplicatePage.enterFirstNameAndPressEnter("Automation");
		//		String firstPatient = mergeAndUnmergeDuplicatePage.getFirstPatientNameFromResult();
		//		String secondPatient = mergeAndUnmergeDuplicatePage.getSecondPatientNameFromResult();
		String firstPatient = patientRegistrationId.trim();
		String secondPatient = patientRegistrationId2.trim();
		mergeAndUnmergeDuplicatePage.checkPrimaryRadioButtonForSpecificPatient(firstPatient);
		mergeAndUnmergeDuplicatePage.checkSelectCheckBoxForSpecificPatient(secondPatient);
		mergeAndUnmergeDuplicatePage.clickOnMergeButton();



		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeaderSecondMethod(firstPatient);
		//		billingPage.clickOnCloseButtonOnDocumentChecklistPopup();
		//		billingPage.closeCompanyDetailsPopup();
		//		billingPage.closeSchemeDetailsPopup();
		//		billingPage.closeRemarksPopup();
		//		try {
		//			billingPage.cancelSchemeForPatientPopup();
		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		try {
			billingPage.clickOnCloseButtonOnDocumentChecklistPopup();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//billingPage.clickClearButtonCompDetails();
		try {
			billingPage.cancelSchemeForPatientPopup();
		}
		catch (Exception e) {}
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		billingPage.closeCompanyDetailsPopup();
		try {
			billingPage.unCheckSchemeDetailsPopup();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			billingPage.cancelSchemeForPatientPopup();
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
		billingPage.clickClearButtonOnHeader();
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeaderSecondMethod(secondPatient);
		assertTrue(billingPage.verifyPatientMappedPopup("Selected UHId has been mapped with"), "Patient Mapped Popup is not showing up");
		patientRegistrationPage.patientdeceasedok();
		//billingPage.clickOnYesButtonOnPatientMappedPopup();
		//		try {
		//			billingPage.cancelSchemeForPatientPopup();
		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//		billingPage.clickOnCloseButtonOnDocumentChecklistPopup();
		//		billingPage.clickClearButtonCompDetails();
		//		billingPage.closeCompanyDetailsPopup();
		//		billingPage.unCheckSchemeDetailsPopup();
		//		billingPage.closeSchemeDetailsPopup();
		//		try {
		//			billingPage.cancelSchemeForPatientPopup();
		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

		try {
			billingPage.clickOnCloseButtonOnDocumentChecklistPopup();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//billingPage.clickClearButtonCompDetails();
		try {
			billingPage.cancelSchemeForPatientPopup();
		}
		catch (Exception e) {}
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		billingPage.closeCompanyDetailsPopup();
		try {
			billingPage.unCheckSchemeDetailsPopup();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			billingPage.cancelSchemeForPatientPopup();
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
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnAddToBillButton();
		assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		assertTrue(billingPage.isPercentageProcessDiscountMessageDisplayed(), "Percentage Process Discount Message is NOT Displayed");
		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("Amount Automation Testing");
		billingPage.enterDiscountAmount("20000");
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
		//assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
		//billingPage.clickOnYesButtonOnOpdPopup();

	}
	@Test(priority = 12)
	public void frontOfficeBillingselectInsuranceCompRadioButtonTestCase() throws Throwable {	

		test=extent.createTest("frontOfficeBillingTwelveTestCase", "This test case verify the Fornt Office Billing Twelve Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.selectTitleFromTitleDropDown(title);
		patientRegistrationPage.enterFirstName("Automation");
		patientRegistrationPage.enterMiddleName("Test");
		patientRegistrationPage.enterLastName("User");
		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
		patientRegistrationPage.enterDob("15-12-1991");
		patientRegistrationPage.enterAge("67");
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
		patientRegistrationPage.enterMobileNumber("1234567890");
		patientRegistrationPage.enterHouseNumber("Automation Test Address");
		patientRegistrationPage.selectCityFromCityDropdown(city);
		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur");
		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Saharanpur", "247001");
		patientRegistrationPage.enterEmailId("test@automation.com");
		patientRegistrationPage.enterRefferdBy("Self");
		patientRegistrationPage.selectPrefferedLanguageFromDropdown("English");
		patientRegistrationPage.selectOccupationFromDropdown(occupation);
		patientRegistrationPage.selectQualificationFromDropdown(qualification);
		patientRegistrationPage.selectReligionFromDropdown("Hindu");
		patientRegistrationPage.selectReferedFromDropdown(referredFrom);
		patientRegistrationPage.checkFinancialDetailsCheckBox();
		patientRegistrationPage.selectCompanyTypeFromDropdown("Corporate");
		patientRegistrationPage.selectCompanyFromDropdownByName("STATE BANK OF INDIA");
		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");
		patientRegistrationPage.checkSchemeCheckBox();
		patientRegistrationPage.selectSchemeFromDropdown(1);
		patientRegistrationPage.clickOnRegisterIcon();
		assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
		patientRegistrationPage.yesButtonOnConfirmPopup();
		assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
		String patientRegistrationId =	patientRegistrationPage.getUHIDOfPatient();
		System.out.println("Patient Registration Id is " +patientRegistrationId);


		patientRegistrationPage.clickOnNoButtonOnRegisteredSuccessfullyPopup();
		//
		//		driver.getURL();
		//		hisHomePage.loginToTriotreeHIS();
		//		hisHomePage.clickOnFronOfficeIcon();
		//		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		//assertTrue(billingPage.verifyMandatoryDocumentMessage("Please select mandatory document"), "Alert not showing up Clicking on save without selecting Mandatory Documents");
		//		billingPage.checkCaseRecordCheckboxFromDocumentCheckList();
		//		billingPage.checkPanCardCheckboxFromDocumentCheckList();
		//		billingPage.checkForm60CheckboxFromDocumentCheckList();
		//		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		billingPage.closeCompanyDetailsPopup();
		billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
		billingPage.closeSchemeDetailsPopup();
		billingPage.closeRemarksPopup();
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
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnInsuranceCompanyButton();
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "0", "0");
		assertTrue(billingPage.isDiscountExceededMessageDisplayed(), "Dicount Can Not be exceeded to Patient Payble Amount Message is is not displayed");
	}
}