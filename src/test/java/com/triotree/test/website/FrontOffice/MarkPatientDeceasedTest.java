package com.triotree.test.website.FrontOffice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.triotree.test.base.ResultListener;
import com.triotree.test.website.TTWebsiteBaseTest;
import com.triotree.website.pages.CommonPages.HISHomePage;
import com.triotree.website.pages.FrontOffice.BillingPage;
import com.triotree.website.pages.FrontOffice.FrontOfficeHomePage;
import com.triotree.website.pages.FrontOffice.GenerateSchedulePage;
import com.triotree.website.pages.FrontOffice.MarkPatientDeceasedPage;
import com.triotree.website.pages.FrontOffice.PatientRegistrationPage;

@Listeners(ResultListener.class)
public class MarkPatientDeceasedTest extends TTWebsiteBaseTest{

	private static final Logger logger = LogManager
			.getLogger(PatientRegistrationTest.class.getName());

	private HISHomePage hisHomePage;
	private FrontOfficeHomePage frontOfficeHomePage;
	private PatientRegistrationPage patientRegistrationPage;
	private MarkPatientDeceasedPage markPatientDeceasedPage;
	private BillingPage billingPage;
	private GenerateSchedulePage generateSchedulePage;

	private String patientRegistrationId = "AHHS.8996";
	private String desc = null;
	private String title1 = null;
	private String desc1 = null;


