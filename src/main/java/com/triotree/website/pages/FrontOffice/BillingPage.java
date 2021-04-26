package com.triotree.website.pages.FrontOffice;

import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class BillingPage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(BillingPage.class.getName());

	public BillingPage(TTWebsiteDriver driver) {
		super(driver);
	}


	private final By ADD_PATIENT_SECTION = By.xpath("//li[@id='FOAddPatientMenu']//i[2]");
	private final By CLOSE_ICON_COMP_DETAIL_POPUP =By.xpath("//a[@id='cancelinsurance']//i[@class='fa fa-times']");
	private final By CLOSE_ICON_SCHEME_DETAILS_POPUP = By.xpath("//a[@id='schemeclose']//i[@class='fa fa-times']");
	private final By CLOSE_ICON_REMARKS_POPUP = By.xpath("//*[@id='remarks_close']//i[@class='fa fa-times']");
	private final By SPECIALITY_DROPDOWN = By.xpath("//select[@name='ddlspecialization']");
	private final By FIRST_DOCTOR_NAME = By.xpath("//ul[@class='doctor_list list_details']/li[1]");
	private final By SECOND_DOCTOR_NAME = By.xpath("//ul[@class='doctor_list list_details']/li[2]");
	private final By SEARCH_DOCTOR_TEXTBOX = By.id("autocomplete");
	private final By DIAGNOSTIC_ICON = By.id("opbilldiagnostic");
	private final By MANUAL_ICON = By.id("opbillmannual");
	private final By SERVICE_NAME_DROPDOWN = By.xpath("//select[@id='ddlService']");
	private final By VERIFY_BUTTON = By.id("new_manual_order");
	private final By SERVICE_ERROR_MESSAGE = By.xpath("//div[contains(@class,'gritter-without-image')]//p[1]");
	private final By DESCRIPTION_TEXT_BOX = By.xpath("//div[contains(@class,'select_manual')]//div[1]//span[2]//input[1]");
	private final By QUANTITY_TEXT_BOX = By.id("txtqnt");
	private final By PRICE_TEXT_BOX = By.id("txtprise");
	private final By OTHER_SERVICES_ICON = By.xpath("//h4[contains(@class,'fa fa-plus-square')]");
	private final By CHOOSE_SERVICES_CHECKBOX_IN_OTHER_SERVICES = By.xpath("//input[contains(@name,'otherServiceChk')]");
	private final By CHOOSE_SERVICES_DROPDOWN_IN_OTHER_SERVICES = By.id("ddotherservice");
	private final By REFFERED_BY_TEXTBOX_IN_OTHER_SERVICES = By.xpath("//input[contains(@name,'autocomplete_refby')]");
	private final By FACILITATOR_DROPDOWN = By.xpath("//div[contains(@class,'form_line facilitator-name')]//select");
	private final By PRICE_NOT_DEFINED_MESSAGE = By.xpath("//p[contains(text(),'Price not defined for this service')]");
	private final By SPECIALITY_DROPDOWN_TEST = By.xpath("//select[@id='ddlspec1']");
	private final By DOCTOR_NAME_TEST  = By.xpath("//select[@id='ddldoc1']");
	private final By ADD_TO_BILL_BUTTON = By.xpath("//a[@id='add_bill_visit']");
	private final By YES_BTN_BILL_GOT_GENERATED_POPUP=By.xpath("//a[@id='btnyesrep']"); //add by nishant
	private final By SCHEME_CHECKBOX_SCHEME_POPUP = By.xpath("//div[@class='scheme-details-popup']//section[@class='popupBody_payment']//form//div//input[@type='checkbox']");
	private final By INVESTIGATION_INSTRUCTION_POPUP = By.xpath("//span[contains(text(),'Investigation Instruction')]");
	private final By RESPONSE_TEXT_FIELD = By.xpath("//td[@ctype='IsMakeResponse']");
	private final By ADD_BTN_INVESTIGATION_INSTRUCTION_POPUP  = By.xpath("//button[@id='add_invInstruction']");
	private final By BILLING_BTN_HEADER = By.xpath("//a[@title='Billing']");
	private final By YES_BUTTON_GENERATE_BILL_POPUP = By.xpath("//a[@id='btnyesbal2']");
	private final By NO_BUTTON_GENERATE_BILL_POPUP = By.xpath("//a[@id='btnnobal2']");

	private final By PATIENT_PAID_AMOUNT_PROCESS_PAYMENT_POPUP = By.xpath("//input[@ctype='amount']");
	private final By NEW_MODE_BUTTON = By.xpath("//button[@id='new_payment_mode']");
	private final By SECOND_PAYMENT_MODE = By.xpath("//select[@id='paymentMode2']");
	private final By Frist_PAYMENT_MODE = By.xpath("//select[@id='paymentMode1']");
	private final By GENRATED_BILL_POPUP = By.xpath("//section[@id='report']");
	private final By COMP_TYPE_COMP_DETAILS_POPUP = By.xpath("//select[@id='company_type']");
	private final By COMPANY_COMP_DETAILS_POPUP = By.xpath("//select[@id='company']");
	private final By CORPORATE_COMP_DETAILS_POPUP = By.xpath("//select[@id='corporateCompany']");
	private final By RATE_CONTRACT_COMP_DETAILS_POPUP = By.xpath("//select[@id='rate_contract']");
	private final By STANDARD_DEDUCTABLE_COMP_DETAILS_POPUP = By.xpath("//input[@id='ci_deductible']");
	private final By STANDARD_CO_PAY_COMP_DETAILS_POPUP = By.xpath("//input[@id='ci_copay']");
	private final By PLUS_BUTTON_COMP_DETAILS_POPUP = By.xpath("//section[@class='popupBody_payment']//a[@title='Add']//i");
	private final By YES_BUTTON_CONFIRM_COMP_DETAILS = By.xpath("//div[@class='modal-block-new']//button[text()='Yes']");
	private final By AUTHORISED_BY_DROPDOWN_SCHEME_DETAIL_POPUP = By.xpath("//select[@name='ddlschemeauth']");
	private final By SCHEME_SCHEME_DETAIL_POPUP = By.xpath("//select[@id='ddlscheme']");
	private final By DAILY_DISCOUNT_LIMIT_POPUP = By.xpath("//p[contains(text(),'Daily discount limit for the patient in this schem')]");
	private final By NO_BTN_BILL_GOT_GENERATED_POPUP = By.xpath("//a[@id='btnnorep']");
	private final By PRINT_OPD_MESSAGE = By.xpath("//p[contains(text(),'Do you want to print OPD card!')]");
	private final By YES_BTN_OPD = By.xpath("//a[@id='btnyesopd']");
	private final By VISIT_TYPE_DROPDOWN = By.xpath("//select[@class='form-control consult_type']");
	private final By PHYSICIAN_ICON = By.xpath("//h4[@class='fa fa-medkit']");
	private final By SCHEME_FOR_PATIENT_POPUP = By.xpath("//span[contains(text(),'Schemes for Patient')]");
	private final By SAVE_BUTTON_DOCUMENT_CHECKLIST_POPUP = By.xpath("//div[@class='modal-block-new top30']//i[@class='fa fa-save']");
	private final By CLOSE_BUTTON_DOCUMENT_CHECKLIST_POPUP =By.xpath("//a[@id='modal_cancel']//i[@class='fa fa-times border-icon']");

	private final By CLOSE_BUTTON_DOCUMENT_CHECKLIST_POPUP1=By.xpath("//a[@id='_closelistpop']/i[@class='fa fa-times']");
	private final By MANDATORY_DOCUMENT_ERROR_MESSAGE = By.xpath("//p[contains(text(),'Please select mandatory document')]");
	private final By CASE_RECORD_CHECKBOX = By.xpath("//input[@id='_alldoccheck']");
	private final By PAN_CARD_CHECKBOX = By.xpath("//td[contains(text(),'PAN Card')]//following::input[1]");
	private final By FORM_60_CHECKBOX = By.xpath("//td[contains(text(),'Form 60')]//following::input[1]");
	private final By INSURANCE_COMPANY_BUTTON = By.xpath("//i[@class='fa fa-university fa-lg']");
	private final By INSURANCE_RADIO_BTN_ON_COMP_DETAILS = By.xpath("//input[@id='r_com_insurance']");
	private final By CHECK_SCHEME_CHECKBOX = By.xpath("//div[@class='scheme-details-popup']//section[@class='popupBody_payment']//form//div//input[@type='checkbox']");
	private final By OK_BTN_SCHEME_POPUP = By.xpath("//a[@title='OK']//i[@class='fa fa-check']");	
	private final By CANCEL_SCHEME_FOR_PATIENT = By.xpath("//a[@id='schemeRemarksPopupClose']");
	private final By DISCOUNT_CHECKBOX = By.xpath("//div[@class='bottom_left_panel']//span[contains(text(),'Discount')]/input");
	private final By YES_BTN_PROVIDE_DISCOUNT = By.xpath("//section[contains(text(),'Provide Discount ?')]//following::a[@id='btndscyes']");
	private final By PERCENTAGE_PROCESS_DISCOUNT_HEADER = By.xpath("//span[contains(text(),'Process Discounts')]");
	private final By YES_BTN_PERCENTAGE_PROCESS_DISCOUNT_POPUP = By.xpath("//section[@class='popupBody_discount']//i[@class='fa fa-save']");
	private final By ERROR_PERCENTAGE_PROCESS_DISCOUNT_POPUP = By.xpath("//div[@class='gritter-without-image']//p[1]");
	private final By DISCOUNT_ON_DROPDOWN = By.xpath("//select[@id='discount_on1']");
	private final By DISCOUNT_HEAD_DROPDOWN = By.xpath("//select[@id='discounthead1']");
	private final By DISCOUNT_REASON_DROPDOWN = By.xpath("//select[@id='discountreason1']");
	private final By AUTHORISED_BY_ERROR = By.xpath("//p[contains(text(),'Please select authorized by!')]");
	private final By AUTHORISED_BY_DORPDOWN = By.xpath("//select[@id='ddlAuthorised_dis']");
	private final By DRAFT_BUTTON_HEADER = By.xpath("//i[@class='fa fa-folder-open']");
	private final By SCHEME_BUTTON_NEAR_ADD_TO_BILL = By.xpath("//i[@class='fa fa-deviantart']");
	private final By PATIENT_PAID_AMOUNT_CHEQUE_PROCESS_PAYMENT_POPUP = By.xpath("//table[@class='mode_table table']//following::input[@ctype='amount'][2]");
	private final By AUTHORISED_BY_PROCESS_PAYMENT = By.xpath("//select[@name='ddlAuthorised']");
	private final By REMARKS_PROCESS_PAYMENT = By.xpath("//input[@id='authorisedremarks']");
	private final By VERIFY_BTN_PROCESS_PAYMENT = By.xpath("//div[@class='Verify_area_one']//button[1]");
	private final By SCHEME_EXPIRY_POPUP = By.xpath("//section[@id='schemeRemarksPopupText']/p[1]");
	private final By CLOSE_SCHEME_EXPIRY_POPUP = By.xpath("//a[@id='schemeRemarksPopupClose']//i[@class='fa fa-times']");
	private final By PREVIOUS_VISIT_ICON = By.xpath("//i[@title='Previous visits']");
	private final By PREVIOUS_VISIT_POPUP = By.xpath("//span[contains(text(),'Previous Visits')]");
	private final By CLOSE_PREVIOUS_VISIT_POPUP = By.xpath("//div[@id='modal_Previousvisit']//i[@class='fa fa-times']");
	private final By SERVICE_NAME_DROPDOWN_PERCENTAGE_POPUP = By.xpath("//table[@class='discount_table']//tbody/tr/td[4]/select");
	private final By ON_COMPANY_RADIO_BTN_PERCENTAGE_POPUP = By.xpath("//input[@id='rdbdiscom']");
	private final By ON_PATIENT_RADIO_BTN_PERCENTAGE_POPUP = By.xpath("//input[@id='rdbdispat']");
	private final By CLEAR_BTN_COMP_DETAILS =By.xpath("//a[@id='modal_refresh']//i[@class='fa fa-refresh']");
	//By.xpath("//section[@class='popupBody_payment']//i[@class='fa fa-refresh']");
	private final By ITEM_DOCTOR_PROCESS_DISCOUNT_POPU = By.xpath("//select[@name='dropdownitmname']");
	private final By DISCOUNT_AMOUNT_PROCESS_DISCOUNT_POPUP = By.xpath("//input[@id='discount_amount1']");
	private final By COMP_DISCOUNT_NOT_ALLOWED_MESSAGE = By.xpath("//p[contains(text(),'For cash patient, company only discount is not all')]");
	private final By SEARCH_NEW_BTN_HEADER = By.xpath("//i[@class='fa fa-search-plus']");
	private final By CLEAR_BTN_HEADER = By.xpath("//div[@class='user_sp_menu']//i[@class='fa fa-refresh']");
	private final By PATIENT_MAPPED_POPUP = By.xpath("//div[@id='modals']//section[@class='popupBody_validation']");
	private final By PATIENT_MAPPED_POPUP_YES_BUTTON = By.xpath("//a[@id='btnyes']");
	private final By PATIENT_MAPPED_POPUP_NO_BUTTON = By.xpath("//a[@id='btnno']");
	private final By MOBILE_NUMBER_SEARCH = By.xpath("//span[@class='float_field']//input[@id='modal_mobileNo']");
	private final By DISCOUNT_CANNOT_EXCEED_MESSAGE = By.xpath("//p[contains(text(),'Discount can not be exceed to patient Payable amou')]");
	private final By YES_BTN_AVAIL_DEPOSIT_POPUP = By.xpath("//a[@id='btnyesbal1']");
	private final By ADJUST_FROM_DEPOSIT_TEXT_BOX = By.xpath("//input[@name='availdeposits']");



	public void clickOnAddPatientAndSelectAnOption(String option) throws InterruptedException {
		//driver.waitForElementPresent(ADD_PATIENT_SECTION);
		driver.findElement(ADD_PATIENT_SECTION);
		logger.info("Add Patient Section is Expanded");

		WebElement options = driver.findElement(By.xpath("//a[text()='"+option+"']"));
		options.click();
		logger.info("Following Option has been selected from Add Patient Section " + option);

	}

	public void closeCompanyDetailsPopup() throws InterruptedException {
		try {
			//			Thread.sleep(2000);
			//			driver.waitForElementPresent(CLOSE_ICON_COMP_DETAIL_POPUP);
			WebElement CLOSE_ICON_COMP_DETAIL_element = driver.findElement(CLOSE_ICON_COMP_DETAIL_POPUP);
			driver.clickByJS(TTWebsiteDriver.driver, CLOSE_ICON_COMP_DETAIL_element);
			logger.info("Company Details Popup Button Closed");
		}
		catch (Exception e) {}
	}

	public void unCheckSchemeDetailsPopup() {
		try {
			WebElement checkbox = driver.findElement(SCHEME_CHECKBOX_SCHEME_POPUP);
			driver.clickByJS(TTWebsiteDriver.driver, checkbox);
			logger.info("Check Box Unchecked on Scheme Details Popup");
		}
		catch (Exception e) {}
	}

	public void closeSchemeDetailsPopup() throws InterruptedException {
		try {
			///driver.waitForElementPresent(CLOSE_ICON_SCHEME_DETAILS_POPUP);
			driver.findElement(CLOSE_ICON_SCHEME_DETAILS_POPUP).click();

			if(driver.findElements(SCHEME_FOR_PATIENT_POPUP).size()>0) {

				WebElement data = driver.findElement(By.xpath("//span[@id='remarks_close1']//i[@class='fa fa-times']"));
				driver.clickByJS(TTWebsiteDriver.driver, data);

			}
			if(driver.findElements(By.xpath("//span[@id='remarks_close1']//i")).size()>0) 
			{
				WebElement remark_element = driver.findElement(By.xpath("//span[@id='remarks_close1']//i"));
				driver.clickByJS(TTWebsiteDriver.driver, remark_element);
			}
			logger.info("Scheme Details Popup Button Closed");
		}
		catch (Exception e) {}
	}

	public void closeRemarksPopup() {
		try {
			if(driver.findElements(CLOSE_ICON_REMARKS_POPUP).size()>0) {
				//driver.waitForElementPresent(CLOSE_ICON_REMARKS_POPUP);
				WebElement CLOSE_ICON_REMARKS_POPUP_element = driver.findElement(CLOSE_ICON_REMARKS_POPUP);
				driver.clickByJS(TTWebsiteDriver.driver, CLOSE_ICON_REMARKS_POPUP_element);
				logger.info("Remarks Popup Button Closed");
			}
			if(driver.findElements(By.xpath("//span[@id='remarks_close1']//i")).size()>0) 
			{
				WebElement remark_element = driver.findElement(By.xpath("//span[@id='remarks_close1']//i"));
				driver.clickByJS(TTWebsiteDriver.driver, remark_element);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectSpecialityFromChooseSpecialityDropdown(String speciality) {
		try {
			//driver.waitForElementPresent(SPECIALITY_DROPDOWN);
			Select specialityDropdown = new Select(driver.findElement(SPECIALITY_DROPDOWN));
			specialityDropdown.selectByVisibleText(speciality);
			logger.info("Following speciality  has been selected from speciality Dropdown : " + speciality);
		}
		catch (Exception e) {}
	}

	public void selectFirstDoctorNameAndVerifyIfPriceIsDefined() {
		//driver.waitForElementPresent(FIRST_DOCTOR_NAME);
		String firstDoctorName = driver.findElement(FIRST_DOCTOR_NAME).getText();

		driver.findElement(By.xpath("//ul[@class='doctor_list list_details']/li[1]")).click();
		logger.info("Following Doctor Name has been searched : " + firstDoctorName);

		try {
			driver.findElement(By.xpath("//p[contains(text(),'Price not defined for this service')]")).isDisplayed();
			logger.info("Price is not defined for this Service");
		}
		catch(Exception e) {
			driver.findElement(By.xpath("//div[@class='parent_panel']//div//tr")).isDisplayed();
			logger.info("Price is defined for this Service and Doctor has been added to the list");
		}

	}

	public void selectDoctorByNameAndVerifyIfPriceIsDefined(String doctorName) {
		try {
			//driver.waitForElementPresent(By.xpath("//li[contains(text(),'"+doctorName+"')]"));
			//String firstDoctorName = driver.findElement(FIRST_DOCTOR_NAME).getText();

			//		driver.findElement(SEARCH_DOCTOR_TEXTBOX).sendKeys(firstDoctorName);
			driver.findElement(By.xpath("//li[contains(text(),'"+doctorName+"')]")).click();
			logger.info("Following Doctor Name has been Selected : " + doctorName);

			try {
				//driver.switchTo().activeElement();
				WebElement dialog_yes_btn = driver.findElement(By.xpath("//div[@role='dialog']//button[text()='Yes']"));	
				driver.clickByJS(TTWebsiteDriver.driver, dialog_yes_btn);
				//driver.switchTo().defaultContent();
			}
			catch (Exception e) {
				//e.printStackTrace();
			}

			//		try {
			//			driver.findElement(By.xpath("//p[contains(text(),'Price not defined for this service')]")).isDisplayed();
			//			logger.info("Price is not defined for this Service");
			//		}
			//		catch(Exception e) {
			//			driver.findElement(By.xpath("//div[@class='parent_panel']//div//tr")).isDisplayed();
			//			logger.info("Price is defined for this Service and Doctor has been added to the list");
			//		}

		}
		catch (Exception e) {}
	}



	public void selectSecondDoctorNameAndVerifyIfPriceIsDefined() {
		///driver.waitForElementPresent(SECOND_DOCTOR_NAME);
		String secondDoctorName = driver.findElement(SECOND_DOCTOR_NAME).getText();

		//		driver.findElement(SEARCH_DOCTOR_TEXTBOX).sendKeys(firstDoctorName);
		driver.findElement(By.xpath("//ul[@class='doctor_list list_details']/li[2]")).click();
		logger.info("Following Doctor Name has been searched : " + secondDoctorName);

		try {
			driver.findElement(By.xpath("//p[contains(text(),'Price not defined for this service')]")).isDisplayed();
			logger.info("Price is not defined for this Service");
		}
		catch(Exception e) {
			driver.findElement(By.xpath("//div[@class='parent_panel']//div//tr")).isDisplayed();
			logger.info("Price is defined for this Service and Doctor has been added to the list");
		}

	}

	public void clickOnDiagnosticIcon() {
		WebElement DIAGNOSTIC_ICON_element = driver.findElement(DIAGNOSTIC_ICON);
		driver.clickByJS(TTWebsiteDriver.driver, DIAGNOSTIC_ICON_element);
		logger.info("Diagnostic Icon Clicked");
	}

	public void selectTestsByName(String Testsname) throws InterruptedException {
		try {
			driver.findElement(By.xpath("//input[@id='autocomplete_tests']")).clear();
			driver.findElement(By.xpath("//input[@id='autocomplete_tests']")).sendKeys(Testsname);
			driver.findElement(By.xpath("//input[@id='autocomplete_tests']")).sendKeys(Keys.ENTER);
			///driver.findElement(By.xpath("//li[starts-with(@title,'"+Testsname+"')]")).click();
			driver.findElement(By.xpath("//li[starts-with(normalize-space(@title),'"+Testsname+"')]")).click();
			logger.info("Following Test has been selcted " +Testsname);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//correct this method
	public void selectAllTestSpecialityAndDoctorName(String speciality, String doctorName) throws InterruptedException 
	{

		List<WebElement> Diagnostics_table_list = driver.findElements(By.xpath("//table[@id='tbldiagnosis']//tbody//tr"));
		for(int i=1;i<=Diagnostics_table_list.size();i++) 
		{
			Thread.sleep(2000);
			WebElement service_element = driver.findElement(By.xpath("(//table[@id='tbldiagnosis']//tbody//tr)["+i+"]//select[@name='dlspec']"));

			Select serviceDropdown = new Select(service_element);
			serviceDropdown.selectByVisibleText(speciality);
			Thread.sleep(2000);
			WebElement doctorname_element = driver.findElement(By.xpath("(//table[@id='tbldiagnosis']//tbody//tr)["+i+"]//select[@name='dlspec']//following::td//select[@class='form-control']"));
			try {
				Select doctornameDropdown = new Select(doctorname_element);
				doctornameDropdown.selectByVisibleText(doctorName);	
			}
			catch (Exception e) {}
		}
	}

	public void selectScheduleSlotAndToken(String token) throws InterruptedException 
	{
		try {
		List<WebElement> Diagnostics_table_list = driver.findElements(By.xpath("//table[@id='tblconsultation']//tbody//tr"));
		for(int i=1;i<=Diagnostics_table_list.size();i++) 
		{
			Thread.sleep(2000);
			WebElement scheduleslot_element = driver.findElement(By.xpath("(//table[@id='tblconsultation']//tbody//tr)["+i+"]//select[contains(@id,'ddlschedule')]"));

			Select scheduleslotDropdown = new Select(scheduleslot_element);
			if(scheduleslotDropdown.getOptions().size()>0) 
			{
				List<WebElement> option = scheduleslotDropdown.getOptions();
				for(int k=0;k<=option.size()-1;k++) 
				{
					if( option.get(k).getText()!=null  && !option.get(k).getText().isEmpty()) 
					{
						scheduleslotDropdown.selectByVisibleText(option.get(k).getText());
						logger.info("Schedule Slot ="+option.get(k).getText());
						Thread.sleep(2000);
						break;
					}
				}

				WebElement token_element = driver.findElement(By.xpath("(//table[@id='tblconsultation']//tbody//tr)["+i+"]//select[contains(@id,'ddlschedule')]/..//following-sibling::td//select[contains(@id,'ddtoken')]"));
				Select tokenDropdown = new Select(token_element);
				List<WebElement> token_option = tokenDropdown.getOptions();
				for(int j=0;j<=token_option.size();j++) 
				{
					String lastvalue=token_option.get(j).getText();
					if(lastvalue!=null && !lastvalue.isEmpty()) 
					{
						tokenDropdown.selectByVisibleText(lastvalue);	
						logger.info("Token ="+lastvalue);
						break;
					}
					if(lastvalue==null) {
						tokenDropdown.selectByVisibleText(token);	
					}
				}
			}
		}
		}
		catch (Exception e) {}
	}
	public boolean verifyPriceNotDefinedMessage(String message) throws InterruptedException{
		if(driver.findElement(PRICE_NOT_DEFINED_MESSAGE).getText().contains(message))
		{
			logger.info("Price Not Defined Message is showing up");
			return true;
		}
		else{
			return false;
		}
	}

	public void clickOnManualIcon() throws InterruptedException {
		WebElement icon = driver.findElement(MANUAL_ICON);
		driver.clickByJS(TTWebsiteDriver.driver, icon);
		logger.info("Manual Icon Clicked");
	}

	public void selectServiceNameFromDropdown(String name) throws InterruptedException {
		Select serviceDropdown = new Select(driver.findElement(SERVICE_NAME_DROPDOWN));
		serviceDropdown.selectByVisibleText(name);
		logger.info("Following Name of Service name has been selected from service name Dropdown : " + name);
	}

	public void clickOnVerifyButton() throws InterruptedException {

		WebElement VERIFY_BU = driver.findElement(VERIFY_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, VERIFY_BU);
		logger.info("Verify Button Clicked");
	}

	public boolean verifySerivesErrorMessageIsShowingUp() throws InterruptedException{

		if(driver.findElement(SERVICE_ERROR_MESSAGE).isDisplayed())
		{
			logger.info("Error Messages are showing up");
			return true;
		}
		else{
			return false;
		}
	}

	public void enterDescriptionInManualSection(String description) {
		driver.findElement(DESCRIPTION_TEXT_BOX).sendKeys(description);
		logger.info("Following Description has been added in Description Text Box : " +description);
	}

	public void selectQuantityInManualSection(String quantity) {
		driver.findElement(QUANTITY_TEXT_BOX).sendKeys(quantity);
		logger.info("Following Quantity has been added in Quantity Text Box : " +quantity);
	}

	public void enterPriceInManualSection(String price) {
		driver.findElement(PRICE_TEXT_BOX).sendKeys(price);
		logger.info("Following Price has been added in Price Text Box : " +price);
	}

	public void clickOnOtherServicesIcon() {

		driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(OTHER_SERVICES_ICON));
		logger.info("Other Services Icon Clicked");
	}

	public void checkChooseServicesCheckboxInOtherServicesSection() {
		driver.waitForElementPresent(CHOOSE_SERVICES_CHECKBOX_IN_OTHER_SERVICES);
		driver.findElement(CHOOSE_SERVICES_CHECKBOX_IN_OTHER_SERVICES).click();
		logger.info("Choose Services Check box checked");
	}

	public boolean verifyChooseServicesDropdownIsEnabled() throws InterruptedException{
		driver.waitForElementPresent(CHOOSE_SERVICES_DROPDOWN_IN_OTHER_SERVICES);
		if(driver.findElement(CHOOSE_SERVICES_DROPDOWN_IN_OTHER_SERVICES).isEnabled())
		{
			logger.info("Choose Services Dropdown is not enabled");
			return true;
		}
		else{
			return false;
		}
	}

	public void selectAllServiceAndItemFromOtherServicesDropdown(String services, String item) {

		Select serviceDropdown = new Select(driver.findElement(CHOOSE_SERVICES_DROPDOWN_IN_OTHER_SERVICES));
		serviceDropdown.selectByVisibleText(services);

		logger.info("Following Service Name has been selected from service Dropdown : " + services);
		driver.findElement(By.xpath("//li[contains(text(),'"+item+"')]")).click();
		try {
			driver.click(PATIENT_MAPPED_POPUP_YES_BUTTON);
		}
		catch (Exception e) {
		}
		logger.info("Following Item has been selected from Services: " +item);
	}

	public void selectSpecialityAndDoctor(String speciality,String doctor) {

		List<WebElement> speciality_list = driver.findElements(By.xpath("(//table[@id='tblotherservice']//tbody//tr//select[@ctype='osspec'])"));
		for(int i=1;i<=speciality_list.size();i++)
		{
			WebElement specialityDropdown_element = driver.findElement(By.xpath("(//table[@id='tblotherservice']//tbody//tr//select[@ctype='osspec'])["+i+"]"));

			Select specialityDropdown = new Select(specialityDropdown_element);
			specialityDropdown.selectByVisibleText(speciality);
		}

		List<WebElement> doctor_list = driver.findElements(By.xpath("(//table[@id='tblotherservice']//tbody//tr//select[@ctype='docName'])"));
		for(int i=1;i<=doctor_list.size();i++)
		{
			WebElement doctorDropdown_element = driver.findElement(By.xpath("(//table[@id='tblotherservice']//tbody//tr//select[@ctype='docName'])["+i+"]"));
			Select doctorDropdown = new Select(doctorDropdown_element);
			doctorDropdown.selectByVisibleText(doctor);

			logger.info("Speciality And Doctor Selected");
		}
	}

	public void selectSpecialityAndDoctor() throws InterruptedException {

		Select specialityDropdown = new Select(driver.findElement(By.xpath("//tr//td[5]//select[1]")));
		specialityDropdown.selectByIndex(1);
		Select doctorDropdown = new Select(driver.findElement(By.xpath("//select[@id='osdoc0']")));
		doctorDropdown.selectByIndex(1);
		logger.info("Speciality And Doctor Selected");
		WebElement specialityDropdown_element = driver.findElement(By.xpath("(//table[@id='tblotherservice']//tbody//tr//select[@class='form-control'])[1]"));

	}

	public void enterRefferedBy(String reffered) {
		try {
			driver.findElement(REFFERED_BY_TEXTBOX_IN_OTHER_SERVICES).sendKeys(reffered);
			driver.findElement(REFFERED_BY_TEXTBOX_IN_OTHER_SERVICES).sendKeys(Keys.ENTER);
			driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(By.xpath("//tbody[@id='tblrefdr']/tr/td[1]")));
			logger.info("Following Reffered By has been added : " +reffered);
		}
		catch (Exception e) {
		}
	}

	public void selectFacilitatorFromDropdown(int index) {

		Select facilitator = new Select(driver.findElement(FACILITATOR_DROPDOWN));
		facilitator.selectByIndex(index);
		logger.info("Following facilitator has been selected from facilitator  Dropdown : " + index);
	}

	public void clickOnAddToBillButton() {

		WebElement ADD_TO_BILL_BUTTON_element = driver.findElement(ADD_TO_BILL_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, ADD_TO_BILL_BUTTON_element);
		logger.info("Add to Bill Buttton Clicked");

		try {
			driver.findElement(YES_BUTTON_CONFIRM_COMP_DETAILS).click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonschemedetails() throws InterruptedException 
	{
		try {
			driver.findElement(By.xpath("//a[@id='btnscheme']")).click();
		}
		catch (Exception e) {}
		try {
			driver.findElement(By.xpath("//input[@id='chkscheme']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='btnokscheme']//i[@class='fa fa-check']")).click();
		}
		catch (Exception e) {}
	}

	public boolean verifyInvestigationInstructionPopupIsPresent() throws InterruptedException
	{
		if(driver.findElement(INVESTIGATION_INSTRUCTION_POPUP).isDisplayed())
		{
			logger.info("Investigation Instruciton Popup is showing Up");
			return true;
		}
		else{
			return false;
		}
	}

	public void enterReponseInInvestigationPopupAndClickOnAddButton(String response) {
		try {
			String response_element = driver.findElement(RESPONSE_TEXT_FIELD).getAttribute("contenteditable");
			if(response_element.equals("false")) 
			{
				driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(ADD_BTN_INVESTIGATION_INSTRUCTION_POPUP));
			}
			else {
				driver.findElement(RESPONSE_TEXT_FIELD).sendKeys(response);
				driver.click(ADD_BTN_INVESTIGATION_INSTRUCTION_POPUP);
			}
			logger.info("Response has been added in Investigation Popup");
		}
		catch (Exception e) {}
	}

	public void clickonAddTOBillButton() {
		try {
			driver.findElement(By.id("add_bill_visit")).click();
			logger.info("Click on Add TO Bill Button");
			driver.findElement(By.id("btnyespolicy")).click();
			logger.info("Click on Add TO Bill Yes Button");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickOnBillingButtonOnHeader() {
		try {
			WebElement button = driver.findElement(BILLING_BTN_HEADER);
			driver.clickByJS(TTWebsiteDriver.driver, button);
			logger.info("Billing Button on header clicked");
		}
		catch (Exception e) {}
	}

	public void enterBillingRemarks() {

		driver.findElement(By.xpath("//textarea[@id='billremark']")).sendKeys("Billing Remarks");
	}

	public void clickOnyesBtnOnGenrateBillPopup() {
		try {
			driver.findElement(YES_BUTTON_GENERATE_BILL_POPUP).click();
			logger.info("Yes Button On Generate Bill Popup Clicked");
		}
		catch (Exception e) {}
	}

	public void clickOnNoBtnOnGenrateBillPopup() {
		try {
			driver.findElement(NO_BUTTON_GENERATE_BILL_POPUP).click();
			logger.info("NO Button On Generate Bill Popup Clicked");
		}
		catch (Exception e) {}
	}
	public void enterPatientPaidAmount(String amount) {
		driver.findElement(PATIENT_PAID_AMOUNT_PROCESS_PAYMENT_POPUP).clear();
		driver.findElement(PATIENT_PAID_AMOUNT_PROCESS_PAYMENT_POPUP).sendKeys(amount);
		logger.info("Following Amount has been added as patient Paid Amount: "+amount);
	}


	public void enterPatientPaidAmountForSecondTransaction(String amount) {
		driver.findElement(By.xpath("(//input[@ctype='amount'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@ctype='amount'])[2]")).sendKeys(amount);
		logger.info("Following Amount has been added as patient Paid Amount: "+amount);
	}



	public void clickOnNewPaymentModeButton() {
		WebElement NEW_MODE_BUTTON_element = driver.findElement(NEW_MODE_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, NEW_MODE_BUTTON_element);
		logger.info("New Payment Mode Button Clicked");
	}

	public void selectSecondPaymentModeAsCheque() {
		try {
			Select facilitator = new Select(driver.findElement(Frist_PAYMENT_MODE));
			facilitator.selectByVisibleText("Cheque");
			logger.info("Frist Payment MOde selected as Cheque");
		}
		catch (Exception e) {
		}
	}

	public void selectSecondPaymentModeAsPanCard(String text) {
		try {
			Select facilitator = new Select(driver.findElement(Frist_PAYMENT_MODE));
			facilitator.selectByVisibleText(text);
			logger.info("Frist Payment MOde selected as Cheque");
		}
		catch (Exception e) {
		}
	}
	public void selectSecondPaymentMode(String mode) {
		try {
			Select facilitator = new Select(driver.findElement(SECOND_PAYMENT_MODE));
			facilitator.selectByVisibleText(mode);
			logger.info("Second Payment MOde selected");
		}
		catch (Exception e) {}
	}


	public void enterChequeDetailsAndSaveDetails(String chequeNumber, String bankName, String branch) throws InterruptedException {
		try {
			driver.findElement(By.xpath("//input[@id='chequeNo']")).sendKeys(chequeNumber);

			Select bank = new Select(driver.findElement(By.xpath("//select[@id='ChequeBank']")));
			bank.selectByVisibleText(bankName);
			driver.findElement(By.xpath("//input[@id='ChequeBranch']")).sendKeys(branch);
			Thread.sleep(1000);
			WebElement element = driver.findElement(By.xpath("//a[@id='verify_modes']//i[@class='fa fa-save']"));
			driver.clickByJS(TTWebsiteDriver.driver, element);
			Thread.sleep(1000);
			logger.info("Cheque Details has been filled");
		}
		catch (Exception e) {}

	}

	public boolean verifyBillGotGenerated(String message) throws InterruptedException
	{
		if(driver.findElement(GENRATED_BILL_POPUP).getText().contains(message.trim()))
		{
			logger.info("Bill Got Generated Successfully");
			return true;
		}
		else{
			return false;
		}
	}

	public void clickOnNoButtonOnBillGotGeneratedPopup() {
		try {

			driver.findElement(NO_BTN_BILL_GOT_GENERATED_POPUP).click();
			logger.info("No Button on Bill Got Generated Popup Clicked");
		}
		catch (Exception e) {}
	}

	public void clickonYesButtonOnBillGotGenertedPopup() 
	{
		try {
			driver.findElement(YES_BTN_BILL_GOT_GENERATED_POPUP).click();
			logger.info("Yes Button on Bill Got Generated Popup Clicked");
			
			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			driver.close();
			driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
		}
		catch (Exception e) {}
	}

	public void enterDetailsInCompDetailsPopupAndPressYesButton(String compType, String company, String corpCompany, String rate, String standardDeductible, String standardCoPay) throws InterruptedException {
		try {
			Select coType = new Select(driver.findElement(COMP_TYPE_COMP_DETAILS_POPUP));
			coType.selectByVisibleText(compType);
			Thread.sleep(1000);
		}
		catch (Exception e) {}
		try {
			Select comp = new Select(driver.findElement(COMPANY_COMP_DETAILS_POPUP));
			comp.selectByVisibleText(company);
			Thread.sleep(1000);
		}
		catch (Exception e) {}
		try {
			Select corp1 = new Select(driver.findElement(CORPORATE_COMP_DETAILS_POPUP));
			corp1.selectByVisibleText(corpCompany);
			Thread.sleep(1000);
		}
		catch (Exception e) {}
		try {
			Select rateCont = new Select(driver.findElement(RATE_CONTRACT_COMP_DETAILS_POPUP));
			rateCont.selectByVisibleText(rate);
		}
		catch (Exception e) {
		}
		try {
			driver.findElement(STANDARD_DEDUCTABLE_COMP_DETAILS_POPUP).clear();
			driver.findElement(STANDARD_DEDUCTABLE_COMP_DETAILS_POPUP).sendKeys(standardDeductible);
		}
		catch (Exception e) {}
		try {
			Thread.sleep(1000);
			driver.findElement(STANDARD_CO_PAY_COMP_DETAILS_POPUP).clear();
			driver.findElement(STANDARD_CO_PAY_COMP_DETAILS_POPUP).sendKeys(standardCoPay);
		}
		catch (Exception e) {}

		try {
			WebElement PLUS_BUTTON = driver.findElement(PLUS_BUTTON_COMP_DETAILS_POPUP);
			driver.clickByJS(TTWebsiteDriver.driver, PLUS_BUTTON);
			Thread.sleep(1000);
			driver.waitForElementPresent(YES_BUTTON_CONFIRM_COMP_DETAILS);
			WebElement YES_BUTTON_CONFIRM = driver.findElement(YES_BUTTON_CONFIRM_COMP_DETAILS);
			driver.clickByJS(TTWebsiteDriver.driver, YES_BUTTON_CONFIRM);
		}
		catch (Exception e) {
		}
		logger.info("Details Entered In Comp Details Popup And Pressed Yes Button");

	}

	public void enterDetailsInCompDetailsPopupAndPressYesButtonMethod1(String compType, String company, String corpCompany, String rate, String standardDeductible, String standardCoPay) throws InterruptedException {
		try {
			Select coType = new Select(driver.findElement(COMP_TYPE_COMP_DETAILS_POPUP));
			coType.selectByVisibleText(compType);

			Select comp = new Select(driver.findElement(COMPANY_COMP_DETAILS_POPUP));
			comp.selectByVisibleText(company);

			Select corp1 = new Select(driver.findElement(CORPORATE_COMP_DETAILS_POPUP));
			corp1.selectByValue(corpCompany);

			Select rateCont = new Select(driver.findElement(RATE_CONTRACT_COMP_DETAILS_POPUP));
			rateCont.selectByVisibleText(rate);
		}
		catch (Exception e) {}


		try {
			selectDocumentFromDocumentChecklistPopup("Case Record");
			selectDocumentFromDocumentChecklistPopup("PAN Card");
			selectDocumentFromDocumentChecklistPopup("Form 60");
			selectDocumentFromDocumentChecklistPopup("OP Prescription");
			driver.click(By.xpath("//a[@id='_savelist']//i[@class='fa fa-save']"));
		} catch (Exception e) {
			e.printStackTrace();
		}


		driver.findElement(STANDARD_DEDUCTABLE_COMP_DETAILS_POPUP).clear();
		driver.findElement(STANDARD_CO_PAY_COMP_DETAILS_POPUP).clear();
		driver.findElement(STANDARD_DEDUCTABLE_COMP_DETAILS_POPUP).sendKeys(standardDeductible);
		driver.findElement(STANDARD_CO_PAY_COMP_DETAILS_POPUP).sendKeys(standardCoPay);
		try {
			driver.click(By.xpath("//a[@id='_savelist']//i[@class='fa fa-save']"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.findElement(PLUS_BUTTON_COMP_DETAILS_POPUP).click();
		driver.findElement(YES_BUTTON_CONFIRM_COMP_DETAILS).click();
		logger.info("Details Entered In Comp Details Popup And Pressed Yes Button");

	}

	public void selectSchemeAuthorisedSchemeDetailsPopup(String scheme, String authorisedBy, String schemeForPatient) throws InterruptedException {
		try {
			Select schemeName = new Select(driver.findElement(SCHEME_SCHEME_DETAIL_POPUP));
			schemeName.selectByVisibleText(scheme);

		}
		catch (Exception e) {
		}
		try {
			Select authorised = new Select(driver.findElement(AUTHORISED_BY_DROPDOWN_SCHEME_DETAIL_POPUP));
			authorised.selectByVisibleText(authorisedBy);

		}
		catch (Exception e) {
		}
		try {
			driver.findElement(By.xpath("//a[@id='btnokscheme']//i[@class='fa fa-check']")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(driver.findElement(SCHEME_FOR_PATIENT_POPUP).isDisplayed()==true) {
				driver.findElement(By.xpath("//td[contains(text(),'"+schemeForPatient+"')]")).click();;
			}
		}
		catch (Exception e) {}
		logger.info("Scheme And Authorised By Selected in Scheme Details Popup");
	}
	public void selectSchemeAuthorisedSchemeDetailsPopupadd() 
	{
		try {
			WebElement add_btn_element = driver.findElement(By.xpath("//a[@id='addinsurance']//i"));
			driver.clickByJS(TTWebsiteDriver.driver, add_btn_element);
		}
		catch (Exception e) {
		}
	}
	public void selectSchemeFromSchemeForPatientPopup(String schemeForPatient) {
		try {
			if(driver.findElement(SCHEME_FOR_PATIENT_POPUP).isDisplayed()==true) {
				driver.findElement(By.xpath("//td[contains(text(),'"+schemeForPatient+"')]"));
			}
			logger.info("Following Scheme From Scheme For Patient Popup selected"+schemeForPatient);
		}
		catch (Exception e) {}
	}

	public boolean verifyDailyDiscountLimitMessage(String message) throws InterruptedException{
		if(driver.findElement(DAILY_DISCOUNT_LIMIT_POPUP).getText().contains(message))
		{
			logger.info("Daily Discount Limit Message is showing up");
			return true;
		}
		else{
			return false;
		}
	}

	public boolean verifyPrintOPDMessageIsDisplaying(String message) throws InterruptedException
	{
		if(driver.findElement(PRINT_OPD_MESSAGE).getText().contains(message))
		{
			logger.info("Print OPD Message is showing Up");
			return true;
		}
		else{
			return false;
		}
	}

	public void clickOnYesButtonOnOpdPopup() {
		try {
			driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(YES_BTN_OPD));
			logger.info("Yes Button On OPD Popup Clicked");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectVisitTypeFromVisitTypeDropdown(String visit) {
		try {
			Select visitDropdown = new Select(driver.findElement(VISIT_TYPE_DROPDOWN));
			visitDropdown.selectByVisibleText(visit);
			logger.info("Following Visit Type  has been selected from Visit Type : " + visit);
		}
		catch (Exception e) {
		}
	}

	public void clickOnPhysicianOrderIcon() {
		try {
			driver.findElement(PHYSICIAN_ICON).click();
			logger.info("Physician Order Icon Clicked");
		}
		catch (Exception e) {
		}
	}

	public void clickOnSaveButtonOnDocumentChecklistPopup() throws InterruptedException {
		try {
			WebElement checkall_element = driver.findElement(By.xpath("//input[@id='_alldoccheck']"));
			driver.clickByJS(TTWebsiteDriver.driver, checkall_element);
			driver.waitForElementPresent(SAVE_BUTTON_DOCUMENT_CHECKLIST_POPUP);
			WebElement SAVE_BUTTON_element = driver.findElement(SAVE_BUTTON_DOCUMENT_CHECKLIST_POPUP);
			driver.clickByJS(TTWebsiteDriver.driver, SAVE_BUTTON_element);
			logger.info("Save Button On Document Checklist popup Clicked");
		}
		catch (Exception e) {
		}
	}

	public void clickOnCloseButtonOnDocumentChecklistPopup() throws InterruptedException {
		try {
			WebElement CLOSE_BUTTON_DOCUMENT_element = driver.findElement(CLOSE_BUTTON_DOCUMENT_CHECKLIST_POPUP);
			driver.clickByJS(TTWebsiteDriver.driver, CLOSE_BUTTON_DOCUMENT_element);
			logger.info("Close Button On Document Checklist popup Clicked");
		}
		catch (Exception e) {
		}
	}
	public void clickandclosebuttonDocumentChecklist() {
		try {
			WebElement CLOSE_BUTTON_DOCUMENT_element1 = driver.findElement(CLOSE_BUTTON_DOCUMENT_CHECKLIST_POPUP1);
			driver.clickByJS(TTWebsiteDriver.driver, CLOSE_BUTTON_DOCUMENT_element1);
			logger.info("Close Button On Document Checklist popup Clicked");
		}
		catch (Exception e) {
		}
	}
	public boolean verifyMandatoryDocumentMessage(String message) throws InterruptedException{
		driver.clickAnyWhereOnScreen();
		if(driver.findElement(MANDATORY_DOCUMENT_ERROR_MESSAGE).getText().contains(message))
		{
			logger.info("Alert SHowing up when clicking on Save wihout checking Mandatory Document");
			return true;
		}
		else{
			return false;
		}
	}

	public void checkCaseRecordCheckboxFromDocumentCheckList() throws InterruptedException {
		try {

			driver.findElement(CASE_RECORD_CHECKBOX);
			Thread.sleep(1000);
			driver.findElement(CASE_RECORD_CHECKBOX).click();
			logger.info("Case record Checkbox Checked");
		}
		catch (Exception e) {
		}
	}

	public void checkPanCardCheckboxFromDocumentCheckList() throws InterruptedException {
		try {
			driver.findElement(PAN_CARD_CHECKBOX).click();
			Thread.sleep(1000);
			driver.findElement(PAN_CARD_CHECKBOX).click();
			logger.info("Pamn Card Checkbox Checked");
		}
		catch (Exception e) {
		}
	}

	public void checkForm60CheckboxFromDocumentCheckList() {
		try {
			driver.findElement(FORM_60_CHECKBOX).click();
			logger.info("Form 60 Checkbox Checked");
		}
		catch (Exception e) {
		}
	}

	public void clickOnInsuranceCompanyButton() {
		try {
			WebElement InsuranceCompanyButton = driver.findElement(INSURANCE_COMPANY_BUTTON);
			driver.clickByJS(TTWebsiteDriver.driver, InsuranceCompanyButton);
			logger.info("Insurance Company Button Clicked");
		}
		catch (Exception e) {}
	}

	public void selectInsuranceCompRadioButtonOnCompDetailsPopup() 
	{
		driver.findElement(INSURANCE_RADIO_BTN_ON_COMP_DETAILS).click();
		logger.info("Insurance Comp Radio Button On Comp Details Popup Clicked");
	}

	public void uncheckSchemeCheckBox() {
		WebElement CHECK_SCHEME_CHECKBOX_element = driver.findElement(CHECK_SCHEME_CHECKBOX);
		driver.clickByJS(TTWebsiteDriver.driver, CHECK_SCHEME_CHECKBOX_element);
		logger.info("Scheme Checkbox Un Checked");
	}

	public void okButtonSchemePopup() {
		driver.findElement(OK_BTN_SCHEME_POPUP).click();
		logger.info("Ok Button on Scheme Popup Clicked");
	}

	public void cancelSchemeForPatientPopup() {

		if(driver.findElements(CANCEL_SCHEME_FOR_PATIENT).size()>0) {
			driver.findElement(CANCEL_SCHEME_FOR_PATIENT).click();
			logger.info("Cancel Button Clicked on Scheme For Patient Popup");
		}

	}

	public void checkDiscountCheckbox()
	{
		driver.findElement(DISCOUNT_CHECKBOX).click();
		logger.info("Discount Checkbox checked under billing section");
	}

	public void clickOnYesBtnUnderProvideDiscountPopup() throws InterruptedException {

		WebElement element = driver.findElement(YES_BTN_PROVIDE_DISCOUNT);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Yes Btn Under Provide Discount Popup Clicked");
	}

	public boolean isPercentageProcessDiscountMessageDisplayed() {
		return driver.isElementPresent(PERCENTAGE_PROCESS_DISCOUNT_HEADER);
	}

	public void clickOnYesBtnPercentageProcessDiscountPopup() {
		driver.click(YES_BTN_PERCENTAGE_PROCESS_DISCOUNT_POPUP);
		logger.info("Yes Btn Under Percentage Process Discount Popup Clicked");
	}

	public boolean isEnterDiscountErrorMessageDisplayed() {
		return driver.isElementPresent(ERROR_PERCENTAGE_PROCESS_DISCOUNT_POPUP);
	}

	public void selectDiscountOnFromDropdown(String discountOn) {

		Select occupationDropdown = new Select(driver.findElement(DISCOUNT_ON_DROPDOWN));
		occupationDropdown.selectByVisibleText(discountOn);
		logger.info("Following Discount On Has been selected from Discount On Dropdown : " + discountOn);
	}

	public void selectDiscountHeadFromDropdown(String discountHead) {

		Select occupationDropdown = new Select(driver.findElement(DISCOUNT_HEAD_DROPDOWN));
		occupationDropdown.selectByVisibleText(discountHead);
		logger.info("Following Discount head Has been selected from Discount Head Dropdown : " + discountHead);
	}

	public void selectDiscountReasonFromDropdown(String discountReason) {

		Select occupationDropdown = new Select(driver.findElement(DISCOUNT_REASON_DROPDOWN));
		occupationDropdown.selectByVisibleText(discountReason);
		logger.info("Following Discount Reason Has been selected from Discount Reason Dropdown : " + discountReason);
	}

	public boolean isAuthorisedByErrorMessageDisplayed() {
		return driver.isElementPresent(AUTHORISED_BY_ERROR);
	}

	public void selectAuthorisedByFromDropdown(String authorisedBy) {

		Select occupationDropdown = new Select(driver.findElement(AUTHORISED_BY_DORPDOWN));
		occupationDropdown.selectByVisibleText(authorisedBy);
		logger.info("Following Authorised By Has been selected from Authorised By Dropdown : " + authorisedBy);
	}

	public void clickOnDraftButtonOnHeader() throws InterruptedException {

		WebElement button = driver.findElement(DRAFT_BUTTON_HEADER);
		driver.clickByJS(TTWebsiteDriver.driver, button);
		logger.info("Draft Button on header clicked");
	}

	public void clickOnSchemeButtonNearAddToBill() {

		WebElement SCHEME_BUTTON = driver.findElement(SCHEME_BUTTON_NEAR_ADD_TO_BILL);
		if(!SCHEME_BUTTON.isSelected()) {
			driver.findElement(SCHEME_BUTTON_NEAR_ADD_TO_BILL).click();
		}
		logger.info("Scheme Button near add to bill button clicked");
	}

	public void enterPatientPaidAmountForCheque(String amount) {

		driver.findElement(PATIENT_PAID_AMOUNT_CHEQUE_PROCESS_PAYMENT_POPUP).clear();
		driver.findElement(PATIENT_PAID_AMOUNT_CHEQUE_PROCESS_PAYMENT_POPUP).sendKeys(amount);
		logger.info("Following Cheque Amount has been added as patient Paid Amount: "+amount);
	}

	public void selectAuthorisedByFromProcessPaymentDropdown(String authorisedBy) {

		Select occupationDropdown = new Select(driver.findElement(AUTHORISED_BY_PROCESS_PAYMENT));
		occupationDropdown.selectByVisibleText(authorisedBy);
		logger.info("Following Authorised By Has been selected from Authorised By Dropdown : " + authorisedBy);
	}

	public void enterRemarsInProcessPaymentPopup(String remarks) {
		driver.findElement(REMARKS_PROCESS_PAYMENT).sendKeys(remarks);
	}

	public void clickOnVerifyButtonOnProcessPayment() {
		WebElement element = driver.findElement(VERIFY_BTN_PROCESS_PAYMENT);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Verify Button on Process Payment Popup Clicked");
	}

	public boolean verifySchemeExpiryPopupMessage(String message) throws InterruptedException
	{
		if(driver.findElement(SCHEME_EXPIRY_POPUP).getText().contains(message))
		{
			logger.info("Scheme Expiry Popup Message is showing up");
			return true;
		}
		else{
			return false;
		}
	}

	public void closeSchemeExpiryPopup() {
		driver.findElement(CLOSE_SCHEME_EXPIRY_POPUP).click();
		logger.info("Scheme Expiry Popup Closed");
	}

	public void clickPreviousVisitIcon() throws InterruptedException {

		WebElement element =	driver.findElement(PREVIOUS_VISIT_ICON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Previous Visit Icon Clicked");
	}

	public boolean isPreviousVisitPopupOpened() {
		return driver.isElementPresent(PREVIOUS_VISIT_POPUP);
	}

	public void closePreviousVisitPopup() {
		try {
			driver.click(CLOSE_PREVIOUS_VISIT_POPUP);
			logger.info("Previous Visit Popup Closed");
		}
		catch (Exception e) {}
	}

	public void selecServiceNameFromPercentagePopupDropdown(String service) {

		Select occupationDropdown = new Select(driver.findElement(SERVICE_NAME_DROPDOWN_PERCENTAGE_POPUP));
		occupationDropdown.selectByVisibleText(service);
		logger.info("Following Service Name Has been selected from Service Name Dropdown : " + service);
	}

	public void selecItemDoctorNameFromDiscountPopupDropdown(String service) {

		Select occupationDropdown = new Select(driver.findElement(ITEM_DOCTOR_PROCESS_DISCOUNT_POPU));
		occupationDropdown.selectByVisibleText(service);
		logger.info("Following Iteam/Doctor Name Has been selected from Item Doctor Name Dropdown : " + service);
	}

	public void selectOnCompanyRadioButton() {
		driver.findElement(ON_COMPANY_RADIO_BTN_PERCENTAGE_POPUP).click();
		logger.info("On Company Radio Button Clicked");
	}

	public void selectOnPatientRadioButton() {
		driver.findElement(ON_PATIENT_RADIO_BTN_PERCENTAGE_POPUP).click();
		logger.info("On Patient Radio Button Clicked");
	}

	public void clickClearButtonCompDetails() 
	{
		try {
			WebElement CLEAR_BTN_COMP_DETAILS_element = driver.findElement(CLEAR_BTN_COMP_DETAILS);
			driver.clickByJS(TTWebsiteDriver.driver, CLEAR_BTN_COMP_DETAILS_element);
			logger.info("Clear Button On Comp Details Popup Clicked");
		}
		catch (Exception e) {}
	}

	public void enterDiscountAmount(String amount) {
		try {
			driver.findElement(DISCOUNT_AMOUNT_PROCESS_DISCOUNT_POPUP).clear();
			driver.findElement(DISCOUNT_AMOUNT_PROCESS_DISCOUNT_POPUP).sendKeys(amount);
		}
		catch (Exception e) {}
	}

	public boolean isCompOnlyDiscoutErrorMessageDisplayed() {
		return driver.isElementPresent(COMP_DISCOUNT_NOT_ALLOWED_MESSAGE);
	}

	public void clickOnSearchNewButtonOnHeader() 
	{
		WebElement search_new_btn_element = driver.findElement(SEARCH_NEW_BTN_HEADER);
		driver.clickByJS(TTWebsiteDriver.driver, search_new_btn_element);
		logger.info("Search New Button on header clicked");
	}

	public void clickClearButtonOnHeader(){

		driver.findElement(CLEAR_BTN_HEADER).click();
		logger.info("Clear Button on Header Clicked");
	}

	public boolean verifyPatientMappedPopup(String message) {
		if(driver.findElement(PATIENT_MAPPED_POPUP).getText().contains(message))
		{
			logger.info("Patient Mapped Popup is showing up");
			return true;
		}
		else{
			return false;
		}
	}

	public void clickOnYesButtonOnPatientMappedPopup() {
		try {
			driver.findElement(PATIENT_MAPPED_POPUP_YES_BUTTON).click();
			logger.info("Yes Button clicked on Patient Mapped Popup");
		}
		catch (Exception e) {
		}
	}

	public void clickOnNoButtonOnPatientMappedPopup() {
		driver.findElement(PATIENT_MAPPED_POPUP_NO_BUTTON).click();
		logger.info("No Button clicked on Patient Mapped Popup");
	}

	public void searchPatientWithMobileNumber(String mobile) throws InterruptedException {

		driver.findElement(MOBILE_NUMBER_SEARCH).sendKeys(mobile);
		driver.findElement(MOBILE_NUMBER_SEARCH).sendKeys(Keys.ENTER);
		logger.info("Following Mobile Number has been searched "+mobile);
	}

	public void clickOnPatientIdFromSearch(String patientId) throws InterruptedException {

		WebElement element =driver.findElement(By.xpath("//td[contains(text(),'"+patientId+"')]//ancestor::tr[1]"));
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Following patien ID has been clicked "+patientId);

	}

	public boolean isDiscountExceededMessageDisplayed() {

		return driver.isElementPresent(DISCOUNT_CANNOT_EXCEED_MESSAGE);
	}

	public void clickOnYesButtonOnAvailDepositPopup() {
		try {
			driver.findElement(YES_BTN_AVAIL_DEPOSIT_POPUP).click();
		}
		catch (Exception e) {}
	}

	public void enterAjustFromDeposit(String deposit) {
		try {
			//driver.findElement(ADJUST_FROM_DEPOSIT_TEXT_BOX).clear();
			driver.findElement(ADJUST_FROM_DEPOSIT_TEXT_BOX).sendKeys(deposit);
		}
		catch (Exception e) {}
	}

	public boolean isCashBillingNotAllowedMessageDisplayed() {
		return driver.isElementPresent(By.xpath("//p[contains(text(),'Cash billing not allowed for this rate contract!')]"));
	}

	public void selectRateContractInCompDetailsPopup(String rateContract) {

		Select authorised = new Select(driver.findElement(By.xpath("//select[@id='rate_contract']")));
		authorised.selectByVisibleText(rateContract);

	}

	public void selectDocumentFromDocumentChecklistPopup(String document) {

		WebElement CaseRecord_checkbox = driver.findElement(By.xpath("//td[text()='"+document+"']/../td//input"));
		if(!CaseRecord_checkbox.isSelected()) 
		{
			driver.clickByJS(TTWebsiteDriver.driver, CaseRecord_checkbox);		
		}
	}

	public void saveDocumentChecklistPopup() 
	{
		WebElement savelist_element = driver.findElement((By.xpath("//a[@id='_savelist']//i[@class='fa fa-save']")));
		driver.clickByJS(TTWebsiteDriver.driver, savelist_element);
	}

	public void enterCardDetailsAndSaveDetails(String cardType1, String debitCardNo, String bankName, String transNo) throws InterruptedException {

		Select cardType = new Select(driver.findElement(By.xpath("//select[@id='dcType']")));
		cardType.selectByVisibleText(cardType1);
		driver.findElement(By.xpath("//input[@id='dcNumber']")).sendKeys(debitCardNo);
		Thread.sleep(6000);

		Select bank = new Select(driver.findElement(By.xpath("//select[@id='dcbank']")));
		bank.selectByVisibleText(bankName);
		driver.findElement(By.xpath("//input[@id='dcTransNo']")).sendKeys(transNo);
		WebElement element = driver.findElement(By.xpath("//a[@id='verify_modes']//i[@class='fa fa-save']"));
		driver.clickByJS(TTWebsiteDriver.driver, element);
		Thread.sleep(5000);

		logger.info("Card Details has been filled");

	}


	public void clickOnSearchIconOnBillUtility() {

		WebElement button = driver.findElement(By.xpath("//a[@id='search_huiddata']//i[@class='fa fa-search']"));
		driver.clickByJS(TTWebsiteDriver.driver, button);
		logger.info("Search Icon Near Save Button clicked");

		driver.findElement(By.xpath("//a[@id='search_UHID']//i[@class='fa fa-search search_buttondata']")).click();
	}


	public void closeSearchUtilityPopup() {
		try {
			driver.findElement(By.xpath("//div[@id='fosearch_patient']//i[@class='fa fa-times']")).click();
		}
		catch (Exception e) {}
	}


	public void clearManualSection() 
	{

		driver.findElement(By.xpath("//a[@id='new_manual_refresh']")).click();
	}

	public void selectAythorisedByInProcessPaymentPopupAndAddRemarks(String name) {
		try {

			Select serviceDropdown = new Select(driver.findElement(By.xpath("//select[@id='ddlAuthorised']")));
			serviceDropdown.selectByVisibleText(name);
			driver.findElement(By.xpath("//input[@id='authorisedremarks']")).sendKeys("Testing Remarks");
		}
		catch (Exception e) {}
	}

	public void clickOnVerifyButtonOnProcessPaymentPopup() {
		try {

			driver.findElement(By.xpath("//button[@id='authorised_verify']")).click();
		}
		catch (Exception e) {}
	}

	public void clickOnNoButtonOnPrintOPDCard()
	{
		try {
			WebElement no = driver.findElement(By.xpath("//a[@id='btnnoopd']"));
			driver.clickByJS(TTWebsiteDriver.driver, no);
		}
		catch (Exception e) {
		}
	}

	public void closeSchemeForPatientPopup() {
		WebElement closeScheme_element = driver.findElement(By.xpath("//span[@id='remarks_close1']//i[@class='fa fa-times']"));
		driver.clickByJS(TTWebsiteDriver.driver, closeScheme_element);
	}

	public void saveprocesspayment() {
		try {
			WebElement saveprocesspayment_element = driver.findElement(By.xpath("//a[@id='verify_modes']//i"));
			driver.clickByJS(TTWebsiteDriver.driver, saveprocesspayment_element);
		}
		catch (Exception e) {
		}
	}
	public void closepopup() {
		WebElement closepopup = driver.findElement(By.xpath("(//a[@title='Close']//i)[1]"));
		driver.clickByJS(TTWebsiteDriver.driver, closepopup);
	}

	public void closeprocessdiscountpopup() 
	{
		try {
			driver.findElement(By.xpath("//i[@class='fa fa-times Diacount_close']")).click();
			logger.info("Close Process Discount Popup");
		}
		catch (Exception e) {}
	}

	public void closevalidityschemepopup() {

		driver.findElement(By.xpath("//a[@id='schemeRemarksPopupClose']//i")).click();
		logger.info("Close validity scheme Popup");
	}

	public void clickonProcesspaymentsavebutton() 
	{
		try {
			WebElement element = driver.findElement(By.xpath("//a[@id='verify_modes']//i[@class='fa fa-save']"));
			driver.clickByJS(TTWebsiteDriver.driver, element);
			logger.info("Click on Process Payment Save Button");
		}
		catch (Exception e) {}
	}

	public void cashrecieved() {
		try {
			String amount = driver.findElement(By.xpath("//input[@id='payment_mode_value1']")).getAttribute("value");
			if(amount!=null)
			{
				driver.findElement(By.xpath("//label[text()='Cash Recieved']//following-sibling::input")).sendKeys(amount);
			}
		}
		catch (Exception e) {}
	}

	public void closeappointmentscheduling()
	{
		try {
			driver.findElement(By.xpath("//span[@id='modelclose123']//i")).click();
			logger.info("Close Appointment Scheduling");
		}
		catch (Exception e) {}
	}
	
	public void clickonBillingIcon() 
	{
		driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(By.id("process_payment")));
		logger.info("Click on Billing Icon");
		
	}
}

