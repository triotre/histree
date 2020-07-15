package com.triotree.website.Physician;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.triotree.test.base.ResultListener;
import com.triotree.test.website.TTWebsiteBaseTest;
import com.triotree.test.website.ADT.ADTCashPatientRegistrationTest;
import com.triotree.website.pages.ADT.ADTHomePage;
import com.triotree.website.pages.ADT.IPDepositRefundformPage;
import com.triotree.website.pages.ADT.SurgeryMedicalEstimatePage;
import com.triotree.website.pages.CommonPages.HISHomePage;
import com.triotree.website.pages.Physician.PhysicianOPDcaseSheetOrders;
@Listeners(ResultListener.class)
public class PhysicianOPDCaseSheet extends TTWebsiteBaseTest
{
	private static final Logger logger = LogManager
			.getLogger(PhysicianOPDCaseSheet.class.getName());

	private HISHomePage hisHomePage;
	private PhysicianOPDcaseSheetOrders opdorder;


	@Test
	public void PhysicianOPDcaseSheetOrdersTest() throws InterruptedException 
	{
		test=extent.createTest("PhysicianOPDcaseSheetOrdersTest", "This test case is verifies Physician OPD case Sheet Orders Test");
		test.assignCategory("PhysicianOPD");
		hisHomePage = new HISHomePage(driver);
		opdorder=new PhysicianOPDcaseSheetOrders(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickonPhysicianIcon();
		opdorder.selectStationAndClickOnYes(test, "1st FLR T1 Transplant ICU");
		opdorder.getHeading(test);
		opdorder.clickonOutPatient(test);
		opdorder.verifyselectedDoctorName(test,"Geena  Jacob ");
		opdorder.verifyselectedView(test);
		opdorder.enterFromDate(test,"10/Feb/2020");
		opdorder.clickonSearchButton(test);
		opdorder.clickonPatient(test);
		opdorder.ClickandAddDiagnosis("Testing data");

		opdorder.clickonOrder(test);
		opdorder.getHeading(test);
		opdorder.verifyselectedTab(test);
		opdorder.verifyreflectedservices(test,"ababa");
		opdorder.clickandverifyservices(test, "ababa", "Blood Routine Examination ( CBC With ESR )");
		opdorder.clickandverifyservices(test, "ababa", "USG - Abdomen And Pelvis");
		opdorder.clickandverifyservices(test, "ababa", "Echo Cardiogram");
		opdorder.clickonSaveOrder(test);
	}

}
