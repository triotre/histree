package com.triotree.test.website.FrontOffice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.triotree.test.base.ResultListener;
import com.triotree.test.website.TTWebsiteBaseTest;
import com.triotree.website.pages.CommonPages.HISHomePage;
import com.triotree.website.pages.FrontOffice.ApproveRefundPage;
import com.triotree.website.pages.FrontOffice.BillingPage;
import com.triotree.website.pages.FrontOffice.BillsUtilityPage;
import com.triotree.website.pages.FrontOffice.DepositPage;
import com.triotree.website.pages.FrontOffice.DoctorSchedulePage;
import com.triotree.website.pages.FrontOffice.FrontOfficeHomePage;
import com.triotree.website.pages.FrontOffice.GenerateSchedulePage;
import com.triotree.website.pages.FrontOffice.MarkPatientDeceasedPage;
import com.triotree.website.pages.FrontOffice.MergeAndUnmergeDuplicatePage;
import com.triotree.website.pages.FrontOffice.PatientRegistrationPage;

@Listeners(ResultListener.class)
public class DepositBillingTest extends TTWebsiteBaseTest{

	private static final Logger logger = LogManager
			.getLogger(DepositBillingTest.class.getName());

	private HISHomePage hisHomePage;
	private FrontOfficeHomePage frontOfficeHomePage;
	private PatientRegistrationPage patientRegistrationPage;
	private BillingPage billingPage;
	private MarkPatientDeceasedPage markPatientDeceasedPage;
	private MergeAndUnmergeDuplicatePage mergeAndUnmergeDuplicatePage;
	private DepositPage depositPage;
	private GenerateSchedulePage generateSchedulePage;
	private DoctorSchedulePage doctorSchedulePage;
	private BillsUtilityPage billsUtilityPage;
	private ApproveRefundPage approveRefundPage;


	private String patientRegistrationId = "AHHS.8996";

	private String desc = null;
	private String title1 = null;
	private String desc1 = null;


	@Test(priority=1)
	public void frontOfficeWithAvailDepositAmountTest() throws Throwable {	

		test=extent.createTest("frontOfficeWithAvailDepositAmountTest", "This test case verify the Fornt Office With Avail Deposit Amount Test Case");
		test.assignCategory("Deposit Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnNo("1st FLR T1 Transplant ICU");
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("1st FLR T1 Transplant ICU");
		//frontOfficeHomePage.clickOnAddPatientAndSelectAnOption("Patient Registration");
//		patientRegistrationPage.selectTitleFromTitleDropDown("Mr.");
//		patientRegistrationPage.enterFirstName("Demo");
//		patientRegistrationPage.enterMiddleName("Test");
//		patientRegistrationPage.enterLastName("User");
//		patientRegistrationPage.checkVipCheckBoxAndEnterData("This VIP Data has been added by Test Automation Scripts");
//		patientRegistrationPage.checkRemarksCheckBoxAndEnterData("This Remarks Data has been added by Test Automation Scripts");
//		patientRegistrationPage.selectGenderFromGenderDropDown("Male");
//		patientRegistrationPage.enterDob("15-12-1991");
//		patientRegistrationPage.enterAge("16");
//		assertTrue(patientRegistrationPage.verifyLesserAgeAlertMessage("Please enter Date of Birth Age is less than 18 year"), "System is not throwing lesser age than 18 years message");
//		patientRegistrationPage.enterAge("23");
//		patientRegistrationPage.selectMartialStatusFromDropDown("Single");
//		patientRegistrationPage.enterMotherMaidenName("Demo Test Mother");
//		patientRegistrationPage.enterFathersName("DemoFather@123 ");
//		patientRegistrationPage.selectNationalityFromDropDown("Indian");
//		patientRegistrationPage.checkNRIChecbox();
//		assertTrue(patientRegistrationPage.verifyIDCardDropDownIsEnabled(), "After checking NRI Checkbox, ID Card Dropdown is not getting enabled");
//		patientRegistrationPage.selectIdCardTypeFromDropDown("PAN CARD");
//		patientRegistrationPage.enterNationalID("12345");
//		patientRegistrationPage.enterTelephoneNumber("1234567891011123");
//		patientRegistrationPage.enterMobileNumber("12345");
//		patientRegistrationPage.clickOnRegisterIcon();
//		assertTrue(patientRegistrationPage.verifyInvalidMobileNoAlertMessage("mobile number should not be less than 10 digit"), "Alert not showing up when invalid mobile No is added");
//		patientRegistrationPage.enterMobileNumber("1234567890");
//		patientRegistrationPage.enterHouseNumber("Demo Test Address");
//		patientRegistrationPage.selectCityFromCityDropdown(city);
//		patientRegistrationPage.addANewCity("Test City"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Ghaziabad");
//		patientRegistrationPage.addLocality("Test local"+com.triotree.utils.CommonUtils.getRandomNum(1, 10000), "Ghaziabad", "201001");
//		patientRegistrationPage.enterEmailId("%^%^%^%^");
//		patientRegistrationPage.clickOnRegisterIcon();
//		patientRegistrationPage.enterEmailId("test@demo.com");
//		patientRegistrationPage.enterRefferdBy("Self");
//		patientRegistrationPage.selectPrefferedLanguageFromDropdown("English");
//		patientRegistrationPage.selectOccupationFromDropdown(occupation);
//		patientRegistrationPage.selectQualificationFromDropdown(qualification);
//		patientRegistrationPage.selectReligionFromDropdown("Hindu");
//		patientRegistrationPage.selectReferedFromDropdown(referredFrom);
//		patientRegistrationPage.checkFinancialDetailsCheckBox();
//		patientRegistrationPage.selectCompanyTypeFromDropdown("Corporate");
//		patientRegistrationPage.selectCompanyFromDropdown(1);
//		patientRegistrationPage.showAllCheckBox();
//		patientRegistrationPage.selectRateContractFromDropdown(1);
//		patientRegistrationPage.checkSchemeCheckBox();
//		patientRegistrationPage.selectSchemeFromDropdown(1);
//		patientRegistrationPage.clickOnRegisterIcon();
//		//assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
//		patientRegistrationPage.yesButtonOnConfirmPopup();
//		//assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
//		String patientRegistrationId =	patientRegistrationPage.getUHIDOfPatient();
//		System.out.println("Second Patient Registration Id is " +patientRegistrationId);
//		System.out.println("Patient Registration Id is " +patientRegistrationId);
//
//
//		patientRegistrationPage.clickOnNoButtonOnRegisteredSuccessfullyPopup();
		//
		//		driver.getURL();
		//		hisHomePage.loginToTriotreeHIS();
		//		hisHomePage.clickOnFronOfficeIcon();
		//		hisHomePage.selectStationAndClickOnYes("Front Office");
										//correct
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Deposits");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader("RAJH.17152907");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isAmountCanNotBeZeroMessageDisplayed(), "Amount Can Not be Zero Message is not showing up");
		depositPage.enterEmountInAmountTextBox("2000001");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		//assertTrue(depositPage.isTotalAmountInCashMessageDisplayed(), "Total Amount in Cash isEqual to or Exceeds message is not showing up");

		depositPage.enterEmountInAmountTextBox("1000");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");

		depositPage.clickOnCreditCardRadioButton();
		depositPage.enterEmountInAmountTextBox("2000");
		depositPage.enterCreditCardDetails(123456789, "MASTERCARD", "Andhra Bank", "2222222222");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");
		depositPage.clickOnChequeRadioButton();
		depositPage.enterEmountInAmountTextBox("2000");
		depositPage.enterChequeDetails("123456789", "Andhra Bank", "Noida");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");
		depositPage.clickOnPrintButtonOnHeader();
		assertTrue(depositPage.isPleaseSelectDepositReceiptMessageDisplayed(), "Please Select Deposit Receipt Message is not showing up");
		depositPage.clickOnFirstDepositDetails();
//////////////////////////////////////////////

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
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
		billingPage.selectTestsByName("24 hour Urine Cortisol");
		//assertTrue(billingPage.verifyPriceNotDefinedMessage("Price not defined for this service"), "Price Not Defined Message is not showing up");
		billingPage.selectTestsByName("24 hour Urine Aldosterone");
		billingPage.selectTestsByName("24 hour Urine Free Cortisol");
		billingPage.selectTestsByName("Phosphorus - Inorganic 24hr Urine");
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
		billingPage.enterRefferedBy("Self");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnAddToBillButton();
		try {
			billingPage.clickonschemedetails();
			billingPage.clickOnAddToBillButton();
		}
		catch (Exception e) {}
		assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		
		billingPage.clickOnYesButtonOnAvailDepositPopup();
		billingPage.enterAjustFromDeposit("5000");
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		billingPage.enterPatientPaidAmount("5000");
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
		billingPage.clickOnYesButtonOnOpdPopup();
	}

	@Test(enabled = false) //fixed
	public void frontOfficeCreditPatientBillingWithAvaialDiscountAndWithoutCoPayTest() throws Throwable {	

		test=extent.createTest("frontOfficeCreditPatientBillingWithAvaialDiscountAndWithoutCoPayTest", "This test case verify the Fornt Office Credit Patient Billing With Avaial Discount And Without CoPay Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);

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
		//assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
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
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Deposits");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isAmountCanNotBeZeroMessageDisplayed(), "Amount Can Not be Zero Message is not showing up");
		depositPage.enterEmountInAmountTextBox("2000001");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isTotalAmountInCashMessageDisplayed(), "Total Amount in Cash isEqual to or Exceeds message is not showing up");

		depositPage.enterEmountInAmountTextBox("1000");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");

		depositPage.clickOnCreditCardRadioButton();
		depositPage.enterEmountInAmountTextBox("2000");
		depositPage.enterCreditCardDetails(123456789, "MASTERCARD", "Andhra Bank", "2222222222");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");
		depositPage.clickOnChequeRadioButton();
		depositPage.enterEmountInAmountTextBox("30000");
		depositPage.enterChequeDetails("123456789", "Andhra Bank", "Noida");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");
		depositPage.clickOnPrintButtonOnHeader();
		assertTrue(depositPage.isPleaseSelectDepositReceiptMessageDisplayed(), "Please Select Deposit Receipt Message is not showing up");
		depositPage.clickOnFirstDepositDetails();


		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		
//		billingPage.clickOnCloseButtonOnDocumentChecklistPopup();
//
//		billingPage.closeCompanyDetailsPopup();
//
//		billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
//		try {
//			billingPage.closeSchemeDetailsPopup();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
		billingPage.enterDescriptionInManualSection("Testing");
		billingPage.selectQuantityInManualSection("5");
		billingPage.enterPriceInManualSection("10.30");
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
			billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
			billingPage.closeSchemeDetailsPopup();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		//billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		//billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "100", "50");
		//billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		//billingPage.clickOnYesButtonOnAvailDepositPopup();
		//billingPage.enterAjustFromDeposit("5000");
	}

	@Test(enabled = false) //fixed 06-april-2020
	public void frontOfficeDepositBySearchPatientTest() throws Throwable {	

		test=extent.createTest("frontOfficeDepositBySearchPatientTest", "This test case verify the Fornt Office Deposit By Search Patient Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);

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
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Deposits");	
		billingPage.clickOnSearchNewButtonOnHeader();
		billingPage.searchPatientWithMobileNumber("1234567890");
		billingPage.clickOnPatientIdFromSearch(patientRegistrationId.trim());

		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isAmountCanNotBeZeroMessageDisplayed(), "Amount Can Not be Zero Message is not showing up");
		depositPage.enterEmountInAmountTextBox("2000001");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isTotalAmountInCashMessageDisplayed(), "Total Amount in Cash isEqual to or Exceeds message is not showing up");

		depositPage.enterEmountInAmountTextBox("1000");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");

		depositPage.clickOnCreditCardRadioButton();
		depositPage.enterEmountInAmountTextBox("2000");
		depositPage.enterCreditCardDetails(123456789, "MASTERCARD", "Andhra Bank", "2222222222");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");
		depositPage.clickOnChequeRadioButton();
		depositPage.enterEmountInAmountTextBox("2000");
		depositPage.enterChequeDetails("123456789", "Andhra Bank", "Noida");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");
		depositPage.clickOnPrintButtonOnHeader();
		assertTrue(depositPage.isPleaseSelectDepositReceiptMessageDisplayed(), "Please Select Deposit Receipt Message is not showing up");
		depositPage.clickOnFirstDepositDetails();

	}
	
