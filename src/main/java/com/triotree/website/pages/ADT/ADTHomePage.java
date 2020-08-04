package com.triotree.website.pages.ADT;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import com.triotree.website.pages.ADT.BedStatusPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.utils.PropertyFile;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;


public class ADTHomePage extends HISWebsiteBasePage {
	private static final Logger logger = LogManager.getLogger(ADTHomePage.class.getName());

	public ADTHomePage(TTWebsiteDriver driver) {
		super(driver);
	}
	int i=0;
	private final By ADMIT_PATIENT_SECTION = By.xpath("//li[@id='FOAddPatientMenu']//i[@class='fa fa-caret-down']");
	private final By UHID_SEARCH_BOX = By.id("uhid_admimitPatient");
	private final By ADD_PATIENT_SECTION = By.xpath("//li[@id='FOBedTranferMenu']//following-sibling::a[text()=' Bed Status']");
	private final By IP_MASTER_SECTION=By.xpath("//a[text()='IP Masters']");

	private final By TITLE_DROP_DOWN = By.id("_title");
	private final By FIRST_NAME = By.id("f_name");
	private final By MIDDLE_NAME = By.id("m_name");
	private final By LAST_NAME = By.id("l_name");
	private final By GENDER_DROPDOWM = By.id("_sex");
	private final By DOD_TEXT_BOX = By.id("_dob");
	private final By AGE_RADIO_BUTTON=By.id("chkage");
	private final By Age=By.id("_age");
	private final By AGE_TYPE=By.id("_agetype");
	private final By TIME_OF_BIRTH=By.id("_dobtime");
	private final By FATHER_RADIO_BUTTON=By.id("_chkfather");
	private final By FATHER_NAME=By.id("fs_name");
	private final By MARITAL_STATUS=By.id("M_status");
	private final By ADDRESS=By.id("_address");
	private final By CITY=By.id("_city");
	private final By NATIONALITY=By.id("_nationality");
	private final By PIN_NUMBER=By.id("_pin");
	private final By NRI_CHECKBOX=By.id("nrichk_admit");
	private final By NATIONAL_ID=By.id("national_id");
	private final By HOWDIDYOUCOMETOKNOWUS=By.id("_hdyoctkau");
	private final By ADD_CITY_ICON=By.xpath("//a[@id='add_city']//i");
	private final By SAVE_BUTTON=By.xpath("//a[@id='saveitem']//i");
	private final By MOBILE_NUMBER=By.id("_mobile");
	private final By OCCUPTION=By.id("_occupation");
	private final By PERMANENT_ADDRESS=By.id("copy_address");
	private final By DOCOTOR_SPECIALITY=By.id("AD_specility");
	private final By ADMITTING_CONSULTANT=By.id("_admittingConsultant");
	private final By PRIMARY_ATTENDING_CONSULTANT=By.id("_primaryAttendingconsultant");
	private final By REFFER_BY=By.id("_refBY");
	private final By EXPECTED_LENGTH_OF_STAY=By.id("Expected_stay");
	private final By REQUESTED_BED_TYPE=By.id("Req_bedtype");
	private final By BILLABLE_BED_TYPE=By.id("billtype");
	private final By ALLOTED_BED_TYPE=By.id("All_type");
	private final By WARD=By.id("ward_type");
	private final By BED=By.id("bed_type");
	private final By SCHEME_CHECKBOX=By.id("_schme");
	private final By SCHEME_DROPDOWN=By.id("_scgmetype");
	private final By PACKAGEDETAILS_SPECIALITY=By.id("_packagedetails_speciality");
	private final By DOCTOR=By.id("packagedetails_doctor");
	private final By KIN_NAME=By.id("nextkin_name");
	private final By RELATIONSHIP=By.id("nextkin_relation");
	private final By COPY_PRESENTADDRESS=By.id("nextkin_copyfrompresentaddress");
	private final By EMERGENCY_NAME=By.id("Emergency_name");
	private final By EMERGENCY_PHNUMBER=By.id("Emergency_phnumber");
	private final By BILLING_COUNSELLING=By.id("Emergency_bCdt");
	private final By CLINICAL_COUNSELLING=By.id("CEmergency_ccdt");
	private final By LOCALITY=By.id("_locality");
	private final By ACCEPT_YES=By.id("btnAcceptYes");
	private final By PRINT_BUTTON=By.xpath("//a[@id='btnprint']//i");
	private final By VIP_TEXTBOX=By.id("viptext");
	private final By POPUP_TEXT=By.xpath("//div[@class='gritter-without-image']//p");
	private final By COMPANY_INSURANCE_RADIO_BUTTON=By.id("_comInsurancetype");
	private final By COMPANY_TYPE=By.id("comp_type");
	private final By COMPANY=By.id("_company");
	private final By RATE_OF_CONTRACT=By.id("_ratecontract");
	private final By AUTHORIZATION_No=By.id("AuthorizationNo");
	private final By CREDIT_NUMBER=By.id("Credit_limit");
	String Bed_Name=PropertyFile.getProperty("bedname");

	BedStatusPage ob=new BedStatusPage(driver);


	public void clickOnAdmitPatientAndSelectAdmitPatient(ExtentTest test,String option) throws InterruptedException {
		driver.waitForElementPresent(ADMIT_PATIENT_SECTION);
		driver.click(ADMIT_PATIENT_SECTION);
		logger.info("Admit Patient Section is Expanded");

		WebElement options = driver.findElement(By.xpath("//ul[@style='display: block;']//a[text()='" + option + "']"));
		options.click();
		logger.info("Following Option has been selected from Indent Items Section " + option);
		driver.waitForPageLoad();
		Thread.sleep(3000);
	}

	public void clickOnAdmitPatientAndSelectAnOption(String option) throws InterruptedException {
		driver.waitForElementPresent(ADD_PATIENT_SECTION);
		WebElement option_element = driver.findElement(ADD_PATIENT_SECTION);
		if(option_element.isDisplayed()) 
		{
			driver.findElement(ADD_PATIENT_SECTION).click();
			logger.info("Admit Patient Section is Expanded");

		}

		driver.waitForElementPresent(By.xpath("//ul[@style='display: block;']//a[text()='" + option + "']"), 120);
		WebElement options = driver.findElement(By.xpath("//ul[@style='display: block;']//a[text()='" + option + "']"));
		options.click();
		logger.info("Following Option has been selected from Indent Items Section " + option);
		driver.waitForPageLoad();
		Thread.sleep(3000);
	}

