package com.selenium.assingments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrieFox {

	public static void main(String[] args) throws InterruptedException
	{
		  System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe" );
		    WebDriver driver = new FirefoxDriver();
		    driver.get("https://demo.guru99.com/test/newtours/");
		    
		    driver.findElement(By.linkText("REGISTER")).click();
		    driver.findElement(By.name("firstName")).sendKeys("Sheetal");
		    Thread.sleep(3000);
		    driver.findElement(By.name("lastName")).sendKeys("Patel");
		    Thread.sleep(3000);
		    driver.findElement(By.name("phone")).sendKeys("1234567890");
		    Thread.sleep(3000);
		    driver.findElement(By.name("userName")).sendKeys("planetdays100@gmail.com");
		    Thread.sleep(3000);
		    
		    driver.close();
		    
		    
	}
}
