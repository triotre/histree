package com.triotree.test.website.FrontOffice;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.test.base.ResultListener;
import com.triotree.test.website.TTWebsiteBaseTest;
import com.triotree.utils.DBUtil;
import com.triotree.utils.PropertyFile;
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


	@Test(priority = 1) //fixed 26-05-2020
	public void frontOfficeBillingenterChequeDetailsAndSaveDetailsTestCase() throws Throwable 
	{
		test=extent.createTest("frontOfficeBillingenterChequeDetailsAndSaveDetailsTestCase", "This test case verify the Fornt Office Billing First Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage=new BillingPage(driver);

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

		//
		//		driver.getURL();
		//		hisHomePage.loginToTriotreeHIS();
		//		hisHomePage.clickOnFronOfficeIcon();
		//		hisHomePage.selectStationAndClickOnYes("Front Office");


		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		try {
			billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
			billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "CGHS COMPANY", "Trio Tree Noida", "NEW CGHS", "5", "10");
			//billingPage.selectSchemeAuthorisedSchemeDetailsPopup("New Scheme", "anshul agarwal", "Today Testing");
			billingPage.clickonschemedetails();
		}
		catch (Exception e) {
		}
		try {
			billingPage.closevalidityschemepopup();
		}
		catch (Exception e) {}
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {}
		billingPage.closeRemarksPopup();

		billingPage.selectSpecialityFromChooseSpecialityDropdown("cardiology1");
		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined(" Abhin  Lazar");
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
		
//		billingPage.clickOnInsuranceCompanyButton();
//		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
//		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "100", "50");
//		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		try {
		billingPage.clickOnInsuranceCompanyButton();
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "CGHS COMPANY", "Trio Tree Noida", "NEW CGHS", "5", "10");
		billingPage.clickonschemedetails();
		}
		catch (Exception e) {
		}
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		
		
		///////////////////////////Not Functioning
		//		billingPage.enterPatientPaidAmount("500");
		//		billingPage.clickOnNewPaymentModeButton();
		//		billingPage.selectSecondPaymentModeAsCheque();
		//		billingPage.enterChequeDetailsAndSaveDetails("123456789", "State Bank of India", "Noida");
		//		//assertTrue(billingPage.verifyBillGotGenerated("generated successfully"), "Bill did not got generated");
		//		billingPage.clickonYesButtonOnBillGotGenertedPopup(); //add by nishant

	}

	@Test(priority = 2) //fixed 26-05-2020
	public void frontOfficeBillingclickOnAddToBillButtonTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingclickOnAddToBillButtonTestCase", "This test case verify front Office Billing click On Add To Bill Button Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage=new BillingPage(driver);

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
		patientRegistrationPage.clickOnYesButtonOnRegisteredSuccessfullyPopup();
		//assertTrue(patientRegistrationPage.verifyUserIsOnBillingScreen("Billing"), "User is not on Billing Screen");
		try {
			billingPage.closevalidityschemepopup();
		}
		catch (Exception e) {}

		try {
			billingPage.closeSchemeDetailsPopup();
		}
		catch (Exception e) {}
		try {
			billingPage.closeSchemeForPatientPopup();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			billingPage.closeRemarksPopup();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//billingPage.selectSpecialityFromChooseSpecialityDropdown("Pathologist");
		//billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined(" Anika  Singh");
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
		//assertTrue(billingPage.verifyDailyDiscountLimitMessage("Daily discount limit for the patient in this schem"), "Daily Discount Limit Message is not showing up");

	}

	@Test(priority = 3) //fixed 26-05-2020
	public void frontOfficeBillingandselectSecondPaymentModeAsChequeTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingandselectSecondPaymentModeAsChequeTestCase", "This test case verify the front Office Billing and select Second Payment Mode As Cheque Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

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
		patientRegistrationPage.clickOnYesButtonOnRegisteredSuccessfullyPopup();
		//assertTrue(patientRegistrationPage.verifyUserIsOnBillingScreen("Billing"), "User is not on Billing Screen");
		try {
			billingPage.closevalidityschemepopup();
		}
		catch (Exception e) {}
		try {
			billingPage.clickandclosebuttonDocumentChecklist();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "CGHS COMPANY", "Trio Tree Noida", "NEW CGHS", "0", "0");
			//billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
			billingPage.clickonschemedetails();
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

	@Test(priority = 4) //pass and fixed 26-05-2020
	public void frontOfficeBillingclickOnNoButtonOnBillGotGeneratedPopupTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingclickOnNoButtonOnBillGotGeneratedPopupTestCase", "This test case verify the front Office Billing click On No Button On Bill Got Generated Popup Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage=new BillingPage(driver);

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
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		//billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		try {
			billingPage.closevalidityschemepopup();
		}
		catch (Exception e) {}

		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {}
		billingPage.closeRemarksPopup();