	@Test(enabled = false)//fixed 06-04-2020
	public void frontOfficeDepositAndRefundTest() throws Throwable {	

		test=extent.createTest("frontOfficeDepositAndRefundTest", "This test case verify the Fornt Office Deposit And Refund Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);

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
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Deposits");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isAmountCanNotBeZeroMessageDisplayed(), "Amount Can Not be Zero Message is not showing up");
		depositPage.enterEmountInAmountTextBox("2000001");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isTotalAmountInCashMessageDisplayed(), "Total Amount in Cash isEqual to or Exceeds message is not showing up");

		depositPage.enterEmountInAmountTextBox("1000");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");

		depositPage.clickOnCreditCardRadioButton();
		depositPage.enterEmountInAmountTextBox("2000");
		depositPage.enterCreditCardDetails(123456789, "MASTERCARD", "Andhra Bank", "2222222222");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");
		depositPage.clickOnChequeRadioButton();
		depositPage.enterEmountInAmountTextBox("2000");
		depositPage.enterChequeDetails("123456789", "Andhra Bank", "Noida");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");
		depositPage.clickOnPrintButtonOnHeader();
		assertTrue(depositPage.isPleaseSelectDepositReceiptMessageDisplayed(), "Please Select Deposit Receipt Message is not showing up");
		depositPage.clickOnFirstDepositDetails();


		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
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
		billingPage.enterDescriptionInManualSection("Testing");
		billingPage.selectQuantityInManualSection("5");
		billingPage.enterPriceInManualSection("10.30");
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
		billingPage.clickOnYesButtonOnAvailDepositPopup();
		billingPage.enterAjustFromDeposit("5000");
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		billingPage.enterPatientPaidAmount("5000");
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
	
	@Test(enabled = false)//fixed 03-April-2020
	public void frontOfficeDepositBySearchPatientTestSchedule1() throws Throwable {	

		test=extent.createTest("frontOfficeDepositBySearchPatientTestSchedule1", "This test case verify the Fornt Office Deposit BySearch Patient Test Schedule1 Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		generateSchedulePage = new GenerateSchedulePage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Generate Schedule");
		generateSchedulePage.clickOnSearchButton();
		assertTrue(generateSchedulePage.verifyPleaseSelectSpecilizationMessage(), "Please Select Specialization Message not showing up");
		generateSchedulePage.clickOnPlusButton();
		assertTrue(generateSchedulePage.verifyPleaseSelectSpecialityMessage(), "Please Select Speciality Message not showing up");
		generateSchedulePage.selectSpecilizationFromDropdown("Ophthalmology");
		generateSchedulePage.selectDoctorFromDropdown("Archana G Mahajan");
		generateSchedulePage.clickOnSearchButton();
		assertTrue(generateSchedulePage.verifyNoScheduleExistMessage(), "No Schedule Exists Message not showing up");
		generateSchedulePage.selectSpecilizationFromDropdown("Cardiology");
		generateSchedulePage.selectDoctorFromDropdown("Sameer Mehrotra");
		generateSchedulePage.clickOnPlusButton();
		generateSchedulePage.selectFacilityFromDropdown("TRIOTREE HOSPITAL");
		generateSchedulePage.enterFromDate("13/Sep/2019");
		driver.clickAnyWhereOnScreen();
		assertTrue(generateSchedulePage.verifyFromDateErrorMessage(), "Older Date is being Selected in From Date Column");
		generateSchedulePage.enterToDate("13/Sep/2019");
		driver.clickAnyWhereOnScreen();
		//assertTrue(generateSchedulePage.verifyToDateErrorMessage(), "Older Date is being Selected in To Date Column");

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

	}
	
	@Test(enabled = false) //fixed 03-April-2020
	public void frontOfficeScheduling1Test() throws Throwable {	

		test=extent.createTest("frontOfficeScheduling1Test", "This test verify that front Office Scheduling 1Test");
		test.assignCategory("Front Office Billing");
		String tomorrowDay = null;
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		generateSchedulePage = new GenerateSchedulePage(driver);
		doctorSchedulePage = new DoctorSchedulePage(driver);

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
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Doctor Schedule");
		doctorSchedulePage.clickOnLegendKey();
		assertTrue(doctorSchedulePage.isLegendForAppointmentFormOpened(), "Legend For Appointment form is not showing Up");
		doctorSchedulePage.closeLegendForAppointmentForm();
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Generate Schedule");


		generateSchedulePage.clickOnSearchButton();
		assertTrue(generateSchedulePage.verifyPleaseSelectSpecilizationMessage(), "Please Select Specialization Message not showing up");
		generateSchedulePage.clickOnPlusButton();
		assertTrue(generateSchedulePage.verifyPleaseSelectSpecialityMessage(), "Please Select Speciality Message not showing up");
		generateSchedulePage.selectSpecilizationFromDropdown("Ophthalmology");
		generateSchedulePage.selectDoctorFromDropdown("Archana G Mahajan");
		generateSchedulePage.clickOnSearchButton();
		assertTrue(generateSchedulePage.verifyNoScheduleExistMessage(), "No Schedule Exists Message not showing up");
		generateSchedulePage.selectSpecilizationFromDropdown("Dermatology");
		generateSchedulePage.selectDoctorFromDropdown("Navya Handa");
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

		if (currentDay.equalsIgnoreCase("Sunday")) {
			tomorrowDay = "Monday";
		}
		if (currentDay.equalsIgnoreCase("Monday")) {
			tomorrowDay = "Tuesday";
		}
		if (currentDay.equalsIgnoreCase("Tuesday")) {
			tomorrowDay = "Wednesday";
		}
		if (currentDay.equalsIgnoreCase("Wednesday")) {
			tomorrowDay = "Thursday";
		}
		if (currentDay.equalsIgnoreCase("Friday")) {
			tomorrowDay = "Saturday";
		}
		if (currentDay.equalsIgnoreCase("Saturday")) {
			tomorrowDay = "Sunday";
		}

		generateSchedulePage.selectDayCheckbox(tomorrowDay);	
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
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Doctor Schedule");

		doctorSchedulePage.selectFacilityFromDropdown("TRIOTREE HOSPITAL");
		doctorSchedulePage.clickOnSearchButton();
		assertTrue(doctorSchedulePage.verifyPleaseSelectSpecialityMessage(), "Please select Speciality Message not showing up");
		doctorSchedulePage.selectSpecilityFromDropdown("Anesthesiast");
		doctorSchedulePage.clickOnSearchButton();
		assertTrue(doctorSchedulePage.isSecialityDoctorTableShowingUp(), "Speciality Doctor Table is not showing up");
		doctorSchedulePage.clickOnClearButton();
		doctorSchedulePage.selectSpecilityFromDropdown("Dermatology");
		doctorSchedulePage.clickOnSearchButtonNearDate();
		doctorSchedulePage.selectDoctorFromDropdown("Navya Handa");
		doctorSchedulePage.clickOnSearchButtonNearDate();
		assertTrue(doctorSchedulePage.isSecialityDoctorTableShowingUp(), "Speciality Doctor Table is not showing up");
		doctorSchedulePage.clickOnGreenGeneratedScheduleForPreviousTime();
		assertTrue(doctorSchedulePage.isTimeOfAppointmentWithGreaterMessageShowing(), "Time of Appointment with Greater that current time message is not showing up");
		doctorSchedulePage.clickOnGreenGeneratedScheduleForFutureTime();
		assertTrue(doctorSchedulePage.isAppointmentSchedulingPopupDisplayed(),"Appointment Scheduling Popup is not showing up");
		doctorSchedulePage.clickOnSaveButtonOnAppointmentSchedulingPopup();
		assertTrue(doctorSchedulePage.isEnterValidUhidMessageShowingUp(), "Enter Valid UHID Message is not showing up");
		doctorSchedulePage.enterUHIDInAppointmentschedulingTextBox(patientRegistrationId);
		doctorSchedulePage.selectVisitTypeFromDropdown("Initial Visit                 ");
		doctorSchedulePage.clickOnSaveButtonOnAppointmentSchedulingPopup();
		assertTrue(doctorSchedulePage.isAppointmentBookedSuccessfullyMessageShowingUp(), "Appointment booked Successfully Message is not showing up");
		doctorSchedulePage.rightClickOnYellowBookedAppointmentAndClickOnGotToBill();
		billingPage.clickOnCloseButtonOnDocumentChecklistPopup();
		billingPage.clickClearButtonCompDetails();
		billingPage.closeCompanyDetailsPopup();

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
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
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
		billingPage.enterDescriptionInManualSection("Testing");
		billingPage.selectQuantityInManualSection("5");
		billingPage.enterPriceInManualSection("10.30");
		billingPage.clickOnVerifyButton();
		billingPage.clickOnOtherServicesIcon();
		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
		assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Dialysis Procedures" , "AV Fistula Day Care Package With Anesthesia");
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);


		billingPage.clickOnAddToBillButton();
		//assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");

		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		assertTrue(billingPage.isPercentageProcessDiscountMessageDisplayed(), "Percentage Process Discount Message is NOT Displayed");

		billingPage.selectDiscountOnFromDropdown("On Bill");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		assertTrue(billingPage.isEnterDiscountErrorMessageDisplayed(), "Enter Discount Error Message is NOT Displayed");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("10% Automation Testing");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		billingPage.selectAuthorisedByFromDropdown("Management Decision");

		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		billingPage.clickOnBillingButtonOnHeader();/////////////
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		billingPage.enterPatientPaidAmount("5000");
		billingPage.clickOnNewPaymentModeButton();
		billingPage.selectSecondPaymentModeAsCheque();
		billingPage.enterChequeDetailsAndSaveDetails("123456789", "State Bank of India", "Noida");
		assertTrue(billingPage.verifyBillGotGenerated("generated successfully"), "Bill did not got generated");
		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		//assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
		//billingPage.clickOnYesButtonOnOpdPopup();
	}

	@Test(enabled = false)//fixed 03-April-2020
	public void frontOfficeGenerateSchedule1Test() throws Throwable {	

		test=extent.createTest("frontOfficeGenerateSchedule1Test", "This test case verify the Fornt Office GenerateSchedule1 Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		generateSchedulePage = new GenerateSchedulePage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Generate Schedule");
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

	}

	@Test(enabled = false)//fixed 03-April-2020
	public void frontOfficeGenerateSchedule2Test() throws Throwable {	

		test=extent.createTest("frontOfficeGenerateSchedule2Test", "This test case verify the Fornt Office GenerateSchedule2 Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		generateSchedulePage = new GenerateSchedulePage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Generate Schedule");
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
	}
	
	@Test(enabled = false)
	public void frontOfficeGenerateSchedule3Test() throws Throwable {
		test=extent.createTest("frontOfficeGenerateSchedule3Test", "This test case verify the Fornt Office GenerateSchedule2 Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		generateSchedulePage = new GenerateSchedulePage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Generate Schedule");
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

	}
	
