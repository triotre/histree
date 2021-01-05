package com.triotree.test.website.ADT;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.triotree.test.base.ResultListener;
import com.triotree.test.website.TTWebsiteBaseTest;
import com.triotree.website.pages.ADT.ADTHomePage;
import com.triotree.website.pages.ADT.IPDepositRefundformPage;
import com.triotree.website.pages.ADT.SurgeryMedicalEstimatePage;
import com.triotree.website.pages.CommonPages.HISHomePage;

@Listeners(ResultListener.class)
public class SurgeryMedicalEstimate extends TTWebsiteBaseTest
{
	private static final Logger logger = LogManager
			.getLogger(SurgeryMedicalEstimate.class.getName());

	private HISHomePage hisHomePage;
	private ADTHomePage adtpage;
	private IPDepositRefundformPage ipdepositrefund;
	private SurgeryMedicalEstimatePage medical;


	@Test
	public void surgeryMedicalEstimateTest() throws InterruptedException 
	{
		test=extent.createTest("SurgeryMedicalEstimateTest", "This test case is verifies Surgery Medical Estimate Test");
		test.assignCategory("ADT Surgery Medical Estimate");
		hisHomePage = new HISHomePage(driver);
		adtpage=new ADTHomePage(driver);
		ipdepositrefund = new IPDepositRefundformPage(driver);
		medical= new SurgeryMedicalEstimatePage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnADTIcon();
		ipdepositrefund.selectStationAndClickOnYes(test,"IT");
		ipdepositrefund.clickOnMenu();
		adtpage.clickOnAdmitPatientAndSelectAdmitPatient(test,"Surgery / Medical Estimate");
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		medical.enterUhid(test,"RAJH.16070980");
		medical.clickonMedicalRadioButton(test);
		medical.selectRequestedBedType(test,"General Ward");
		medical.checkTotalNoOfIPDays(test);
		medical.enterICUDays(test,"3");
		medical.enterRequiredWardDays(test,"2");
		medical.enterExpectedDateofAdmission(test,"10-07-2020");
		medical.selectBedType(test,"Twin Bed");
		medical.enterWardDays(test,"3");
		medical.selectBedType2(test,"Single Non-AC");
		medical.enterWardDays2(test,"2");
		medical.enterDiagnosisProblem(test,"Typhoid");
		medical.selectPrimaryAttendingSpeciality(test,"Dermatology");
		medical.enterVisitsDays(test,"7");
		medical.selectCospecility(test,"Dermatology");
		medical.selectCoConsultant(test);
		medical.enterCOVisitsDays(test,"2");
		medical.selectSecondarySpeciality(test,"Endocrinology");
		medical.enterSecondaryVisitsDays(test,"3");
		medical.checkCashRadioButton(test);
		medical.selectReferredBy(test," AJITHA");
		medical.enterBillingCounsellingdoneto(test,"Demo person");
		medical.enterEmergencyContacts(test,"9876543212");
		medical.checkAsperActual(test);
		medical.enterTransfusionMedicine(test,"5000");
		medical.enterEquipmentCharges(test,"4500");
		medical.enterNumberofReferralDoctorVisits(test,"4");
		medical.enterCostPerVisit(test,"400");
		medical.enterImplants(test,"Demo  stent");
		medical.enterImplantsAmount(test,"7500");
		medical.checkPharmICUDays(test);
		medical.enterAmountPerDay(test,"6000");
		medical.enterOtherItem1(test,"Testing item 1");
		medical.enterOtherItem1Amount(test,"450");
		medical.clickonAddOtherItemButton(test);
		medical.selectService(test,"Cardiology Services");
		medical.selectItem(test);
		medical.enterQty(test,"3");
		medical.clickonAddServiceIteam(test);
		medical.clickonCalculatesurgery(test);
		medical.clickonSaveButton(test);
		medical.clickonSaveEstimation(test);
		medical.clickonSaveSuccessfully(test);
		
	}
}