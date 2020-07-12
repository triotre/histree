package com.triotree.website.pages.ADT;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class UpdateAdmissionDate extends HISWebsiteBasePage
{


	private static final Logger logger = LogManager.getLogger(ADTHomePage.class.getName());
	private final By ADMIT_PATIENT_SECTION = By.xpath("//li[@id='FOAddPatientMenu']//i[@class='fa fa-caret-down']");
	private final By IP_NUMBER=By.id("txtIPNO");
	private final By SAVE_BUTTON=By.id("btnUpdate");
	private final By NEW_DISCHARGE_TYPE=By.id("ddlndischarg");
	private final By ADDMISSION_DATE_RADIO=By.xpath("//input[@id='rbladmdate' and @class='disable_a_href']");
	private final By NEW_ADMISSION_DATE_FIELD=By.id("dtpNewAdmitDateTime");
	private final By DISCHARGE_TYPE_RADIO_BUTTON=By.id("rbldischarge");

	public UpdateAdmissionDate(TTWebsiteDriver driver) 
	{
		super(driver);
	}

	private final By IP_DEPOSIT_REFUND = By.xpath("//li[@id='FOBedTranferMenu']//a[text()='IP Deposit Refund']");

	public void clickOnAdmitPatientAndSelectAdmitPatient(ExtentTest test,String option) throws InterruptedException {
		driver.waitForElementPresent(ADMIT_PATIENT_SECTION);
		driver.click(ADMIT_PATIENT_SECTION);
		logger.info("Admit Patient Section is Expanded");
		Markup m=MarkupHelper.createLabel("Admit Patient Section is Expanded", ExtentColor.GREEN);
		test.info(m);
		driver.waitForElementPresent(By.xpath("//ul[@style='display: block;']//a[text()='"+option+"']"), 120);
		WebElement options = driver.findElement(By.xpath("//ul[@style='display: block;']//a[text()='"+option+"']"));
		options.click();
		logger.info("Following Option has been selected from Indent Items Section " + option);
		Markup m1=MarkupHelper.createLabel("Following Option has been selected from Indent Items Section " + option, ExtentColor.GREEN);
		test.info(m1);
		driver.waitForPageLoad();
		Thread.sleep(3000);
	}

	public void enterIPnumber(ExtentTest test,String ipnumber) throws InterruptedException 
	{
		driver.findElement(IP_NUMBER).sendKeys(ipnumber);
		driver.findElement(IP_NUMBER).sendKeys(Keys.ENTER);
		logger.info("IP Number= "+ipnumber);
		Markup m=MarkupHelper.createLabel("IP Number= "+ipnumber, ExtentColor.GREEN);
		test.info(m);
		Thread.sleep(1000);
		verifyInformationisfetch(test);
	}

	public void checkNewAdmissionDateField(ExtentTest test,String text) throws InterruptedException
	{
		String datefield_attribute = driver.findElement(NEW_ADMISSION_DATE_FIELD).getAttribute("class");
		System.out.println("datefield_attribute= "+datefield_attribute);
		if(datefield_attribute.contains("disable")) 
		{
			logger.info("New Admission Date Field should not be editable");
			Markup m=MarkupHelper.createLabel("New Admission Date Field should not be editable", ExtentColor.RED);
			test.info(m);
		}
		else {
			logger.info("New Admission Date Field should be editable");
			driver.findElement(NEW_ADMISSION_DATE_FIELD).sendKeys(text);
			logger.info("New Admission Date Field= "+text);
			Markup m=MarkupHelper.createLabel("New Admission Date Field should be editable and Date Field= "+text, ExtentColor.GREEN);
			test.info(m);
			Thread.sleep(1000);
			clickonSaveButton();
		}
	}

	public void clickonSaveButton() 
	{
		WebElement save_btn = driver.findElement(SAVE_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, save_btn);
		logger.info("Click on Save Button");
	}

	public void selectNewDischargeType(ExtentTest test,String text) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_DISCHARGE_TYPE));

		Select sl=new Select(driver.findElement(NEW_DISCHARGE_TYPE));
		if(sl.getOptions().size()>0) 
		{
			List<WebElement> option_text = sl.getOptions();
			for(int k=0;k<option_text.size();k++) 
			{
				WebElement selectedValueInDropDown = option_text.get(k);
				if(!selectedValueInDropDown.getText().isEmpty()) 
				{	sl.selectByVisibleText(text);
				logger.info("New Discharge Type= "+text+" is selected");
				Markup m=MarkupHelper.createLabel("New Discharge Type is enable and New Discharge Type= "+text+" is selected", ExtentColor.GREEN);
				test.info(m);	
				break;
				}
				if(selectedValueInDropDown.getText().isEmpty()) {
					logger.info("New Discharge Type is Null");
					Markup m=MarkupHelper.createLabel("New Discharge Type is Null", ExtentColor.RED);
					test.info(m);	
				}
			}
		}
	}

	public void clickonAdmissionDateRadioButton(ExtentTest test)
	{
		String btn_attribute = driver.findElement(ADDMISSION_DATE_RADIO).getAttribute("class");
		logger.info("Admission Date Radio att= "+btn_attribute);

		if(btn_attribute.equals("disable_a_href")) {
			logger.info("Admission Date Radio Button not get selected");
			Markup m=MarkupHelper.createLabel("Admission Date Radio Button not get selected", ExtentColor.RED);
			test.info(m);
		}
		if(!btn_attribute.equals("disable_a_href")) 
		{
			WebElement radio_btn_element = driver.findElement(ADDMISSION_DATE_RADIO);
			driver.findElement(ADDMISSION_DATE_RADIO).click();
			if(radio_btn_element.isSelected()) 
			{
				logger.info("Admission Date Radio Button get selected");
				Markup m=MarkupHelper.createLabel("Admission Date Radio Button get selected", ExtentColor.GREEN);
				test.info(m);
			}
		}
	}

	public void verifyInformationisfetch(ExtentTest test) 
	{
		WebElement dischargetype = driver.findElement(DISCHARGE_TYPE_RADIO_BUTTON);
		if(dischargetype.isSelected()) 
		{
			logger.info("Discharge Type radio button is selected");
			logger.info("Details of patient is fetch");
			Markup m=MarkupHelper.createLabel("Details of patient is fetch", ExtentColor.GREEN);
			test.info(m);
		}
		else {
			logger.info("Details of patient is not  fetch");
			Markup m=MarkupHelper.createLabel("Details of patient is not fetch", ExtentColor.RED);
			test.info(m);
		}
	}

	public void clickonclearbutton() 
	{
		WebElement clear_element = driver.findElement(By.id("btnClear"));
		driver.clickByJS(TTWebsiteDriver.driver, clear_element);
		logger.info("Click on clear button");
	}

	public void verifyExpiredDateTimeField(ExtentTest test) 
	{
		if(driver.findElements(By.xpath("//input[@id='dtpexpdate' and @value]")).size()>0) 
		{
			logger.info("Expired date time field should visible on screen");
			String datetimevalue = driver.findElement(By.xpath("//input[@id='dtpexpdate' and @value]")).getAttribute("value");
			logger.info("Expired Date Time value= "+datetimevalue);
			Markup m=MarkupHelper.createLabel("Expired Date Time field is visible on screen and it's value= "+datetimevalue, ExtentColor.GREEN);
			test.info(m);
		}
	}
}
