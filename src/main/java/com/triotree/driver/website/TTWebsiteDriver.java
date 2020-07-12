package com.triotree.driver.website;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.triotree.utils.PropertyFile;
import com.triotree.driver.website.TTWebsiteDriver;
import com.triotree.driver.TTDriver;

public class TTWebsiteDriver implements TTDriver, WebDriver
{

	public static WebDriver driver; 
	private PropertyFile propertyFile;
	private static int DEFAULT_TIMEOUT = 60;

	static 
	{
		SimpleDateFormat dateformate=new SimpleDateFormat("yyyy-MM-dd_hhmmss");
		System.setProperty("current.date", dateformate.format(new Date()));
	}
	
	public TTWebsiteDriver(PropertyFile propertyFile) {
		//super();
		this.propertyFile = propertyFile;			
	}

	private static final Logger logger = LogManager
			.getLogger(TTWebsiteDriver.class.getName());

	public void loadApplication() throws MalformedURLException 
	{

		if (propertyFile.getProperty("browser").equalsIgnoreCase("firefox"))
		{

			System.setProperty("webdriver.gecko.driver","E:\\Softwares\\geckodriver.exe");
			ProfilesIni profile2 = new ProfilesIni();
			FirefoxProfile profile3 = profile2.getProfile("AutoProfile");
			profile3.setPreference("browser.popups.showPopupBlocker", false);

			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setProfile(profile3);

			driver = new FirefoxDriver(firefoxOptions);

		}
		else if (propertyFile.getProperty("browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

			String downloadFilepath = System.getProperty("user.dir") + "\\Downloads";


			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			chromePrefs.put("pdfjs.disabled", true);
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--test-type");
			options.addArguments("--disable-extensions"); //to disable browser extension popup

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap);  			
		}

		else if(propertyFile.getProperty("browser").equalsIgnoreCase("ie")){
			String driverPath = System.getProperty("user.dir") + "\\src\\test\\resources\\";
			//static String driverPath = "IE driver path";
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			System.out.println("*******************");
			System.out.println("launching IE browser");
			System.out.println("*******************");
			System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");

			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("requireWindowFocus", true);
			driver = new InternetExplorerDriver(capabilities);
		}

		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		//Disabling the chrome-is-being-controlled-by-automated-test-software infobar
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("disable-infobars"); 

		driver.manage().window().maximize();
		//logger.info("Window is maximized");
		// for clearing cookies
		driver.manage().deleteAllCookies();
		//logger.info("All cookies deleted");
		//	driver.get(propertyFile.getProperty("baseUrl"));

	}

	public void getURL() {
		driver.get(propertyFile.getProperty("baseUrl"));
	}

	public boolean isElementPresent(By locator) {
		try{
			if (driver.findElements(locator).size() > 0) {
				return true;
			} else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}



	public void waitForElementPresent(By locator, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			//logger.info("waiting for locator " + locator);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			//logger.info("Element found");
		} catch (Exception e) {
			e.getStackTrace();
		}	
	}

	public boolean isElementPresent(By locator,int time) {
		waitForElementPresent(locator,time);
		try{
			if (driver.findElements(locator).size() > 0) {
				return true;
			} else
				return false;
		}
		catch(Exception e){
			return false;
		}

		finally{
			turnOnImplicitWaits();
		}
	}