//		billingPage.selectSpecialityFromChooseSpecialityDropdown("Cardiology");
//		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined(" MANNAT  DEVGAN");
//		billingPage.selectScheduleSlotAndToken("54"); // new functionality is added
//		billingPage.clickOnDiagnosticIcon();
//		billingPage.selectTestsByName("24 hour urine 5HIAA");
//		//assertTrue(billingPage.verifyPriceNotDefinedMessage("Price not defined for this service"), "Price Not Defined Message is not showing up");
////		billingPage.selectTestsByName("24 hour Urine Aldosterone");
////		billingPage.selectTestsByName("24 hour Urine Free Cortisol");
////		billingPage.selectTestsByName("Phosphorus - Inorganic 24hr Urine");
//		billingPage.selectAllTestSpecialityAndDoctorName("Cardiology", "MANNAT  DEVGAN");
//		billingPage.clickOnYesButtonOnPatientMappedPopup();
//		billingPage.clickOnManualIcon();
//		billingPage.selectServiceNameFromDropdown("Cardiology Services");
//		billingPage.enterDescriptionInManualSection("cardic");
//		billingPage.selectQuantityInManualSection("50");
//		billingPage.enterPriceInManualSection("100");
//		billingPage.clickOnVerifyButton();
//		billingPage.clickOnOtherServicesIcon();
//		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
//		//assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
//		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Blood Bank" , "Cross matching");
//		//billingPage.selectSpecialityAndDoctor();
//		billingPage.selectSpecialityAndDoctor("Cardiology", "MANNAT  DEVGAN");
//		billingPage.enterRefferedBy("Self");
//		billingPage.selectFacilitatorFromDropdown(1);
//
//		billingPage.clickOnInsuranceCompanyButton();
//		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
//		try {
//			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "CGHS COMPANY", "Trio Tree Noida", "NEW CGHS", "0", "0");
//			billingPage.clickonschemedetails();
//		}
//		catch (Exception e) {}
//		//billingPage.selectSchemeAuthorisedSchemeDetailsPopup("All Keral Blood Donors Scheme", "testing master", "Today Testing");
//
//		//		try {
//		//			billingPage.okButtonSchemePopup();
//		//		} catch (Exception e) {
//		//			// TODO Auto-generated catch block
//		//			e.printStackTrace();
//		//		}
//		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
//		billingPage.clickOnBillingButtonOnHeader();
//		//		billingPage.clickOnyesBtnOnGenrateBillPopup();
//		//		billingPage.enterPatientPaidAmount("500");
//		//		billingPage.clickOnNewPaymentModeButton();
//		//		billingPage.selectSecondPaymentModeAsCheque();
//		//		billingPage.enterChequeDetailsAndSaveDetails("123456789", "State Bank of India", "Noida");
//		//		assertTrue(billingPage.verifyBillGotGenerated("generated successfully"), "Bill did not got generated");
//		//		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
//		//assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
//		//billingPage.clickOnYesButtonOnOpdPopup();

	}

	@Test(priority = 5) //pass and fixed 26-05-2020
	public void frontOfficeBillingPercentageProcessDiscountTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingPercentageProcessDiscountTestCase", "This test case verify the front Office Billing Percentage Process Discount TestCase");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

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

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		//billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		try {
			billingPage.closevalidityschemepopup();
		}
		catch (Exception e) {}
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {}
		billingPage.closeRemarksPopup();

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


		billingPage.clickOnInsuranceCompanyButton();
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "CGHS COMPANY", "Trio Tree Noida", "NEW CGHS", "0", "0");
		billingPage.clickonschemedetails();
		try {
			billingPage.clickOnInsuranceCompanyButton();
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "CGHS COMPANY", "Trio Tree Noida", "NEW CGHS", "0", "0");
			billingPage.clickonschemedetails();
		}
		catch (Exception e) {
		}
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		assertTrue(billingPage.isPercentageProcessDiscountMessageDisplayed(), "Percentage Process Discount Message is NOT Displayed");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		assertTrue(billingPage.isEnterDiscountErrorMessageDisplayed(), "Enter Discount Error Message is NOT Displayed");

		//		billingPage.selectDiscountOnFromDropdown("On Bill");
		//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//		assertTrue(billingPage.isEnterDiscountErrorMessageDisplayed(), "Enter Discount Error Message is NOT Displayed");
		//		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		//		billingPage.selectDiscountReasonFromDropdown("10% Automation Testing");
		//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//		assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		//		billingPage.selectAuthorisedByFromDropdown("Management Decision");
		//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//		billingPage.clickOnDraftButtonOnHeader();
		//Thread.sleep(10000);		

	}

	@Test(priority = 6) //pass and fixed 26-05-2020
	public void frontOfficeBillingProcessPaymentTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingProcessPaymentTestCase", "This test case verify the front Office Billing Process Payment Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

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
		
		patientRegistrationPage.showAllCheckBox();/////////////////////////////////////not clicked issues arise
		
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

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		
		try {
			billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
			billingPage.closevalidityschemepopup();
		}
		catch (Exception e) {}
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {}
		billingPage.closeRemarksPopup();

		billingPage.selectSpecialityFromChooseSpecialityDropdown("Cardiology");
		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined(" MANNAT  DEVGAN");
		billingPage.selectScheduleSlotAndToken("54"); // new functionality is added
		billingPage.clickOnDiagnosticIcon();
		billingPage.selectTestsByName("24 hour urine 5HIAA");
		//assertTrue(billingPage.verifyPriceNotDefinedMessage("Price not defined for this service"), "Price Not Defined Message is not showing up");
		//billingPage.selectTestsByName("24 hour Urine Aldosterone");
		//billingPage.selectTestsByName("24 hour Urine Free Cortisol");
		//billingPage.selectTestsByName("Phosphorus - Inorganic 24hr Urine");
		billingPage.selectAllTestSpecialityAndDoctorName("Cardiology", "MANNAT  DEVGAN");
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


		billingPage.clickOnInsuranceCompanyButton();
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "CGHS COMPANY", "Trio Tree Noida", "NEW CGHS", "0", "0");
		billingPage.clickonschemedetails();
		try {
			billingPage.clickOnInsuranceCompanyButton();
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "CGHS COMPANY", "Trio Tree Noida", "NEW CGHS", "0", "0");
			billingPage.clickonschemedetails();
		}
		catch (Exception e) {
		}
		//billingPage.clickOnAddToBillButton();
		//assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.clickonYesButtonOnBillGotGenertedPopup();
		billingPage.clickOnYesButtonOnOpdPopup();

		//		billingPage.clickOnBillingButtonOnHeader();
		//		billingPage.clickOnyesBtnOnGenrateBillPopup();
		//		billingPage.enterPatientPaidAmount("50");
		//		billingPage.clickOnNewPaymentModeButton();
		//		billingPage.selectSecondPaymentModeAsCheque();
		//		//billingPage.enterPatientPaidAmountForCheque("1000");
		//		billingPage.enterChequeDetailsAndSaveDetails("123456789", "State Bank of India", "Noida");		
		//		billingPage.selectAuthorisedByFromProcessPaymentDropdown("anshul");
		//		billingPage.enterRemarsInProcessPaymentPopup("Testing Remarks");
		//		billingPage.clickOnVerifyButtonOnProcessPayment();
		//		assertTrue(billingPage.verifyBillGotGenerated("generated successfully"), "Bill did not got generated");
		//		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		//assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
		//billingPage.clickOnYesButtonOnOpdPopup();

	}


	@Test(priority = 7) //pass and fixed 26-05-2020
	public void frontOfficeBillingverifyPrintOPDMessageIsDisplayingTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingverifyPrintOPDMessageIsDisplayingTestCase", "This test case verify the front Office Billing verify Print OPD Message Is Displaying Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

		String schemeExpiredPatienId = propertyFile.getProperty("schemeExpiredPatient");

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");		
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeaderSecondMethod("RAJH.17152860");
		//assertTrue(billingPage.verifySchemeExpiryPopupMessage("The validity of this patients association with scheme is expired. Please extend the validity or remove scheme!"), "Scheme Expiry Popup is not showing up");
		//billingPage.closeSchemeExpiryPopup();
		try {
			billingPage.closevalidityschemepopup();
		}
		catch (Exception e) {}
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {}
		billingPage.closeRemarksPopup();
		//assertTrue(billingPage.verifyMandatoryDocumentMessage("Please select mandatory document"), "Alert not showing up Clicking on save without selecting Mandatory Documents");
		//billingPage.checkCaseRecordCheckboxFromDocumentCheckList();
		//billingPage.checkPanCardCheckboxFromDocumentCheckList();
		//billingPage.checkForm60CheckboxFromDocumentCheckList();
		//billingPage.clickOnSaveButtonOnDocumentChecklistPopup();

		//billingPage.closeCompanyDetailsPopup();

		//billingPage.closeRemarksPopup();
		billingPage.clickPreviousVisitIcon();
		assertTrue(billingPage.isPreviousVisitPopupOpened(), "Previous Visit Popup is not opened");
		billingPage.closePreviousVisitPopup();

		//choose speciality
		billingPage.selectSpecialityFromChooseSpecialityDropdown("Cardiology");
		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined(" MANNAT  DEVGAN");
		billingPage.selectScheduleSlotAndToken("54"); 
		//Diagnostic Test
		billingPage.clickOnDiagnosticIcon();
		billingPage.selectTestsByName("24 hour Urine Cortisol");
		//assertTrue(billingPage.verifyPriceNotDefinedMessage("Price not defined for this service"), "Price Not Defined Message is not showing up");
		billingPage.selectTestsByName("24 hour Urine Aldosterone");
		billingPage.selectTestsByName("24 hour Urine Free Cortisol");
		billingPage.selectTestsByName("Phosphorus - Inorganic 24hr Urine");
		billingPage.selectAllTestSpecialityAndDoctorName("Cardiology", "MANNAT  DEVGAN");

		//Manual Icon 
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

		billingPage.clickOnInsuranceCompanyButton();
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "CGHS COMPANY", "Trio Tree Noida", "NEW CGHS", "5", "10");
		billingPage.clickonschemedetails();
		try {
			billingPage.clickOnInsuranceCompanyButton();
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "CGHS COMPANY", "Trio Tree Noida", "NEW CGHS", "5", "10");
			billingPage.clickonschemedetails();
		}
		catch (Exception e) {
		}
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		assertTrue(billingPage.isPercentageProcessDiscountMessageDisplayed(), "Percentage Process Discount Message is NOT Displayed");
		billingPage.selectDiscountOnFromDropdown("On Service");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selectDiscountHeadFromDropdown("Staff Dependent");
		billingPage.selectDiscountReasonFromDropdown("Investigation Discount");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		billingPage.selectAuthorisedByFromDropdown("anshul");
		billingPage.selectOnCompanyRadioButton();
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		assertTrue(patientRegistrationPage.verifymessagedisplay("Discount of given % cannot be saved as Maximum Discount allowed in billing service item is applicable!"), "Verify that Discount of given % cannot be saved as Maximum Discount allowed in billing service item is applicable!");
		billingPage.closeprocessdiscountpopup();
		try {
			billingPage.clickOnBillingButtonOnHeader();
		}
		catch (Exception e) {}
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		///write save button logic
		billingPage.clickonProcesspaymentsavebutton();
		billingPage.clickonYesButtonOnBillGotGenertedPopup();
		billingPage.clickOnYesButtonOnOpdPopup();

		//		billingPage.clickOnBillingButtonOnHeader();
		//		billingPage.clickOnyesBtnOnGenrateBillPopup();
		//		billingPage.enterPatientPaidAmount("5000");
		//		billingPage.clickOnNewPaymentModeButton();
		//		billingPage.selectSecondPaymentModeAsCheque();
		//		billingPage.enterChequeDetailsAndSaveDetails("123456789", "State Bank of India", "Noida");		
		//		billingPage.clickOnVerifyButtonOnProcessPayment();
		//		assertTrue(billingPage.verifyBillGotGenerated("generated successfully"), "Bill did not got generated");
		//		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		//assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
		//billingPage.clickOnYesButtonOnOpdPopup();
	}

	@Test(priority = 8) //fixed 27-05-2020
	public void frontOfficeBillingNewPaymentModeTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingNewPaymentModeTestCase", "This test case verify the front Office Billing New Payment Mode Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

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

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		//billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		try {
			billingPage.closevalidityschemepopup();
		}
		catch (Exception e) {}
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {}
		billingPage.closeRemarksPopup();

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
		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		//assertTrue(billingPage.isPercentageProcessDiscountMessageDisplayed(), "Percentage Process Discount Message is NOT Displayed");
