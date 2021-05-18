package Regression;

import java.io.FileInputStream;
import java.io.IOException;
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

public class createLead extends Base {

	@Test
	public void createLeadandconvert () throws IOException, InterruptedException
	{
        Properties prop = new Properties();
    	FileInputStream fis = new FileInputStream("C:\\Users\\966790\\git\\newrepo\\FOBO\\src\\main\\java\\Regression\\data.properties");
    	prop.load(fis);
		driver= initialiseDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
		loginPageObject l = new loginPageObject(driver);
		l.getusername().sendKeys(prop.getProperty("username"));
		l.getpassword().sendKeys(prop.getProperty("pwd"));
		l.getLogin().click();
		try {
			l.clickskip().click();
			}
			catch(Exception e) {
			  //driver.navigate().refresh();
			}
		
		try {
			driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
		}
			catch(Exception e) { 
		}
		Thread.sleep(2000);
		landingPage lp= new landingPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lp.getLeads());
		Thread.sleep(5000);
		lp.getleadnew().click();;
		createLeadPage clp= new createLeadPage(driver);
		Thread.sleep(5000);
		
		clp.getfirstname().sendKeys(prop.getProperty("firstname"));
		clp.getlastname().sendKeys(prop.getProperty("lastname"));
		clp.getemail().sendKeys(prop.getProperty("email"));
		clp.getcompany().sendKeys(prop.getProperty("company"));
		clp.getphone().sendKeys(prop.getProperty("phone"));
		clp.getwebsite().sendKeys(prop.getProperty("website"));
		clp.getstreet().sendKeys(prop.getProperty("street"));
		clp.getcity().sendKeys(prop.getProperty("city"));
		clp.getstate().sendKeys(prop.getProperty("state"));
		clp.getpostalcode().sendKeys(prop.getProperty("postalcode"));
		clp.getcountry().sendKeys(prop.getProperty("country"));
		clp.getsave().click();
		Thread.sleep(10000);
		//convert lead
		clp.getconvert().click();
		Thread.sleep(10000);
		clp.getcon().click();
		Thread.sleep(20000);
	driver.close();
		
	}
}