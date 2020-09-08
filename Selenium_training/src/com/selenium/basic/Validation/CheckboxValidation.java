package com.selenium.basic.Validation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ActiTimeUtils;

public class CheckboxValidation {

	public static void main(String[] args) 
	{
          WebDriver driver = ActiTimeUtils.getDriver();
          ActiTimeUtils.launchApp("http://formy-project.herokuapp.com/form");
          
          ActiTimeUtils.selectCheckBox("id", "checkbox-1");
          ActiTimeUtils.selectCheckBox("id", "checkbox-2");
          ActiTimeUtils.selectCheckBox("id", "checkbox-3");
          ActiTimeUtils.unselectCheckBox("id", "checkbox-1");
          ActiTimeUtils.selectCheckBox("id", "checkbox-2");
          ActiTimeUtils.unselectCheckBox("id", "checkbox-3");
          
	}

}
