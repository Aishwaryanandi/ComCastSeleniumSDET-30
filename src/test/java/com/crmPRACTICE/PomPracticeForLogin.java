package com.crmPRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.objectRepositry.HomePage;
import com.crm.objectRepositry.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PomPracticeForLogin
{
	@Test
	public void pomPractice()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888");
       LoginPage lp=new LoginPage(driver);
		lp.loginToApp("admin", "admin");
		HomePage hp=new HomePage(driver);
		hp.clickOnContactLnk();
		hp.signOutOfApp(driver);
		
		
	}

}
