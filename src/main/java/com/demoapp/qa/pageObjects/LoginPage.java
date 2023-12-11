package com.demoapp.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;
	
	@FindBy(css="div[class*='alert']")
	private WebElement invalidEmailOrPasswarnMsg;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this); // this or LoginPage.class
	}
	
	public AccountPage enterLoginFields(String email, String password)
	{
		emailField.sendKeys(email);
		
		passwordField.sendKeys(password);
		
		loginBtn.click();
		
		return new AccountPage(driver);
		
		
	}
	
	public void enterEmail(String email)
	{
		emailField.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public AccountPage clickOnLogin()
	{
		loginBtn.click();
		
		return new AccountPage(driver);
	}
	
	public String getWarnMsgText()
	{
		return invalidEmailOrPasswarnMsg.getText();
	}
	

}
