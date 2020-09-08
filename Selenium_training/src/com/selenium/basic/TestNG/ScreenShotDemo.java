package com.selenium.basic.TestNG;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utils.ActiTimeUtils;

public class ScreenShotDemo {

	  
	  @AfterMethod
		public void logout(ITestResult result)
		{
		  System.out.println("testing result");
		  if (result.getStatus() == ITestResult.FAILURE)
		  {
			
		
			try {
				System.out.println("taking screenshot");
				ActiTimeUtils.captureScreenshot(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
			
	  else {
		  ActiTimeUtils.logout();
		
	  }
		}
		
		@Test
		public void validLogin()
		{
			ActiTimeUtils.getDriver("chrome");
			ActiTimeUtils.launchApp();
			ActiTimeUtils.login("admin", "manager");
		}
		
		@Test
		public void invalidLogin()
		{
			ActiTimeUtils.getDriver("chrome");
			ActiTimeUtils.launchApp();
			ActiTimeUtils.login("admin1", "manager1");
		}
		
		
	  
  }

