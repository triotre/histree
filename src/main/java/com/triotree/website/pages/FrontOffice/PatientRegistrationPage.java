package com.triotree.website.pages.FrontOffice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.triotree.driver.TTDriver;
import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

public class PatientRegistrationPage extends HISWebsiteBasePage{
	private static final Logger logger = LogManager
			.getLogger(PatientRegistrationPage.class.getName());

	public PatientRegistrationPage(TTWebsiteDriver driver) {
		super(driver);
	}


	private final By TITLE_DROP_DOWN = By.id("title");
	private final By FIRST_NAME = By.id("firstName");
	private final By MIDDLE_NAME = By.id("middleName");
	private final By LAST_NAME = By.id("lastName");
	private final By GENDER_DROPDOWM = By.id("gender");
	private final By DOD_TEXT_BOX = By.id("dob");
	private final By AGE_RADIO_BUTTON = By.id("chkA");
	private final By AGE_TEXT_BOX = By.id("age");
	private final By AGE_ALERT_MESSAAGE = By.xpath("//p[contains(text(),'Please enter Date of Birth Age is less than 18 yea')]");
	private final By MARIAL_STATUS_DROPDOWN = By.id("mStatus");
	private final By MOTHER_MAIDEN_NAME = By.id("motherName");
	private final By FATHERS_NAME = By.id("relName");
	private final By NATIONALITY_DROPDOWN = By.id("nationality");
	private final By VIP_CHECKBOX = By.id("vip");
	private final By VIP_TEXT_BOX = By.id("vipText");
	private final By REMARKS_CHECKBOX = By.id("remarks");
	private final By REMARKS_TEXT_BOX = By.id("remarksText");
	private final By NRI_CHECK_BOX = By.id("nri");
	private final By ID_CARD_DROP_DOWN = By.id("cardType");
	private final By NATIONAL_ID_TEXT_BOX = By.id("Nationalid");
	private final By TELEPHONE_NO = By.id("teleNo");
	private final By MOBILE_NUMBER = By.id("mobileNo");
	private final By MOBILE_ALERT_MESSAGE = By.xpath("//p[contains(text(),'mobile number should not be less than 10 digit')]");
	private final By RGISTER_ICON = By.id("register");
	private final By HOUSE_NO = By.id("address");
	private final By CITY_DROP_DOWN = By.id("city");
	private final By ADD_NEW_CITY = By.id("addcity");
	private final By CITY_FROM_POPUP = By.id("city_name");
	private final By DISTRICT_DROP_DOWN_FROM_POPUP = By.id("Districtid");
	private final By SAVE_BUTTON_FROM_POPUP = By.id("SaveCity");
	private final By CLEAR_BUTTON_FROM_POPUP = By.id("ClearCity");
	private final By ADD_LOCALITY_BUTTON = By.id("addlocal");
	private final By LOCALITY_FROM_POPUP = By.id("local");
	private final By CITY_DROPDOWN_FROM_POPUP = By.id("Citysave");
	private final By PINCODE = By.id("Pincode");
	private final By SAVE_BUTTON_LOCALITY_POPUP = By.id("Save");
	private final By EMAIL_ID = By.id("emailID");
	private final By EMAIL_ID_MESSAGE = By.xpath("//p[contains(text(),'Please enter correct email Id!')");
	private final By REFFERED_BY_TEXT_BOX = By.id("refDr");
	private final By LANGUAGE_DROP_DOWN = By.id("lang");
	private final By OCCUPATION_DROP_DOWN = By.id("occupation");
	private final By QUALIFICATION_DROP_DOWN = By.id("qualification");
	private final By RELIGION_DROP_DOWN = By.id("religion");
	private final By REFER_DROP_DOWN = By.id("sref");
	private final By FINANCIAL_DETAILS_CHECKBOX = By.id("fin");
	private final By COMP_TYPE_DROP_DOWN = By.id("companytype");
	private final By COMP_DROP_DOWN = By.id("company");
	private final By SHOW_ALL_CHECK_BOX = By.id("Showall");
	private final By RATE_DROP_DOWN = By.id("rate");
	private final By SCHEME_CHECKBOX = By.id("chkscheme");
	private final By SCHEME_DROP_DOWN = By.id("scheme");

	//--------------------------------------------------------------------------------------------	
	private final By FILLACTUALDEMOGRAPHICS_ICON = By.xpath("//a[@id='btndemographic']//img");
	private final By FILLACTUALDEMOGRAPHICS_TITLE_DROP_DOWN = By.xpath("//select[@id='ddltitle']");
	private final By FILLACTUALDEMOGRAPHICS_FIRST_NAME = By.xpath("//input[@id='txtfirstname']");
	private final By FILLACTUALDEMOGRAPHICS_MIDDLE_NAME = By.xpath("//input[@id='txtmiddlename']");
	private final By FILLACTUALDEMOGRAPHICS_LAST_NAME = By.xpath("//input[@id='txtlastname']");
	private final By FILLACTUALDEMOGRAPHICS_DOB = By.xpath("//input[@id='_actdob']");
	private final By FILLACTUALDEMOGRAPHICS_MOBILE = By.xpath("//input[@id='_actmobile']");
	private final By FILLACTUALDEMOGRAPHICS_ADDRESS= By.xpath("//input[@id='_actaddress']");
	private final By FILLACTUALDEMOGRAPHICS_GUARDIAN_NAME = By.xpath("//input[@id='_actGuardian']");
	private final By FILLACTUALDEMOGRAPHICS_CLOSE_BTN = By.xpath("//a[@id='btnclosealias']//i[@class='fa fa-times']");

