package com.selenium.basic.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.ActiTimeUtils;

public class CreateCustomerUsingTestNG {
	
	@BeforeClass
	public void launchAndLogin() {
		ActiTimeUtils.getDriver();
		ActiTimeUtils.launchApp();
		ActiTimeUtils.login("admin", "manager");
		
	}
	
  @Test(priority = 1, dataProviderClass = TestData.class, dataProvider = "createCustomer")
  public void createCustomer(String cn, String cd) {
	  ActiTimeUtils.selectModule("tasks");
	  ActiTimeUtils.clickonNewCustomerButton();
	  ActiTimeUtils.createCustomer(cn, cd);
  }
  
  @Test(priority = 2,dataProviderClass = TestData.class, dataProvider  = "createCustomer")
  public void DeleteCustomer(String cn, String dc) throws InterruptedException {
	  
	  ActiTimeUtils.searchCustomerToDelete(cn);
	  ActiTimeUtils.deleteCustomer();
	  ActiTimeUtils.getElement("xpath", "//div[@class='customersProjectsPanel']//input" ).clear();
	  
  }
  
  @AfterClass
  public void logoutApp() {
	  ActiTimeUtils.logout();
	  
  }
  
}
