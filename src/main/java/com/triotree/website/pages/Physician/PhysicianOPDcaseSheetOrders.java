package com.triotree.website.pages.Physician;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.utils.PropertyFile;
import com.triotree.website.pages.ADT.ADTHomePage;
import com.triotree.website.pages.CommonPages.HISHomePage;
import com.triotree.website.pages.CommonPages.HISWebsiteBasePage;

import javafx.css.converter.ColorConverter;
import javafx.scene.control.ColorPicker;




public class PhysicianOPDcaseSheetOrders extends HISWebsiteBasePage
{
	private static final Logger logger = LogManager
			.getLogger(PhysicianOPDcaseSheetOrders.class.getName());
	private final By STATION_DROPDOWN = By.id("Department"); 
	private final By YES_STATION_DROPDOWN = By.id("btn_yes_desh");
	private final By OutPatients=By.id("outpatients");
	private final By Heading=By.xpath("//div[@class='modal_sub_title']");
	private final By Doctor=By.id("doctorsId");
	private final By View=By.id("view_type");
	private final By From_Date=By.id("FromDate");
	private final By Search_Button=By.id("search_data");
	private final By Patient=By.xpath("(//div[@id='op_queue']//div[@id])[3]");
	private final By Order=By.xpath("//div[@id='ordersopphycomp']");
	private final By Chief_Complaints=By.xpath("//div[@id='chiefcomplantopphycomp']");
	private final By Diagnosis=By.xpath("//div[@id='diagnosisopphycomp']");
	private final By Save_Order_Button=By.xpath("//i[@id='save_fav_orders']");
	private final By Search_Laboratory=By.id("searchlaboratory");
	private final By Laborartory_Item=By.xpath("//ul[@id='path_All']//li//a");
	private final By Radiology_Item=By.xpath("//ul[@id='rad_All']//li//a");
	private final By Procedure_Item=By.xpath("//ul[@id='proc_All']//li//a");
	private final By All_Order_Sets_Item=By.xpath("//ul[@id='allorderset']//li//a");
	private final By Search_Radiology=By.id("searchradio");
	private final By Search_Procedure=By.id("searchproc");
	private final By Item_Category=By.id("item_Category");
	private final By Item_Subcategory=By.id("sub_category");
	private final By All_Medicine_Search=By.id("searcham");
	private final By All_Order_Sets_Search=By.id("allordersetsearch");
	private final By Diganosis_CheckBox=By.xpath("//input[@class='p_chkbox']");
	private final By Existing_Tab_Button=By.id("existing_orders");
	private final By LandingOrder_Tab_Button=By.xpath("//a[@class='orders_link']");
	private final By  Show_Drugs_Only=By.id("checkexist"); 
	private final By Close_Banner_Button=By.id("closeidcseshet");
	private final By Select_Department=By.id("opmanual");
	private final By Manual_Service_Name=By.id("manualtext");
	private final By Manual_Price=By.id("manual_price");
	private final By Manual_Plus_Icon=By.id("add_manual_order");
	private final By Facility=By.id("hospitalConsult");
	private final By Consults_Speciality=By.id("speciality");
	private final By Consults_Priority=By.id("priority");
	private final By Consults_Location=By.id("location");
	private final By Consults_Reason=By.id("consult_reason");
	private final By Consults_Add_Row=By.id("add_consult_order");
	private final By Chief_Complaints_Add_Row=By.id("addnewrow");
	private final By Acquity_DropDown=By.id("acquity1");
	private final By Characteristics=By.id("characteristics1");
	private final By Duration=By.id("no1");
	private final By Aggravating_Factors=By.id("agg_factors1");
	private final By Relieving_Factors=By.id("relief_factors1");
	private final By Meds_Taken=By.id("meds_taken1");
	private final By Effect=By.id("effect1");
	private final By Remark=By.id("remark1");
	private final By Save_Chief_Complaints=By.id("save_chief_complaints");
	private final By Description=By.xpath("//input[contains(@id,'item')]");


	int f=0;

	String servicename="";
	String selected_Tab="";
	Boolean found=false;

	List<String> servicelist=new LinkedList<String>();
	List<String> refletedservices=new LinkedList<String>();
	List<String> Existingorderlist=new LinkedList<String>();

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

	public void clickonOutPatient(ExtentTest test) {
		WebElement outpatient_element = driver.findElement(OutPatients);
		driver.clickByJS(TTWebsiteDriver.driver, outpatient_element);
		logger.info("Click on OutPatient");
		Markup m=MarkupHelper.createLabel("Click on OutPatient", ExtentColor.GREEN);
		test.info(m);
	}