	//--------------------------------------------------------------------------------------------		
	private final By CONFRM_PATIENT_DETAILS_POPUP_HEADER = By.xpath("//span[contains(text(),'Confirm Patient Details')]");
	private final By YES_BUTTON_CONFRM_PAT_DETAILS_POPUP = By.id("btnyesss");
	private final By REGISTERED_SUCCESSFULLY_POPUP_HEADER = By.xpath("//header[contains(text(),'Registered Successfully')]");
	private final By REGSITERED_SUCCESSFULLY_YES_BUTTON = By.xpath("//a[@id='btnyes']");
	private final By REGSITERED_SUCCESSFULLY_NO_BUTTON = By.xpath("//div[@class='popup-area']//div[@class='modal-block-new']//a[contains(text(),'No')]");
	private final By ALIAS_CHECKBOX = By.id("chkalias");
	private final By UHID_SEARCH_BOX = By.id("uHid");
	//---------------------------------------------------------------------------
	private final By UNMERGE_SELECT_CHECK_BOX = By.xpath("//input[@id='checkBox_selection0']");
	private final By UNMERGE_BUTTON = By.xpath("//a[@id='save_unmerge']//i[@class='fa fa-male']");

	//---------------------------------------------------------------------------
	private final By UPDATE_ICON = By.xpath("//i[@class='fa fa-edit']");

	//---------------------------------------------------------------------------
	private final By REASON_MODIFICATION_TEXTBOX = By.xpath("//textarea[@id='_reasonForModifiaction']");

	//---------------------------------------------------------------------------
	private final By YES_BUTTON_ON_UPDATE_POPUP = By.id("btnyessss");
	private final By SEARCH_PATIENT_BUTTON = By.id("searchnew");
	private final By SEARCH_PATIENT_POPUP_HEADER = By.xpath("//div[@id='modalnew']//span[@class='header_title']");
	private final By MOBILE_NO_SEARCH_PATIENT_POPUP = By.id("modal_mobileNo");
	private final By NAME_SEARCH_PATIENT_POPUP = By.id("modal_Name");
	private final By FIRST_NAME_SEARCH_PATIENT_POPUP = By.id("modal_firstName");
	private final By LAST_NAME_SEARCH_PATIENT_POPUP = By.id("modal_lastName");
	private final By ADDRESS_SEARCH_PATIENT_POPUP = By.id("modal_address");
	private final By LOCALITY_SEARCH_PATIENT_POPUP = By.id("modal_locality");
	private final By NATIONAL_ID_SEARCH_PATIENT_POPUP = By.id("modal_nationalID");
	private final By REMARKS_SEARCH_PATIENT_POPUP = By.id("modal_Remarks");
	private final By ERROR_MESSAGE_LESSER_CHARACTER = By.xpath("//p[contains(text(),'Plese enter atleast 3 charecters in of the search ')]");
	private final By FIRST_RESULT_IN_SEARCH_PATIENT_POPUP = By.xpath("//tbody//tr[1]//td[2]");
	private final By PATIENT_DECEASED_POPUP_BODY = By.xpath("//section[@class='popupBody1']");
	private final By POSSIBLE_DUPLICATE_ALERT_HEADING = By.xpath("//span[contains(text(),'Possible Duplicate Alert')]");
	private final By POSSIBLE_DUPLICATE_ALERT_CLOSE = By.xpath("//span[@id='duplicatepopupclose']//i[@class='fa fa-times']");
	private final By FIRST_RESULT_FROM_DUPLICATE_ALERT_POPUP  = By.xpath("//p[contains(text(),'Possible duplicate exists .Plese select the right ')]//following::tr[2]/td[1]");



	public void selectTitleFromTitleDropDown(String title) 
	{
		//driver.waitForElementPresent(TITLE_DROP_DOWN);
		try {
			WebElement title_element = driver.findElement(TITLE_DROP_DOWN);
			Select titleDropDown = new Select(title_element);
			titleDropDown.selectByVisibleText("Mr.");
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		logger.info("Following Title has been selected from Title Dropdown : " + title);
	}

	public void selectFillActualDemographicsCheckbox() {
		driver.waitForElementPresent(ALIAS_CHECKBOX);
		driver.click(ALIAS_CHECKBOX);
		logger.info("Alias Checkbox is checked");
	}

	public void enterFirstName(String firstName) {
		driver.waitForElementPresent(FIRST_NAME);
		driver.findElement(FIRST_NAME).clear();
		driver.findElement(FIRST_NAME).sendKeys(firstName);
		logger.info("First Name has been added as : " +  firstName);

	}

	public void enterMiddleName(String middleName) {
		driver.waitForElementPresent(MIDDLE_NAME);
		driver.findElement(MIDDLE_NAME).clear();
		driver.findElement(MIDDLE_NAME).sendKeys(middleName);
		logger.info("Middle Name has been added as : " +  middleName);

	}

	public void enterLastName(String lastName) {
		driver.waitForElementPresent(LAST_NAME);
		driver.findElement(LAST_NAME).clear();
		driver.findElement(LAST_NAME).sendKeys(lastName);
		logger.info("Last Name has been added as : " +  lastName);

	}

	public void selectGenderFromGenderDropDown(String gender) {
		driver.waitForElementPresent(GENDER_DROPDOWM);
		Select genderDropDown = new Select(driver.findElement(GENDER_DROPDOWM));
		genderDropDown.selectByVisibleText(gender);
		logger.info("Following Gender has been selected from Gender Dropdown : " + gender);
	}

	public void enterDob(String dob) {
		driver.waitForElementPresent(DOD_TEXT_BOX);
		driver.findElement(DOD_TEXT_BOX).sendKeys(dob);
		driver.clickAnyWhereOnScreen();
		logger.info("Following DOB has been added : " + dob);
	}

	public void enterAge(String age) throws InterruptedException {
		driver.waitForElementToBeClickable(AGE_RADIO_BUTTON, 40);
		Thread.sleep(8000);
		driver.waitForElementPresent(AGE_RADIO_BUTTON);
		WebElement checkBox = driver.findElement(AGE_RADIO_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, checkBox);
		driver.waitForElementPresent(AGE_TEXT_BOX);
		driver.findElement(AGE_TEXT_BOX).clear();
		driver.findElement(AGE_TEXT_BOX).sendKeys(age);
		driver.clickByJS(TTWebsiteDriver.driver, checkBox);
		logger.info("Following Age has been added : " + age);
	}

	public boolean verifyLesserAgeAlertMessage(String message) throws InterruptedException{
		driver.clickAnyWhereOnScreen();
		if(driver.findElement(AGE_ALERT_MESSAAGE).getText().contains(message))
		{
			logger.info("When User is entering age less than 18, alert message is showing up");
			return true;
		}
		else{
			return false;
		}
	}

	public void selectMartialStatusFromDropDown(String status) {
		driver.waitForElementPresent(MARIAL_STATUS_DROPDOWN,60);
		Select statusDropDown = new Select(driver.findElement(MARIAL_STATUS_DROPDOWN));
		statusDropDown.selectByVisibleText(status);
		logger.info("Following MArtial Status has been selected from MArtial Status  Dropdown : " + status);
	}

	public void enterMotherMaidenName(String motherName) {
		driver.waitForElementPresent(MOTHER_MAIDEN_NAME);
		driver.findElement(MOTHER_MAIDEN_NAME).sendKeys(motherName);
		logger.info("Following Mother Maiden Name Has been Added: " + motherName);
	}

	public void enterFathersName(String fatherName) {
		driver.waitForElementPresent(FATHERS_NAME);
		driver.findElement(FATHERS_NAME).sendKeys(fatherName);
		logger.info("Following Fathers Name Has been Added: " + fatherName);
	}

	public void selectNationalityFromDropDown(String nationality) {
		driver.waitForElementPresent(NATIONALITY_DROPDOWN);
		Select nationalityDropDown = new Select(driver.findElement(NATIONALITY_DROPDOWN));
		nationalityDropDown.selectByVisibleText(nationality);
		logger.info("Following Nationality has been selected from Nationality Dropdown : " + nationality);
	}

	public void checkVipCheckBoxAndEnterData(String data) {
		//driver.waitForElementPresent(By.xpath("//input[@id='vip']"),60);
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='vip']"));
		driver.clickByJS(TTWebsiteDriver.driver, checkBox);
		driver.findElement(VIP_TEXT_BOX).sendKeys(data);
		logger.info("VIP Checkbox has been selected and Data has been added to VIP Text Box");
	}

