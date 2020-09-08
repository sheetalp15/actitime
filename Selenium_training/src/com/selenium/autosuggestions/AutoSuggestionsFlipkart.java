package com.selenium.autosuggestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionsFlipkart {

	public static void main(String[] args) throws InterruptedException
	{
     System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
     WebDriver driver = new ChromeDriver();
     
     driver.get("http://www.flipkart.com/");
     
     Thread.sleep(3000);
     driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
     
     driver.findElement(By.name("q")).sendKeys("phone");
     
     Thread.sleep(3000);
     
      List<WebElement> autoSuggestions = driver.findElements(By.xpath("//ul/li[@class='1va75j']"));
     
     System.out.println(autoSuggestions.size());
     
     for (WebElement suggesgtion : autoSuggestions) {
    	 System.out.println(suggesgtion.getText());
     }
	}

}
