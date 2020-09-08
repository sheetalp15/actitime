package com.selenium.basics;

import org.openqa.selenium.WebDriver;

import utils.ActiTimeUtils;

public class CreateCustomer {

	public static void main(String[] args)
	{
        System.out.println("Create Customer Test");
        WebDriver driver = ActiTimeUtils.getDriver("chrome");
        
        ActiTimeUtils.launchApp();
        ActiTimeUtils.login("admin", "manager");
        
        ActiTimeUtils.selectModule("tasks");
        ActiTimeUtils.clickonNewCustomerButton();
        ActiTimeUtils.createCustomer("May-Batch-Customer4", "May-Batch-Customer4-Desc");
        
        ActiTimeUtils.logout();
        
	}

}
