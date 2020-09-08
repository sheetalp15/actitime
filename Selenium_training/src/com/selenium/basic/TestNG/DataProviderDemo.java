package com.selenium.basic.TestNG;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class DataProviderDemo

{
	
	@Parameters("tester") // cannot run alone if you have parameter, so execute/run xml only
	@BeforeMethod
	public void testerName(String name)           //  pass variable name 
	{
		
		System.out.println("Executed by --" + name);
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("----------------------------------");
	}
	
  @Test(dataProvider = "dp", dataProviderClass = TestData.class)    //to specify the location of the dataprovider dp class, 
  public void login(Integer n, String s) {
	  System.out.println(n + "----" + s); 
  }

  
}