	public void checkRemarksCheckBoxAndEnterData(String data) {
		driver.waitForElementPresent(REMARKS_CHECKBOX,60);
		WebElement checkBox = driver.findElement(REMARKS_CHECKBOX);
		driver.clickByJS(TTWebsiteDriver.driver, checkBox);
		driver.findElement(REMARKS_TEXT_BOX).sendKeys(data);
		logger.info("Remarks Checkbox has been selected and Data has been added to Remarks Text Box");
	}

	public void checkNRIChecbox() {
		WebElement checkBox = driver.findElement(NRI_CHECK_BOX);
		driver.clickByJS(TTWebsiteDriver.driver, checkBox);
		logger.info("NRI Checkbox has been selected");
	}

	public boolean verifyIDCardDropDownIsEnabled() throws InterruptedException{
		driver.clickAnyWhereOnScreen();
		if(driver.findElement(ID_CARD_DROP_DOWN).isEnabled())
		{
			logger.info("ID Card Drop down is enabled");
			return true;
		}
		else{
			return false;
		}
	}

	public void selectIdCardTypeFromDropDown(String idcard) {
		driver.waitForElementPresent(ID_CARD_DROP_DOWN);
		Select titleDropDown = new Select(driver.findElement(ID_CARD_DROP_DOWN));
		titleDropDown.selectByVisibleText(idcard);
		logger.info("Following ID Card has been selected from ID Card Dropdown : " + idcard);
	}

	public void enterNationalID(String id) {
		driver.findElement(NATIONAL_ID_TEXT_BOX).sendKeys(id);
		logger.info("Following National ID has been added : " + id);
	}

	public void enterTelephoneNumber(String telephone) {
		driver.findElement(TELEPHONE_NO).sendKeys(telephone);
		logger.info("Following TELEPHONE NO has been added in TELEPHONE No Text Box : " + telephone);
	}

	public void enterMobileNumber(String mobile) {
		driver.findElement(MOBILE_NUMBER).sendKeys(mobile);
		logger.info("Following MOBILE NO has been added : " + mobile);
	}

	public boolean verifyInvalidMobileNoAlertMessage(String message) throws InterruptedException{
		driver.clickAnyWhereOnScreen();
		if(driver.findElements(MOBILE_ALERT_MESSAGE).size()>0) 
		{
			if(driver.findElement(MOBILE_ALERT_MESSAGE).getText().contains(message))
			{	
				logger.info("Alert SHowing up when adding Invalid Message");
				return true;
			}
			else{
				return false;
			}
		}
		return true; //changes by nishant

	}

	public void clickOnRegisterIcon() {
		driver.waitForElementPresent(RGISTER_ICON);
		WebElement icon = driver.findElement(RGISTER_ICON);
		driver.clickByJS(TTWebsiteDriver.driver, icon);
		logger.info("Regsiter Icon Clicked");
	}

	public void clickOnUpdateIcon() {
		driver.waitForElementPresent(UPDATE_ICON);
		WebElement icon = driver.findElement(UPDATE_ICON);
		driver.clickByJS(TTWebsiteDriver.driver, icon);
		logger.info("Update Icon Clicked");
	}

	//--------------------------------------------------------------
	public void enterReasonModification(String reasonmodification) {
		driver.findElement(REASON_MODIFICATION_TEXTBOX).sendKeys(reasonmodification);
		logger.info("Following house Number has been added "+ reasonmodification);
	}
	//--------------------------------------------------------------

	public void enterHouseNumber(String house) {
		driver.findElement(HOUSE_NO).sendKeys(house);
		logger.info("Following house Number has been added "+ house);
	}

	public void selectCityFromCityDropdown(String city) {
		driver.waitForElementPresent(CITY_DROP_DOWN);
		Select titleDropDown = new Select(driver.findElement(CITY_DROP_DOWN));
		titleDropDown.selectByVisibleText(city);
		logger.info("Following City  has been selected from City Dropdown : " + city);
	}

