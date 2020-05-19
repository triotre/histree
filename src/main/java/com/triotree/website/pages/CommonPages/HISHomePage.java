package com.triotree.website.pages.CommonPages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.triotree.driver.TTDriver;
import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISHomePage;

public class HISHomePage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(HISHomePage.class.getName());

	private final By USERNAME = By.id("txtLoginName");
	private final By PASSWORD = By.id("txtPassword");
	private final By LOGIN_BTN = By.id("btnLogin");
	private final By FRONT_OFFICE_ICON = By.xpath("//span[contains(text(),'Front Office')]//ancestor::a"); // change by Nishant
	private final By MIS_REPORT_ICON = By.xpath("//li[@id='btn_MIS']//div/span");
	private final By INVENTORY_ICON = By.xpath("//span[@class='app_name' and contains(text(),'Inventory')]//preceding::span[1]");
	private final By STATION_DROPDOWN = By.id("Department"); 
	private final By NO_STATION_DROPDOWN = By.id("btn_no_desh");
	private final By YES_STATION_DROPDOWN = By.id("btn_yes_desh");
	private final By ADT_ICON = By.xpath("//li[@id='btn_adt']//span[@class='image_hover']//a[@href='javascript:void(0);']//div");
	private final By LOGIN_ALERT_POPUP = By.xpath("//div[3]//div[1]//header[1]");
	private final By YES_BTN_LOGIN_ALERT = By.xpath("//a[@id='btnYesAlreadyLogedinPopup']");
	private final By USER_ICON_ON_TOPRIGHT = By.xpath("//a[@id='user']//i[@class='fa fa-user']");
	private final By LOGOUT_BUTTON = By.xpath("//a[@id='login_form']");


	public HISHomePage(TTWebsiteDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub

	}

public void logOutFromApplication() {
	WebElement element = driver.findElement(USER_ICON_ON_TOPRIGHT);
	Actions action = new Actions(TTWebsiteDriver.driver);
	action.moveToElement(element).build().perform();
	driver.waitForElementPresent(LOGOUT_BUTTON);
	driver.click(LOGOUT_BUTTON);
	logger.info("User has been logged Out From  HIS Portal");
}
	
	public void loginToTriotreeHIS() {
		driver.findElement(USERNAME).sendKeys(propertyFile.getProperty("userName"));
		driver.findElement(PASSWORD).sendKeys(propertyFile.getProperty("password"));
		driver.click(LOGIN_BTN);
		try {
			if(driver.findElement(LOGIN_ALERT_POPUP).isDisplayed()==true) {
				driver.click(YES_BTN_LOGIN_ALERT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * try {
		 * if(driver.findElement(By.xpath("//a[@id='btnNoChangePass']")).isDisplayed()==
		 * true) { driver.click(By.xpath("//a[@id='btnNoChangePass']")); } } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
		logger.info("User has been logged in to HIS Portal");
	}

	public boolean verifyClientLogoisDisplayed(){
		driver.waitForPageLoad();
		driver.waitForElementPresent(By.xpath("//img[@class='img-responsive']"));
		logger.info("Client Logo is Displayed");
		return driver.isElementPresent(By.xpath("//img[@class='img-responsive']"));
	}

	public void clickOnFronOfficeIcon() {
		driver.waitForElementPresent(FRONT_OFFICE_ICON);
		
		Select stationDropDown = new Select(driver.findElement(By.xpath("//select[@id='Facility']")));
		stationDropDown.selectByVisibleText("TRIOTREE HOSPITAL");
		
		WebElement element = driver.findElement(FRONT_OFFICE_ICON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Front Office Icon Clicked");
	}
	
	
	public void clickOnMISReportIcon() {
		driver.waitForElementPresent(MIS_REPORT_ICON);
		
		Select stationDropDown = new Select(driver.findElement(By.xpath("//select[@id='Facility']")));
		stationDropDown.selectByVisibleText("TRIOTREE HOSPITAL");
		
		WebElement element = driver.findElement(MIS_REPORT_ICON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("MIS Report Icon Clicked");
	}
	
	
	public void clickOnInventoryIcon() {
		driver.waitForElementPresent(INVENTORY_ICON);
		
		Select stationDropDown = new Select(driver.findElement(By.xpath("//select[@id='Facility']")));
		stationDropDown.selectByVisibleText("TRIOTREE HOSPITAL");
		
		WebElement element = driver.findElement(INVENTORY_ICON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Inventory Icon Clicked");
	}
	
	public void clickOnADTIcon() {
		driver.waitForElementPresent(ADT_ICON);
		driver.findElement(ADT_ICON);
		WebElement element = driver.findElement(ADT_ICON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("ADT Icon Clicked");
	}

	public void selectStationAndClickOnNo(String station) {
		Select stationDropDown = new Select(driver.findElement(STATION_DROPDOWN));
		stationDropDown.selectByVisibleText(station);
		logger.info("Following Station has been selected from Station Dropdown : " + station);
		driver.click(NO_STATION_DROPDOWN);
		logger.info("NO has been clicked from Station Dropdown");

	}
	
	public void selectStationAndClickOnYes(String station) {
	//	driver.waitForElementNotPresent(STATION_DROPDOWN);
		Select stationDropDown = new Select(driver.findElement(STATION_DROPDOWN));
		driver.pauseExecutionFor(4000);
		stationDropDown.selectByVisibleText(station);
		logger.info("Following Station has been selected from Station Dropdown : " + station);
		driver.click(YES_STATION_DROPDOWN);
		logger.info("YES has been clicked from Station Dropdown");

	}
	

}
