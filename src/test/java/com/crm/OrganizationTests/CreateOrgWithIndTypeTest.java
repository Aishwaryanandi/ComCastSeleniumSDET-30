package com.crm.OrganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
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
@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateOrgWithIndTypeTest extends BaseclassUtility
{
	@Test(groups="regression")
	public void createOrgwithIndType() throws Throwable
	{
		
		
		String orgName = eLib.readDataFromExcel("Org", 4, 2)+"_"+jLib.getRandomNumber();
		String indType = eLib.readDataFromExcel("Org", 4, 3);
		
		
		HomePage hp= new HomePage(driver);
		hp.clickOnOrgLnk();
        Assert.fail();
        
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		
         CreateOrganizationPage cop=new CreateOrganizationPage(driver);
         cop.createNeworg(indType);
         
         OrganizationInfoPage oip=new OrganizationInfoPage(driver);
         String actHeader = oip.OrgnameInfo();
         if(actHeader.contains(orgName))
         {
        	 System.out.println("organiztion created");
         }
         else
         {
        	 System.out.println("organiztion not created");
         }
         
         
         driver.quit();
         
         
         }
       @Test(groups="regional")
       public void createSample(){
    	   System.out.println("sample test");
       }
}
