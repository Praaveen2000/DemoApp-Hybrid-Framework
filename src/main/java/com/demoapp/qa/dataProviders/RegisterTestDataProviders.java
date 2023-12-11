package com.demoapp.qa.dataProviders;

import org.testng.annotations.DataProvider;

import com.demoapp.qa.utils.Utilities;

public class RegisterTestDataProviders {
	
	@DataProvider
	public Object[][] readDataFromMandateFieldsReg()
	{
		Object [][] data = Utilities.readDataFromExcel("MandateFieldsReg");
		
		return data;
	}
	
	@DataProvider
	public Object[][] readDataFromAllFieldsReg()
	{
		Object [][] data = Utilities.readDataFromExcel("AllFieldsReg");
		
		return data;
	}
	
	@DataProvider
	public Object[][] readDataFromExistingEmailReg()
	{
		Object [][] data = Utilities.readDataFromExcel("ExistingEmailReg");
		
		return data;
	}

}
