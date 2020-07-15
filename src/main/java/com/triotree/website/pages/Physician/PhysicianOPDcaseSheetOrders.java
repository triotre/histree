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




public class PhysicianOPDcaseSheetOrders extends HISWebsiteBasePage{
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
	private final By Patient=By.xpath("(//div[@id='op_queue']//div[@id])[1]");
	private final By Order=By.xpath("//div[@id='ordersopphycomp']");
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
	int f=0;

	String servicename="";
	String selected_Tab="";
	///String chief_complaint_name ="";

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
		WebElement patient_element = driver.findElement(Patient);
		driver.clickByJS(TTWebsiteDriver.driver, patient_element);
		logger.info("Click on Patient");
		Markup m=MarkupHelper.createLabel("Click on Patient", ExtentColor.GREEN);
		test.info(m);
	}

	public void clickonOrder(ExtentTest test) {

		WebElement order_element = driver.findElement(Order);
		driver.clickByJS(TTWebsiteDriver.driver, order_element);
		logger.info("Click on Order Tab");
		Markup m=MarkupHelper.createLabel("Click on Order Tab", ExtentColor.GREEN);
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


			//			WebElement chief_complaint_element = driver.findElement(By.xpath("//div[@class='resp-tab-content resp-tab-content-active']//label//strong[text()='"+refletedservices_name+"']/..//following-sibling::ul//span[text()='"+chief_complaint_name+"']"));
			//			driver.clickByJS(TTWebsiteDriver.driver, chief_complaint_element);
			//			if(chief_complaint_name.equals("3T MRI Angiography Abdomen")) 
			//			{
			//				Thread.sleep(2000);
			//				driver.findElement(By.xpath("//input[@id='txtOrderInvestigationResponse']")).sendKeys(text);
			//				WebElement investigation_save = driver.findElement(By.xpath("//i[@id='OrderInvestAddResponse']"));
			//				driver.clickByJS(TTWebsiteDriver.driver, investigation_save);
			//			}
			//
			//			servicename = driver.findElement(By.xpath("//table[@id='fav_orders_table']//tbody//tr//td[starts-with(normalize-space(text()),'"+chief_complaint_name+"')]")).getText();
			//			servicelist.add(servicename);
			//			if(servicename.equals(chief_complaint_name)) 
			//			{
			//				logger.info(""+refletedservices_name+" Service "+servicename+" get added in the below grid");	
			//				Markup m1=MarkupHelper.createLabel(""+refletedservices_name+" Service "+servicename+" get added in the below grid", ExtentColor.GREEN);
			//				test.info(m1);
			//			}
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
		servicename = driver.findElement(By.xpath("//table[@id='fav_orders_table']//tbody//tr//td[starts-with(normalize-space(text()),'"+text+"')]")).getText();
		servicelist.add(servicename);
		logger.info(""+selected_Tab+" Service = "+servicename+" is get added in the below grid");
		Markup m1=MarkupHelper.createLabel(""+selected_Tab+" Service = "+servicename+" is get added in the below grid", ExtentColor.GREEN);
		test.info(m1);

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
		}
		f++;
	}


	public void cancelAddedItembelowGrid(String text) 
	{
		driver.findElement(By.xpath("//table[@id='fav_orders_table']//tbody//tr//td[text()='"+text+"']//following-sibling::td//i")).click();
		logger.info("Cancel selected Item in the below grid= "+text);
	}
	public void SelectedItemFrequencyandSelectedItemRoute(String text,String frequency,String route) 
	{

		TTWebsiteDriver.selectByvisibletext(By.xpath("//table[@id='fav_orders_table']//tbody//tr//td[text()='"+text+"']//following-sibling::td//select[contains(@id,'OrdFreq')]"), frequency);
		TTWebsiteDriver.selectByvisibletext(By.xpath("//table[@id='fav_orders_table']//tbody//tr//td[text()='"+text+"']//following-sibling::td//select[contains(@id,'OrdRoute')]"), route);
		logger.info("Selected Item Name="+text+" Frequency Itemy= "+frequency+" and Route Item= "+route);

	}

	public void ClickandAddDiagnosis(String text) 
	{
		WebElement digno_element = driver.findElement(Diagnosis);
		driver.clickByJS(TTWebsiteDriver.driver, digno_element);

		if(driver.findElements(By.xpath("//table[@id='diagnosis_table']//tbody//tr")).size()>0) 
		{
			driver.findElement(Diganosis_CheckBox).click();
			TTWebsiteDriver.selectByvisibletext(By.xpath("//td[contains(@id,'type')]//select"), "Final");
			///driver.findElement(By.xpath("//input[@id='icd_code_input']")).sendKeys(text);
			driver.findElement(By.xpath("//textarea[@id='diag_text']")).sendKeys(text);
			driver.findElement(By.xpath("//textarea[@id='diag_text']")).sendKeys(Keys.ENTER);
			WebElement save = driver.findElement(By.id("save_diagnosis"));
			driver.clickByJS(TTWebsiteDriver.driver, save);
		}
		else {
			WebElement row_element = driver.findElement(By.xpath("(//ul[@id='fav_diagnosis']//li//a)[1]"));
			driver.clickByJS(TTWebsiteDriver.driver, row_element);
			driver.findElement(Diganosis_CheckBox).click();
			TTWebsiteDriver.selectByvisibletext(By.xpath("//td[contains(@id,'type')]//select"), "Final");
			driver.findElement(By.xpath("//textarea[@id='diag_text']")).sendKeys(text);
			driver.findElement(By.xpath("//textarea[@id='diag_text']")).sendKeys(Keys.ENTER);
			WebElement save = driver.findElement(By.id("save_diagnosis"));
			driver.clickByJS(TTWebsiteDriver.driver, save);
		}

	}

	public void clickonExistingTabButton() {
		WebElement existing_element = driver.findElement(Existing_Tab_Button);
		driver.clickByJS(TTWebsiteDriver.driver, existing_element);
		logger.info("Click on Existing Tab Button");
	}

	public void checkstatusofOrderedItem() 
	{
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
		}
	}

	public void changeStatusDropdowncancel(String text,String status) 
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
			}
			else {
				//logger.info("else Select Status Drop Down");
			}
		}
	}

	public void checkCancelledStatusofItem(String text) {
		if(driver.findElements(By.xpath("(//table[@id='existing_orders_table']//tbody//tr//td[text()='"+text+"']/..//select[contains(@id,'ExistOrdStatus')])")).size()>0) 
		{
			WebElement statusofOrderedItem_element = driver.findElement(By.xpath("(//table[@id='existing_orders_table']//tbody//tr//td[text()='"+text+"']/..//select[contains(@id,'ExistOrdStatus')])"));
			Select sl=new Select(statusofOrderedItem_element);
			logger.info("Status Drop Down of "+text+"= "+sl.getFirstSelectedOption().getText());
		}


	}

	public void clickonLandingOrderTabButton() {
		WebElement LandingOrder_element = driver.findElement(LandingOrder_Tab_Button);
		driver.clickByJS(TTWebsiteDriver.driver, LandingOrder_element);
		logger.info("Click on Landing Order Tab Button");
	}

	public void clickonShowsDrugsOnly() 
	{	
		WebElement ShowsDrugsOnly_element = driver.findElement(Show_Drugs_Only);
		driver.clickByJS(TTWebsiteDriver.driver, ShowsDrugsOnly_element);
		logger.info("Click on Shows Drugs Only Check Box");
	}

	public void clickonCloseBannerButton() 
	{
		WebElement banner_element = driver.findElement(Close_Banner_Button);
		driver.clickByJS(TTWebsiteDriver.driver, banner_element);
		logger.info("Click on close banner button");
	}
}
