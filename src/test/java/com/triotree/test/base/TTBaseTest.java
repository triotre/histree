package com.triotree.test.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.triotree.test.base.TTBaseTest;
import com.triotree.utils.ExcelReader;
import com.triotree.utils.PropertyFile;
import com.triotree.website.constants.TestConstants;


@Listeners({ com.triotree.listners.TestListner.class })
//@Listeners(ResultListener.class)
public class TTBaseTest {
	public static WebDriver driver;
	public String defaultProps = "defaultenv.properties";
	public static ExtentReports extent;
	public static ExtentTest test;
	protected static long startTime ;
	protected static long endTime ;

	static 
	{
		SimpleDateFormat dateformate=new SimpleDateFormat("yyyy-MM-dd_hhmmss");
		System.setProperty("current.date", dateformate.format(new Date()));
	}
	String reportpath=System.getProperty("user.dir")+"/extent_report/"+this.getClass().getSimpleName()+"_"+"ExtentReport"+".html";
	protected PropertyFile propertyFile = new PropertyFile();
	private static final Logger logger = LogManager
			.getLogger(TTBaseTest.class.getName());
	//	protected SoftAssert s_assert;
	/**
	 * @param envproperties
	 *            envproperties is the file name that is given to pom.xml that
	 *            contains the environment details that to be loaded
	 * @throws Exception 
	 */
	@BeforeSuite
	@Parameters({"envproperties"})
	public void beforeSuite(@Optional String envproperties) throws Exception {
		extent=createInstance(reportpath);
		//System.out.println("Started execution with " + " " + envproperties);
		//Changed debug to Info
		//logger.info("Started execution with " + " " + envproperties);
		if (!StringUtils.isEmpty(envproperties)) {
			propertyFile.loadProps(envproperties);
			logger.debug("Environment properties recieved and preparing the environment for "
					+ envproperties); 
			logger.info("EXECUTION ENVIRONMENT ------ "+propertyFile.getProperty("browser"));

		} else {
			propertyFile.loadProps(defaultProps);
//			logger.info("Environment properties are not provided by the user ... loading the default properties");
//			logger.info("Default Browser is  ------ "+propertyFile.getProperty("browser"));
//			logger.info("Default URL is  ------ "+propertyFile.getProperty("baseUrl"));
//			logger.info("Default loginname is  ------ "+propertyFile.getProperty("loginname"));
//			logger.info("Default username is  ------ "+propertyFile.getProperty("username"));
//			logger.info("Default user password is  ------ "+propertyFile.getProperty("password"));

		}
		// clear screenshots folder
		
		/*
		 * try { FileUtils.cleanDirectory(new File(System.getProperty("user.dir") +
		 * "\\output\\ScreenShots")); } catch (IOException e) { e.printStackTrace(); }
		 */
		 

		// clear Downloads folder
		try {
			FileUtils.cleanDirectory(new File(System.getProperty("user.dir")
					+ "\\Downloads"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void beforeclass() throws Exception
	{
		startTime=System.currentTimeMillis();
	}

	@AfterSuite(alwaysRun=true)
	public void afterSuite() throws IOException{
		endTime =  System.currentTimeMillis();
		//create a time stamp to be added to new logs,output and test-output folders
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String timeStamp = String.valueOf(dateFormat.format(date));

		// set the location of the source directories of logs,output and test-output folder
		//String srcLogsDirectory = System.getProperty("user.dir")+"\\logs";
		//String srcOutputDirectory = System.getProperty("user.dir")+"\\output";
		//String srcTestOutputDirectory = System.getProperty("user.dir")+"\\test-output";

		// set the location of the destination directories of logs,output and test-output folder under buildHistory folder
		//String destinationLogsDirectory = System.getProperty("user.dir")+"\\buildHistory\\logs\\logs-"+timeStamp;
		//String destinationOutputDirectory = System.getProperty("user.dir")+"\\buildHistory\\output\\output-"+timeStamp;
		//String destinationTestOutputDirectory = System.getProperty("user.dir")+"\\buildHistory\\test-output\\test-output-"+timeStamp;

		// create new folders for logs,output and test-output directories
		try {
			//FileUtils.forceMkdir(new File(destinationLogsDirectory));
			//FileUtils.forceMkdir(new File(destinationOutputDirectory));
			//FileUtils.forceMkdir(new File(destinationTestOutputDirectory));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// copy the latest data to logs,output and test-output directories
		try {
			//FileUtils.copyDirectory(new File(srcLogsDirectory), new File(destinationLogsDirectory));
			//FileUtils.copyDirectory(new File(srcOutputDirectory), new File(destinationOutputDirectory));
			//FileUtils.copyDirectory(new File(srcTestOutputDirectory), new File(destinationTestOutputDirectory));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ExtentReports createInstance(String filename) throws Exception
	{
		ExtentHtmlReporter htmlreport=new ExtentHtmlReporter(filename);
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setDocumentTitle("TrioTree Technologies Pvt. Ltd.");
		htmlreport.config().setEncoding("utf-8");
		htmlreport.config().setReportName("Trio Tree Launchpad Automation Report");
		htmlreport.config().setAutoCreateRelativePathMedia(true);
		

		String browser = propertyFile.getProperty("browser");

		extent=new ExtentReports();
		extent.setSystemInfo("OS Name:", System.getProperty("os.name"));
		extent.setSystemInfo("OS Version", System.getProperty("os.version"));
		extent.setSystemInfo("User Name:", System.getProperty("user.name"));
		extent.setSystemInfo("Browser", browser);
		extent.attachReporter(htmlreport);
		return extent;
	}


	/**
	 * @throws Exception
	 */
	@DataProvider(name = "ttTestData")
	public Object[][] ttDataProvider(Method testMethod) throws Exception {
		String sheetName = testMethod.getName();
		String filePath = "src/test/resources/"
				+ testMethod
				.getDeclaringClass()
				.getName()
				.replace(TestConstants.DOT, TestConstants.FORWARD_SLASH)
				+ ".xlsx";
		System.out.println("Test data is loaded from file " + filePath
				+ " and the sheet is " + sheetName);
		Object[][] testObjArray = ExcelReader.getTableArray(filePath,
				testMethod.getName());

		return (testObjArray);
	}
	

}
