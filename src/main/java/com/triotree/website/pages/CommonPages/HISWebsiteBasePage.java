package com.triotree.website.pages.CommonPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.utils.PropertyFile;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;
import com.triotree.pages.TTBasePage;

public class HISWebsiteBasePage extends TTBasePage{
	
	private final By MENU = By.xpath("//i[@class='fa fa-bars']");
	private final By BARS_MENU = By.xpath("//i[@class='fa fa-bars']");
	private final By HOME_ICON = By.xpath("//a[contains(text(),'HOME')]");

	//private final By ADD_PATIENT_FROM_MENU = By.xpath("//body[@id='body_clickable']/nav[@id='menu']/ul/li[@id='FOAddPatientMenu']/a[1]");

	private static final Logger logger = LogManager
			.getLogger(HISWebsiteBasePage.class.getName());
	
	
	protected TTWebsiteDriver driver;
	public HISWebsiteBasePage(TTWebsiteDriver driver){		
		super(driver);
		this.driver = driver;
	}

	protected PropertyFile propertyFile = new PropertyFile();
	
	
	//This Class will contain all the common methods of all the Pages
	public void clickOnSaveButton() {
		
	}
	
	public void clickOnMenu() throws InterruptedException {
		driver.waitForElementPresent(MENU);
		driver.click(MENU);
		logger.info("Menu Clicked");
		Thread.sleep(4000);
	}
	
	public void clickOnHomeIcon() {
		driver.waitForElementPresent(HOME_ICON);
		driver.click(HOME_ICON);
		logger.info("HOME ICON Clicked");
	}
	
	public void expandMenu() {
		driver.waitForElementPresent(BARS_MENU);
		driver.click(BARS_MENU);
		logger.info("Menu Expanded");
	}
	
	public boolean verifyActionMessage(String message) {
		driver.waitForElementToBeVisible(By.xpath("//p[contains(text(),'"+message+"')]"), 45);
		driver.waitForElementPresent(By.xpath("//p[contains(text(),'"+message+"')]"));
		if (driver.findElement(By.xpath("//p[contains(text(),'"+message+"')]")).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}

