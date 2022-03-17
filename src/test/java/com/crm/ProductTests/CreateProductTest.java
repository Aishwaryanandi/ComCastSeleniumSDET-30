package com.crm.ProductTests;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

public class CreateProductTest
{
	@Test
	public void createproductTest() throws Throwable
	{
		Random ran=new Random();
		int random = ran.nextInt();
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		 Properties pobj=new Properties();
		 pobj.load(fis);
		 
		 String BROWSER = pobj.getProperty("browser");
		 String URL = pobj.getProperty("URL");
	     String USERNAME = pobj.getProperty("username");
	     String PASSWORD = pobj.getProperty("password");
	     
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Data1.xlsx");
		 Workbook book = WorkbookFactory.create(fi);
		 Sheet s = book.getSheet("Product");
		 Row r = s.getRow(1);
		 Cell c = r.getCell(2);
		 String Nokia = c.getStringCellValue();
		 
		String Nokiaran = Nokia +" "+random;
		Cell ce = r.getCell(1);
		String comname = ce.getStringCellValue()+" "+random;
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
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get(URL);
		 driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		 driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 driver.findElement(By.linkText("Products")).click();
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		 
		 
		 driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(Nokiaran);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 String prodheader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		 if(prodheader.contains(Nokiaran))
		 {
			 System.out.println(prodheader);
			 System.out.println("product created");
			 
		 }
		 else
		 {
			 System.out.println(prodheader);
			 System.out.println("product not header");
		 }
		 driver.findElement(By.linkText("More")).click();
		 
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(comname);
		
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		
		Set<String> win = driver.getWindowHandles();
		
		 for (String winid : win)
		 {
			 driver.switchTo().window(winid);
			
		}
		 driver.findElement(By.xpath("//a[.='"+Nokiaran+"']")).click();
		 Set<String> win1 = driver.getWindowHandles();
		 for (String w1 : win1)
		 {
			 driver.switchTo().window(w1);
			
		}
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		  String comheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if(comheader.contains(comname))
		 {
		 
			 System.out.println(comheader +"contact saved ");
		 }
		 else
		 {
			 System.out.println("contact not created");
		 }
		 
		// driver.findElement(By.xpath("input[@name='search_txt']")).click();
		 //driver.findElement(By.xpath("//input[@name='search']")).click();
		 //driver.findElement(By.linkText("NOKIA")).click();
		
		 //driver.findElement(By.xpath("//span[@class='dvHeaderText']")).click();
		 
		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(ele).perform();
		 driver.findElement(By.linkText("Sign Out"));
		 driver.quit();
		 
		 
		 
		 
		
		
	}

}
