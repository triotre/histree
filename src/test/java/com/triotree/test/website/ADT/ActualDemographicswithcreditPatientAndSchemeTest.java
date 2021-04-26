package com.triotree.test.website.ADT;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.triotree.test.base.ResultListener;
import com.triotree.test.website.TTWebsiteBaseTest;
import com.triotree.utils.PropertyFile;
import com.triotree.website.pages.ADT.ADTHomePage;
import com.triotree.website.pages.ADT.BedStatusPage;
import com.triotree.website.pages.ADT.IPDepositRefundformPage;
import com.triotree.website.pages.CommonPages.HISHomePage;


@Listeners(ResultListener.class)
public class ActualDemographicswithcreditPatientAndSchemeTest extends TTWebsiteBaseTest
{
	private static final Logger logger = LogManager
			.getLogger(ActualDemographicswithcreditPatientAndSchemeTest.class.getName());

	private HISHomePage hisHomePage;
	private BedStatusPage bedstatusPage;
	private ADTHomePage adtpage;
	private IPDepositRefundformPage ipdepositrefund;
	
	
	@Test
	public void actualDemographicswithcreditPatientAndScheme() throws Exception 
	{
		test=extent.createTest("ActualDemographicswithcreditPatientAndScheme", "This test case is verifies Actual Demographics with credit Patient And Scheme");
		test.assignCategory("ADT Actual Demographics with credit Patient and Scheme");
		hisHomePage = new HISHomePage(driver);
		adtpage=new ADTHomePage(driver);
		ipdepositrefund = new IPDepositRefundformPage(driver);
		bedstatusPage=new BedStatusPage(driver);
		
		String Company_Type=PropertyFile.getproperty("ADT","Company_Type");
		String Company=PropertyFile.getproperty("ADT","Company");
		String Rate_Contract=PropertyFile.getproperty("ADT","Rate_Contract");
		String Doctor=PropertyFile.getproperty("ADT", "Doctor");
		String Speciality= PropertyFile.getproperty("ADT", "Speciality");
		
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
		adtpage.selectdoctorspeciality(test,Speciality);
		adtpage.selectAdmittingConsultant(test,Doctor);
		adtpage.selectPrimaryAttendingConsultant(test,Doctor);
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
		
		/// Scheme company type and company
		adtpage.companyInsuranceDetails(test,Company_Type,Company, Rate_Contract);
		adtpage.enterauthorizationNumber(test, "123456");
		adtpage.enterCreditLimit(test, "1");
		adtpage.clickonschemecheckbox();
		adtpage.selectscheme("Rajagiri-Staff Dependent");


		///Package Details
		adtpage.selectTab(test,"Package Details");
		adtpage.selectpackagedetailsspeciality(test,Speciality);
		adtpage.selectdoctor(test,Doctor);

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
		adtpage.getUHIDandIP(test);
		adtpage.clickonprintbutton(test);
		
	}
	
	
}
