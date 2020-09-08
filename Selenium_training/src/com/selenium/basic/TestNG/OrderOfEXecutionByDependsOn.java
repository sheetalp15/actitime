package com.selenium.basic.TestNG;

import org.testng.annotations.Test;

public class OrderOfEXecutionByDependsOn {

@Test
public void lauchTest()
{
	  System.out.println("lauchTest");
}

@Test(dependsOnMethods = "lauchTest")
public void loginTest()
{
	  System.out.println("loginTest");
}

@Test(dependsOnMethods = {"lauchTest", "loginTest"})
public void createCustomerTest()
{
	  System.out.println("createCustomerTest");
}

@Test(dependsOnMethods = "createCustomerTest")
public void logoutTest()
{
	  System.out.println("logoutTest");
}
}