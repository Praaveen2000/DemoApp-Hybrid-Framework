package com.demoapp.qa.dataProviders;

import org.testng.annotations.DataProvider;

import com.demoapp.qa.utils.Utilities;

public class SearchTestDataProviders {
	
	@DataProvider
	public Object[][] readDataFromValidProductSearch()
	{
		Object[][] data = Utilities.readDataFromExcel("ValidProductSearch");
		
		return data;
	}
	
	@DataProvider
	public Object[][] readDataFromInvalidProductSearch()
	{
		Object[][] data = Utilities.readDataFromExcel("InvalidProductSearch");
		
		return data;
	}

}
