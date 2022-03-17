package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage
{
	@FindBy(linkText="More")
	private WebElement moreLnk;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLnk;
	
	public void clickOnCampaign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getMoreLnk() {
		return moreLnk;
	}

	public WebElement getCampaignLnk() {
		return campaignLnk;
	}
	
	public void createCampaign()
	{
		moreLnk.click();
		campaignLnk.click();
	}

}