	public void turnOffImplicitWaits() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public void turnOnImplicitWaits() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public void pauseExecutionFor(long lTimeInMilliSeconds) {
		try {
			Thread.sleep(lTimeInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean waitForPageLoad() {
		boolean isLoaded = false;
		try {
			//logger.info("Waiting For Page load via JS");
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript(
							"return document.readyState").equals("complete");
				}
			};
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
			wait.until(pageLoadCondition);
			isLoaded = true;
		} catch (Exception e) {
			logger.error("Error Occured waiting for Page Load "
					+ driver.getCurrentUrl());
		}
		return isLoaded;
	}


	public void quickWaitForElementPresent(By locator){
		//logger.info("quick wait started for "+locator);
		int timeout = 2;
		turnOffImplicitWaits();
		for(int i=1;i<=timeout;i++){
			try{
				if(driver.findElements(locator).size()==0){
					pauseExecutionFor(500);
					logger.info("waiting...");
					continue;
				}else{
					//logger.info("wait over,element found");
					turnOnImplicitWaits();
					break;
				}			
			}catch(Exception e){
				continue;
			}
		}
	}

	public void waitForElementNotPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
			//logger.info("waiting for locator " + locator);
			wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(locator)));
			//logger.info("Element found");
		} catch (Exception e) {
			e.getStackTrace();
		}		
	}

	public void waitForLoadingImageToDisappear(){
		turnOffImplicitWaits();
		By locator = By.xpath("//div[@class='modal']"); //Need to add the XPath of Loading Image
		logger.info("Waiting for loading image to get disappear");
		for(int i=1;i<=DEFAULT_TIMEOUT;i++){			
			try{
				if(driver.findElements(locator).size()==1){
					pauseExecutionFor(1000);
					logger.info("waiting..");
					continue;
				}else{
					turnOnImplicitWaits();
					logger.info("loading image disappears");
					break;
				}			
			}catch(Exception e){
				continue;
			}
		}

	}

	public void click(By locator) {		
		waitForElementPresent(locator);
		quickWaitForElementPresent(locator);
		try{
			findElement(locator).click();			
		}catch(Exception e){
			retryingFindClick(locator);
		}		
	}
	public boolean retryingFindClick(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 5) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
			pauseExecutionFor(1000);
		}
		return result;
	}

	public boolean deleteAllCookies(WebDriver driver) {
		boolean IsDeleted = false;
		try {
			driver.manage().deleteAllCookies();
			IsDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsDeleted;
	}

	public void clickByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static String getDateTime() {
		String sDateTime = "";
		try {
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			Date now = new Date();
			String strDate = sdfDate.format(now);
			String strTime = sdfTime.format(now);
			strTime = strTime.replace(":", "-");
			sDateTime = "D" + strDate + "_T" + strTime;
		} catch (Exception e) {
			System.err.println(e);
		}
		return sDateTime;
	}

	public void switchToSecondWindow() throws InterruptedException{
		Thread.sleep(3000);
		Set<String> allWindows = driver.getWindowHandles();
		logger.info("total windows opened = "+allWindows.size());
		String parentWindow = driver.getWindowHandle();
		for(String allWin : allWindows){
			if(!allWin.equalsIgnoreCase(parentWindow)){
				driver.switchTo().window(allWin);
				Thread.sleep(4000);
				break;
			}

		}
		logger.info("Switched to second window whose title is "+driver.getTitle());		
	}






	public void waitForElementPresent(By locator) {

		//logger.info("wait started for "+locator);
		int timeout = 10;
		turnOffImplicitWaits();
		boolean isElementFound = false;
		for(int i=1;i<=timeout;i++){		
			try{
				if(driver.findElements(locator).size()==0){
					pauseExecutionFor(1000);
					logger.info("waiting...");
					continue;
				}else{
					//logger.info("wait over,element found");
					isElementFound =true;
					turnOnImplicitWaits();
					pauseExecutionFor(1000);
					break;
				}			
			}catch(Exception e){
				continue;
			}
		}
		if(isElementFound ==false)
			logger.info("ELEMENT NOT FOUND");		
	}


	public static String takeSnapShotAndRetPath(String
			methodName) throws Exception {

		String FullSnapShotFilePath = "";

		//try { 
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			String sFilename ="Screenshot-" +methodName+getDateTime() + ".png";
			System.out.println("Screenshotfile name is "+sFilename); 
			FullSnapShotFilePath= System.getProperty("user.dir") +"/output/" + sFilename;
			System.out.println("FullSnapShotFilePath name is "+FullSnapShotFilePath);
			FileUtils.copyFile(scrFile, new File(FullSnapShotFilePath));
			
		//} 
		//catch(Exception e) {}

		return FullSnapShotFilePath; 
	}


//	public static String takeSnapShotAndRetPath(WebDriver driver) throws Exception {
//
//		String FullSnapShotFilePath = "";
//		try {
//			logger.info("Taking Screenshot");
//			File scrFile = ((TakesScreenshot) driver)
//					.getScreenshotAs(OutputType.FILE);
//			String sFilename = null;
//			sFilename = "verificationFailure_Screenshot.png";
//			FullSnapShotFilePath = System.getProperty("user.dir")
//					+ "/output/" + sFilename;
//			FileUtils.copyFile(scrFile, new File(FullSnapShotFilePath));
//
//		} catch (Exception e) {
//
//		}
//
//		return FullSnapShotFilePath;
//	}



	public void waitForLoadingImageToAppear(){
		turnOffImplicitWaits();
		By locator = By.xpath("//div[@id='blockUIBody']");
		int timeout = 3;

		for(int i=1;i<=timeout;i++){			
			try{
				if(driver.findElements(locator).size()==0){
					pauseExecutionFor(1000);

					continue;
				}else{
					turnOnImplicitWaits();

					break;
				}			
			}catch(Exception e){
				continue;
			}
		}

	}

	public void waitForSpinImageToDisappear(){
		turnOffImplicitWaits();
		By locator = By.xpath("//span[@id='email-ajax-spinner'][contains(@style,'display: inline;')]");
		logger.info("Waiting for sping image to get disappear");
		for(int i=1;i<=DEFAULT_TIMEOUT;i++){
			try{
				if(driver.findElements(locator).size()==1){
					pauseExecutionFor(1000);
					logger.info("waiting..");
					continue;
				}else {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					System.out.println( "System has been logged out at "+sdf.format(cal.getTime()) );
					logger.info("System has been logged out at "+sdf.format(cal.getTime()) );
					turnOnImplicitWaits();
					break;
				}			
			}catch(Exception e){
				continue;
			}
		}
	}

	public void waitForElementTobeEnabled(By locator){
		for(int time=1;time<=30;time++){
			if(driver.findElement(locator).isEnabled()==true){
				break;
			}		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void moveToELement(By locator) {
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(locator));
	}

	public void get(String Url) {
		driver.get(Url);
	}


	public void quit() {
		driver.quit();
	}

	public List<WebElement> findElements(By by) {
		// movetToElementJavascript(by);
		return driver.findElements(by);
	}

	public String getTitle() {
		return driver.getTitle();
	}


	public WebElement findElement(By by) {
		return driver.findElement(by);
	}

	public WebElement findElementWithoutMove(By by) {
		// movetToElementJavascript(by);
		return driver.findElement(by);
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void close() {
		driver.close();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	public Navigation navigate() {
		return driver.navigate();

	}

	public Options manage() {
		return driver.manage();
	}

	public Select getSelect(By by) {
		return new Select(findElement(by));
	}

	public void scrollToBottomJS() throws InterruptedException {
		((JavascriptExecutor) driver)
		.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	}

	public void clear(By by) {
		//		quickWaitForElementPresent(by);
		findElement(by).clear();
	}

	public void movetToElementJavascript(By locator) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				driver.findElement(locator));
	}

	public String getAttribute(By by, String name) {
		return findElement(by).getAttribute(name);
	}

	/**
	 * 
	 * Purpose:This Method return text value of Element.
	 * 
	 * @author: 
	 * @date:
	 * @returnType: String
	 * @param by
	 * @return
	 */
	public String getText(By by) {
		return findElement(by).getText();
	}

	public void fnDragAndDrop(By by) throws InterruptedException {
		WebElement Slider = driver.findElement(by);
		Actions moveSlider = new Actions(driver);
		moveSlider.clickAndHold(Slider);
		moveSlider.dragAndDropBy(Slider, 150, 0).build().perform();
	}

	public Actions action() {
		return new Actions(driver);
	}



	/**
	 * Checks if element is visible Purpose:
	 * 
	 * @author: 
	 * @date:
	 * @returnType: WebElement
	 */
	public boolean IsElementVisible(WebElement element) {
		return element.isDisplayed() ? true : false;
	}

	/**
	 * 
	 * Purpose:Waits for element to be visible
	 * 
	 * @author: 
	 * @date:
	 * @returnType: WebElement
	 */
	public boolean waitForElementToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		return IsElementVisible(element);
	}

	/**
	 * 
	 * Purpose: Waits and matches the exact title
	 * 
	 * @author: 
	 * @date:
	 * @returnType: boolean
	 */
	public boolean IsTitleEqual(By locator, int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.titleIs(title));
	}

	/**
	 * Waits and matches if title contains the text Purpose:
	 * 
	 * @author: 
	 * @date:
	 * @returnType: boolean
	 */
	public boolean IsTitleContains(By locator, int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * Wait for element to be clickable Purpose:
	 * 
	 * @author: 
	 * @date:
	 * @returnType: WebElement
	 */
	public WebElement waitForElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(locator));
		return element;
	}

	/**
	 * 
	 * Purpose:Wait for element to disappear
	 * 
	 * @author: 
	 * @date:
	 * @returnType: boolean
	 */
	public boolean waitForElementToBeInVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut) {
			
		};
		return wait.until(ExpectedConditions
				.invisibilityOfElementLocated(locator));
	}



	public void selectFromList(List<WebElement> lstElementList,
			String sValueToBeSelected) throws Exception {
		logger.info("START OF FUNCTION->selectFromList");
		boolean flag = false;
		logger.info("Total element found --> " + lstElementList.size());
		logger.info("Value to be selected " + sValueToBeSelected + " from list"
				+ lstElementList);
		for (WebElement e : lstElementList) {
			logger.info(">>>>>>>>>>>>>" + e.getText() + "<<<<<<<<<<<<<<<");
			if (e.getText().equalsIgnoreCase(sValueToBeSelected)) {
				logger.info("Value matched in list as->" + e.getText());
				e.click();
				flag = true;
				break;
			}
		}
		if (flag == false) {
			throw new Exception("No match found in the list for value->"
					+ sValueToBeSelected);
		}
		logger.info("END OF FUNCTION->selectFromList");
	}

	public WebElement waitForElementToBeClickable(WebElement element,
			int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

	public void clickAnyWhereOnScreen(){
		driver.findElement(By.id("body_clickable")).click();
	}

	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void selectByvisibletext(By locator,String text) 
	{
		Select sl =new Select(driver.findElement(locator));
		sl.selectByVisibleText(text);
	}
	
	public static void doubleclick(WebElement element) 
	{
		Actions ac=new Actions(driver);
		ac.doubleClick(element).click().perform();
	}
}
