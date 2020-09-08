package com.selenium.basic.TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utils.ActiTimeUtils;

public class JavaScriptExecutorDemo 
{
	@Test
   public void javaScriptTest()
  
  {
	WebDriver driver = ActiTimeUtils.getDriver();
	ActiTimeUtils.launchApp("https://formy-project.herokuapp.com/scroll");
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	//scroll down to 1000th pixel
	// js.executeScript("window.scrollTo(0,1000);");
	
	//scroll to a perticular element            javascript code examples can be found on w3school.com
	js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("name")));
	
	
	
	
}
  
  
  
}
