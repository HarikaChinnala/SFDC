package Regression;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Base {
	
	public WebDriver driver;
	public WebDriver initialiseDriver() throws IOException
	{
	
		Properties prop = new Properties();
    	
    	FileInputStream fis = new FileInputStream("C:\\Users\\966790\\workspace\\FOBO\\src\\main\\java\\Regression\\data.properties");
    	
    	prop.load(fis);
    	
    	String browserName = prop.getProperty("browser");
    	System.out.println(browserName);
    	
    	if (browserName.equals("chrome"))
    	{
    		ChromeOptions opt = new ChromeOptions();
    		opt.addArguments("--disable-notifications");
    		System.setProperty("webdriver.chrome.driver", "C://Users//966790//chromedriver//chromedriver.exe");
    		driver = new ChromeDriver(opt);
    		
    	}
    	else if (browserName.equals("firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver","C://Users//966790//geckodriver.exe");
    		driver = new FirefoxDriver();
    	}
    	else if (browserName.equals("IE"))
    	{
    		//exceute in IE
    	}
    
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
		return driver;
	}
	
	
	
	

}

