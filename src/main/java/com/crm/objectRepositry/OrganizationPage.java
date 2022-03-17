package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebdriverUtility;

public class OrganizationPage extends WebdriverUtility
{
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	 

	public  OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgLookUpImg() 
	{
		return createOrgLookUpImg;
	}
	 public void clickOnCreateOrgImg()
	 {
		 createOrgLookUpImg.click(); 
	 }

}
