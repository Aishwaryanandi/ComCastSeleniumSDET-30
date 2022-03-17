package com.crmPRACTICE;

import java.util.Properties;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;

public class PracticeForGenericUtilsTest
{
	@Test
	public void practiseforgenericutils() throws Throwable
	{
		JavaUtility jLib=new JavaUtility();
		int ran = jLib.getRandomNumber();
		String dat = jLib.getSystemDate();
		String date = jLib.getSystemDateInFormat();
		System.out.println(ran+ date);
		System.out.println(dat);
		 
	   Properties pLib=new Properties();
	   String Browser = pLib.getProperty("browser");
	   System.out.println("browser");
	}

}
