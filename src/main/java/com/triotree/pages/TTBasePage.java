package com.triotree.pages;
import org.openqa.selenium.WebDriver;

import com.triotree.utils.PropertyFile;




/**
 * @author PranavPasricha TQBasePage is the super class for all the page
 *         classes
 */

public class TTBasePage{

	public WebDriver webdriver;

	public TTBasePage(WebDriver driver)
	{
		webdriver = driver;
	}

	public WebDriver getWebdriver()
	{
		return webdriver;
	}
	

}
