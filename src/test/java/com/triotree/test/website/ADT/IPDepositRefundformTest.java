package com.triotree.test.website.ADT;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.triotree.test.base.ResultListener;
import com.triotree.test.website.TTWebsiteBaseTest;
import com.triotree.website.pages.ADT.IPDepositRefundformPage;
import com.triotree.website.pages.CommonPages.HISHomePage;

@Listeners(ResultListener.class)
public class IPDepositRefundformTest  extends TTWebsiteBaseTest
{

	private static final Logger logger = LogManager
			.getLogger(IPDepositRefundformTest.class.getName());

	private HISHomePage hisHomePage;
	private IPDepositRefundformPage ipdepositrefund;
	private String patientRegistrationId ="RAJH.17150458";

	@Test
	public void AdtIPDepositRefundformTest() throws InterruptedException 
	{
		test=extent.createTest("IPDepositRefundformTest", "This test case is verifies ADT IPDeposit Refund form Test");
		test.assignCategory("ADT IP Deposit Refund");

		hisHomePage = new HISHomePage(driver);
		ipdepositrefund=new IPDepositRefundformPage(driver);

		hisHomePage.loginToTriotreeHIS();
		hisHomePage.clickOnADTIcon();
		ipdepositrefund.selectStationAndClickOnYes(test,"IT");
		ipdepositrefund.clickOnMenu();
		ipdepositrefund.clickOnAdmitPatientAndSelectAnOption("IP Deposit/Refund");
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

		ipdepositrefund.searchUHIDFromSearchBoxOnHeader(patientRegistrationId);
		ipdepositrefund.validatepopuptext(test);
		ipdepositrefund.validatepatientuhid(test);
		ipdepositrefund.clickonclearbutton();

		ipdepositrefund.searchUHIDFromSearchBoxOnHeader("RAJH.17152257");
		ipdepositrefund.clickonSideOPButton(test);
		ipdepositrefund.enterTransferringAmount(test,"10");
		ipdepositrefund.clickonclearbutton();

		//Deposit Cash
		ipdepositrefund.enterIPNumber(test,"40102");
		ipdepositrefund.enterAmount(test,"0");
		ipdepositrefund.clickondepositbutton();
		ipdepositrefund.validatepopuptext(test);
		ipdepositrefund.enterAmount(test,"5");
		ipdepositrefund.clickondepositbutton();
		ipdepositrefund.clickonDeposityesbutton();
		ipdepositrefund.validatepopuptext(test);

		//Refund Cash Amount
		ipdepositrefund.clickonsiderefundbutton(test);
		ipdepositrefund.clickonRefundbutton(test,"5","anshul","Automation Remark");
		ipdepositrefund.clickonHeaderrefundbutton(test);
		ipdepositrefund.clickonRefundDeposit(test);
		ipdepositrefund.validatepopuptext(test);

		//receipt got selected
		ipdepositrefund.clickonclearbutton();
		ipdepositrefund.clickonReceiptUtility(test);
		ipdepositrefund.enterbilldetailsuhid("RAJH.17150458");
		ipdepositrefund.clickonbilldetailclearbutton();
		ipdepositrefund.clickonReceiptUtility(test);
		ipdepositrefund.enterbilldetailsIPNumber(test,"40102");
		ipdepositrefund.clickonPrintButton(test);
		ipdepositrefund.clickonRefershbutton();
		ipdepositrefund.enterRecepitNumber(test,"RHDI46457");
		ipdepositrefund.clickonPrintButton(test);
		ipdepositrefund.clickonBillDetailclosebutton();

		//Cheque in hand details
		ipdepositrefund.clickOnMenu();
		ipdepositrefund.clickOnIpDepositandRefund("Cheque In Hand Details");
		driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
		ipdepositrefund.getheading(test,"Cheque In Hand Details");
		ipdepositrefund.enterFromDate(test,"01/Jun/2020");
		ipdepositrefund.enterToDate(test,"15/Jun/2020");
		ipdepositrefund.clickoncheckInHandSearch();
		ipdepositrefund.verifycheckInHandDetails(test);
		ipdepositrefund.clickonCSVButton(test);

		//Select the from date greater then to date
		ipdepositrefund.enterFromDate(test,"16/Jun/2020");
		ipdepositrefund.enterToDate(test,"15/Jun/2020");
		ipdepositrefund.clickoncheckInHandSearch();
		ipdepositrefund.validatepopuptext(test);
	}
}
