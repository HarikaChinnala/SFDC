package Regression;

import java.awt.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.accountPage;
import Pageobjects.createOppPage;
import Pageobjects.createQuotePage;
import Pageobjects.landingPage;
import Pageobjects.loginPageObject;
import Pageobjects.oppPage;
import Regression.Base;

public class createContract extends Base {

	@Test
	public void LoginpageNavigation () throws IOException, InterruptedException
	{
		Properties prop = new Properties();
FileInputStream fis = new FileInputStream("C:\\Users\\966790\\git\\Foborepository\\FOBO\\src\\main\\java\\Regression\\data.properties");
    	prop.load(fis);
		driver= initialiseDriver();
		driver.get(prop.getProperty("url"));
		loginPageObject l = new loginPageObject(driver);
		l.getusername().sendKeys(prop.getProperty("username"));
		l.getpassword().sendKeys(prop.getProperty("pwd"));
		l.getLogin().click();
		try {
			l.clickskip().click();
			}
			catch(Exception e) {
			 // driver.navigate().refresh();
			}
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
		}
			catch(Exception e) { 
		}

		landingPage lp= new landingPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lp.getOpportunities());
		Thread.sleep(5000);
		lp.getopptxtbox().sendKeys(prop.getProperty("OppName"));
		lp.getopptxtbox().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		//lp.getsrchresult().click();
		String OppName = prop.getProperty("OppName");
		driver.findElement(By.xpath("//*[@title='"
								+ OppName
								+ "']")).click();
		oppPage op= new oppPage(driver);
		js.executeScript("arguments[0].click();", op.getselection());
		js.executeScript("arguments[0].click();", op.getmark());
		
		Thread.sleep(10000);
		js.executeScript("arguments[0].click();", op.getcontract());
		Thread.sleep(20000);
		
		js.executeScript("arguments[0].click();", op.getcontractsave());
		Thread.sleep(20000);
		
		js.executeScript("arguments[0].click();", op.getcontracting());
		js.executeScript("arguments[0].click();", op.getmark());
		Thread.sleep(10000);
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		
		js.executeScript("arguments[0].click();", op.getcontractlink());
		Thread.sleep(5000);
		
		
		
	}
}