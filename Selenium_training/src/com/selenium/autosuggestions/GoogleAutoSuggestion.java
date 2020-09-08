package com.selenium.autosuggestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleAutoSuggestion {

	public static void main(String[] args) 
	{
         System.out.println("--- Welcome to Google Auto Suggestions ---");
         System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         
         driver.get("http://www.google.com/");
         
         driver.findElement(By.name("q")).sendKeys("intellipaat");
         
          List<WebElement> autoSuggestions = driver.findElements(By.xpath("//ul/li//div[@class='sbtc']"));   //java.utils.list<WebElemnt> then,remover unused import,then remove java.utils from start of the line, then import list java utils when suggest highlights 
         
         System.out.println(autoSuggestions.size());
         
         for(WebElement suggestion : autoSuggestions) {
        	 System.out.println(suggestion.getText());
        	 
         }
	}

}
