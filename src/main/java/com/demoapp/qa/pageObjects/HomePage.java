package com.demoapp.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropDownMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginBtn;
	
	@FindBy(linkText="Register")
	private WebElement registerBtn;
	
	@FindBy(name="search")
	private WebElement searchBox;
	
	@FindBy(css="span[class*='input-group-btn']>button")
	private WebElement searchBtn;
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);  //this or HomePage.class
	}
	
	public void clickOnMyAccount()
	{
		myAccountDropDownMenu.click();
	}
	
	public LoginPage navigateToLoginPage()
	{
		myAccountDropDownMenu.click();
		
		loginBtn.click();
		
		return new LoginPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage()
	{
		myAccountDropDownMenu.click();
		
		registerBtn.click();
		
		return new RegisterPage(driver);
	}
	
	public SearchResultsPage searchForAProduct(String product)
	{
		searchBox.sendKeys(product);
		
		searchBtn.click();
		
		return new SearchResultsPage(driver);
	}
	
	public void enterSearchBox(String product)
	{
		searchBox.sendKeys(product);
	}
	
	public SearchResultsPage clickOnSearch()
	{
		searchBtn.click();
		
		return new SearchResultsPage(driver);
	}

}
