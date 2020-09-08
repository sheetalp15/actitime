package com.selenium.basics;

import org.openqa.selenium.WebDriver;

import utils.ActiTimeUtils;
import utils.ExcelUtils;
import utils.FileReaderUtils;

public class CreateCustomerUsingExternalData {

	public static void main(String[] args)
	{
       String browser = FileReaderUtils.getPropertyValue("browser");
       String username = FileReaderUtils.getPropertyValue("username");
       String password = FileReaderUtils.getPropertyValue("password");
       int rowCount;
       String sheetName = "customerdata";       // use sheet name
       String customername = null, customerdesc = null;
       System.out.println("Create Customer Test");
       WebDriver driver = ActiTimeUtils.getDriver(browser);
       
       ActiTimeUtils.launchApp();
       ActiTimeUtils.login(username, password);
       ActiTimeUtils.selectModule("task");
       
       rowCount = ExcelUtils.getRowCount(sheetName);
       for (int i = 1; i < rowCount; i++) 
       {
    	   customername = ExcelUtils.getCellData(sheetName, i, 0);
    	   customerdesc = ExcelUtils.getCellData(sheetName, i, 1);
    	   
    	   ActiTimeUtils.clickonNewCustomerButton();
    	   ActiTimeUtils.createCustomer(customername, customerdesc);
       }	   
       
	}

}
