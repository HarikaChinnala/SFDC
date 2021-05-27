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

	@Test(priority=1)
	public void createLead() throws IOException, InterruptedException
	{
		driver= initialiseDriver();
		Thread.sleep(2000);
		landingPage lp= new landingPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lp.getLeads());
		Thread.sleep(5000);
		lp.getleadnew().click();;
		createLeadPage clp= new createLeadPage(driver);
		Thread.sleep(5000);
		
		clp.getfirstname().sendKeys(firstname);
		clp.getlastname().sendKeys(lastname);
		clp.getemail().sendKeys(email);
		clp.getcompany().sendKeys(company);
		clp.getphone().sendKeys(phone);
		clp.getwebsite().sendKeys(website);
		clp.getstreet().sendKeys(street);
		clp.getcity().sendKeys(city);
		clp.getstate().sendKeys(state);
		clp.getpostalcode().sendKeys(postalcode);
		clp.getcountry().sendKeys(country);
		clp.getsave().click();
		Thread.sleep(10000);
	}
		//convert lead
		@Test(priority=2)
		public void convertLead() throws IOException, InterruptedException
		{
			Thread.sleep(5000);	
		createLeadPage clp= new createLeadPage(driver);
		clp.getconvert().click();
		Thread.sleep(10000);
		clp.getcon().click();
		Thread.sleep(20000);
	driver.close();
		
	}
}