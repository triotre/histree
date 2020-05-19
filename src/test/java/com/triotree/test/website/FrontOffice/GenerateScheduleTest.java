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
public class GenerateScheduleTest extends TTWebsiteBaseTest{

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


		@Test(priority=1)//fixed 03-April-2020
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
	@Test(priority = 2) //fixed 03-April-2020
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

	@Test(priority=3)//fixed 03-April-2020
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

	@Test(priority=4)//fixed 03-April-2020
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
	@Test(priority = 5)
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
	@Test(priority = 6)
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

	@Test(priority = 7)
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
	@Test(priority = 8)
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


}
