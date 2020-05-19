package com.triotree.website.constants;

import java.util.Properties;

import org.testng.internal.PropertiesFile;

import com.triotree.utils.DBUtil;
import com.triotree.utils.PropertyFile;

public class TestConstants {
	
	protected static PropertyFile propertyFile = new PropertyFile();

		public static final String USER_ID = "1687162";

		/*
		 * Character constants
		 */
		public static final String DOT = ".";
		public static final String FORWARD_SLASH = "/";
		public static final String DOLLAR = "$";
		public static final String BACK_SLASH = "\\";
		public static final String EMPTY_STRING = "";
		public static final String IOS = "";
		
		
		/*
		 * DB Queries
		 */
		public static final String GET_ID_CARD_QUERY = "select top 1 Name from M_IdCardType where Deleted=0";
		public static final String GET_OCCUPATION_QUERY = "select top 1 name from M_OCCUPATION where Deleted=0";
		public static final String GET_QUALIFICATION_QUERY = "select top 1 Name from M_QUALIFICATION where Deleted=0";
		public static final String GET_REFFERED_FROM_QUERY = "select top 1 Name from m_SourceOfInfo where Deleted=0";
		public static final String GET_CITY_FROM_QUERY = "select top 1 NAME from m_city where deleted=0";
		public static final String GET_TITLE_FROM_QUERY = "select top 1 NAME from m_city where deleted=0";
		
		}
