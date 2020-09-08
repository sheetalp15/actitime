package com.Selenium.actitime.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringType;


public class DriverUtils {
	
	public static WebDriver driver = null;
	
	public static WebDriver getDriver()
	{
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
	}
	
	public static WebDriver getDriver(String type)
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
	
	/**
	 * 
	 * @param type - id,name,classname,tagname,linktext,partiallinktext,see,xpath
	 * @param value - value corresponding to type
	 * @return WebElement
	 */
	
	public static WebElement getElement(String type,String value)
	{
		WebElement element = null;
		System.out.println("finding element using " +type + " and " + value);
		
		switch (type.toLowerCase())
		{
		case "id":
			element = driver.findElement(By.id(value));
			break;

		case "name":
			element = driver.findElement(By.name(value));
			break;
			
		case "classname":
			element = driver.findElement(By.className(value));
			break;
			
		case "tagname":
			element = driver.findElement(By.tagName(value));
			break;
			
		case "linktext":
			element = driver.findElement(By.linkText(value));
			break;
			
		case "partiallinktext":
			element = driver.findElement(By.partialLinkText(value));
			break;
			
		case "css":
			element = driver.findElement(By.cssSelector(value));
			break;
			
		case "xpath":
			element = driver.findElement(By.xpath(value));
			break;
			
		default:
			System.out.println("Please check your type it should be a valid type");
			break;
		}
		return element;
		
	}
	
	public static void type(String type, String value, String text)
	{
		System.out.println("Performing find element and type " + text);
		//WebElement element = getElement (type, value);
		//element.sendkeys(text);
		getElement(type, value).sendKeys(text);
		}
	
	public static void validateAndType(String type, String value, String text)
	{
		WebElement ele = getElement(type, value);
		if (ele.isDisplayed()&&ele.isEnabled())
		{
		 ele.sendKeys(text);	
		}
		else
		{
			System.out.println("Element is not in a state to perform type operation");
		}
	}
	
	public static void click(String type,String value)
	{
		System.out.println("Performming Click operation");
		getElement(type, value).click();
	}
	
	
	public static void validateTitle(String expectedTitle)
	{
		String actualTitle = driver.getTitle();
		
		org.testng.Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println(expectedTitle + " is valid");
	
	
		// if you want to stop the execution whenever there is a failure use assert. or can use if else
		/*if (actualTitle.equals(expectedTitle)) {
			System.out.println("title Matched" + actualTitle);
		}
		else
		{
			System.out.println("title Mismatched" + actualTitle);
		}	*/
	}
	
	public static void selectCheckBox(String type, String value)
	{
        WebElement ele = getElement(type, value);
        
        if (!ele.isSelected()) 
        {
			ele.click();
		}
        else
        {
        	System.out.println("Check box is already selected so not performing click");
        }
	}
	
	public static void unselectCheckBox(String type, String value)
	{
        WebElement ele = getElement(type, value);
        
        if (ele.isSelected()) 
        {
			ele.click();
		}
        else
        {
        	System.out.println("Check box is not selected so not performing click");
        }
	}

}
