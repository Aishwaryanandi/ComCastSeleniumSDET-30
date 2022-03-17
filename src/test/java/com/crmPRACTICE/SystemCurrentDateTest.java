package com.crmPRACTICE;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SystemCurrentDateTest 
{
	@Test
	public   void systemcurrentdate()
	{
		LocalDateTime ldate=LocalDateTime.now();
		int day = ldate.getDayOfMonth();
		String mon = ldate.getMonth().name();
		int year = ldate.getYear();
		String month = mon.substring(0, 1).toUpperCase() +mon.substring(1).toLowerCase();
		Integer idate=day;
		String sday=idate.toString();

		Integer iyear=year;
		String syear=iyear.toString();
		System.out.println(sday+" "+month+" "+syear);
	
		System.out.println(month);
		String dateFormat = month+" "+syear;
		System.out.println(dateFormat+" "+day+" "); 
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		//String datexpath = "//div[text()='"+dateFormat+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']";
		driver.findElement(By.xpath("//div[text()='"+dateFormat+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+sday+"']")).click();
	}

}