//		billingPage.selectDiscountOnFromDropdown("On Items");
//		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
//		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("24 hour Urine Cortisol");
//		billingPage.selectDiscountHeadFromDropdown("Staff Dependent");
//		billingPage.selectDiscountReasonFromDropdown("Investigation Discount");
//
//		//billingPage.enterDiscountAmount("500");
//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
//		//assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
//		billingPage.selectAuthorisedByFromDropdown("anshul agarwal");
//		billingPage.selectOnCompanyRadioButton();
//		billingPage.enterDiscountAmount("5");
//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
//		//assertTrue(billingPage.isCompOnlyDiscoutErrorMessageDisplayed(), "Comp Only Discount Error Message is NOT Displayed");
//		billingPage.selectOnPatientRadioButton();
//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
//		billingPage.clickOnBillingButtonOnHeader();
//		billingPage.clickOnyesBtnOnGenrateBillPopup();
//		billingPage.enterPatientPaidAmount("5000");
//		billingPage.clickOnNewPaymentModeButton();
//		billingPage.selectSecondPaymentModeAsCheque();
//		billingPage.enterChequeDetailsAndSaveDetails("123456789", "State Bank of India", "Noida");		
//		billingPage.clickOnVerifyButtonOnProcessPayment();
//		assertTrue(billingPage.verifyBillGotGenerated("generated successfully"), "Bill did not got generated");
//		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
//		//assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
//		//billingPage.clickOnYesButtonOnOpdPopup();
	}

	@Test(priority = 9) 
	public void frontOfficeBillingMarkPatientDeceasedTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingMarkPatientDeceasedTestCase", "This test case verify the front Office Billing Mark Patient Deceased Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		markPatientDeceasedPage = new MarkPatientDeceasedPage(driver);

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
		//billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		try {
			billingPage.closevalidityschemepopup();
		}
		catch (Exception e) {}
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {}
		billingPage.closeRemarksPopup();

