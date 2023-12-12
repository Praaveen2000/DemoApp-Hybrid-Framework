package com.demoapp.qa.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.demoapp.qa.utils.Utilities;

public class BaseClass {
	
	static Properties property;
	
	public static String readFromProperties(String key)
	{
		property = new Properties();
		
		File file = new File(System.getProperty("user.dir")+"/src/main/resources/com/demoapp/qa/config/Config.properties");
		
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				property.load(stream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return property.getProperty(key);
		
		
	}
	

	public static WebDriver driver;
	
	public static WebDriver getBrowserInstance()
	{
		return driver;
	}

	public WebDriver SetupBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions opt = new ChromeOptions();
			
			opt.addArguments("--headless=new");
			
			opt.addArguments("--no-sandbox");
			
			driver = new ChromeDriver(opt);
			
			
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
			
			
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
			
			
		}
		else if(browserName.equalsIgnoreCase("Safari"))
		{
			driver = new SafariDriver();
			
			
		}	
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMP_WAIT_TIME));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		
		driver.get(readFromProperties("url"));
		
		return driver;
		

	}

}
