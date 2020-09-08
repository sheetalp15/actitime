package com.selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	public static void main(String[] args) 
	{
       System.out.println("welcome");
       System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       
	}

}
