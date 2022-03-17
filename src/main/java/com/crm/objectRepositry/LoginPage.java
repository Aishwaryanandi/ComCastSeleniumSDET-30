package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitbutton")
	private WebElement submitbtn;

	public WebElement getUserNameEdt()
	{
		return userNameEdt;
	}

	public WebElement getPasswordEdt() 
	{
		return passwordEdt;
	}

	public WebElement getSubmitbtn()
	{
		return submitbtn;
	}
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	 
	public void loginToApp(String userName, String password)
	{
		userNameEdt.sendKeys(userName);
		passwordEdt.sendKeys(password);
		submitbtn.click();
		
	}
	
	

}