	@Test(priority = 1)
	public void markPatientDeceasedTest() throws Throwable {
		
		test=extent.createTest("markPatientDeceasedTest", "This test case is Mark Patient Deceased Test");
		test.assignCategory("Front Office");
		
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		markPatientDeceasedPage = new MarkPatientDeceasedPage(driver);
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
		
		patientRegistrationPage.clickOnYesButtonOnRegisteredSuccessfullyPopup();
		assertTrue(patientRegistrationPage.verifyUserIsOnBillingScreen("Billing"), "User is not on Billing Screen");
		billingPage.closeCompanyDetailsPopup();
		billingPage.closeSchemeDetailsPopup();
		try {
			billingPage.cancelSchemeForPatientPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.closeRemarksPopup();
		
		
		frontOfficeHomePage.clickOnMenu();
		
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Mark Patient Deceased");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		markPatientDeceasedPage.checkDeceasedCheckbox();
		markPatientDeceasedPage.enterInformedBy("DOCTOR");
		markPatientDeceasedPage.clickOnSaveIcon();
		markPatientDeceasedPage.yesButtonOnMarkPatientDeceasedPopup();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		assertTrue(patientRegistrationPage.verifyPatientDeceasedPopupPresence("Patient is deceased!"), "When Deceased Patient is searched in Patient Registration, Deceased popup is nto showing up");
		patientRegistrationPage.clickOnYesButtonOnRegisteredSuccessfullyPopup();

	}

	@Test(priority = 2)
	public void markPatientDeceasedSearchPatientTest() throws Throwable {
		test=extent.createTest("markPatientDeceasedSearchPatientTest", "This test case is Mark Patient Deceased Search PatientTest");
		test.assignCategory("Front Office");
		
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		markPatientDeceasedPage = new MarkPatientDeceasedPage(driver);
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
		assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
		patientRegistrationPage.yesButtonOnConfirmPopup();
		assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
		String patientRegistrationId =	patientRegistrationPage.getUHIDOfPatient();
		System.out.println("Patient Registration Id is " +patientRegistrationId);
		patientRegistrationPage.clickOnYesButtonOnRegisteredSuccessfullyPopup();
		assertTrue(patientRegistrationPage.verifyUserIsOnBillingScreen("Billing"), "User is not on Billing Screen");
		billingPage.closeCompanyDetailsPopup();
		billingPage.closeSchemeDetailsPopup();
		try {
			billingPage.cancelSchemeForPatientPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.closeRemarksPopup();
		
		
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Mark Patient Deceased");
		markPatientDeceasedPage.clickOnSearchIcon();
		
		patientRegistrationPage.searchMobileNumberAndClickOnEnter("12");
		assertTrue(patientRegistrationPage.verifyErrorMessageOfEnteringLesserCharacters("Plese enter atleast 3 charecters"), "Less than three characters in search is not throwing Error");
		patientRegistrationPage.clearMobileNumberField();
		patientRegistrationPage.searchNameAndClickOnEnter("ab");
		assertTrue(patientRegistrationPage.verifyErrorMessageOfEnteringLesserCharacters("Plese enter atleast 3 charecters"), "Less than three characters in search is not throwing Error");
		patientRegistrationPage.clearNameField();
		patientRegistrationPage.searchFirstNameAndClickOnEnter("ab");
		assertTrue(patientRegistrationPage.verifyErrorMessageOfEnteringLesserCharacters("Plese enter atleast 3 charecters"), "Less than three characters in search is not throwing Error");
		patientRegistrationPage.clearFirstNameField();
		patientRegistrationPage.searchLastNameAndClickOnEnter("ab");
		assertTrue(patientRegistrationPage.verifyErrorMessageOfEnteringLesserCharacters("Plese enter atleast 3 charecters"), "Less than three characters in search is not throwing Error");
		patientRegistrationPage.clearLastNameField();
		patientRegistrationPage.searchAddressAndClickOnEnter("Ad");
		assertTrue(patientRegistrationPage.verifyErrorMessageOfEnteringLesserCharacters("Plese enter atleast 3 charecters"), "Less than three characters in search is not throwing Error");
		patientRegistrationPage.clearAddressField();
		patientRegistrationPage.searchLocalityAndClickOnEnter("Lo");
		assertTrue(patientRegistrationPage.verifyErrorMessageOfEnteringLesserCharacters("Plese enter atleast 3 charecters"), "Less than three characters in search is not throwing Error");
		patientRegistrationPage.clearLocalityField();
		patientRegistrationPage.searchNationalIdAndClickOnEnter("Na");
		assertTrue(patientRegistrationPage.verifyErrorMessageOfEnteringLesserCharacters("Plese enter atleast 3 charecters"), "Less than three characters in search is not throwing Error");
		patientRegistrationPage.clearNationalityField();

		patientRegistrationPage.searchMobileNumberAndClickOnEnter("1234512345");
		//assertTrue(patientRegistrationPage.verifyResultIsShowingUpInSearchPopupScreen(), "Results are not showing up in Search Popup Screen");
		patientRegistrationPage.clearMobileNumberField();
		patientRegistrationPage.searchNameAndClickOnEnter("Automation");
		assertTrue(patientRegistrationPage.verifyResultIsShowingUpInSearchPopupScreen(), "Results are not showing up in Search Popup Screen");
		patientRegistrationPage.clearNameField();
		patientRegistrationPage.searchFirstNameAndClickOnEnter("Automation");
		assertTrue(patientRegistrationPage.verifyResultIsShowingUpInSearchPopupScreen(), "Results are not showing up in Search Popup Screen");
		patientRegistrationPage.clearFirstNameField();
		patientRegistrationPage.searchLastNameAndClickOnEnter("User");
		assertTrue(patientRegistrationPage.verifyResultIsShowingUpInSearchPopupScreen(), "Results are not showing up in Search Popup Screen");
		patientRegistrationPage.clearLastNameField();
		patientRegistrationPage.searchAddressAndClickOnEnter("Automation Test Address");
		assertTrue(patientRegistrationPage.verifyResultIsShowingUpInSearchPopupScreen(), "Results are not showing up in Search Popup Screen");
		patientRegistrationPage.clearAddressField();
		patientRegistrationPage.searchLocalityAndClickOnEnter("Test local");
		assertTrue(patientRegistrationPage.verifyResultIsShowingUpInSearchPopupScreen(), "Results are not showing up in Search Popup Screen");
		patientRegistrationPage.clearLocalityField();
		patientRegistrationPage.searchNationalIdAndClickOnEnter("12345");
		assertTrue(patientRegistrationPage.verifyResultIsShowingUpInSearchPopupScreen(), "Results are not showing up in Search Popup Screen");
		patientRegistrationPage.clearNationalityField();
		driver.waitForPageLoad();
	}
	
	@Test(priority = 3)
	public void revokeDeceasedPatientTest() throws Throwable {
		test=extent.createTest("revokeDeceasedPatientTest", "This test case is Mark Patient Deceased Search PatientTest");
		test.assignCategory("Front Office");
		
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
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
		patientRegistrationPage.clickOnYesButtonOnRegisteredSuccessfullyPopup();
//		assertTrue(patientRegistrationPage.verifyUserIsOnBillingScreen("Billing"), "User is not on Billing Screen");
		
		
		
		billingPage.closeCompanyDetailsPopup();
		billingPage.closeSchemeDetailsPopup();
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
		
		
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Mark Patient Deceased");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		markPatientDeceasedPage.checkDeceasedCheckbox();
		markPatientDeceasedPage.enterInformedBy("DOCTOR");
		markPatientDeceasedPage.clickOnSaveIcon();
		markPatientDeceasedPage.yesButtonOnMarkPatientDeceasedPopup();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		assertTrue(patientRegistrationPage.verifyPatientDeceasedPopupPresence("Patient is deceased!"), "When Deceased Patient is searched in Patient Registration, Deceased popup is nto showing up");
		patientRegistrationPage.clickOnYesButtonOnRegisteredSuccessfullyPopup();
		
		
		billingPage.closeCompanyDetailsPopup();
		billingPage.closeSchemeDetailsPopup();
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
		
		
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Mark Patient Deceased");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		markPatientDeceasedPage.unCheckDeceasedCheckbox();
		
		markPatientDeceasedPage.clickOnSaveIcon();
		markPatientDeceasedPage.yesButtonOnMarkPatientDeceasedPopup();

	}
	
	@Test(priority = 4)
	public void frontOfficeCancellationOfAllAppointmentOnMarkPatientDeceased() throws InterruptedException {
		
		test=extent.createTest("frontOfficeCancellationOfAllAppointmentOnMarkPatientDeceased", "This test case is front Office Cancellation Of All Appointment On Mark Patient Deceased Test");
		test.assignCategory("Front Office");
		
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		markPatientDeceasedPage = new MarkPatientDeceasedPage(driver);
		billingPage = new BillingPage(driver);
		generateSchedulePage = new GenerateSchedulePage(driver);

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
		patientRegistrationPage.clickOnYesButtonOnRegisteredSuccessfullyPopup();
		//assertTrue(patientRegistrationPage.verifyUserIsOnBillingScreen("Billing"), "User is not on Billing Screen");
		billingPage.closeCompanyDetailsPopup();
		billingPage.closeSchemeDetailsPopup();
		try {
			billingPage.cancelSchemeForPatientPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.closeRemarksPopup();
		
		
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Generate Schedule");
//		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Generate Schedule");
		generateSchedulePage.clickOnSearchButton();
		assertTrue(generateSchedulePage.verifyPleaseSelectSpecilizationMessage(), "Please Select Specialization Message not showing up");
		generateSchedulePage.clickOnPlusButton();
		assertTrue(generateSchedulePage.verifyPleaseSelectSpecialityMessage(), "Please Select Speciality Message not showing up");
		generateSchedulePage.selectSpecilizationFromDropdown("Ophthalmology");
		generateSchedulePage.selectDoctorFromDropdown("Archana G Mahajan");
		generateSchedulePage.clickOnSearchButton();
		assertTrue(generateSchedulePage.verifyNoScheduleExistMessage(), "No Schedule Exists Message not showing up");
		generateSchedulePage.selectSpecilizationFromDropdown("Anesthesiast");
		generateSchedulePage.selectDoctorFromDropdown("Sunil Agarwal");
		generateSchedulePage.clickOnPlusButton();
		generateSchedulePage.selectFacilityFromDropdown("TRIOTREE HOSPITAL");
		generateSchedulePage.enterFromDate("13/Feb/2019");
		driver.clickAnyWhereOnScreen();
		assertTrue(generateSchedulePage.verifyFromDateErrorMessage(), "Older Date is being Selected in From Date Column");
		generateSchedulePage.enterToDate("13/Feb/2019");
		driver.clickAnyWhereOnScreen();
		assertTrue(generateSchedulePage.verifyToDateErrorMessage(), "Older Date is being Selected in To Date Column");

		Date date = new Date();
		int currenthour= date.getHours();
		int fromHour = currenthour+1;
		int toHour = currenthour+1;
		String fromHourString = String.valueOf(fromHour);
		String toHourString = String.valueOf(toHour);
		String futureFromTime = fromHourString+":"+"30";
		String futureToTime = toHourString+":"+"40";

		int fromHourSitting2 = currenthour+2;
		int toHourSitting2 = currenthour+2;
		String fromHourStringSitting2 = String.valueOf(fromHourSitting2);
		String toHourStringSitting2 = String.valueOf(toHourSitting2);
		String futureFromTimeSitting2 = fromHourStringSitting2+":"+"30";
		String futureToTimeSitting2 = toHourStringSitting2+":"+"45";
		generateSchedulePage.selectFromTimeForSitting1(futureFromTime);
		generateSchedulePage.selectToTimeForSitting1(futureToTime);
		Calendar calendar = Calendar.getInstance();
		Date date1 = calendar.getTime();
		System.out.println(new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date1.getTime()));
		String currentDay = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date1.getTime());
		generateSchedulePage.selectDayCheckbox(currentDay);		
		generateSchedulePage.selectDayCheckbox("Sunday");	
		generateSchedulePage.selectRightCheckForSitting1();
		generateSchedulePage.enterRemarksForCurrentDayForSitting1("Remarks added by Automation Scripts", currentDay);		
		generateSchedulePage.selectFromTimeForSitting2(futureFromTimeSitting2);
		generateSchedulePage.selectToTimeForSitting2(futureToTimeSitting2);
		generateSchedulePage.selectRightCheckForSitting2();
		generateSchedulePage.enterRemarksForCurrentDayForSitting2("Remarks added by Automation Scripts", currentDay);
		generateSchedulePage.clickOnSaveButtonOnHeader();
		assertTrue(generateSchedulePage.verifyDoYouWantToSavePopupMessage("Do you want to save?"), "Do you want to save popup didnt opened");
		generateSchedulePage.clickOnSaveButtonOnSavePopup();
		//assertTrue(generateSchedulePage.isSaveSuccessfullyMessageShowsUp(), "Schedule didnt got saved");

		
		
		markPatientDeceasedPage.clickOnSearchIcon();
		
		patientRegistrationPage.searchMobileNumberAndClickOnEnter("12");
		assertTrue(patientRegistrationPage.verifyErrorMessageOfEnteringLesserCharacters("Plese enter atleast 3 charecters"), "Less than three characters in search is not throwing Error");
		patientRegistrationPage.clearMobileNumberField();
		patientRegistrationPage.searchNameAndClickOnEnter("ab");
		assertTrue(patientRegistrationPage.verifyErrorMessageOfEnteringLesserCharacters("Plese enter atleast 3 charecters"), "Less than three characters in search is not throwing Error");
		patientRegistrationPage.clearNameField();
		patientRegistrationPage.searchFirstNameAndClickOnEnter("ab");
		assertTrue(patientRegistrationPage.verifyErrorMessageOfEnteringLesserCharacters("Plese enter atleast 3 charecters"), "Less than three characters in search is not throwing Error");
		patientRegistrationPage.clearFirstNameField();
		patientRegistrationPage.searchLastNameAndClickOnEnter("ab");
		assertTrue(patientRegistrationPage.verifyErrorMessageOfEnteringLesserCharacters("Plese enter atleast 3 charecters"), "Less than three characters in search is not throwing Error");
		patientRegistrationPage.clearLastNameField();
		patientRegistrationPage.searchAddressAndClickOnEnter("Ad");
		assertTrue(patientRegistrationPage.verifyErrorMessageOfEnteringLesserCharacters("Plese enter atleast 3 charecters"), "Less than three characters in search is not throwing Error");
		patientRegistrationPage.clearAddressField();
		patientRegistrationPage.searchLocalityAndClickOnEnter("Lo");
		assertTrue(patientRegistrationPage.verifyErrorMessageOfEnteringLesserCharacters("Plese enter atleast 3 charecters"), "Less than three characters in search is not throwing Error");
		patientRegistrationPage.clearLocalityField();
		patientRegistrationPage.searchNationalIdAndClickOnEnter("Na");
		assertTrue(patientRegistrationPage.verifyErrorMessageOfEnteringLesserCharacters("Plese enter atleast 3 charecters"), "Less than three characters in search is not throwing Error");
		patientRegistrationPage.clearNationalityField();

		patientRegistrationPage.searchMobileNumberAndClickOnEnter("1234512345");
		assertTrue(patientRegistrationPage.verifyResultIsShowingUpInSearchPopupScreen(), "Results are not showing up in Search Popup Screen");
		patientRegistrationPage.clearMobileNumberField();
		patientRegistrationPage.searchNameAndClickOnEnter("Automation");
		assertTrue(patientRegistrationPage.verifyResultIsShowingUpInSearchPopupScreen(), "Results are not showing up in Search Popup Screen");
		patientRegistrationPage.clearNameField();
		patientRegistrationPage.searchFirstNameAndClickOnEnter("Automation");
		assertTrue(patientRegistrationPage.verifyResultIsShowingUpInSearchPopupScreen(), "Results are not showing up in Search Popup Screen");
		patientRegistrationPage.clearFirstNameField();
		patientRegistrationPage.searchLastNameAndClickOnEnter("User");
		assertTrue(patientRegistrationPage.verifyResultIsShowingUpInSearchPopupScreen(), "Results are not showing up in Search Popup Screen");
		patientRegistrationPage.clearLastNameField();
		patientRegistrationPage.searchAddressAndClickOnEnter("Automation Test Address");
		assertTrue(patientRegistrationPage.verifyResultIsShowingUpInSearchPopupScreen(), "Results are not showing up in Search Popup Screen");
		patientRegistrationPage.clearAddressField();
		patientRegistrationPage.searchLocalityAndClickOnEnter("Test local");
		assertTrue(patientRegistrationPage.verifyResultIsShowingUpInSearchPopupScreen(), "Results are not showing up in Search Popup Screen");
		patientRegistrationPage.clearLocalityField();
		patientRegistrationPage.searchNationalIdAndClickOnEnter("12345");
		assertTrue(patientRegistrationPage.verifyResultIsShowingUpInSearchPopupScreen(), "Results are not showing up in Search Popup Screen");
		patientRegistrationPage.clearNationalityField();
		driver.waitForPageLoad();
			
	}
}