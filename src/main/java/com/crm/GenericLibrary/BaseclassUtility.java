
package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.crm.objectRepositry.HomePage;
import com.crm.objectRepositry.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class BaseclassUtility 
{
	public PropertyFileUtility pLib=new PropertyFileUtility();
	public DatabaseUtility dLib=new DatabaseUtility();
	public ExcelFileUtility eLib=new ExcelFileUtility();
	public WebdriverUtility wLib=new WebdriverUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups="smokeSuite")
	public void connectDatabase()
	{
		Reporter.log(" db connection",true); 
		
	}
	
	@BeforeClass(groups="smokeSuite")
	//@BeforeTest
	//@Parameters("browser")
	public void launchTheBrowser() throws Throwable
	{
		String BROWSER = pLib.getDataFromPropertyFile("browser");
		String URL = pLib.getDataFromPropertyFile("url");
		
		WebDriverManager.firefoxdriver().setup();
		if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		sdriver=driver;
		wLib.maximizewindow(driver);
		wLib.waitforPageLoad(driver);
		driver.get(URL);
		Reporter.log("Browser launched success",true);
		
	}
	
	@BeforeMethod(groups="smokeSuite")
	public void login() throws Throwable
	{
		String USERNAME = pLib.getDataFromPropertyFile("username");
		String PASSWORD = pLib.getDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("login sucess",true);
		
	}
	
	@AfterMethod(groups="smokeSuite")
	public void logout()
	{
		HomePage hp=new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("logout success",true);
	}
	
	@AfterClass(groups="smokeSuite")
	//@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("Browser closed success",true);
	}
	
	@AfterSuite(groups="smokeSuite")
	public void closeDb()
	{
		Reporter.log("database connection is closed",true);
	}
	
	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	


