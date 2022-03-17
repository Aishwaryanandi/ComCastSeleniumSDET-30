package com.crm.ProductPractiseTest;

import java.io.FileInputStream;

import java.util.Properties;

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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateProductWithQuickCreateTest

{
	@Test
	public void createproductwithquickcreateTest() throws Throwable
	{

		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		   Properties pobj=new Properties();
		   pobj.load(fis);
		   String BROWSER = pobj.getProperty("browser");
		   String URL = pobj.getProperty("URL"
		   		+ ""
		   		+ "");
		   String USERNAME = pobj.getProperty("username");
		   String PASSWORD = pobj.getProperty("password");
		
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Data2.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet s = book.getSheet("ProductTC1");
		Row r = s.getRow(1);
		Cell c = r.getCell(2);
		String Sony = c.getStringCellValue();
		
		
		
	
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
	    	 System.out.println("Invalid browser");
	     }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type=submit]")).click();
		
		   WebElement ele = driver.findElement(By.xpath("//option[.='Quick Create...']"));
		 
		    ele=driver.findElement(By.xpath("//input[@type='radio'][1]"));
		    Select a = new Select(ele);
		    a.selectByVisibleText("Sony");
		    
		    boolean b = ele.isSelected();
		    if(b)
		    {
		    	System.out.println("cbox is selected");
		    }
		    else
		    {
		    	System.out.println("cbox is not selected");
		    }
		    driver.findElement(By.xpath("//input[@name='productname']")).click();
		    driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
		    String header = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		    
		    ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		    Actions act=new Actions(driver);
		    act.moveToElement(ele).perform();
		    driver.findElement(By.linkText("Sign Out")).click();
		    driver.quit();
		    
		    

			
		
		
		
	}

}
