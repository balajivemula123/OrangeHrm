package com.qa.SeleniumWrapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.Base.BaseSetup;
import com.qa.Utilities.Readproperty;



public class SeleniumWrappaer extends BaseSetup
{
	 static Readproperty pr = new Readproperty("config");
	static long shortwait=Long.valueOf(pr.getproperty("shortwait"));
	static long waittime = Long.valueOf(pr.getproperty("wait"));
	static long longwait=Long.valueOf(pr.getproperty("longwait"));
	
	static long Thwait=Long.valueOf(pr.getproperty("Mwait"));

	
 public static  void geturl(String expected )
 {
	String actual =driver.getCurrentUrl();
	 Assert.assertEquals(expected, actual,"url not matched");
 }
	
 
    public  static void gettitle(String expected)

    {
    String actual=driver.getTitle();
    Assert.assertEquals(actual, expected, "title not matched" );
    }
	
 
	public static  void implicitwait()
	{
		driver.manage().timeouts().implicitlyWait(shortwait, TimeUnit.SECONDS);
	}


	public static void SeleniumClick(WebElement element)
	{
		try{
	 WebDriverWait wait = new WebDriverWait(driver, longwait);
	 wait.until(ExpectedConditions.visibilityOf(element));
	 wait.until(ExpectedConditions.elementToBeClickable(element));
	 element.click();
		}
		catch(Exception e)
		{
			System.out.println("unable to click element.Exception:" +e);
		}
	}
	
	
	public static void enterText(WebElement element, String textToenter)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, longwait) ;
			wait.until(ExpectedConditions.visibilityOf(element));
			if(element.isEnabled())
			{
				element.sendKeys(textToenter);
			}
			else
			{
				System.out.println("element isw not enabled");
			}
		}
			catch(Exception e)
			{
				System.out.println("unable to given text:"+textToenter+ "in element.Exception;" +e);
			}
			
	     }
			
			
	// it  will wait until element to be clickable
	public  static void waitUntillElementToBeclickable(WebElement element)
	{
		
	try {
		WebDriverWait wait = new WebDriverWait(driver, longwait);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Exception e){
			System.out.println("element is not clickable.Exception;"+e);
		}
			
	}
		
	public static void WBdropdown(WebElement element,String text)
	{
	     element.sendKeys(text);
		Select countries = new Select(element);
		countries.selectByVisibleText(text);
	}
			
	//for screen shot
	
	public  void ScreenShot(String path,String filename) throws IOException
	{
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File(path+filename+".jpg"));
		
	}
	
		
	//for  auto it
	
	public static void Autoit(String path) throws IOException
	{
		
	Runtime.getRuntime().exec(path);  		
		
   }
	
	
	//for thread.sleep
	
	public static void Threadsleep() throws InterruptedException
	{
		
	 Thread.sleep(Thwait);
	 
	}
	
	//for window handles
	
	public static void windowhandles(String window1,String window2)
	{
		
	      Set<String> handler=driver.getWindowHandles();
	      Iterator<String> it=handler.iterator();
	         window1=it.next();
	         window2=it.next();
	        driver.switchTo().window(window2);
		
	}
	
	
	public static void Alerts()
	{
		
		Alert a= driver.switchTo().alert();
		  a.accept();
		  a.dismiss();	
	}
	
	
	
	
}		
	

	
	
	
	
	
	
	
	

