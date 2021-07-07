package Regression;

import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

public class contractSubmitEdit extends Base {
	public String type;

	@Test(priority=1)
	public void Submitedit() throws IOException, InterruptedException
	{
		driver= initialiseDriver();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		contractPage c= new contractPage(driver);
		driver.get(contracturl);
		type= driver.findElement(By.xpath("//*[@class='test-id__field-label'][starts-with(text(),'Type')]//parent::div/following-sibling::div/span/span")).getText();
		System.out.println(type);
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//To Check the status of the Chevron
		if(c.Chevron_Draft.getAttribute("class").contains("active"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
				
		//Details_Status
		System.out.println("Initial Contract Status in Details Section = " +c.Details_Status().getText());
		Assert.assertEquals(c.Details_Status().getText(), "Draft");
				
		//Contract_Status
		System.out.println("Initial Contract Status = " +c.Contract_Status().getText());
		Assert.assertEquals(c.Contract_Status().getText(), "Draft");
	
		c.Dropdown().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", c.SubmitEdit());
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		c.SubmitEditDetails().sendKeys(SubmitEditDetails);
		Thread.sleep(5000);
		c.Submit_SubmitEdit().click();
		
		for(int i=1;i<=5;i++) {
			if(c.Details_Status().getText()!="Draft" && c.Contract_Status().getText()!="Draft") {
				System.out.println(i);
				break;
				}
			else{
				driver.navigate().refresh();
				Thread.sleep(10000);
			}
		}
		
		Thread.sleep(20000);
		//To Check the status of the Chevron
		if(c.Chevron_EditUnderReview.getAttribute("class").contains("active"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		//Details_Status
		System.out.println("Contract Status after doing Submit Edit in Details Section = " +c.Details_Status().getText());
		Assert.assertEquals(c.Details_Status().getText(), "Edit Under Review");
		
		//Contract_Status
		System.out.println("Contract Status after doing Submit Edit = " +c.Contract_Status().getText());
		Assert.assertEquals(c.Contract_Status().getText(), "Edit Under Review");
		// code to check error message 
		c.Dropdown().click();
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", c.SubmitForSignature());
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='parent_Signature_Tool__c2']/div/div")).click();
		driver.findElement(By.xpath("//*[@title='Neustar Adobe Signature']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("(//*[@class='select'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='parent_Signing_Order__c2']/div/div")).click();
		driver.findElement(By.xpath("//*[@title='Customer then Neustar']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='slds-form-element']/div/textarea")).sendKeys("eSignature");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		System.out.print("Error message when trying to do Submit for signature without approving Approval records: ");
		geterrormessage();
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@title='Close']")));
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@title='Close this window']")));
		Thread.sleep(10000);
		c.getdropdown().click();
		js.executeScript("arguments[0].click();", c.getesign());
		System.out.print("Error message when trying to do eSignature without approving Approval records: ");
		geterrormessage();
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@title='Close']")));
		Thread.sleep(10000);
		
		c.Related_Tab().click();
		if(type.equals("Service Order")){
		//Cases
		c.Cases_Section().click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		try {
			List<WebElement> Cases_List = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr/td[3]/span/a[contains(@title,'Edit Request')]"));
			int Cases_Count = Cases_List.size();
			System.out.println("Number of Case records when Submit Edit is done = " + Cases_Count);
			if(Cases_Count == 1) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertFalse(true);
			}
			Thread.sleep(5000);
			c.Case_SubmitEdit().click();
			Thread.sleep(10000);
			System.out.println(c.Case_Owner().getText());
			Assert.assertEquals("Sales Operations", c.Case_Owner().getText());
			driver.navigate().back();
		}
		catch(Exception e){
			
			System.out.println("No Case Records");
			if(type.equals("Service Order"))
			Assert.assertFalse(true);
		}
		}
		else if(type.equals("Legal")){
			c.Cases_Section().click();
			List<WebElement> Cases_List = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr/td[3]/span/a[contains(@title,'Edit Request')]"));
			int Cases_Count = Cases_List.size();
			System.out.println("Number of Case records when Submit Edit is done = " + Cases_Count);
			
			
		}
		
		else if(type.equals("Master Service Agreement (MSA)")){
			c.Cases_Section().click();
			List<WebElement> Cases_List = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr/td[3]/span/a[contains(@title,'Edit Request')]"));
			int Cases_Count = Cases_List.size();
			System.out.println("Number of Case records when Submit Edit is done = " + Cases_Count);
			
			
		}
		else if(type.equals("Reseller Partner Agreement")){
			c.Cases_Section().click();
			List<WebElement> Cases_List = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr/td[3]/span/a[contains(@title,'Edit Request')]"));
			int Cases_Count = Cases_List.size();
			System.out.println("Number of Case records when Submit Edit is done = " + Cases_Count);
			
			
		}
		
		driver.navigate().back();
		Thread.sleep(10000);
		
		
		
		
		//logout fron existing user
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
						Thread.sleep(1000);
					 // driver.navigate().refresh();
					}
				Thread.sleep(3000);
				try {
					driver.findElement(By.xpath("//*[@class='switch-to-lightning']")).click();
				}
					catch(Exception e) {
						Thread.sleep(1000);
				}
				//contractPage c= new contractPage(driver);
				driver.get(contracturl);
				Thread.sleep(5000);
				c.Related_Tab().click();
				c.Approvals_Section().click();
				
				//Approving the Approval Records
				try {
					driver.navigate().refresh();
					List<WebElement> Approval_List = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr"));
					int Approval_Count = Approval_List.size();
					System.out.println("Number of Approval records = " + Approval_Count);
					for(int i=1;i<=Approval_Count;i++) {
						
						Thread.sleep(10000);
						c.Approvals_Requested().click();
						Thread.sleep(5000);
						driver.navigate().refresh();
						Thread.sleep(10000);
						c.Approve_Button().click();
						Thread.sleep(20000);
						int x=driver.findElements(By.xpath("//iframe")).size();
						//System.out.println(x);
				        for(int j=0; j<x; j++){
				            driver.switchTo().frame(j);
				            
				            try {
				            	c.Approve_Text().sendKeys(ApprovalComments);
				            	c.Approval_Submit().click();
				            }
				           
				            catch (Exception e) {
				            	
				                driver.switchTo().defaultContent();
				            }
				            driver.switchTo().defaultContent();
				        }
				        Thread.sleep(10000);
				        driver.navigate().refresh();
						Thread.sleep(20000);
						c.Related_Tab().click();
						Thread.sleep(20000);
						c.Approvals_Section().click();
						Thread.sleep(10000);
					}
					
				}
				catch(Exception e){
					
					System.out.println("No Approval Records");
					Assert.assertFalse(true);
					
				}
				
				/*driver.navigate().back();
				driver.navigate().refresh();*/
				Thread.sleep(5000);
				
				//user login
				 String URL= driver.getCurrentUrl();
				if(URL.contains("uat"))
			    {
			    	//System.out.println(userid);
			    driver.get("https://neustar--uat.lightning.force.com/"+userid1);
			    Thread.sleep(10000);
			    }
			    else{
			    	//System.out.println(userid);
			    	driver.get("https://neustar--ltnstage.lightning.force.com/"+userid1);	
			    Thread.sleep(10000);
			    }
				driver.findElement(By.xpath("//*[@title='User Detail']")).click();
				//JavascriptExecutor js = (JavascriptExecutor)driver;
				Thread.sleep(10000);
				int j=driver.findElements(By.xpath("//iframe")).size();
			//	System.out.println(j);
			    for(int a=0; a<j; a++){
			    	driver.switchTo().frame(a);
				try{	
			    		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='topButtonRow']/input[4][@name='login']")));
			    	//	System.out.println("clicked login");
			    		Thread.sleep(5000);
			    		}
			    	catch (Exception e){
			    		
			    		driver.switchTo().defaultContent();
			    	}
			    	
			    }
				driver.switchTo().defaultContent();
				Thread.sleep(10000);
				//contracturl=prop.getProperty("contracturl");
				driver.get(contracturl);
		
		//driver.findElement(By.xpath("//span[text()='Details']")).click();
		//driver.navigate().back();
		
		for(int i=1;i<=5;i++) {
			if(c.Details_Status().getText()!="Edit Under Review" && c.Contract_Status().getText()!="Edit Under Review") {
				System.out.println(i);
				break;
				}
			else{
				driver.navigate().refresh();
				Thread.sleep(10000);
			}
		}
		
		Thread.sleep(10000);
		//To Check the status of the Chevron
		if(c.Chevron_EditComplete.getAttribute("class").contains("active"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		//Details_Status
		System.out.println("Contract Status after Approving the Approval records in Details Section = " +c.Details_Status().getText());
		Assert.assertEquals(c.Details_Status().getText(), "Edit Complete");
		
		//Contract_Status
		System.out.println("Contract Status after Approving the Approval records = " +c.Contract_Status().getText());
		Assert.assertEquals(c.Contract_Status().getText(), "Edit Complete");
		
	driver.close();
	        
		
	}	
	public void geterrormessage() {
		WebElement msg = driver.findElement(By.xpath("//*[@class='forceVisualMessageQueue']/div/div/div/div/span"));
		waitForWebElementPresent(msg);
		String msgct = msg.getText();
		WebElement sm = driver.findElement(By.xpath("//*[@class='forceVisualMessageQueue']"));
		//if (sm.getText().contains("Error"))
			System.out.println(msgct);
	
	}
	
}