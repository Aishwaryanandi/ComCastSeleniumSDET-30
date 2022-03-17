package com.crmOrg;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class CreateOrgTest 
{
	@Test
	public void createorg() throws Throwable
	{
		Random random=new Random();
		int ran = random.nextInt(500);
		
		         
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
	    FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Data2.xlsx");
	    Workbook wb = WorkbookFactory.create(fi);
	    Sheet s = wb.getSheet("OrgTest");
	    Row r = s.getRow(1);
	    Cell c = r.getCell(2);
	    String ORG_NAME = c.getStringCellValue()+random;
	    
	    
	    WebDriver driver=null;
	    if(BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	driver=new FirefoxDriver();
	    }
	    else if(BROWSER.equalsIgnoreCase("chrome"))
	    {
	    	driver=new ChromeDriver();
	    }
	    else
	    {
	    	System.out.println("invalid browser");
	    }
	    
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    driver.get(URL);
	    
	    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
	    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    
	    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORG_NAME);
	    
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    
	    WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions act=new Actions(driver);
	    act.moveToElement(ele).perform();
	    
	    driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
	    driver.quit();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}

}
