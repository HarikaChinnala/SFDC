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
	@Test
	public void createContract () throws IOException, InterruptedException
	{
		
		driver= initialiseDriver();
		landingPage lp= new landingPage(driver);
		contractPage cp= new contractPage(driver);
		oppPage op= new oppPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;	js.executeScript("arguments[0].click();", lp.getOpportunities());
		Thread.sleep(5000);
		lp.getopptxtbox().sendKeys(opportunityname);
		lp.getopptxtbox().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		//lp.getsrchresult().click();
		//String OppName = prop.getProperty("OppName");
		driver.findElement(By.xpath("//*[@title='"
								+ opportunityname
								+ "']")).click();
		Thread.sleep(5000);
		System.out.println("Opportunity Pagelayout values");
//		1. Opportunity
		String oppname1= op.getopportunityname().getText();
		System.out.println("opportunityname: "+oppname1);
//		2. Account name
		String accname1= op.getaccountname().getText();
		System.out.println("accountname: "+accname1);
//		3. Selling lane
		String sellinglane1= op.getsellinglane().getText();
		System.out.println("sellinglane: "+sellinglane1);
//		4. Entity
		String entity1= op.getentity().getText();
		System.out.println("entity: "+entity1);
//		5.  MSA Date 
		String msadate1= op.getmsadate().getText();
		System.out.println("msadate: "+msadate1);		
//		6. Service Order date
		String servicedate1= op.getservicedate().getText();
		System.out.println("servicedate: "+servicedate1);	
//		7. Quote 
		String quote1= op.getquote().getText();
		System.out.println("quote: "+quote1);
//		8. Contract term
		String term1= op.getterm().getText();
		System.out.println("term: "+term1);
//		9. primary Contact 
		String primecontact1= op.getprimecontact().getText();
		System.out.println("primarycontact: "+primecontact1);
//		10 Currency 
		String currency1= op.getcurrency().getText();
		System.out.println("currency: "+currency1);
//		11.Billing contact
		try{
		String billcontact1= op.getbillcontact().getText();
		System.out.println("billingcontact: "+billcontact1);
		}
		catch(Exception e){
			
		}
		
//		js.executeScript("arguments[0].click();", op.getcontracting());
//		js.executeScript("arguments[0].click();", op.getmark());
//		Thread.sleep(10000);
//		String err= driver.findElement(By.xpath("//*[@class='slds-align-middle slds-hyphenate']")).getText();
//		System.out.println(err);
//		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@title='Close']")));
//		
		js.executeScript("arguments[0].click();", op.getselection());
		js.executeScript("arguments[0].click();", op.getmark());
		
		Thread.sleep(10000);
		js.executeScript("arguments[0].click();", op.getcontracting());
		js.executeScript("arguments[0].click();", op.getmark());
		Thread.sleep(10000);
		String err1= driver.findElement(By.xpath("//*[@class='slds-align-middle slds-hyphenate']")).getText();
		System.out.println(err1);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@title='Close']")));
		
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
	        System.out.println("Contract Pagelayout Values");
//	        1. Opportunity
			String oppname2= cp.getopportunityname().getText();
			System.out.println("opportunityname: "+oppname2);
//			2. Account name
			String accname2= cp.getaccountname().getText();
			System.out.println("accountname: "+accname2);
//			3. Selling lane
			String sellinglane2= cp.getsellinglane().getText();
			System.out.println("sellinglane: "+sellinglane2);
//			4. Entity
			String entity2= cp.getentity().getText();
			System.out.println("entity: "+entity2);
//			5.  MSA Date 
			String msadate2= cp.getmsadate().getText();
			System.out.println("msadate: "+msadate2);		
//			6. Service Order date
			String servicedate2= cp.getservicedate().getText();
			System.out.println("servicedate: "+servicedate2);	
//			7. Quote 
			String quote2= cp.getquote().getText();
			System.out.println("quote: "+quote2);
//			8. Contract term
			String term2= cp.getterm().getText();
			System.out.println("term: "+term2);
//			9. primary Contact 
			String primecontact2= cp.getprimecontact().getText();
			System.out.println("primarycontact: "+primecontact2);
//			10.Billing contact
			try{
			String billcontact2= cp.getbillcontact().getText();
			System.out.println("billingcontact: "+billcontact2);
			}
			catch(Exception e){
				
			}
			
			if(oppname2.equals(oppname1) && accname2.equals(accname1) && sellinglane2.equals(sellinglane1) && entity2.equals(entity1) && msadate2.equals(msadate1) && servicedate2.equals(servicedate1) && quote2.equals(quote1) && primecontact2.equals(primecontact1) )
	        System.out.println("All values reflected correctly");
			else
				Assert.assertTrue(false);
				
			String stat= driver.findElement(By.xpath("//*[@title='Status']/following-sibling::div")).getText();
	        System.out.println("Contract Status is:"+stat);
	        // to be sent to data.prop file
	        String  curl = driver.getCurrentUrl();
	       String  id= driver.findElement(By.xpath("(//*[contains(text(),'Contract Number')]//parent::div)/following-sibling::div/span/span")).getText();
	        System.out.println("Contractid is:"+id);
	        System.out.println("Contracturl is:"+curl);
	        prop.setProperty("contractid", id);
	        prop.setProperty("contracturl", curl);
			try (final OutputStream outputstream = new FileOutputStream("src/main/java/Regression/data.properties");) {
				prop.store(outputstream, "File Updated");
				outputstream.close();
			}
	        Thread.sleep(5000);
		// code for contract page layout validations
		
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