	public void addANewCity(String city, String district) throws InterruptedException {
		Thread.sleep(5000);
		WebElement ADD_NEW_CITY_element = driver.findElement(ADD_NEW_CITY);
		driver.clickByJS(TTWebsiteDriver.driver, ADD_NEW_CITY_element);
		driver.findElement(CITY_FROM_POPUP).sendKeys(city);
		Select districtDropDown = new Select(driver.findElement(DISTRICT_DROP_DOWN_FROM_POPUP));
		districtDropDown.selectByVisibleText(district);
		WebElement CLEAR_BUTTON_FROM_POPUP_element = driver.findElement(CLEAR_BUTTON_FROM_POPUP);
		driver.clickByJS(TTWebsiteDriver.driver, CLEAR_BUTTON_FROM_POPUP_element);
		driver.findElement(CITY_FROM_POPUP).sendKeys(city);
		Select districtDropDown1 = new Select(driver.findElement(DISTRICT_DROP_DOWN_FROM_POPUP));
		districtDropDown1.selectByVisibleText(district);
		Thread.sleep(4000);
		WebElement SAVE_BUTTON_FROM_POPUP_element = driver.findElement(SAVE_BUTTON_FROM_POPUP);
		driver.clickByJS(TTWebsiteDriver.driver, SAVE_BUTTON_FROM_POPUP_element);
		logger.info("Following City has been added"+city +"Following District has been selected");
	}

	public void addLocality(String local, String city, String pincode) throws InterruptedException {
		driver.waitForElementPresent(ADD_LOCALITY_BUTTON);
		WebElement button = driver.findElement(ADD_LOCALITY_BUTTON);
		driver.clickByJS(TTWebsiteDriver.driver, button);
		driver.waitForElementPresent(LOCALITY_FROM_POPUP);
		driver.findElement(LOCALITY_FROM_POPUP).sendKeys(local);
		Select cityDropDown = new Select(driver.findElement(CITY_DROPDOWN_FROM_POPUP));
		cityDropDown.selectByVisibleText(city);
		driver.findElement(PINCODE).sendKeys(pincode);
		Thread.sleep(8000);
		WebElement SAVE_BUTTON_element = driver.findElement(SAVE_BUTTON_LOCALITY_POPUP);
		driver.clickByJS(TTWebsiteDriver.driver, SAVE_BUTTON_element);
		logger.info("Follwoing Locality has been added: " +local+ "Following City has been selected: " +city+ "Following Pin Code has been added: " +pincode);
	}

	public void enterEmailId(String email) {
		driver.waitForElementPresent(EMAIL_ID);
		driver.findElement(EMAIL_ID).clear();
		driver.findElement(EMAIL_ID).sendKeys(email);
		logger.info("Following email has been added: " + email);
	}

	public boolean verifyInvalidEmailIdAlertMessage(String message) throws InterruptedException{
		if(driver.findElement(EMAIL_ID_MESSAGE).getText().contains(message))
		{
			logger.info("Alert Showing up when adding Invalid Email id");
			return true;
		}
		else{
			return false;
		}
	}

	public void enterRefferdBy(String refferedBy) {
		driver.findElement(REFFERED_BY_TEXT_BOX).sendKeys(refferedBy);
		logger.info("Following Reffered By has been added: "+refferedBy);
	}

	public void selectPrefferedLanguageFromDropdown(String language) {
		driver.waitForElementPresent(LANGUAGE_DROP_DOWN);
		Select languageDropdown = new Select(driver.findElement(LANGUAGE_DROP_DOWN));
		languageDropdown.selectByVisibleText(language);
		logger.info("Following language  has been selected from language Dropdown : " + language);
	}

	public void selectOccupationFromDropdown(String occupation) {
		driver.waitForElementPresent(OCCUPATION_DROP_DOWN);
		Select occupationDropdown = new Select(driver.findElement(OCCUPATION_DROP_DOWN));
		occupationDropdown.selectByVisibleText(occupation);
		logger.info("Following occupation  has been selected from occupation Dropdown : " + occupation);
	}

	public void selectQualificationFromDropdown(String qualification) {
		driver.waitForElementPresent(QUALIFICATION_DROP_DOWN);
		Select qualificationDropdown = new Select(driver.findElement(QUALIFICATION_DROP_DOWN));
		qualificationDropdown.selectByVisibleText(qualification);
		logger.info("Following qualification  has been selected from qualification Dropdown : " + qualification);
	}

	public void selectReligionFromDropdown(String relegion) {
		driver.waitForElementPresent(RELIGION_DROP_DOWN);
		Select relegionDropdown = new Select(driver.findElement(RELIGION_DROP_DOWN));
		relegionDropdown.selectByVisibleText(relegion);
		logger.info("Following relegion  has been selected from relegion Dropdown : " + relegion);
	}

	public void selectReferedFromDropdown(String refer) {
		driver.waitForElementPresent(REFER_DROP_DOWN);
		Select referDropdown = new Select(driver.findElement(REFER_DROP_DOWN));
		referDropdown.selectByVisibleText(refer);
		logger.info("Following refer  has been selected from refer Dropdown : " + refer);
	}

	public void checkFinancialDetailsCheckBox() {
		WebElement element = driver.findElement(FINANCIAL_DETAILS_CHECKBOX);
		driver.clickByJS(TTWebsiteDriver.driver, element);
		logger.info("Financial Details Checkbox Checked");
	}

	public void selectCompanyTypeFromDropdown(String compType) {
		driver.waitForElementPresent(COMP_TYPE_DROP_DOWN);
		Select compTypeDropdown = new Select(driver.findElement(COMP_TYPE_DROP_DOWN));
		compTypeDropdown.selectByVisibleText(compType);
		logger.info("Following compType  has been selected from compType Dropdown : " + compType);
	}

	public void selectCompanyFromDropdown(int index) {
		driver.waitForElementPresent(COMP_DROP_DOWN);
		Select compDropdown = new Select(driver.findElement(COMP_DROP_DOWN));
		compDropdown.selectByIndex(index);
		logger.info("First comp has been selected from comp Dropdown");
	}

	public void selectCompanyFromDropdownByName(String name) {
		driver.waitForElementPresent(COMP_DROP_DOWN);
		Select compDropdown = new Select(driver.findElement(COMP_DROP_DOWN));
		compDropdown.selectByVisibleText(name);
		logger.info("Following comp has been selected from comp Dropdown: "+name);
	}

