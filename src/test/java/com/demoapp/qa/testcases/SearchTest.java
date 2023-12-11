package com.demoapp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoapp.qa.baseClass.BaseClass;
import com.demoapp.qa.dataProviders.SearchTestDataProviders;
import com.demoapp.qa.pageObjects.HomePage;
import com.demoapp.qa.pageObjects.SearchResultsPage;

public class SearchTest extends BaseClass{
	
	SearchResultsPage resultsPage;
	
	HomePage homePage;
	
	@BeforeMethod
	public void setup()
	{
		driver = SetupBrowser(readFromProperties("browserName"));

		homePage = new HomePage(driver);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1, dataProvider="readDataFromValidProductSearch", dataProviderClass=SearchTestDataProviders.class)
	public void searchWithValidProduct(String validProduct)
	{	
		resultsPage = homePage.searchForAProduct(validProduct);
		
		Assert.assertTrue(resultsPage.getStatusOfValidHPLinkText());
	}
	
	@Test(priority=2, dataProvider="readDataFromInvalidProductSearch", dataProviderClass=SearchTestDataProviders.class)
	public void searchWithInValidProduct(String invalidProduct)
	{
		resultsPage = homePage.searchForAProduct(invalidProduct);
		
		Assert.assertTrue(resultsPage.getInvalidResultWarnMsgText().equalsIgnoreCase("There s no product that matches the search criteria."), "Warning message not displayed");
	}
	
	@Test(priority=3, dependsOnMethods="searchWithInValidProduct")
	public void searchWithBlankValue()
	{
		resultsPage = homePage.clickOnSearch();
		
		Assert.assertTrue(resultsPage.getInvalidResultWarnMsgText().equalsIgnoreCase("There is no product that matches the search criteria."), "Warning message not displayed");
	}

}
