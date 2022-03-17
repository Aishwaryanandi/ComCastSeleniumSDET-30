package com.crmPRACTICE;

import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseclassUtility;
import com.crm.objectRepositry.HomePage;

public class OrganizationCheckboxTest extends BaseclassUtility
{
	@Test
	public void organizationcheckboxtest()
	{

		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		
		List<WebElement> ele = driver.findElements(By.xpath("//table/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		ArrayList<WebElement> eles = (ArrayList<WebElement>) ele;


		eles.get(4).click();

		driver.findElement(By.xpath("//table/tbody/tr[7]/td/a[.='del']")).click();
		wLib.acceptAlert(driver);	   


	}

}