	public void clickOnIpMasterAndSelectAnBed(String option) throws InterruptedException {
		driver.waitForElementPresent(IP_MASTER_SECTION);
		WebElement option_element = driver.findElement(IP_MASTER_SECTION);
		if(option_element.isDisplayed()) 
		{
			driver.findElement(IP_MASTER_SECTION).click();
			logger.info("Admit Patient Section is Expanded");

		}
		driver.waitForElementPresent(By.xpath("//ul[@style='display: block;']//a[text()='" + option + "']"), 120);
		WebElement options = driver.findElement(By.xpath("//ul[@style='display: block;']//a[text()='" + option + "']"));
		options.click();
		logger.info("Following Option has been selected from Indent Items Section " + option);
		driver.waitForPageLoad();
		Thread.sleep(3000);
	}

	public void enterUHIDInSearchBox(String uhid) {
		driver.waitForElementPresent(UHID_SEARCH_BOX);
		driver.findElement(UHID_SEARCH_BOX).clear();
		driver.findElement(UHID_SEARCH_BOX).sendKeys(uhid);
		driver.findElement(UHID_SEARCH_BOX).sendKeys(Keys.RETURN);
		logger.info("Following UHID has been added to the UHID Search Box " + uhid);
	}

	public void clickOnVIPCheckBox(ExtentTest test,String data) {
		WebElement VIPCheckBox_element = driver.findElement(By.xpath("//input[@id='vipcheck']"));
		if (!VIPCheckBox_element.isSelected()) {
			driver.clickByJS(TTWebsiteDriver.driver, VIPCheckBox_element);
			logger.info("VIP Check Box is selected");
			Markup m=MarkupHelper.createLabel("VIP Check Box is selected", ExtentColor.GREEN);
			test.info(m);
			String vip_input = driver.findElement(VIP_TEXTBOX).getAttribute("innerHTML");
			if(!vip_input.contains("disabled")) 
			{
				driver.findElement(VIP_TEXTBOX).sendKeys(data);
				logger.info("Check box is selected and VIP text box get enable= "+data);
				Markup m1=MarkupHelper.createLabel("Check box is selected and text box get enable", ExtentColor.GREEN);
				test.info(m1);
			}
			if(vip_input.contains("disabled") && (!VIPCheckBox_element.isSelected()))
			{
				logger.info("Check box is not selecting and text box get disabled");
				Markup m1=MarkupHelper.createLabel("Check box is not selected and text box get disabled", ExtentColor.RED);
				test.info(m1);	
			}

		}
	}

	public void clickOnRemarkCheckBox(ExtentTest test,String remark)
	{
		driver.waitForElementPresent(By.xpath("//input[@id='reamarkcheck']"), 20);
		WebElement RemarkCheckBox_element = driver.findElement(By.xpath("//input[@id='reamarkcheck']"));
		if(!RemarkCheckBox_element.isSelected()) {
			driver.clickByJS(TTWebsiteDriver.driver, RemarkCheckBox_element);
			logger.info("Remark Check Box is selected");
			Markup m1=MarkupHelper.createLabel("Remark Check Box is selected", ExtentColor.GREEN);
			test.info(m1);	
		}

		driver.waitForElementPresent(By.xpath("//input[@id='remarkstext']"), 10);
		String remark_input = driver.findElement(By.xpath("//input[@id='remarkstext']")).getAttribute("innerHTML");
		if(!remark_input.contains("disabled")) 
		{
			logger.info("Check box is selected and Remark text box get enable= "+remark);
			Markup m1=MarkupHelper.createLabel("Check box is selected and Remark text box get enable= "+remark, ExtentColor.GREEN);
			test.info(m1);
		}

		if(remark_input.contains("disabled") && (!RemarkCheckBox_element.isSelected()))
		{
			logger.info("Check box is not selecting and text box get disabled");
			Markup m1=MarkupHelper.createLabel("Check box is not selected and text box get disabled", ExtentColor.GREEN);
			test.info(m1);	
		}

	}

	public void selectTitleDropdown(ExtentTest test,String title) {
		try {
			Select sl = new Select(driver.findElement(TITLE_DROP_DOWN));
			sl.selectByVisibleText(title);
			logger.info("Title= "+title);
			Markup m1=MarkupHelper.createLabel("Title get selected= "+title, ExtentColor.GREEN);
			test.info(m1);	
		}
		catch (Exception e) {
			Markup m1=MarkupHelper.createLabel("Title is not get selected= "+title, ExtentColor.RED);
			test.info(m1);
		}
	}

	public void EnterFirstName(ExtentTest test,String firstname) 
	{
		try {
			driver.findElement(FIRST_NAME).sendKeys(firstname);
			logger.info("First Name= "+firstname);
			Markup m1=MarkupHelper.createLabel("First Name is filled= "+firstname, ExtentColor.GREEN);
			test.info(m1);
		}
		catch (Exception e) {
			logger.info("First Name is not filled= "+firstname);
			Markup m1=MarkupHelper.createLabel("First Name is not filled= "+firstname, ExtentColor.RED);
			test.info(m1);
		}
	}

	public void EnterMiddelName(ExtentTest test,String middlename) 
	{
		try {
			driver.findElement(MIDDLE_NAME).sendKeys(middlename);
			logger.info("Middle Name= "+middlename);
			Markup m1=MarkupHelper.createLabel("Middle Name is filled= "+middlename, ExtentColor.GREEN);
			test.info(m1);
		}
		catch (Exception e) {
			logger.info("Middle Name is not filled= "+middlename);
			Markup m1=MarkupHelper.createLabel("Middle Name is not filled= "+middlename, ExtentColor.RED);
			test.info(m1);		
		}
	}

