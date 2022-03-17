package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage
{
	@FindBy(xpath="//span[@class='dvheaderText']")
	private WebElement contactHeaderText;
	
	public void ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	
     
	public String contactNameInfo()
	{
		return contactHeaderText.getText();
	}

}
