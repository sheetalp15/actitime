package com.selenium.basic.Validation;

import org.openqa.selenium.WebDriver;

import utils.ActiTimeUtils;

public class ValidateElement {

	public static void main(String[] args) 
	{
          WebDriver driver = ActiTimeUtils.getDriver();
          ActiTimeUtils.launchApp("http://formy-project.herokuapp.com/enabled"); 
          ActiTimeUtils.validateAndType("id", "disabledInput", "hello");
          ActiTimeUtils.validateAndType("id", "input", "helloooo");
	}

}
