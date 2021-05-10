package Regression;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pageobjects.accountPage;
import Pageobjects.createLeadPage;
import Pageobjects.createOppPage;
import Pageobjects.landingPage;
import Pageobjects.loginPageObject;
import Regression.Base;

public class createAccountandEdit extends Base {
	
	@Test
	public void createAccountandEdit () throws IOException, InterruptedException
	{
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\966790\\git\\Foborepository\\FOBO\\src\\main\\java\\Regression\\data.properties");
	    	prop.load(fis);
	
			driver= initialiseDriver();
			driver.get(prop.getProperty("url"));
		Thread.sleep(10000);
		loginPageObject l = new loginPageObject(driver);
		l.getusername().sendKeys(prop.getProperty("username"));
		l.getpassword().sendKeys(prop.getProperty("pwd"));
		l.getLogin().click();
		try {
			l.clickskip().click();
			}
			catch(Exception e) {
			  driver.navigate().refresh();
			}
		
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
		}
			catch(Exception e) { 
		}
		Thread.sleep(2000);	
		landingPage lp= new landingPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lp.getAccount());
		Thread.sleep(5000);
		accountPage ap= new accountPage(driver);
		js.executeScript("arguments[0].click();", ap.getNewAccount());
		ap.getAccountNamefield().sendKeys(prop.getProperty("NewAccountname"));
		ap.getwebsite().sendKeys(prop.getProperty("websitename"));
		ap.getsaveAccount().click();
		Thread.sleep(10000);
	
			
			js.executeScript("arguments[0].click();", lp.getAccount());
			Thread.sleep(5000);
			String existingaccount = prop.getProperty("existingaccountname");
			driver.findElement(By.xpath("//*[text()='"
									+ existingaccount
									+ "']")).click();
	
			ap.getedit().click();
			ap.getwebsite().clear();
			ap.getwebsite().sendKeys(prop.getProperty("websitename"));
			ap.getsaveAccount().click();
			//driver.findElement(By.xpath("(//*[text()='Save'])[2]")).click();
			Thread.sleep(5000);
			driver.close();
		
	}
}