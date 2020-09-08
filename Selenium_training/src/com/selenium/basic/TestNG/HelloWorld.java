package com.selenium.basic.TestNG;

import org.testng.annotations.Test;

public class HelloWorld 
{
  @Test
  public void lauchTest()
  {
	  System.out.println("LaunchTest");
  }
  @Test
  public void loginTest()
  {
	  System.out.println("LoginTest");
  }
  @Test
  public void createCustomerTest()
  {
	  System.out.println("CreateCustomerTest");
  }
  @Test
  public void logoutTest()
  {
	  System.out.println("LogoutTest");
  }
}