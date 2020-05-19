package com.triotree.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.triotree.utils.DBUtil;

public class TestDatabase 
{
	private static final Logger log=Logger.getLogger(TestDatabase.class.getName());
	////////////////////////////////////////////////////
	static Connection con = null;
	// Statement object
	private static Statement stmt;
	// Constant for Database URL
	public static String DB_URL = "jdbc:mysql://206.19.38.4:1433/SIT_HISTree_TestingAuto"; 
	//jdbc:mysql://206.19.38.4:3306/
	// Constant for Database Username
	public static String DB_USER = "devuser2017";
	// Constant for Database Password
	public static String DB_PASSWORD = "devuser2017";
	public static void main(String []args)
	{
		//DBUtil.getConnectionString("SIT_HISTree_TestingAuto");
		//DBUtil.getConnectionString("SIT_HISTree_TestingAuto", "206.19.38.4");
			try {
			 String dbClass = "com.mysql.jdbc.Driver";
	         Class.forName(dbClass).newInstance();
	         // Get connection to DB
	         Connection con = DriverManager.getConnection("jdbc:sqlserver://206.19.38.4:1433;databaseName=NT Service\\MSSQL$SQLEXPRESS;integratedSecurity=true;", "devuser2017", "devuser2017");
	         // Statement object to send the SQL statement to the Database
	         
	         stmt = con.createStatement();
	         con.close();
	         }
	         catch (Exception e)
	         {
	               e.printStackTrace();
	         }
			
		//String result=DBUtil.performDatabaseQuery("select top 1 id from M_IdCardType where Deleted=0");
		//log.info("Result::"+result);
	}
}
