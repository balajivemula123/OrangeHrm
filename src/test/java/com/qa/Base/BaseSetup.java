package com.qa.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.SeleniumWrapper.SeleniumWrappaer;
import com.qa.Utilities.Readproperty;

public class BaseSetup 
{

	 public static WebDriver driver;
		@BeforeTest
		public  void setup()
		{ 
			Readproperty pr=new Readproperty("config");
			String browser = pr.getproperty("browser");
			
			if(browser.equalsIgnoreCase("Chrome"))
			{
			 System.setProperty("webdriver.chrome.driver", "E:\\selenium program\\OrangeHrm\\libraries\\chromedriver.exe");
	        driver = new ChromeDriver();
			}
			
			else if(browser.equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "E:\\selenium program\\OrangeHrm\\libraries\\geckodriver.exe");
				driver= new FirefoxDriver();
			}
			
			else if (browser.equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver", "E:\\selenium program\\OrangeHrm\\libraries\\IEDriverServer.exe");
				driver = new InternetExplorerDriver(); 
			}
				
	    driver.manage().window().maximize();
      SeleniumWrappaer.implicitwait();
	   driver.get(pr.getproperty("url"));
	    
		}
		
		@AfterTest
		public void teardown()
		{
			driver.close();
		}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
