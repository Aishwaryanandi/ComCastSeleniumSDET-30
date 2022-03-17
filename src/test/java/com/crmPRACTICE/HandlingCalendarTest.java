package com.crmPRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandlingCalendarTest
{
	@Test
	public void calendar()
	{
		int date=20;
		String monthandyear="April 2022";

		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();

		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		//driver.findElement(By.xpath("//div[text()=' "+monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
        driver.findElement(By.xpath("//div[.='April 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='20']")).click();
	}

}
