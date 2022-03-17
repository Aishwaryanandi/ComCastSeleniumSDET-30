package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebdriverUtility;

public class ContactsPage extends WebdriverUtility
{
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	

	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}
	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}


	public void clickOnCreateContactImg()
	{
		createContactLookUpImg.click();
	}
	
	public void clickOnCreateNewContact(String lastName)
	{
		lastNameEdt.click();
	}
	 
	

}
