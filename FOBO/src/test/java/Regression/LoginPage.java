package Regression;

import java.io.IOException;

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
import Pageobjects.createOppPage;
import Pageobjects.landingPage;
import Pageobjects.loginPageObject;
import Regression.Base;

public class LoginPage extends Base {

	@Test
	public void LoginpageNavigation () throws IOException, InterruptedException
	{
		
		driver= initialiseDriver();
		driver.get("https://neustar--ltnstage.my.salesforce.com/");
		Thread.sleep(10000);
		loginPageObject l = new loginPageObject(driver);
		l.getusername().sendKeys("madhuri.yasareni@team.neustar.ltnstage.salesops");
		l.getpassword().sendKeys("Fobo@1234");
		l.getLogin().click();
		try {
			l.clickskip().click();
			}
			catch(Exception e) {
			  driver.navigate().refresh();
			}
		Thread.sleep(5000);
		landingPage lp= new landingPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lp.getAccount());
		Thread.sleep(5000);
		lp.getAcctbox().sendKeys("Testing");
		lp.getAcctbox().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		lp.getsrchresult().click();
		accountPage ap= new accountPage(driver);
		Thread.sleep(20000);
		js.executeScript("arguments[0].click();",ap.getOppsCont());
		Thread.sleep(20000);
		js.executeScript("arguments[0].click();", ap.getOppsNew());
		
		createOppPage cop = new createOppPage(driver);
		cop.getOppName().sendKeys("Opp1");
		cop.getcurrency().sendKeys("USD");
		Thread.sleep(5000);
		cop.getcurrency().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", cop.getUSD());
		
		js.executeScript("arguments[0].click();", cop.getcloseDate());
		cop.getToday().click();
		
		js.executeScript("arguments[0].click();", cop.getstage());
		cop.getstage0().click();
		
		js.executeScript("arguments[0].click();", cop.getOppType());
		cop.getNewlogo().click();
		
		js.executeScript("arguments[0].click();", cop.getsellinglane());
		cop.getSecuritySL().click();
		
		js.executeScript("arguments[0].click();", cop.getusecase());
		cop.getucDNS().click();
		
		js.executeScript("arguments[0].click();", cop.getentity());
		cop.getenSSL().click();
		
		js.executeScript("arguments[0].click();", cop.getMSADate());
		cop.getToday().click();
		
		js.executeScript("arguments[0].click();", cop.getSODate());
		cop.getToday().click();
		
		js.executeScript("arguments[0].click();", cop.getprimcntct());
		cop.getprimcntct().sendKeys("QA");
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",cop.getselectcntct());
		
		js.executeScript("arguments[0].click();", cop.getBillcntct());
		cop.getBillcntct().sendKeys("QA");
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();",cop.getselectbillcntct());
		
		cop.getsave().click();
		
		
	}
}