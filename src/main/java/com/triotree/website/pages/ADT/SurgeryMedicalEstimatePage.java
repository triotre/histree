package com.triotree.website.pages.ADT;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class SurgeryMedicalEstimatePage extends HISWebsiteBasePage {
	private static final Logger logger = LogManager.getLogger(ADTHomePage.class.getName());

	public SurgeryMedicalEstimatePage(TTWebsiteDriver driver) {
		super(driver);
	}

	private final By UHID = By.id("uHid");
	private final By patient_name=By.xpath("//div[@class='right_patient_info']//label[@id='patient_name']");
	private final By MEDICAL_RADIO_BUTTON=By.id("rd_medical");
	private final By Requested_Bed_Type=By.id("bedType");
	private final By Total_No_Of_IP_Days=By.id("IP_bed_days");
	private final By ICU_Days=By.id("icu_bed_days");
	private final By Req_Ward_Days=By.id("req_bed_days");
	private final By Expected_Date_of_Admission=By.id("ExpectedDateof_Admission");
	private final By Bed_Type=By.id("_bedType1");
	private final By Ward_Days=By.id("_bedType1days");
	private final By Bed_Type2=By.id("_bedType2");
	private final By Ward_Days2=By.id("_bedType2days");
	private final By Diagnosis_Problem=By.id("problem");
	private final By Primary_Attending_Speciality=By.id("physician_speciality");
	private final By Primary_Attending_Consultant=By.id("physician_name");
	private final By Visits_Days=By.id("_primaryvistdays");
	private final By CoSpeciality=By.id("_cospecility");
	private final By CoConsultant=By.id("_coConsultant");
	private final By COVisits_Days=By.id("_coVisits");
	private final By Secondary_Speciality=By.id("_secondarySpeciality");
	private final By Secondary_Consultant=By.id("_secondaryConsultant");
	private final By Secondary_Visits_Days=By.id("_secondaryVisits");
	private final By Cash_Radio_Button=By.id("rd_cash");
	private final By Referred_By=By.id("referredBy");
	private final By Billing_Counselling_done_to=By.id("billCounselling");
	private final By Emergency_Contacts=By.id("emerg_contact");
	private final By CheckBox_As_per_Actual=By.id("_Asperactualchage");
	private final By Drug_Charges=By.xpath("//input[@id='_checkdrug']");
	private final By Investigation_Charges=By.xpath("//input[@id='_checkInvestigation']");
	private final By Consumable_Charges=By.xpath("//input[@id='_checkConsumable']");
	private final By Transfusion_Medicine=By.id("tran_charges");
	private final By Equipment_Charges=By.id("equi_charges");
	private final By No_of_Referral_Doctor_Visits=By.id("doc_visit");
	private final By Cost_Per_Visit=By.id("cost_visit");
	private final By Implants=By.id("implants");
	private final By Implants_Amount=By.id("amount");
	private final By Pharm_ICU_Days=By.id("phar_icu_days");
	private final By Amount_Per_Day=By.id("amt_per_day");
	private final By Other_Item_1=By.id("otherItem1");
	private final By Other_Item1_Amount=By.id("otherItem1_amt");
	private final By Add_Other_Item_Button=By.id("_btnaddotheriteam");
	private final By Service=By.id("service");
	private final By Item=By.id("items");
	private final By Qty=By.id("qty");
	private final By Add_Service_Iteam=By.id("_btnaddserviceiteam");
	private final By Calculate_surgery=By.id("cal_surgery");
	private final By Save_Button=By.id("save_surgeryDetails");
	private final By Save_Estimation=By.id("btnyes");
	private final By Save_Successfully=By.id("btnprint_yes");

	public void enterUhid(ExtentTest test,String text) throws InterruptedException 
	{
		String att = driver.findElement(UHID).getAttribute("disabled");
		if(att!=null) {
			logger.info("UHID field is disabled");
			Markup m=MarkupHelper.createLabel("UHID field is disabled", ExtentColor.RED);
			test.info(m);
		}
		else {
			logger.info("UHID field is enabled");
			Markup m=MarkupHelper.createLabel("UHID field is enabled", ExtentColor.GREEN);
			test.info(m);
			driver.findElement(UHID).clear();
			driver.findElement(UHID).sendKeys(text);
			driver.findElement(UHID).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			String att1 = driver.findElement(UHID).getAttribute("disabled");
			if(att1.equals("true")) {
				logger.info("After Press Enter Key UHID field is disabled");
				Markup m1=MarkupHelper.createLabel("After Press Enter Key UHID field is disabled", ExtentColor.GREEN);
				test.info(m1);
				String patient_text = driver.findElement(patient_name).getText();
				logger.info("Patient details fetch on banner= "+patient_text);
				Markup m2=MarkupHelper.createLabel("Patient details fetch on banner= "+patient_text, ExtentColor.GREEN);
				test.info(m2);
			}
		}
	}

	public void clickonMedicalRadioButton(ExtentTest test) {
		WebElement medical = driver.findElement(MEDICAL_RADIO_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, medical);
		logger.info("Click on Radio Button");
		Markup m2=MarkupHelper.createLabel("Click on Radio Button", ExtentColor.GREEN);
		test.info(m2);
	}

	public void selectRequestedBedType(ExtentTest test,String text) 
	{
		TTWebsiteDriver.selectByvisibletext(Requested_Bed_Type, text);
		logger.info("Requested Bed Type= "+text);
		Markup m2=MarkupHelper.createLabel("Requested Bed Type= "+text, ExtentColor.GREEN);
		test.info(m2);
	}

	public void checkTotalNoOfIPDays(ExtentTest test)
	{
		String ipdays = driver.findElement(By.xpath("//input[@id='IP_bed_days']")).getAttribute("readonly");
		if(ipdays.contains("true")) 
		{
			logger.info("Total No Of IP Days field is in disable form");
			Markup m2=MarkupHelper.createLabel("Total No Of IP Days field is in disable form", ExtentColor.GREEN);
			test.info(m2);
		}
	}

	public void enterICUDays(ExtentTest test,String text) 
	{
		driver.findElement(ICU_Days).sendKeys(text);
		logger.info("ICU Days= "+text);
		Markup m2=MarkupHelper.createLabel("ICU Days= "+text, ExtentColor.GREEN);
		test.info(m2);
	}

	public void enterRequiredWardDays(ExtentTest test,String text)
	{
		driver.findElement(Req_Ward_Days).sendKeys(text);
		logger.info("Required Ward Days= "+text);
		Markup m2=MarkupHelper.createLabel("Required Ward Days= "+text, ExtentColor.GREEN);
		test.info(m2);
	}

	public void enterExpectedDateofAdmission(ExtentTest test,String text)
	{
		driver.findElement(Expected_Date_of_Admission).sendKeys(text);
		driver.findElement(Expected_Date_of_Admission).sendKeys(Keys.ENTER);

		logger.info("Expected Date of Admission= "+text);
		Markup m2=MarkupHelper.createLabel("Expected Date of Admission= "+text, ExtentColor.GREEN);
		test.info(m2);
	}

	public void selectBedType(ExtentTest test,String text) 
	{
		TTWebsiteDriver.selectByvisibletext(Bed_Type, text);
		logger.info("Bed Type= "+text+" is selected");
		Markup m2=MarkupHelper.createLabel("Bed Type= "+text+" is selected", ExtentColor.GREEN);
		test.info(m2);
	}

	public void enterWardDays(ExtentTest test,String text)
	{
		driver.findElement(Ward_Days).sendKeys(text);
		logger.info("Ward Days= "+text);
		Markup m2=MarkupHelper.createLabel("Ward Days= "+text, ExtentColor.GREEN);
		test.info(m2);
	}

	public void selectBedType2(ExtentTest test,String text) 
	{
		TTWebsiteDriver.selectByvisibletext(Bed_Type2, text);
		logger.info("Bed Type2= "+text+" is selected");
		Markup m2=MarkupHelper.createLabel("Bed Type2= "+text+" is selected", ExtentColor.GREEN);
		test.info(m2);
	}

	public void enterWardDays2(ExtentTest test,String text)
	{
		driver.findElement(Ward_Days2).sendKeys(text);
		logger.info("Ward Days2= "+text);
		Markup m2=MarkupHelper.createLabel("Ward Days2= "+text, ExtentColor.GREEN);
		test.info(m2);
	}

	public void enterDiagnosisProblem(ExtentTest test,String text) 
	{
		driver.findElement(Diagnosis_Problem).sendKeys(text);
		logger.info("Diagnosis Problem= "+text);
		Markup m2=MarkupHelper.createLabel("Diagnosis Problem= "+text, ExtentColor.GREEN);
		test.info(m2);
	}

	public void selectPrimaryAttendingSpeciality(ExtentTest test,String text) 
	{
		TTWebsiteDriver.selectByvisibletext(Primary_Attending_Speciality,text);
		logger.info("Primary/AttendingSpeciality= "+text+" is selected");
		Markup m2=MarkupHelper.createLabel("Primary/AttendingSpeciality= "+text+" is selected", ExtentColor.GREEN);
		test.info(m2);
		Select sl=new Select(driver.findElement(Primary_Attending_Consultant));
		sl.getFirstSelectedOption().getText();
		logger.info("Value of Primary Attending Consultant "+sl.getFirstSelectedOption().getText()+" is auto fetch on selection of Primary Attending speciality");
		Markup m1=MarkupHelper.createLabel("Value of Primary Attending Consultant "+sl.getFirstSelectedOption().getText()+" is auto fetch on selection of Primary Attending speciality", ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterVisitsDays(ExtentTest test,String text) 
	{
		driver.findElement(Visits_Days).sendKeys(text);
		logger.info("VisitsDays= "+text);
		Markup m2=MarkupHelper.createLabel("VisitsDays= "+text, ExtentColor.GREEN);
		test.info(m2);
	}

	public void selectCospecility(ExtentTest test,String text) 
	{
		TTWebsiteDriver.selectByvisibletext(CoSpeciality, text);
		logger.info("Co-specility= "+text+" is selected");
		Markup m2=MarkupHelper.createLabel("Co-specility= "+text+" is selected", ExtentColor.GREEN);
		test.info(m2);
	}

	public void selectCoConsultant(ExtentTest test,String text) 
	{
		TTWebsiteDriver.selectByvisibletext(CoConsultant, text);
		logger.info("Co-Consultant= "+text+" is selected");
		Markup m2=MarkupHelper.createLabel("Co-Consultant= "+text+" is selected", ExtentColor.GREEN);
		test.info(m2);
	}

	public void enterCOVisitsDays(ExtentTest test,String text) 
	{
		driver.findElement(COVisits_Days).sendKeys(text);
		logger.info("CO-Visits Days= "+text);
		Markup m2=MarkupHelper.createLabel("CO-Visits Days= "+text, ExtentColor.GREEN);
		test.info(m2);
	}

	public void selectSecondarySpeciality(ExtentTest test,String text) 
	{
		TTWebsiteDriver.selectByvisibletext(Secondary_Speciality, text);
		logger.info("Secondary Speciality= "+text+" is selected");
		Markup m2=MarkupHelper.createLabel("Secondary Speciality= "+text+" is selected", ExtentColor.GREEN);
		test.info(m2);
		Select sl=new Select(driver.findElement(Secondary_Consultant));
		sl.getFirstSelectedOption().getText();
		logger.info("Value of Secondary Consultant "+sl.getFirstSelectedOption().getText()+" is auto fetch on selection of Secondary speciality");
		Markup m1=MarkupHelper.createLabel("Value of Secondary Consultant "+sl.getFirstSelectedOption().getText()+" is auto fetch on selection of Secondary speciality", ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterSecondaryVisitsDays(ExtentTest test,String text) 
	{
		driver.findElement(Secondary_Visits_Days).sendKeys(text);
		logger.info("Secondary Visits Days= "+text);
		Markup m2=MarkupHelper.createLabel("Secondary Visits Days= "+text, ExtentColor.GREEN);
		test.info(m2);
	}

	public void checkCashRadioButton(ExtentTest test) {
		WebElement cash_element = driver.findElement(Cash_Radio_Button);
		if(cash_element.isSelected()) 
		{
			logger.info("Cash radio button is selected");
			Markup m2=MarkupHelper.createLabel("Cash radio button is selected", ExtentColor.GREEN);
			test.info(m2);
		}
	}

	public void selectReferredBy(ExtentTest test,String text) 
	{
		TTWebsiteDriver.selectByvisibletext(Referred_By, text);
		logger.info("Referred By= "+text+" is selected");
		Markup m2=MarkupHelper.createLabel("Referred By= "+text+" is selected", ExtentColor.GREEN);
		test.info(m2);
	}

	public void enterBillingCounsellingdoneto(ExtentTest test,String text) 
	{
		driver.findElement(Billing_Counselling_done_to).sendKeys(text);
		logger.info("Billing Counselling done to= "+text);
		Markup m2=MarkupHelper.createLabel("Billing Counselling done to= "+text, ExtentColor.GREEN);
		test.info(m2);
	}

	public void enterEmergencyContacts(ExtentTest test,String text) 
	{
		driver.findElement(Emergency_Contacts).sendKeys(text);
		logger.info("Emergency Contacts= "+text);
		Markup m2=MarkupHelper.createLabel("Emergency Contacts= "+text, ExtentColor.GREEN);
		test.info(m2);
	}

	public void checkAsperActual(ExtentTest test) throws InterruptedException {
		driver.findElement(CheckBox_As_per_Actual).click();
		logger.info("As per Actual check box is get checked ");
		Markup m2=MarkupHelper.createLabel("As per Actual check box is get checked ", ExtentColor.GREEN);
		test.info(m2);
		WebElement drug = driver.findElement(Drug_Charges);
		WebElement investigation = driver.findElement(Investigation_Charges);
		WebElement consumable = driver.findElement(Consumable_Charges);

		if(drug.isSelected() && investigation.isSelected() && consumable.isSelected()) 
		{
			///logger.info("all fields is selected");
			String durg_attr = driver.findElement(By.xpath("//input[@id='_checkdrug']//following-sibling::input[@disabled]")).getAttribute("disabled");
			Thread.sleep(1000);
			String investigation_attr = driver.findElement(By.xpath("//input[@id='_checkInvestigation']//following-sibling::input[@disabled]")).getAttribute("disabled");
			Thread.sleep(1000);
			String consumable_attr = driver.findElement(By.xpath("//input[@id='_checkConsumable']//following-sibling::input[@disabled]")).getAttribute("disabled");

			if(durg_attr.equals("true") && investigation_attr.contains("true") && consumable_attr.contains("true")) 
			{
				logger.info("Checkboxes is auto checked on selection of 'as per actual' checkbox and field is disable");
				Markup m1=MarkupHelper.createLabel("Checkboxes is auto checked on selection of 'as per actual' checkbox and field is disable", ExtentColor.GREEN);
				test.info(m1);
			}
		}
		else {
			logger.info("As per Actual check box is not get checked");
			Markup m1=MarkupHelper.createLabel("As per Actual check box is not get checked", ExtentColor.RED);
			test.info(m1);
		}
	}

	public void enterTransfusionMedicine(ExtentTest test,String text)
	{
		driver.findElement(Transfusion_Medicine).sendKeys(text);
		logger.info("Transfusion Medicine Amount= "+text);
		Markup m1=MarkupHelper.createLabel("Transfusion Medicine Amount= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterEquipmentCharges(ExtentTest test,String text)
	{
		driver.findElement(Equipment_Charges).sendKeys(text);
		logger.info("Equipment Charges Amount= "+text);
		Markup m1=MarkupHelper.createLabel("Equipment Charges Amount= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterNumberofReferralDoctorVisits(ExtentTest test,String text) {
		driver.findElement(No_of_Referral_Doctor_Visits).sendKeys(text);
		logger.info("Number of Referral Doctor Visits= "+text);
		Markup m1=MarkupHelper.createLabel("Number of Referral Doctor Visits= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterCostPerVisit(ExtentTest test,String text) 
	{
		driver.findElement(Cost_Per_Visit).sendKeys(text);
		logger.info("Cost Per Visit= "+text);
		Markup m1=MarkupHelper.createLabel("Cost Per Visit= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterImplants(ExtentTest test,String text) 
	{
		driver.findElement(Implants).sendKeys(text);
		logger.info("Implants= "+text);
		Markup m1=MarkupHelper.createLabel("Implants= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterImplantsAmount(ExtentTest test,String text)
	{
		driver.findElement(Implants_Amount).sendKeys(text);
		logger.info("Implants Amount= "+text);
		Markup m1=MarkupHelper.createLabel("Implants Amount= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void checkPharmICUDays(ExtentTest test) {
		String icudays = driver.findElement(Pharm_ICU_Days).getAttribute("disabled");
		if(icudays.equals("true")) {
			logger.info("Pharm ICU Days Field is disabled");
			Markup m1=MarkupHelper.createLabel("Pharm ICU Days Field is disabled", ExtentColor.GREEN);
			test.info(m1);
		}
	}

	public void enterAmountPerDay(ExtentTest test,String text) {
		driver.findElement(Amount_Per_Day).sendKeys(text);
		logger.info("Amount Per Day= "+text);
		Markup m1=MarkupHelper.createLabel("Amount Per Day= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterOtherItem1(ExtentTest test,String text) {

		driver.findElement(Other_Item_1).sendKeys(text);
		logger.info("Other Item 1= "+text);
		Markup m1=MarkupHelper.createLabel("Other Item 1= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterOtherItem1Amount(ExtentTest test,String text) 
	{	
		driver.findElement(Other_Item1_Amount).sendKeys(text);
		logger.info("Other Item1 Amount= "+text);
		Markup m1=MarkupHelper.createLabel("Other Item1 Amount= "+text, ExtentColor.GREEN);
		test.info(m1);

	}

	public void clickonAddOtherItemButton(ExtentTest test) 
	{	
		driver.findElement(Add_Other_Item_Button).click();
		logger.info("Add Other Item Button is clicked");
		Markup m1=MarkupHelper.createLabel("Add Other Item Button is clicked", ExtentColor.GREEN);
		test.info(m1);
		List<WebElement> Other_item_cart = driver.findElements(By.xpath("//table[@id='_tbladditeam']//tbody//tr"));
		if(Other_item_cart.size()>0) 
		{
			logger.info("Data is added in Other item cart");
			Markup m2=MarkupHelper.createLabel("Data is added in Other item cart", ExtentColor.GREEN);
			test.info(m2);
		}

	}


	public void selectService(ExtentTest test,String text) 
	{
		TTWebsiteDriver.selectByvisibletext(Service, text);
		logger.info("Service= "+text+" is Selected");
		Markup m2=MarkupHelper.createLabel("Service= "+text+" is Selected", ExtentColor.GREEN);
		test.info(m2);
	}

	public void selectItem(ExtentTest test,String text) 
	{
		TTWebsiteDriver.selectByvisibletext(Item, text);
		logger.info("Item= "+text+" is Selected");
		Markup m2=MarkupHelper.createLabel("Item= "+text+" is Selected", ExtentColor.GREEN);
		test.info(m2);
	}


	public void enterQty(ExtentTest test,String text) 
	{	
		driver.findElement(Qty).sendKeys(text);
		logger.info("Qty= "+text);
		Markup m2=MarkupHelper.createLabel("Qty= "+text, ExtentColor.GREEN);
		test.info(m2);
	}

	public void clickonAddServiceIteam(ExtentTest test) {
		WebElement addservice = driver.findElement(Add_Service_Iteam);
		driver.clickByJS(TTWebsiteDriver.driver, addservice);
		logger.info("Click on Add Service Iteam Button");
		Markup m2=MarkupHelper.createLabel("Click on Add Service Iteam Button", ExtentColor.GREEN);
		test.info(m2);
	}

	public void clickonCalculatesurgery(ExtentTest test) {
		WebElement cal_btn = driver.findElement(Calculate_surgery);
		driver.clickByJS(TTWebsiteDriver.driver, cal_btn);
		logger.info("Click on Calculate Surgery Button");
		Markup m2=MarkupHelper.createLabel("Click on Calculate Surgery Button", ExtentColor.GREEN);
		test.info(m2);

	}

	public void clickonSaveButton(ExtentTest test) {
		WebElement save_btn = driver.findElement(Save_Button);
		driver.clickByJS(TTWebsiteDriver.driver, save_btn);
		logger.info("Click on Save Button");
		Markup m2=MarkupHelper.createLabel("Click on Save Button", ExtentColor.GREEN);
		test.info(m2);
	}

	public void clickonSaveEstimation(ExtentTest test) 
	{
		WebElement estimation = driver.findElement(Save_Estimation);
		driver.clickByJS(TTWebsiteDriver.driver, estimation);
		logger.info("Click on Do you want to save estimation for this patient?");
		Markup m2=MarkupHelper.createLabel("Click on Do you want to save estimation for this patient?", ExtentColor.GREEN);
		test.info(m2);
	}

	public void clickonSaveSuccessfully(ExtentTest test) throws InterruptedException 
	{
		WebElement successfully = driver.findElement(Save_Successfully);
		driver.clickByJS(TTWebsiteDriver.driver, successfully);
		logger.info("SaveSuccessfully Click on Do you want to print estimation of this patient!");
		Markup m2=MarkupHelper.createLabel("SaveSuccessfully Click on Do you want to print estimation of this patient!", ExtentColor.GREEN);
		test.info(m2);
		driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
		Thread.sleep(5000);
		driver.close();
		logger.info("Print Window is Close");
		Markup m1=MarkupHelper.createLabel("Print Window is Close", ExtentColor.GREEN);
		test.info(m1);
	}
}
