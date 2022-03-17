package com.crm.objectRepositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebdriverUtility;

public class CreateContactsPage extends WebdriverUtility
{
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orgNameLookUpImg;

	
	@FindBy(name="leadsource")
	private WebElement leadsouceDropDown;
	
	@FindBy(xpath="//input=[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public void CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;

	}

	public WebElement getOrgNameLookUpImg() {
		return orgNameLookUpImg;
	}

	public WebElement getLeadsouceDropDown() {
		return leadsouceDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public void createNewcontact(String lastname, String leadSource)
	{
		lastnameEdt.sendKeys(lastname);
		select(leadSource, leadsouceDropDown);
		saveBtn.click();
	}
	
	public void createNewcontact(WebDriver driver , String lastname, String OrgName)
	{
		lastnameEdt.sendKeys(lastname);
		orgNameLookUpImg.click();
	     switchToWindow(driver, "Accounts");
	     searchEdt.sendKeys(OrgName);
	     searchBtn.click();
	     driver.findElement(By.xpath("//a[.='"+OrgName+"']")).click();
	     switchToWindow(driver, "Contacts");
	     saveBtn.click();
	     
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
