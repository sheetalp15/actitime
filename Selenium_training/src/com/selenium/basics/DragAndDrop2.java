package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.ActiTimeUtils;

public class DragAndDrop2 {

	public static void main(String[] args)
	{
       WebDriver driver = ActiTimeUtils.getDriver();
       
       ActiTimeUtils.launchApp("http://formy-project.herokuapp.com/dragdrop");
       //driver.switchTo().frame(0);  only use if frame are present
       Actions act = new Actions(driver);
       WebElement src = driver.findElement(By.id("image"));
       WebElement dest = driver.findElement(By.id("box"));
       act.dragAndDrop(src, dest).perform();
       System.out.println(dest.getText());
       
       driver.close();
       
	}

}
