package com.Selenium.actitime.test;

import org.testng.annotations.Test;

import com.Selenium.actitime.util.Helper2;

public class DeleteCustomer {
	@Test(priority = 4,dataProviderClass = TestData2.class, dataProvider  = "createCustomer")
	  public void DeleteCustomer(String cn, String dc) throws InterruptedException {
		  
		  Helper2.searchCustomerToDelete(cn);
		  Helper2.deleteCustomer();
		  Helper2.getElement("xpath", "//div[@class='customersProjectsPanel']//input" ).clear();
		 
	  }
}
