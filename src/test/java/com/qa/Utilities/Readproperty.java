package com.qa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readproperty 
{
	private String filename;
	private File file;
	private Properties prop;
	public Readproperty(String filename)
	{
		this.filename=filename;
		try {
			String path = System.getProperty("user.dir")+File.separator+"ObjectRepocitory"+File.separator+filename+".properties";
			file = new File(path);
		
		
		}
		catch(Exception e)
		{
			System.out.println("error in file reading" );
			
		}
		
		prop = new Properties();
		}
	public String getproperty(String key)
	{
		String value =null;
		try
		{
			if (file. exists())
			{
				FileInputStream fis= new FileInputStream(file);
				prop.load(fis);
				value=prop.getProperty(key);
				
			}
			else 
			{
				System.out.println(filename+"doesnot exists");
				
			}
			
		}
			
			catch(Exception e) 
		{
				
		}
		
		
	
	return value;
	
}
}
