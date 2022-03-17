package com.crmPRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CalendarSelectforgoibiboTest
{
	@Test
	public void calendarselectforgoibibo()
	{
		WebDriver driver=new  FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10, 10);
		
		driver.findElement(By.xpath("//div[@class='sc-jJoQJp iPfLQ']")).click();
	}

}
