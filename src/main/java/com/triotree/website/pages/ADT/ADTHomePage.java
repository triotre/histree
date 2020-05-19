package com.triotree.website.pages.ADT;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class ADTHomePage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(ADTHomePage.class.getName());

	public ADTHomePage(TTWebsiteDriver driver) {
		super(driver);
	}


	private final By ADMIT_PATIENT_SECTION = By.xpath("//li[@id='FOAddPatientMenu']//i[@class='fa fa-caret-down']");
	private final By UHID_SEARCH_BOX = By.id("uhid_admimitPatient");


	public void clickOnAdmitPatientAndSelectAdmitPatient() throws InterruptedException {
		driver.waitForElementPresent(ADMIT_PATIENT_SECTION);
		driver.click(ADMIT_PATIENT_SECTION);
		logger.info("Admit Patient Section is Expanded");

		WebElement options = driver.findElement(By.xpath("//a[@href='/histree/ADT/AdmitPatient/AdmitPatient']"));
		options.click();
		logger.info("Admit Patient Option has been selected from Admit Patient Section");
		driver.waitForPageLoad();
		Thread.sleep(18000);
	}
	
	public void enterUHIDInSearchBox(String uhid) {
		driver.waitForElementPresent(UHID_SEARCH_BOX);
		driver.findElement(UHID_SEARCH_BOX).clear();
		driver.findElement(UHID_SEARCH_BOX).sendKeys(uhid);
		driver.findElement(UHID_SEARCH_BOX).sendKeys(Keys.RETURN);
		logger.info("Following UHID has been added to the UHID Search Box " +uhid);
	}
}