	public void getHeading(ExtentTest test) {
		String heading = driver.findElement(Heading).getText();
		logger.info("Page Heading Name= "+heading);
		Markup m=MarkupHelper.createLabel("Page Heading Name= "+heading, ExtentColor.GREEN);
		test.info(m);

	}

	public void verifyselectedDoctorName(ExtentTest test,String text) {
		Select sl=new Select(driver.findElement(Doctor));
		sl.selectByVisibleText(text);
		logger.info("Doctor Name= "+text);
		Markup m=MarkupHelper.createLabel("Doctor Name= "+text, ExtentColor.GREEN);
		test.info(m);
		//}
	}

	public void verifyselectedView(ExtentTest test) 
	{
		Select sl=new Select(driver.findElement(View));

		logger.info("View= "+sl.getFirstSelectedOption().getText());
		Markup m=MarkupHelper.createLabel("View= "+sl.getFirstSelectedOption().getText(), ExtentColor.GREEN);
		test.info(m);
	}

	public void enterFromDate(ExtentTest test,String date) {
		driver.findElement(From_Date).clear();
		driver.findElement(From_Date).sendKeys(date);
		driver.findElement(From_Date).sendKeys(Keys.ENTER);
		logger.info("Frome Date= "+date);
		Markup m=MarkupHelper.createLabel("Frome Date= "+date, ExtentColor.GREEN);
		test.info(m);
	}

	public void clickonSearchButton(ExtentTest test) throws InterruptedException {
		WebElement search_element = driver.findElement(Search_Button);
		driver.clickByJS(TTWebsiteDriver.driver, search_element);
		logger.info("Click on Search Button");
		Markup m=MarkupHelper.createLabel("Click on Search Button", ExtentColor.GREEN);
		test.info(m);
		Thread.sleep(3000);
	}

	public void clickonPatient(ExtentTest test) {
		if(driver.findElements(Patient).size()>0) {
			WebElement patient_element = driver.findElement(Patient);
			driver.clickByJS(TTWebsiteDriver.driver, patient_element);
			logger.info("Click on Patient");
			Markup m=MarkupHelper.createLabel("Click on Patient", ExtentColor.GREEN);
			test.info(m);
			found=true;
		}
		else {
			logger.info("Patient is not available in Patient Queue");
			Markup m=MarkupHelper.createLabel("Patient is not available in Patient Queue", ExtentColor.RED);
			test.info(m);
			found=false;
			Assert.assertTrue(found, "Patient is not available in Patient Queue");
		}
	}

	public void clickonOrder(ExtentTest test) 
	{
		WebElement order_element = driver.findElement(Order);
		driver.clickByJS(TTWebsiteDriver.driver, order_element);
		logger.info("Click on Order Tab");
		Markup m=MarkupHelper.createLabel("Click on Order Tab", ExtentColor.GREEN);
		test.info(m);
	}

