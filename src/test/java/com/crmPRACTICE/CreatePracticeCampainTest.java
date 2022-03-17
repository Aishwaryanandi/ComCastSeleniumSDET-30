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
import com.crm.objectRepositry.HomePage;
import com.crm.objectRepositry.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePracticeCampainTest extends BaseclassUtility
{
	@Test
	public void createpracticecampaign() throws Throwable
	{
		
		String Campaign_name = eLib.readDataFromExcel("CampaignTC", 1, 2)+"_"+jLib.getRandomNumber();
		String Product_name = eLib.readDataFromExcel("CampaignTC", 1,3 )+"_"+jLib.getRandomNumber();
		String Productcategory = eLib.readDataFromExcel("CampaignTC", 1, 4)+"_"+jLib.getRandomNumber();
		
		
		HomePage hp=new HomePage(driver);
		hp.getCampaignsLnk();
		
		CreatePracticeCampainTest cpc=new CreatePracticeCampainTest();
		cpc.createpracticecampaign();
		
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
