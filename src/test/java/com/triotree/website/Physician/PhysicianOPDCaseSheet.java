package com.triotree.website.Physician;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.triotree.test.website.TTWebsiteBaseTest;
import com.triotree.test.website.ADT.ADTCashPatientRegistrationTest;
import com.triotree.website.pages.ADT.ADTHomePage;
import com.triotree.website.pages.ADT.IPDepositRefundformPage;
import com.triotree.website.pages.ADT.SurgeryMedicalEstimatePage;
import com.triotree.website.pages.CommonPages.HISHomePage;
import com.triotree.website.pages.Physician.PhysicianOPDcaseSheetOrders;

public class PhysicianOPDCaseSheet extends TTWebsiteBaseTest
{
	private static final Logger logger = LogManager
			.getLogger(ADTCashPatientRegistrationTest.class.getName());

	private HISHomePage hisHomePage;
	private PhysicianOPDcaseSheetOrders opdorder;


	@Test
	public void PhysicianOPDcaseSheetOrdersTest() throws InterruptedException 
	{
		test=extent.createTest("PhysicianOPDcaseSheetOrdersTest", "This test case is verifies Surgery Medical Estimate Test");
		test.assignCategory("PhysicianOPD");
		hisHomePage = new HISHomePage(driver);
		opdorder=new PhysicianOPDcaseSheetOrders(driver);
		
		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickonPhysicianIcon();
		opdorder.selectStationAndClickOnYes(test, "1st FLR T1 Transplant ICU");
		opdorder.getHeading();
		opdorder.clickonOutPatient();
		opdorder.verifyselectedDoctorName();
		opdorder.verifyselectedView();
		opdorder.enterFromDate("10/Feb/2020");
		opdorder.clickonSearchButton();
		opdorder.clickonPatient();
		opdorder.clickonOrder();
		opdorder.getHeading();
		opdorder.verifyselectedTab();
		opdorder.verifyreflectedservices();
	}

}
