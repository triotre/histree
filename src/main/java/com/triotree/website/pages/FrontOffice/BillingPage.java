package com.triotree.website.pages.FrontOffice;

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
	private final By CLOSE_ICON_COMP_DETAIL_POPUP =By.xpath("//span[@id='modelclose123']//i");
	//By.xpath("//a[@id='cancelinsurance']//i[@class='fa fa-times']");
	private final By CLOSE_ICON_SCHEME_DETAILS_POPUP = By.xpath("//a[@id='schemeclose']//i[@class='fa fa-times']");
	private final By CLOSE_ICON_REMARKS_POPUP = By.xpath("//span[@id='remarks_close']//i[@class='fa fa-times']");
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
	private final By PATIENT_PAID_AMOUNT_PROCESS_PAYMENT_POPUP = By.xpath("//input[@ctype='amount']");
	private final By NEW_MODE_BUTTON = By.xpath("//button[@id='new_payment_mode']");
	private final By SECOND_PAYMENT_MODE = By.xpath("//select[@id='paymentMode2']");
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
		driver.waitForElementPresent(ADD_PATIENT_SECTION);
		driver.click(ADD_PATIENT_SECTION);
		logger.info("Add Patient Section is Expanded");

		WebElement options = driver.findElement(By.xpath("//a[text()='"+option+"']"));
		options.click();
		logger.info("Following Option has been selected from Add Patient Section " + option);
		driver.waitForPageLoad();
		Thread.sleep(18000);
	}

	public void closeCompanyDetailsPopup() throws InterruptedException {
		try {
			Thread.sleep(2000);
			driver.waitForElementPresent(CLOSE_ICON_COMP_DETAIL_POPUP);
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
			driver.waitForElementPresent(CLOSE_ICON_SCHEME_DETAILS_POPUP);
			driver.findElement(CLOSE_ICON_SCHEME_DETAILS_POPUP).click();
			driver.pauseExecutionFor(4000);
			if(driver.findElement(SCHEME_FOR_PATIENT_POPUP).isDisplayed()==true) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[@id='remarks_close1']//i[@class='fa fa-times']")).click();
				Thread.sleep(2000);
			}
			logger.info("Scheme Details Popup Button Closed");
		}
		catch (Exception e) {}
	}

	public void closeRemarksPopup() {
		try {
			if(driver.findElements(CLOSE_ICON_REMARKS_POPUP).size()>0) {
				driver.waitForElementPresent(CLOSE_ICON_REMARKS_POPUP);
				WebElement CLOSE_ICON_REMARKS_POPUP_element = driver.findElement(CLOSE_ICON_REMARKS_POPUP);
				driver.clickByJS(TTWebsiteDriver.driver, CLOSE_ICON_REMARKS_POPUP_element);
				logger.info("Remarks Popup Button Closed");
			}
			else if(driver.findElements(By.xpath("//span[@id='remarks_close1']//i")).size()>0) 
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
			driver.waitForElementPresent(SPECIALITY_DROPDOWN);
			Select specialityDropdown = new Select(driver.findElement(SPECIALITY_DROPDOWN));
			specialityDropdown.selectByVisibleText(speciality);
			logger.info("Following speciality  has been selected from speciality Dropdown : " + speciality);
		}
		catch (Exception e) {}
	}

	public void selectFirstDoctorNameAndVerifyIfPriceIsDefined() {
		driver.waitForElementPresent(FIRST_DOCTOR_NAME);
		String firstDoctorName = driver.findElement(FIRST_DOCTOR_NAME).getText();

		//		driver.findElement(SEARCH_DOCTOR_TEXTBOX).sendKeys(firstDoctorName);
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
			driver.waitForElementPresent(By.xpath("//li[contains(text(),'"+doctorName+"')]"));
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
		driver.waitForElementPresent(SECOND_DOCTOR_NAME);
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
			driver.findElement(By.xpath("//input[@id='autocomplete_tests']")).sendKeys(Testsname);
			driver.findElement(By.xpath("//input[@id='autocomplete_tests']")).sendKeys(Keys.ENTER);

			driver.waitForElementPresent(By.xpath("//li[starts-with(@title,'"+Testsname+"')]"));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[starts-with(@title,'"+Testsname+"')]")).click();
			logger.info("Following Test has been selcted " +Testsname);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//correct this method
	public void selectAllTestSpecialityAndDoctorName(String speciality, String doctorName) throws InterruptedException {

		//		int noOfTests = driver.findElements(By.xpath("//body[@class='patient_registration_demo_body']//div[@class='master_panel']//form[@class='billing-area-responsive']//div[@class='parent_panel op_billing_area_new']//div//div[@class='opbill-table']//table[2]//tbody[1]//tr")).size();
		//		for(int i=noOfTests;i>=1;i--) {
		//
		//			driver.waitForElementPresent(CHOOSE_SERVICES_DROPDOWN_IN_OTHER_SERVICES);
		//			Select serviceDropdown = new Select(driver.findElement(By.xpath("//body[@class='patient_registration_demo_body']//div[@class='master_panel']//form[@class='billing-area-responsive']//div[@class='parent_panel op_billing_area_new']//div//div[@class='opbill-table']//table[2]//tbody[1]//tr["+i+"]//td[8]//select[1]")));
		//			serviceDropdown.selectByVisibleText(speciality);
		//			logger.info("Following Speciality has been selected from Speciality Dropdown : " + speciality);
		//			driver.waitForElementPresent(DOCTOR_NAME_TEST);
		//			Select doctorDropdown = new Select(driver.findElement(By.xpath("//body[@class='patient_registration_demo_body']//div[@class='master_panel']//form[@class='billing-area-responsive']//div[@class='parent_panel op_billing_area_new']//div//div[@class='opbill-table']//table[2]//tbody[1]//tr["+i+"]//td[9]//select[1]")));
		//			doctorDropdown.selectByVisibleText(doctorName);
		//			logger.info("Following Doctor Name has been selected from Doctor Name Dropdown : " + doctorName);
		//}

		List<WebElement> Diagnostics_table_list = driver.findElements(By.xpath("//table[@id='tbldiagnosis']//tbody//tr"));
		for(int i=1;i<=Diagnostics_table_list.size();i++) 
		{
			Thread.sleep(2000);
			WebElement service_element = driver.findElement(By.xpath("(//table[@id='tbldiagnosis']//tbody//tr)["+i+"]//select[@name='dlspec']"));

			Select serviceDropdown = new Select(service_element);
			serviceDropdown.selectByVisibleText(speciality);
			Thread.sleep(2000);
			WebElement doctorname_element = driver.findElement(By.xpath("(//table[@id='tbldiagnosis']//tbody//tr)["+i+"]//select[@name='dlspec']//following::td//select[@class='form-control']"));

			Select doctornameDropdown = new Select(doctorname_element);
			doctornameDropdown.selectByVisibleText(doctorName);	
		}
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
		Thread.sleep(3000);
		driver.waitForElementPresent(MANUAL_ICON);
		WebElement icon = driver.findElement(MANUAL_ICON);
		driver.clickByJS(TTWebsiteDriver.driver, icon);
		logger.info("Manual Icon Clicked");
	}

	public void selectServiceNameFromDropdown(String name) throws InterruptedException {
		Thread.sleep(3000);
		driver.waitForElementPresent(SERVICE_NAME_DROPDOWN);
		Select serviceDropdown = new Select(driver.findElement(SERVICE_NAME_DROPDOWN));
		serviceDropdown.selectByVisibleText(name);
		logger.info("Following Name of Service name has been selected from service name Dropdown : " + name);
	}

	public void clickOnVerifyButton() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(VERIFY_BUTTON).click();
		logger.info("Verify Button Clicked");
	}

	public boolean verifySerivesErrorMessageIsShowingUp() throws InterruptedException{
		driver.waitForElementPresent(SERVICE_ERROR_MESSAGE);
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
		driver.findElement(OTHER_SERVICES_ICON).click();
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
		driver.waitForElementPresent(CHOOSE_SERVICES_DROPDOWN_IN_OTHER_SERVICES);
		Select serviceDropdown = new Select(driver.findElement(CHOOSE_SERVICES_DROPDOWN_IN_OTHER_SERVICES));
		serviceDropdown.selectByVisibleText(services);
		logger.info("Following Service Name has been selected from service Dropdown : " + services);
		driver.findElement(By.xpath("//li[contains(text(),'"+item+"')]")).click();
		logger.info("Following Item has been selected from Services: " +item);
	}

	public void selectSpecialityAndDoctor(String speciality,String doctor) {
		//		driver.waitForElementPresent(By.xpath("//tr//td[5]//select[1]"));
		//		
		//		Select specialityDropdown = new Select(driver.findElement(By.xpath("//tr//td[5]//select[1]")));
		//		specialityDropdown.selectByVisibleText(speciality);
		//		
		//		Select doctorDropdown = new Select(driver.findElement(By.xpath("//select[@id='osdoc0']")));
		//		doctorDropdown.selectByVisibleText(doctor);

		WebElement specialityDropdown_element = driver.findElement(By.xpath("(//table[@id='tblotherservice']//tbody//tr//select[@class='form-control'])[1]"));

		Select specialityDropdown = new Select(specialityDropdown_element);
		specialityDropdown.selectByVisibleText(speciality);

		WebElement doctorDropdown_element = driver.findElement(By.xpath("(//table[@id='tblotherservice']//tbody//tr//select[@class='form-control'])[2]"));
		Select doctorDropdown = new Select(doctorDropdown_element);
		doctorDropdown.selectByVisibleText(doctor);

		logger.info("Speciality And Doctor Selected");
	}

	public void selectSpecialityAndDoctor() throws InterruptedException {
		Thread.sleep(2000);
		driver.waitForElementPresent(By.xpath("//tr//td[5]//select[1]"));
		Select specialityDropdown = new Select(driver.findElement(By.xpath("//tr//td[5]//select[1]")));
		specialityDropdown.selectByIndex(1);
		Select doctorDropdown = new Select(driver.findElement(By.xpath("//select[@id='osdoc0']")));
		doctorDropdown.selectByIndex(1);
		logger.info("Speciality And Doctor Selected");


		WebElement specialityDropdown_element = driver.findElement(By.xpath("(//table[@id='tblotherservice']//tbody//tr//select[@class='form-control'])[1]"));


	}

	public void enterRefferedBy(String reffered) {
		driver.findElement(REFFERED_BY_TEXTBOX_IN_OTHER_SERVICES).sendKeys(reffered);
		driver.findElement(REFFERED_BY_TEXTBOX_IN_OTHER_SERVICES).sendKeys(Keys.ENTER);
		driver.waitForElementPresent(By.xpath("//tbody[@id='tblrefdr']/tr/td[1]"));
		driver.click(By.xpath("//tbody[@id='tblrefdr']/tr/td[1]"));

		logger.info("Following Reffered By has been added : " +reffered);
	}

	public void selectFacilitatorFromDropdown(int index) {

		driver.waitForElementPresent(FACILITATOR_DROPDOWN);
		Select facilitator = new Select(driver.findElement(FACILITATOR_DROPDOWN));
		facilitator.selectByIndex(index);
		logger.info("Following facilitator has been selected from facilitator  Dropdown : " + index);
	}

	public void clickOnAddToBillButton() {

		WebElement ADD_TO_BILL_BUTTON_element = driver.findElement(ADD_TO_BILL_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, ADD_TO_BILL_BUTTON_element);
		logger.info("Add to Bill Buttton Clicked");

		try {
			driver.waitForElementPresent(YES_BUTTON_CONFIRM_COMP_DETAILS);
			driver.click(YES_BUTTON_CONFIRM_COMP_DETAILS);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifyInvestigationInstructionPopupIsPresent() throws InterruptedException{
		driver.waitForElementPresent(INVESTIGATION_INSTRUCTION_POPUP);
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
			driver.findElement(RESPONSE_TEXT_FIELD).sendKeys(response);
			driver.click(ADD_BTN_INVESTIGATION_INSTRUCTION_POPUP);
			logger.info("Response has been added in Investigation Popup");
		}
		catch (Exception e) {
			//e.printStackTrace();
		}
	}

	public void clickOnBillingButtonOnHeader() {
		WebElement button = driver.findElement(BILLING_BTN_HEADER);
		driver.clickByJS(TTWebsiteDriver.driver, button);
		logger.info("Billing Button on header clicked");
	}

	public void enterBillingRemarks() {
		driver.waitForElementPresent(By.xpath("//textarea[@id='billremark']"));
		driver.findElement(By.xpath("//textarea[@id='billremark']")).sendKeys("Billing Remarks");
	}

	public void clickOnyesBtnOnGenrateBillPopup() {
		driver.waitForElementPresent(YES_BUTTON_GENERATE_BILL_POPUP);
		driver.click(YES_BUTTON_GENERATE_BILL_POPUP);
		logger.info("Yes Button On Generate Bill Popup Clicked");
	}

	public void enterPatientPaidAmount(String amount) {
		driver.waitForElementPresent(PATIENT_PAID_AMOUNT_PROCESS_PAYMENT_POPUP);
		driver.findElement(PATIENT_PAID_AMOUNT_PROCESS_PAYMENT_POPUP).clear();
		driver.findElement(PATIENT_PAID_AMOUNT_PROCESS_PAYMENT_POPUP).sendKeys(amount);
		logger.info("Following Amount has been added as patient Paid Amount: "+amount);
	}


	public void enterPatientPaidAmountForSecondTransaction(String amount) {
		driver.waitForElementPresent(By.xpath("(//input[@ctype='amount'])[2]"));
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
		Select facilitator = new Select(driver.findElement(SECOND_PAYMENT_MODE));
		facilitator.selectByVisibleText("Cheque");
		logger.info("Second Payment MOde selected as Cheque");
	}


	public void selectSecondPaymentMode(String mode) {
		Select facilitator = new Select(driver.findElement(SECOND_PAYMENT_MODE));
		facilitator.selectByVisibleText(mode);
		logger.info("Second Payment MOde selected");
	}


	public void enterChequeDetailsAndSaveDetails(String chequeNumber, String bankName, String branch) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='chequeNo']")).sendKeys(chequeNumber);
		//		driver.findElement(By.xpath("//input[@id='chequeDate']")).sendKeys(date);
		//		driver.findElement(By.xpath("//input[@id='chequeValidaty']")).sendKeys(validity);
		Select bank = new Select(driver.findElement(By.xpath("//select[@id='ChequeBank']")));
		bank.selectByVisibleText(bankName);
		driver.findElement(By.xpath("//input[@id='ChequeBranch']")).sendKeys(branch);
		Thread.sleep(6000);
		WebElement element = driver.findElement(By.xpath("//a[@id='verify_modes']//i[@class='fa fa-save']"));
		driver.clickByJS(TTWebsiteDriver.driver, element);
		Thread.sleep(5000);
		logger.info("Cheque Details has been filled");

	}

	public boolean verifyBillGotGenerated(String message) throws InterruptedException{
		driver.pauseExecutionFor(10000);
		driver.waitForElementPresent(GENRATED_BILL_POPUP);
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
		driver.waitForElementPresent(NO_BTN_BILL_GOT_GENERATED_POPUP);
		driver.click(NO_BTN_BILL_GOT_GENERATED_POPUP);
		logger.info("No Button on Bill Got Generated Popup Clicked");
	}

	public void clickonYesButtonOnBillGotGenertedPopup() ///////////////////////////dgdf
	{
		driver.waitForElementPresent(YES_BTN_BILL_GOT_GENERATED_POPUP);
		driver.click(YES_BTN_BILL_GOT_GENERATED_POPUP);
		logger.info("Yes Button on Bill Got Generated Popup Clicked");
		//		try {
		//			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		//			driver.manage().window().maximize();
		//			JavascriptExecutor js = (JavascriptExecutor) driver; 
		//			WebElement clearData = (WebElement) js.executeScript("return document.querySelector('settings-ui').shadowRoot.querySelector('settings-main').shadowRoot.querySelector('settings-basic-page').shadowRoot.querySelector('settings-section > settings-privacy-page').shadowRoot.querySelector('settings-clear-browsing-data-dialog').shadowRoot.querySelector('#clearBrowsingDataDialog').querySelector('#clearBrowsingDataConfirm')");
		//			// now you can click on clear data button
		//			clearData.click();
		//		}
		//		catch (Exception e) {
		//			e.printStackTrace();
		//		}
	}

	public void enterDetailsInCompDetailsPopupAndPressYesButton(String compType, String company, String corpCompany, String rate, String standardDeductible, String standardCoPay) throws InterruptedException {
		driver.waitForElementPresent(COMP_TYPE_COMP_DETAILS_POPUP);
		try {
			Select coType = new Select(driver.findElement(COMP_TYPE_COMP_DETAILS_POPUP));
			coType.selectByVisibleText(compType);
			Thread.sleep(2000);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Select comp = new Select(driver.findElement(COMPANY_COMP_DETAILS_POPUP));
			comp.selectByVisibleText(company);
			Thread.sleep(2000);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Select corp1 = new Select(driver.findElement(CORPORATE_COMP_DETAILS_POPUP));
			corp1.selectByVisibleText(corpCompany);
			Thread.sleep(2000);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Select rateCont = new Select(driver.findElement(RATE_CONTRACT_COMP_DETAILS_POPUP));
			rateCont.selectByVisibleText(rate);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		try {
			if(driver.findElements(By.xpath("//div[@class='modal-block-new top30']//span[text()='Document Check List']")).size()>0) 
			{
				driver.findElement(By.xpath("//span//a[@id='_closelistpop']")).click();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(4000);

		try {

			driver.click(By.xpath("//a[@id='_savelist']//i[@class='fa fa-save']"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(STANDARD_DEDUCTABLE_COMP_DETAILS_POPUP).clear();
		driver.findElement(STANDARD_DEDUCTABLE_COMP_DETAILS_POPUP).sendKeys(standardDeductible);
		Thread.sleep(2000);
		driver.findElement(STANDARD_CO_PAY_COMP_DETAILS_POPUP).clear();
		driver.findElement(STANDARD_CO_PAY_COMP_DETAILS_POPUP).sendKeys(standardCoPay);
		try {
			driver.click(By.xpath("//a[@id='_savelist']//i[@class='fa fa-save']"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			///e.printStackTrace();
		}
		driver.click(PLUS_BUTTON_COMP_DETAILS_POPUP);
		driver.waitForElementPresent(YES_BUTTON_CONFIRM_COMP_DETAILS);
		driver.click(YES_BUTTON_CONFIRM_COMP_DETAILS);
		logger.info("Details Entered In Comp Details Popup And Pressed Yes Button");

	}

	public void enterDetailsInCompDetailsPopupAndPressYesButtonMethod1(String compType, String company, String corpCompany, String rate, String standardDeductible, String standardCoPay) throws InterruptedException {
		driver.waitForElementPresent(COMP_TYPE_COMP_DETAILS_POPUP);
		Select coType = new Select(driver.findElement(COMP_TYPE_COMP_DETAILS_POPUP));
		coType.selectByVisibleText(compType);
		Thread.sleep(2000);
		Select comp = new Select(driver.findElement(COMPANY_COMP_DETAILS_POPUP));
		comp.selectByVisibleText(company);
		Thread.sleep(5000);
		Select corp1 = new Select(driver.findElement(CORPORATE_COMP_DETAILS_POPUP));
		corp1.selectByValue(corpCompany);
		Thread.sleep(2000);
		Select rateCont = new Select(driver.findElement(RATE_CONTRACT_COMP_DETAILS_POPUP));
		rateCont.selectByVisibleText(rate);



		Thread.sleep(4000);

		try {
			selectDocumentFromDocumentChecklistPopup("Case Record");
			selectDocumentFromDocumentChecklistPopup("PAN Card");
			selectDocumentFromDocumentChecklistPopup("Form 60");
			selectDocumentFromDocumentChecklistPopup("OP Prescription");
			driver.click(By.xpath("//a[@id='_savelist']//i[@class='fa fa-save']"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		driver.findElement(STANDARD_DEDUCTABLE_COMP_DETAILS_POPUP).clear();
		driver.findElement(STANDARD_CO_PAY_COMP_DETAILS_POPUP).clear();
		driver.findElement(STANDARD_DEDUCTABLE_COMP_DETAILS_POPUP).sendKeys(standardDeductible);
		driver.findElement(STANDARD_CO_PAY_COMP_DETAILS_POPUP).sendKeys(standardCoPay);
		try {
			driver.click(By.xpath("//a[@id='_savelist']//i[@class='fa fa-save']"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.click(PLUS_BUTTON_COMP_DETAILS_POPUP);
		driver.waitForElementPresent(YES_BUTTON_CONFIRM_COMP_DETAILS);
		driver.click(YES_BUTTON_CONFIRM_COMP_DETAILS);
		logger.info("Details Entered In Comp Details Popup And Pressed Yes Button");

	}

	public void selectSchemeAuthorisedSchemeDetailsPopup(String scheme, String authorisedBy, String schemeForPatient) throws InterruptedException {
		try {
		Select schemeName = new Select(driver.findElement(SCHEME_SCHEME_DETAIL_POPUP));
		schemeName.selectByVisibleText(scheme);
		Thread.sleep(3000);
		}
		catch (Exception e) {
		}
		try {
		Select authorised = new Select(driver.findElement(AUTHORISED_BY_DROPDOWN_SCHEME_DETAIL_POPUP));
		authorised.selectByVisibleText(authorisedBy);
		Thread.sleep(3000);
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
		WebElement add_btn_element = driver.findElement(By.xpath("//a[@id='addinsurance']//i"));
		driver.clickByJS(TTWebsiteDriver.driver, add_btn_element);

	}
	public void selectSchemeFromSchemeForPatientPopup(String schemeForPatient) {
		if(driver.findElement(SCHEME_FOR_PATIENT_POPUP).isDisplayed()==true) {
			driver.findElement(By.xpath("//td[contains(text(),'"+schemeForPatient+"')]"));
		}
		logger.info("Following Scheme From Scheme For Patient Popup selected"+schemeForPatient);
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

	public boolean verifyPrintOPDMessageIsDisplaying(String message) throws InterruptedException{
		driver.waitForElementPresent(PRINT_OPD_MESSAGE);
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
			driver.waitForElementPresent(YES_BTN_OPD);
			driver.click(YES_BTN_OPD);
			logger.info("Yes Button On OPD Popup Clicked");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectVisitTypeFromVisitTypeDropdown(String visit) {
		driver.waitForElementPresent(VISIT_TYPE_DROPDOWN);
		Select visitDropdown = new Select(driver.findElement(VISIT_TYPE_DROPDOWN));
		visitDropdown.selectByVisibleText(visit);
		logger.info("Following Visit Type  has been selected from Visit Type : " + visit);
	}

	public void clickOnPhysicianOrderIcon() {
		driver.findElement(PHYSICIAN_ICON).click();
		logger.info("Physician Order Icon Clicked");
	}

	public void clickOnSaveButtonOnDocumentChecklistPopup() throws InterruptedException {
		try {
		Thread.sleep(3000);
		WebElement checkall_element = driver.findElement(By.xpath("//input[@id='_alldoccheck']"));
		driver.clickByJS(TTWebsiteDriver.driver, checkall_element);
		Thread.sleep(3000);
		driver.waitForElementPresent(SAVE_BUTTON_DOCUMENT_CHECKLIST_POPUP);
		WebElement SAVE_BUTTON_element = driver.findElement(SAVE_BUTTON_DOCUMENT_CHECKLIST_POPUP);
		driver.clickByJS(TTWebsiteDriver.driver, SAVE_BUTTON_element);
		logger.info("Save Button On Document Checklist popup Clicked");
		}
		catch (Exception e) {
		}
	}

	public void clickOnCloseButtonOnDocumentChecklistPopup() throws InterruptedException {
		//		Thread.sleep(3000);
		//		driver.waitForElementPresent(CLOSE_BUTTON_DOCUMENT_CHECKLIST_POPUP);
		//		driver.click(CLOSE_BUTTON_DOCUMENT_CHECKLIST_POPUP);
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
		Thread.sleep(3000);
		driver.click(CASE_RECORD_CHECKBOX);
		Thread.sleep(1000);
		driver.click(CASE_RECORD_CHECKBOX);
		logger.info("Case record Checkbox Checked");
	}

	public void checkPanCardCheckboxFromDocumentCheckList() throws InterruptedException {
		driver.click(PAN_CARD_CHECKBOX);
		Thread.sleep(1000);
		driver.click(PAN_CARD_CHECKBOX);
		logger.info("Pamn Card Checkbox Checked");
	}

	public void checkForm60CheckboxFromDocumentCheckList() {
		driver.click(FORM_60_CHECKBOX);
		logger.info("Form 60 Checkbox Checked");
	}

	public void clickOnInsuranceCompanyButton() {
		try {
			WebElement InsuranceCompanyButton = driver.findElement(INSURANCE_COMPANY_BUTTON);
			driver.clickByJS(TTWebsiteDriver.driver, InsuranceCompanyButton);
			logger.info("Insurance Company Button Clicked");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void selectInsuranceCompRadioButtonOnCompDetailsPopup() {
		driver.waitForElementPresent(INSURANCE_RADIO_BTN_ON_COMP_DETAILS);
		driver.click(INSURANCE_RADIO_BTN_ON_COMP_DETAILS);
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
			driver.waitForElementPresent(CANCEL_SCHEME_FOR_PATIENT);
			driver.click(CANCEL_SCHEME_FOR_PATIENT);
			logger.info("Cancel Button Clicked on Scheme For Patient Popup");
		}

	}

	public void checkDiscountCheckbox() {
		driver.waitForElementPresent(DISCOUNT_CHECKBOX);
		driver.click(DISCOUNT_CHECKBOX);
		logger.info("Discount Checkbox checked under billing section");
	}

	public void clickOnYesBtnUnderProvideDiscountPopup() throws InterruptedException {
		driver.waitForElementPresent(YES_BTN_PROVIDE_DISCOUNT);
		Thread.sleep(5000);
		WebElement element = driver.findElement(YES_BTN_PROVIDE_DISCOUNT);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		//		driver.click(YES_BTN_PROVIDE_DISCOUNT);
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
		driver.waitForElementPresent(DISCOUNT_ON_DROPDOWN);
		Select occupationDropdown = new Select(driver.findElement(DISCOUNT_ON_DROPDOWN));
		occupationDropdown.selectByVisibleText(discountOn);
		logger.info("Following Discount On Has been selected from Discount On Dropdown : " + discountOn);
	}

	public void selectDiscountHeadFromDropdown(String discountHead) {
		driver.waitForElementPresent(DISCOUNT_HEAD_DROPDOWN);
		Select occupationDropdown = new Select(driver.findElement(DISCOUNT_HEAD_DROPDOWN));
		occupationDropdown.selectByVisibleText(discountHead);
		logger.info("Following Discount head Has been selected from Discount Head Dropdown : " + discountHead);
	}

	public void selectDiscountReasonFromDropdown(String discountReason) {
		driver.waitForElementPresent(DISCOUNT_REASON_DROPDOWN);
		Select occupationDropdown = new Select(driver.findElement(DISCOUNT_REASON_DROPDOWN));
		occupationDropdown.selectByVisibleText(discountReason);
		logger.info("Following Discount Reason Has been selected from Discount Reason Dropdown : " + discountReason);
	}

	public boolean isAuthorisedByErrorMessageDisplayed() {
		return driver.isElementPresent(AUTHORISED_BY_ERROR);
	}

	public void selectAuthorisedByFromDropdown(String authorisedBy) {
		driver.waitForElementPresent(AUTHORISED_BY_DORPDOWN);
		Select occupationDropdown = new Select(driver.findElement(AUTHORISED_BY_DORPDOWN));
		occupationDropdown.selectByVisibleText(authorisedBy);
		logger.info("Following Authorised By Has been selected from Authorised By Dropdown : " + authorisedBy);
	}

	public void clickOnDraftButtonOnHeader() throws InterruptedException {
		driver.waitForElementPresent(DRAFT_BUTTON_HEADER);
		Thread.sleep(3000);
		WebElement button = driver.findElement(DRAFT_BUTTON_HEADER);
		driver.clickByJS(TTWebsiteDriver.driver, button);
		logger.info("Draft Button on header clicked");
	}

	public void clickOnSchemeButtonNearAddToBill() {
		driver.waitForElementPresent(SCHEME_BUTTON_NEAR_ADD_TO_BILL);
		driver.click(SCHEME_BUTTON_NEAR_ADD_TO_BILL);
		logger.info("Scheme Button near add to bill button clicked");
	}

	public void enterPatientPaidAmountForCheque(String amount) {
		driver.waitForElementPresent(PATIENT_PAID_AMOUNT_CHEQUE_PROCESS_PAYMENT_POPUP);
		driver.findElement(PATIENT_PAID_AMOUNT_CHEQUE_PROCESS_PAYMENT_POPUP).clear();
		driver.findElement(PATIENT_PAID_AMOUNT_CHEQUE_PROCESS_PAYMENT_POPUP).sendKeys(amount);
		logger.info("Following Cheque Amount has been added as patient Paid Amount: "+amount);
	}

	public void selectAuthorisedByFromProcessPaymentDropdown(String authorisedBy) {
		driver.waitForElementPresent(AUTHORISED_BY_PROCESS_PAYMENT);
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
		driver.waitForElementPresent(SCHEME_EXPIRY_POPUP);
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
		Thread.sleep(3000);
		driver.waitForElementPresent(PREVIOUS_VISIT_ICON);		
		WebElement element =	driver.findElement(PREVIOUS_VISIT_ICON);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Previous Visit Icon Clicked");
	}

	public boolean isPreviousVisitPopupOpened() {
		return driver.isElementPresent(PREVIOUS_VISIT_POPUP);
	}

	public void closePreviousVisitPopup() {
		driver.click(CLOSE_PREVIOUS_VISIT_POPUP);
		logger.info("Previous Visit Popup Closed");
	}

	public void selecServiceNameFromPercentagePopupDropdown(String service) {
		driver.waitForElementPresent(SERVICE_NAME_DROPDOWN_PERCENTAGE_POPUP);
		Select occupationDropdown = new Select(driver.findElement(SERVICE_NAME_DROPDOWN_PERCENTAGE_POPUP));
		occupationDropdown.selectByVisibleText(service);
		logger.info("Following Service Name Has been selected from Service Name Dropdown : " + service);
	}

	public void selecItemDoctorNameFromDiscountPopupDropdown(String service) {
		driver.waitForElementPresent(ITEM_DOCTOR_PROCESS_DISCOUNT_POPU);
		Select occupationDropdown = new Select(driver.findElement(ITEM_DOCTOR_PROCESS_DISCOUNT_POPU));
		occupationDropdown.selectByVisibleText(service);
		logger.info("Following Iteam/Doctor Name Has been selected from Item Doctor Name Dropdown : " + service);
	}

	public void selectOnCompanyRadioButton() {
		driver.click(ON_COMPANY_RADIO_BTN_PERCENTAGE_POPUP);
		logger.info("On Company Radio Button Clicked");
	}

	public void selectOnPatientRadioButton() {
		driver.click(ON_PATIENT_RADIO_BTN_PERCENTAGE_POPUP);
		logger.info("On Patient Radio Button Clicked");
	}

	public void clickClearButtonCompDetails() {
		driver.waitForElementPresent(CLEAR_BTN_COMP_DETAILS);
		WebElement CLEAR_BTN_COMP_DETAILS_element = driver.findElement(CLEAR_BTN_COMP_DETAILS);
		driver.clickByJS(TTWebsiteDriver.driver, CLEAR_BTN_COMP_DETAILS_element);
		logger.info("Clear Button On Comp Details Popup Clicked");
	}

	public void enterDiscountAmount(String amount) {
		driver.findElement(DISCOUNT_AMOUNT_PROCESS_DISCOUNT_POPUP).clear();
		driver.findElement(DISCOUNT_AMOUNT_PROCESS_DISCOUNT_POPUP).sendKeys(amount);
	}

	public boolean isCompOnlyDiscoutErrorMessageDisplayed() {
		return driver.isElementPresent(COMP_DISCOUNT_NOT_ALLOWED_MESSAGE);
	}

	public void clickOnSearchNewButtonOnHeader() {
		driver.waitForElementPresent(SEARCH_NEW_BTN_HEADER);
		WebElement search_new_btn_element = driver.findElement(SEARCH_NEW_BTN_HEADER);
		driver.clickByJS(TTWebsiteDriver.driver, search_new_btn_element);
		logger.info("Search New Button on header clicked");//////////////////////////////////////
	}

	public void clickClearButtonOnHeader(){
		driver.waitForElementPresent(CLEAR_BTN_HEADER);
		driver.click(CLEAR_BTN_HEADER);
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
		driver.click(PATIENT_MAPPED_POPUP_YES_BUTTON);
		logger.info("Yes Button clicked on Patient Mapped Popup");
	}

	public void clickOnNoButtonOnPatientMappedPopup() {
		driver.click(PATIENT_MAPPED_POPUP_NO_BUTTON);
		logger.info("No Button clicked on Patient Mapped Popup");
	}

	public void searchPatientWithMobileNumber(String mobile) throws InterruptedException {
		driver.waitForElementPresent(MOBILE_NUMBER_SEARCH);
		Thread.sleep(5000);
		driver.findElement(MOBILE_NUMBER_SEARCH).sendKeys(mobile);
		driver.findElement(MOBILE_NUMBER_SEARCH).sendKeys(Keys.ENTER);
		logger.info("Following Mobile Number has been searched "+mobile);
	}

	public void clickOnPatientIdFromSearch(String patientId) throws InterruptedException {
		driver.waitForElementPresent(By.xpath("//td[contains(text(),'"+patientId+"')]//ancestor::tr[1]"));
		Thread.sleep(5000);
		WebElement element =driver.findElement(By.xpath("//td[contains(text(),'"+patientId+"')]//ancestor::tr[1]"));
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Following patien ID has been clicked "+patientId);

	}

	public boolean isDiscountExceededMessageDisplayed() {
		driver.waitForElementPresent(DISCOUNT_CANNOT_EXCEED_MESSAGE);
		return driver.isElementPresent(DISCOUNT_CANNOT_EXCEED_MESSAGE);
	}

	public void clickOnYesButtonOnAvailDepositPopup() {
		driver.waitForElementPresent(YES_BTN_AVAIL_DEPOSIT_POPUP);
		driver.click(YES_BTN_AVAIL_DEPOSIT_POPUP);
	}

	public void enterAjustFromDeposit(String deposit) {
		driver.waitForElementPresent(ADJUST_FROM_DEPOSIT_TEXT_BOX);
		driver.findElement(ADJUST_FROM_DEPOSIT_TEXT_BOX).clear();
		driver.findElement(ADJUST_FROM_DEPOSIT_TEXT_BOX).sendKeys(deposit);
	}

	public boolean isCashBillingNotAllowedMessageDisplayed() {
		return driver.isElementPresent(By.xpath("//p[contains(text(),'Cash billing not allowed for this rate contract!')]"));
	}

	public void selectRateContractInCompDetailsPopup(String rateContract) {
		driver.waitForElementPresent(By.xpath("//select[@id='rate_contract']"));
		Select authorised = new Select(driver.findElement(By.xpath("//select[@id='rate_contract']")));
		authorised.selectByVisibleText(rateContract);

	}

	public void selectDocumentFromDocumentChecklistPopup(String document) {
		//driver.waitForElementPresent(By.xpath("//td[contains(text(),'"+document+"')]//following::input[1]"), 120);
		//driver.click(By.xpath("//td[contains(text(),'"+document+"')]//following::input[1]"));
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
		driver.waitForElementPresent(By.xpath("//a[@id='search_huiddata']//i[@class='fa fa-search']"));
		WebElement button = driver.findElement(By.xpath("//a[@id='search_huiddata']//i[@class='fa fa-search']"));
		driver.clickByJS(TTWebsiteDriver.driver, button);
		logger.info("Search Icon Near Save Button clicked");
		driver.waitForElementPresent(By.xpath("//a[@id='search_UHID']//i[@class='fa fa-search search_buttondata']"), 120);
		driver.findElement(By.xpath("//a[@id='search_UHID']//i[@class='fa fa-search search_buttondata']")).click();
	}


	public void closeSearchUtilityPopup() {
		driver.pauseExecutionFor(5000);
		driver.waitForElementPresent(By.xpath("//div[@id='fosearch_patient']//i[@class='fa fa-times']"), 120);
		driver.click(By.xpath("//div[@id='fosearch_patient']//i[@class='fa fa-times']"));
	}


	public void clearManualSection() {
		driver.waitForElementPresent(By.xpath("//a[@id='new_manual_refresh']"), 120);
		driver.click(By.xpath("//a[@id='new_manual_refresh']"));
	}

	public void selectAythorisedByInProcessPaymentPopupAndAddRemarks(String name) {
		driver.waitForElementPresent(By.xpath("//select[@id='ddlAuthorised']"), 100);
		Select serviceDropdown = new Select(driver.findElement(By.xpath("//select[@id='ddlAuthorised']")));
		serviceDropdown.selectByVisibleText(name);
		driver.findElement(By.xpath("//input[@id='authorisedremarks']")).sendKeys("Testing Remarks");
	}

	public void clickOnVerifyButtonOnProcessPaymentPopup() {
		driver.waitForElementPresent(By.xpath("//button[@id='authorised_verify']"));
		driver.click(By.xpath("//button[@id='authorised_verify']"));
		driver.pauseExecutionFor(7000);
	}

	public void clickOnNoButtonOnPrintOPDCard() {
		driver.waitForElementPresent(By.xpath("//a[@id='btnnoopd']"), 120);
		driver.click(By.xpath("//a[@id='btnnoopd']"));
	}

	public void closeSchemeForPatientPopup() {
		driver.waitForElementPresent(By.xpath("//span[@id='remarks_close1']//i[@class='fa fa-times']"), 120);
		driver.click(By.xpath("//span[@id='remarks_close1']//i[@class='fa fa-times']"));
	}

	public void saveprocesspayment() {

		WebElement saveprocesspayment_element = driver.findElement(By.xpath("//a[@id='verify_modes']//i"));
		driver.clickByJS(TTWebsiteDriver.driver, saveprocesspayment_element);
	}
	public void closepopup() {
		driver.findElement(By.xpath("(//a[@title='Close']//i)[1]")).click();
	}
}

