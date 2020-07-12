package com.triotree.website.pages.Physician;

import java.util.List;
import java.util.StringTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.utils.PropertyFile;
import com.triotree.website.pages.CommonPages.HISHomePage;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

import javafx.css.converter.ColorConverter;
import javafx.scene.control.ColorPicker;




public class PhysicianOPDcaseSheetOrders extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(HISHomePage.class.getName());

	private final By STATION_DROPDOWN = By.id("Department"); 
	private final By YES_STATION_DROPDOWN = By.id("btn_yes_desh");
	private final By OutPatients=By.id("outpatients");
	private final By Heading=By.xpath("//div[@class='modal_sub_title']");
	private final By Doctor=By.id("doctorsId");
	private final By View=By.id("view_type");
	private final By From_Date=By.id("FromDate");
	private final By Search_Button=By.id("search_data");
	private final By Patient=By.xpath("(//div[@id='op_queue']//div[@id])[1]");
	private final By Order=By.xpath("//div[@id='ordersopphycomp']");
	//private final By Favourites=By.xpath("//li[text()='Favourites']");

	public PhysicianOPDcaseSheetOrders(TTWebsiteDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void selectStationAndClickOnYes(ExtentTest test,String station) throws InterruptedException {
		try {
			Select stationDropDown = new Select(driver.findElement(STATION_DROPDOWN));
			Thread.sleep(2000);		
			stationDropDown.selectByVisibleText(station);
			Markup m=MarkupHelper.createLabel("Following Station has been selected from Station Dropdown : " + station, ExtentColor.GREEN);
			test.info(m);
			logger.info("Following Station has been selected from Station Dropdown : " + station);
		}
		catch (Exception e) {
			Markup m=MarkupHelper.createLabel("Following Station has been not selected from Station Dropdown : " + station, ExtentColor.RED);
			test.info(m);
		}
		try {
			driver.click(YES_STATION_DROPDOWN);
			logger.info("YES has been clicked from Station Dropdown");
			Markup m=MarkupHelper.createLabel("YES has been clicked from Station Dropdown", ExtentColor.GREEN);
			test.info(m);
		}
		catch (Exception e) {
			Markup m=MarkupHelper.createLabel("YES has been not clicked from Station Dropdown", ExtentColor.RED);
			test.info(m);
		}

	}

	public void clickonOutPatient() {
		WebElement outpatient_element = driver.findElement(OutPatients);
		driver.clickByJS(TTWebsiteDriver.driver, outpatient_element);
		logger.info("Click on OutPatient");
	}

	public void getHeading() {
		String heading = driver.findElement(Heading).getText();
		logger.info("Page Heading Name= "+heading);
	}

	public void verifyselectedDoctorName() {
		Select sl=new Select(driver.findElement(Doctor));

		logger.info("Doctor Name= "+sl.getFirstSelectedOption().getText());
	}

	public void verifyselectedView() 
	{
		Select sl=new Select(driver.findElement(View));

		logger.info("View= "+sl.getFirstSelectedOption().getText());
	}

	public void enterFromDate(String date) {
		driver.findElement(From_Date).clear();
		driver.findElement(From_Date).sendKeys(date);
		driver.findElement(From_Date).sendKeys(Keys.ENTER);
		logger.info("Frome Date= "+date);
	}

	public void clickonSearchButton() throws InterruptedException {
		WebElement search_element = driver.findElement(Search_Button);
		driver.clickByJS(TTWebsiteDriver.driver, search_element);
		logger.info("Click on Search Button");
		Thread.sleep(3000);
	}

	public void clickonPatient() {
		WebElement patient_element = driver.findElement(Patient);
		driver.clickByJS(TTWebsiteDriver.driver, patient_element);
		logger.info("Click on Patient");
	}

	public void clickonOrder() {
		WebElement order_element = driver.findElement(Order);
		driver.clickByJS(TTWebsiteDriver.driver, order_element);
		logger.info("Click on Order Tab");
	}

	public void verifyselectedTab() {
		List<WebElement> tab_list = driver.findElements(By.xpath("//div[@id='horizontalTab1']//ul[@class='resp-tabs-list']//li[text()]"));
		for(int i=1;i<=tab_list.size();i++)
		{
			String color =driver.findElement(By.xpath("(//div[@id='horizontalTab1']//ul[@class='resp-tabs-list']//li[text()])["+i+"]")).getCssValue("background");
			String []split=color.split("none");
			String[] numbers = split[0].replace("rgb(", "").replace(")", "").split(",");
			int r = Integer.parseInt(numbers[0].trim());
			int g = Integer.parseInt(numbers[1].trim());
			int b = Integer.parseInt(numbers[2].trim());
			String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
			//String code = Color.fromString(color).asRgba();
			if(hex.equals("#16bcc0")) {
				String selected_Tab = driver.findElement(By.xpath("(//div[@id='horizontalTab1']//ul[@class='resp-tabs-list']//li[text()])["+i+"]")).getText();
				logger.info("Selected TAB Name= "+selected_Tab);
			}
		}
	}

	public void verifyreflectedservices() 
	{
		List<WebElement> refletedservices_list = driver.findElements(By.xpath("//div[@class='resp-tab-content resp-tab-content-active']//label//strong"));
		for(int i=1;i<=refletedservices_list.size();i++) 
		{
			String refletedservices_name = driver.findElement(By.xpath("(//div[@class='resp-tab-content resp-tab-content-active']//label//strong)["+i+"]")).getText();

			String chief_complaint_name = driver.findElement(By.xpath("//div[@class='resp-tab-content resp-tab-content-active']//label//strong[text()='"+refletedservices_name+"']/..//following-sibling::ul//span")).getText();
//driver.findElement(By.)
			logger.info("Reflected Services Name= "+refletedservices_name+" and Chief Complaint Name= "+chief_complaint_name);
		}
	}
}
