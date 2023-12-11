package com.demoapp.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	WebDriver driver;
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPLinkText;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement invalidResultWarnMsg;
	
	public SearchResultsPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean getStatusOfValidHPLinkText()
	{
		return validHPLinkText.isDisplayed();
	}
	
	public String getInvalidResultWarnMsgText() 
	{
		return invalidResultWarnMsg.getText();
	}

}
