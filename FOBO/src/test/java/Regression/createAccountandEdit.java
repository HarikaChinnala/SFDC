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
	
	
	@Test(priority=1)
	public void createAccount() throws IOException, InterruptedException
	{
		driver= initialiseDriver();
		Thread.sleep(2000);	
		landingPage lp= new landingPage(driver);
		accountPage ap= new accountPage(driver);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lp.getAccount());
		Thread.sleep(5000);
		
		js.executeScript("arguments[0].click();", ap.getNewAccount());
		ap.getAccountNamefield().sendKeys(NewAccountname);
		ap.getwebsite().sendKeys(websitename);
		ap.getsaveAccount().click();
		Thread.sleep(10000);
	driver.navigate().refresh();
	}
	@Test(priority=2)
	public void editAccount() throws IOException, InterruptedException
	{
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	landingPage lp= new landingPage(driver);
	accountPage ap= new accountPage(driver);
	
			js.executeScript("arguments[0].click();", lp.getAccount());
			Thread.sleep(10000);
			//String existingaccount = prop.getProperty("existingaccountname");
			driver.findElement(By.xpath("//*[text()='"
									+ existingaccountname
									+ "']")).click();
	
			ap.getedit().click();
			ap.getwebsite().clear();
			ap.getwebsite().sendKeys(websitename);
			ap.getsaveAccount().click();
			//driver.findElement(By.xpath("(//*[text()='Save'])[2]")).click();
			Thread.sleep(5000);
			driver.close();
		
	}
}