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
import Pageobjects.contactPage;
import Pageobjects.createLeadPage;
import Pageobjects.createOppPage;
import Pageobjects.landingPage;
import Pageobjects.loginPageObject;
import Regression.Base;

public class createContactandEdit extends Base {
	
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
		contactPage cp= new contactPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lp.getcontacts());
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].click();", cp.getNewContact());
		cp.getfirstname().sendKeys(prop.getProperty("firstname1"));
		cp.getlastnamee().sendKeys(prop.getProperty("lastname1"));
		cp.getemail().sendKeys(prop.getProperty("email1"));
		cp.getAccountname().sendKeys(prop.getProperty("Accountname1"));
		String Accountname= prop.getProperty("Accountname1");
		driver.findElement(By.xpath("(//*[@role='listbox'])[4]/ul/li/lightning-base-combobox-item/span[2]/span/lightning-base-combobox-formatted-text[@title='"
				+ Accountname
				+ "']")).click();
		cp.getcountry().sendKeys(prop.getProperty("country"));
		cp.getsavecontact().click();
		Thread.sleep(5000);
		driver.navigate().refresh();

	//edit contact
		
		js.executeScript("arguments[0].click();", lp.getcontacts());
		Thread.sleep(5000);
		String existingcontactname = prop.getProperty("existingcontactname");
		driver.findElement(By.xpath("//*[text()='"
				+ existingcontactname
				+ "']")).click();
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", cp.getedit());
			cp.getfirstname().clear();
			cp.getfirstname().sendKeys(prop.getProperty("newfirstname"));
			cp.getsavecontact().click();
			//driver.findElement(By.xpath("(//*[text()='Save'])[2]")).click();
			Thread.sleep(5000);
			driver.close();
		
	}
}