	public void showAllCheckBox() {
		WebElement SHOW_ALL_CHECK_BOX_element = driver.findElement(SHOW_ALL_CHECK_BOX);
		driver.clickByJS(TTWebsiteDriver.driver, SHOW_ALL_CHECK_BOX_element);
		logger.info("Show All checkbox under financial details has been selected");
	}

	public void selectRateContractFromDropdown(int index) {
		driver.waitForElementPresent(RATE_DROP_DOWN);
		Select dropdown = new Select(driver.findElement(RATE_DROP_DOWN));
		dropdown.selectByIndex(index);
		logger.info("First Rate has been selected from Rate Dropdown");
	}

	public void selectRateContractFromDropdownByName(String name) {
		try {
			driver.waitForElementPresent(RATE_DROP_DOWN);
			Select dropdown = new Select(driver.findElement(RATE_DROP_DOWN));
			dropdown.selectByVisibleText(name);
			logger.info("Following Rate has been selected from Rate Dropdown: "+name);
		} catch (Exception e) {}
	}

	public void checkSchemeCheckBox() {
		WebElement SCHEME_CHECKBOX_element = driver.findElement(SCHEME_CHECKBOX);
		driver.clickByJS(TTWebsiteDriver.driver, SCHEME_CHECKBOX_element);
		logger.info("Scheme Checkbox Checked");
	}



	public void selectSchemeFromDropdown(int index) {
		driver.waitForElementPresent(SCHEME_DROP_DOWN);
		Select dropdown = new Select(driver.findElement(SCHEME_DROP_DOWN));
		dropdown.selectByIndex(index);
		logger.info("First Scheme has been selected from Scheme Dropdown");
	}

	//----------------------------------------------------------------------------------------	

	//Fill Actual Demographics
	public void clickatfillactualdemographics() {
		driver.waitForElementPresent(FILLACTUALDEMOGRAPHICS_ICON);
		WebElement imageiconelement = driver.findElement(FILLACTUALDEMOGRAPHICS_ICON);
		driver.clickByJS(TTWebsiteDriver.driver, imageiconelement);

		logger.info("Fill Actual Demographics checkbox has been checked.");
	}

	public void selecttitleatactualpatientdetails(String titleatActualPatient) {
		driver.waitForElementPresent(FILLACTUALDEMOGRAPHICS_TITLE_DROP_DOWN);
		Select titleddapd = new Select(driver.findElement(FILLACTUALDEMOGRAPHICS_TITLE_DROP_DOWN));
		titleddapd.selectByVisibleText(titleatActualPatient);
		logger.info("Title dropdown is selected at Actual Patient Details window.");
	}

	public void enterfirstnameatactualpatientdetails(String firstnameatActualPatient) {
		driver.waitForElementPresent(FILLACTUALDEMOGRAPHICS_FIRST_NAME);
		driver.findElement(FILLACTUALDEMOGRAPHICS_FIRST_NAME).sendKeys(firstnameatActualPatient);
		logger.info("First Name is entered at Actual Patient Details window.");
	}

	public void entermiddlenameatactualpatientdetails(String middlenameatActualPatient) {
		driver.waitForElementPresent(FILLACTUALDEMOGRAPHICS_MIDDLE_NAME);
		driver.findElement(FILLACTUALDEMOGRAPHICS_MIDDLE_NAME).sendKeys(middlenameatActualPatient);
		logger.info("Middle Name is entered at Actual Patient Details window.");
	}

	public void enterlastnameatactualpatientdetails(String lastnameatActualPatient) {
		driver.waitForElementPresent(FILLACTUALDEMOGRAPHICS_LAST_NAME);
		driver.findElement(FILLACTUALDEMOGRAPHICS_LAST_NAME).sendKeys(lastnameatActualPatient);
		logger.info("Last Name is entered at Actual Patient Details window.");
	}

	public void enterdobatactualpatientdetails(String dobatActualPatient) {
		driver.waitForElementPresent(FILLACTUALDEMOGRAPHICS_DOB);
		driver.findElement(FILLACTUALDEMOGRAPHICS_DOB).sendKeys(dobatActualPatient);
		driver.clickAnyWhereOnScreen();
		logger.info("DOB is entered at Actual Patient Details window.");
	}

	public void entermobileatactualpatientdetails(String mobilenumberatActualPatient) {
		driver.waitForElementPresent(FILLACTUALDEMOGRAPHICS_MOBILE);
		driver.findElement(FILLACTUALDEMOGRAPHICS_MOBILE).sendKeys(mobilenumberatActualPatient);
		logger.info("Mobile Number is entered at Actual Patient Details window.");
	}

	public void enteraddressatactualpatientdetails(String addressatActualPatient) {
		driver.waitForElementPresent(FILLACTUALDEMOGRAPHICS_ADDRESS);
		driver.findElement(FILLACTUALDEMOGRAPHICS_ADDRESS).sendKeys(addressatActualPatient);
		logger.info("Address is entered at Actual Patient Details window.");
	}


	public void enterguardianatactualpatientdetails(String guardianatActualPatient) {
		driver.waitForElementPresent(FILLACTUALDEMOGRAPHICS_GUARDIAN_NAME);
		driver.findElement(FILLACTUALDEMOGRAPHICS_GUARDIAN_NAME).sendKeys(guardianatActualPatient);
		logger.info("Guardian Name is entered at Actual Patient Details window.");
	}

	public void closebuttonatactualpatientdetails() {
		driver.waitForElementPresent(FILLACTUALDEMOGRAPHICS_CLOSE_BTN);
		driver.findElement(FILLACTUALDEMOGRAPHICS_CLOSE_BTN).click();
		logger.info("Close button is clicked at Actual Patient Details window.");
	}

	//----------------------------------------------------------------------------------------	

	public boolean verifyConfirmPatientDetailsPopupPresence(String message) throws InterruptedException{
		if(driver.findElement(CONFRM_PATIENT_DETAILS_POPUP_HEADER).getText().contains(message))
		{
			logger.info("COnfirm Patient Details Popup is showing up");
			return true;
		}
		else{
			return false;
		}
	}

