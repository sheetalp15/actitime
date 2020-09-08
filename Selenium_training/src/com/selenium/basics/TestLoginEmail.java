package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginEmail {

	public static void main(String[] args) throws InterruptedException
	{
		 System.out.println("welcome");
	        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://accounts.google.com/");
	        
	        driver.findElement(By.id("identifierId")).sendKeys("");
	        driver.findElement(By.id("identifierNext")).click();
	        
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("");
	        driver.findElement(By.id("passwordNext")).click();
	        
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//img[@class='gb_Ia gbii']")).click();
	        driver.findElement(By.id("gb_71")).click();
	        
	        driver.close();
	        driver = null;
	        
	}

}
