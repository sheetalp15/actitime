package com.selenium.basic.TestNG;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sun.tools.internal.xjc.Driver;

import utils.ActiTimeUtils;

public class CreateCustomerTestUsingTestnG {
	
	/*WebDriver driver = null;
	@BeforeClass
	public void createDriver()             
	{
		driver = ActiTimeUtils.getDriver("chrome");	
	}
	
	@AfterClass
	public void closeDriver()
	{
		ActiTimeUtils.driver.close();
	}
	*/
	
	@Parameters({"un", "pwd"})
	@BeforeMethod
	public void launch(String username, String password)
		{
		ActiTimeUtils.getDriver("chrome");
		ActiTimeUtils.launchApp();
		ActiTimeUtils.login(username, password);
		 
		
	}
	
	@AfterMethod
	public void logout(ITestResult result) throws IOException 
	{
		ActiTimeUtils.captureScreenshot(result);
		ActiTimeUtils.logout();
		ActiTimeUtils.driver.close();
	}
	
  @Test(dataProviderClass = TestData.class , dataProvider = "createCustomer")
  public void createCustomerTest(String name, String desc) 
  {
	  ActiTimeUtils.selectModule("tasks");
	    ActiTimeUtils.clickonNewCustomerButton();
	    ActiTimeUtils.createCustomer(name,desc);
	    
  }
  
  @Test
  public void createProjectTest() 
  
  {
  }
}
