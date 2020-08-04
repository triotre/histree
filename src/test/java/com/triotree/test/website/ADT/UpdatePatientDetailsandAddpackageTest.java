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
import com.triotree.website.pages.ADT.UpdatePatientDetailsandAddpackagePage;
import com.triotree.website.pages.CommonPages.HISHomePage;

@Listeners(ResultListener.class)
public class UpdatePatientDetailsandAddpackageTest extends TTWebsiteBaseTest
{
	private static final Logger logger = LogManager
			.getLogger(UpdatePatientDetailsandAddpackageTest.class.getName());

	private HISHomePage hisHomePage;
	private BedStatusPage bedstatusPage;
	private ADTHomePage adtpage;
	private IPDepositRefundformPage ipdepositrefund;
	private UpdatePatientDetailsandAddpackagePage updatedetail;

	@Test
	public void reEnterUHIDandupdatePatientdetailsandAddsomepackage() throws InterruptedException
	{
		test=extent.createTest("reEnterUHIDandupdatePatientdetailsandAddsomepackage", "This test case is verifies Patient Details and Add Some package");
		test.assignCategory("ADT reEnter UHID and update Patient details");
		hisHomePage = new HISHomePage(driver);
		adtpage=new ADTHomePage(driver);
		ipdepositrefund = new IPDepositRefundformPage(driver);
		bedstatusPage=new BedStatusPage(driver);
		updatedetail=new UpdatePatientDetailsandAddpackagePage(driver);

		hisHomePage.loginToTriotreeHIS();

		// Admit Patient Registration
		hisHomePage.clickOnADTIcon();
		ipdepositrefund.selectStationAndClickOnYes(test,"IT");
		ipdepositrefund.clickOnMenu();
		adtpage.clickOnAdmitPatientAndSelectAdmitPatient(test,"Admit Patient");
		updatedetail.enterIPNumber(test,"40934");
		updatedetail.clickonDependentADM(test);
		adtpage.validatepopuptext(test);


		updatedetail.enterIPNumber(test,"15726");
		adtpage.verifyDetailsFetch(test);
		updatedetail.clickonModifyButton();
		adtpage.verifyDetailsFetch(test);
		adtpage.selectTitleDropdown(test, "Ms.");
		updatedetail.clickonDependentADM(test);

		///Dependent_Admission popup window
		updatedetail.Simultaneouslytransferform();
		updatedetail.selectsex(test,"Male");
		updatedetail.enterFatherName(test,"Testing");
		updatedetail.selectDeliveryandBirthType(test,"Forceps Delivery","Live Birth");
		updatedetail.enterGestationalAge(test,"2");
		updatedetail.selectandfilledspecialityprimaryandReferring(test,"Cardiology","Anish  ","Anish");
		updatedetail.getvalueofFirstandLastName(test);
		updatedetail.clickoncancelbutton(test);

		//Validation of Name is updated 
		updatedetail.verifyandgetAdmitPatientUpdatedFirstandLastName(test);

		//Package Details tab Speciality
		adtpage.selectTab(test,"Package Details");
		updatedetail.clickonSelectedPackage(test);
		updatedetail.packageDetailSearch(test,"Akash package()");
		updatedetail.verifypackageDetails(test);
		updatedetail.clickonplusbuttonicon(test);
		updatedetail.verfiyAssignnewPackagePopup(test);
		updatedetail.clickonNewAssignNobutton(test);
		updatedetail.clickonplusbuttonicon(test);
		updatedetail.clickonNewAssignYesbutton(test);
		adtpage.validatepopuptext(test);
		updatedetail.clickonDeleteButtonIcon(test);
		updatedetail.verifyDeletePackagePopup(test);
		updatedetail.clickonDeletePackageNoButton(test);
		updatedetail.clickonDeleteButtonIcon(test);
		updatedetail.clickonDeletePackageYesButton(test);


	}

}
