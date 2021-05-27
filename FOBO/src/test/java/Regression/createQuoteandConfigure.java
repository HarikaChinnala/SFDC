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
import Pageobjects.reusablemethods;
import Regression.Base;

public class createQuoteandConfigure extends Base {
	
	
	@Test(priority=1)
	public void createQuote() throws IOException, InterruptedException
	{
		driver= initialiseDriver();	
		landingPage lp= new landingPage(driver);
		createQuotePage qp= new createQuotePage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		Thread.sleep(5000);
		try{
		js.executeScript("arguments[0].click();", lp.getOpportunities());}
		catch (Exception e1){
			driver.findElement(By.cssSelector("[title='Opportunities']")).click();
		}
		//lp.getOpportunities().click();
		Thread.sleep(5000);
		lp.getopptxtbox().sendKeys(OppName);
		lp.getopptxtbox().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		//lp.getsrchresult().click();
		//String OppName = prop.getProperty("OppName");
		driver.findElement(By.xpath("//*[@title='"
								+ OppName
								+ "']")).click();
		Thread.sleep(10000);
		js.executeScript("arguments[0].click();", lp.getnewQuote()); 
		
		Thread.sleep(20000);
		js.executeScript("arguments[0].click();",qp.getRNperiod());
		Thread.sleep(5000);
		//String RNperiod = prop.getProperty("RNperiod");
		driver.findElement(By.xpath("//*[@title='"
				+ RNperiod
				+ "']")).click();
		
		qp.getsave().click();
		Thread.sleep(5000);
	}
		@Test(priority=2)
		public void configureQuote() throws IOException, InterruptedException
		{
			oppPage op= new oppPage(driver);
			JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", op.getDetail());
		Thread.sleep(30000);
		//driver.findElement(By.xpath("(//*[contains(text(),'Primary Quote')]/parent::div)/following-sibling::div[1]/span/slot/slot/force-lookup/div/force-hoverable-link/div/a/span[@id='window']")).click();
		js.executeScript("arguments[0].click();", op.getquotelink());
		Thread.sleep(30000);
		
		
		js.executeScript("arguments[0].click();", op.geteditlines());
		Thread.sleep(30000);
       int x=driver.findElements(By.xpath("//iframe")).size();
        for(int i=0; i<x; i++){
        	driver.switchTo().frame(i);
        	//WebElement add =driver.findElement(By.xpath("//*[@name='Add Products']/paper-button"));
        	//System.out.println(add.isEnabled());
        	try{
        	//driver.findElement(By.xpath("//*[@name='Add Products']/paper-button")).click();
        		
        		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@name='Add Products']/paper-button")));
        	}
        	
        	catch (Exception e) {
        		driver.switchTo().defaultContent();
        	}
        	}
        
	
        driver.findElement(By.xpath("//*[@id='items']/sb-table-row[4]")).click();    
        Thread.sleep(10000);      
        driver.switchTo().defaultContent();
        Thread.sleep(10000);
        int j=driver.findElements(By.xpath("//iframe")).size();
        for(int a=0; a<j; a++){
        	driver.switchTo().frame(a);
        	//WebElement checkbox =driver.findElement(By.xpath("//*[@name='UltraDNS']/sb-swipe-container/div/div/sb-group/div/div/sb-table-cell-select/div/paper-checkbox"));
        	//if(driver.findElement(By.xpath("//*[@name='UltraDNS']/sb-swipe-container/div/div/sb-group/div/div/sb-table-cell-select/div/paper-checkbox")).isEnabled()==true){
        	try{	
        		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@name='UltraDNS']/sb-swipe-container/div/div/sb-group/div/div/sb-table-cell-select/div/paper-checkbox")));
        	}
        	catch (Exception e){
        		driver.switchTo().defaultContent();
        	}
        	
        }
     
        driver.findElement(By.xpath("//*[text()='Select']")).click();
        
        Thread.sleep(10000);
        
        driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
        driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
        driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();
        
        Thread.sleep(10000);
        
        //QUICK SAVE
        //driver.findElement(By.xpath("//*[@name='Quick Save']/paper-button")).click();
        js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@name='Quick Save']/paper-button")));
        Thread.sleep(30000);
        
        //SAVE
        //driver.findElement(By.xpath("//*[@name='Save']/paper-button")).click();
        js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@name='Save']/paper-button")));
       try{
    	  //driver.navigate().refresh();
    	   Thread.sleep(30000); 
        js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@name='Save']/paper-button")));
       }
       catch (Exception exc){
    	   driver.switchTo().defaultContent();
       
       }
        driver.navigate().refresh();
        Thread.sleep(10000);
		}
		
		@Test(priority=3)
		public void generatequoteproposal() throws IOException, InterruptedException
		{
		createQuotePage qp= new createQuotePage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		reusablemethods rm= new reusablemethods(driver);
        js.executeScript("arguments[0].click();", qp.getGenquoteprop());
        Thread.sleep(60000);
        rm.generatedoc(driver);
        js.executeScript("arguments[0].click();", qp.getRelated()); 
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