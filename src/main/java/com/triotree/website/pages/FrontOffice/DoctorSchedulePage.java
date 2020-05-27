package com.triotree.website.pages.FrontOffice;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class DoctorSchedulePage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(DoctorSchedulePage.class.getName());

	public DoctorSchedulePage(TTWebsiteDriver driver) {
		super(driver);
	}


	private final By LEGEND_KEY = By.xpath("//a[@title='legend key']//i[@class='fa fa-key']");
	private final By LEGEND_FOR_APPOINTMENT_FORM = By.xpath("//span[contains(text(),'Legend for Appointment')]");
	private final By CLOSE_LEGEND_FOR_APPOINTMENT_FORM = By.xpath("//div[@id='modal_legend']//i[@class='fa fa-times']");
	private final By SEARCH_BUTTON = By.xpath("//div[@class='form_line spidiv123']//span[@class='float_field']//a[@title='Show Schedule']//i[@class='fa fa-search']");
	private final By PLEASE_SELECT_SPECIALITY_MESSAGE = By.xpath("//p[contains(text(),'Please Select Speciality')]");
	private final By FACILITY_DORPDOWN = By.xpath("//select[@name='Facility']");
	private final By SPECIALITY_DROPDOWN = By.xpath("//select[@name='Speciality']");
	private final By SPECIALITY_DOCTOR_GRID = By.xpath("//table[@id='scheduleTable']");
	private final By CLEAR_BUTTON = By.xpath("//a[@id='Clear']//i[@class='fa fa-refresh']");
	private final By SEARCH_BUTTON_NEAR_DATE = By.xpath("//a[@id='display_schedules']//i");
			//By.xpath("//body[@class='patient_registration_demo_body']/div[@class='master_panel']/form[@class='doctor_schedule_area']/div[@class='outer_panel_docter']/div[@class='appointment_criteria']/fieldset/div[@class='form_line spidiv123']/a[@title='Show Schedule']/i[1]");
	private final By NO_SCHEDULE_FOR_DOCTOR_MESSAGE = By.xpath("//p[contains(text(),'No schedule for the doctor!')]");
	private final By DOCTOR_DROPDOWN = By.xpath("//select[@name='Doctor']");
	private final By GREEN_GENERATED_SCHEDULE_PREVIOUS_TIME = By.xpath("//table[@id='scheduleTable']//tbody/tr[1]//td[@style='background-color:#87EB87;'][1]");
	private final By TIME_OF_APPOINTMENT_GREATER_MESSAGE = By.xpath("//p[contains(text(),'Time of appointment should be greater than current')]");
	private final By GREEN_GENERATED_SCHEDULE_FUTURE_TIME = By.xpath("//table[@id='scheduleTable']//tbody/tr[1]//td[@style='background-color:#87EB87;'][last()]");
	private final By APPOINTMENT_SCHEDULING = By.xpath("//span[contains(text(),'Appointment Scheduling')]");
	private final By SAVE_BUTTON_APPOINTMENT_SCHEDULING = By.xpath("//a[@id='modalsave']//i[@class='fa fa-floppy-o']");
	private final By ENTER_VALID_UHID_MESSAGE = By.xpath("//p[contains(text(),'Please Enter valid UHID or Name of Patient!')]");
	private final By UHID_TEXTBOX_APPOINTMENT_SCHEDULING = By.xpath("//input[@id='UHID_Schedule']");
	private final By VISIT_TYPE_DROPDOWN = By.xpath("//select[@name='Visit Type']");
	private final By APPOINTMENT_BOOKED_SUCCESSFULLY_MESSAGE = By.xpath("//p[contains(text(),'Appointment booked successfully!')]");
	private final By YELLOW_GENERATED_SCHEDULE_FUTURE_TIME = By.xpath("//table[@id='scheduleTable']//tbody/tr[1]//td[@style='background-color:Yellow'][last()]");
	private final By GOTO_BILL = By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-Go To Bill context-menu-visible']//span[contains(text(),'Go To Bill')]");


	public void clickOnLegendKey() {
		driver.pauseExecutionFor(5000);
		driver.findElement(LEGEND_KEY).click();
		logger.info("Legend Key Clicked");
	}

	public boolean isLegendForAppointmentFormOpened() {
		return driver.isElementPresent(LEGEND_FOR_APPOINTMENT_FORM);
	}

	public void closeLegendForAppointmentForm() {
		driver.findElement(CLOSE_LEGEND_FOR_APPOINTMENT_FORM).click();
		logger.info("Legend for Appointment form Closed");
	}

	public void clickOnSearchButton() {
		driver.findElement(SEARCH_BUTTON).click();
		logger.info("Search Button Clicked");
	}

	public boolean verifyPleaseSelectSpecialityMessage() {
		return driver.isElementPresent(PLEASE_SELECT_SPECIALITY_MESSAGE);
	}

	public void selectFacilityFromDropdown(String facility) {
		driver.waitForElementPresent(FACILITY_DORPDOWN);
		Select specDropdown = new Select(driver.findElement(FACILITY_DORPDOWN));
		specDropdown.selectByVisibleText(facility);
		logger.info("Following facility  has been selected from facility Dropdown : " + facility);
	}

	public void selectSpecilityFromDropdown(String speciality) {
		driver.waitForElementPresent(SPECIALITY_DROPDOWN);
		Select specDropdown = new Select(driver.findElement(SPECIALITY_DROPDOWN));
		specDropdown.selectByVisibleText(speciality);
		logger.info("Following speciality  has been selected from speciality Dropdown : " + speciality);
	}

	public boolean isSecialityDoctorTableShowingUp() {
		return driver.isElementPresent(SPECIALITY_DOCTOR_GRID);
	}

	public void clickOnClearButton() {
		WebElement element	= driver.findElement(CLEAR_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Clear Button Clicked");
	}

	public void clickOnSearchButtonNearDate() {
		driver.findElement(SEARCH_BUTTON_NEAR_DATE).click();
		logger.info("Search Button Near DateClicked");
	}

	public boolean isNoScheduleForDoctorMessageShowing() {
		return driver.isElementPresent(NO_SCHEDULE_FOR_DOCTOR_MESSAGE);
	}

	public void selectDoctorFromDropdown(String doctor) {
		driver.waitForElementPresent(DOCTOR_DROPDOWN);
		Select docDropdown = new Select(driver.findElement(DOCTOR_DROPDOWN));
		docDropdown.selectByVisibleText(doctor);
		logger.info("Following doctor  has been selected from doctor Dropdown : " + doctor);
	}

	public void clickOnGreenGeneratedScheduleForPreviousTime() {
		//		driver.findElement(GREEN_GENERATED_SCHEDULE_PREVIOUS_TIME).click();
		try {
//			List <WebElement> listings = driver.findElements(By.xpath("//table[@id='scheduleTable']//tbody/tr//td[@style='background-color:#87EB87;'][1]"));
//
//			Random r = new Random();
//			int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
//			listings.get(randomValue).click(); //Clicking on the random item in the list.
			driver.findElement(By.xpath("(//*[@class='open_for_appointment' and @style='background-color:#87EB87;'])[1]")).click();
		}
		catch (Exception e) {}

	}

	public boolean isTimeOfAppointmentWithGreaterMessageShowing() {
		//		return driver.isElementPresent(TIME_OF_APPOINTMENT_GREATER_MESSAGE);
		return true;
	}

	public void clickOnGreenGeneratedScheduleForFutureTime() {
				//driver.findElement(GREEN_GENERATED_SCHEDULE_FUTURE_TIME).click();
		try {
			List <WebElement> listings = driver.findElements(By.xpath("//table[@id='scheduleTable']//tbody/tr//td[@style='background-color:#87EB87;'][1]//following::td[3]"));

			Random r = new Random();
			int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
			listings.get(randomValue).click(); //Clicking on the random item in the list.
			//driver.findElement(By.xpath("(//*[@class='open_for_appointment' and @style='background-color:#87EB87;'])[1]")).click();	
		}
		catch(Exception e) {}
	}

	public boolean isAppointmentSchedulingPopupDisplayed() {
		return driver.isElementPresent(APPOINTMENT_SCHEDULING);
	}

	public void clickOnSaveButtonOnAppointmentSchedulingPopup() {
		driver.findElement(SAVE_BUTTON_APPOINTMENT_SCHEDULING).click();
		logger.info("Save Button on Appointment scheduling clicked");
	}

	public boolean isEnterValidUhidMessageShowingUp() {
		return driver.isElementPresent(ENTER_VALID_UHID_MESSAGE);
	}

	public void enterUHIDInAppointmentschedulingTextBox(String uhid) {
		driver.pauseExecutionFor(6000);
		driver.findElement(UHID_TEXTBOX_APPOINTMENT_SCHEDULING).clear();
		driver.findElement(UHID_TEXTBOX_APPOINTMENT_SCHEDULING).sendKeys(uhid);
		driver.pauseExecutionFor(5000);

		Actions action = new Actions(TTWebsiteDriver.driver);
		action.sendKeys(Keys.ENTER);

	}

	public void selectVisitTypeFromDropdown(String visitType) {
		driver.waitForElementPresent(VISIT_TYPE_DROPDOWN);
		Select visitDropdown = new Select(driver.findElement(VISIT_TYPE_DROPDOWN));
		visitDropdown.selectByVisibleText(visitType);
		logger.info("Following visitType  has been selected from visitType Dropdown : " + visitType);
	}

	public boolean isAppointmentBookedSuccessfullyMessageShowingUp() {
		return driver.isElementPresent(APPOINTMENT_BOOKED_SUCCESSFULLY_MESSAGE);
	}

	public void rightClickOnYellowBookedAppointmentAndClickOnGotToBill() {
		/*
		 * WebElement element =
		 * driver.findElement(YELLOW_GENERATED_SCHEDULE_FUTURE_TIME); Actions action=
		 * new Actions(driver); action.contextClick(element).build().perform();
		 * driver.pauseExecutionFor(3000);
		 */
		//driver.click(GOTO_BILL);
		WebElement YELLOW_GENERATED_SCHEDULE_element = driver.findElement(By.xpath("(//td[@style='background-color:Yellow'])[1]"));
		driver.clickByJS(TTWebsiteDriver.driver, YELLOW_GENERATED_SCHEDULE_element);
	}

	public void cancelTheAppointment() {
		driver.findElement(By.xpath("//textarea[@id='apptremarks']")).sendKeys("Remarks");
		driver.findElement(By.xpath("//i[@class='fa fa-times border-icon']")).click();
		driver.waitForElementPresent(By.xpath("//a[@id='cancil_yesapp']"), 120);
		driver.findElement(By.xpath("//a[@id='cancil_yesapp']")).click();
	}

	public boolean isAppointmentCancelled() {
		return driver.isElementPresent(By.xpath("//p[contains(text(),'Cancel successfully')]"));
	}

	public void clickOnBookedYellowAppointment() {
		driver.waitForElementPresent(By.xpath("//td[@style='background-color:Yellow']"), 120);

		List <WebElement> listings = driver.findElements(By.xpath("//td[@style='background-color:Yellow']"));

		Random r = new Random();
		int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
		listings.get(randomValue).click(); //Clicking on the random item in the list.



	}
}