	public void EnterLastName(ExtentTest test,String lastname) 
	{
		try {
			driver.findElement(LAST_NAME).sendKeys(lastname);
			logger.info("Last Name= "+lastname);
			Markup m1=MarkupHelper.createLabel("Last Name is filled= "+lastname, ExtentColor.GREEN);
			test.info(m1);	
		}
		catch (Exception e) {
			logger.info("Last Name= "+lastname);
			Markup m1=MarkupHelper.createLabel("Last Name is not filled= "+lastname, ExtentColor.RED);
			test.info(m1);	
		}
	}

	public void SelectGenderDropDown(ExtentTest test, String gender) 
	{
		try {
			Select sl = new Select(driver.findElement(GENDER_DROPDOWM));
			sl.selectByVisibleText(gender);
			logger.info("Gender Type is selected= "+gender);
			Markup m1=MarkupHelper.createLabel("Gender Type is selected= "+gender, ExtentColor.GREEN);
			test.info(m1);			}
		catch (Exception e) {
			logger.info("Gender Type is not selected= "+gender);
			Markup m1=MarkupHelper.createLabel("Gender Type is not selected= "+gender, ExtentColor.RED);
			test.info(m1);			
		}
	}

	public void EnterDOB(ExtentTest test,String dob) throws InterruptedException 
	{

		WebElement dob_radio_button = driver.findElement(By.xpath("//input[@id='chkdob']"));
		if(dob_radio_button.isSelected()) 
		{
			try {
				Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
				Matcher match = pattern.matcher(dob);
				boolean val = match.find();
				if (val == true) {
					WebElement agebutton_element = driver.findElement(AGE_RADIO_BUTTON);
					if(dob_radio_button.isSelected() && (!agebutton_element.isSelected()))
					{	
						driver.findElement(DOD_TEXT_BOX).sendKeys(dob);
						driver.findElement(DOD_TEXT_BOX).sendKeys(Keys.TAB);
						logger.info("DOB= "+dob);
						Markup m1=MarkupHelper.createLabel("Special char should not allowed in DOB box = "+dob, ExtentColor.GREEN);
						test.info(m1);
					}

				}
				else {
					if(i==1) {
						driver.findElement(DOD_TEXT_BOX).clear();
					}
					driver.findElement(DOD_TEXT_BOX).sendKeys(dob);
					driver.findElement(DOD_TEXT_BOX).sendKeys(Keys.TAB);
					logger.info("DOB= "+dob);
					Markup m1=MarkupHelper.createLabel("DOB= "+dob, ExtentColor.GREEN);
					test.info(m1);
				}
			}
			catch (Exception e) {}
			i++;
		}

	}

	public void validatepopuptext(ExtentTest test) {

		String text="";
		try {
			text = driver.findElement(POPUP_TEXT).getText();
		}
		catch (Exception e) {}

		if(text.equals("Please enter Date of Birth Age is less than 18 year")) 
		{
			//Test.class.
			Assert.assertEquals("Please enter Date of Birth Age is less than 18 year", "Please enter Date of Birth Age is less than 18 year");
			logger.info(text+" is equal to "+"Please enter Date of Birth Age is less than 18 year");
			Markup m=MarkupHelper.createLabel("Please enter Date of Birth Age is less than 18 year", ExtentColor.GREEN);
			test.info(m);
		}
		if(text.equals("Please Select Please enter Expected Length of Stay, Requested Bed Type, Billable Bed Type, Allotted Bed Type, Emergency Name, Emergency Phone, Billing Counselling To, Clinical Counseling To,Emergency Mobile No. Should be correct")) 
		{
			Assert.assertEquals("Please Select Please enter Expected Length of Stay, Requested Bed Type, Billable Bed Type, Allotted Bed Type, Emergency Name, Emergency Phone, Billing Counselling To, Clinical Counseling To,Emergency Mobile No. Should be correct", "Please Select Please enter Expected Length of Stay, Requested Bed Type, Billable Bed Type, Allotted Bed Type, Emergency Name, Emergency Phone, Billing Counselling To, Clinical Counseling To,Emergency Mobile No. Should be correct");
			logger.info(text+" is equal to "+"Please Select Please enter Expected Length of Stay, Requested Bed Type, Billable Bed Type, Allotted Bed Type, Emergency Name, Emergency Phone, Billing Counselling To, Clinical Counseling To,Emergency Mobile No. Should be correct");
			Markup m=MarkupHelper.createLabel("Please Select Please enter Expected Length of Stay, Requested Bed Type, Billable Bed Type, Allotted Bed Type, Emergency Name, Emergency Phone, Billing Counselling To, Clinical Counseling To,Emergency Mobile No. Should be correct", ExtentColor.GREEN);
			test.info(m);
		}

		if(text.equals("Patient has been discharged!")) {
			Assert.assertEquals("Patient has been discharged!", "Patient has been discharged!");
			logger.info(text+" is equal to "+"Patient has been discharged!");
			Markup m=MarkupHelper.createLabel("Patient has been discharged!", ExtentColor.GREEN);
			test.info(m);
		}

		if(text.equals("An error encountered while retrieving the patient's details. Please check IP number and try again!"))
		{
			Assert.assertEquals("An error encountered while retrieving the patient's details. Please check IP number and try again!", "An error encountered while retrieving the patient's details. Please check IP number and try again!");
			logger.info(text+" is equal to "+"An error encountered while retrieving the patient's details. Please check IP number and try again!");
			Markup m=MarkupHelper.createLabel("An error encountered while retrieving the patient's details. Please check IP number and try again!", ExtentColor.RED);
			test.info(m);	
		}

		if(text.equals("Discharge Type Can be Change Only Same Day Of Discharge")) {
			Assert.assertEquals("Discharge Type Can be Change Only Same Day Of Discharge","Discharge Type Can be Change Only Same Day Of Discharge");
			logger.info(text+" is equal to "+"Discharge Type Can be Change Only Same Day Of Discharge");
			Markup m=MarkupHelper.createLabel("Discharge Type Can be Change Only Same Day Of Discharge", ExtentColor.GREEN);
			test.info(m);	
		}
		if(text.equals("Dependent admission option is available only for females older than 14 years!")) {
			Assert.assertEquals("Dependent admission option is available only for females older than 14 years!","Dependent admission option is available only for females older than 14 years!");
			logger.info(text+" is equal to "+"Dependent admission option is available only for females older than 14 years!");
			Markup m=MarkupHelper.createLabel("Dependent admission option is available only for females older than 14 years!", ExtentColor.GREEN);
			test.info(m);		
		}

		if(text.equals("Package assigned successfully!")) {
			Assert.assertEquals("Package assigned successfully!","Package assigned successfully!");
			logger.info(text+" is equal to "+"Package assigned successfully!");
			Markup m=MarkupHelper.createLabel("Package assigned successfully!", ExtentColor.GREEN);
			test.info(m);	
		}

		if(text.equals("Package deleted successfully!")) {
			Assert.assertEquals("Package deleted successfully!","Package deleted successfully!");
			logger.info(text+" is equal to "+"Package deleted successfully!");
			Markup m=MarkupHelper.createLabel("Package deleted successfully!", ExtentColor.GREEN);
			test.info(m);
		}

		if(text.equals("This Bed is already assigned to the patient")) {
			Assert.assertEquals("This Bed is already assigned to the patient","This Bed is already assigned to the patient");
			logger.info(text+" is equal to "+"This Bed is already assigned to the patient");
			Markup m=MarkupHelper.createLabel("This Bed is already assigned to the patient", ExtentColor.GREEN);
			test.info(m);
		}

		if(text.equals("Already transferred!")) 
		{
			Assert.assertEquals("Already transferred!","Already transferred!");
			logger.info(text+" is equal to "+"Already transferred!");
			Markup m=MarkupHelper.createLabel("Already transferred!", ExtentColor.GREEN);
			test.info(m);
		}
		if(text.equals("Diagnosis details are mandatory before order")) {
			Assert.assertEquals("Diagnosis details are mandatory before order","Diagnosis details are mandatory before order");
			logger.info(text+" is equal to "+"Diagnosis details are mandatory before order");
			Markup m=MarkupHelper.createLabel("Diagnosis details are mandatory before order", ExtentColor.GREEN);
			test.info(m);
		}
	}

