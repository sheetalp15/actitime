package com.selenium.basic.TestNG;

import org.testng.annotations.Test;

public class OrderOfExecutionByPriority 
{
  @Test(priority = 1)
  public void lauchTest()
  {
	  System.out.println("LaunchTest");
  }
  @Test(priority = 2)
  public void loginTest()
  {
	  System.out.println("LoginTest");
  }
  @Test(priority = 3)
  public void createCustomerTest()
  {
	  System.out.println("CreateCustomerTest");
  }
  @Test(priority = 4)
  public void logoutTest()
  {
	  System.out.println("LogoutTest");
  }
}