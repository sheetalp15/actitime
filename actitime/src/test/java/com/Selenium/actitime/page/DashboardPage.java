package com.Selenium.actitime.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage {
  
  WebDriver driver = null;

	 @FindBy(xpath = "//div[text()='TASKS']/parent::a")
	 WebElement tasksTab;
	 
	 @FindBy(linkText = "Logout")
	 WebElement logoutLink;
	 
	 public void validateDashboardPage() {
			Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		}
	 
	 public void clickOnTask()
	 {
		 tasksTab.click();
		 Assert.assertEquals(driver.getTitle(), "actiTIME - Task List");
		 
	 }
	 public void logout()
	 {
		 logoutLink.click();
		 Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
		 
	 }
	 
	public DashboardPage(WebDriver driver)
	{
	 PageFactory.initElements(driver, this);	
	 this.driver = driver;
	 
	}
}
