package com.demoapp.qa.dataProviders;

import org.testng.annotations.DataProvider;

import com.demoapp.qa.utils.Utilities;

public class LoginTestDataProviders {
	
	@DataProvider
	public Object[][] readValidDataFromExcel()
	{
	    Object[][] data = Utilities.readDataFromExcel("ValidLogin");
	    	
	    return data;
	}
	
	@DataProvider
	public Object[][] readInvalidDataFromExcel()
	{
	    Object[][] data = Utilities.readDataFromExcel("InvalidLogin");
	    	
	    return data;
	}
	
	@DataProvider
	public Object[][] readInvalidEmailAndValidPassFromExcel()
	{
	    Object[][] data = Utilities.readDataFromExcel("InvalidEmailAndValidPassLogin");
	    	
	    return data;
	}
	
	@DataProvider
	public Object[][] readValidEmailAndInvalidPassFromExcel()
	{
	    Object[][] data = Utilities.readDataFromExcel("ValidEmailAndInvalidPassLogin");
	    	
	    return data;
	}
	
	@DataProvider
	public Object[][] readBlankDataFromExcel()
	{
	    Object[][] data = Utilities.readDataFromExcel("BlankCredentialsLogin");
	    	
	    return data;
	}

}
