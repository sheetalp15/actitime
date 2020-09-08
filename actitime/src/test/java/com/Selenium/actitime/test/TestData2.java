package com.Selenium.actitime.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData2 {

	@DataProvider
	  public Object[][] dp() 
	{               
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
	                                              //1 data provider is 1 excel sheet, each object is 1 row and values are colums
	@DataProvider
	  public Object[][] createCustomer()      
	{             
	    return new Object[][]
	    		{
	      new Object[] { "TNG-May03-Customer0001611", "TNG-May03-Customer-Desc0001611" },        // code to print values from spreadsheet
	      new Object[] { "TNG-May03-Customer0001711", "TNG-May03-Customer-Desc0001711" },
	      //new Object[] { "TNG-May03-Customer003", "TNG-May03-Customer-Desc003" },
	      
 	    };
	  }
	@DataProvider
	  public Object[][] createProject()      
	{             
	    return new Object[][]
	    		{
	      new Object[] { "Project-May-1","TNG-May03-Customer1", "TNG-May03-Customer-Desc1" },        // code to print values from spreadsheet
	      new Object[] { "Project-May-2","TNG-May03-Customer2", "TNG-May03-Customer-Desc2" },
	      new Object[] { "Project-May-3","TNG-May03-Customer3", "TNG-May03-Customer-Desc3" },
	      new Object[] { "Project-May-4","TNG-May03-Customer4", "TNG-May03-Customer-Desc4" },
	      new Object[] { "Project-May-5","TNG-May03-Customer5", "TNG-May03-Customer-Desc5" },
	      new Object[] { "Project-May-6","TNG-May03-Customer6", "TNG-May03-Customer-Desc6" },
	      new Object[] { "Project-May-7","TNG-May03-Customer7", "TNG-May03-Customer-Desc7" },
	    };
	  }
	
	
}
