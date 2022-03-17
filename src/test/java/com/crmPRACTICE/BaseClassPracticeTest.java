package com.crmPRACTICE;

import org.testng.annotations.BeforeSuite;

public class BaseClassPracticeTest 
{
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("login to app");
	}
	

}
