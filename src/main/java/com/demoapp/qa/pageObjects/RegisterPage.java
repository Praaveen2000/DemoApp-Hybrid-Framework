package com.demoapp.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passWordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassWordField;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement yesNewsLetter;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement checkPrivacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueBtn;
	
	@FindBy(css="div[class*='alert']")
	private WebElement warnMsg;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarnMsg;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarnMsg;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarnMsg;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarnMsg;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarnMsg;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String firstName)
	{
		firstNameField.sendKeys(firstName);
	}
	
	public void enterLastName(String firstName)
	{
		lastNameField.sendKeys(firstName);
	}
	
	public void enterEmail(String email)
	{
		emailField.sendKeys(email);
	}
	
	public void entertelephone(String telephone)
	{
		telephoneField.sendKeys(telephone);
	}
	
	public void enterPassWord(String passWord)
	{
		passWordField.sendKeys(passWord);
	}
	
	public void enterConfirmPassWord(String confirmPassWord)
	{
		confirmPassWordField.sendKeys(confirmPassWord);
	}
	
	public void checkPrivacyPolicyBox()
	{
		checkPrivacyPolicy.click();
	}
	
	public AccountSuccessPage clickOnContinue()
	{
		continueBtn.click();
		
		return new AccountSuccessPage(driver);
	}
	
	public void optForNewsLetter()
	{
		yesNewsLetter.click();
	}
	
	public String getWarnMsgText()
	{
		return warnMsg.getText();
	}
	
	public String getFirstNameWarnMsgText()
	{
		return firstNameWarnMsg.getText();
	}
	
	public String getlastNameWarnMsgText()
	{
		return lastNameWarnMsg.getText();
	}
	
	public String getEmailWarnMsgText()
	{
		return emailWarnMsg.getText();
	}
	
	public String getTelephoneWarnMsgText()
	{
		return telephoneWarnMsg.getText();
	}
	
	public String getPassWordWarnMsgText()
	{
		return passwordWarnMsg.getText();
	}
	
	public void enterMandatoryRegisterFields(String firstName, String lastName, String email, String telephone, String passWord, String confirmPassWord)
	{
		firstNameField.sendKeys(firstName);
		
		lastNameField.sendKeys(firstName);
		
		emailField.sendKeys(email);
		
		telephoneField.sendKeys(telephone);
		
		passWordField.sendKeys(passWord);
		
		confirmPassWordField.sendKeys(confirmPassWord);
	}
	
	public AccountSuccessPage checkPrivacyAndContinueToAccountSuccessPage()
	{
		checkPrivacyPolicy.click();
		
		continueBtn.click();
		
		return new AccountSuccessPage(driver);
	}
	

	public void enterAllRegisterFields(String firstName, String lastName, String email, String telephone, String passWord, String confirmPassWord)
	{
		firstNameField.sendKeys(firstName);
		
		lastNameField.sendKeys(firstName);
		
		emailField.sendKeys(email);
		
		telephoneField.sendKeys(telephone);
		
		passWordField.sendKeys(passWord);
		
		confirmPassWordField.sendKeys(confirmPassWord);
		
		yesNewsLetter.click();
	}

}
