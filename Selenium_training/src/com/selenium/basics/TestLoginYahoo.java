package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginYahoo {

	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("welcome");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.yahoo.com/");
        
        driver.findElement(By.id("login-username")).sendKeys("");   //add user name
        Thread.sleep(3000);	
        driver.findElement(By.xpath("//input[@class='orko-button-primary orko-button challenge-button']")).click();
        
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//input[@class='password']")).sendKeys("");   // add password
        Thread.sleep(3000);
        driver.findElement(By.id("login-signin")).click();
        
        driver.findElement(By.id("header-profile-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='C($c-fuji-grey-1) D(b) E11 Td(n)']")).click();
        
        driver.close();
        driver = null;
        
        	
        		
	}

}
