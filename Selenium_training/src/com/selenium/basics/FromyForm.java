package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FromyForm {

	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("welcome");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        
        driver.findElement(By.id("first-name")).sendKeys("Sheetal");
        String fname = driver.findElement(By.id("first-name")).getAttribute("value");
        System.out.println(fname);
        
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Patel");
        String lname = driver.findElement(By.id("last-name")).getAttribute("value");
        System.out.println(lname);
        
        driver.findElement(By.xpath("//input[@id='job-title']")).sendKeys("Tester");
        String title = driver.findElement(By.id("job-title")).getAttribute("value");
        System.out.println(title);
        
        driver.findElement(By.xpath("//input[@id='radio-button-2']")).click();
        driver.findElement(By.xpath("//input[@id='checkbox-3']")).click();
        driver.findElement(By.xpath("//select[@id='select-menu']")).click();
        driver.findElement(By.xpath("//option[@contains(text(),'10+']")).click();
        driver.findElement(By.id("datepicker")).click();
        
        WebElement today =driver.findElement(By.xpath("//td[text()='19']"));
        //WEbElement today = driver.findElement(by.xpath(//td[@class='today active day']"));
        Thread.sleep(3000);
        //String today = driver.findElement(by.xpath("//td[@class='today active day']")).getText();
        
        
        driver.findElement(By.xpath("//a[@class='btn btn-lg btn-primary']")).click();
        
        driver.close();
        driver = null;
        
        		
	}

}
