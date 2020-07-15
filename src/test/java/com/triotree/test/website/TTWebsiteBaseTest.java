package com.triotree.test.website;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.util.FileCopyUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.triotree.utils.DBUtil;
import com.triotree.utils.HtmlLogger;
import com.triotree.website.constants.TestConstants;
import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.test.base.TTBaseTest;

public class TTWebsiteBaseTest extends TTBaseTest {
	public String jsonTestData;
	StringBuilder verificationErrors = new StringBuilder();
	protected TTWebsiteDriver driver = new TTWebsiteDriver(propertyFile);
	private static final Logger logger = LogManager
			.getLogger(TTWebsiteBaseTest.class.getName());
	//	public String idCard = DBUtil.performDatabaseQuery("select top 1 Name from M_IdCardType where Deleted=0");
	public String idCard = null;
	public String occupation = null;
	public String qualification = null;
	public String referredFrom = null;
	public String city = null;
	public String title = null;

	/**
	 * @throws Exception
	 *             setup function loads the driver and environment and baseUrl
	 *             for the tests
	 */

	@BeforeMethod(alwaysRun=true)
	public void setUp() throws Exception {
		driver.loadApplication();           
		driver.getURL();
		//logger.info("Application loaded");
		idCard = getIDCardType();
		occupation = getOccupation();
		qualification = getQualification();
		referredFrom = getRefferedFrom();
		city = getCity();
		title = getTitle();
	}

	@AfterMethod
	public void tearDownSession() throws IOException 
	{
		//driver.quit();
		//renameLogfileName();
	}
	
	public String getIDCardType() {
		String idCard = DBUtil.performDatabaseQuery(TestConstants.GET_ID_CARD_QUERY);
		return idCard;
	}

	public String getOccupation() {
		String occupation = DBUtil.performDatabaseQuery(TestConstants.GET_OCCUPATION_QUERY);
		return occupation;
	}

	public String getQualification() {
		String qualification = DBUtil.performDatabaseQuery(TestConstants.GET_QUALIFICATION_QUERY);
		return qualification;
	}

	public String getRefferedFrom() {
		String referredFrom = DBUtil.performDatabaseQuery(TestConstants.GET_REFFERED_FROM_QUERY);
		return referredFrom;
	}

	public String getCity() {
		String city = DBUtil.performDatabaseQuery(TestConstants.GET_CITY_FROM_QUERY);
		return city;
	}

	public String getTitle() {
		String title = DBUtil.performDatabaseQuery(TestConstants.GET_CITY_FROM_QUERY);
		//System.out.println("title="+title);
		return title;
	}




	//	@BeforeTest(alwaysRun=true)
	//	public void setUp() throws Exception {
	//		driver.loadApplication();		
	//		driver.getURL();
	//		logger.info("Application loaded");
	//	}
	//	@BeforeMethod(alwaysRun=true)
	//	public void beforeMethod(){
	//
	//		try {
	//			Set<String> windows = driver.getWindowHandles();
	//			Iterator<String> iter = windows.iterator();
	//			String[] winNames=new String[windows.size()];
	//			int i=0;
	//			while (iter.hasNext()) {
	//				winNames[i]=iter.next();
	//				i++;
	//			}
	//
	//			if(winNames.length > 1) {
	//				for(i = winNames.length; i > 1; i--) {
	//					driver.switchTo().window(winNames[i - 1]);
	//					driver.close();
	//				}
	//			}
	//			driver.switchTo().window(winNames[0]);
	//			driver.getURL();
	//			driver.manage().deleteAllCookies();
	//		}
	//		catch(Exception e){         
	//			e.printStackTrace();
	//		}
	//	}

	//	@AfterTest(alwaysRun = true)
	//	public void tearDown() throws Exception {
	//		new HtmlLogger().createHtmlLogFile();		
	//		driver.quit();
	//	}





	//Reading test data from JSON File
	public JSONObject getTestData() throws FileNotFoundException, IOException, ParseException{
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./data/"+jsonTestData+".json"));
		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
	}

	//	public void logout(){
	//		driver.quickWaitForElementPresent(By.xpath(".//*[@id='headerForm:home']"));
	//		driver.findElement(By.xpath(".//*[@id='headerForm:home']")).click();
	//		driver.pauseExecutionFor(2000);
	//		driver.quickWaitForElementPresent(By.xpath("//div[contains(text(),'LOG OUT')]"));
	//		driver.findElement(By.xpath("//div[contains(text(),'LOG OUT')]")).click();
	//		logger.info("Logout");		
	//		driver.pauseExecutionFor(3000);
	//
	//	}


	// This assertion for the UI Texts
	public void assertTrue(String message, boolean condition) {
		if (!condition) {
			logger.info("[FUNCTIONAL FAILURE - ASSERTION ERROR ----------- "
					+ message + "]");			
			Assert.fail(message);				
		}

	}

	public void assertTrue(boolean condition, String message) {

		if (!condition) {
			logger.info("[FUNCTIONAL FAILURE - ASSERTION ERROR ----------- "
					+ message + "]");
			Assert.fail(message);
		}
	}

	public void assertEquals(Object obj1, Object obj2, String message) {
		if (!obj1.equals(obj2)) {
			logger.info("[FUNCTIONAL FAILURE - ASSERTION ERROR ----------- "
					+ message + "]");
			Assert.fail(message);
		}
	}

	public void assertEquals(String message, int num1,int num2) {
		if (!(num1==num2)) {
			logger.info("[FUNCTIONAL FAILURE - ASSERTION ERROR ----------- "
					+ message + "]");
			Assert.fail(message);
		}
	}

	public void assertFalse(boolean condition, String message) {

		if (condition) {
			logger.info("[FUNCTIONAL FAILURE - ASSERTION ERROR ----------- "
					+ message + "]");
			Assert.fail(message);
		}
	}

	public void assertFalse(String message, boolean condition) {

		if (condition) {
			logger.info("[FUNCTIONAL FAILURE - ASSERTION ERROR ----------- "
					+ message + "]");
			Assert.fail(message);
		}
	}

	public void assertEquals(String message, float num1,float num2) {

		if (!(num1==num2)) {
			logger.info("[FUNCTIONAL FAILURE - ASSERTION ERROR ----------- "
					+ message + "]");
			Assert.fail(message);
		}
	}
	
	public  void renameLogfileName() throws IOException {
		File f=new File("./logs");
		File []listoffile=f.listFiles();
		File chosenFile = null;
		String className = this.getClass().getSimpleName();
		System.out.println("className= "+className);
		
		long lastModifiedTime = Long.MIN_VALUE;
		for(int i=0;i<listoffile.length;i++) 
		{
			if (listoffile[i].lastModified() > lastModifiedTime)
			{
				chosenFile = listoffile[i];
				lastModifiedTime = listoffile[i].lastModified();
			}
		}
		if(chosenFile.exists()) {
		System.out.println(chosenFile);
		System.out.println(chosenFile.renameTo(new File("./logfolder/"+className+".log")));
		}
		else {
			System.out.println("not exists");
		}
		///return chosenFile.renameTo(new File("./logs/"+className+".log"));

	}

	
}
