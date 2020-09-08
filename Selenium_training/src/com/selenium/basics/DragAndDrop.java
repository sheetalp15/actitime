package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.ActiTimeUtils;

public class DragAndDrop {

	public static void main(String[] args) 
	{
         WebDriver driver = ActiTimeUtils.getDriver();
         
         ActiTimeUtils.launchApp("https://jqueryui.com/droppable/");
         driver.switchTo().frame(0);
         Actions act = new Actions(driver);
         WebElement src = driver.findElement(By.id("draggable"));
         WebElement dest = driver.findElement(By.id("droppable"));
         System.out.println(dest.getText());
         act.dragAndDrop(src, dest).perform();
         System.out.println(dest.getText());
	}

} 
