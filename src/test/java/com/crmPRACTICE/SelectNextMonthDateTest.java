package com.crmPRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectNextMonthDateTest
{
	@Test
	public void calendar()
	{
		int date=18;
		String monthandyear="Aug 2022";

		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		

		Actions actions=new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();

		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		String arrowxpath="//span[@aria-label='Next Month']";
	 String datexpath = "//div[text()='Aug 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='18']";
				
				//driver.findElement(By.xpath(datexpath)).click();
		
		// driver.findElement(By.xpath("//div[.='April 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='20']")).click();
		for(;;)
		{
			try
			{
				
				driver.findElement(By.xpath(datexpath)).click();
				break;
			}
			catch (Exception e)
			{
				driver.findElement(By.xpath(arrowxpath)).click();
			}
		}
	}

}
