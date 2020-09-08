package com.Selenium.actitime.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Helper {
 
  WebDriver driver = null;
  
	public  WebDriver getDriver(String type)
	{
		switch (type.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case"ff":
			System.setProperty("webdriver.grcko.driver", "drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "drivers//msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Please contact your framework Developer");
			break;
		} 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;

	} 
	
}

