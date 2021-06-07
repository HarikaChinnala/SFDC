package Regression;

import java.awt.List;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
import Pageobjects.reusablemethods;
import Regression.productConfiguration;
import Regression.Base;

public class createQuoteandConfigure extends Base {
	//public String existquote;
	//createOpportunity cp=new createOpportunity();
	
	@Test(priority=1)
	public void createQuote() throws IOException, InterruptedException
	{
		driver= initialiseDriver();
		landingPage lp= new landingPage(driver);
		createQuotePage qp= new createQuotePage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		Thread.sleep(3000);
		try{
		js.executeScript("arguments[0].click();", lp.getOpportunities());
		}
		catch (Exception e1){
			
			driver.findElement(By.cssSelector("[title='Opportunities']")).click();
		}
		//lp.getOpportunities().click();
		Thread.sleep(3000);
		lp.getopptxtbox().sendKeys(opportunityname);
		lp.getopptxtbox().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		//lp.getsrchresult().click();
		//String OppName = prop.getProperty("OppName");
		driver.findElement(By.xpath("//*[@title='"
								+ opportunityname
								+ "']")).click();
		Thread.sleep(10000);
		js.executeScript("arguments[0].click();", lp.getnewQuote()); 
		
		Thread.sleep(15000);
		js.executeScript("arguments[0].click();",qp.getRNperiod());
		Thread.sleep(5000);
		//String RNperiod = prop.getProperty("RNperiod");
		driver.findElement(By.xpath("//*[@title='"
				+ RNperiod
				+ "']")).click();
		
		qp.getsave().click();
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(10000);
	}
		@Test(priority=2)
		public void configureQuote() throws IOException, InterruptedException
		{
			
			oppPage op= new oppPage(driver);
			productConfiguration pc= new productConfiguration(driver);
			JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", op.getDetail());
		Thread.sleep(30000);
		//driver.findElement(By.xpath("(//*[contains(text(),'Primary Quote')]/parent::div)/following-sibling::div[1]/span/slot/slot/force-lookup/div/force-hoverable-link/div/a/span[@id='window']")).click();
		js.executeScript("arguments[0].click();", op.getquotelink());
		Thread.sleep(20000);
		//to be sent to data.property file
		String quote = driver.findElement(By.xpath("//*[contains(text(),'Quote Number')]/following-sibling::p/slot/lightning-formatted-text")).getText();
		System.out.println("Quote created is:"+quote);
	 
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", op.geteditlines());
		Thread.sleep(30000);
		// configured products
		pc.productConfiguration();
        driver.navigate().refresh();
        Thread.sleep(10000);
		}
		
		@Test(priority=3)
		public void generatequoteproposal() throws IOException, InterruptedException
		{
		createQuotePage qp= new createQuotePage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		reusablemethods rm= new reusablemethods(driver);
		Thread.sleep(5000);
        js.executeScript("arguments[0].click();", qp.getGenquoteprop());
        Thread.sleep(60000);
        rm.generatedoc(driver);
        js.executeScript("arguments[0].click();", qp.getRelated()); 
        Thread.sleep(10000);
        
        Actions a = new Actions(driver);
        a.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(10000);
        
        String file=qp.getFiles().getAttribute("title");
        if(file.startsWith("Quote Proposal -"))
        System.out.println("File is attached");
        else
        	System.out.println("File is not attached");
		}
		@Test(priority=4)
		public void approveQuote() throws IOException, InterruptedException
		{
			
			createQuotePage qp= new createQuotePage(driver);
			JavascriptExecutor js = (JavascriptExecutor)driver;
        qp.getdropdown().click();
        Thread.sleep(5000);
        //qp.getsubmitapproval().click();
        String url=driver.getCurrentUrl();
        
        if(url.contains("ltnstage")){
        js.executeScript("arguments[0].click();", qp.getsubmitapproval());
        Thread.sleep(10000);
        }
        else
        	js.executeScript("arguments[0].click();", qp.getsubmitapprovaluat());
        Thread.sleep(10000);
        String app = qp.getapproved().getAttribute("aria-selected");
        System.out.println(app);
        if (app.equals("true")){
        	System.out.println("Quote is approved");
        }
        else 
        	System.out.println("Quote is not approved");
      driver.close();
        }
	
}