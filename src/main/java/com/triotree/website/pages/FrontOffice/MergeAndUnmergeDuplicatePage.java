package com.triotree.website.pages.FrontOffice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class MergeAndUnmergeDuplicatePage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(MergeAndUnmergeDuplicatePage.class.getName());

	public MergeAndUnmergeDuplicatePage(TTWebsiteDriver driver) {
		super(driver);
	}
	
	private final By FIRST_NAME = By.id("firstaname_mearge");
	private final By PLEASE_FILL_DETAIL_MESSAGE = By.xpath("//p[contains(text(),'Please fill atleast one detail')]");
	private final By FIRST_PRIMARY_CHECKBOX = By.xpath("//input[@id='checkBox_primary0']");
	private final By SECOND_PRIMARY_CHECKBOX = By.xpath("//input[@id='checkBox_primary1']");
	private final By MERGE_BUTTON = By.xpath("//a[@id='save_merge']//i[@class='fa fa-male']");
	private final By SELECT_UHID_ALERT_MESSAGE = By.xpath("//p[contains(text(),'Please Select UHID')]");
	private final By SELECTED_UHID_MERGED_MESSAGE = By.xpath("//p[contains(text(),'Selected UHID have been merged with')]");
	
	
	//UNMERGED SCREEN LOCATORS BELOW
	private final By FIRST_SECONDARY_PATIENT_ID = By.xpath("//td[@id='likedid0']");
	private final By FIRST_RESULT_CHECKBOX = By.xpath("//input[@id='checkBox_selection0']");
	private final By UNMERGE_BUTTON  = By.xpath("//a[@id='save_unmerge']//i[@class='fa fa-male']");
	
	public void enterFirstNameAndPressEnter(String firstName) {
		driver.waitForElementPresent(FIRST_NAME);
		driver.findElement(FIRST_NAME).sendKeys(firstName);
		driver.findElement(FIRST_NAME).sendKeys(Keys.ENTER);;
		logger.info("Following First Name has been added "+firstName);
	}

	public boolean verifyPleaseFillDetailMessage(String message) throws InterruptedException{
		if(driver.findElement(PLEASE_FILL_DETAIL_MESSAGE).getText().contains(message))
		{
			logger.info("When User is entering no Data and clicking on Enter then Please fill Details message is displaying");
			return true;
		}
		else{
			return false;
		}
	}
	
	public void selectFirstPrimaryCheckBox() {
		driver.waitForElementPresent(FIRST_PRIMARY_CHECKBOX);
		WebElement checkbox = driver.findElement(FIRST_PRIMARY_CHECKBOX);
		driver.clickByJS(TTWebsiteDriver.driver, checkbox);
		logger.info("First primary checkbox checked");
	}
	
	public void selectSecondPrimaryCheckBox() {
		driver.waitForElementPresent(SECOND_PRIMARY_CHECKBOX);
		WebElement checkbox = driver.findElement(SECOND_PRIMARY_CHECKBOX);
		driver.clickByJS(TTWebsiteDriver.driver, checkbox);
		logger.info("Second primary checkbox checked");
	}
	
	public void clickOnMergeButton() {
		
		WebElement MERGE_BUTT = driver.findElement(MERGE_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, MERGE_BUTT);
		logger.info("Merge Button Clicked");
	}
	
	
	public boolean selectUHIDAlertMessage(String message) throws InterruptedException{
		if(driver.findElement(SELECT_UHID_ALERT_MESSAGE).getText().contains(message))
		{
			logger.info("SELECT UHID ALERT MESSAGE is Displaying");
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean verifyUHIDMergedMessage(String message) throws InterruptedException{
		if(driver.findElement(SELECTED_UHID_MERGED_MESSAGE).getText().contains(message))
		{
			logger.info("UHID Merged Message Is Present");
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getMergedUHID() {
		String message = driver.findElement(SELECTED_UHID_MERGED_MESSAGE).getText();
		String [] message1= message.split("with");
		String uhid1 = message1[1];
		logger.info("Merged UHID Is  "+uhid1);
		System.out.println("Merged UHID Is  "+uhid1);
		return uhid1;
	}
	//////Issue
	
	public String getTheFirstSecondaryId() {
		String secondaryId = driver.findElement(FIRST_SECONDARY_PATIENT_ID).getText();
		logger.info("Secindary Patient UHID Is  "+secondaryId);
		return secondaryId;
	}
	
	public void selectFirstResultCheckbox() {
		driver.waitForElementPresent(FIRST_RESULT_CHECKBOX);
		driver.click(FIRST_RESULT_CHECKBOX);
		logger.info("First result Checkbox Checked");
	}
	
	public void clickOnUnmergeButton() {
		driver.click(UNMERGE_BUTTON);
		logger.info("Unmerge Button Clicked");
	}
	
	public void checkPrimaryRadioButtonForSpecificPatient(String patient) {
		driver.isElementPresent(By.xpath("//td[contains(text(),'"+patient+"')]//preceding::input[@type='radio'][1]"),10);
		((JavascriptExecutor)TTWebsiteDriver.driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//td[contains(text(),'"+patient+"')]//preceding::input[@type='radio'][1]"))); 
		WebElement checkPrimaryRadioButton_element = driver.findElement(By.xpath("//td[contains(text(),'"+patient+"')]//preceding::input[@type='radio'][1]"));
		driver.clickByJS(TTWebsiteDriver.driver, checkPrimaryRadioButton_element);
		
	}
	
	public void checkSelectCheckBoxForSpecificPatient(String patient) {
		driver.isElementPresent(By.xpath("//td[contains(text(),'"+patient+"')]//preceding::input[@type='checkbox'][1]"),10);
		((JavascriptExecutor)TTWebsiteDriver.driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//td[contains(text(),'"+patient+"')]//preceding::input[@type='checkbox'][1]")));
		WebElement checkSelectCheckBox_element = driver.findElement(By.xpath("//td[contains(text(),'"+patient+"')]//preceding::input[@type='checkbox'][1]"));
		driver.clickByJS(TTWebsiteDriver.driver, checkSelectCheckBox_element);
	}
	
	public String getFirstPatientNameFromResult() {
		return driver.findElement(By.xpath("//td[@id='maxid0']")).getText();
	}
	
	public String getSecondPatientNameFromResult() {
		return driver.findElement(By.xpath("//td[@id='maxid1']")).getText();
	}
}
