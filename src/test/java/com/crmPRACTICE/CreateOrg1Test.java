package com.crmPRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseclassUtility;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebdriverUtility;
import com.crm.objectRepositry.CreateOrganizationPage;
import com.crm.objectRepositry.HomePage;
import com.crm.objectRepositry.LoginPage;
import com.crm.objectRepositry.OrganizationInfoPage;
import com.crm.objectRepositry.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrg1Test extends BaseclassUtility
{
	@Test
	public void createorg() throws Throwable
	{
		
		
		String ORG_NAME = eLib.readDataFromExcel("OrgTest", 1, 2)+"_"+jLib.getRandomNumber();
		
		
	
	
	HomePage hp= new HomePage(driver);
	hp.clickOnOrgLnk();
	
	OrganizationPage op=new OrganizationPage(driver);
	op.clickOnCreateOrgImg();
	
	CreateOrganizationPage cop=new CreateOrganizationPage(driver);
	cop.createNewOrg(ORG_NAME);
	
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String oipheader = oip.OrgnameInfo();
	if(oipheader.contains(oipheader))
	{
		System.out.println("org is created");
	}
	else
	{
		System.out.println("org is not created");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	}
}
