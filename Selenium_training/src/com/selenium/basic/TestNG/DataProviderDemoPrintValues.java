package com.selenium.basic.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderDemoPrintValues

{
  @Test(dataProvider = "dp")
  public void login(Integer n, String s) {
	  System.out.println(n + "----" + s); 
  }

  @DataProvider
  public Object[][] dp() {               //1 data provider is 1 excel sheet, each object is 1 row and values are colums
    return new Object[][]
    		{
      new Object[] { 1, "a" },        // code to print values from spreadsheet
      new Object[] { 2, "b" },
      new Object[] { 3, "c" }, 
      new Object[] { 4, "d" },
      new Object[] { 5, "e" },
      new Object[] { 6, "f" },
    };
  }
}
