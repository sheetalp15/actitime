package utils;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;

import org.apache.commons.io.FileUtils;

public class ActiTimeUtils extends DriverUtils
{
   
	//private static String type;
	public static void launchApp(String url)
	{
       driver.get(url);

	}
	//function overloading, if the user does not provide a url by default the provided ur will be launched
	public static void launchApp()
	{
		driver.get("http://localhost/login.do");         //create url field
		validateTitle("actiTIME - Login"); //use this to validate the title of the webpage ( to ensure the page displayes is login page)
	}
	
	public static void login(String un,String pwd)
	{
		ActiTimeUtils.type("id", "username", un);  // webElement id = username, un is variable
		ActiTimeUtils.type("name", "pwd", pwd);
		ActiTimeUtils.click("id", "loginButton");
	
		try
		{
			Thread.sleep(5000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		validateTitle("actiTIME - Enter Time-Track"); // this will validate successful login by making sure the page is Enter time track upon successful login
	}
	public static void logout()
	{
		System.out.println("Clicking on Logout");
		ActiTimeUtils.click("linktext",	"Logout");
		validateTitle("actiTIME - Login");
	}
	public static void selectModule(String name)
	{
		System.out.println("Entering to " + name  + " module ");
		//Dynamic Xpath  -> constructing xpath at the run time
						//div[text()='TASKS']/parent::a
		click("xpath", "//div[text()='" + name.toUpperCase() + "']/parent::a");
		
		
	}
		public static void clickonNewCustomerButton()
		{
			ActiTimeUtils.click("xpath", "//div[@class='addNewContainer']");             
			WebDriverWait wait = new WebDriverWait(driver, 10 );
			wait.until(ExpectedConditions.visibilityOf(ActiTimeUtils.getElement("xpath", "//div[@class='dropdownContainer addNewMenu']")));
			ActiTimeUtils.click("xpath", "//div[contains(text(),'New Customer')]");
		}
		public static void createCustomer(String customerName, String customerDesc)
		{
			type("id", "customerLightBox_nameField", customerName);
			type("id", "customerLightBox_descriptionField", customerDesc);
			click("id", "customerLightBox_commitBtn");
		WebDriverWait appearwait = new WebDriverWait(driver, 10);
		WebElement toastEle = appearwait.until(ExpectedConditions.visibilityOf(ActiTimeUtils.getElement("xpath", "//div[@class='toasts']")));
		
		System.out.println("Toast Message -" + toastEle.getText());
		
		System.out.println("waiting for toast to disappear");
		
		WebDriverWait disappearWait = new WebDriverWait(driver, 10);
		disappearWait.until(ExpectedConditions.invisibilityOf(ActiTimeUtils.getElement("xpath", "//div[@class='toasts']")));
				
		}   
		/*public static void selectCustomer(String cutomerName) {
		//type ("xpath",input[contains(text(),'Start typing name ...']", customerName);
		click("xpath", "//div[contains(text(),'cust1')]");
		click("xpath", "//div[@class='node customerNode selected']//div[@class='editButton available']");
		
		}*/
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
//			act.moveToElement(getElement("xpath", "//div[@class='filteredContainer']//div[@class='itemsContainer']//span[text()='"+ customerName+"']")).perform();
			act.moveToElement(getElement("xpath", "//div[@class='filteredContainer']//div[@class='itemsContainer']//div[@class='node customerNode notSelected']")).perform();
			
//			act.click(getElement("xpath", "//div[@class='filteredContainer']//div[@class='itemsContainer']//span[text()='" +customerName+ "']/parent::div/following-sibling::div")).perform();
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
	
	

