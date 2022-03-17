package com.crm.objectRepositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebdriverUtility;

public class HomePage extends WebdriverUtility
{
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Oppurtunity")
	private WebElement oppurtunityLnk;
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	@FindBy(linkText="More")
	private WebElement moreLnk;
	
	@FindBy(linkText="Campigns")
	private WebElement campaignsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrationLnk;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationLnk() 
	{
		return organizationLnk;
	}

	public WebElement getContactsLnk()
	{
		return contactsLnk;
	}

	public WebElement getOppurtunityLnk()
	{
		return oppurtunityLnk;
	}

	public WebElement getProductsLnk()
	{
		return productsLnk;
	}

	public WebElement getMoreLnk()
	{
		return moreLnk;
	}

	public WebElement getCampaignsLnk()
	{
		return campaignsLnk;
	}

	public WebElement getAdministrationLnk()
	{
		return administrationLnk;
	}

	public WebElement getSignOutLnk()
	{
		return signOutLnk;
	}
	
	public void clickOnOrgLnk()
	{
		organizationLnk.click();
	}
	public void clickOnContactLnk()
	{
		contactsLnk.click();
	}
	public void signOutOfApp(WebDriver driver)
	{
		mouseHover(driver, administrationLnk);
		signOutLnk.click();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
