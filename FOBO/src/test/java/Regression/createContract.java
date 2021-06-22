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
import Pageobjects.contractPage;
import Pageobjects.createOppPage;
import Pageobjects.createQuotePage;
import Pageobjects.landingPage;
import Pageobjects.loginPageObject;
import Pageobjects.oppPage;
import Regression.Base;

public class createContract extends Base {
//public String contracturl;
//public String contractid;
	@Test
	public void createContract () throws IOException, InterruptedException
	{
		
		driver= initialiseDriver();
		landingPage lp= new landingPage(driver);
		contractPage cp= new contractPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//driver.get("https://neustar--ltnstage.lightning.force.com/lightning/r/Contract/8006s0000005DmXAAU/view");
		js.executeScript("arguments[0].click();", lp.getOpportunities());
		Thread.sleep(5000);
		lp.getopptxtbox().sendKeys(opportunityname);
		lp.getopptxtbox().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		//lp.getsrchresult().click();
		//String OppName = prop.getProperty("OppName");
		driver.findElement(By.xpath("//*[@title='"
								+ opportunityname
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
		Thread.sleep(20000);
/*		 String url=driver.getCurrentUrl();
	        if(url.contains("ltnstage")){
		js.executeScript("arguments[0].click();", op.getcontractlink());
		Thread.sleep(5000);
	        }
	        else
	        	js.executeScript("arguments[0].click();", op.getcontractlinkuat());
*/
		try{
			js.executeScript("arguments[0].click();", op.getcontractlink());
		}
		catch(Exception e)
		{
			js.executeScript("arguments[0].click();", op.getcontractlinkuat());
		}
	        Thread.sleep(5000);
	        driver.navigate().refresh();
	        
	        Thread.sleep(10000);
	        String stat= driver.findElement(By.xpath("//*[@title='Status']/following-sibling::div")).getText();
	        System.out.println("Contract Status is:"+stat);
	        // to be sent to data.prop file
	        String  curl = driver.getCurrentUrl();
	       String  id= driver.findElement(By.xpath("(//*[contains(text(),'Contract Number')]//parent::div)/following-sibling::div/span/span")).getText();
	        System.out.println("Contractid is:"+id);
	        System.out.println("Contracturl is:"+curl);
	        prop.setProperty("contractid", id);
	        prop.setProperty("contracturl", curl);
			try (final OutputStream outputstream = new FileOutputStream(
					"C://Users//966790//git//newrepo//FOBO//src//main//java//Regression//data.properties");) {
				prop.store(outputstream, "File Updated");
				outputstream.close();
			}
	        Thread.sleep(5000);
		
		
		try{
		js.executeScript("arguments[0].click();", cp.getRelated());}
		catch (Exception e3){
			
			driver.findElement(By.xpath("//*[@class='tabs__nav']/li/a[@title='Related']")).click();
		}
	
		try{
		js.executeScript("arguments[0].click();", cp.getmanageclauses());
		}
		catch (Exception e2){
			
			driver.findElement(By.xpath("(//*[@title='Managed Clauses'])[2]")).click();
		}
		
		Thread.sleep(5000);
		
		int count= driver.findElements(By.xpath("//*[@role='grid']/tbody/tr")).size();
		//System.out.println(count);
		
		if(count>0)
			System.out.println("Manage clauses are generated");
		else 
			System.out.println("Manage clauses are not generated");
		
		
		driver.navigate().back();
		
	driver.close();
	        
		
	}
}