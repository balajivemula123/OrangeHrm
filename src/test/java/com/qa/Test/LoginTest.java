package com.qa.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Base.BaseSetup;
import com.qa.SeleniumWrapper.SeleniumWrappaer;
import com.qa.Utilities.TestData;
import com.qa.pages.LoginPage;

public class LoginTest extends BaseSetup
{
	@DataProvider(name="LoginData")
	public Object[][] getTestDta()
	{
		Object data[][]=TestData.getTestData("Sheet1");
		return data;
	
     }

      @Test(dataProvider ="LoginData")
      
      public void verifyloginDetails(String username,String password)
      {
    	  LoginPage lp =new LoginPage();
    	  
    	  SeleniumWrappaer.implicitwait();
    	  
    	  lp.enterUsernameAndPassword(username, password);
    	  
    	  SeleniumWrappaer.implicitwait();
    	  
    	  lp.clickonLogin();    	  
     }
      
      @Test
      public void verifylogout()
      {
    	  LoginPage lp =new LoginPage();
    	      lp.verifyWelcome();
    	      lp.verifylogout();
      }
    	
}