	public void yesButtonOnConfirmPopup() throws InterruptedException {
		if(driver.findElements(YES_BUTTON_CONFRM_PAT_DETAILS_POPUP).size()>0) 
		{
			try {
				driver.waitForElementPresent(YES_BUTTON_CONFRM_PAT_DETAILS_POPUP);
				driver.findElement(YES_BUTTON_CONFRM_PAT_DETAILS_POPUP).click();
				Thread.sleep(10000);
				logger.info("Yes button clicked on Confirm Patient Details Popup");	
			}
			catch (Exception e) {}
		}

	}

	public boolean verifyRegisteredSuccessfullPopupPresence(String message) throws InterruptedException{
		driver.waitForElementPresent(REGISTERED_SUCCESSFULLY_POPUP_HEADER);
		if(driver.findElement(REGISTERED_SUCCESSFULLY_POPUP_HEADER).getText().equals(message))
		{
			logger.info("REGISTERED SUCCESSFULLY POPUP is showing up");
			return true;
		}
		else{
			return false;
		}
	}

	public String getUHIDOfPatient() 
	{
		String id = null;
		try {
			String no = driver.findElement(By.xpath("//section[@class='popupBody1']")).getText();
			String[] parts = no.split(" ");
			String part1 = parts[4];
			String[] part2 = part1.split("M");
			id = part2[0];
			logger.info("TEST US JHKJHKJH"+id);
			System.out.println("TEST US FFFFFFFF"+id+"Helllos");

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return id;
	}

	public void clickOnYesButtonOnRegisteredSuccessfullyPopup() {

		try {
			driver.waitForElementPresent(REGSITERED_SUCCESSFULLY_YES_BUTTON);
			driver.click(REGSITERED_SUCCESSFULLY_YES_BUTTON);
			driver.waitForPageLoad();
			logger.info("REGISTERED SUCCESSFULLY POPUP Yes Button Clicked");
		} catch (Exception e) {}
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='btnyes']"), 250);
			driver.click(By.xpath("//a[@id='btnyes']"));
		} catch (Exception e) {}
	}

	public void clickOnNoButtonOnRegisteredSuccessfullyPopup() {
		try {
			driver.waitForElementPresent(REGSITERED_SUCCESSFULLY_NO_BUTTON);
			driver.click(REGSITERED_SUCCESSFULLY_NO_BUTTON);
			driver.waitForPageLoad();
			logger.info("REGISTERED SUCCESSFULLY POPUP No Button Clicked");

		} catch (Exception e) {}	
	}

	public boolean verifyUserIsOnBillingScreen(String title) throws InterruptedException{
		if(driver.getTitle().contains(title))
		{
			logger.info("User is On Billing Screen");
			return true;
		}
		else{
			return false;
		}
	}



	public void searchUHIDFromSearchBoxOnHeader(String uhid) throws InterruptedException {
		try {
			driver.waitForElementPresent(UHID_SEARCH_BOX);
			driver.findElement(UHID_SEARCH_BOX).clear();
			driver.findElement(UHID_SEARCH_BOX).sendKeys(uhid);
			//		Actions action = new Actions(TTWebsiteDriver.driver);
			//		action.keyDown(Keys.ENTER);
			Thread.sleep(4000);

			//Actions action = new Actions(driver); 
			//action.sendKeys(driver.findElement(By.id("uHid")), Keys.ENTER).build().perform();


			driver.findElement(UHID_SEARCH_BOX).sendKeys(Keys.ENTER);
			Thread.sleep(4000);
			logger.info("Following UHID has been searched from Search Box" + uhid);	

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public void patientdeceasedok() {

		WebElement patientdeceasedok_element = driver.findElement(By.xpath("//a[@id='btnyes']"));
		driver.clickByJS(TTWebsiteDriver.driver, patientdeceasedok_element);
	}

	public void clickOnSelectCheckboxatUnmerge() {
		driver.waitForElementPresent(UNMERGE_SELECT_CHECK_BOX);
		driver.click(UNMERGE_SELECT_CHECK_BOX);
		logger.info("Checkbox has been selected on Unmerge screen.");	
	}

	public void clickOnUnmergeButtonatUnmerge() throws InterruptedException {
		driver.waitForElementPresent(UNMERGE_BUTTON);
		driver.click(UNMERGE_BUTTON);
		logger.info("User clicked on Unmerge button.");
		Thread.sleep(8000);
	}




	public void searchUHIDFromSearchBoxOnHeaderSecondMethod(String uhid) throws InterruptedException {
		driver.waitForElementPresent(UHID_SEARCH_BOX);
		driver.findElement(UHID_SEARCH_BOX).clear();
		driver.findElement(UHID_SEARCH_BOX).sendKeys(uhid);
		driver.findElement(UHID_SEARCH_BOX).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		logger.info("Following UHID has been searched from Search Box" + uhid);
	}



	public void clickOnYesButtonOnUpdatePopup() {
		try {
			driver.waitForElementPresent(YES_BUTTON_ON_UPDATE_POPUP);
			driver.click(YES_BUTTON_ON_UPDATE_POPUP);
			logger.info("Yes Button on Update Popup Clicked");
		} catch (Exception e) {}

	}

	public void clickOnSearchPatientButton() {
		try {
			driver.waitForElementPresent(SEARCH_PATIENT_BUTTON);
			WebElement icon = driver.findElement(SEARCH_PATIENT_BUTTON);
			driver.clickByJS(TTWebsiteDriver.driver, icon);
			logger.info("Search Patient Button Clicked");	
		} catch (Exception e) {}

	}

	public boolean verifySearchPatientPopupIsVisibale() throws InterruptedException{
		driver.clickAnyWhereOnScreen();
		if(driver.findElement(SEARCH_PATIENT_POPUP_HEADER).isDisplayed())
		{
			logger.info("Search patient Popup is showing up");
			return true;
		}
		else{
			return false;
		}
	}

	public void searchMobileNumberAndClickOnEnter(String mobileNumber) {
		driver.waitForElementPresent(MOBILE_NO_SEARCH_PATIENT_POPUP);
		driver.findElement(MOBILE_NO_SEARCH_PATIENT_POPUP).sendKeys(mobileNumber);
		driver.findElement(MOBILE_NO_SEARCH_PATIENT_POPUP).sendKeys(Keys.RETURN);
		logger.info("Following Mobile Number has been Entered" +mobileNumber);
	}

	public void searchNameAndClickOnEnter(String name) {
		driver.waitForElementPresent(NAME_SEARCH_PATIENT_POPUP);
		driver.findElement(NAME_SEARCH_PATIENT_POPUP).sendKeys(name);
		driver.findElement(NAME_SEARCH_PATIENT_POPUP).sendKeys(Keys.RETURN);
		logger.info("Following Name has been Entered" +name);
	}

	public void searchFirstNameAndClickOnEnter(String name) {
		driver.waitForElementPresent(FIRST_NAME_SEARCH_PATIENT_POPUP);
		driver.findElement(FIRST_NAME_SEARCH_PATIENT_POPUP).sendKeys(name);
		driver.findElement(FIRST_NAME_SEARCH_PATIENT_POPUP).sendKeys(Keys.RETURN);
		logger.info("Following First Name has been Entered" +name);
	}

	public void searchLastNameAndClickOnEnter(String name) {
		driver.waitForElementPresent(LAST_NAME_SEARCH_PATIENT_POPUP);
		driver.findElement(LAST_NAME_SEARCH_PATIENT_POPUP).sendKeys(name);
		driver.findElement(LAST_NAME_SEARCH_PATIENT_POPUP).sendKeys(Keys.RETURN);
		logger.info("Following Last Name has been Entered" +name);
	}

	public void searchAddressAndClickOnEnter(String address) {
		driver.waitForElementPresent(ADDRESS_SEARCH_PATIENT_POPUP);
		driver.findElement(ADDRESS_SEARCH_PATIENT_POPUP).sendKeys(address);
		driver.findElement(ADDRESS_SEARCH_PATIENT_POPUP).sendKeys(Keys.RETURN);
		logger.info("Following Address has been Entered" +address);
	}

	public void searchLocalityAndClickOnEnter(String address) {
		driver.waitForElementPresent(LOCALITY_SEARCH_PATIENT_POPUP);
		driver.findElement(LOCALITY_SEARCH_PATIENT_POPUP).sendKeys(address);
		driver.findElement(LOCALITY_SEARCH_PATIENT_POPUP).sendKeys(Keys.RETURN);
		logger.info("Following Localtiy has been Entered" +address);
	}

	public void searchNationalIdAndClickOnEnter(String id) {
		driver.waitForElementPresent(NATIONAL_ID_SEARCH_PATIENT_POPUP);
		driver.findElement(NATIONAL_ID_SEARCH_PATIENT_POPUP).sendKeys(id);
		driver.findElement(NATIONAL_ID_SEARCH_PATIENT_POPUP).sendKeys(Keys.RETURN);
		logger.info("Following National Id has been Entered" +id);
	}

	public void searchRemarksAndClickOnEnter(String id) {
		driver.waitForElementPresent(REMARKS_SEARCH_PATIENT_POPUP);
		driver.findElement(REMARKS_SEARCH_PATIENT_POPUP).sendKeys(id);
		driver.findElement(REMARKS_SEARCH_PATIENT_POPUP).sendKeys(Keys.RETURN);
		logger.info("Following Remarks has been Entered" +id);
	}

	public void clearMobileNumberField() {
		driver.waitForElementPresent(MOBILE_NO_SEARCH_PATIENT_POPUP);
		driver.findElement(MOBILE_NO_SEARCH_PATIENT_POPUP).clear();
		logger.info("Mobile Number Field Got Cleared");
	}

	public void clearNameField() {
		driver.waitForElementPresent(NAME_SEARCH_PATIENT_POPUP);
		driver.findElement(NAME_SEARCH_PATIENT_POPUP).clear();
		logger.info("Name Field Got Cleared");
	}

	public void clearFirstNameField() {
		driver.waitForElementPresent(FIRST_NAME_SEARCH_PATIENT_POPUP);
		driver.findElement(FIRST_NAME_SEARCH_PATIENT_POPUP).clear();
		logger.info("First Name Field Got Cleared");
	}

	public void clearLastNameField() {
		driver.waitForElementPresent(LAST_NAME_SEARCH_PATIENT_POPUP);
		driver.findElement(LAST_NAME_SEARCH_PATIENT_POPUP).clear();
		logger.info("Last Name Field Got Cleared");
	}

	public void clearAddressField() {
		driver.waitForElementPresent(ADDRESS_SEARCH_PATIENT_POPUP);
		driver.findElement(ADDRESS_SEARCH_PATIENT_POPUP).clear();
		logger.info("Address Field Got Cleared");
	}

	public void clearLocalityField() {
		driver.waitForElementPresent(LOCALITY_SEARCH_PATIENT_POPUP);
		driver.findElement(LOCALITY_SEARCH_PATIENT_POPUP).clear();
		logger.info("Locality Field Got Cleared");
	}

	public void clearNationalityField() {
		driver.waitForElementPresent(NATIONAL_ID_SEARCH_PATIENT_POPUP);
		driver.findElement(NATIONAL_ID_SEARCH_PATIENT_POPUP).clear();
		logger.info("National Id Field Got Cleared");
	}

	public void clearRemarksField() {
		driver.waitForElementPresent(REMARKS_SEARCH_PATIENT_POPUP);
		driver.findElement(REMARKS_SEARCH_PATIENT_POPUP).clear();
		logger.info("Remarks Field Got Cleared");
	}

	public boolean verifyErrorMessageOfEnteringLesserCharacters(String message) throws InterruptedException{
		driver.waitForElementPresent(ERROR_MESSAGE_LESSER_CHARACTER);
		if(driver.findElement(ERROR_MESSAGE_LESSER_CHARACTER).getText().contains(message))
		{
			logger.info("Error Message Verified and is showing up");
			return true;
		}
		else{
			return false;
		}
	}

	public boolean verifyResultIsShowingUpInSearchPopupScreen() throws InterruptedException{
		driver.waitForElementPresent(FIRST_RESULT_IN_SEARCH_PATIENT_POPUP);
		if(driver.findElements(FIRST_RESULT_IN_SEARCH_PATIENT_POPUP).size()>0)
		{
			if(driver.findElement(FIRST_RESULT_IN_SEARCH_PATIENT_POPUP).isDisplayed())
			{
				logger.info("Results are showing up");
			}
			return true;	
		}
		else{
			return false;
		}
	}

	public boolean verifyPatientDeceasedPopupPresence(String message) throws InterruptedException{
		driver.waitForElementPresent(PATIENT_DECEASED_POPUP_BODY);
		if(driver.findElement(PATIENT_DECEASED_POPUP_BODY).getText().contains(message))
		{
			logger.info("Patient Deceased Popup Verified and is showing up");
			return true;
		}
		else{
			return false;
		}
	}

	public boolean verifyPossibleDuplicateAlertPresence(String message) throws InterruptedException{
		driver.waitForElementPresent(POSSIBLE_DUPLICATE_ALERT_HEADING);
		if(driver.findElement(POSSIBLE_DUPLICATE_ALERT_HEADING).getText().contains(message))
		{
			logger.info("Possible Alert Message is showing up");
			return true;
		}
		else{
			return false;
		}
	}

	public void closePossibleAlertBox() {

		if(driver.findElements(POSSIBLE_DUPLICATE_ALERT_CLOSE).size()>0)
		{
			try {
				driver.waitForElementPresent(POSSIBLE_DUPLICATE_ALERT_CLOSE);
				driver.click(POSSIBLE_DUPLICATE_ALERT_CLOSE);
				logger.info("Possible Duplicate Alert Box Closed");		
			}
			catch (Exception e) {}
		}

	}

	public void selectFirstResultFromDuplicateAlertPopup() throws InterruptedException {
		try {
			driver.waitForElementPresent(FIRST_RESULT_FROM_DUPLICATE_ALERT_POPUP);
			WebElement user = driver.findElement(FIRST_RESULT_FROM_DUPLICATE_ALERT_POPUP);
			driver.clickByJS(TTWebsiteDriver.driver, user);
			logger.info("First Result from Duplicate Patient Popup Clicked");
			Thread.sleep(4000);	
		} catch (Exception e) {}	
	}

	public void enterKinDetails(String name, String relationship, String phone) {
		driver.findElement(By.xpath("//input[@id='KinName']")).sendKeys(name);
		Select titleDropDown = new Select(driver.findElement(By.xpath("//select[@id='kinRelationship']")));
		titleDropDown.selectByVisibleText(relationship);
		driver.findElement(By.xpath("//input[@id='kinPhone']")).sendKeys(phone);
	}

	public void clickOnSearchButtonNearCard() {
		driver.waitForElementPresent(By.xpath("//i[@id='searchnew']"), 120);
		driver.click(By.xpath("//i[@id='searchnew']"));
	}

	public void enterDOBInSearchPopup(String dob) {
		driver.waitForElementPresent(By.xpath("//input[@id='modal_DOB']"), 120);
		driver.findElement(By.xpath("//input[@id='modal_DOB']")).clear();
		driver.findElement(By.xpath("//input[@id='modal_DOB']")).sendKeys(dob);
		driver.findElement(By.xpath("//input[@id='modal_DOB']")).sendKeys(Keys.ENTER);
	}

	public void clickOnSearchButtonOnSearchPopup() {
		try {
			driver.waitForElementPresent(By.xpath("//a[@id='search_button']//i[@class='fa fa-search']"), 120);
			 WebElement clickOnSearchButton_element = driver.findElement(By.xpath("//a[@id='search_button']//i[@class='fa fa-search']"));
			 driver.clickByJS(TTWebsiteDriver.driver, clickOnSearchButton_element);
			 Thread.sleep(3000);
		} 
		catch (Exception e) {}

	}

	public boolean verifyNoRecordFoundMessage() throws InterruptedException{
		driver.waitForElementPresent(By.xpath("//p[contains(text(),'No Record Found!')]"), 120);
		try {
			if(driver.findElement(By.xpath("//p[contains(text(),'No Record Found!')]")).getText().contains("No Record Found"))
			{
				logger.info("No Record Found message is showing up");
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e) 
		{
			return false;
		}
	}

	public void selectFirstSearchedPatientRow() 
	{
		driver.waitForElementPresent(By.xpath("//table[@id='searchResultsTable']//tr[@class='patient_row'][1]"), 120);
		WebElement selectFirstSearchedPatient = driver.findElement(By.xpath("//table[@id='searchResultsTable']//tr[@class='patient_row'][1]"));
		driver.clickByJS(TTWebsiteDriver.driver, selectFirstSearchedPatient);
	}

	public void selectPurposeOfVisit(String visit) {
		driver.waitForElementPresent(By.xpath("//select[@id='PurposeofVisit']"), 120);
		Select titleDropDown = new Select(driver.findElement(By.xpath("//select[@id='PurposeofVisit']")));
		titleDropDown.selectByVisibleText(visit);
	}

	public boolean verifyUserIsOnPatientRegisterationPage() {
		return driver.isElementPresent(By.xpath("//h1[contains(text(),'Patient Demographics')]"), 120);
	}

	public void closeSearchPopup() {
		driver.pauseExecutionFor(5000);
		driver.waitForElementPresent(By.xpath("//div[@id='fosearch_patient']//i[@class='fa fa-times']"), 120);
		driver.findElement(By.xpath("//div[@id='fosearch_patient']//i[@class='fa fa-times']")).click();
	}

	public void selectActualDemographicsCheckbox() {
		driver.waitForElementPresent(By.xpath("//input[@id='chkalias']"));
		driver.findElement(By.xpath("//input[@id='chkalias']")).click();
	}

	public boolean verifymessagedisplay(String message) 
	{
		if(driver.findElement(By.xpath("//p[text()='"+message+"']")).isDisplayed())
		{
			logger.info("Please enter reason for returning the following Items:!");
			return true;		
		}
		else {
			return false;
		}

	}
	
	public void clickonAdvancedButton()
	{
		driver.waitForElementPresent(By.xpath("//button[@id='details-button']"));
		WebElement advanced_btn = driver.findElement(By.xpath("//button[@id='details-button']"));
		driver.clickByJS(TTWebsiteDriver.driver, advanced_btn);
		logger.info("Click on Advanced Button");
	}
}