//		billingPage.selectSpecialityFromChooseSpecialityDropdown("Cardiology");
//		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined(" MANNAT  DEVGAN");
//		billingPage.selectScheduleSlotAndToken("54"); // new functionality is added
//		billingPage.clickOnDiagnosticIcon();
//		billingPage.selectTestsByName("24 hour urine 5HIAA");
//		//assertTrue(billingPage.verifyPriceNotDefinedMessage("Price not defined for this service"), "Price Not Defined Message is not showing up");
////		billingPage.selectTestsByName("24 hour Urine Aldosterone");
////		billingPage.selectTestsByName("24 hour Urine Free Cortisol");
////		billingPage.selectTestsByName("Phosphorus - Inorganic 24hr Urine");
//		billingPage.selectAllTestSpecialityAndDoctorName("Cardiology", "MANNAT  DEVGAN");
//		billingPage.clickOnYesButtonOnPatientMappedPopup();
//		billingPage.clickOnManualIcon();
//		billingPage.selectServiceNameFromDropdown("Cardiology Services");
//		billingPage.enterDescriptionInManualSection("cardic");
//		billingPage.selectQuantityInManualSection("50");
//		billingPage.enterPriceInManualSection("100");
//		billingPage.clickOnVerifyButton();
//		billingPage.clickOnOtherServicesIcon();
//		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
//		//assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
//		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Blood Bank" , "Cross matching");
//		//billingPage.selectSpecialityAndDoctor();
//		billingPage.selectSpecialityAndDoctor("Cardiology", "MANNAT  DEVGAN");
//		billingPage.enterRefferedBy("Self");
//		billingPage.selectFacilitatorFromDropdown(1);
//		billingPage.clickOnAddToBillButton();
//
//		assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
//		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
//		billingPage.checkDiscountCheckbox();
//		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
//		assertTrue(billingPage.isPercentageProcessDiscountMessageDisplayed(), "Percentage Process Discount Message is NOT Displayed");
//		billingPage.selectDiscountOnFromDropdown("On Items");
//		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
//		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("24 hour Urine Cortisol");
//		billingPage.selectDiscountHeadFromDropdown("Staff Dependent");
//		billingPage.selectDiscountReasonFromDropdown("Investigation Discount");
//
//		//billingPage.enterDiscountAmount("500");
//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
//		//assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
//		billingPage.selectAuthorisedByFromDropdown("anshul agarwal");
//		billingPage.selectOnCompanyRadioButton();
//		billingPage.enterDiscountAmount("5");
//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
//		//assertTrue(billingPage.isCompOnlyDiscoutErrorMessageDisplayed(), "Comp Only Discount Error Message is NOT Displayed");
//		billingPage.selectOnPatientRadioButton();
//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
//		billingPage.clickOnBillingButtonOnHeader();
//		billingPage.clickOnyesBtnOnGenrateBillPopup();
//		billingPage.enterPatientPaidAmount("5000");
//		billingPage.clickOnNewPaymentModeButton();
//		billingPage.selectSecondPaymentModeAsCheque();
//		billingPage.enterChequeDetailsAndSaveDetails("123456789", "State Bank of India", "Noida");		
//		billingPage.clickOnVerifyButtonOnProcessPayment();
//		billingPage.clickOnYesButtonOnOpdPopup();
//		//assertTrue(billingPage.verifyBillGotGenerated("generated successfully"), "Bill did not got generated");
//		//billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
//		//		assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
//		//		

	}

	@Test(priority = 10) 
	public void frontOfficeBillingsearchPatientWithMobileNumberTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingsearchPatientWithMobileNumberTestCase", "This test case verify the front Office Billing search Patient With Mobile Number Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

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

		//
		//		driver.getURL();
		//		hisHomePage.loginToTriotreeHIS();
		//		hisHomePage.clickOnFronOfficeIcon();
		//		hisHomePage.selectStationAndClickOnYes("Front Office");


		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		try {
			billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
			billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "CGHS COMPANY", "Trio Tree Noida", "NEW CGHS", "5", "10");
			//billingPage.selectSchemeAuthorisedSchemeDetailsPopup("New Scheme", "anshul agarwal", "Today Testing");
			billingPage.clickonschemedetails();
		}
		catch (Exception e) {
		}
		try {
			billingPage.closevalidityschemepopup();
		}
		catch (Exception e) {}
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {}
		billingPage.closeRemarksPopup();

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
		
