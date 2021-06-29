package Regression;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pageobjects.accountPage;
import Pageobjects.createOppPage;
import Pageobjects.landingPage;
import Pageobjects.legalDocumentPage;
import Pageobjects.loginPageObject;
import Regression.Base;

public class createNonRevenueContract extends Base {

	@Test
	public void  createNonRevenueContract() throws IOException, InterruptedException
	{
		
		driver= initialiseDriver();
		landingPage lp= new landingPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lp.getAccount());
		Thread.sleep(5000);
		lp.getAcctbox().sendKeys(Accountname);
		lp.getAcctbox().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		//lp.getsrchresult().click();
		//String Accountname = prop.getProperty("Accountname");
		driver.findElement(By.xpath("//*[text()='"
								+ Accountname
								+ "']")).click();
		accountPage ap= new accountPage(driver);
		Thread.sleep(20000);
		ap.getmore().click();
		js.executeScript("arguments[0].click();",ap.getlegal());
		Thread.sleep(5000);
		legalDocumentPage ldp=new legalDocumentPage(driver);
		js.executeScript("arguments[0].click();",ldp.getServiceline());
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//*[@name='Service_Line__c']//parent::div)/following-sibling::div/lightning-base-combobox-item[@data-value='"+serviceline+"']")));
		
		js.executeScript("arguments[0].click();",ldp.getDoctype());
		Select s= new Select(ldp.getDoctype());
		s.selectByVisibleText(""+doctype+"");
		Thread.sleep(5000);
		
		js.executeScript("arguments[0].click();",ldp.getlegalentity());
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//*[@name='NDA_Entity__c']//parent::div)/following-sibling::div/lightning-base-combobox-item[@data-value='"+legalentity+"']")));
		Thread.sleep(3000);
		
		ldp.getcountercontact().sendKeys(""+countercontact+"");
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(((//*[@for='custSignedBy']//following-sibling::lightning-input-field)//input)/parent::div)/following-sibling::div/ul/li/lightning-base-combobox-item/span[2]/span/*[@title='"+countercontact+"']")));
		Thread.sleep(5000);
		
		ldp.getcomments().sendKeys("Testing comments");
		
		if(doctype=="Assignment document from Customer"||doctype=="Other Non-Revenue Document"){
			
			ldp.getupload().click();
			
		}
		Thread.sleep(5000);
			js.executeScript("arguments[0].click();", ldp.getsubmit());
			
		Thread.sleep(30000);
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
		
		driver.close();
		
	}
}