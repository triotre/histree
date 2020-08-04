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
import com.triotree.website.pages.ADT.UpdateAdmissionDate;
import com.triotree.website.pages.CommonPages.HISHomePage;

@Listeners(ResultListener.class)
public class UpdateAdmisssionDateTest extends TTWebsiteBaseTest
{

	private static final Logger logger = LogManager
			.getLogger(UpdateAdmisssionDateTest.class.getName());

	private HISHomePage hisHomePage;
	private BedStatusPage bedstatusPage;
	private ADTHomePage adtpage;
	private IPDepositRefundformPage ipdepositrefund;
	private UpdateAdmissionDate update;
	
	@Test
	public void updateadmissiondatetestcase() throws InterruptedException 
	{
		test=extent.createTest("UpdateAdmisssionDateTest", "This test case is verifies update admission date test case");
		test.assignCategory("ADT Update Admission Date");
		hisHomePage = new HISHomePage(driver);
		adtpage=new ADTHomePage(driver);
		ipdepositrefund = new IPDepositRefundformPage(driver);
		bedstatusPage=new BedStatusPage(driver);
		update=new UpdateAdmissionDate(driver);
		hisHomePage.loginToTriotreeHIS();
		
		hisHomePage.clickOnADTIcon();
		ipdepositrefund.selectStationAndClickOnYes(test,"IT");
		ipdepositrefund.clickOnMenu();
		update.clickOnAdmitPatientAndSelectAdmitPatient(test,"Update Admission Date");
		update.enterIPnumber(test,"15727");
		update.clickonAdmissionDateRadioButton(test);
		update.checkNewAdmissionDateField(test,"10-05-2020  4:15:00 PM");
		
		
		///Enter previous day discharged ip no.
		update.clickonclearbutton();
		update.enterIPnumber(test,"15729");
		adtpage.validatepopuptext(test);
		update.selectNewDischargeType(test,"LAMA");
		try {
			adtpage.validatepopuptext(test);
		}
		catch (Exception e) {}
		update.clickonSaveButton();
		adtpage.validatepopuptext(test);
		
		//Enter clinically discharged ip no. of same day
		update.clickonclearbutton();
		update.enterIPnumber(test,"15729");
		adtpage.validatepopuptext(test);
		update.selectNewDischargeType(test,"LAMA");
		try {
			adtpage.validatepopuptext(test);
		}
		catch (Exception e) {}
		update.clickonSaveButton();
		adtpage.validatepopuptext(test);

		///Expired
		update.selectNewDischargeType(test,"Expired");
		try {
			adtpage.validatepopuptext(test);
		}
		catch (Exception e) {}
		update.clickonSaveButton();
		adtpage.validatepopuptext(test);
		
	}

}