//		billingPage.clickOnInsuranceCompanyButton();
//		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
//		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "100", "50");
//		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		try {
		billingPage.clickOnInsuranceCompanyButton();
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "CGHS COMPANY", "Trio Tree Noida", "NEW CGHS", "5", "10");
		billingPage.clickonschemedetails();
		}
		catch (Exception e) {
		}
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.clickOnYesButtonOnAvailDepositPopup();

		billingPage.checkDiscountCheckbox();

		billingPage.clickOnYesBtnUnderProvideDiscountPopup();


		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("24 hour urine 5HIAA");
		billingPage.selectDiscountHeadFromDropdown("Special Discount");
		billingPage.selectDiscountReasonFromDropdown("Specail Discount 10%");

		//		
		//		billingPage.enterDiscountAmount("20000");
		//		billingPage.enterDiscountAmount("500");
		//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//		assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		//billingPage.selectAuthorisedByFromDropdown("As per MOU of NDMC");
		//		billingPage.selectOnCompanyRadioButton();
		//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//		assertTrue(billingPage.isCompOnlyDiscoutErrorMessageDisplayed(), "Comp Only Discount Error Message is NOT Displayed");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		billingPage.selectAuthorisedByFromDropdown("anshul agarwal");
		//billingPage.selectOnCompanyRadioButton();
		//billingPage.enterDiscountAmount("5");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//assertTrue(billingPage.isCompOnlyDiscoutErrorMessageDisplayed(), "Comp Only Discount Error Message is NOT Displayed");
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		billingPage.enterPatientPaidAmount("500");


		billingPage.clickOnNewPaymentModeButton();
		billingPage.selectSecondPaymentMode("Debit Card");
		billingPage.enterPatientPaidAmountForSecondTransaction("200");
		billingPage.enterCardDetailsAndSaveDetails("MASTERCARD", "123456789", "Andhra Bank", "2222222222");
		billingPage.selectAythorisedByInProcessPaymentPopupAndAddRemarks("anshul agarwal");
		billingPage.clickOnVerifyButtonOnProcessPaymentPopup();
		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		billingPage.clickOnNoButtonOnPrintOPDCard();
	}

	@Test(priority = 11) 
	public void frontOfficeBillingMergeDuplicatesTestCase() throws Throwable {

		test=extent.createTest("frontOfficeBillingMergeDuplicatesTestCase", "This test case verify the front Office Billing Merge Duplicates Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		mergeAndUnmergeDuplicatePage = new MergeAndUnmergeDuplicatePage(driver);

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

		//Second Patient Registration
		frontOfficeHomePage.clickOnMenu();
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
		String patientRegistrationId2 =	patientRegistrationPage.getUHIDOfPatient();
		System.out.println("Second Patient Registration Id is " +patientRegistrationId2);
		patientRegistrationPage.clickOnNoButtonOnRegisteredSuccessfullyPopup();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Merge Duplicates");
		mergeAndUnmergeDuplicatePage.enterFirstNameAndPressEnter("Demo");
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
		try {
			billingPage.closevalidityschemepopup();
		}
		catch (Exception e) {}
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {}
		billingPage.closeRemarksPopup();

		billingPage.clickClearButtonOnHeader();
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeaderSecondMethod(secondPatient);
		assertTrue(billingPage.verifyPatientMappedPopup("Selected UHId has been mapped with"), "Patient Mapped Popup is not showing up");
		patientRegistrationPage.patientdeceasedok();

		try {
			billingPage.closevalidityschemepopup();
		}
		catch (Exception e) {}
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {}
		billingPage.closeRemarksPopup();

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
		try {
			billingPage.clickonschemedetails();
			billingPage.clickOnAddToBillButton();
		}
		catch (Exception e) {}
		//assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		assertTrue(billingPage.isPercentageProcessDiscountMessageDisplayed(), "Percentage Process Discount Message is NOT Displayed");
		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("24 hour urine 5HIAA");
		billingPage.selectDiscountHeadFromDropdown("Staff Dependent");
		billingPage.selectDiscountReasonFromDropdown("Investigation Discount");


		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		billingPage.selectAuthorisedByFromDropdown("anshul agarwal");
		billingPage.selectOnCompanyRadioButton();
		billingPage.enterDiscountAmount("5");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//assertTrue(billingPage.isCompOnlyDiscoutErrorMessageDisplayed(), "Comp Only Discount Error Message is NOT Displayed");
		billingPage.selectOnPatientRadioButton();
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		//Assert.assertTrue(patientRegistrationPage.verifymessagedisplay("there is no token to be assigned for this doctor"));
//		billingPage.enterPatientPaidAmount("5000");
//		billingPage.clickOnNewPaymentModeButton();
//		billingPage.selectSecondPaymentModeAsCheque();
//		billingPage.enterChequeDetailsAndSaveDetails("123456789", "State Bank of India", "Noida");		
//		billingPage.clickOnVerifyButtonOnProcessPayment();
//		billingPage.clickOnYesButtonOnOpdPopup();
		//assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
		//billingPage.clickOnYesButtonOnOpdPopup();

	}
	
	@Test(priority = 12) //fixed 27-05-2020
	public void frontOfficeBillingselectInsuranceCompTestCase() throws Throwable {	

		test=extent.createTest("frontOfficeBillingselectInsuranceCompTestCase", "This test case verify the front Office Billing select Insurance Comp Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

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

		//
		//		driver.getURL();
		//		hisHomePage.loginToTriotreeHIS();
		//		hisHomePage.clickOnFronOfficeIcon();
		//		hisHomePage.selectStationAndClickOnYes("Front Office");


		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		try {
			billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
			billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "CGHS COMPANY", "Trio Tree Noida", "NEW CGHS", "5", "10");
			//billingPage.selectSchemeAuthorisedSchemeDetailsPopup("New Scheme", "anshul agarwal", "Today Testing");
			billingPage.clickonschemedetails();
		}
		catch (Exception e) {
		}
		try {
			billingPage.closevalidityschemepopup();
		}
		catch (Exception e) {}
		try {
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {}
		billingPage.closeRemarksPopup();

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
		
//		billingPage.clickOnInsuranceCompanyButton();
//		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
//		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "100", "50");
//		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		try {
		billingPage.clickOnInsuranceCompanyButton();
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "CGHS COMPANY", "Trio Tree Noida", "NEW CGHS", "5", "10");
		billingPage.clickonschemedetails();
		}
		catch (Exception e) {
		}
		//assertTrue(billingPage.isDiscountExceededMessageDisplayed(), "Dicount Can Not be exceeded to Patient Payble Amount Message is is not displayed");
	}
}