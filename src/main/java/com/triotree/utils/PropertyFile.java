package com.triotree.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

	public static String path = "src/test/resources/";
	private static final Properties props = new Properties();
	static Properties prop;
	public static void loadProps(String fileName) {
		try {
			FileInputStream inputStream = new FileInputStream(path+fileName);
			try {
				props.load(inputStream);
			} catch (IOException e) {
				e.getMessage();
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) 
	{
		return props.getProperty(key);
	}

	public void setProperty(String key, String value) {
		props.setProperty(key, value);
	}

	public static String getproperty(String filename, String propertyname) throws Exception
	{
		prop=new Properties();
		prop.load(new FileInputStream("./src/test/resources/"+filename+".properties"));
		String value=prop.getProperty(propertyname);
		if(value==null)
		{
			throw new Exception("Property "+propertyname+" not found in "+filename+".properties");
		}
		return value;


	}
}