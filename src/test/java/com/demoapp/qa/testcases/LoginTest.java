package com.demoapp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.demoapp.qa.baseClass.BaseClass;
import com.demoapp.qa.dataProviders.LoginTestDataProviders;
import com.demoapp.qa.pageObjects.AccountPage;
import com.demoapp.qa.pageObjects.HomePage;
import com.demoapp.qa.pageObjects.LoginPage;

public class LoginTest extends BaseClass {
	
	LoginPage loginPage; 

	@BeforeMethod
	public void setup()
	{
		driver = SetupBrowser(readFromProperties("browserName"));
		
		HomePage homePage = new HomePage(driver);
		
		loginPage = homePage.navigateToLoginPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1,dataProvider="readValidDataFromExcel", dataProviderClass=LoginTestDataProviders.class)
	public void loginWithValidCredentials(String email, String password)
	{
		AccountPage accountPage = loginPage.enterLoginFields(email, password);
		
		Assert.assertTrue(accountPage.getDisplayStatusOfAccountInfoHeader(), "Login is not successful");
	}
	
	@Test(priority=2, dataProvider="readInvalidDataFromExcel", dataProviderClass=LoginTestDataProviders.class)
	public void loginWithInvalidCredentials(String email, String password, String warnMsg)
	{	
		loginPage.enterLoginFields(email, password);
		
		Assert.assertEquals(loginPage.getWarnMsgText(), warnMsg, "Invalid login warning message is not dispayed");
		
	}
	
	@Test(priority=3, dataProvider ="readInvalidEmailAndValidPassFromExcel", dataProviderClass=LoginTestDataProviders.class)
	public void loginWithInvalidEmailAndValidPass(String email, String password, String warnMsg)
	{	
		loginPage.enterLoginFields(email, password);
		
		Assert.assertEquals(loginPage.getWarnMsgText(), warnMsg, "Invalid login warning message is not dispayed");
	}



    @Test(priority=4, dataProvider="readValidEmailAndInvalidPassFromExcel", dataProviderClass=LoginTestDataProviders.class)
    public void loginWithValidEmailAndInvalidPass(String email, String password, String warnMsg)
	{	
    	loginPage.enterLoginFields(email, password);
		
		Assert.assertEquals(loginPage.getWarnMsgText(), warnMsg, "Invalid login warning message is not dispayed");
		
   }
    
    @Test(priority=5, dataProvider="readBlankDataFromExcel", dataProviderClass=LoginTestDataProviders.class)
    public void loginWithoutCredentials(String warnMsg)
	{	
    	loginPage.clickOnLogin();
		
		Assert.assertEquals(loginPage.getWarnMsgText(), warnMsg, "Invalid login warning message is not dispayed");
   }
    
   

}
