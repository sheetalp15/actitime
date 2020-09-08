package com.Selenium.actitime.page;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	WebDriver driver = null;
	//Variables
	
	@FindBy(id = "username")
	WebElement usernameTextBox;
	
	@FindBy(name = "pwd")
	WebElement passwordTextBox;
	
	@FindBy(id = "loginButton")
	WebElement loginButton;
	
	
	public void enterUserName(String username)
	{
		usernameTextBox.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		passwordTextBox.sendKeys(password);
	}
	
	public void clickonLogin()
	{
		loginButton.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		
	}
	
	
	
	
	//Methods
	public void login(String un,String pwd)
	{
		usernameTextBox.sendKeys(un);
		passwordTextBox.sendKeys(pwd);
		loginButton.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
	}
	
	
	//constructors
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
}