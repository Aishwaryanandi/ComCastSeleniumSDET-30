package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage 
{
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	@FindBy(name="industry")
	private WebElement industryDropDown;
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	@FindBy(xpath="//input[@title= 'Save [Alt+S]']")
	private WebElement savebtn;
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	public void createNewOrg(String OrgName)
	{
		orgNameEdt.sendKeys(OrgName);
		savebtn.click();
	}
	public void createNeworg(String indType)
	{
		industryDropDown.click();
	}
	

}

