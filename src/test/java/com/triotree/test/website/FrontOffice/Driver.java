package com.triotree.test.website.FrontOffice;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;
import org.testng.TestNG;

public class Driver {

	public static void main(String[]args) 
	{
		//		ArrayList<String> list=new ArrayList<String>();
		//		TestNG run=new TestNG();
		//		list.add("testng.xml");
		//		run.setTestSuites(list);
		//		run.run();
		getvalue();	
	}
	public static String getvalue() 
	{
		String value = null;
		File myFile7 = new File("./Downloads");
		File[] listoffile=myFile7.listFiles();
		for(int i=0;i<listoffile.length;i++)
		{
			if(listoffile[i].isFile()) 
			{
				String nameoffile = listoffile[i].getName();
				String exe = FilenameUtils.getExtension(nameoffile);
				System.out.println("nameoffile="+nameoffile);
				System.out.println(exe);
				String []array=nameoffile.split(exe);
				value=array[0]+"xlsx";
			}			
		}
		return value;
	}
}
