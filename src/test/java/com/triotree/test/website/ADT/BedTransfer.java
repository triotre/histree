package com.triotree.test.website.ADT;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.triotree.test.base.ResultListener;
import com.triotree.test.website.TTWebsiteBaseTest;
import com.triotree.website.pages.ADT.ADTHomePage;
import com.triotree.website.pages.ADT.BedStatusPage;
import com.triotree.website.pages.ADT.IPDepositRefundformPage;
import com.triotree.website.pages.CommonPages.HISHomePage;
@Listeners(ResultListener.class)
public class BedTransfer  extends TTWebsiteBaseTest
{
	private static final Logger logger = LogManager
			.getLogger(ADTCashPatientRegistrationTest.class.getName());

	private HISHomePage hisHomePage;
	private BedStatusPage bedstatusPage;
	private ADTHomePage adtpage;
	private IPDepositRefundformPage ipdepositrefund;

	
	@Test
	public void patientBedTranferTest() throws InterruptedException 
	{
		test=extent.createTest("patientBedTranferTest", "This test case is verifies Patient Bed Tranfer Test");
		test.assignCategory("ADT");
		hisHomePage = new HISHomePage(driver);
		adtpage=new ADTHomePage(driver);
		ipdepositrefund = new IPDepositRefundformPage(driver);
		bedstatusPage=new BedStatusPage(driver);
		
		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnADTIcon();
		ipdepositrefund.selectStationAndClickOnYes(test,"IT");
		ipdepositrefund.clickOnMenu();
		ipdepositrefund.clickOnBedTransferAndSelectAnOption("Bed Transfer");
		bedstatusPage.clickonPendingTransferRequest(test);
		bedstatusPage.checkandselectOccupiedBed_Bed(test);
		bedstatusPage.selectOccupiedBedward(test);
		bedstatusPage.clickonPackageandBillingcontinue(test);
		///adtpage.validatepopuptext(test);

	}

}
