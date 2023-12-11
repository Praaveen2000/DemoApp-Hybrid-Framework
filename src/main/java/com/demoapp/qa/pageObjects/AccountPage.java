package com.demoapp.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	@FindBy(linkText="Change your password")
	private WebElement editYourAccountInfo;
	
	public AccountPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);  // this or AccountPage.class
	}
	
	public boolean getDisplayStatusOfAccountInfoHeader()
	{
		return editYourAccountInfo.isDisplayed();
	}

}
