package com.crm.objectRepositry;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrg1Test 
{
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorgLnk;
	
	@FindBy(name="accountname")
	private WebElement orgnameLnk;
	
	 @FindBy(xpath="//input[@title= 'Save [Alt+S]']")
      private WebElement saveBtn;	
	public void CreateOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCreateorgLnk() {
		return createorgLnk;
	}

	public WebElement getOrgnameLnk() {
		return orgnameLnk;
	}
	public void createNewOrg(String Org_Name)
	{
		orgnameLnk.sendKeys(Org_Name);
		saveBtn.click();
	}

}