	public void clickonChiefComplaints(ExtentTest test) {

		WebElement Chief_Complaints_element = driver.findElement(Chief_Complaints);
		driver.clickByJS(TTWebsiteDriver.driver, Chief_Complaints_element);
		logger.info("Click on Chief Complaints Tab");
		Markup m=MarkupHelper.createLabel("Click on Chief Complaints Tab", ExtentColor.GREEN);
		test.info(m);

	}
	public void verifyselectedTab(ExtentTest test) {
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
				selected_Tab = driver.findElement(By.xpath("(//div[@id='horizontalTab1']//ul[@class='resp-tabs-list']//li[text()])["+i+"]")).getText();
				logger.info("Selected TAB Name= "+selected_Tab);
				Markup m=MarkupHelper.createLabel("Selected TAB Name= "+selected_Tab, ExtentColor.GREEN);
				test.info(m);
			}
		}
	}

	public void verifyreflectedservices(ExtentTest test,String text) throws InterruptedException 
	{

		List<WebElement> refletedservices_list = driver.findElements(By.xpath("//div[@class='resp-tab-content resp-tab-content-active']//label//strong"));
		servicelist=new LinkedList<String>();
		refletedservices=new LinkedList<String>();
		for(int i=1;i<=refletedservices_list.size();i++) 
		{
			String refletedservices_name = driver.findElement(By.xpath("(//div[@class='resp-tab-content resp-tab-content-active']//label//strong)["+i+"]")).getText();
			refletedservices.add(refletedservices_name);
			List<WebElement> hief_complaint_list = driver.findElements(By.xpath("//div[@class='resp-tab-content resp-tab-content-active']//label//strong[text()='"+refletedservices_name+"']/..//following-sibling::ul//span"));
			for(int h=1;h<=hief_complaint_list.size();h++) 
			{

				String chief_complaint_name = driver.findElement(By.xpath("(//div[@class='resp-tab-content resp-tab-content-active']//label//strong[text()='"+refletedservices_name+"']/..//following-sibling::ul//span)["+h+"]")).getText();
				logger.info("Reflected Service Name= "+refletedservices_name+" and Laboratory Service Name= "+chief_complaint_name);
				Markup m=MarkupHelper.createLabel("Reflected Service Name= "+refletedservices_name+" and Laboratory Service Name= "+chief_complaint_name, ExtentColor.GREEN);
				test.info(m);
			}
		}
	}

	public void clickandverifyservices(ExtentTest test,String text,String service) throws InterruptedException {
		for(int i=0;i<refletedservices.size();i++)
		{
			try {
				WebElement chief_complaint_element = driver.findElement(By.xpath("//div[@class='resp-tab-content resp-tab-content-active']//label//strong[text()='"+refletedservices.get(i)+"']/..//following-sibling::ul//span[text()='"+service+"']"));
				driver.clickByJS(TTWebsiteDriver.driver, chief_complaint_element);
				if(service.equals("3T MRI Angiography Abdomen")) 
				{
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@id='txtOrderInvestigationResponse']")).sendKeys(text);
					WebElement investigation_save = driver.findElement(By.xpath("//i[@id='OrderInvestAddResponse']"));
					driver.clickByJS(TTWebsiteDriver.driver, investigation_save);
				}

				servicename = driver.findElement(By.xpath("//table[@id='fav_orders_table']//tbody//tr//td[starts-with(normalize-space(text()),'"+service+"')]")).getText();
				servicelist.add(servicename);
				if(servicename.equals(service)) 
				{
					logger.info(""+refletedservices.get(i)+" Service "+servicename+" get added in the below grid");	
					Markup m1=MarkupHelper.createLabel(""+refletedservices.get(i)+" Service "+servicename+" get added in the below grid", ExtentColor.GREEN);
					test.info(m1);
				}
			}
			catch (Exception e) {
			}
		}
	}
	public void clickonSaveOrder(ExtentTest test) 
	{
		WebElement save_element = driver.findElement(Save_Order_Button);
		driver.clickByJS(TTWebsiteDriver.driver, save_element);
		logger.info("Click on Save Order Button");

		Markup m=MarkupHelper.createLabel("Click on Save Order Button", ExtentColor.GREEN);
		test.info(m);
		if(driver.findElements(By.xpath("//div[@id='orders']//div[@id='divorders']")).size()>0) 
		{
			System.out.println(servicelist);
			for(int j=0;j<servicelist.size();j++)
			{
				String nameofservice=servicelist.get(j);
				List<WebElement> text = driver.findElements(By.xpath("//div[@id='orders']//div[@id='divorders']//label"));
				for(int i=1;i<=text.size();i++) {
					String name = driver.findElement(By.xpath("(//div[@id='orders']//div[@id='divorders']//label)["+i+"]")).getAttribute("innerHTML");
					if(name.replace("<b></b><br></br>", "").contains(nameofservice)) 
					{
						logger.info("After click on Save Button Service "+nameofservice+" is get saved");
						Markup m1=MarkupHelper.createLabel("After click on Save Button Service "+nameofservice+" is get saved", ExtentColor.GREEN);
						test.info(m1);
					}
				}	
			}
		}
		else {
			logger.info("After click on Save Button Service is not get saved");
			Markup m1=MarkupHelper.createLabel("After click on Save Button Service is not get saved", ExtentColor.RED);
			test.info(m1);
		}
	}

	public void clickonOrderTab(ExtentTest test,String text) 
	{
		WebElement tab_element = driver.findElement(By.xpath("//div[@id='horizontalTab1']//ul[@class='resp-tabs-list']//li[text()='"+text+"']"));
		driver.clickByJS(TTWebsiteDriver.driver, tab_element);
		logger.info("Click on Tab= "+text);
		Markup m1=MarkupHelper.createLabel("Click on Tab= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void searchandselectLaboratoryitem(ExtentTest test,String text) throws InterruptedException 
	{
		driver.findElement(Search_Laboratory).sendKeys(text);
		Thread.sleep(2000);
		WebElement lab_item_element = driver.findElement(Laborartory_Item);
		driver.clickByJS(TTWebsiteDriver.driver, lab_item_element);
		logger.info("Laboratory Search item= "+text);
		Markup m1=MarkupHelper.createLabel("Laboratory Search item= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void searchandselectRadiologyitem(ExtentTest test,String text) throws InterruptedException 
	{
		driver.findElement(Search_Radiology).sendKeys(text);
		Thread.sleep(5000);
		WebElement radio_item_element = driver.findElement(Radiology_Item);
		driver.clickByJS(TTWebsiteDriver.driver, radio_item_element);
		logger.info("Radiology Search item= "+text);
		Markup m1=MarkupHelper.createLabel("Radio Search item= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void searchandselectProcedureitem(ExtentTest test,String text) throws InterruptedException 
	{
		driver.findElement(Search_Procedure).sendKeys(text);
		Thread.sleep(5000);
		WebElement prodcedure_item_element = driver.findElement(Procedure_Item);
		driver.clickByJS(TTWebsiteDriver.driver, prodcedure_item_element);
		logger.info("Procedure Search Item= "+text);
		Markup m1=MarkupHelper.createLabel("Procedure Search Item= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void searchandselectAllOrderSetitem(ExtentTest test,String text) throws InterruptedException 
	{
		driver.findElement(All_Order_Sets_Search).sendKeys(text);
		Thread.sleep(5000);
		WebElement prodcedure_item_element = driver.findElement(All_Order_Sets_Item);
		driver.clickByJS(TTWebsiteDriver.driver, prodcedure_item_element);
		logger.info("All Order Sets Search Item= "+text);
		Markup m1=MarkupHelper.createLabel("Procedure Search Item= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void selectFavouriteOrderSetItem(ExtentTest test,String text) {

		driver.findElement(By.xpath("//ul[@id='lab_fav']//span[text()='"+text+"']")).click();
		logger.info("Click on Favourite Order Set Item= "+text);
		Markup m1=MarkupHelper.createLabel("Click on Favourite Order Set Item= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void verifyAddedservices(ExtentTest test,String text) 
	{
		if(driver.findElements(By.xpath("//table[@id='fav_orders_table']//tbody//tr//td[starts-with(normalize-space(text()),'"+text+"')]")).size()>0) 
		{
			servicename = driver.findElement(By.xpath("//table[@id='fav_orders_table']//tbody//tr//td[starts-with(normalize-space(text()),'"+text+"')]")).getText();
			servicelist.add(servicename);
			logger.info(""+selected_Tab+" Service = "+servicename+" is get added in the below grid");
			Markup m1=MarkupHelper.createLabel(""+selected_Tab+" Service = "+servicename+" is get added in the below grid", ExtentColor.GREEN);
			test.info(m1);
		}
		else {
			logger.info(""+selected_Tab+" Service is not get added in the below grid");
			Markup m1=MarkupHelper.createLabel(""+selected_Tab+" Service is not get added in the below grid", ExtentColor.RED);
			test.info(m1);
		}
	}

	public void verifyOrderSetAddedservices(ExtentTest test) 
	{
		List<WebElement> orderset_list = driver.findElements(By.xpath("//table[@id='fav_orders_table']//tbody//tr//td[starts-with(normalize-space(@ctype),'OrdName')]"));
		for(int i=1;i<=orderset_list.size();i++) {
			if(driver.findElement(By.xpath("(//table[@id='fav_orders_table']//tbody//tr//td[starts-with(normalize-space(@ctype),'OrdName')])["+i+"]")).isDisplayed())
			{
				servicename=driver.findElement(By.xpath("(//table[@id='fav_orders_table']//tbody//tr//td[starts-with(normalize-space(@ctype),'OrdName')])["+i+"]")).getText();
				servicelist.add(servicename);
				logger.info(""+selected_Tab+" Service = "+servicename+" is get added in the below grid");
				Markup m1=MarkupHelper.createLabel(""+selected_Tab+" Service = "+servicename+" is get added in the below grid", ExtentColor.GREEN);
				test.info(m1);
			}
		}
	}

	public void selectItemCategoryandItemSubcategory(ExtentTest test,String text,String subcatory) 
	{
		TTWebsiteDriver.selectByvisibletext(Item_Category, text);
		TTWebsiteDriver.selectByvisibletext(Item_Subcategory, subcatory);
		logger.info("ItemCategory= "+text+" and Item Subcategory= "+subcatory);
		Markup m1=MarkupHelper.createLabel("Medicine Search item= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void AllMedicineSearch(ExtentTest test,String text) {

		if(f>0) {
			driver.findElement(All_Medicine_Search).clear();
		}
		driver.findElement(All_Medicine_Search).sendKeys(text);

		logger.info("All Medicine Search Item= "+text);
		if(driver.findElements(By.xpath("//ul[@id='med_all']//li//a//span[text()='"+text+"']/..")).size()>0) {
			WebElement medicine_item_element = driver.findElement(By.xpath("//ul[@id='med_all']//li//a//span[text()='"+text+"']/.."));
			driver.clickByJS(TTWebsiteDriver.driver, medicine_item_element);
			logger.info("Medicine Search item= "+text);
			Markup m1=MarkupHelper.createLabel("Medicine Search item= "+text, ExtentColor.GREEN);
			test.info(m1);
			try {
				WebElement yes_btn = driver.findElement(By.id("ratcontractpopupyes"));
				driver.clickByJS(TTWebsiteDriver.driver, yes_btn);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		f++;
	}


	public void cancelAddedItembelowGrid(ExtentTest test,String text) 
	{
		WebElement cancelorder = driver.findElement(By.xpath("//table[@id='fav_orders_table']//tbody//tr//td[text()='"+text+"']//following-sibling::td//i"));
		driver.clickByJS(TTWebsiteDriver.driver, cancelorder);
		logger.info("Cancel selected Item in the below grid= "+text);
		Markup m1=MarkupHelper.createLabel("Cancel selected Item in the below grid= "+text, ExtentColor.GREEN);
		test.info(m1);
	}
	public void SelectedItemFrequencyandSelectedItemRoute(ExtentTest test,String text,String frequency,String route) 
	{

		TTWebsiteDriver.selectByvisibletext(By.xpath("//table[@id='fav_orders_table']//tbody//tr//td[text()='"+text+"']//following-sibling::td//select[contains(@id,'OrdFreq')]"), frequency);
		TTWebsiteDriver.selectByvisibletext(By.xpath("//table[@id='fav_orders_table']//tbody//tr//td[text()='"+text+"']//following-sibling::td//select[contains(@id,'OrdRoute')]"), route);
		logger.info("Selected Item Name="+text+" Frequency Itemy= "+frequency+" and Route Item= "+route);
		Markup m1=MarkupHelper.createLabel("Selected Item Name="+text+" Frequency Itemy= "+frequency+" and Route Item= "+route, ExtentColor.GREEN);
		test.info(m1);

	}

	public void ClickandAddDiagnosis(ExtentTest test,String text) 
	{
		WebElement digno_element = driver.findElement(Diagnosis);
		driver.clickByJS(TTWebsiteDriver.driver, digno_element);

		if(driver.findElements(By.xpath("//table[@id='diagnosis_table']//tbody//tr")).size()>0) 
		{
			driver.findElement(Diganosis_CheckBox).click();
			logger.info("Click on Diganosis CheckBox");
			TTWebsiteDriver.selectByvisibletext(By.xpath("//td[contains(@id,'type')]//select"), "Final");
			logger.info("Diganosis Type value is Final");
			///driver.findElement(By.xpath("//input[@id='icd_code_input']")).sendKeys(text);
			driver.findElement(By.xpath("//textarea[@id='diag_text']")).sendKeys(text);
			logger.info("Add Diganosis remark= "+text);
			driver.findElement(By.xpath("//textarea[@id='diag_text']")).sendKeys(Keys.ENTER);
			checkDescriptionType(test);
			WebElement save = driver.findElement(By.id("save_diagnosis"));
			driver.clickByJS(TTWebsiteDriver.driver, save);
			logger.info("Click on Save Button");
		}
		else {
			WebElement row_element = driver.findElement(By.xpath("(//ul[@id='fav_diagnosis']//li//a)[1]"));
			driver.clickByJS(TTWebsiteDriver.driver, row_element);
			driver.findElement(Diganosis_CheckBox).click();
			TTWebsiteDriver.selectByvisibletext(By.xpath("//td[contains(@id,'type')]//select"), "Final");
			logger.info("Diganosis Type value is Final");
			driver.findElement(By.xpath("//textarea[@id='diag_text']")).sendKeys(text);
			logger.info("Add Diganosis remark= "+text);
			driver.findElement(By.xpath("//textarea[@id='diag_text']")).sendKeys(Keys.ENTER);
			checkDescriptionType(test);
			WebElement save = driver.findElement(By.id("save_diagnosis"));
			driver.clickByJS(TTWebsiteDriver.driver, save);
			logger.info("Click on Save Button");
		}

	}

	public void checkDescriptionType(ExtentTest test) 
	{
		String description_type = driver.findElement(By.xpath("//table[@id='diagnosis_table']//tbody//td[@style]")).getCssValue("background-color");

		String split=description_type.replace("rgba", "rgb");
		System.out.println("description_type= "+split);
		String[] numbers = split.replace("rgb(", "").replace(")", "").split(",");
		int r = Integer.parseInt(numbers[0].trim());
		int g = Integer.parseInt(numbers[1].trim());
		int b = Integer.parseInt(numbers[2].trim());
		String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
		//String code = Color.fromString(color).asRgba();
		if(hex.equals("#EF7C7C")) {
			logger.info("Diagnosis Description is complex");
			Markup m=MarkupHelper.createLabel("Diagnosis Description is complex", ExtentColor.GREEN);
			test.info(m);
		}
		else {
			logger.info("Diagnosis Description is not complex");
			Markup m=MarkupHelper.createLabel("Diagnosis Description is not complex", ExtentColor.GREEN);
			test.info(m);	
		}

	}

	public void clickonExistingTabButton(ExtentTest test) {
		WebElement existing_element = driver.findElement(Existing_Tab_Button);
		driver.clickByJS(TTWebsiteDriver.driver, existing_element);
		logger.info("Click on Existing Tab Button");
		Markup m1=MarkupHelper.createLabel("Click on Existing Tab Button", ExtentColor.GREEN);
		test.info(m1);
	}

	public void checkstatusofOrderedItem(ExtentTest test) 
	{
		if(driver.findElements(By.xpath("//table[@id='existing_orders_table']//tbody//tr")).size()>0) {
			List<WebElement> service_list = driver.findElements(By.xpath("//table[@id='existing_orders_table']//tbody//tr//td[2]"));
			for(int s=1;s<=service_list.size();s++)
			{
				String service_name = driver.findElement(By.xpath("(//table[@id='existing_orders_table']//tbody//tr//td[2])["+s+"]")).getText();

				String orders_name = driver.findElement(By.xpath("(//table[@id='existing_orders_table']//tbody//tr//td[3])["+s+"]")).getText();
				Existingorderlist.add(orders_name);
				WebElement statusofOrderedItem_element = driver.findElement(By.xpath("(//table[@id='existing_orders_table']//tbody//tr["+s+"]//select[contains(@id,'ExistOrdStatus')])"));
				Select sl=new Select(statusofOrderedItem_element);
				WebElement item_text_element = sl.getFirstSelectedOption();

				logger.info("Service Name= "+service_name+" Orders Name= "+orders_name+" Status= "+item_text_element.getText());
				Markup m1=MarkupHelper.createLabel("Service Name= "+service_name+" Orders Name= "+orders_name+" Status= "+item_text_element.getText(), ExtentColor.GREEN);
				test.info(m1);
			}
		}
		else {
			logger.info("No Data is available on Existing Order Tab");
			Markup m1=MarkupHelper.createLabel("No Data is available on Existing Order Tab", ExtentColor.RED);
			test.info(m1);
		}
	}

	public void changeStatusDropdowncancel(ExtentTest test,String text,String status) 
	{
		System.out.println(Existingorderlist);
		for(String data:Existingorderlist) 
		{
			if(data.equals(text)) 
			{	
				WebElement statusofOrderedItem_element = driver.findElement(By.xpath("(//table[@id='existing_orders_table']//tbody//tr//td[text()='"+text+"']/..//select[contains(@id,'ExistOrdStatus')])"));
				Select sl=new Select(statusofOrderedItem_element);
				sl.selectByVisibleText(status);
				logger.info("Select Status Drop Down= "+status);
				Markup m1=MarkupHelper.createLabel("Select Status Drop Down= "+status, ExtentColor.GREEN);
				test.info(m1);
			}
		}
	}

	public void checkCancelledStatusofItem(ExtentTest test,String text) {
		if(driver.findElements(By.xpath("(//table[@id='existing_orders_table']//tbody//tr//td[text()='"+text+"']/..//select[contains(@id,'ExistOrdStatus')])")).size()>0) 
		{
			WebElement statusofOrderedItem_element = driver.findElement(By.xpath("(//table[@id='existing_orders_table']//tbody//tr//td[text()='"+text+"']/..//select[contains(@id,'ExistOrdStatus')])"));
			Select sl=new Select(statusofOrderedItem_element);
			logger.info("Status Drop Down of "+text+"= "+sl.getFirstSelectedOption().getText());
			Markup m1=MarkupHelper.createLabel("Status Drop Down of "+text+"= "+sl.getFirstSelectedOption().getText(), ExtentColor.GREEN);
			test.info(m1);
		}
	}

	public void clickonLandingOrderTabButton(ExtentTest test) {
		WebElement LandingOrder_element = driver.findElement(LandingOrder_Tab_Button);
		driver.clickByJS(TTWebsiteDriver.driver, LandingOrder_element);
		logger.info("Click on Landing Order Tab Button");
		Markup m1=MarkupHelper.createLabel("Click on Landing Order Tab Button", ExtentColor.GREEN);
		test.info(m1);
	}

	public void clickonShowsDrugsOnly(ExtentTest test) 
	{	
		WebElement ShowsDrugsOnly_element = driver.findElement(Show_Drugs_Only);
		driver.clickByJS(TTWebsiteDriver.driver, ShowsDrugsOnly_element);
		logger.info("Click on Shows Drugs Only Check Box");
		Markup m1=MarkupHelper.createLabel("Click on Shows Drugs Only Check Box", ExtentColor.GREEN);
		test.info(m1);
	}

	public void clickonCloseBannerButton(ExtentTest test) 
	{
		WebElement banner_element = driver.findElement(Close_Banner_Button);
		driver.clickByJS(TTWebsiteDriver.driver, banner_element);
		logger.info("Click on close banner button");
		Markup m1=MarkupHelper.createLabel("Click on close banner button", ExtentColor.GREEN);
		test.info(m1);
	}

	public void SelectDepartmentManual(ExtentTest test,String text) 
	{
		TTWebsiteDriver.selectByvisibletext(Select_Department, text);
		logger.info("Select Department= "+text);
		Markup m1=MarkupHelper.createLabel("Select Department= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterManualServiceName(ExtentTest test,String text) {
		driver.findElement(Manual_Service_Name).sendKeys(text);
		logger.info("Manual Service Name= "+text);
		Markup m1=MarkupHelper.createLabel("Manual Service Name= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterManualPrice(ExtentTest test,String text) {
		driver.findElement(Manual_Price).sendKeys(text);
		logger.info("Manual Price= "+text);
		Markup m1=MarkupHelper.createLabel("Manual Price= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void clickonManualPlusIcon(ExtentTest test) {
		driver.findElement(Manual_Plus_Icon).click();
		logger.info("Click on Manual Plus Icon");
		Markup m1=MarkupHelper.createLabel("Click on Manual Plus Icon", ExtentColor.GREEN);
		test.info(m1);
	}

	public void VerifyConsultsFacility(ExtentTest test) {
		Select sl=new Select(driver.findElement(Facility));
		logger.info("Consults Facility= "+sl.getFirstSelectedOption().getText());
		Markup m1=MarkupHelper.createLabel("Consults Facility= "+sl.getFirstSelectedOption().getText(), ExtentColor.GREEN);
		test.info(m1);
	}

	public void VerifyConsultsSpeciality(ExtentTest test,String text) {
		TTWebsiteDriver.selectByvisibletext(Consults_Speciality, text);
		logger.info("Consults Speciality= "+text);
		Markup m1=MarkupHelper.createLabel("Consults Speciality= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void VerifyConsultsPriority(ExtentTest test,String text) {
		TTWebsiteDriver.selectByvisibletext(Consults_Priority, text);
		logger.info("Consults Priority= "+text);
		Markup m1=MarkupHelper.createLabel("Consults Priority= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void VerifyConsultsLocation(ExtentTest test) {
		Select sl=new Select(driver.findElement(Consults_Location));
		logger.info("Consults Location= "+sl.getFirstSelectedOption().getText());
		Markup m1=MarkupHelper.createLabel("Consults Location= "+sl.getFirstSelectedOption().getText(), ExtentColor.GREEN);
		test.info(m1);
	}


	//	private final By Consults_Add_Row=By.id("add_consult_order");

	public void AddConsultsReason(ExtentTest test,String text) 
	{
		driver.findElement(Consults_Reason).sendKeys(text);
		logger.info("Consults Reason= "+text);
		Markup m1=MarkupHelper.createLabel("Consults Reason= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void clickonConsultAddRow() 
	{
		WebElement addrow = driver.findElement(Consults_Add_Row);
		driver.clickByJS(TTWebsiteDriver.driver, addrow);
		logger.info("Click on Consults Add Row");
	}

	public void clickonChiefComplaintsAddRow(ExtentTest test) 
	{
		int table_size = driver.findElements(By.xpath("//table[@id='chief_complaints_table']//tbody//tr")).size();
		if(table_size>0) 
		{
			logger.info("Already Chief Complaints is exists= "+table_size);
			Markup m1=MarkupHelper.createLabel("Already Chief Complaints is exists= "+table_size, ExtentColor.GREEN);
			test.info(m1);
			driver.findElement(By.xpath("//td[@class='delete_row']")).click();
			clickonSaveChiefComplaints(test);
			clickonChiefComplaints(test);
		}
		WebElement ChiefComplaintsaddrow = driver.findElement(Chief_Complaints_Add_Row);
		driver.clickByJS(TTWebsiteDriver.driver, ChiefComplaintsaddrow);
		logger.info("Click on Chief Complaints Add Row");
		Markup m1=MarkupHelper.createLabel("Click on Chief Complaints Add Row", ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterChiefComplaintsDescription(ExtentTest test,String text) 
	{
		driver.findElement(Description).sendKeys(text);
		logger.info("Chief Complaints Description= "+text);
		Markup m1=MarkupHelper.createLabel("Chief Complaints Description= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void selectAcquity(ExtentTest test,String text) 
	{
		TTWebsiteDriver.selectByvisibletext(Acquity_DropDown, text);
		logger.info("Chief Complaints Acquity= "+text);
		Markup m1=MarkupHelper.createLabel("Chief Complaints Acquity= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterChiefComplaintsCharacteristics(ExtentTest test,String text) 
	{
		driver.findElement(Characteristics).sendKeys(text);
		logger.info("Chief Complaints Characteristics= "+text);
		Markup m1=MarkupHelper.createLabel("Chief Complaints Characteristics= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterChiefComplaintsDuration(ExtentTest test,String text) 
	{
		driver.findElement(Duration).sendKeys(text);
		logger.info("Chief Complaints Duration= "+text);
		Markup m1=MarkupHelper.createLabel("Chief Complaints Duration= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterChiefComplaintsAggravatingFactors(ExtentTest test,String text) 
	{
		driver.findElement(Aggravating_Factors).sendKeys(text);
		logger.info("Chief Complaints Aggravating Factors= "+text);
		Markup m1=MarkupHelper.createLabel("Chief Complaints Aggravating Factors= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterChiefComplaintsRelievingFactors(ExtentTest test,String text) 
	{
		driver.findElement(Relieving_Factors).sendKeys(text);
		logger.info("Chief Complaints Relieving Factors= "+text);
		Markup m1=MarkupHelper.createLabel("Chief Complaints Relieving Factors= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterChiefComplaintsMedsTaken(ExtentTest test,String text) 
	{
		driver.findElement(Meds_Taken).sendKeys(text);
		logger.info("Chief Complaints Meds Taken= "+text);
		Markup m1=MarkupHelper.createLabel("Chief Complaints Meds Taken= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void selectEffect(ExtentTest test,String text) 
	{
		TTWebsiteDriver.selectByvisibletext(Effect, text);
		logger.info("Chief Complaints Effect= "+text);
		Markup m1=MarkupHelper.createLabel("Chief Complaints Effect= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void enterChiefComplaintsRemark(ExtentTest test,String text) 
	{
		driver.findElement(Remark).sendKeys(text);
		logger.info("Chief Complaints Remark= "+text);
		Markup m1=MarkupHelper.createLabel("Chief Complaints Remark= "+text, ExtentColor.GREEN);
		test.info(m1);
	}

	public void clickonSaveChiefComplaints(ExtentTest test) {
		WebElement save_element = driver.findElement(Save_Chief_Complaints);
		driver.clickByJS(TTWebsiteDriver.driver, save_element);
		logger.info("Click on Save Button");
		Markup m1=MarkupHelper.createLabel("Click on Save Button", ExtentColor.GREEN);
		test.info(m1);
	}


}
