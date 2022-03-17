package com.crm.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author owner
 *
 */

public class WebdriverUtility
{
	/**
	 * 
	 * @param driver
	 */
	public void maximizewindow(WebDriver driver)
	{
		
		driver.manage().window().maximize();
	}
	/**
	 * 
	 * @param driver
	 */
	public void waitforPageLoad(WebDriver driver)
	{
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitforElementtobeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitforElementtobeVisible(WebDriver driver, WebElement element)
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
	
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * 
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text)
	{
		
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * 
	 * @param value
	 * @param element
	 */
	public void select(String value,WebElement element)
	{
	
		Select s= new Select(element);
		s.selectByValue(value);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver , WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAnddrop(WebDriver driver, WebElement src,WebElement target)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleclickAction(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void doubleclickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void rightclick(WebDriver driver )
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * 
	 * @param driver
	 * @param Element
	 */
	public void rightclick(WebDriver driver, WebElement Element)
	{
		Actions act= new Actions(driver);
		act.contextClick(Element).perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void enterKey(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	public void enterKeyPress() throws Throwable
	{
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		
	}

	 
	public void enterKeyRelease() throws AWTException
	{
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver ,String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	/**
	 * 
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	/**
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
	 driver.switchTo().alert().accept();	
	}
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
     /**
      * this method will switch to window depending on partial window title
      * @param driver
      */
	public void switchToWindow(WebDriver driver, String screenName, String partialWinTitle)
	{
	   //step 1:-capture all window ids
		
		Set<String> windows = driver.getWindowHandles();
		//step 2:- itearte through the window
		
		Iterator<String> it = windows.iterator();
		//step 3:-check whether their is next window
		
		while(it.hasNext())
		{
			//step 4:- capture current winId
			
			String winId = it.next();
			//step 5:- switch to current window and capture title
			
			String currentTitle = driver.switchTo().window(winId).getTitle();
			//step :-check whether current window title is expected
			
			if(currentTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
		
		/**
		 * this method will take screenshot 
		 * @param driver
		 * @return 
		 * @throws Throwable 
		 */
		public String getscreenshot(WebDriver driver, String screenShotName) throws Throwable
		{
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  File src=ts.getScreenshotAs(OutputType.FILE);
		String  path="./Screenshot/"+screenShotName+".png";
		  File dst=new File(".\\Screenshot\\"+screenShotName+".png");
			FileUtils.copyFile(src, dst);
			return path;
			
		}
		/**
		 * this method will perform random scroll
		 * @param driver
		 */
		public void scrolAction(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 500");
		}
		/**
		 * 
		 * @param driver
		 */
		public void scrollAction1(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy.(0, 500)","");
		}
		/**
		 * 
		 * @param driver
		 */
		public void scrollAction(WebDriver driver, WebElement element)
		{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window(0,"+y+")", element);
		
		}
		public void switchToWindow(WebDriver driver, String Products)
		{
			driver.switchTo().window(Products);
			
		}
}
			
		

	
		
	
		 
         
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	