	@Test(enabled = false)
	public void frontOfficeDoctorSchedulingCancelAppointmentTest() throws Throwable {	

		test=extent.createTest("frontOfficeDoctorSchedulingCancelAppointmentTest", "This test case verify the Fornt Office Doctor Scheduling Cancel Appointment Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		generateSchedulePage = new GenerateSchedulePage(driver);
		doctorSchedulePage = new DoctorSchedulePage(driver);


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
		//assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
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

		//		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Generate Schedule");
		//		
		////		doctorSchedulePage.clickOnLegendKey();
		//		
		//		
		//		generateSchedulePage.clickOnSearchButton();
		//		assertTrue(generateSchedulePage.verifyPleaseSelectSpecilizationMessage(), "Please Select Specialization Message not showing up");
		//		generateSchedulePage.clickOnPlusButton();
		//		assertTrue(generateSchedulePage.verifyPleaseSelectSpecialityMessage(), "Please Select Speciality Message not showing up");
		//		generateSchedulePage.selectSpecilizationFromDropdown("Ophthalmology");
		//		generateSchedulePage.selectDoctorFromDropdown("Archana G Mahajan");
		//		generateSchedulePage.clickOnSearchButton();
		//		assertTrue(generateSchedulePage.verifyNoScheduleExistMessage(), "No Schedule Exists Message not showing up");
		//		generateSchedulePage.selectSpecilizationFromDropdown("Paediatrician");
		//		generateSchedulePage.selectDoctorFromDropdown("Ashish Gupta");
		//		generateSchedulePage.clickOnPlusButton();
		//		generateSchedulePage.selectFacilityFromDropdown("TRIOTREE HOSPITAL");
		//		generateSchedulePage.enterFromDate("13/Feb/2019");
		//		driver.clickAnyWhereOnScreen();
		//		assertTrue(generateSchedulePage.verifyFromDateErrorMessage(), "Older Date is being Selected in From Date Column");
		//		generateSchedulePage.enterToDate("13/Feb/2019");
		//		driver.clickAnyWhereOnScreen();
		//		assertTrue(generateSchedulePage.verifyToDateErrorMessage(), "Older Date is being Selected in To Date Column");
		//
		//		Date date = new Date();
		//		int currenthour= date.getHours();
		//		int fromHour = currenthour+1;
		//		int toHour = currenthour+1;
		//		String fromHourString = String.valueOf(fromHour);
		//		String toHourString = String.valueOf(toHour);
		//		String futureFromTime = fromHourString+":"+"30";
		//		String futureToTime = toHourString+":"+"40";
		//
		//		int fromHourSitting2 = currenthour+2;
		//		int toHourSitting2 = currenthour+2;
		//		String fromHourStringSitting2 = String.valueOf(fromHourSitting2);
		//		String toHourStringSitting2 = String.valueOf(toHourSitting2);
		//		String futureFromTimeSitting2 = fromHourStringSitting2+":"+"30";
		//		String futureToTimeSitting2 = toHourStringSitting2+":"+"45";
		//		generateSchedulePage.selectFromTimeForSitting1(futureFromTime);
		//		generateSchedulePage.selectToTimeForSitting1(futureToTime);
		//		Calendar calendar = Calendar.getInstance();
		//		Date date1 = calendar.getTime();
		//		System.out.println(new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date1.getTime()));
		//		String currentDay = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date1.getTime());
		//		generateSchedulePage.selectDayCheckbox(currentDay);		
		//		generateSchedulePage.selectDayCheckbox("Sunday");	
		//		generateSchedulePage.selectRightCheckForSitting1();
		//		generateSchedulePage.enterRemarksForCurrentDayForSitting1("Remarks added by Automation Scripts", currentDay);		
		//		generateSchedulePage.selectFromTimeForSitting2(futureFromTimeSitting2);
		//		generateSchedulePage.selectToTimeForSitting2(futureToTimeSitting2);
		//		generateSchedulePage.selectRightCheckForSitting2();
		//		generateSchedulePage.enterRemarksForCurrentDayForSitting2("Remarks added by Automation Scripts", currentDay);
		//		generateSchedulePage.clickOnSaveButtonOnHeader();
		//		assertTrue(generateSchedulePage.verifyDoYouWantToSavePopupMessage("Do you want to save?"), "Do you want to save popup didnt opened");
		//		generateSchedulePage.clickOnSaveButtonOnSavePopup();
		//		assertTrue(generateSchedulePage.isSaveSuccessfullyMessageShowsUp(), "Schedule didnt got saved");


		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Doctor Schedule");

		doctorSchedulePage.selectFacilityFromDropdown("TRIOTREE HOSPITAL");
		doctorSchedulePage.clickOnSearchButton();
		assertTrue(doctorSchedulePage.verifyPleaseSelectSpecialityMessage(), "Please select Speciality Message not showing up");
		doctorSchedulePage.selectSpecilityFromDropdown("Anesthesiast");
		doctorSchedulePage.clickOnSearchButton();
		assertTrue(doctorSchedulePage.isSecialityDoctorTableShowingUp(), "Speciality Doctor Table is not showing up");
		doctorSchedulePage.clickOnClearButton();
		doctorSchedulePage.selectSpecilityFromDropdown("Neurology");
		doctorSchedulePage.clickOnSearchButtonNearDate();
		doctorSchedulePage.selectDoctorFromDropdown("Vijay Chandra");
		doctorSchedulePage.clickOnSearchButtonNearDate();
		assertTrue(doctorSchedulePage.isSecialityDoctorTableShowingUp(), "Speciality Doctor Table is not showing up");
		doctorSchedulePage.clickOnGreenGeneratedScheduleForPreviousTime();
		//		assertTrue(doctorSchedulePage.isTimeOfAppointmentWithGreaterMessageShowing(), "Time of Appointment with Greater that current time message is not showing up");
		//		doctorSchedulePage.clickOnGreenGeneratedScheduleForFutureTime();
		//		assertTrue(doctorSchedulePage.isAppointmentSchedulingPopupDisplayed(), "Appointment Scheduling Popup is not showing up");
		//		doctorSchedulePage.clickOnSaveButtonOnAppointmentSchedulingPopup();
		//		assertTrue(doctorSchedulePage.isEnterValidUhidMessageShowingUp(), "Enter Valid UHID Message is not showing up");


		//		doctorSchedulePage.enterUHIDInAppointmentschedulingTextBox(patientRegistrationId);
		//		doctorSchedulePage.selectVisitTypeFromDropdown("Initial Visit                 ");
		//		doctorSchedulePage.cancelTheAppointment();
		//		assertTrue(doctorSchedulePage.isAppointmentCancelled(), "Appointment has not cancelled");

	}

	@Test(enabled = false)
	public void frontOfficeDoctorSchedulingWithAddPatientTest() throws Throwable {	

		test=extent.createTest("frontOfficeDoctorSchedulingWithAddPatientTest", "This test case verify the Fornt Office Doctor Scheduling With Add Patient Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		generateSchedulePage = new GenerateSchedulePage(driver);
		doctorSchedulePage = new DoctorSchedulePage(driver);


		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Doctor Schedule");
		doctorSchedulePage.clickOnLegendKey();
		assertTrue(doctorSchedulePage.isLegendForAppointmentFormOpened(), "Legend For Appointment form is not showing Up");
		doctorSchedulePage.closeLegendForAppointmentForm();
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Generate Schedule");
		generateSchedulePage.clickOnSearchButton();
		assertTrue(generateSchedulePage.verifyPleaseSelectSpecilizationMessage(), "Please Select Specialization Message not showing up");
		generateSchedulePage.clickOnPlusButton();
		assertTrue(generateSchedulePage.verifyPleaseSelectSpecialityMessage(), "Please Select Speciality Message not showing up");
		generateSchedulePage.selectSpecilizationFromDropdown("Ophthalmology");
		generateSchedulePage.selectDoctorFromDropdown("Archana G Mahajan");
		generateSchedulePage.clickOnSearchButton();
		assertTrue(generateSchedulePage.verifyNoScheduleExistMessage(), "No Schedule Exists Message not showing up");
		generateSchedulePage.selectSpecilizationFromDropdown("Neurology");
		generateSchedulePage.selectDoctorFromDropdown("Vijay Chandra");
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


		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Doctor Schedule");



		doctorSchedulePage.selectFacilityFromDropdown("TRIOTREE HOSPITAL");
		doctorSchedulePage.clickOnSearchButton();
		assertTrue(doctorSchedulePage.verifyPleaseSelectSpecialityMessage(), "Please select Speciality Message not showing up");
		doctorSchedulePage.selectSpecilityFromDropdown("Anesthesiast");
		doctorSchedulePage.clickOnSearchButton();
		assertTrue(doctorSchedulePage.isSecialityDoctorTableShowingUp(), "Speciality Doctor Table is not showing up");
		doctorSchedulePage.clickOnClearButton();
		doctorSchedulePage.selectSpecilityFromDropdown("Neurology");
		doctorSchedulePage.clickOnSearchButtonNearDate();
		doctorSchedulePage.selectDoctorFromDropdown("Vijay Chandra");
		doctorSchedulePage.clickOnSearchButtonNearDate();
		assertTrue(doctorSchedulePage.isSecialityDoctorTableShowingUp(), "Speciality Doctor Table is not showing up");
		doctorSchedulePage.clickOnGreenGeneratedScheduleForPreviousTime();
		assertTrue(doctorSchedulePage.isTimeOfAppointmentWithGreaterMessageShowing(), "Time of Appointment with Greater that current time message is not showing up");
		doctorSchedulePage.clickOnGreenGeneratedScheduleForFutureTime();
		assertTrue(doctorSchedulePage.isAppointmentSchedulingPopupDisplayed(), "Appointment Scheduling Popup is not showing up");
		doctorSchedulePage.clickOnSaveButtonOnAppointmentSchedulingPopup();
		assertTrue(doctorSchedulePage.isEnterValidUhidMessageShowingUp(), "Enter Valid UHID Message is not showing up");
		doctorSchedulePage.enterUHIDInAppointmentschedulingTextBox(patientRegistrationId);
		doctorSchedulePage.selectVisitTypeFromDropdown("Initial Visit                 ");
		doctorSchedulePage.clickOnSaveButtonOnAppointmentSchedulingPopup();
		//assertTrue(doctorSchedulePage.isAppointmentBookedSuccessfullyMessageShowingUp(), "Appointment booked Successfully Message is not showing up");
		//doctorSchedulePage.clickOnBookedYellowAppointment();
		driver.pauseExecutionFor(5000);
	}
	
	@Test(enabled = false)
	public void frontOfficeDoctorSchedulingWithLinkUHIDTest() throws Throwable {	

		test=extent.createTest("frontOfficeDoctorSchedulingWithLinkUHIDTest", "This test case verify the Fornt Office Doctor Scheduling With LinkUHID Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		generateSchedulePage = new GenerateSchedulePage(driver);
		doctorSchedulePage = new DoctorSchedulePage(driver);


		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Doctor Schedule");
		doctorSchedulePage.clickOnLegendKey();
		assertTrue(doctorSchedulePage.isLegendForAppointmentFormOpened(), "Legend For Appointment form is not showing Up");
		doctorSchedulePage.closeLegendForAppointmentForm();
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Generate Schedule");
		generateSchedulePage.clickOnSearchButton();
		assertTrue(generateSchedulePage.verifyPleaseSelectSpecilizationMessage(), "Please Select Specialization Message not showing up");
		generateSchedulePage.clickOnPlusButton();
		assertTrue(generateSchedulePage.verifyPleaseSelectSpecialityMessage(), "Please Select Speciality Message not showing up");
		generateSchedulePage.selectSpecilizationFromDropdown("Ophthalmology");
		generateSchedulePage.selectDoctorFromDropdown("Archana G Mahajan");
		generateSchedulePage.clickOnSearchButton();
		assertTrue(generateSchedulePage.verifyNoScheduleExistMessage(), "No Schedule Exists Message not showing up");
		generateSchedulePage.selectSpecilizationFromDropdown("Neurology");
		generateSchedulePage.selectDoctorFromDropdown("Vijay Chandra");
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


		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Doctor Schedule");



		doctorSchedulePage.selectFacilityFromDropdown("TRIOTREE HOSPITAL");
		doctorSchedulePage.clickOnSearchButton();
		assertTrue(doctorSchedulePage.verifyPleaseSelectSpecialityMessage(), "Please select Speciality Message not showing up");
		doctorSchedulePage.selectSpecilityFromDropdown("Anesthesiast");
		doctorSchedulePage.clickOnSearchButton();
		assertTrue(doctorSchedulePage.isSecialityDoctorTableShowingUp(), "Speciality Doctor Table is not showing up");
		doctorSchedulePage.clickOnClearButton();
		doctorSchedulePage.selectSpecilityFromDropdown("Neurology");
		doctorSchedulePage.clickOnSearchButtonNearDate();
		doctorSchedulePage.selectDoctorFromDropdown("Vijay Chandra");
		doctorSchedulePage.clickOnSearchButtonNearDate();
		assertTrue(doctorSchedulePage.isSecialityDoctorTableShowingUp(), "Speciality Doctor Table is not showing up");
		doctorSchedulePage.clickOnGreenGeneratedScheduleForPreviousTime();
		assertTrue(doctorSchedulePage.isTimeOfAppointmentWithGreaterMessageShowing(), "Time of Appointment with Greater that current time message is not showing up");
		doctorSchedulePage.clickOnGreenGeneratedScheduleForFutureTime();
		assertTrue(doctorSchedulePage.isAppointmentSchedulingPopupDisplayed(), "Appointment Scheduling Popup is not showing up");
		doctorSchedulePage.clickOnSaveButtonOnAppointmentSchedulingPopup();
		assertTrue(doctorSchedulePage.isEnterValidUhidMessageShowingUp(), "Enter Valid UHID Message is not showing up");
		doctorSchedulePage.enterUHIDInAppointmentschedulingTextBox(patientRegistrationId);
		doctorSchedulePage.selectVisitTypeFromDropdown("Initial Visit                 ");
		doctorSchedulePage.clickOnSaveButtonOnAppointmentSchedulingPopup();
		//assertTrue(doctorSchedulePage.isAppointmentBookedSuccessfullyMessageShowingUp(), "Appointment booked Successfully Message is not showing up");


		//doctorSchedulePage.clickOnBookedYellowAppointment();

		driver.pauseExecutionFor(5000);
	}

	@Test(enabled = false)// fixed 01-04-2020
	public void frontOfficeBillingWithBillingModeCreditPatientTest() throws Throwable {	

		test=extent.createTest("frontOfficeBillingWithBillingModeCreditPatientTest", "This test case verify the Fornt Office Billing With Billing Mode Credit Patient Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);

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
		patientRegistrationPage.selectCompanyTypeFromDropdown("Embassy");
		patientRegistrationPage.selectCompanyFromDropdownByName("AMERICAN EMBASSY");
		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");

		//patientRegistrationPage.checkSchemeCheckBox();
		//patientRegistrationPage.selectSchemeFromDropdown(4);
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
		//		assertTrue(billingPage.isCashBillingNotAllowedMessageDisplayed(), "Cash Billing Not Allowed Message is not showing Up");

		//billingPage.selectRateContractInCompDetailsPopup("AMERICAN EMBASSY");
		//assertTrue(billingPage.isCashBillingNotAllowedMessageDisplayed(), "Cash Billing Not Allowed Message is not showing Up");
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
		try {
			billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		billingPage.closeCompanyDetailsPopup();
		//billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
		///billingPage.selectSchemeAuthorisedSchemeDetailsPopupadd();
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

		billingPage.clickOnInsuranceCompanyButton();
		try {
			billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		}
		catch (Exception e) {
			e.printStackTrace();
			//billingPage.closepopup();
		}
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		try {
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "0", "50");
			billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			//assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
			billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//		billingPage.clickOnBillingButtonOnHeader();
		//		billingPage.clickOnyesBtnOnGenrateBillPopup();
		//		billingPage.enterPatientPaidAmount("5000");
		//		billingPage.clickOnNewPaymentModeButton();
		//		billingPage.selectSecondPaymentMode("Debit Card");
		//		billingPage.enterCardDetailsAndSaveDetails("MASTERCARD", "123456789", "Andhra Bank", "2222222222");
		//		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		//		assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
		//		billingPage.clickOnYesButtonOnOpdPopup();

	}

	@Test(enabled = false) //fixed 07-04-2020
	public void frontOfficeBillingWithBillingModeCashPatientTest() throws Throwable {	

		test=extent.createTest("frontOfficeBillingWithBillingModeCashPatientTest", "This test case verify the Fornt Office Billing With Billing Mode Cash Patient Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);

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
		patientRegistrationPage.selectSchemeFromDropdown(4);
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
		//		assertTrue(billingPage.isCashBillingNotAllowedMessageDisplayed(), "Cash Billing Not Allowed Message is not showing Up");
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		//billingPage.selectDocumentFromDocumentChecklistPopup("Case Record");
		//billingPage.selectDocumentFromDocumentChecklistPopup(idCard);
		//billingPage.selectDocumentFromDocumentChecklistPopup("Form 60");
		//billingPage.selectDocumentFromDocumentChecklistPopup("OP Prescription");
		//billingPage.saveDocumentChecklistPopup();
		billingPage.closeCompanyDetailsPopup();
		billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");


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
		billingPage.selectQuantityInManualSection("100");
		billingPage.enterPriceInManualSection("150");
		billingPage.clickOnVerifyButton();
		billingPage.clickOnOtherServicesIcon();
		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
		assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Dialysis Procedures" , "AV Fistula Day Care Package With Anesthesia");
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);


		billingPage.clickOnInsuranceCompanyButton();
		//		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		//		try {
		//			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "0", "50");
		//		}
		//		catch (Exception e) {}
		//		try {
		//			billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		try {
			billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		}
		catch (Exception e) {
		}
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();


		try {
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "0", "50");
			billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		billingPage.clickOnAddToBillButton();
		try {
			//assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
			billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//billingPage.checkDiscountCheckbox();

		//billingPage.clickOnYesBtnUnderProvideDiscountPopup();

		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		billingPage.enterPatientPaidAmount("5000");
		billingPage.clickOnNewPaymentModeButton();
		billingPage.selectSecondPaymentMode("Debit Card");
		billingPage.enterCardDetailsAndSaveDetails("MASTERCARD", "123456789", "Andhra Bank", "2222222222");
		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		//assertTrue(billingPage.verifyPrintOPDMessageIsDisplaying("Do you want to print OPD card"), "Print OP Card Message is not showing up");
		//billingPage.clickOnYesButtonOnOpdPopup();

	}

	@Test(enabled = false)//fixed 07-04-2020
	public void frontOfficeDoctorScheduleWithGenerateScheduleAndRegisterPatientTest() throws Throwable {	

		test=extent.createTest("frontOfficeDoctorScheduleWithGenerateScheduleAndRegisterPatientTest", "This test case verify the Fornt Office Billing With Billing Mode Cash Patient Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		generateSchedulePage = new GenerateSchedulePage(driver);
		doctorSchedulePage = new DoctorSchedulePage(driver);


		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Doctor Schedule");
		doctorSchedulePage.clickOnLegendKey();
		assertTrue(doctorSchedulePage.isLegendForAppointmentFormOpened(), "Legend For Appointment form is not showing Up");
		doctorSchedulePage.closeLegendForAppointmentForm();
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Generate Schedule");
		generateSchedulePage.clickOnSearchButton();
		assertTrue(generateSchedulePage.verifyPleaseSelectSpecilizationMessage(), "Please Select Specialization Message not showing up");
		generateSchedulePage.clickOnPlusButton();
		assertTrue(generateSchedulePage.verifyPleaseSelectSpecialityMessage(), "Please Select Speciality Message not showing up");
		generateSchedulePage.selectSpecilizationFromDropdown("Ophthalmology");
		generateSchedulePage.selectDoctorFromDropdown("Archana G Mahajan");
		generateSchedulePage.clickOnSearchButton();
		assertTrue(generateSchedulePage.verifyNoScheduleExistMessage(), "No Schedule Exists Message not showing up");
		generateSchedulePage.selectSpecilizationFromDropdown("Neurology");
		generateSchedulePage.selectDoctorFromDropdown("Vijay Chandra");
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


		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Doctor Schedule");



		doctorSchedulePage.selectFacilityFromDropdown("TRIOTREE HOSPITAL");
		doctorSchedulePage.clickOnSearchButton();
		assertTrue(doctorSchedulePage.verifyPleaseSelectSpecialityMessage(), "Please select Speciality Message not showing up");
		doctorSchedulePage.selectSpecilityFromDropdown("Anesthesiast");
		doctorSchedulePage.clickOnSearchButton();
		assertTrue(doctorSchedulePage.isSecialityDoctorTableShowingUp(), "Speciality Doctor Table is not showing up");
		doctorSchedulePage.clickOnClearButton();
		doctorSchedulePage.selectSpecilityFromDropdown("Neurology");
		doctorSchedulePage.clickOnSearchButtonNearDate();
		doctorSchedulePage.selectDoctorFromDropdown("Vijay Chandra");
		doctorSchedulePage.clickOnSearchButtonNearDate();
		assertTrue(doctorSchedulePage.isSecialityDoctorTableShowingUp(), "Speciality Doctor Table is not showing up");
		doctorSchedulePage.clickOnGreenGeneratedScheduleForPreviousTime();
		assertTrue(doctorSchedulePage.isTimeOfAppointmentWithGreaterMessageShowing(), "Time of Appointment with Greater that current time message is not showing up");
		doctorSchedulePage.clickOnGreenGeneratedScheduleForFutureTime();
		assertTrue(doctorSchedulePage.isAppointmentSchedulingPopupDisplayed(), "Appointment Scheduling Popup is not showing up");
		doctorSchedulePage.clickOnSaveButtonOnAppointmentSchedulingPopup();
		assertTrue(doctorSchedulePage.isEnterValidUhidMessageShowingUp(), "Enter Valid UHID Message is not showing up");
		doctorSchedulePage.enterUHIDInAppointmentschedulingTextBox(patientRegistrationId);
		doctorSchedulePage.selectVisitTypeFromDropdown("Initial Visit                 ");
		doctorSchedulePage.clickOnSaveButtonOnAppointmentSchedulingPopup();
		//assertTrue(doctorSchedulePage.isAppointmentBookedSuccessfullyMessageShowingUp(), "Appointment booked Successfully Message is not showing up");


		//doctorSchedulePage.clickOnBookedYellowAppointment();

		driver.pauseExecutionFor(5000);
	}
	
	@Test(enabled = false) //fixed 07-04-2020
	public void frontOfficeDoctorScheduleWithGenerateScheduleAndLinkToExistingUHIDTest() throws Throwable {	

		test=extent.createTest("frontOfficeDoctorScheduleWithGenerateScheduleAndLinkToExistingUHIDTest", "This test case verify the Fornt Office Billing With Billing Mode Cash Patient Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		generateSchedulePage = new GenerateSchedulePage(driver);
		doctorSchedulePage = new DoctorSchedulePage(driver);


		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Doctor Schedule");
		doctorSchedulePage.clickOnLegendKey();
		assertTrue(doctorSchedulePage.isLegendForAppointmentFormOpened(), "Legend For Appointment form is not showing Up");
		doctorSchedulePage.closeLegendForAppointmentForm();
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Generate Schedule");
		generateSchedulePage.clickOnSearchButton();
		assertTrue(generateSchedulePage.verifyPleaseSelectSpecilizationMessage(), "Please Select Specialization Message not showing up");
		generateSchedulePage.clickOnPlusButton();
		assertTrue(generateSchedulePage.verifyPleaseSelectSpecialityMessage(), "Please Select Speciality Message not showing up");
		generateSchedulePage.selectSpecilizationFromDropdown("Ophthalmology");
		generateSchedulePage.selectDoctorFromDropdown("Archana G Mahajan");
		generateSchedulePage.clickOnSearchButton();
		assertTrue(generateSchedulePage.verifyNoScheduleExistMessage(), "No Schedule Exists Message not showing up");
		generateSchedulePage.selectSpecilizationFromDropdown("Neurology");
		generateSchedulePage.selectDoctorFromDropdown("Vijay Chandra");
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


		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnDoctorScheduleAndSelectAnOption("Doctor Schedule");

		doctorSchedulePage.selectFacilityFromDropdown("TRIOTREE HOSPITAL");
		doctorSchedulePage.clickOnSearchButton();
		assertTrue(doctorSchedulePage.verifyPleaseSelectSpecialityMessage(), "Please select Speciality Message not showing up");
		doctorSchedulePage.selectSpecilityFromDropdown("Anesthesiast");
		doctorSchedulePage.clickOnSearchButton();
		assertTrue(doctorSchedulePage.isSecialityDoctorTableShowingUp(), "Speciality Doctor Table is not showing up");
		doctorSchedulePage.clickOnClearButton();
		doctorSchedulePage.selectSpecilityFromDropdown("Neurology");
		doctorSchedulePage.clickOnSearchButtonNearDate();
		doctorSchedulePage.selectDoctorFromDropdown("Vijay Chandra");
		doctorSchedulePage.clickOnSearchButtonNearDate();
		assertTrue(doctorSchedulePage.isSecialityDoctorTableShowingUp(), "Speciality Doctor Table is not showing up");
		doctorSchedulePage.clickOnGreenGeneratedScheduleForPreviousTime();
		assertTrue(doctorSchedulePage.isTimeOfAppointmentWithGreaterMessageShowing(), "Time of Appointment with Greater that current time message is not showing up");
		doctorSchedulePage.clickOnGreenGeneratedScheduleForFutureTime();
		assertTrue(doctorSchedulePage.isAppointmentSchedulingPopupDisplayed(), "Appointment Scheduling Popup is not showing up");
		doctorSchedulePage.clickOnSaveButtonOnAppointmentSchedulingPopup();
		assertTrue(doctorSchedulePage.isEnterValidUhidMessageShowingUp(), "Enter Valid UHID Message is not showing up");
		doctorSchedulePage.enterUHIDInAppointmentschedulingTextBox(patientRegistrationId);
		doctorSchedulePage.selectVisitTypeFromDropdown("Initial Visit                 ");
		doctorSchedulePage.clickOnSaveButtonOnAppointmentSchedulingPopup();
		//assertTrue(doctorSchedulePage.isAppointmentBookedSuccessfullyMessageShowingUp(), "Appointment booked Successfully Message is not showing up");

		//doctorSchedulePage.clickOnBookedYellowAppointment();

		driver.pauseExecutionFor(5000);
	}
	
	@Test(enabled = false) //fixed 07-04-2020
	public void frontOfficeDeposit3Test() throws Throwable 
	{	
		test=extent.createTest("frontOfficeDeposit3Test", "This test case verify the Fornt Office Deposit3 Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);

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
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Deposits");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isAmountCanNotBeZeroMessageDisplayed(), "Amount Can Not be Zero Message is not showing up");
		depositPage.enterEmountInAmountTextBox("2000001");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isTotalAmountInCashMessageDisplayed(), "Total Amount in Cash isEqual to or Exceeds message is not showing up");

		depositPage.enterEmountInAmountTextBox("1000");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");

		depositPage.clickOnCreditCardRadioButton();
		depositPage.enterEmountInAmountTextBox("2000");
		depositPage.enterCreditCardDetails(123456789, "MASTERCARD", "Andhra Bank", "2222222222");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");
		depositPage.clickOnChequeRadioButton();
		depositPage.enterEmountInAmountTextBox("30000");
		depositPage.enterChequeDetails("123456789", "Andhra Bank", "Noida");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");
		depositPage.clickOnPrintButtonOnHeader();
		assertTrue(depositPage.isPleaseSelectDepositReceiptMessageDisplayed(), "Please Select Deposit Receipt Message is not showing up");
		depositPage.clickOnFirstDepositDetails();


		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Billing");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		billingPage.clickOnCloseButtonOnDocumentChecklistPopup();

		billingPage.closeCompanyDetailsPopup();
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
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
		assertTrue(billingPage.verifyPriceNotDefinedMessage("Price not defined for this service"), "Price Not Defined Message is not showing up");
		billingPage.selectTestsByName("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectTestsByName("17-Ketosteroids, 24hrs Urine");
		billingPage.selectTestsByName("X-ray Dorso Lumbar Spine LAT");
		billingPage.selectTestsByName("X-ray Both Leg Skyline");
		billingPage.selectAllTestSpecialityAndDoctorName("Cardiac Surgeon", "Ajeet Jain");
		billingPage.clickOnManualIcon();
		billingPage.selectServiceNameFromDropdown("Cardiology Services");
		billingPage.enterDescriptionInManualSection("Testing");
		billingPage.selectQuantityInManualSection("5");
		billingPage.enterPriceInManualSection("10.30");
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
		//billingPage.clickOnYesButtonOnAvailDepositPopup();
		//billingPage.enterAjustFromDeposit("5000");
	}

	@Test(enabled = false) // fixed 07-04-2020
	public void frontOfficeBillingUtilityWithCreditPartialCoPayPatientRefundWithDueSettlementTest() throws Throwable {

		test=extent.createTest("frontOfficeBillingUtilityWithCreditPartialCoPayPatientRefundWithDueSettlementTest", "This test case verify the Fornt Office Deposit3 Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		billsUtilityPage = new BillsUtilityPage(driver);
		approveRefundPage = new ApproveRefundPage(driver);

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
		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA-(POSH)");

		//		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");
		//		patientRegistrationPage.checkSchemeCheckBox();
		//		patientRegistrationPage.selectSchemeFromDropdown(4);
		patientRegistrationPage.clickOnRegisterIcon();
		//assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
		patientRegistrationPage.yesButtonOnConfirmPopup();
		//assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
		String patientRegistrationId =patientRegistrationPage.getUHIDOfPatient();
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
		//		assertTrue(billingPage.isCashBillingNotAllowedMessageDisplayed(), "Cash Billing Not Allowed Message is not showing Up");

		//billingPage.clickOnCloseButtonOnDocumentChecklistPopup();
		//billingPage.clickClearButtonCompDetails();
		//billingPage.closeCompanyDetailsPopup();
		try {
			billingPage.cancelSchemeForPatientPopup();
		}
		catch (Exception e) {}
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		billingPage.closeCompanyDetailsPopup();
		try {
			billingPage.closeRemarksPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.clickPreviousVisitIcon();
		assertTrue(billingPage.isPreviousVisitPopupOpened(), "Previous Visit Popup is not opened");
		//billingPage.closePreviousVisitPopup();
		//		billingPage.selectSpecialityFromChooseSpecialityDropdown("Pathologist");
		//		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Megha");
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
		billingPage.enterDescriptionInManualSection("Testing");
		billingPage.selectQuantityInManualSection("5");
		billingPage.enterPriceInManualSection("10.30");
		billingPage.clickOnVerifyButton();
		billingPage.clickOnOtherServicesIcon();
		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
		assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Dialysis Procedures" , "AV Fistula Day Care Package With Anesthesia");
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnInsuranceCompanyButton();
		//billingPage.selectRateContractInCompDetailsPopup("AMERICAN EMBASSY");
		//billingPage.selectDocumentFromDocumentChecklistPopup("Case Record");
		//billingPage.selectDocumentFromDocumentChecklistPopup(idCard);
		//billingPage.selectDocumentFromDocumentChecklistPopup("Form 60");
		//billingPage.selectDocumentFromDocumentChecklistPopup("OP Prescription");
		try {
			billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		}
		catch (Exception e) {}
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		//billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Embassy", "AMERICAN EMBASSY", "OTHER", "AMERICAN EMBASSY", "0", "50");
		billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "0", "50");
		try {
			billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		billingPage.clickOnAddToBillButton();
		try {
			//assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
			billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.checkDiscountCheckbox();




		billingPage.clickOnYesBtnUnderProvideDiscountPopup();




		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("30% Automation Testing");

		//		
		//		billingPage.enterDiscountAmount("20000");
		//		billingPage.enterDiscountAmount("500");
		//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//		assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		billingPage.selectAuthorisedByFromDropdown("As per MOU of NDMC");
		//		billingPage.selectOnCompanyRadioButton();
		//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//		assertTrue(billingPage.isCompOnlyDiscoutErrorMessageDisplayed(), "Comp Only Discount Error Message is NOT Displayed");
		billingPage.selectOnPatientRadioButton();
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		billingPage.enterPatientPaidAmount("500");


		billingPage.clickOnNewPaymentModeButton();
		billingPage.selectSecondPaymentMode("Debit Card");
		billingPage.enterPatientPaidAmountForSecondTransaction("200");
		billingPage.enterCardDetailsAndSaveDetails("MASTERCARD", "123456789", "Andhra Bank", "2222222222");
		billingPage.selectAythorisedByInProcessPaymentPopupAndAddRemarks("As per MOU of NDMC");
		billingPage.clickOnVerifyButtonOnProcessPaymentPopup();
		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		//billingPage.clickOnNoButtonOnPrintOPDCard();




		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Bills Utility");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		billsUtilityPage.processDueSettlement();
		billsUtilityPage.clickOnServicesIcon();


		billsUtilityPage.clickOnSelectRefundButton();
		billsUtilityPage.selectServices("Deepak Koshal");
		billsUtilityPage.selectServices("17-Hydroxycorticosteroids, 24hrs Urine");
		billsUtilityPage.selectServices("X-ray Both Leg Skyline");
		billsUtilityPage.selectReasonAndSendApprovalRequest("Wrong Test Selected");
		billsUtilityPage.clickOnSelectRefundButton();
		billsUtilityPage.selectServices("Deepak Koshal");
		billsUtilityPage.selectServices("17-Hydroxycorticosteroids, 24hrs Urine");
		billsUtilityPage.selectServices("X-ray Both Leg Skyline");
		billsUtilityPage.selectServices("17-Ketosteroids, 24hrs Urine");
		billsUtilityPage.selectServices("X-ray Dorso Lumbar Spine LAT");
		billsUtilityPage.selectReasonAndSendApprovalRequest("Automation Refund Reason");


		billsUtilityPage.clickOnSelectRefundButton();
		billsUtilityPage.selectServices("Deepak Koshal");
		billsUtilityPage.selectServices("17-Hydroxycorticosteroids, 24hrs Urine");
		billsUtilityPage.selectServices("X-ray Both Leg Skyline");
		billsUtilityPage.selectServices("17-Ketosteroids, 24hrs Urine");
		billsUtilityPage.selectServices("X-ray Dorso Lumbar Spine LAT");
		billsUtilityPage.selectReasonAndSendApprovalRequest("Automation Refund Reason");



		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Approve Refunds");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		//approveRefundPage.clickOnApproveButton();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Bills Utility");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		//billsUtilityPage.clickOnYesButtonApprovalAgainstBillNoPopup();
		billsUtilityPage.selectDueSettlementTab();
		billsUtilityPage.selectModeOfPayment("Credit Card");
		billsUtilityPage.enterCreditCardDetails();
		billsUtilityPage.selectPlusButton();

	}
	
	@Test(enabled = false) // fixed 07-04-2020
	public void frontOfficeBillingUtilityFindAllBillForOnePatientTest() throws Throwable {

		test=extent.createTest("frontOfficeBillingUtilityFindAllBillForOnePatientTest", "This test case verify the Fornt Office Deposit3 Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		billsUtilityPage = new BillsUtilityPage(driver);
		approveRefundPage = new ApproveRefundPage(driver);

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

		//		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");
		//		patientRegistrationPage.checkSchemeCheckBox();
		//		patientRegistrationPage.selectSchemeFromDropdown(4);
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
		//		assertTrue(billingPage.isCashBillingNotAllowedMessageDisplayed(), "Cash Billing Not Allowed Message is not showing Up");

		try {
			billingPage.cancelSchemeForPatientPopup();
		}
		catch (Exception e) {}
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();

		billingPage.closeCompanyDetailsPopup();

		billingPage.closeRemarksPopup();
		billingPage.clickPreviousVisitIcon();
		assertTrue(billingPage.isPreviousVisitPopupOpened(), "Previous Visit Popup is not opened");
		//billingPage.closePreviousVisitPopup();

		//		billingPage.selectSpecialityFromChooseSpecialityDropdown("Pathologist");
		//		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Megha");
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
		billingPage.enterDescriptionInManualSection("Testing");
		billingPage.selectQuantityInManualSection("5");
		billingPage.enterPriceInManualSection("10.30");
		billingPage.clickOnVerifyButton();
		billingPage.clickOnOtherServicesIcon();
		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
		assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Dialysis Procedures" , "AV Fistula Day Care Package With Anesthesia");
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnInsuranceCompanyButton();
		try {
			billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		}
		catch (Exception e) {
		}
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		//billingPage.selectRateContractInCompDetailsPopup("AMERICAN EMBASSY");
		//billingPage.selectDocumentFromDocumentChecklistPopup("Case Record");
		//billingPage.selectDocumentFromDocumentChecklistPopup(idCard);
		//billingPage.selectDocumentFromDocumentChecklistPopup("Form 60");
		//billingPage.selectDocumentFromDocumentChecklistPopup("OP Prescription");
		//billingPage.saveDocumentChecklistPopup();


		try {
			//billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Embassy", "AMERICAN EMBASSY", "OTHER", "AMERICAN EMBASSY", "0", "50");
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "0", "50");
			billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		billingPage.clickOnAddToBillButton();
		try {
			//assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
			billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.checkDiscountCheckbox();

		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("30% Automation Testing");


		billingPage.selectAuthorisedByFromDropdown("As per MOU of NDMC");
		//		billingPage.selectOnCompanyRadioButton();
		//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//		assertTrue(billingPage.isCompOnlyDiscoutErrorMessageDisplayed(), "Comp Only Discount Error Message is NOT Displayed");
		billingPage.selectOnPatientRadioButton();
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		billingPage.enterPatientPaidAmount("5000");


		billingPage.clickOnNewPaymentModeButton();
		billingPage.selectSecondPaymentMode("Debit Card");
		billingPage.enterPatientPaidAmountForSecondTransaction("200");
		billingPage.enterCardDetailsAndSaveDetails("MASTERCARD", "123456789", "Andhra Bank", "2222222222");
		billingPage.selectAythorisedByInProcessPaymentPopupAndAddRemarks("As per MOU of NDMC");
		billingPage.clickOnVerifyButtonOnProcessPaymentPopup();
		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		//billingPage.clickOnNoButtonOnPrintOPDCard();
	}

	@Test(enabled = false) //fixed 07-04-2020
	public void frontOfficeToAddDOBMobileNoAddressGaurdianNameTest() throws Throwable {	

		test=extent.createTest("frontOfficeToAddDOBMobileNoAddressGaurdianNameTest", "This test case verify the Fornt Office Deposit3 Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		billsUtilityPage = new BillsUtilityPage(driver);
		approveRefundPage = new ApproveRefundPage(driver);

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

		//		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");
		//		patientRegistrationPage.checkSchemeCheckBox();
		//		patientRegistrationPage.selectSchemeFromDropdown(4);
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
		//		assertTrue(billingPage.isCashBillingNotAllowedMessageDisplayed(), "Cash Billing Not Allowed Message is not showing Up");

		try {
			billingPage.cancelSchemeForPatientPopup();
		}
		catch (Exception e) {}
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		billingPage.closeCompanyDetailsPopup();

		billingPage.closeRemarksPopup();
		billingPage.clickPreviousVisitIcon();
		assertTrue(billingPage.isPreviousVisitPopupOpened(), "Previous Visit Popup is not opened");
		//billingPage.closePreviousVisitPopup();

		//		billingPage.selectSpecialityFromChooseSpecialityDropdown("Pathologist");
		//		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Megha");
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
		billingPage.enterDescriptionInManualSection("Testing");
		billingPage.selectQuantityInManualSection("5");
		billingPage.enterPriceInManualSection("10.30");
		billingPage.clickOnVerifyButton();
		billingPage.clickOnOtherServicesIcon();
		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
		assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Dialysis Procedures" , "AV Fistula Day Care Package With Anesthesia");
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnInsuranceCompanyButton();
		try {
			billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		}
		catch (Exception e) {
		}
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		//billingPage.selectRateContractInCompDetailsPopup("AMERICAN EMBASSY");

		//billingPage.selectDocumentFromDocumentChecklistPopup("Case Record");
		//billingPage.selectDocumentFromDocumentChecklistPopup(idCard);
		//billingPage.selectDocumentFromDocumentChecklistPopup("Form 60");
		//billingPage.selectDocumentFromDocumentChecklistPopup("OP Prescription");
		//billingPage.saveDocumentChecklistPopup();



		try {
			//billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Embassy", "AMERICAN EMBASSY", "OTHER", "AMERICAN EMBASSY", "0", "50");
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "0", "50");
			billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		billingPage.clickOnAddToBillButton();
		try {
			//assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
			billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.checkDiscountCheckbox();




		billingPage.clickOnYesBtnUnderProvideDiscountPopup();




		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("30% Automation Testing");

		//		
		//		billingPage.enterDiscountAmount("20000");
		//		billingPage.enterDiscountAmount("500");
		//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//		assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		billingPage.selectAuthorisedByFromDropdown("As per MOU of NDMC");
		//		billingPage.selectOnCompanyRadioButton();
		//		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//		assertTrue(billingPage.isCompOnlyDiscoutErrorMessageDisplayed(), "Comp Only Discount Error Message is NOT Displayed");
		billingPage.selectOnPatientRadioButton();
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		billingPage.enterPatientPaidAmount("500");


		billingPage.clickOnNewPaymentModeButton();
		billingPage.selectSecondPaymentMode("Debit Card");
		billingPage.enterPatientPaidAmountForSecondTransaction("200");
		billingPage.enterCardDetailsAndSaveDetails("MASTERCARD", "123456789", "Andhra Bank", "2222222222");
		billingPage.selectAythorisedByInProcessPaymentPopupAndAddRemarks("As per MOU of NDMC");
		billingPage.clickOnVerifyButtonOnProcessPaymentPopup();
		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		///billingPage.clickOnNoButtonOnPrintOPDCard();




		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Bills Utility");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		billsUtilityPage.processDueSettlement();
		billsUtilityPage.clickOnServicesIcon();


		billsUtilityPage.clickOnSelectRefundButton();
		billsUtilityPage.selectServices("Deepak Koshal");
		billsUtilityPage.selectServices("17-Hydroxycorticosteroids, 24hrs Urine");
		billsUtilityPage.selectServices("X-ray Both Leg Skyline");
		billsUtilityPage.selectReasonAndSendApprovalRequest("Wrong Test Selected");
		billsUtilityPage.clickOnSelectRefundButton();
		billsUtilityPage.selectServices("Deepak Koshal");
		billsUtilityPage.selectServices("17-Hydroxycorticosteroids, 24hrs Urine");
		billsUtilityPage.selectServices("X-ray Both Leg Skyline");
		billsUtilityPage.selectServices("17-Ketosteroids, 24hrs Urine");
		billsUtilityPage.selectServices("X-ray Dorso Lumbar Spine LAT");
		billsUtilityPage.selectReasonAndSendApprovalRequest("Automation Refund Reason");


		billsUtilityPage.clickOnSelectRefundButton();
		billsUtilityPage.selectServices("Deepak Koshal");
		billsUtilityPage.selectServices("17-Hydroxycorticosteroids, 24hrs Urine");
		billsUtilityPage.selectServices("X-ray Both Leg Skyline");
		billsUtilityPage.selectServices("17-Ketosteroids, 24hrs Urine");
		billsUtilityPage.selectServices("X-ray Dorso Lumbar Spine LAT");
		billsUtilityPage.selectReasonAndSendApprovalRequest("Automation Refund Reason");



		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Approve Refunds");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		//approveRefundPage.clickOnApproveButton();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Bills Utility");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		//billsUtilityPage.clickOnYesButtonApprovalAgainstBillNoPopup();
		billsUtilityPage.selectDueSettlementTab();
		billsUtilityPage.selectModeOfPayment("Credit Card");
		billsUtilityPage.enterCreditCardDetails();
		billsUtilityPage.selectPlusButton();		

	}

	@Test(enabled = false) //fixed 31-March-2020
	public void frontOfficeBillUtilitySearchPatientbyDateRangeAndRefundTheBillTest() throws Throwable {	

		test=extent.createTest("frontOfficeBillUtilitySearchPatientbyDateRangeAndRefundTheBillTest", "This test case verify the Fornt Office Deposit3 Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		billsUtilityPage = new BillsUtilityPage(driver);
		approveRefundPage = new ApproveRefundPage(driver);

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
		//		patientRegistrationPage.checkSchemeCheckBox();
		//		patientRegistrationPage.selectSchemeFromDropdown(4);
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
		//		assertTrue(billingPage.isCashBillingNotAllowedMessageDisplayed(), "Cash Billing Not Allowed Message is not showing Up");

		//billingPage.clickOnCloseButtonOnDocumentChecklistPopup();
		try {
			billingPage.cancelSchemeForPatientPopup();
		}
		catch (Exception e) {}
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		billingPage.closeCompanyDetailsPopup();

		try {
			billingPage.closeRemarksPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.clickPreviousVisitIcon();
		assertTrue(billingPage.isPreviousVisitPopupOpened(), "Previous Visit Popup is not opened");

		//		billingPage.selectSpecialityFromChooseSpecialityDropdown("Pathologist");
		//		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Megha");
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
		billingPage.enterDescriptionInManualSection("Testing");
		billingPage.selectQuantityInManualSection("5");
		billingPage.enterPriceInManualSection("10.30");
		billingPage.clickOnVerifyButton();
		billingPage.clickOnOtherServicesIcon();
		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
		assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Dialysis Procedures" , "AV Fistula Day Care Package With Anesthesia");
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);
		billingPage.clickOnInsuranceCompanyButton();
		//////////////////////////////////////////////////
		try {
			billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		}
		catch (Exception e) {
		}

		try {
			//billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Embassy", "AMERICAN EMBASSY", "OTHER", "AMERICAN EMBASSY", "0", "50");
			billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "0", "50");
			billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//billingPage.clickOnAddToBillButton();
		billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		//billingPage.enterBillingRemarks();
		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();


		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("30% Automation Testing");


		billingPage.selectAuthorisedByFromDropdown("As per MOU of NDMC");
		//billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		//assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");


		//billingPage.selectAuthorisedByFromDropdown("Management Decision");/////////////////////
		billingPage.selectOnPatientRadioButton();		
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		billingPage.enterPatientPaidAmount("5000");

		billingPage.clickOnNewPaymentModeButton();
		billingPage.selectSecondPaymentMode("Debit Card");
		billingPage.enterPatientPaidAmountForSecondTransaction("200");
		billingPage.enterCardDetailsAndSaveDetails("MASTERCARD", "123456789", "Andhra Bank", "2222222222");

		try {
			//billingPage.selectAythorisedByInProcessPaymentPopupAndAddRemarks("Management Decision");
			billingPage.selectAythorisedByInProcessPaymentPopupAndAddRemarks("As per MOU of NDMC");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			billingPage.clickOnVerifyButtonOnProcessPaymentPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		//billingPage.clickOnNoButtonOnPrintOPDCard();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Bills Utility");
		billsUtilityPage. searchPatientDetails();
		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);
		billsUtilityPage.clickOnSelectRefundButton();
		try {
			billsUtilityPage.selectServices("17-Hydroxycorticosteroids, 24hrs Urine");
			billsUtilityPage.enterUsernamePasswordAndSelectApproveButton("Deepak", "Test1234$");
		}
		catch (Exception e) {
			billsUtilityPage.closerefund();
		}

		billsUtilityPage.selectReasonFromReasonDropdown("Wrong Entry");
		billsUtilityPage.enterRemarks();
		//		billsUtilityPage.clickOnSaveButton();
		//		
		//		billsUtilityPage.clickYesButtonRefundByCashPopup();
		//		billsUtilityPage.clickClearButton();
		//		billsUtilityPage. searchPatientDetails();
		//		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);
		//		billsUtilityPage.clickOnSelectRefundButton();
		//		billsUtilityPage.selectServices("17-Hydroxycorticosteroids, 24hrs Urine");
		//		billsUtilityPage.selectServices("Deepak Koshal");
		//		billsUtilityPage.selectServices("X-ray Dorso Lumbar Spine LAT");
		//		billsUtilityPage.selectServices("X-ray Both Leg Skyline");
		//		billsUtilityPage.selectServices("Testing");
		//		billsUtilityPage.enterUsernamePasswordAndSelectApproveButton("Deepak", "Test1234$");
		//		billsUtilityPage.selectReasonFromReasonDropdown("Wrong Entry");
		//		billsUtilityPage.enterRemarks();
		//		billsUtilityPage.clickOnSaveButton();
		//		billsUtilityPage.clickYesButtonRefundByCashPopup();
		//
		//		billsUtilityPage.clickClearButton();
		//		billsUtilityPage. searchPatientDetails();
		//		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);
		//		billsUtilityPage.clickOnSelectRefundButton();
		//		billsUtilityPage.selectAllServices();
		//		billsUtilityPage.enterUsernamePasswordAndSelectApproveButton("Deepak", "Test1234$");
		//		billsUtilityPage.selectReasonFromReasonDropdown("Wrong Entry");
		//		billsUtilityPage.enterRemarks();
		//		billsUtilityPage.clickOnSaveButton();
		//		billsUtilityPage.clickYesButtonRefundByCashPopup();
		//
		//		billsUtilityPage.clickClearButton();
		//		billsUtilityPage. searchPatientDetails();
		//
		//		assertTrue(billsUtilityPage.verifyRefundIsInPinkColour(), "Refund in Pink Colour is not showing up");

	}

	@Test(enabled = false) //fixed 07-04-2020
	public void frontOfficeBillUtilityShowIpEmBillDetailsTest() throws Throwable {	

		test=extent.createTest("frontOfficeBillUtilityShowIpEmBillDetailsTest", "This test case verify the Fornt Office Deposit3 Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		billsUtilityPage = new BillsUtilityPage(driver);
		approveRefundPage = new ApproveRefundPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnFronOfficeIcon();
		hisHomePage.selectStationAndClickOnYes("Front Office");
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Bills Utility");
		billsUtilityPage.clearuhidandBillNo();
		billsUtilityPage.clickSearchButton();
		billsUtilityPage.selectShowIpCheckbox();
		billsUtilityPage.searchPatientDetailsWithoutClickingSearchButton();
		billsUtilityPage.selectOpPatientType();
		assertTrue(billsUtilityPage.verifyPatientIsOpened(), "OP Patient is not showing up");

		billsUtilityPage.clearuhidandBillNo();
		billsUtilityPage.clickSearchButton();
		billsUtilityPage.selectShowIpCheckbox();
		billsUtilityPage.searchPatientDetailsWithoutClickingSearchButton();
		billsUtilityPage.selectIPPatientType();		
	}

	@Test(enabled = false)/////fixed
	public void frontOfficeBillingFullyCreditBillPatientRefundWithRefundApprovalTest() throws Throwable {

		test=extent.createTest("frontOfficeBillingFullyCreditBillPatientRefundWithRefundApprovalTest", "This test case verify the Fornt Office Deposit3 Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		billsUtilityPage = new BillsUtilityPage(driver);
		approveRefundPage = new ApproveRefundPage(driver);

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
		//		patientRegistrationPage.checkSchemeCheckBox();
		//		patientRegistrationPage.selectSchemeFromDropdown(1);
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
		billingPage.enterDescriptionInManualSection("Testing");
		billingPage.selectQuantityInManualSection("5");
		billingPage.enterPriceInManualSection("10.30");
		billingPage.clickOnVerifyButton();
		billingPage.clearManualSection();
		billingPage.enterDescriptionInManualSection("Testing");
		billingPage.selectQuantityInManualSection("5");
		billingPage.enterPriceInManualSection("11");
		billingPage.clickOnVerifyButton();
		billingPage.clickOnOtherServicesIcon();
		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
		assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Dialysis Procedures" , "AV Fistula Day Care Package With Anesthesia");
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);



		billingPage.clickOnInsuranceCompanyButton();
		try {
			billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		}
		catch (Exception e) {
		}
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();

		//billingPage.selectRateContractInCompDetailsPopup("AMERICAN EMBASSY");
		//billingPage.selectDocumentFromDocumentChecklistPopup("Case Record");
		//billingPage.selectDocumentFromDocumentChecklistPopup(idCard);
		//billingPage.selectDocumentFromDocumentChecklistPopup("Form 60");
		//billingPage.selectDocumentFromDocumentChecklistPopup("OP Prescription");
		//billingPage.saveDocumentChecklistPopup();

		//billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Embassy", "AMERICAN EMBASSY", "OTHER", "AMERICAN EMBASSY", "", "");
		//billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		try {
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "0", "50");
			billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		billingPage.clickOnAddToBillButton();
		try {
			//assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
			billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.enterBillingRemarks();

		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("30% Automation Testing");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		billingPage.selectAuthorisedByFromDropdown("Management Decision");
		billingPage.selectOnCompanyRadioButton();
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		try {
			billingPage.saveprocesspayment();
		}
		catch (Exception e) {}
		try {
			billingPage.clickOnNoButtonOnBillGotGeneratedPopup();/////////////////
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Bills Utility");
		billsUtilityPage. searchPatientDetails();

		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);

		billsUtilityPage.clickOnSaveButton();

		billsUtilityPage.clickYesButtonRefundByCashPopup();
		billsUtilityPage.clickNoButtonRefundByCashPopup();
		billsUtilityPage.clickOnSelectRefundButton();

		billsUtilityPage.selectAllServices();

		billsUtilityPage.clickSendApprovalRequestButton();
		billsUtilityPage.selectReasonForRefund();
		billsUtilityPage.clickSendApprovalRequestButton();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Approve Refunds");

		approveRefundPage.selectFromDate();
		approveRefundPage.clickOnSearchButton();
		approveRefundPage.clickOnApproveButton();
		approveRefundPage.selectApprovedRadioButton();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Bills Utility");
		billsUtilityPage. searchPatientDetails();
		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);
		billsUtilityPage.clickOnYesButtonApprovalAgainstBillNoPopup();
		billsUtilityPage.selectModeOfPaymentFromBillUtility("Cheque");
		billsUtilityPage.enterChequeDetails();
		billsUtilityPage.clickOnSaveButton();
	}

	@Test(enabled = false)/////////fixed 31-March-2020
	public void frontOfficeBillingFullyCreditPatientRefundApprovalAndAlsoRejectApprovalTest() throws Throwable {

		test=extent.createTest("frontOfficeBillingFullyCreditPatientRefundApprovalAndAlsoRejectApprovalTest", "This test case verify the Fornt Office Deposit3 Test Case");
		test.assignCategory("Front Office Billing");
		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		billsUtilityPage = new BillsUtilityPage(driver);
		approveRefundPage = new ApproveRefundPage(driver);

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
		//		patientRegistrationPage.checkSchemeCheckBox();
		//		patientRegistrationPage.selectSchemeFromDropdown(1);
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
		billingPage.enterDescriptionInManualSection("Testing");
		billingPage.selectQuantityInManualSection("5");
		billingPage.enterPriceInManualSection("10.30");
		billingPage.clickOnVerifyButton();
		billingPage.clearManualSection();
		billingPage.enterDescriptionInManualSection("Testing");
		billingPage.selectQuantityInManualSection("5");
		billingPage.enterPriceInManualSection("11");
		billingPage.clickOnVerifyButton();
		billingPage.clickOnOtherServicesIcon();
		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
		assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Dialysis Procedures" , "AV Fistula Day Care Package With Anesthesia");
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);




		billingPage.clickOnInsuranceCompanyButton();
		try {
			billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		}
		catch (Exception e) {
		}
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();
		//billingPage.selectRateContractInCompDetailsPopup("AMERICAN EMBASSY");
		//billingPage.selectDocumentFromDocumentChecklistPopup("Case Record");
		//billingPage.selectDocumentFromDocumentChecklistPopup(idCard);
		//billingPage.selectDocumentFromDocumentChecklistPopup("Form 60");
		//billingPage.selectDocumentFromDocumentChecklistPopup("OP Prescription");
		//billingPage.saveDocumentChecklistPopup();


		//billingPage.enterDetailsInCompDetailsPopupAndPressYesButtonMethod1("Corporate", "STATE BANK OF INDIA", "0", "STATE BANK OF INDIA - (CGHS)", "", "20");
		//billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");

		try {
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "0", "50");
			billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.enterBillingRemarks();

		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("30% Automation Testing");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		billingPage.selectAuthorisedByFromDropdown("As per MOU of NDMC");

		billingPage.selectOnCompanyRadioButton();
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		try {
			billingPage.saveprocesspayment();
		}
		catch (Exception e) {}


		//billingPage.enterPatientPaidAmount("500");


		//billingPage.clickOnNewPaymentModeButton();
		//billingPage.selectSecondPaymentMode("Debit Card");
		//		billingPage.enterPatientPaidAmountForSecondTransaction("200");
		//billingPage.enterCardDetailsAndSaveDetails("MASTERCARD", "123456789", "Andhra Bank", "2222222222");
		//		try {
		//			billingPage.selectAythorisedByInProcessPaymentPopupAndAddRemarks("As per MOU of NDMC");
		//		} catch (Exception e2) {
		//			// TODO Auto-generated catch block
		//			e2.printStackTrace();
		//		}
		//		try {
		//			billingPage.clickOnVerifyButtonOnProcessPaymentPopup();
		//		} catch (Exception e2) {
		//			// TODO Auto-generated catch block
		//			e2.printStackTrace();
		//		}
		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();

		//		try {
		//			billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		//		} catch (Exception e1) {
		//			e1.printStackTrace();
		//		}

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Bills Utility");
		billsUtilityPage. searchPatientDetails();
		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);

		billsUtilityPage.clickOnSaveButton();

		billsUtilityPage.clickYesButtonRefundByCashPopup();
		billsUtilityPage.clickNoButtonRefundByCashPopup();
		billsUtilityPage.clickOnSelectRefundButton();	

		billsUtilityPage.selectAllServices();
		billsUtilityPage.clickSendApprovalRequestButton();


		billsUtilityPage.selectReasonForRefund();
		billsUtilityPage.clickSendApprovalRequestButton();
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Approve Refunds");

		approveRefundPage.selectFromDate();
		approveRefundPage.clickOnSearchButton();
		approveRefundPage.clickOnRejectButton();




		approveRefundPage.selectRejectRadioButton();

		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Bills Utility");
		billsUtilityPage. searchPatientDetails();
		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);
		billsUtilityPage.clickOnSaveButton();
		billsUtilityPage.clickYesButtonRefundByCashPopup();
		billsUtilityPage.clickNoButtonRefundByCashPopup();
		billsUtilityPage.clickOnSelectRefundButton();		
		billsUtilityPage.selectAllServices();
		billsUtilityPage.clickSendApprovalRequestButton();


		billsUtilityPage.selectReasonForRefund();
		billsUtilityPage.clickSendApprovalRequestButton();



		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Approve Refunds");

		approveRefundPage.selectFromDate();
		approveRefundPage.clickOnSearchButton();
		approveRefundPage.clickOnApproveButton();
		approveRefundPage.selectApprovedRadioButton();


		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Bills Utility");
		billsUtilityPage. searchPatientDetails();
		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);
		billsUtilityPage.clickOnYesButtonApprovalAgainstBillNoPopup();
		billsUtilityPage.selectModeOfPaymentFromBillUtility("Cheque");
		billsUtilityPage.enterChequeDetails();
		billsUtilityPage.clickOnSaveButton();

	}

	@Test(enabled = false) // fixed 1-04-2020
	public void frontOfficeBillUtilityCashPatientRefundWithDueSettlementTest() throws Throwable {

		test=extent.createTest("frontOfficeBillUtilityCashPatientRefundWithDueSettlementTest", "This test case verify the Fornt Office Deposit3 Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		billsUtilityPage = new BillsUtilityPage(driver);
		approveRefundPage = new ApproveRefundPage(driver);

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
		//patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA-(POSH)");
		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");
		//		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");
		//		patientRegistrationPage.checkSchemeCheckBox();
		//		patientRegistrationPage.selectSchemeFromDropdown(4);
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
		//		assertTrue(billingPage.isCashBillingNotAllowedMessageDisplayed(), "Cash Billing Not Allowed Message is not showing Up");
		try {
			billingPage.clickOnCloseButtonOnDocumentChecklistPopup();
		}
		catch (Exception e) {
			// TODO: handle exception
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
			billingPage.closeSchemeForPatientPopup();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			billingPage.closeRemarksPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		//		billingPage.selectSpecialityFromChooseSpecialityDropdown("Pathologist");
		//		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Megha");
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
		billingPage.enterDescriptionInManualSection("Testing");
		billingPage.selectQuantityInManualSection("5");
		billingPage.enterPriceInManualSection("10.30");
		billingPage.clickOnVerifyButton();
		billingPage.clickOnOtherServicesIcon();
		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
		assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Dialysis Procedures" , "AV Fistula Day Care Package With Anesthesia");
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");
		billingPage.selectFacilitatorFromDropdown(1);

		//billingPage.clickOnAddToBillButton();
		///billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.clickOnInsuranceCompanyButton();
		try {
			billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		}
		catch (Exception e) {
		}
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();

		try {
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "0", "50");
			billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			//assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
			billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.enterBillingRemarks();
		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("30% Automation Testing");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		billingPage.selectAuthorisedByFromDropdown("Management Decision");

		billingPage.selectOnPatientRadioButton();		
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		billingPage.enterPatientPaidAmount("5000");
		billingPage.clickOnNewPaymentModeButton();
		billingPage.selectSecondPaymentMode("Debit Card");
		billingPage.enterPatientPaidAmountForSecondTransaction("7000");
		billingPage.enterCardDetailsAndSaveDetails("MASTERCARD", "123456789", "Andhra Bank", "2222222222");

		try {
			billingPage.selectAythorisedByInProcessPaymentPopupAndAddRemarks("Management Decision");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			billingPage.clickOnVerifyButtonOnProcessPaymentPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		//billingPage.clickOnNoButtonOnPrintOPDCard();
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Bills Utility");
		billsUtilityPage. searchPatientDetails();
		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);
		billsUtilityPage.clickOnSelectRefundButton();
		billsUtilityPage.selectAllServices();
		billsUtilityPage.closeRefundPopup();
		billsUtilityPage.selectDueSettlementTab();
		billsUtilityPage.enterAmountToBeSettled("1000");
		billsUtilityPage.selectPlusButton();
		billsUtilityPage.selectModeOfPayment("Credit Card");
		billsUtilityPage.enterCreditCardDetails();
		billsUtilityPage.selectPlusButton();	
		billsUtilityPage.clickMakeReceiptButton();
		billsUtilityPage.clickClearButton();
		billsUtilityPage. searchPatientDetails();
		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);
		billsUtilityPage.clickOnSelectRefundButton();
		billsUtilityPage.selectServices("Deepak Koshal");
		billsUtilityPage.selectServices("17-Hydroxycorticosteroids, 24hrs Urine");
		billsUtilityPage.selectServices("X-ray Both Leg Skyline");
		billsUtilityPage.enterUsernamePasswordAndSelectApproveButton("Deepak", "Test1234$");

		billsUtilityPage.selectReasonFromReasonDropdown("Automation Refund Reason");
		billsUtilityPage.enterRemarks();
		billsUtilityPage.clickOnSaveButton();
		try {
			billsUtilityPage.clickMakeReceiptButton();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billsUtilityPage.clickYesButtonRefundByCashPopup();
		billsUtilityPage.clickClearButton();
		billsUtilityPage. searchPatientDetails();
		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);
		billsUtilityPage.clickOnSelectRefundButton();
		billsUtilityPage.selectAllServices();
		billsUtilityPage.enterUsernamePasswordAndSelectApproveButton("Deepak", "Test1234$");
		billsUtilityPage.selectReasonFromReasonDropdown("Automation Refund Reason");
		billsUtilityPage.clickSendApprovalRequestButton();

		billsUtilityPage.selectModeOfPayment("Credit Card");
		billsUtilityPage.enterCreditCardDetails();
		billsUtilityPage.selectPlusButton();	
		try {
			billsUtilityPage.clickMakeReceiptButton();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billsUtilityPage.clickClearButton();
		billsUtilityPage. searchPatientDetails();
		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);
		billsUtilityPage.selectYesApprovalRequestPopup();
		billsUtilityPage.selectReasonFromReasonDropdown("Automation Refund Reason");
		billsUtilityPage.selectModeOfPaymentFromBillUtility("Cheque");
		billsUtilityPage.enterChequeDetails();
		billsUtilityPage.clickOnSaveButton();
		try {
			billsUtilityPage.clickOnSaveButton();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		billsUtilityPage.clickOnSelectRefundButton();
		billsUtilityPage.selectAllServices();
		billsUtilityPage.selectReasonFromReasonDropdown("Automation Refund Reason");
		billsUtilityPage.clickOnSaveButton();
		billsUtilityPage.clickYesButtonRefundByCashPopup();

	}	

	@Test(enabled = false) //not fixed 31-03-2020
	public void frontOfficeDeposit6Test() throws Throwable {	

		test=extent.createTest("frontOfficeDeposit6Test", "This test case verify the Fornt Office Deposit3 Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		mergeAndUnmergeDuplicatePage = new MergeAndUnmergeDuplicatePage(driver);
		depositPage = new DepositPage(driver);


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
		assertTrue(patientRegistrationPage.verifyConfirmPatientDetailsPopupPresence("Confirm Patient Details"), "Confirm Patient Details Popup is not showing Up");
		patientRegistrationPage.yesButtonOnConfirmPopup();
		assertTrue(patientRegistrationPage.verifyRegisteredSuccessfullPopupPresence("Registered Successfully"), "Registered Successfully Popup is not showing Up");
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
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Deposits");		
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		depositPage.clickOnClearButton();
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId2);
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnremarksOk']"), 120);
			driver.click(By.xpath("//a[@id='btnremarksOk']"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		depositPage.clickYesButtonPatienIsMerged();
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnremarksOk']"), 120);
			driver.click(By.xpath("//a[@id='btnremarksOk']"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		depositPage.clickOnClearButton();
		patientRegistrationPage.searchUHIDFromSearchBoxOnHeader(patientRegistrationId2);
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnremarksOk']"), 120);
			driver.click(By.xpath("//a[@id='btnremarksOk']"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		depositPage.clickNoButtonPatienIsMerged();

		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		//		assertTrue(depositPage.isAmountCanNotBeZeroMessageDisplayed(), "Amount Can Not be Zero Message is not showing up");
		depositPage.enterEmountInAmountTextBox("2000001");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isTotalAmountInCashMessageDisplayed(), "Total Amount in Cash isEqual to or Exceeds message is not showing up");

		depositPage.enterEmountInAmountTextBox("1000");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");

		depositPage.clickOnCreditCardRadioButton();
		depositPage.enterEmountInAmountTextBox("2000");
		depositPage.enterCreditCardDetails(123456789, "MASTERCARD", "Andhra Bank", "2222222222");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");
		depositPage.clickOnChequeRadioButton();
		depositPage.enterEmountInAmountTextBox("2000");
		depositPage.enterChequeDetails("123456789", "Andhra Bank", "Noida");
		depositPage.clickOnDepositButtonOnHeader();
		assertTrue(depositPage.isConfirmDepositMessageDisplayed(), "Confirm Deposit Popup is not showing up");
		depositPage.clickOnYesButtonOnConfirmDepositPopup();
		assertTrue(depositPage.isDepositTakenSuccessfullyMessageDisplayed(), "Deposit Taken Successfully Message is not showing up");
		depositPage.clickOnPrintButtonOnHeader();
		assertTrue(depositPage.isPleaseSelectDepositReceiptMessageDisplayed(), "Please Select Deposit Receipt Message is not showing up");
		depositPage.clickOnFirstDepositDetails();
	}

	@Test(enabled = false) ///  fixed 1-April-2020
	public void frontOfficeBillUtilityCashPatientWithDiscountDueAmountAndRefundBillWithDueSettlementTest() throws Throwable {	

		test=extent.createTest("frontOfficeBillUtilityCashPatientWithDiscountDueAmountAndRefundBillWithDueSettlementTest", "This test case verify the Fornt Office Deposit3 Test Case");
		test.assignCategory("Front Office Billing");

		hisHomePage = new HISHomePage(driver);
		frontOfficeHomePage = new FrontOfficeHomePage(driver);
		patientRegistrationPage = new PatientRegistrationPage(driver);
		billingPage = new BillingPage(driver);
		depositPage = new DepositPage(driver);
		billsUtilityPage = new BillsUtilityPage(driver);
		approveRefundPage = new ApproveRefundPage(driver);

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
		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA-(POSH)");

		//		patientRegistrationPage.selectRateContractFromDropdownByName("STATE BANK OF INDIA - (CGHS)");
		//		patientRegistrationPage.checkSchemeCheckBox();
		//		patientRegistrationPage.selectSchemeFromDropdown(4);
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
		//		assertTrue(billingPage.isCashBillingNotAllowedMessageDisplayed(), "Cash Billing Not Allowed Message is not showing Up");
		try {
			billingPage.clickOnCloseButtonOnDocumentChecklistPopup();
		}
		catch (Exception e) {}
		//billingPage.clickClearButtonCompDetails();
		try {
			billingPage.cancelSchemeForPatientPopup();
		}
		catch (Exception e) {}
		billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		billingPage.closeCompanyDetailsPopup();
		try {
			billingPage.closeSchemeForPatientPopup();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			billingPage.closeRemarksPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		//		billingPage.selectSpecialityFromChooseSpecialityDropdown("Pathologist");
		//		billingPage.selectDoctorByNameAndVerifyIfPriceIsDefined("Megha");
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
		billingPage.enterDescriptionInManualSection("Testing");
		billingPage.selectQuantityInManualSection("5");
		billingPage.enterPriceInManualSection("10.30");
		billingPage.clickOnVerifyButton();
		billingPage.clickOnOtherServicesIcon();
		billingPage.checkChooseServicesCheckboxInOtherServicesSection();
		assertTrue(billingPage.verifyChooseServicesDropdownIsEnabled(), "Choose Services Dropdown is disabled");
		billingPage.selectAllServiceAndItemFromOtherServicesDropdown("Dialysis Procedures" , "AV Fistula Day Care Package With Anesthesia");
		billingPage.selectSpecialityAndDoctor("Anesthesiast", "Sunil Agarwal");
		billingPage.enterRefferedBy("Deepak Thakur");


		billingPage.selectFacilitatorFromDropdown(1);

		billingPage.clickOnInsuranceCompanyButton();
		try {
			billingPage.clickOnSaveButtonOnDocumentChecklistPopup();
		}
		catch (Exception e) {
		}
		billingPage.selectInsuranceCompRadioButtonOnCompDetailsPopup();


		try {
			billingPage.enterDetailsInCompDetailsPopupAndPressYesButton("Corporate", "STATE BANK OF INDIA", "OTHER", "STATE BANK OF INDIA - (CGHS)", "0", "50");
			billingPage.selectSchemeAuthorisedSchemeDetailsPopup("Automation Testing Scheme 2", "Management Decision", "Today Testing");
			billingPage.closeSchemeDetailsPopup();
		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			//assertTrue(billingPage.verifyInvestigationInstructionPopupIsPresent(), "Investigation Instruction Popup Is Not showing up");
			billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billingPage.enterBillingRemarks();

		///billingPage.clickOnAddToBillButton();
		///billingPage.enterReponseInInvestigationPopupAndClickOnAddButton("ggg");
		billingPage.checkDiscountCheckbox();
		billingPage.clickOnYesBtnUnderProvideDiscountPopup();
		billingPage.selectDiscountOnFromDropdown("On Items");
		billingPage.selecServiceNameFromPercentagePopupDropdown("Investigations");
		billingPage.selecItemDoctorNameFromDiscountPopupDropdown("17-Hydroxycorticosteroids, 24hrs Urine");
		billingPage.selectDiscountHeadFromDropdown("Automation Testing");
		billingPage.selectDiscountReasonFromDropdown("30% Automation Testing");
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		assertTrue(billingPage.isAuthorisedByErrorMessageDisplayed(), "Authorised By Error Message is NOT Displayed");
		billingPage.selectAuthorisedByFromDropdown("Management Decision");

		billingPage.selectOnPatientRadioButton();		
		billingPage.clickOnYesBtnPercentageProcessDiscountPopup();
		billingPage.clickOnBillingButtonOnHeader();
		billingPage.clickOnyesBtnOnGenrateBillPopup();
		billingPage.enterPatientPaidAmount("5000");
		billingPage.clickOnNewPaymentModeButton();
		billingPage.selectSecondPaymentMode("Debit Card");
		billingPage.enterPatientPaidAmountForSecondTransaction("7000");
		billingPage.enterCardDetailsAndSaveDetails("MASTERCARD", "123456789", "Andhra Bank", "2222222222");

		try {
			billingPage.selectAythorisedByInProcessPaymentPopupAndAddRemarks("Management Decision");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			billingPage.clickOnVerifyButtonOnProcessPaymentPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			billingPage.clickOnNoButtonOnBillGotGeneratedPopup();
		}
		catch (Exception e) {}
		//billingPage.clickOnNoButtonOnPrintOPDCard();
		frontOfficeHomePage.clickOnMenu();
		frontOfficeHomePage.clickOnBillingAndSelectAnOption("Bills Utility");
		billsUtilityPage. searchPatientDetails();
		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);
		billsUtilityPage.clickOnSaveButton();
		billsUtilityPage.clickOnSelectRefundButton();
		billsUtilityPage.selectAllServices();

		billsUtilityPage.closeRefundPopup();
		billsUtilityPage.selectDueSettlementTab();
		billsUtilityPage.enterAmountToBeSettled("1000");
		billsUtilityPage.selectPlusButton();
		billsUtilityPage.selectModeOfPayment("Credit Card");
		billsUtilityPage.enterCreditCardDetails();
		billsUtilityPage.selectPlusButton();	
		billsUtilityPage.clickMakeReceiptButton();
		billsUtilityPage.clickClearButton();
		billsUtilityPage. searchPatientDetails();
		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);
		billsUtilityPage.clickOnSelectRefundButton();
		billsUtilityPage.selectServices("Deepak Koshal");
		billsUtilityPage.selectServices("17-Hydroxycorticosteroids, 24hrs Urine");
		billsUtilityPage.selectServices("X-ray Both Leg Skyline");
		billsUtilityPage.enterUsernamePasswordAndSelectApproveButton("Deepak", "Test1234$");
		billsUtilityPage.selectReasonFromReasonDropdown("Automation Refund Reason");
		billsUtilityPage.enterRemarks();
		billsUtilityPage.clickOnSaveButton();
		try {
			billsUtilityPage.clickMakeReceiptButton();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		billsUtilityPage.clickYesButtonRefundByCashPopup();
		billsUtilityPage.clickClearButton();
		billsUtilityPage. searchPatientDetails();
		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);
		billsUtilityPage.clickOnSelectRefundButton();
		billsUtilityPage.selectAllServices();
		billsUtilityPage.enterUsernamePasswordAndSelectApproveButton("Deepak", "Test1234$");
		billsUtilityPage.selectReasonFromReasonDropdown("Automation Refund Reason");
		billsUtilityPage.selectModeOfPayment("Credit Card");
		billsUtilityPage.enterCreditCardDetails();
		try {
			billsUtilityPage.selectPlusButton();	
		}
		catch (Exception e) {}
		try {
			billsUtilityPage.clickMakeReceiptButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
		billsUtilityPage.clickClearButton();
		billsUtilityPage. searchPatientDetails();
		billsUtilityPage.selectRegisteredPatient(patientRegistrationId);
		billsUtilityPage.selectYesApprovalRequestPopup();
		billsUtilityPage.selectReasonFromReasonDropdown("Automation Refund Reason");
		billsUtilityPage.selectModeOfPaymentFromBillUtility("Cheque");
		billsUtilityPage.enterChequeDetails();
		billsUtilityPage.clickOnSaveButton();
		try {
			billsUtilityPage.clickOnSaveButton();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		billsUtilityPage.clickOnSelectRefundButton();
		billsUtilityPage.selectAllServices();
		billsUtilityPage.selectReasonFromReasonDropdown("Automation Refund Reason");
		billsUtilityPage.clickOnSaveButton();
		billsUtilityPage.clickYesButtonRefundByCashPopup();

	}
}
