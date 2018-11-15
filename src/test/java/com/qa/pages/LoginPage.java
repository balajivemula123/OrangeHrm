package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.BaseSetup;
import com.qa.SeleniumWrapper.SeleniumWrappaer;

public class LoginPage extends BaseSetup
{
   @FindBy(xpath="//input[@id='txtUsername']")
   WebElement Wbuname;
   
   @FindBy(xpath="//input[@id='txtPassword']")
   WebElement Wbpassword;
   
   @FindBy(xpath="//input[@id='btnLogin']")
   WebElement Wblogin;
   
   @FindBy(xpath="//a[text()='Welcome Admin']")
   WebElement WbWelcome;
   
   @FindBy(xpath="//a[text()='Logout']")
   WebElement Wblogout;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsernameAndPassword(String Username,String Password)
	{
		SeleniumWrappaer.enterText(Wbuname, Username);
		SeleniumWrappaer.enterText(Wbpassword, Password);
	
	}
	
	public void clickonLogin()
	{
		SeleniumWrappaer.SeleniumClick(Wblogin);
			
	}
	
	 public void verifyWelcome()
	 {
	
		SeleniumWrappaer.SeleniumClick(WbWelcome);
	 }
	
	 public void verifylogout()
	 {
		 
	 
		SeleniumWrappaer.SeleniumClick(Wblogout);
	 }
}









