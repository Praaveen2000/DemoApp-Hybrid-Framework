package com.demoapp.qa.testcases;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoapp.qa.baseClass.BaseClass;
import com.demoapp.qa.pageObjects.AccountSuccessPage;
import com.demoapp.qa.pageObjects.HomePage;
import com.demoapp.qa.pageObjects.RegisterPage;
import com.demoapp.qa.utils.Utilities;

public class RegisterTest extends BaseClass{
	
	RegisterPage registerPage;
	
	AccountSuccessPage accountSuccessPage;
	
	@BeforeMethod
	public void setup()
	{
		driver = SetupBrowser(readFromProperties("browserName"));
		
		HomePage homePage = new HomePage(driver);
		
		registerPage = homePage.navigateToRegisterPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void registerAccountWithMandatoryFields()
	{	
		registerPage.enterMandatoryRegisterFields("Tester", "Test", "tester"+Utilities.TimeStamp()+"@gmail.com", "8333412132", "12345", "12345");
		
		accountSuccessPage = registerPage.checkPrivacyAndContinueToAccountSuccessPage();
				
		Assert.assertEquals(accountSuccessPage.getAccountSuccessHeaderText(), "Your Account Has Been Created!", "Account is not registered successfully");	
	}
	
	@Test(priority=2)
	public void registerAccountWithAllFields()
	{	
		registerPage.enterAllRegisterFields("Tester", "Test", "tester"+Utilities.TimeStamp()+"@gmail.com", "8333412132", "12345", "12345");
		
		accountSuccessPage = registerPage.checkPrivacyAndContinueToAccountSuccessPage();
		
		Assert.assertEquals(accountSuccessPage.getAccountSuccessHeaderText(), "Your Account Has Been Created!", "Account is not registered successfully");
	}
	
	@Test(priority=3)
	public void registerAccountWithExistingEmail()
	{	
		registerPage.enterAllRegisterFields("Tester", "Test", "praveenkaverimohan@gmail.com", "8333412132", "12345", "12345");
		
		registerPage.checkPrivacyAndContinueToAccountSuccessPage();
		
		Assert.assertEquals(registerPage.getWarnMsgText(), "Warning: E-Mail Address is already registered!","Existing Email Warning not dipslayed");
	}
	
	@Test(priority=4)
	public void registerAccountWithoutFillingAnyFields()
	{	
		registerPage.clickOnContinue();
		
		Assert.assertTrue(registerPage.getWarnMsgText().equalsIgnoreCase("Warning: You must agree to the Privacy Policy!"),"Privacy Policy Warning not displayed");
		
		Assert.assertEquals(registerPage.getFirstNameWarnMsgText(), "First Name must be between 1 and 32 characters!","First Name Warning not displayed");
		
		Assert.assertEquals(registerPage.getlastNameWarnMsgText(), "Last Name must be between 1 and 32 characters!","Last Name Warning not displayed");
		
		Assert.assertEquals(registerPage.getEmailWarnMsgText(), "E-Mail Address does not appear to be valid!","Email Warning not displayed");
		
		Assert.assertEquals(registerPage.getTelephoneWarnMsgText(), "Telephone must be between 3 and 32 characters!","Phone Warning not displayed");
		
		Assert.assertEquals(registerPage.getPassWordWarnMsgText(), "Password must be between 4 and 20 characters!","Password Warning not displayed");
	}

}