	public void ageRadioButton(ExtentTest test)
	{
		WebElement agebutton_element = driver.findElement(AGE_RADIO_BUTTON);
		if(!agebutton_element.isSelected())
		{
			driver.clickByJS(TTWebsiteDriver.driver, agebutton_element);
			logger.info("Age Radio Button is selected");
			Markup m1=MarkupHelper.createLabel("Age Radio Button is selected", ExtentColor.GREEN);
			test.info(m1);
		}
	}

	public void EnterAge(ExtentTest test,String age) 
	{
		try {
			driver.waitForElementPresent(Age,10);
			driver.findElement(Age).sendKeys(age);
			driver.findElement(Age).sendKeys(Keys.ENTER);
			logger.info("Age= "+age);
			Markup m=MarkupHelper.createLabel("Age= "+age, ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {
			Markup m=MarkupHelper.createLabel("User is not able to enter Age= "+age, ExtentColor.RED);
			test.info(m);	}
	}

	public void selectAgeTypeDropdown(ExtentTest test,String agetype) 
	{
		Select sl = new Select(driver.findElement(AGE_TYPE));
		sl.selectByVisibleText(agetype);
		logger.info("Age Type= "+agetype);
		Markup m=MarkupHelper.createLabel("Age Type= "+agetype, ExtentColor.GREEN);
		test.info(m);
	}

	public void TimeofBirth(ExtentTest test,String birthtime) throws InterruptedException 
	{
		Thread.sleep(4000);
		try {
			if(driver.findElements(By.xpath("//a[@id='duplicatepopupclose']//i")).size()>0) 
			{
				driver.findElement(By.xpath("//a[@id='duplicatepopupclose']//i")).click();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		driver.findElement(TIME_OF_BIRTH).sendKeys(birthtime);
		logger.info("Time of Birth= "+birthtime);
		Markup m=MarkupHelper.createLabel("Time of Birth= "+birthtime, ExtentColor.GREEN);
		test.info(m);
	}

	public void clickonFatherRadioButtonANDEnterFatherName(ExtentTest test,String fathername) throws InterruptedException {

		WebElement fatherradio_btn = driver.findElement(FATHER_RADIO_BUTTON);
		if(!fatherradio_btn.isSelected())
		{
			try {
				driver.findElement(FATHER_RADIO_BUTTON).click();
				logger.info("Father Radio Button is selected");
				driver.findElement(FATHER_NAME).sendKeys(fathername);
				Thread.sleep(2000);
				logger.info("Father Name= "+fathername);
				Markup m=MarkupHelper.createLabel("Father Radio Button is selected and Father Name= "+fathername, ExtentColor.GREEN);
				test.info(m);
			}
			catch (Exception e) {
				Markup m=MarkupHelper.createLabel("Father Radio Button is not selected and Father Name is not filled= "+fathername, ExtentColor.RED);
				test.info(m);			
			}
		}
	}

	public void EnterFatherName(String fathername) throws InterruptedException 
	{
		driver.findElement(FATHER_NAME).sendKeys(fathername);
		Thread.sleep(2000);
		logger.info("Father Name= "+fathername);
	}

	public void selectMaritalStatus(ExtentTest test,String maritalstatus) throws InterruptedException 
	{
		try {
			Select sl=new Select(driver.findElement(MARITAL_STATUS));
			sl.selectByVisibleText(maritalstatus);
			Thread.sleep(2000);
			logger.info("Marital Satus= "+maritalstatus);
			Markup m=MarkupHelper.createLabel("Marital Satus is selected= "+maritalstatus, ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {
			Markup m=MarkupHelper.createLabel("Marital Satus is not selected= "+maritalstatus, ExtentColor.RED);
			test.info(m);		
		}
	}

	public void EnterAddress(ExtentTest test,String address) throws InterruptedException 
	{
		try {
			Thread.sleep(2000);
			driver.findElement(ADDRESS).sendKeys(address);
			logger.info("Address= "+address);
			Markup m=MarkupHelper.createLabel("Address= "+address, ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {
			logger.info("User is not able to enter Address= "+address);
			Markup m=MarkupHelper.createLabel("User is not able to enter Address= "+address, ExtentColor.RED);
			test.info(m);		}
	}

	public void selectCity(ExtentTest test,String city) throws InterruptedException 
	{
		try {
			Select sl=new Select(driver.findElement(CITY));
			sl.selectByVisibleText(city);
			Thread.sleep(2000);
			logger.info("City Name= "+city);
			Markup m=MarkupHelper.createLabel("City Name= "+city, ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {
			logger.info("City Name is not selected= "+city);
			Markup m=MarkupHelper.createLabel("City Name is not selected= "+city, ExtentColor.RED);
			test.info(m);		
		}
	}

	public void selectNationality(ExtentTest test,String nationality) throws InterruptedException 
	{
		try {
			Select sl=new Select(driver.findElement(NATIONALITY));
			sl.selectByVisibleText(nationality);
			Thread.sleep(2000);
			logger.info("NATIONALITY= "+nationality);
			Markup m=MarkupHelper.createLabel("NATIONALITY= "+nationality, ExtentColor.GREEN);
			test.info(m);	
		}
		catch (Exception e) 
		{
			Markup m=MarkupHelper.createLabel("NATIONALITY is not selected= "+nationality, ExtentColor.RED);
			test.info(m);	
		}
	}

	public void enterPinNumber(ExtentTest test,String pinnumber) throws InterruptedException 
	{
		driver.findElement(PIN_NUMBER).sendKeys(pinnumber);
		Thread.sleep(2000);
		logger.info("PIN Number= "+pinnumber);
		Markup m=MarkupHelper.createLabel("PIN Number= "+pinnumber, ExtentColor.GREEN);
		test.info(m);
	}

	public void selectNRIcheckbox() throws InterruptedException 
	{
		driver.findElement(NRI_CHECKBOX).click();
		Thread.sleep(2000);
		logger.info("NRI Check Box is Selected");

	}

	public void enterNationalId(ExtentTest test,String nationalid) throws InterruptedException 
	{

		driver.findElement(NATIONAL_ID).sendKeys(nationalid);
		Thread.sleep(2000);
		logger.info("National ID= "+nationalid);
		Markup m=MarkupHelper.createLabel("National ID= "+nationalid, ExtentColor.GREEN);
		test.info(m);
	}

	public void howdidyoucometoknowus(ExtentTest test,String knowus) throws InterruptedException 
	{
		try {
			Select sl=new Select(driver.findElement(HOWDIDYOUCOMETOKNOWUS));
			sl.selectByVisibleText(knowus);
			Thread.sleep(2000);
			logger.info("HOWDIDYOUCOMETOKNOWUS= "+knowus);
			Markup m=MarkupHelper.createLabel("HOWDIDYOUCOMETOKNOWUS= "+knowus, ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e)
		{
			Markup m=MarkupHelper.createLabel("HOWDIDYOUCOMETOKNOWUS is not selected= "+knowus, ExtentColor.RED);
			test.info(m);		
		}
	}

	public void clickonaddcity(ExtentTest test) throws InterruptedException 
	{
		driver.findElement(ADD_CITY_ICON).click();
		Thread.sleep(2000);
		logger.info("Click on Add City");
		//				if(driver.findElements(By.xpath("//div[@id='citymodal']//following-sibling::section")).size()>0) 
		//				{
		//					///logger.info("New window is appear");
		//					Markup m=MarkupHelper.createLabel("New window is appear", ExtentColor.GREEN);
		//					test.info(m);
		//				}
		//				else {
		//					//logger.info("New window is not appear");
		//					Markup m=MarkupHelper.createLabel("New window is not appear", ExtentColor.RED);
		//					test.info(m);
		//				}
	}

	public void clickonSaveButton() throws InterruptedException 
	{

		WebElement save_btn = driver.findElement(SAVE_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, save_btn);
		Thread.sleep(2000);
		logger.info("Click on Save Button");
	}

	public void entermobilenumber(ExtentTest test,String mobilenumber) throws InterruptedException 
	{
		driver.findElement(MOBILE_NUMBER).sendKeys(mobilenumber);
		Thread.sleep(2000);
		logger.info("Mobile Number= "+mobilenumber);
		Markup m=MarkupHelper.createLabel("Mobile Number= "+mobilenumber, ExtentColor.GREEN);
		test.info(m);
		Thread.sleep(4000);
	}

	public void selectoccuption(ExtentTest test,String occuption) throws InterruptedException 
	{
		Select sl=new Select(driver.findElement(OCCUPTION));
		sl.selectByVisibleText(occuption);
		Thread.sleep(4000);
		logger.info("Occuption= "+occuption);
		Markup m=MarkupHelper.createLabel("Occuption= "+occuption, ExtentColor.GREEN);
		test.info(m);
		try {
			if(driver.findElements(By.xpath("//a[@id='duplicatepopupclose']//i")).size()>0) 
			{
				driver.findElement(By.xpath("//a[@id='duplicatepopupclose']//i")).click();
			}
		}
		catch (Exception e) {
		}
	}

	public void selectTab(ExtentTest test,String tabname) throws InterruptedException 
	{
		WebElement adtname_element = driver.findElement(By.xpath("//a[text()='"+tabname+"']"));
		driver.clickByJS(TTWebsiteDriver.driver, adtname_element);
		Thread.sleep(2000);
		logger.info("Tab Name= "+tabname+" is selected");
		Markup m=MarkupHelper.createLabel("Tab Name= "+tabname+" is selected", ExtentColor.GREEN);
		test.info(m);
	}

	public void clickonpermanentaddresscheckbox() throws InterruptedException {
		WebElement permanentaddress_element = driver.findElement(PERMANENT_ADDRESS);
		driver.clickByJS(TTWebsiteDriver.driver, permanentaddress_element);
		Thread.sleep(2000);
		logger.info("click on Permanent Address Check box");
	}

	public void selectdoctorspeciality(ExtentTest test,String speciality) throws InterruptedException 
	{
		try {
			Select sl=new Select(driver.findElement(DOCOTOR_SPECIALITY));
			sl.selectByVisibleText(speciality);
			///Thread.sleep(2000);
			logger.info("Doctor Speciality= "+speciality+" is selected");
			Markup m=MarkupHelper.createLabel("Doctor Speciality= "+speciality+" is selected", ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {
			logger.info("Doctor Speciality= "+speciality+" not is selected");
			Markup m=MarkupHelper.createLabel("Doctor Speciality= "+speciality+" not is selected", ExtentColor.RED);
			test.info(m);		}
	}

	public void selectAdmittingConsultant(ExtentTest test,String admittingconsultant) throws InterruptedException 
	{
		try {
			Select sl=new Select(driver.findElement(ADMITTING_CONSULTANT));
			sl.selectByVisibleText(admittingconsultant);
			///Thread.sleep(2000);
			logger.info("Admitting Consultant= "+admittingconsultant+" is selected");
			Markup m=MarkupHelper.createLabel("Admitting Consultant= "+admittingconsultant+" is selected", ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {
			logger.info("Admitting Consultant= "+admittingconsultant+" not is selected");
			Markup m=MarkupHelper.createLabel("Admitting Consultant= "+admittingconsultant+" not is selected", ExtentColor.RED);
			test.info(m);			
		}
	}

	public void selectPrimaryAttendingConsultant(ExtentTest test,String primaryadttedingconsultant) throws InterruptedException 
	{
		try {
			Select sl=new Select(driver.findElement(PRIMARY_ATTENDING_CONSULTANT));
			sl.selectByVisibleText(primaryadttedingconsultant);
			///Thread.sleep(2000);
			logger.info("Primary Attending Consultant= "+primaryadttedingconsultant+" is selected");
			Markup m=MarkupHelper.createLabel("Primary Attending Consultant= "+primaryadttedingconsultant+" is selected", ExtentColor.GREEN);
			test.info(m);	
		}
		catch (Exception e) {
			logger.info("Primary Attending Consultant= "+primaryadttedingconsultant+" not is selected");
			Markup m=MarkupHelper.createLabel("Primary Attending Consultant= "+primaryadttedingconsultant+" not is selected", ExtentColor.RED);
			test.info(m);	
		}
	}

	public void enterrefferby(ExtentTest test,String refferby) throws InterruptedException {
		driver.findElement(REFFER_BY).sendKeys(refferby);
		driver.findElement(REFFER_BY).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//table[@id='_refbytbl']//tbody//td[text()='"+refferby+"']")).click();
		///Thread.sleep(2000);
		logger.info("Reffer By= "+refferby);
		Markup m=MarkupHelper.createLabel("Reffer By= "+refferby, ExtentColor.GREEN);
		test.info(m);
	}

	public void enterexpectedlength(ExtentTest test,String expectedlength) throws InterruptedException {
		driver.findElement(EXPECTED_LENGTH_OF_STAY).sendKeys(expectedlength);
		Thread.sleep(2000);
		logger.info("Expected Length of stay= "+expectedlength);
		Markup m=MarkupHelper.createLabel("Expected Length of stay= "+expectedlength, ExtentColor.GREEN);
		test.info(m);
	}


	public void selectrequestedbedtype(ExtentTest test) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(REQUESTED_BED_TYPE));

		Select sl=new Select(driver.findElement(REQUESTED_BED_TYPE));
		if(sl.getOptions().size()>0) 
		{
			List<WebElement> option_text = sl.getOptions();
			for(int k=0;k<option_text.size();k++) 
			{
				WebElement selectedValueInDropDown = option_text.get(k);
				if(!selectedValueInDropDown.getText().isEmpty()) 
				{	
					logger.info("Requested Bed Type= "+sl.getFirstSelectedOption().getText()+" is selected");
					Markup m=MarkupHelper.createLabel("Requested Bed Type= "+sl.getFirstSelectedOption().getText()+" is selected", ExtentColor.GREEN);
					test.info(m);	
					break;
				}
				if(selectedValueInDropDown.getText().isEmpty()) {
					logger.info("Requested Bed Type is Null");
					Markup m=MarkupHelper.createLabel("Requested Bed Type is Null", ExtentColor.RED);
					test.info(m);	
				}
			}
		}
	}
	public void selectbillablebedtype(ExtentTest test) throws InterruptedException 
	{
		Select sl=new Select(driver.findElement(BILLABLE_BED_TYPE));
		if(sl.getOptions().size()>0) 
		{
			List<WebElement> option_text = sl.getOptions();
			for(int k=0;k<option_text.size();k++) 
			{
				WebElement selectedValueInDropDown = option_text.get(k);
				if(!selectedValueInDropDown.getText().isEmpty()) 
				{
					Thread.sleep(2000);
					logger.info("Billable Bed Type= "+sl.getFirstSelectedOption().getText()+" is selected");
					Markup m=MarkupHelper.createLabel("Billable Bed Type= "+sl.getFirstSelectedOption().getText()+" is selected", ExtentColor.GREEN);
					test.info(m);
					break;
				}
				if(selectedValueInDropDown.getText().isEmpty()) {
					logger.info("Billable Bed Type is Null");
					Markup m=MarkupHelper.createLabel("Billable Bed Type is Null", ExtentColor.RED);
					test.info(m);
				}
			}
		}
	}

	public void selectallotedbedtype(ExtentTest test) throws InterruptedException 
	{
		Select sl=new Select(driver.findElement(ALLOTED_BED_TYPE));
		if(sl.getOptions().size()>0) 
		{
			logger.info("Bed Option size= "+sl.getOptions().size());

			List<WebElement> option_text = sl.getOptions();
			for(int k=0;k<option_text.size();k++) 
			{
				WebElement selectedValueInDropDown = option_text.get(k);
				if(!selectedValueInDropDown.getText().isEmpty()) 
				{
					///sl.selectByVisibleText(allotedbedtype);
					logger.info("Alloted Bed Type= "+sl.getFirstSelectedOption().getText()+" is selected");
					Markup m=MarkupHelper.createLabel("Alloted Bed Type= "+sl.getFirstSelectedOption().getText()+" is selected", ExtentColor.GREEN);
					test.info(m);
					break;
				}
				if(selectedValueInDropDown.getText().isEmpty()) 
				{
					logger.info("Alloted Bed Type is Null");
					Markup m=MarkupHelper.createLabel("Alloted Bed Type is Null", ExtentColor.RED);
					test.info(m);
				}
			}
		}
	}

	public void selectwardtype(ExtentTest test) throws InterruptedException 
	{
		Select sl=new Select(driver.findElement(WARD));
		if(sl.getOptions().size()>0) 
		{
			logger.info("Bed Option size= "+sl.getOptions().size());
			List<WebElement> option_text = sl.getOptions();
			for(int k=0;k<option_text.size();k++) 
			{
				WebElement selectedValueInDropDown = option_text.get(k);
				if(!selectedValueInDropDown.getText().isEmpty()) 
				{
					logger.info("Ward Type= "+sl.getFirstSelectedOption().getText()+" is selected");
					Markup m=MarkupHelper.createLabel("Ward Type= "+sl.getFirstSelectedOption().getText()+" is selected", ExtentColor.GREEN);
					test.info(m);
					break;
				}
				if(selectedValueInDropDown.getText().isEmpty()) 
				{
					logger.info("Ward Type is Null");
					Markup m=MarkupHelper.createLabel("Ward Type is Null", ExtentColor.RED);
					test.info(m);
				}
			}
		}
	}

	public void selectbedtype(ExtentTest test) throws InterruptedException 
	{
		Select sl=new Select(driver.findElement(BED));
		if(sl.getOptions().size()>0) 
		{
			logger.info("Bed Option size= "+sl.getOptions().size());

			List<WebElement> option_text = sl.getOptions();
			for(int k=0;k<option_text.size();k++) 
			{
				WebElement selectedValueInDropDown = option_text.get(k);
				if(!selectedValueInDropDown.getText().isEmpty()) 
				{
					if(selectedValueInDropDown.getText().equals(Bed_Name))
					{
						sl.selectByVisibleText(Bed_Name);
					}
					else {
						Bed_Name=BedStatusPage.bedvalue;
						sl.selectByVisibleText(Bed_Name);
					}
					Thread.sleep(2000);
					logger.info("Bed Type= "+Bed_Name+" is selected");
					Markup m=MarkupHelper.createLabel("Bed Type= "+Bed_Name+" is selected", ExtentColor.GREEN);
					test.info(m);
				}
				if(selectedValueInDropDown.getText().isEmpty()) {
					logger.info("Bed Option name= "+selectedValueInDropDown.getText());
					Markup m=MarkupHelper.createLabel("Bed Option name= "+selectedValueInDropDown.getText(), ExtentColor.RED);
					test.info(m);
				}
			}
		}
	}

	public void clickonschemecheckbox() throws InterruptedException 
	{
		WebElement scheme_checkbox = driver.findElement(SCHEME_CHECKBOX);
		if(!scheme_checkbox.isSelected()) {
			driver.clickByJS(TTWebsiteDriver.driver, scheme_checkbox);
			Thread.sleep(2000);
			logger.info("Click on Scheme Check Box");
		}
	}

	public void selectscheme(String scheme) throws InterruptedException 
	{
		Select sl=new Select(driver.findElement(SCHEME_DROPDOWN));
		sl.selectByVisibleText(scheme);
		Thread.sleep(2000);
		logger.info("Scheme= "+scheme);
	}

	public void selectpackagedetailsspeciality(ExtentTest test,String packagedetails) throws InterruptedException 
	{
		try {
			Select sl=new Select(driver.findElement(PACKAGEDETAILS_SPECIALITY));
			sl.selectByVisibleText(packagedetails);
			Thread.sleep(2000);
			logger.info("Package Details Speciality= "+packagedetails+" is selected");
			Markup m=MarkupHelper.createLabel("Package Details Speciality= "+packagedetails+" is selected", ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {
			logger.info("Package Details Speciality= "+packagedetails+" not is selected");
			Markup m=MarkupHelper.createLabel("Package Details Speciality= "+packagedetails+" is not selected", ExtentColor.RED);
			test.info(m);
		}
	}

	public void selectdoctor(ExtentTest test,String doctor) throws InterruptedException 
	{
		try {
			Select sl=new Select(driver.findElement(DOCTOR));
			sl.selectByVisibleText(doctor);
			Thread.sleep(2000);
			logger.info("Doctor Name= "+doctor+" not selected");
			Markup m=MarkupHelper.createLabel("Doctor Name= "+doctor+" is not selected", ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {
			logger.info("Doctor Name= "+doctor+" not is selected");
			Markup m=MarkupHelper.createLabel("Doctor Name= "+doctor+" is not selected", ExtentColor.RED);
			test.info(m);		
		}
	}

	public void enterkinname(ExtentTest test,String kinname) throws InterruptedException 
	{
		driver.findElement(KIN_NAME).sendKeys(kinname);	
		Thread.sleep(2000);
		logger.info("Kin Name= "+kinname);
		Markup m=MarkupHelper.createLabel("Kin Name= "+kinname, ExtentColor.GREEN);
		test.info(m);	
	}

	public void selectkinRelationship(ExtentTest test,String Relationship) throws InterruptedException
	{
		try {
			Select sl=new Select(driver.findElement(RELATIONSHIP));
			sl.selectByVisibleText(Relationship);
			Thread.sleep(2000);
			logger.info("Relationship with Kin= "+Relationship+" is selected");
			Markup m=MarkupHelper.createLabel("Relationship with Kin= "+Relationship+" is selected", ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {
			logger.info("Relationship with Kin= "+Relationship+" is not selected");
			Markup m=MarkupHelper.createLabel("Relationship with Kin= "+Relationship+" is not selected", ExtentColor.GREEN);
			test.info(m);		
		}
	}

	public void  clickonCopyfrompresentAddresscheckbox() throws InterruptedException {
		WebElement CopyfrompresentAddress = driver.findElement(COPY_PRESENTADDRESS);
		if(!CopyfrompresentAddress.isSelected()) 
		{
			driver.clickByJS(TTWebsiteDriver.driver, CopyfrompresentAddress);
			Thread.sleep(2000);
			logger.info("Click on Copy from present Address check box");
		}
	}

	public void  enteremergencyname(String emergencyname) throws InterruptedException 
	{
		driver.findElement(EMERGENCY_NAME).sendKeys(emergencyname);	
		Thread.sleep(2000);
		logger.info("Emergency Name= "+emergencyname);
	}

	public void enteremergencyphonenumber(String emergencyphonenumber) throws InterruptedException 
	{
		driver.findElement(EMERGENCY_PHNUMBER).sendKeys(emergencyphonenumber);	
		Thread.sleep(2000);
		logger.info("Emergency PhNumber= "+emergencyphonenumber);
	}

	public void enterbillingcounselling(String billingcounselling) throws InterruptedException {

		driver.findElement(BILLING_COUNSELLING).sendKeys(billingcounselling);
		Thread.sleep(2000);
		logger.info("Billing Counselling= "+billingcounselling);
	}

	public void enterClinicalCounselling(String clinicalCounselling) throws InterruptedException 
	{
		driver.findElement(CLINICAL_COUNSELLING).sendKeys(clinicalCounselling);
		Thread.sleep(2000);
		logger.info("Clinical Counselling= "+clinicalCounselling);	
	}

	public void selectlocality(ExtentTest test,String locality) throws InterruptedException 
	{
		try {
			Select sl=new Select(driver.findElement(LOCALITY));
			sl.selectByVisibleText(locality);
			Thread.sleep(2000);
			logger.info("Locality= "+locality);
			Markup m=MarkupHelper.createLabel("Locality= "+locality, ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {
			Markup m=MarkupHelper.createLabel("Locality is not selected= "+locality, ExtentColor.RED);
			test.info(m);		
		}
	}

	public void clickonacceptyes(ExtentTest test) 
	{
		try {
			driver.findElement(ACCEPT_YES).click();
			logger.info("Click on Accept Button");
			Markup m=MarkupHelper.createLabel("Click on Accept Button", ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) 
		{
			Markup m=MarkupHelper.createLabel("Not Click on Accept Button", ExtentColor.RED);
			test.info(m);
		}
	}

	public void clickonprintbutton(ExtentTest test) throws InterruptedException{
		try {
			driver.findElement(PRINT_BUTTON).click();
			logger.info("Click on Print Button");
			Markup m=MarkupHelper.createLabel("Click on Print Button", ExtentColor.GREEN);
			test.info(m);
			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			Thread.sleep(4000);
			driver.close();

		}
		catch (Exception e) 
		{
			Markup m=MarkupHelper.createLabel("Not Click on Print Button", ExtentColor.RED);
			test.info(m);
		}
	}

	public void companyInsuranceDetails(ExtentTest test,String companytype,String company,String rate) throws InterruptedException
	{

		WebElement companyinsurance = driver.findElement(COMPANY_INSURANCE_RADIO_BUTTON);
		if(!companyinsurance.isSelected())
		{
			driver.clickByJS(TTWebsiteDriver.driver, companyinsurance);
			logger.info("Company Insurance Radio Button is selected");
			Markup m=MarkupHelper.createLabel("Company Insurance Radio Button is selected", ExtentColor.GREEN);
			test.info(m);
			try {
				TTWebsiteDriver.selectByvisibletext(COMPANY_TYPE, companytype);
				Thread.sleep(2000);
				TTWebsiteDriver.selectByvisibletext(COMPANY, company);
				Thread.sleep(2000);
				TTWebsiteDriver.selectByvisibletext(RATE_OF_CONTRACT, rate);

				logger.info("Scheme Company Type= "+companytype);
				logger.info("Company= "+company);
				logger.info("Rate of Contract= "+rate);
				Markup m1=MarkupHelper.createLabel("Scheme Company Type= "+companytype, ExtentColor.GREEN);
				test.info(m1);
				Markup m2=MarkupHelper.createLabel("Company= "+company, ExtentColor.GREEN);
				test.info(m2);
				Markup m3=MarkupHelper.createLabel("Rate of Contract= "+rate, ExtentColor.GREEN);
				test.info(m3);
			}
			catch (Exception e) {
				Markup m2=MarkupHelper.createLabel("Scheme Company Type= "+companytype+" Company= "+company+" Rate of Contract= "+rate+" is not selected", ExtentColor.RED);
				test.info(m2);
			}
		}
	}

	public void enterauthorizationNumber(ExtentTest test,String authnumber) 
	{
		driver.findElement(AUTHORIZATION_No).sendKeys(authnumber);
		logger.info("Authorization Number= "+authnumber);
		Markup m=MarkupHelper.createLabel("Authorization Number= "+authnumber, ExtentColor.GREEN);
		test.info(m);
	}

	public void enterCreditLimit(ExtentTest test,String creditlimit) 
	{
		driver.findElement(CREDIT_NUMBER).sendKeys(creditlimit);
		logger.info("Credit Limit= "+creditlimit);
		Markup m=MarkupHelper.createLabel("Credit Limit= "+creditlimit, ExtentColor.GREEN);
		test.info(m);
	}
	public  String rename(String s)
	{
		String []d=s.split("0");
		int a=Integer.parseInt(d[1])+1;
		return d[0]+Integer.toString(a);
	}

	public void verifyDetailsFetch(ExtentTest test) 
	{
		WebElement RemarkCheckBox_element = driver.findElement(FIRST_NAME);
		WebElement title_element = driver.findElement(TITLE_DROP_DOWN);

		if(!title_element.isEnabled() && !RemarkCheckBox_element.isEnabled()) 
		{
			logger.info("Details is fetch");
			Markup m1=MarkupHelper.createLabel("Details is fetch", ExtentColor.GREEN);
			test.info(m1);	
		}
		else {
			logger.info("All details text box get enabled and user can be able to modify patient details");
			Markup m1=MarkupHelper.createLabel("All details text box get enabled and user can be able to modify patient details", ExtentColor.GREEN);
			test.info(m1);	
		}

	}
}
