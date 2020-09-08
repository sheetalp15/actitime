package com.Selenium.actitime.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;


public class Helper2 extends HelperUtils
{
 
	public static void selectModule(String name)
	{
		System.out.println("Entering to " + name  + " module ");
		//Dynamic Xpath  -> constructing xpath at the run time
						//div[text()='TASKS']/parent::a
		click("xpath", "//div[text()='" + name.toUpperCase() + "']/parent::a");
	}
		

	public static void click(String type,String value)
	{
		System.out.println("Performming Click operation");
		getElement(type, value).click();
	}
	public static void clickonNewCustomerButton() throws InterruptedException
	{
		click("xpath", "//div[@class='addNewContainer']//div[@class='addNewButton']"); 
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 10 );
		wait.until(ExpectedConditions.visibilityOf(HelperUtils.getElement("xpath", "//div[@class='dropdownContainer addNewMenu']")));
		click("xpath", "//div[contains(text(),'New Customer')]");
	}
	

	public static void createCustomer(String customerName, String customerDesc)
	{
		type("id", "customerLightBox_nameField", customerName);
		type("id", "customerLightBox_descriptionField", customerDesc);
		click("id", "customerLightBox_commitBtn");
	WebDriverWait appearwait = new WebDriverWait(driver, 10);
	WebElement toastEle = appearwait.until(ExpectedConditions.visibilityOf(Helper2.getElement("xpath", "//div[@class='toasts']")));
	
	System.out.println("Toast Message -" + toastEle.getText());
	
	System.out.println("waiting for toast to disappear");
	
	WebDriverWait disappearWait = new WebDriverWait(driver, 10);
	disappearWait.until(ExpectedConditions.invisibilityOf(Helper2.getElement("xpath", "//div[@class='toasts']")));
			
	}   
	
	public static String dateAndTime()
	{
		return new Date().toString().replace(" ", "_").replace(":", "_");  // replace space and colon with underscore for dates
	}
	
	public static void captureScreenshot(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("ss/ss_"+dateAndTime()+ ".png"));   //download jar files for fileutils mvnrepository.com----ss means screenshot

		}
	}
	
	public static void searchCustomerToDelete(String customerName) throws InterruptedException
	{
		type("xpath", "//div[@class='customersProjectsPanel']//input", customerName);
		Thread.sleep(2000);
		Actions act = new Actions(driver);
//		act.moveToElement(getElement("xpath", "//div[@class='filteredContainer']//div[@class='itemsContainer']//span[text()='"+ customerName+"']")).perform();
		act.moveToElement(getElement("xpath", "//div[@class='filteredContainer']//div[@class='itemsContainer']//div[@class='node customerNode notSelected']")).perform();
		
//		act.click(getElement("xpath", "//div[@class='filteredContainer']//div[@class='itemsContainer']//span[text()='" +customerName+ "']/parent::div/following-sibling::div")).perform();
		act.click(getElement("xpath", "//div[@class='filteredContainer']//div[@class='itemsContainer']//div[@class='node customerNode notSelected']/div[@class='editButton available']")).perform();
		
		Thread.sleep(2000);
	
	}
	
	public static void deleteCustomer()
	{
		click("xpath", "//div[@class='customerNamePlaceHolder']/following-sibling::div");
		click("xpath","//div[@class='customerNamePlaceHolder']/parent::div/following-sibling::div[@class='dropdownContainer actionsMenu']//div[text()='Delete']");
		click("id","customerPanel_deleteConfirm_submitTitle");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement successMsg = wait.until(ExpectedConditions.visibilityOf(getElement("xpath", "//div[@class='toasts']")));
		System.out.println("Success message is appeared "  + successMsg.getText());
		WebDriverWait waitDisappear = new WebDriverWait(driver, 10);
		waitDisappear.until(ExpectedConditions.invisibilityOf(getElement("xpath", "//div[@class='toasts']")));
		System.out.println("Toast message disappeared!!!");
		
		
		
	}
}