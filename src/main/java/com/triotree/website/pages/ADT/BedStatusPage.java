package com.triotree.website.pages.ADT;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.utils.PropertyFile;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class BedStatusPage extends HISWebsiteBasePage {
	private static final Logger logger = LogManager.getLogger(ADTHomePage.class.getName());

	public BedStatusPage(TTWebsiteDriver driver) 
	{
		super(driver);
	}
	private final By VACANT_BED=By.xpath("//div[@id='_bedpatient']//div[@class='patient-card vacant']");
	private final By ADMIT=By.xpath("//div[@class='patient-card vacant open']//ul[@class=' fr dropdown-menu  pull-right']//a[text()='Admit']");
	private final By WARD_DROPDOWN=By.id("_ward");
	private final By BED_TYPE=By.id("_bedtype");
	private final By FACILITY=By.id("ddlfacility");
	private final By BED_NAME=By.id("txtbedname");
	private final By IPMaster_BED_TYPE=By.id("ddlbedtype");
	private final By ROOM_NUMBER=By.id("ddlroomno");
	private final By SPECILITY=By.id("ddlspeciality");
	private final By INTERFACE_IEN=By.id("txtinterface");
	private final By SAVE_BUTTON=By.xpath("//a[@id='btnsave']//i");
	private final By YES_BUTTON=By.id("btnyes");
	private final By BED_STATUS=By.id("_bedsatatus");
	private final By POPUP_TEXT=By.xpath("//div[@class='gritter-without-image']//p");
	private final By Retained_Bed=By.id("chkretained");
	private final By occupiedBed_Bed=By.id("DDl_TBed");
	private final By Transfer_Tracking_close_btn=By.xpath("//div[@id='transfertracking']//a//i");
	private final By Add_to_Waitlist=By.id("addrequest");
	private final By Clear_Button=By.id("Clearitem");
	private final By Occupied_Ward_Type=By.id("DDl_TWard");
	private final By Bed_Transfer_Save_Btn=By.id("saveitem");
	boolean bed=false;
	boolean ward=false;
	int j=0;
	int waitlist=0;
	static String bedvalue="";
	static String bedtype="";
	static String wardname="";
	String Bed_Name="";
	String interfacIEN="";
	String Facility=PropertyFile.getProperty("facility");
	String Bed_Type=PropertyFile.getProperty("bedtype");
	String Room_Number=PropertyFile.getProperty("roonnumber");
	String Specility=PropertyFile.getProperty("specility");


	public void selectwarddropdown(ExtentTest test,String text,String bedstatus) throws InterruptedException
	{
		TTWebsiteDriver.selectByvisibletext(WARD_DROPDOWN, text);
		Thread.sleep(2000);
		TTWebsiteDriver.selectByvisibletext(BED_TYPE, Bed_Type);
		Thread.sleep(2000);
		TTWebsiteDriver.selectByvisibletext(BED_STATUS, bedstatus);

		logger.info("Ward= "+text+" is selected");
		logger.info("Bed Type= "+Bed_Type+" is selected");
		logger.info("Bed Status= "+bedstatus+" is selected");
		Markup m=MarkupHelper.createLabel("Ward= "+text+" is selected", ExtentColor.GREEN);
		test.info(m);
		Markup m1=MarkupHelper.createLabel("Bed Type= "+Bed_Type+" is selected", ExtentColor.GREEN);
		test.info(m1);
		Markup m2=MarkupHelper.createLabel("Bed Status= "+bedstatus+" is selected", ExtentColor.GREEN);
		test.info(m2);
	}

	public void checkbedstatus(ExtentTest test) throws InterruptedException
	{

		String bed_number = driver.findElement(By.xpath("//div[@id='_bedpatient']//div[@class='patient-card vacant']//span[text()='"+Bed_Name+"']")).getText();

		if(bed_number.replace("|", "").equals(bedvalue)) 
		{
			logger.info("Bed Name= "+bed_number.replace("|", ""));
			Markup m=MarkupHelper.createLabel("Bed Name= "+bed_number.replace("|", ""), ExtentColor.GREEN);
			test.info(m);
			driver.findElement(By.xpath("//div[@id='_bedpatient']//div[@class='patient-card vacant']//span[text()='"+bedvalue+"']/..//following::a[@class='fr dropdown-toggle']//i")).click();
			Thread.sleep(2000);
			driver.findElement(ADMIT).click();
			Thread.sleep(4000);		
		}
		else {
			logger.info(bed_number+" is not equal to "+Bed_Name);
			Markup m=MarkupHelper.createLabel(bed_number+" is not equal to "+Bed_Name, ExtentColor.RED);
			test.info(m);
		}

	}

	public void createbedInIpMaster() throws InterruptedException 
	{
		TTWebsiteDriver.selectByvisibletext(FACILITY, Facility);
		for(int i=1;i<=200;i++) {
			if(driver.findElements(By.xpath("//table[@id='tblmain']//td[text()='"+"TrioBed"+i+"']")).size()==0)
			{
				Bed_Name="TrioBed"+i;
				break;
			}
		}
		for(int j=1;j<=200;j++) 
		{
			if(driver.findElements(By.xpath("//table[@id='tblmain']//td[text()='"+"Automation Testing"+j+"']")).size()==0) 
			{
				interfacIEN="Automation Testing"+j;
				break;
			}
		}
		driver.findElement(BED_NAME).sendKeys(Bed_Name);
		Thread.sleep(2000);
		TTWebsiteDriver.selectByvisibletext(IPMaster_BED_TYPE, Bed_Type);
		Thread.sleep(2000);
		TTWebsiteDriver.selectByvisibletext(ROOM_NUMBER, Room_Number);
		Thread.sleep(2000);
		TTWebsiteDriver.selectByvisibletext(SPECILITY, Specility);
		Thread.sleep(2000);
		driver.findElement(INTERFACE_IEN).sendKeys(interfacIEN);
		Thread.sleep(2000);
		bedvalue=Bed_Name;
		bedtype=Bed_Type;
		wardname=Room_Number;
		logger.info("Facility= "+Facility+" Bed Name= "+Bed_Name+" Bed Type= "+Bed_Type+" Room Number= "+Room_Number);
	}

	public void clickonsavebutton() throws InterruptedException 
	{
		driver.findElement(SAVE_BUTTON).click();
		logger.info("Click on Save Button");
	}

	public void clickonYesButton() throws InterruptedException 
	{
		driver.findElement(YES_BUTTON).click();
		logger.info("Click on Yes Button");
	}

	public void clickonPendingTransferRequest(ExtentTest test) throws InterruptedException 
	{
		List<WebElement> transfer_list = driver.findElements(By.xpath("(//table[@id='transfertbl']//tbody//tr)"));
		for(int i=1;i<=transfer_list.size();i++) 
		{
			if(j==0) {
				driver.findElement(By.xpath("(//table[@id='transfertbl']//tbody//tr)["+i+"]//button")).click();
				logger.info("Click on View");
				Markup m=MarkupHelper.createLabel("Click on View", ExtentColor.GREEN);
				test.info(m);	
				driver.findElement(Retained_Bed).click();
				String Retained_Bed_status = driver.findElement(By.xpath("//table[@id='tbl_tracking']//tbody//tr")).getAttribute("style");
				if(Retained_Bed_status.contains("table-row")) 
				{
					logger.info("Bed is Release");
					Markup m1=MarkupHelper.createLabel("Bed is Release", ExtentColor.GREEN);
					test.info(m1);	
				}
				else {
					logger.info("Bed is not Release");
					Markup m1=MarkupHelper.createLabel("Bed is not Release", ExtentColor.RED);
					test.info(m1);	
				}
				clickonTransferTarckingclosebutton(test);
			}
			driver.findElement(By.xpath("(//table[@id='transfertbl']//tbody//tr)["+i+"]")).click();
			logger.info("Click on Pending Transfer Request");
			Markup m1=MarkupHelper.createLabel("Click on Pending Transfer Request", ExtentColor.GREEN);
			test.info(m1);	
			j++;
			break;
		}
	}

	public void checkandselectOccupiedBed_Bed(ExtentTest test) throws InterruptedException {

		Select sl=new Select(driver.findElement(occupiedBed_Bed));
		if(sl.getOptions().size()>0) 
		{
			List<WebElement> option_text = sl.getOptions();
			for(int k=0;k<option_text.size();k++) 
			{
				WebElement selectedValueInDropDown = option_text.get(k);
				if(!selectedValueInDropDown.getText().isEmpty() && (!selectedValueInDropDown.getAttribute("value").contains("0"))) 
				{	
					sl.selectByVisibleText(selectedValueInDropDown.getText());
					logger.info("Occupied Bed Type= "+(selectedValueInDropDown.getText())+" is selected");
					Markup m=MarkupHelper.createLabel("Occupied Bed Type= "+(selectedValueInDropDown.getText())+" is selected", ExtentColor.GREEN);
					test.info(m);	
					bed=true;
					if(bed && ward==true) {
					clickonBedTransferSaveButton(test);
					}
					break;
				}
				if(option_text.size()==1 && selectedValueInDropDown.getAttribute("value").contains("0")) {
					logger.info("Occupied Bed Type is Null");
					Markup m=MarkupHelper.createLabel("Occupied Bed Type is Null", ExtentColor.RED);
					test.info(m);	
					if(waitlist==0) {
						clickonAddtoWaitlist(test);
						clickonClear_Button(test);
						clickonPendingWaitlist(test);
						clickonPendingTransferRequest(test);
					}
				}
				waitlist++;
			}
		}
	}

	public void clickonTransferTarckingclosebutton(ExtentTest test) throws InterruptedException {

		driver.findElement(Transfer_Tracking_close_btn).click();
		logger.info("Click on Transfer Tarcking close Button");
		Markup m1=MarkupHelper.createLabel("Click on Transfer Tarcking close Button", ExtentColor.GREEN);
		test.info(m1);
		Thread.sleep(4000);
	}

	public void clickonAddtoWaitlist(ExtentTest test) throws InterruptedException {
		WebElement pending_element = driver.findElement(Add_to_Waitlist);
		driver.clickByJS(TTWebsiteDriver.driver, pending_element);
		logger.info("Click on Add to Waitlist");
		Markup m1=MarkupHelper.createLabel("Click on Add to Waitlist", ExtentColor.GREEN);
		test.info(m1);
		Thread.sleep(4000);
	}

	public void clickonClear_Button(ExtentTest test) throws InterruptedException {
		WebElement clear_element = driver.findElement(Clear_Button);
		driver.clickByJS(TTWebsiteDriver.driver, clear_element);
		logger.info("Click on Clear Button");
		Markup m1=MarkupHelper.createLabel("Click on Clear Button", ExtentColor.GREEN);
		test.info(m1);
		Thread.sleep(4000);
	}

	public void clickonPendingWaitlist(ExtentTest test) {
		List<WebElement> waitlist = driver.findElements(By.xpath("//table[@id='waitlisttbl']//tbody//tr"));
		for(int i=1;i<=waitlist.size();i++) 
		{
			driver.findElement(By.xpath("(//table[@id='waitlisttbl']//tbody//tr)["+i+"]")).click();
			logger.info("Click on Pending Wait list");
			Markup m1=MarkupHelper.createLabel("Click on Pending Wait list", ExtentColor.GREEN);
			test.info(m1);
			break;
		}
	}

	public void selectOccupiedBedward(ExtentTest test) throws InterruptedException 
	{
		Select sl=new Select(driver.findElement(Occupied_Ward_Type));
		if(sl.getOptions().size()>0) 
		{
			List<WebElement> option_text = sl.getOptions();
			for(int k=0;k<option_text.size();k++) 
			{
				WebElement selectedValueInDropDown = option_text.get(k);
				if(!selectedValueInDropDown.getText().isEmpty()) 
				{	
					sl.selectByVisibleText(selectedValueInDropDown.getText());
					logger.info("Occupied Ward Type= "+selectedValueInDropDown.getText()+" is selected");
					Markup m=MarkupHelper.createLabel("Occupied Ward Type= "+selectedValueInDropDown.getText()+" is selected", ExtentColor.GREEN);
					test.info(m);	
					ward=true;
					if(ward==true && bed==true) 
					{
						break;
					}
					if(ward==true && bed==false)  {
						checkandselectOccupiedBed_Bed(test);
					}
				}
				if(selectedValueInDropDown.getText().isEmpty()) {
					logger.info("Occupied Ward Type is Null");
					Markup m=MarkupHelper.createLabel("Occupied Ward Type is Null", ExtentColor.RED);
					test.info(m);	
					break;
				}
			}
		}
	}

	public void clickonBedTransferSaveButton(ExtentTest test) throws InterruptedException {
		WebElement save = driver.findElement(Bed_Transfer_Save_Btn);
		driver.clickByJS(TTWebsiteDriver.driver, save);
		logger.info("Click on Save Button");
		Markup m=MarkupHelper.createLabel("Click on Save Button", ExtentColor.GREEN);
		test.info(m);
		Thread.sleep(4000);
	}

	public void clickonPackageandBillingcontinue(ExtentTest test) throws InterruptedException 
	{
		try {
			driver.findElement(By.xpath("//a[@id='btnAcceptYes']")).click();
			logger.info("Click on Package and Billing continue Yes Button");
			Markup m=MarkupHelper.createLabel("Click on Package and Billing continue Yes Button", ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(2000);
		}
		catch (Exception e) {}
	}
}
