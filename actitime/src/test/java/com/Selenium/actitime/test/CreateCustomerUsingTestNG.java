package com.Selenium.actitime.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Selenium.actitime.util.ActiTimeUtils;

public class CreateCustomerUsingTestNG {
	WebDriver driver = null;
	@BeforeClass
	public void launchAndLogin() {
		ActiTimeUtils.getDriver();
		ActiTimeUtils.launchApp();
		ActiTimeUtils.login("admin", "manager");
		
	}
	
  @Test(priority = 1, dataProviderClass = TestData2.class, dataProvider = "createCustomer")
  public void createCustomer(String cn, String cd) {
	  ActiTimeUtils.selectModule("tasks");
	  ActiTimeUtils.clickonNewCustomerButton();
	  ActiTimeUtils.createCustomer(cn, cd);
  }
  
  @Test(priority = 2,dataProviderClass = TestData2.class, dataProvider  = "createCustomer")
  public void DeleteCustomer(String cn, String cd) throws InterruptedException {
	  
	  ActiTimeUtils.searchCustomerToDelete(cn);
	  //Thread.sleep(3000);
	  ActiTimeUtils.deleteCustomer();
	  ActiTimeUtils.getElement("xpath", "//div[@class='customersProjectsPanel']//input" ).clear();
	  
  }
  
  @AfterClass
  public void logoutApp() {
	  ActiTimeUtils.logout();
	  
  }
  
  //@AfterMethod
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
