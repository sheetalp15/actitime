package com.Selenium.actitime.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Selenium.actitime.page.DashboardPage;
import com.Selenium.actitime.page.LoginPage;
import com.Selenium.actitime.util.Helper;









	public class LoginTest {
	
		WebDriver driver = null;
		LoginPage lp = null;
		DashboardPage dp  = null;
		Helper hp = null;
		
		
		
		@BeforeTest
		public void setup()
		{
			hp = new Helper();
			driver = hp.getDriver("chrome");
			lp = new LoginPage(driver);
			dp =  new DashboardPage(driver);
		}
		
		@BeforeMethod
		public void launch()
		{
			driver.get("http://localhost/login.do");
		}
		
		@Test(priority = 1)
		public void validLoginTest()
		{
			lp.login("admin", "manager");
			dp.clickOnTask();
			dp.logout();
		}
		
		//@Test(priority = 2)
		public void inValidLoginTest()
		{
			lp.login("admin1", "manager1");
			dp.clickOnTask();
			dp.logout();
		}

		
		@AfterMethod
		public void checkStatus(ITestResult result) throws IOException
		{
			if(result.getStatus() ==ITestResult.FAILURE)
			{
				TakesScreenshot ts = (TakesScreenshot)driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("ss\\sample.png"));
			}
		}
}