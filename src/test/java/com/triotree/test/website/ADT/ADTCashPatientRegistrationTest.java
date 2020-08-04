package com.triotree.test.website.ADT;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.triotree.test.base.ResultListener;
import com.triotree.test.website.TTWebsiteBaseTest;
import com.triotree.test.website.InventroyModule.InventoryModuleTest;
import com.triotree.website.pages.ADT.ADTHomePage;
import com.triotree.website.pages.ADT.BedStatusPage;
import com.triotree.website.pages.ADT.IPDepositRefundformPage;
import com.triotree.website.pages.CommonPages.HISHomePage;
import com.triotree.website.pages.FrontOffice.BillingPage;
import com.triotree.website.pages.FrontOffice.FrontOfficeHomePage;
import com.triotree.website.pages.FrontOffice.IndentApprovalPage;
import com.triotree.website.pages.FrontOffice.IndentIssuePage;
import com.triotree.website.pages.FrontOffice.IndentItemsPage;
import com.triotree.website.pages.FrontOffice.PatientRegistrationPage;
import com.triotree.website.pages.FrontOffice.PurchaseRequisitionPage;
@Listeners(ResultListener.class)
public class ADTCashPatientRegistrationTest extends TTWebsiteBaseTest
{

	private static final Logger logger = LogManager
			.getLogger(ADTCashPatientRegistrationTest.class.getName());

	private HISHomePage hisHomePage;
	private ADTHomePage adtpage;
	private BedStatusPage bedstatusPage;
	private IPDepositRefundformPage ipdepositrefund;

	@Test
	public void RegistrationforminADTwithcashPatient() throws InterruptedException 
	{
		test=extent.createTest("RegistrationforminADTwithcashPatient", "This test case is verifies Registration form in ADT with cash Patient");
		test.assignCategory("Registration in ADT with cash Patient");
		hisHomePage = new HISHomePage(driver);
		adtpage=new ADTHomePage(driver);
		ipdepositrefund = new IPDepositRefundformPage(driver);
		bedstatusPage=new BedStatusPage(driver);
		
		hisHomePage.loginToTriotreeHIS();
		
		///////Create Bed 
		hisHomePage.clickOnIPMasterIcon();
		ipdepositrefund.selectStationAndClickOnYes(test,"IT");
		adtpage.clickOnIpMasterAndSelectAnBed("Bed");
		bedstatusPage.createbedInIpMaster();
		bedstatusPage.clickonsavebutton();
		bedstatusPage.clickonYesButton();
		ipdepositrefund.clickOnMenu();
		hisHomePage.clickOnHomeIcon();

		// Admit Patient Registration
		hisHomePage.clickOnADTIcon();
		ipdepositrefund.selectStationAndClickOnYes(test,"IT");
		ipdepositrefund.clickOnMenu();
		adtpage.clickOnAdmitPatientAndSelectAnOption("Bed Status");
		ipdepositrefund.getheading(test,"Bed Status");
		bedstatusPage.selectwarddropdown(test, "1st FLR T1 Transplant ICU","Vacant");
		bedstatusPage.checkbedstatus(test);
		ipdepositrefund.getheading(test,"Admit Patient");
		adtpage.clickOnVIPCheckBox(test,"VIP Test Data");
		adtpage.clickOnRemarkCheckBox(test,"Automation Remarks");
		adtpage.selectTitleDropdown(test,"Mr.");
		adtpage.EnterFirstName(test,"Testing");
		adtpage.EnterMiddelName(test,"Kumar");
		adtpage.EnterLastName(test,"Sharma");
		adtpage.SelectGenderDropDown(test,"Male");
		adtpage.EnterDOB(test,"@#$%^&*\":><");
		adtpage.EnterDOB(test,"15-12-1991");

		//adtpage.clickonPossibleAlert();
		adtpage.TimeofBirth(test,"06:15 PM");
		adtpage.ageRadioButton(test);
		adtpage.EnterAge(test,"17");
		adtpage.validatepopuptext(test);
		adtpage.EnterAge(test,"23");
		adtpage.selectAgeTypeDropdown(test,"Year(s)");
		//adtpage.clickonFatherRadioButton();
		adtpage.clickonFatherRadioButtonANDEnterFatherName(test,"Testing Father");
		adtpage.selectMaritalStatus(test,"Single");
		adtpage.EnterAddress(test,"Testing Address");
		adtpage.selectCity(test,"DELHI");
		adtpage.selectlocality(test,"GJGJGH");
		adtpage.enterPinNumber(test,"201001");
		adtpage.selectNRIcheckbox();
		adtpage.enterNationalId(test,"12345");
		adtpage.howdidyoucometoknowus(test,"News Paper");
		adtpage.selectNationality(test,"Indian");
		adtpage.clickonSaveButton();
		adtpage.validatepopuptext(test);
		adtpage.entermobilenumber(test,"1234567890");
		adtpage.selectoccuption(test,"Student");
		//adtpage.clickonSaveButton();
		adtpage.clickonpermanentaddresscheckbox();

		/////Consultant Tab
		adtpage.selectTab(test,"Consultant");
		adtpage.selectdoctorspeciality(test,"Cardiology");
		adtpage.selectAdmittingConsultant(test,"Scheudle  Testing");
		adtpage.selectPrimaryAttendingConsultant(test,"Scheudle  Testing");
		adtpage.enterrefferby(test," A.G.RAJAN");
		adtpage.enterexpectedlength(test,"5");
		adtpage.clickonSaveButton();
		adtpage.validatepopuptext(test);
		
		//////Bed & Payment Details Tab
		adtpage.selectTab(test,"Bed & Payment Details");
		adtpage.selectrequestedbedtype(test);
		adtpage.selectbillablebedtype(test);
		adtpage.selectallotedbedtype(test);
		adtpage.selectwardtype(test);
		adtpage.selectbedtype(test);

		///Package Details
		adtpage.selectTab(test,"Package Details");
		adtpage.selectpackagedetailsspeciality(test,"Cardiology");
		adtpage.selectdoctor(test,"MANNAT  DEVGAN");

		//Next of Kin Details
		adtpage.selectTab(test,"Next of Kin Details");
		adtpage.enterkinname(test,"Auto Name");
		adtpage.selectkinRelationship(test,"Mother");
		adtpage.clickonCopyfrompresentAddresscheckbox();
		adtpage.enteremergencyname("KIN FATHER");
		adtpage.enteremergencyphonenumber("1234567891011123");
		adtpage.enterbillingcounselling("AUTO NAME");
		adtpage.enterClinicalCounselling("Patient himself");
		adtpage.clickonSaveButton();
		adtpage.clickonacceptyes(test);
		adtpage.clickonprintbutton(test);	
	}

}
