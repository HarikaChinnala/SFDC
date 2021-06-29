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
import Pageobjects.contractPage;
import Pageobjects.createOppPage;
import Pageobjects.createQuotePage;
import Pageobjects.landingPage;
import Pageobjects.loginPageObject;
import Pageobjects.oppPage;
import Regression.Base;

public class activateContract extends Base {
	
	public String type;
	//Attention required
	@Test(priority=1)
	public void attentionrequired () throws IOException, InterruptedException 
	{
		driver= initialiseDriver();
		landingPage lp= new landingPage(driver);
		contractPage cp= new contractPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lp.getcontracts());
		Thread.sleep(5000);
		lp.getcontracttxtbox().sendKeys(contractid);
		lp.getcontracttxtbox().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		//String contractid = prop.getProperty("contractid");
		driver.findElement(By.xpath("//*[@title='"
								+ contractid
								+ "']")).click();
		//driver.get("https://neustar--ltnstage.lightning.force.com/lightning/r/Contract/8006s0000005Dg0AAE/view");
		Thread.sleep(10000);
	   type= driver.findElement(By.xpath("//*[@class='test-id__field-label'][starts-with(text(),'Type')]//parent::div/following-sibling::div/span/span")).getText();
		System.out.println(type);
	   ((JavascriptExecutor)driver).executeScript("scroll(0,100);");
		Thread.sleep(1000);
		Actions action= new Actions(driver);
		action.doubleClick(cp.getstatus()).build().perform();
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();",driver.findElement(By.cssSelector("a.select")));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", cp.getARdrop());
		
		cp.getARcomments().sendKeys(ARcomments);
		Thread.sleep(5000);
		try{
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//*[@dir='ltr'][contains(text(),'Save')])[2]")));	
		}
		catch (Exception e){
			
		js.executeScript("arguments[0].click();", cp.geteditsave());
		}
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		
		String AR=cp.getARchev().getAttribute("aria-selected");
		  if (AR.equals("true")){
	        	System.out.println("Contract stage is moved to Attention Required");
	        }
	        else 
	        	System.out.println("Contract stage is not moved to Attention Required");
	     
	}
	// Awaiting activation
	@Test(priority=2)
	public void awaitingactivation () throws IOException, InterruptedException{
		  
		contractPage cp= new contractPage(driver);
		  ((JavascriptExecutor)driver).executeScript("scroll(0,100);");
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			Actions action= new Actions(driver);
			action.doubleClick(cp.getstatus()).build().perform();
			Thread.sleep(3000);
			js.executeScript("arguments[0].click();",driver.findElement(By.cssSelector("a.select")));
			Thread.sleep(1000);
			js.executeScript("arguments[0].click();", cp.getAAdrop());
			js.executeScript("arguments[0].click();", cp.geteditsave());
			Thread.sleep(10000);
			for(int m=0;m<=1;m++)
	        {
	        	driver.navigate().refresh();
	        	Thread.sleep(10000);
	        	
	        }
			
			String AA=cp.getAAchev().getAttribute("aria-selected");
			  if (AA.equals("true")){
		        	System.out.println("Contract stage is moved to Awaiting Activation");
		        }
		        else 
		        	System.out.println("Contract stage is not moved to Awaiting Activation");
	}
	// contract activation
	@Test(priority=3)
	public void contractactivation () throws IOException, InterruptedException{
		
		contractPage cp= new contractPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", cp.getActivate());
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", cp.getActivatepopup());
		Thread.sleep(5000);
		//driver.navigate().refresh();
		Thread.sleep(10000);
		
		String act=cp.getActchev().getAttribute("aria-selected");
		  if (act.equals("true")){
	        	System.out.println("Contract is Activated");
	        }
	        else 
	        	System.out.println("Contract is not Activated");
		  
		  if(type.equals("Service Order")){
	  js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@class='slds-form-element__control']/div/div/a")));
		 Thread.sleep(10000);
		
		  String chev=driver.findElement(By.xpath("//*[@title='7 - Won']")).getAttribute("aria-selected");
		  if (chev.equals("true")){
	        	System.out.println("Opportunity is moved to 7-won stage");
	        }
	        else 
	        	System.out.println("Opportunity is not moved to 7-won stage");
		  }
		  Thread.sleep(3000);
		  driver.close();
		
	}
}