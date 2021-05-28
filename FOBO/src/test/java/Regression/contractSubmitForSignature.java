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

public class contractSubmitForSignature extends Base {

	@Test
	public void contractSubmitForSignature() throws IOException, InterruptedException
	{
		
		driver= initialiseDriver();
		createContract cc=new createContract();
		landingPage lp= new landingPage(driver);
		contractPage c= new contractPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get(contracturl);
		Thread.sleep(15000);
		js.executeScript("window.scrollBy(0,2700)", "");
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("((//*[text() = 'Billing Contact'])//parent::div)//following-sibling::div/span[@class='test-id__field-value slds-form-element__static slds-grow ']"));
		act.doubleClick(ele).perform();
		Thread.sleep(5000);
		
/*		 WebElement bc=driver.findElement(By.xpath("(((//*[text() = 'Billing Contact'])//parent::label)//following-sibling::div)/div/div/div/input"));
       String bcvalue= bc.getAttribute("placeholder");
       if(bcvalue.equals("Search Contacts...")){
        bc.sendKeys(primarycontact);
      
       
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("(((//*[text() = 'Billing Contact'])//parent::label)//following-sibling::div)/div/div/div/div/div[@class='listContent']/ul/li/a/div[@class='slds-m-left--smalllabels slds-truncate slds-media__body']/div[@title='"
				+ primarycontact
				+ "']")).click();
       }
	*/	 
		driver.findElement(By.xpath("(((//*[text() = 'Billing Contact'])//parent::label)//following-sibling::div)/div/div/div/input")).sendKeys(primarycontact);
		Thread.sleep(5000);
		//String primarycontact = prop.getProperty("primarycontact");
		driver.findElement(By.xpath("(((//*[text() = 'Billing Contact'])//parent::label)//following-sibling::div)/div/div/div/div/div[@class='listContent']/ul/li/a/div[@class='slds-m-left--smalllabels slds-truncate slds-media__body']/div[@title='"
				+ primarycontact
				+ "']")).click();

	
		driver.findElement(By.xpath("//*[text() = 'Save']")).click();
		Thread.sleep(15000);
		driver.navigate().refresh();
		Thread.sleep(15000);
		c.Dropdown().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		js.executeScript("arguments[0].click();", c.SubmitForSignature());
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
		//driver.findElement(By.xpath("(//*[@class='select'])[1]")).click()0		
		driver.findElement(By.xpath("//div[@id='parent_Signature_Tool__c2']/div/div")).click();
		driver.findElement(By.xpath("//*[@title='Neustar Adobe Signature']")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("(//*[@class='select'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='parent_Signing_Order__c2']/div/div")).click();
		driver.findElement(By.xpath("//*[@title='Customer then Neustar']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='slds-form-element']/div/textarea")).sendKeys("eSignature");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(5000);
		//driver.navigate().refresh();
		
		for(int i=1;i<=5;i++) {
			if(c.Details_Status().getText()!="Edit Complete" && c.Contract_Status().getText()!="Edit Complete") {
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
		if(c.Chevron_SubmissionUnderReview().getAttribute("class").contains("active"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		//Details_Status
		System.out.println("Contract Status after Submit for Signature in Details Section = " +c.Details_Status().getText());
		Assert.assertEquals(c.Details_Status().getText(), "Submission Under Review");
		
		//Contract_Status
		System.out.println("Contract Status after Submit for Signature = " +c.Contract_Status().getText());
		Assert.assertEquals(c.Contract_Status().getText(), "Submission Under Review");
		
		c.Related_Tab().click();
		
		//Cases
		c.Cases_Section().click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		try {
			
			List<WebElement> Cases_List = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr/td[3]/span/a[contains(@title,'Contract Submission -- Security')]"));
			int Cases_Count = Cases_List.size();
			System.out.println("Number of Case records when Submit for Signature is done = " + Cases_Count);
			if(Cases_Count == 1) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertFalse(true);
			}
			Thread.sleep(5000);
			c.Case_SubmitForSignature().click();
			Thread.sleep(10000);
			System.out.println(c.Case_Owner().getText());
			Assert.assertEquals("Sales Operations", c.Case_Owner().getText());
			driver.navigate().back();
		}
		catch(Exception e){
			System.out.println("No Case Records");
			Assert.assertFalse(true);
		}
		driver.navigate().back();
		Thread.sleep(10000);
		
	driver.close();
	        
		
	}
}