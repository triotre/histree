package com.triotree.website.pages.ADT;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class UpdatePatientDetailsandAddpackagePage extends HISWebsiteBasePage 
{
	private static final Logger logger = LogManager.getLogger(ADTHomePage.class.getName());

	public UpdatePatientDetailsandAddpackagePage(TTWebsiteDriver driver) {
		super(driver);
	}
	int i=0;
	String First_Name="";
	String Last_Name="";
	private final By IP_NUMBER = By.id("text_ipid");
	private final By UHID_NUMBER=By.id("uhid_admimitPatient");
	private final By Dependent_ADM=By.id("dipendentadmission");
	private final By MODIFY=By.id("modify");
	private final By Simultaneously_transfer_to=By.id("chkadmsimultaneously");
	private final By SEX=By.id("admsex");
	private final By FATHER_NAME=By.id("admfather");
	private final By Speciality=By.id("admspecilty");
	private final By Primary_Consultant=By.id("admconsultant");
	private final By Referring_Consultant=By.id("adm_refBY");
	private final By Delivery_type=By.id("admdeliverytype");
	private final By Birth_Type=By.id("birthtype");
	private final By Gestational_Age=By.id("txtwek");
	private final By Save_Button=By.id("saveAdm");
	private final By closeADM=By.id("closeADM");
	private final By Selected_Package_icon=By.id("packagedetails_packagename");
	private final By Package_Detail_Search=By.id("pkdetail_serach");
	private final By PLUS_BUTTON_ICON=By.id("addrowdata");
	private final By DELETE_BUTTON_ICON=By.id("deletepackage");
	private final By NEW_ASSIGN_YES_BTN=By.id("btnsavenewpack");
	private final By NEW_ASSIGN_NO_BTN=By.id("btnnonewpack");
	private final By Delete_Package_YES_BTN=By.id("btndeletpackage");
	private final By Delete_Package_NO_BTN=By.id("btncanelpackagedel");
	private final By Allotted_Bed_Type=By.id("admallotedbedtype");
	private final By Ward=By.id("admward");
	private final By Bed=By.id("admbed");
	private final By Clear_Button=By.id("Clearitem");

	public void enterIPNumber(ExtentTest test,String ipnumber) 
	{
//		if(i==1) {
//			driver.findElement(IP_NUMBER).clear();
//		}
		driver.findElement(IP_NUMBER).sendKeys(ipnumber);
		driver.findElement(IP_NUMBER).sendKeys(Keys.ENTER);
		logger.info("IP Number= "+ipnumber);
		Markup m1=MarkupHelper.createLabel("IP Number= "+ipnumber, ExtentColor.GREEN);
		test.info(m1);
		//i++;
	}

	public void enterUHID_NUMBER(ExtentTest test,String uhidnumber) 
	{
		driver.findElement(UHID_NUMBER).clear();
		driver.findElement(UHID_NUMBER).sendKeys(uhidnumber);
		driver.findElement(UHID_NUMBER).sendKeys(Keys.ENTER);
		logger.info("UHID NUMBER= "+uhidnumber);
		Markup m1=MarkupHelper.createLabel("UHID NUMBER= "+uhidnumber, ExtentColor.GREEN);
		test.info(m1);
	}

	public void clickonDependentADM(ExtentTest test) {
		WebElement adm_element = driver.findElement(Dependent_ADM);
		driver.clickByJS(TTWebsiteDriver.driver, adm_element);
		logger.info("Click on Dependent ADM Button");
		if(driver.findElements(By.xpath("//span[text()='Dependent Admission']")).size()>0)
		{
			logger.info("Dependent_Admission popup window  is open");
			Markup m1=MarkupHelper.createLabel("Dependent Admission popup window  is open", ExtentColor.GREEN);
			test.info(m1);
		}
		else {
			logger.info("Dependent_Admission popup window is not open");
			Markup m1=MarkupHelper.createLabel("Dependent Admission popup window  is not open", ExtentColor.RED);
			test.info(m1);
		}
	}

	public void clickonModifyButton() 
	{
		WebElement modify_element = driver.findElement(MODIFY);
		driver.clickByJS(TTWebsiteDriver.driver, modify_element);
		logger.info("Click on Modify Button");
	}

	public void Simultaneouslytransferform() 
	{
		driver.findElement(Simultaneously_transfer_to).click();
		logger.info("Click on Simultaneously Transfer To");	
	}

	public void selectsex(ExtentTest test,String sex) 
	{
		TTWebsiteDriver.selectByvisibletext(SEX, sex);
		logger.info("Sex= "+sex);	
		Markup m1=MarkupHelper.createLabel("Sex= "+sex, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterFatherName(ExtentTest test,String fathername)
	{
		driver.findElement(FATHER_NAME).sendKeys(fathername);
		logger.info("Father Name= "+fathername);
		Markup m1=MarkupHelper.createLabel("Father Name= "+fathername, ExtentColor.GREEN);
		test.info(m1);
	}

	public void selectDeliveryandBirthType(ExtentTest test,String delivery,String birth)
	{
		TTWebsiteDriver.selectByvisibletext(Delivery_type, delivery);
		TTWebsiteDriver.selectByvisibletext(Birth_Type, birth);
		logger.info("Delivery_type= "+delivery);
		logger.info("Birth_Type= "+birth);
		Markup m1=MarkupHelper.createLabel("Delivery_type= "+delivery, ExtentColor.GREEN);
		test.info(m1);
		Markup m2=MarkupHelper.createLabel("Birth_Type= "+birth, ExtentColor.GREEN);
		test.info(m2);
	}


	public void enterGestationalAge(ExtentTest test,String age) 
	{
		driver.findElement(Gestational_Age).sendKeys(age);
		logger.info("Gestational Age= "+age);
		Markup m1=MarkupHelper.createLabel("Gestational Age= "+age, ExtentColor.GREEN);
		test.info(m1);
	}

	public void selectandfilledspecialityprimaryandReferring(ExtentTest test,String speciality,String consultant,String refer) throws InterruptedException 
	{
		TTWebsiteDriver.selectByvisibletext(Speciality, speciality);
		Thread.sleep(1000);
		try {
		TTWebsiteDriver.selectByvisibletext(Primary_Consultant ,consultant);
		}
		catch (Exception e) {}
		driver.findElement(Referring_Consultant).sendKeys(refer);
		WebElement referring_consultant = driver.findElement(Referring_Consultant);
		TTWebsiteDriver.doubleclick(referring_consultant);
		logger.info("Speciality="+speciality);
		logger.info("Primary_Consultant= "+consultant);
		logger.info("Referring_Consultant= "+refer);
		Markup m1=MarkupHelper.createLabel("Speciality="+speciality, ExtentColor.GREEN);
		test.info(m1);
		Markup m2=MarkupHelper.createLabel("Primary_Consultant= "+consultant, ExtentColor.GREEN);
		test.info(m2);
		Markup m3=MarkupHelper.createLabel("Referring_Consultant= "+refer, ExtentColor.GREEN);
		test.info(m3);
	}

	public void clickonSaveButton(ExtentTest test) {
		WebElement save_element = driver.findElement(Save_Button);
		driver.clickByJS(TTWebsiteDriver.driver, save_element);
		logger.info("Click on Save Button");
		Markup m1=MarkupHelper.createLabel("Click on Save Button", ExtentColor.GREEN);
		test.info(m1);

	}

	public void clickoncancelbutton(ExtentTest test) 
	{
		WebElement cancel_element = driver.findElement(closeADM);
		driver.clickByJS(TTWebsiteDriver.driver, cancel_element);	
		logger.info("Click on Cancel Button");
		Markup m1=MarkupHelper.createLabel("Click on Cancel Button", ExtentColor.GREEN);
		test.info(m1);

		if(driver.findElements(By.xpath("//div[@class='modal-block-new top23']//span[@class='header_title']")).size()==0)
		{
			logger.info("Dependent_Admission popup window is close");
			Markup m=MarkupHelper.createLabel("Dependent_Admission popup window  is close", ExtentColor.GREEN);
			test.info(m);
		}
	}

	public void getvalueofFirstandLastName(ExtentTest test) {

		First_Name = driver.findElement(By.xpath("//input[@id='admf_name' and @type='text']")).getAttribute("value");
		logger.info("First Name= "+First_Name);
		Markup m=MarkupHelper.createLabel("First Name= "+First_Name, ExtentColor.GREEN);
		test.info(m);
		Last_Name =driver.findElement(By.xpath("//input[@id='adm_lname' and @type='text']")).getAttribute("value");
		logger.info("Last_Name= "+Last_Name);
		Markup m1=MarkupHelper.createLabel("Last_Name= "+Last_Name, ExtentColor.GREEN);
		test.info(m1);
	}

	public void verifyandgetAdmitPatientUpdatedFirstandLastName(ExtentTest test) 
	{
		String updatedFirst_Name = driver.findElement(By.xpath("//input[@id='f_name' and @type='text']")).getAttribute("value");
		logger.info("Admit Patient Updated First Name= "+updatedFirst_Name);
		String updatedLast_Name =driver.findElement(By.xpath("//input[@id='l_name' and @type='text']")).getAttribute("value");
		logger.info("Admit Patient Updated Last_Name= "+updatedLast_Name);

		if(First_Name.replace("BABY OF  ", "").equals(updatedFirst_Name) && Last_Name.trim().equals(updatedLast_Name)) 
		{
			logger.info("Name is updated");
			Markup m1=MarkupHelper.createLabel("Name is updated= "+updatedFirst_Name, ExtentColor.GREEN);
			test.info(m1);
		}
		else {
			logger.info("Name is not updated");
			Markup m1=MarkupHelper.createLabel("Name is not updated", ExtentColor.RED);
			test.info(m1);
		}
	}

	public void clickonSelectedPackage(ExtentTest test) 
	{
		WebElement package_icon = driver.findElement(Selected_Package_icon);
		driver.clickByJS(TTWebsiteDriver.driver, package_icon);

		if(driver.findElements(By.xpath("//div[@class='modal-block-new top15']//span[@class='header_title']")).size()>0)
		{
			logger.info("Package Details popup window  is open");
			Markup m1=MarkupHelper.createLabel("Package Details popup window  is open", ExtentColor.GREEN);
			test.info(m1);
		}
		else {
			logger.info("Package Details popup window is not open");
			Markup m1=MarkupHelper.createLabel("Package Details popup window  is not open", ExtentColor.RED);
			test.info(m1);
		}
	}

	public void packageDetailSearch(ExtentTest test,String packagename) 
	{
		driver.findElement(Package_Detail_Search).sendKeys(packagename);
		driver.findElement(Package_Detail_Search).sendKeys(Keys.ENTER);
		driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(By.xpath("//td[text()='"+packagename+"']")));
		WebElement selected_bed_type = driver.findElement(By.xpath("//table[@id='pricepkdetail']//tbody//tr//input[@checked]"));
		if(selected_bed_type.isSelected())
		{
			List<WebElement> bed_amount = driver.findElements(By.xpath("//table[@id='pricepkdetail']//tbody//tr//input[@checked]/..//following-sibling::td"));
			for(int i=1;i<=bed_amount.size();i++) 
			{
				String text = driver.findElement(By.xpath("(//table[@id='pricepkdetail']//tbody//tr//input[@checked]/..//following-sibling::td)["+i+"]")).getText();

				Pattern p = Pattern.compile("([0-9])");
				Matcher m = p.matcher(text);

				if(m.find())
				{
					logger.info("Price= "+text);
					Markup m1=MarkupHelper.createLabel("Package Details Price= "+text, ExtentColor.GREEN);
					test.info(m1);
				}
				else {
					logger.info("Bed Type= "+text);
					Markup m1=MarkupHelper.createLabel("Package Details Bed Type= "+text, ExtentColor.GREEN);
					test.info(m1);
				}
			}
		}
		WebElement package_save_btn = driver.findElement(By.id("savepackage"));
		driver.clickByJS(TTWebsiteDriver.driver, package_save_btn);
	}

	public void verifypackageDetails(ExtentTest test) {

		if(driver.findElements(By.xpath("//table[@id='packagedetails_tbl']//tbody//tr")).size()>0) 
		{
			logger.info("Package details is added in blow grid");
			Markup m=MarkupHelper.createLabel("Package details is added in blow grid", ExtentColor.GREEN);
			test.info(m);
		}
	}

	public void clickonplusbuttonicon(ExtentTest test) 
	{
		driver.findElement(PLUS_BUTTON_ICON).click();
		logger.info("Click on Plus Button Icon");
		Markup m=MarkupHelper.createLabel("Click on Plus Button Icon", ExtentColor.GREEN);
		test.info(m);

	}

	public void verfiyAssignnewPackagePopup(ExtentTest test) 
	{
		if(driver.findElements(By.xpath("//label[text()='Assign new package?']")).size()>0) 
		{
			logger.info("system will be throwing a pop-up Assign new package?");
			Markup m=MarkupHelper.createLabel("system will be throwing a pop-up Assign new package?", ExtentColor.GREEN);
			test.info(m);
		}
	}

	public void verifyDeletePackagePopup(ExtentTest test)
	{
		if(driver.findElements(By.xpath("//label[text()='Delete package?']")).size()>0) 
		{
			logger.info("system will be throwing a pop-up Delete package?");
			Markup m=MarkupHelper.createLabel("system will be throwing a pop-up Delete package?", ExtentColor.GREEN);
			test.info(m);
		}
	}

	public void clickonNewAssignYesbutton(ExtentTest test)
	{
		driver.findElement(NEW_ASSIGN_YES_BTN).click();
		logger.info("Click on New Assign Yes Button");
		Markup m=MarkupHelper.createLabel("Click on New Assign Yes Button", ExtentColor.GREEN);
		test.info(m);
	}

	public void clickonNewAssignNobutton(ExtentTest test) 
	{
		driver.findElement(NEW_ASSIGN_NO_BTN).click();
		logger.info("Click on New Assign No Button");
		Markup m=MarkupHelper.createLabel("Click on New Assign No Button", ExtentColor.GREEN);
		test.info(m);

	}

	public void clickonDeleteButtonIcon(ExtentTest test)
	{
		driver.findElement(DELETE_BUTTON_ICON).click();
		logger.info("Click on Delete Button Icon");
		Markup m=MarkupHelper.createLabel("Click on Delete Button Icon", ExtentColor.GREEN);
		test.info(m);
	}

	public void clickonDeletePackageYesButton(ExtentTest test) 
	{
		WebElement yes_element = driver.findElement(Delete_Package_YES_BTN);
		driver.clickByJS(TTWebsiteDriver.driver, yes_element);
		logger.info("Click on Delete Package Yes Button");
		Markup m=MarkupHelper.createLabel("Click on Delete Package Yes Button", ExtentColor.GREEN);
		test.info(m);

	}

	public void clickonDeletePackageNoButton(ExtentTest test) 
	{
		driver.findElement(Delete_Package_NO_BTN).click();
		logger.info("Click on Delete Package NO Button");
		Markup m=MarkupHelper.createLabel("Click on Delete Package NO Button", ExtentColor.GREEN);
		test.info(m);
	}

	public void selectAllottedBedType(ExtentTest test) 
	{
		TTWebsiteDriver.selectByvisibletext(Allotted_Bed_Type, BedStatusPage.bedtype);
		logger.info("simultaneously transfer to Allotted Bed Type= "+BedStatusPage.bedtype);
		Markup m=MarkupHelper.createLabel("simultaneously transfer to Allotted Bed Type= "+BedStatusPage.bedtype, ExtentColor.GREEN);
		test.info(m);
	}

	public void selectward(ExtentTest test,String ward) {
		TTWebsiteDriver.selectByvisibletext(Ward, ward);
		logger.info("simultaneously transfer to Ward Name= "+ward);
		Markup m=MarkupHelper.createLabel("simultaneously transfer to Ward Name= "+ward, ExtentColor.GREEN);
		test.info(m);
	}

	public void selectBed(ExtentTest test) throws InterruptedException {
		Select sl=new Select(driver.findElement(Bed));
		if(sl.getOptions().size()>0) 
		{
			logger.info("Bed Option size= "+sl.getOptions().size());

			List<WebElement> option_text = sl.getOptions();
			for(int k=0;k<option_text.size();k++) 
			{
				WebElement selectedValueInDropDown = option_text.get(k);
				if(!selectedValueInDropDown.getText().isEmpty()) 
				{
					if(selectedValueInDropDown.getText().equals(BedStatusPage.bedvalue))
					{
						sl.selectByVisibleText(BedStatusPage.bedvalue);
						Thread.sleep(2000);
						logger.info("simultaneously transfer to Bed Type= "+BedStatusPage.bedvalue+" is selected");
						Markup m=MarkupHelper.createLabel("simultaneously transfer to Bed Type= "+BedStatusPage.bedvalue+" is selected", ExtentColor.GREEN);
						test.info(m);
					}
					else {
						sl.selectByVisibleText(BedStatusPage.bedvalue);
					}
					
				}
				if(selectedValueInDropDown.getText().isEmpty()) {
					logger.info("Bed Option name= "+selectedValueInDropDown.getText());
					Markup m=MarkupHelper.createLabel("simultaneously transfer to Bed Option name= "+selectedValueInDropDown.getText(), ExtentColor.RED);
					test.info(m);
				}
			}
		}
	}
	
	public void clickonClear_Button(ExtentTest test)
	{
	driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(Clear_Button));
	logger.info("Click on Clear Button");
	Markup m=MarkupHelper.createLabel("Click on Clear Button", ExtentColor.GREEN);
	test.info(m);
	}
}
