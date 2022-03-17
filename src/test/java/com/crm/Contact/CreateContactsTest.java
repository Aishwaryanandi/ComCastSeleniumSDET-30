package com.crm.Contact;

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
import com.crm.objectRepositry.ContactInfoPage;
import com.crm.objectRepositry.ContactsPage;
import com.crm.objectRepositry.CreateContactsPage;
import com.crm.objectRepositry.HomePage;
import com.crm.objectRepositry.LoginPage;
@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)

public class CreateContactsTest extends BaseclassUtility
{
	@Test(groups="smokeSuite")
	public void createcontacts() throws Throwable
	{
		
		
		String xylem = eLib.readDataFromExcel("Contacts", 1, 2)+"_"+jLib.getRandomNumber();
		String lastName = eLib.readDataFromExcel("Contacts", 1, 3)+"_"+jLib.getRandomNumber();
		
		
		
		
		HomePage hp= new HomePage(driver);
		hp.clickOnContactLnk();
		
		
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
	     CreateContactsPage ccp=new CreateContactsPage();
	     ccp.createNewcontact(driver, lastName, xylem);
	     
	     ContactInfoPage cip=new ContactInfoPage();
	     String actheader = cip.contactNameInfo();
	     if(actheader.contains(lastName))
	     {
	    	 System.out.println("contact is created");
	     }
	     else
	     {
	    	 System.out.println("contact is not created");
	     }
	     
	     driver.quit();
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
