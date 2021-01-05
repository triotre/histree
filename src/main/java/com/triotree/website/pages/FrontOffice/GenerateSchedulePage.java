package com.triotree.website.pages.FrontOffice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class GenerateSchedulePage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(GenerateSchedulePage.class.getName());

	public GenerateSchedulePage(TTWebsiteDriver driver) {
		super(driver);
	}


	private final By SEARCH_BUTTON = By.xpath("//div[@class='user_sp_menu']//i[@class='fa fa-search']");
	private final By PLEASE_SELECT_SPECIALIZATION_MESSAGE = By.xpath("//p[contains(text(),'Please Select Speclization')]");
	private final By PLUS_BUTTON = By.xpath("//i[@class='fa fa-plus']");
	private final By PLEASE_SELECT_SPECIALITY_MESSAGE = By.xpath("//p[contains(text(),'Please select speciality/doctor or equipment!')]");
	private final By SPECIALIZATION_DROPDOWN = By.xpath("//select[@id='drpSpecilization']");
	private final By DOCTOR_DROPDOWN = By.xpath("//select[@id='drpdoctorname']");
	private final By NO_SCHEDULE_EXIST_MESSAGE = By.xpath("//p[contains(text(),'No schedule exists!')]");
	private final By FACILITY_DROPDOWN = By.xpath("//select[@name='Facility']");
	private final By FROM_DATE_TEXT_BOX = By.xpath("//input[@id='txtfrmdate']");
	private final By FROM_DATE_MESSAGE = By.xpath("//p[contains(text(),'FROM DATE cannot be less than current date!')]");
	private final By TO_DATE_TEXT_BOX = By.xpath("//input[@id='txtTodate']");
	private final By TO_DATE_MESSAGE = By.xpath("//p[contains(text(),'TO DATE cannot be less than current date!')]");
	private final By FROM_TIME_SITTING_1 = By.xpath("//select[@id='sitting1fromtime']");
	private final By TO_TIME_SITTING_1 = By.xpath("//select[@id='sitting1totime']");
	private final By RIGHT_CHECKBOX_SITTING_1 = By.xpath("//div[@class='span-sitting1']//i[@title='Ok']");
	private final By RIGHT_CHECKBOX_SITTING_2 = By.xpath("//div[@class='span-sitting2']//i[@title='Ok']");
	private final By FROM_TIME_SITTING_2 = By.xpath("//select[@id='sitting2fromtime']");
	private final By TO_TIME_SITTING_2 = By.xpath("//select[@id='sitting2totime']");
	private final By SAVE_BUTTON_HEADER = By.xpath("//a[@id='btnSave']//i[@class='fa fa-save']");
	private final By SAVE_POPUP_MESSAGE = By.xpath("//section[@class='popupBody_validation']");
	private final By YES_BUTTON_SAVE_POPUP = By.xpath("//a[@id='btnyes']");
	private final By SAVE_SUCCESSFULLY_MESSAGE = By.xpath("//p[contains(text(),'Saved successfully!')]");
	private final By EQUIPMENT_EDIT_BTN=By.xpath("//a[@id='opbilldiagnostic']//h4");
	
	public void clickOnSearchButton() {
		WebElement element = driver.findElement(SEARCH_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Search Button Clicked");
	}

	public boolean verifyPleaseSelectSpecilizationMessage() {
		return driver.isElementPresent(PLEASE_SELECT_SPECIALIZATION_MESSAGE);
	}

	public void clickOnPlusButton() {
		WebElement element = driver.findElement(PLUS_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Plus Button Clicked");
	}

	public boolean verifyPleaseSelectSpecialityMessage() {
		return driver.isElementPresent(PLEASE_SELECT_SPECIALITY_MESSAGE);
	}

	public void selectSpecilizationFromDropdown(String specialization) {
		driver.waitForElementPresent(SPECIALIZATION_DROPDOWN);
		Select specDropdown = new Select(driver.findElement(SPECIALIZATION_DROPDOWN));
		specDropdown.selectByVisibleText(specialization);
		logger.info("Following specialization  has been selected from specialization Dropdown : " + specialization);
	}
	public void selectDoctorFromDropdown(String doctor) {
		//driver.waitForElementPresent(DOCTOR_DROPDOWN);
		Select doctorDorpdown = new Select(driver.findElement(DOCTOR_DROPDOWN));
		doctorDorpdown.selectByVisibleText(doctor);
		logger.info("Following doctor  has been selected from doctor Dropdown : " + doctor);
	}

	public boolean verifyNoScheduleExistMessage() {
		return driver.isElementPresent(NO_SCHEDULE_EXIST_MESSAGE);
	}

	public void selectFacilityFromDropdown(String facility) {
		//driver.waitForElementPresent(FACILITY_DROPDOWN);
		Select facilityDropdown = new Select(driver.findElement(FACILITY_DROPDOWN));
		facilityDropdown.selectByVisibleText(facility);
		logger.info("Following facility  has been selected from facility Dropdown : " + facility);
	}

	public void selectGenerateScheduledropdown(String facility) 
	{
		///driver.waitForElementPresent(By.xpath("//div[@class='form_line generate_facility']//select[@name='Facility']"));
		Select facilityDropdown = new Select(driver.findElement(By.xpath("//div[@class='form_line generate_facility']//select[@name='Facility']")));
		facilityDropdown.selectByVisibleText(facility);
		logger.info("Following facility  has been selected from facility Dropdown : " + facility);
	}

	public void enterFromDate(String date) {
		driver.findElement(FROM_DATE_TEXT_BOX).clear();
		driver.findElement(FROM_DATE_TEXT_BOX).sendKeys(date);
		//driver.pauseExecutionFor(2000);
		logger.info("Following Date  has been added in From Date Textbox : " + date);
	}

	public boolean verifyFromDateErrorMessage() {
		return driver.isElementPresent(FROM_DATE_MESSAGE);
	}

	public void enterToDate(String date) {
		driver.findElement(TO_DATE_TEXT_BOX).clear();
		driver.findElement(TO_DATE_TEXT_BOX).sendKeys(date);
		//driver.pauseExecutionFor(2000);
		logger.info("Following Date  has been added in To Date Textbox : " + date);
	}

	public boolean verifyToDateErrorMessage() {
		return driver.isElementPresent(TO_DATE_MESSAGE);
	}

	public void selectFromTimeForSitting1(String fromTime) {
		//driver.waitForElementPresent(FROM_TIME_SITTING_1);
		Select fromTimeDropdown = new Select(driver.findElement(FROM_TIME_SITTING_1));
		fromTimeDropdown.selectByVisibleText(fromTime);
		logger.info("Following From Time  has been selected from From Time Dropdown for Sitting 1 : " + fromTime);
	}

	public void selectToTimeForSitting1(String toTime) {
		//driver.waitForElementPresent(TO_TIME_SITTING_1);
		Select toTimeDropdown = new Select(driver.findElement(TO_TIME_SITTING_1));
		toTimeDropdown.selectByVisibleText(toTime);
		logger.info("Following To Time  has been selected from To Time Dropdown for Sitting 1 : " + toTime);
	}

	public void selectDayCheckbox(String day) throws InterruptedException {
		try {
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath("//td[contains(text(),'"+day+"')]//preceding::td[1]/input"));
			driver.clickByJS(TTWebsiteDriver.driver, element);
		}
		catch (Exception e) {}
	}

	public void selectRightCheckForSitting1()
	{
		driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(RIGHT_CHECKBOX_SITTING_1));
		logger.info("Right Check clicked For Sitting 1");
	}

	public void selectRightCheckForSitting2(){
		driver.findElement(RIGHT_CHECKBOX_SITTING_2).click();
		logger.info("Right Check clicked For Sitting 2");
	}


	public void enterRemarksForCurrentDayForSitting1(String remarks, String currentDay) throws InterruptedException {
		////driver.pauseExecutionFor(7000);
		driver.findElement(By.xpath("(//td[contains(text(),'"+currentDay+"')]//following::td//input)[1]")).sendKeys(remarks);


	}

	public void selectFromTimeForSitting2(String fromTime) {
		///driver.waitForElementPresent(FROM_TIME_SITTING_2, 120);
		Select fromTimeDropdown = new Select(driver.findElement(FROM_TIME_SITTING_2));
		fromTimeDropdown.selectByVisibleText(fromTime);
		logger.info("Following From Time  has been selected from From Time Dropdown for Sitting 2 : " + fromTime);
	}

	public void selectToTimeForSitting2(String toTime) {
		///driver.waitForElementPresent(TO_TIME_SITTING_2);
		Select toTimeDropdown = new Select(driver.findElement(TO_TIME_SITTING_2));
		toTimeDropdown.selectByVisibleText(toTime);
		logger.info("Following To Time  has been selected from To Time Dropdown for Sitting 2 : " + toTime);
	}

	public void enterRemarksForCurrentDayForSitting2(String remarks, String currentDay) 
	{
		///driver.pauseExecutionFor(7000);
		driver.findElement(By.xpath("(//td[contains(text(),'"+currentDay+"')]//following::td//input)[2]")).sendKeys(remarks);
	}

	public void clickOnSaveButtonOnHeader() throws InterruptedException {
		//Thread.sleep(5000);
		WebElement HEADER = driver.findElement(SAVE_BUTTON_HEADER);
		driver.clickByJS(TTWebsiteDriver.driver, HEADER);
		logger.info("Save button on header clicked");
	}

	public boolean verifyDoYouWantToSavePopupMessage(String message) {
		if(driver.findElement(SAVE_POPUP_MESSAGE).getText().contains(message)) {
			return true;
		}
		else {
			return false;
		}
	}

	public void clickOnSaveButtonOnSavePopup() {
		driver.findElement(YES_BUTTON_SAVE_POPUP).click();
		logger.info("Save Button on Save Popup Clicked");
	}

	public boolean isSaveSuccessfullyMessageShowsUp() {
		return driver.isElementPresent(SAVE_SUCCESSFULLY_MESSAGE);
	}

	public void selectspecility(String text) 
	{
		Select sl =new Select(driver.findElement(By.xpath("//select[@id='Speciality']")));
		sl.selectByVisibleText(text);
		logger.info("Specility of the doctor is selected: "+text);
	}

	public void selectEquipmentTab(ExtentTest test) {
		WebElement equiptab = driver.findElement(EQUIPMENT_EDIT_BTN);
		driver.clickByJS(TTWebsiteDriver.driver, equiptab);
		logger.info("Click On Equipment Tab Btn");
		Markup m=MarkupHelper.createLabel("Click on Equipment Schedule", ExtentColor.GREEN);
		test.info(m);
	}

	public void selectEquipment(ExtentTest test,String text)
	{
		TTWebsiteDriver.selectclass(test, "Equipment", "drpequipment", text);
	}
}
