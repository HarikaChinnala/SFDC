package Regression;

import java.awt.List;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

//import javax.swing.text.html.HTMLDocument.Iterator;

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
import Pageobjects.reusablemethods;
import Regression.Base;
import java.util.Iterator;

public class eSignature extends Base {
	//Properties prop = new Properties();
	reusablemethods rm= new reusablemethods(driver);
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	//contractPage cp= new contractPage(driver);
	//private String file;
	@Test
	public void eSignature() throws IOException, InterruptedException
	{
		
		driver= initialiseDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@title='User']")));
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();",driver.findElement(By.cssSelector("a.profile-link-label.logout.uiOutputURL")));
		Thread.sleep(10000);
		//login as admin
		
		loginPageObject l = new loginPageObject(driver);
		l.getusername().sendKeys(usernameadmin);
		l.getpassword().sendKeys(pwd);
		l.getLogin().click();
		try {
			l.clickskip().click();
			}
			catch(Exception e) {
			 // driver.navigate().refresh();
			}
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
		}
			catch(Exception e) { 
		}
		//rm.otherUserlogin(driver);
		// other user login
		/*	driver.findElement(By.xpath("//*[@class='setupGear']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='related_setup_app_home']")));
		Set<String> s = driver.getWindowHandles();
		Iterator<String> i = s.iterator();
	    Thread.sleep(10000);
	    while (i.hasNext()) {
	        String ChildWindow = i.next();
	            driver.switchTo().window(ChildWindow);
	        }*/
	    String URL= driver.getCurrentUrl();
	    //System.out.println(URL);
	    //userid= prop.getProperty("userid");
	    if(URL.contains("uat"))
	    {
	    	//System.out.println(userid);
	    driver.get("https://neustar--uat.lightning.force.com/"+userid);
	    Thread.sleep(10000);
	    }
	    else{
	    	//System.out.println(userid);
	    	driver.get("https://neustar--ltnstage.lightning.force.com/"+userid);	
	    Thread.sleep(10000);
	    }
		driver.findElement(By.xpath("//*[@title='User Detail']")).click();
		
		Thread.sleep(10000);
		int j=driver.findElements(By.xpath("//iframe")).size();
		System.out.println(j);
	    for(int a=0; a<j; a++){
	    	driver.switchTo().frame(a);
		try{	
	    		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='topButtonRow']/input[4][@name='login']")));
	    		System.out.println("clicked login");
	    		Thread.sleep(5000);
	    		}
	    	catch (Exception e){
	    		driver.switchTo().defaultContent();
	    	}
	    	
	    }
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		//contracturl=prop.getProperty("contracturl");
		driver.get(contracturl);
		//contractid = prop.getProperty("contractid");
		contractPage cp= new contractPage(driver);
		Thread.sleep(10000);
		 js.executeScript("arguments[0].click();", cp.getRelated()); 
	        Thread.sleep(10000);

			((JavascriptExecutor)driver).executeScript("scroll(0,500);");
			Thread.sleep(10000);
	        
	        WebElement upload = driver.findElement(By.xpath("//*[@data-key='upload'][@class='slds-button__icon slds-button__icon_left']"));
	       
	        
	        if(upload.isDisplayed())
	        {
	        	System.out.println("File is not attached");
		
		cp.getdropdown().click();
		js.executeScript("arguments[0].click();", cp.getGenerateDoc());
		 Thread.sleep(60000);
		 rm.generatedoc(driver);
		
	        Thread.sleep(20000);
	        }
	        else
	        {
	        	String file=cp.getFiles().getAttribute("title");
	        	 System.out.println(file);
        		if(file.endsWith("- "
							+ contractid
							+ ".docx"))
     
        System.out.println("File is attached");
	        }
		
	        cp.getdropdown().click();
		
		js.executeScript("arguments[0].click();", cp.getesign());
		Thread.sleep(80000);
		String agreementname= cp.getagreement().getText();
		System.out.println(agreementname);
		System.out.println(cp.getagreementstat().getText());
		js.executeScript("arguments[0].click();", cp.getNext());
		Thread.sleep(30000);
		System.out.println(driver.getCurrentUrl());
		String parentwindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
	    Thread.sleep(10000);
	    while (i1.hasNext()) {
	        String Window1 = i1.next();
	        String Window2=i1.next();
	        driver.switchTo().window(Window2);
	        System.out.println("switched to childwindow");
	        Thread.sleep(10000);
	        System.out.println(driver.getCurrentUrl());
		js.executeScript("arguments[0].click();",driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.send-action ")));
		Thread.sleep(10000);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@class='control-button']")));
		Thread.sleep(20000);		
		driver.switchTo().window(Window1);
		Thread.sleep(5000);
	    }
		System.out.println(cp.getagreementstat().getText());
		
		Thread.sleep(5000);
		//((JavascriptExecutor)driver).executeScript("scroll(0,500);");
		//js.executeScript("arguments[0].click();",cp.getcontractlink());
		driver.get(contracturl);		
	Thread.sleep(10000);
		/*
		 js.executeScript("arguments[0].click();",cp.getcontractlink());
		 Set<String> s2 = driver.getWindowHandles();
		
		Iterator<String> i2 = s2.iterator();
	    Thread.sleep(10000);
	    while (i2.hasNext()) {
	    	String parentwindow2 = driver.getWindowHandle();
	        String ChildWindow1 = i2.next();
	        String ChildWindow2 = i2.next();
	            driver.switchTo().window(ChildWindow2);
	            System.out.println("switched to childwindow"); */
	        
		 js.executeScript("arguments[0].click();", cp.getRelated()); 
	        Thread.sleep(10000);
	     
	        	((JavascriptExecutor)driver).executeScript("scroll(0,1500);");
	 	       Thread.sleep(5000);
	 	      ((JavascriptExecutor)driver).executeScript("scroll(0,2000);");
	 	       Thread.sleep(2000);
	       try{
					String agreementstatus= driver.findElement(By.xpath("((((//*[contains(text(),'"
								+ agreementname
								+ "'])/preceding-sibling::a)/parent::div)/parent::th)/following-sibling::td[3]")).getText();
						System.out.println(agreementstatus);		
	       }		
	       catch (Exception exc){
	       }
	       
					
				//	System.out.println(cp.getagreementstatus().getText());
					
					String PCS = cp.getPCSchev().getAttribute("aria-selected");
			        //System.out.println(PCS);
			        if (PCS.equals("true")){
			        	System.out.println("Stage moved to Pending Customer Signature");
			        }
			        else 
			        	System.out.println("Stage not moved to Pending Customer Signature");
			        
			        for(int m=0;m<=5;m++)
			        {
			        	driver.navigate().refresh();
			        	Thread.sleep(20000);
			        	
			        }
			        try{
						String agreementstatus= driver.findElement(By.xpath("((((//*[contains(text(),'"
									+ agreementname
									+ "'])/preceding-sibling::a)/parent::div)/parent::th)/following-sibling::td[3]")).getText();
							System.out.println(agreementstatus);		
		       }		
		       catch (Exception exc){
		       }
			        String CS = cp.getCSchev().getAttribute("aria-selected");
			        //System.out.println(CS);
			        if (CS.equals("true")){
			        	System.out.println("Stage moved to Client Signed");
			        }
			        else 
			        	System.out.println("Stage not moved to Client Signed");   
			        
			        driver.close();
			        }
		
	
	}
