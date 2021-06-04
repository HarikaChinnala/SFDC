package Regression;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.Alert;

import Pageobjects.accountPage;
import Pageobjects.amendmentOpportunityPage;
import Pageobjects.contractPage;
import Pageobjects.createLeadPage;
import Pageobjects.createOppPage;
import Pageobjects.createQuotePage;
import Pageobjects.landingPage;
import Pageobjects.loginPageObject;
import Regression.Base;

public class createAmendmentOpportunity extends Base {
	//public String amendurl;
	@Test
	public void createAmendmentOpportunity() throws IOException, InterruptedException {
		
		driver = initialiseDriver();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
		driver.get(contracturl);
		amendmentOpportunityPage ao = new amendmentOpportunityPage(driver);
		Actions a = new Actions(driver);
		
		Thread.sleep(20000);

		ao.AmendButton().click();
		
		Thread.sleep(60000);

		int x = driver.findElements(By.xpath("//iframe")).size();
		// System.out.println(x);
		for (int j = 0; j < x; j++) {
			driver.switchTo().frame(j);
			try {
				ao.Amend().click();
			}

			catch (Exception e) {
				
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
			}
			driver.switchTo().defaultContent();
		}
		
		Thread.sleep(60000);

		int x1 = driver.findElements(By.xpath("//iframe")).size();
		// System.out.println(x1);
		for (int j = 0; j < x1; j++) {
			driver.switchTo().frame(j);
			try {
				ao.Toggle().click();
			}

			catch (Exception e) {
				
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
			}
			driver.switchTo().defaultContent();
		}

		int x2 = driver.findElements(By.xpath("//iframe")).size();
		// System.out.println(x2);
		for (int j = 0; j < x2; j++) {
			driver.switchTo().frame(j);

			try {
				Thread.sleep(5000);
				ao.Clone().click();
				// System.out.println(driver.switchTo().alert().getText());
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				Thread.sleep(5000);
			}

			catch (Exception e) {
				
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
			}
			driver.switchTo().defaultContent();
		}
		

		int y = driver.findElements(By.xpath("//iframe")).size();
		// System.out.println(y);
		for (int j = 0; j < y; j++) {
			driver.switchTo().frame(j);
			// System.out.println("switched to frame : " +j);
			try {
				driver.findElement(By.xpath(
						"(//button[@id='actionButton1'])[1]//parent::sf-line-actions//parent::div//following-sibling::div[5]"))
						.click();
				driver.findElement(By.xpath(
						"(//button[@id='actionButton1'])[1]//parent::sf-line-actions//parent::div//following-sibling::div[5]/div/span"))
						.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(
						"//input[@class='myinput numberInput style-scope sb-input --desktop style-scope sf-le-table-row']"))
						.sendKeys("" + 0);

				
				a.sendKeys(Keys.ENTER).build().perform();

				// System.out.println(driver.switchTo().alert().getText());
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				Thread.sleep(5000);
			}

			catch (Exception e) {
				
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
			}
			driver.switchTo().defaultContent();
		}

		int z = driver.findElements(By.xpath("//iframe")).size();
		// System.out.println(x);
		for (int j = 0; j < z; j++) {
			driver.switchTo().frame(j);

			try {
				driver.findElement(By.xpath("//span[@class='sf-icon-chevronright style-scope sb-line-editor']"))
						.click();
				driver.findElement(By.xpath(
						"//div[@id='item'][contains(text(),'Subscription Term')]//parent::div/div/sb-field/span/div/sb-input/input[@type='text']"))
						.sendKeys("" + 24);
				// driver.findElement(By.xpath("//*[contains(text(),'Quick Save')]")).click();
				Thread.sleep(10000);
				// driver.findElement(By.xpath("//*[@name='Save']")).click();

				driver.findElement(By.xpath("//*[@name='Save']/paper-button")).click();
				Thread.sleep(10000);
			}

			catch (Exception e) {
				
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
			}
			driver.switchTo().defaultContent();
		}
		Thread.sleep(20000);

		driver.navigate().refresh();
		Thread.sleep(20000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		createQuotePage qp = new createQuotePage(driver);

		js.executeScript("arguments[0].click();", qp.getGenquoteprop());
		Thread.sleep(60000);
		 
		int k = driver.findElements(By.xpath("//iframe")).size();
		//System.out.println("k="+k);
		for (int b = 0; b < k; b++) {
			driver.switchTo().frame(b);
			//System.out.println("b="+b);
			try {
				driver.findElement(By.xpath("//*[@class='x-box-inner ']/div/a/span/span/span[contains(text(),'Continue')]")).click();
			} catch (Exception e) {
				
				int m = driver.findElements(By.xpath("//iframe")).size();
				//System.out.println("m="+m);
				if (m > 0) {
					for (int c = 0; c < m; c++) {
						driver.switchTo().frame(c);
						//System.out.println("c="+c);
						try {
							driver.findElement(By.xpath("//*[@class='x-box-inner ']/div/a/span/span/span[contains(text(),'Continue')]")).click();
						} catch (Exception ex) {
						
							int n = driver.findElements(By.xpath("//iframe")).size();
							//System.out.println("n="+n);
							if (n > 0) {
								for (int d = 0; d < n; d++) {
									driver.switchTo().frame(d);
									//System.out.println("d="+d);
									try {
										driver.findElement(By.xpath("//*[@class='x-box-inner ']/div/a/span/span/span[contains(text(),'Continue')]")).click();
									} catch (Exception exc) {
										
										driver.switchTo().defaultContent();
									}
								}
							} else {
								driver.switchTo().defaultContent();
							}
						}
					}
				} else {
					driver.switchTo().defaultContent();
				}
			}
		}

		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		Thread.sleep(20000);
		
		js.executeScript("arguments[0].click();", qp.getRelated());
		Thread.sleep(10000);
	
		a.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(10000);
		
		String file = qp.getFiles().getAttribute("title");
		if (file.startsWith("Quote Proposal -"))
			System.out.println("File is attached");
		else
			System.out.println("File is not attached");

		qp.getdropdown().click();
		Thread.sleep(5000);
		// qp.getsubmitapproval().click();
		//js.executeScript("arguments[0].click();", qp.getsubmitapproval());
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@name='Submit_for_Approval']")));
		Thread.sleep(20000);

		String app = qp.getapproved().getAttribute("aria-selected");
		System.out.println(app);
		if (app.equals("true")) {
			System.out.println("Quote is approved");
		} else
			System.out.println("Quote is not approved");
		
		
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'Amendment for contract #"
				+ contractid
				+ "')]")));
		Thread.sleep(5000);
		//to be sent to data.prop file
		
		String amendurl=driver.getCurrentUrl();
		System.out.println("Amendment Opportunity url:"+amendurl);
		prop.setProperty("amendurl", amendurl);
		try (final OutputStream outputstream = new FileOutputStream(
				"C://Users//966790//git//newrepo//FOBO//src//main//java//Regression//data.properties");) {
			prop.store(outputstream, "File Updated");
			outputstream.close();
		}
		
		
driver.navigate().refresh();
//		driver.get(amendurl);
		Thread.sleep(15000);
	 	//opportunity type	
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		((JavascriptExecutor)driver).executeScript("scroll(0,500);");
	 		a.doubleClick(driver.findElement(By.xpath("(//*[contains(text(),'Opportunity Type')]//parent::div)/following-sibling::div"))).build().perform();;
		Thread.sleep(10000);
		//js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//*[contains(text(),'Opportunity Type')]//parent::label)/following-sibling::div")));
		WebElement opp=driver.findElement(By.xpath("(//*[contains(text(),'Opportunity Type')]//parent::label)/following-sibling::div[1]/lightning-base-combobox/div/div[1]/input"));
//		js.executeScript("arguments[0].scrollTo();",opp);
		//opp.click();
		js.executeScript("arguments[0].click();", opp);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//*[contains(text(),'Opportunity Type')]//parent::label)/following-sibling::div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[@data-value='Upgrade']")));	
		Thread.sleep(1000);
		
		//product/usecase
		//js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//*[contains(text(),'Product / Use Case')]//parent::label)/following-sibling::div")));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//*[contains(text(),'Product / Use Case')]//parent::label)/following-sibling::div[1]/lightning-base-combobox/div/div[1]/input")));
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//*[contains(text(),'Product / Use Case')]//parent::label)/following-sibling::div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[@data-value='DNS']")));
		Thread.sleep(1000);
		
	 		//service date
		//js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//*[contains(text(),'Service Order Date')]//parent::label)/following-sibling::div")));
		WebElement serv=driver.findElement(By.xpath("(//*[contains(text(),'Service Order Date')]//parent::label)/following-sibling::div/input"));
//		js.executeScript("arguments[0].scrollIntoView();",serv);
		js.executeScript("arguments[0].click();", serv);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@name='today']")));
		Thread.sleep(5000);
		
	 		//foundbychannel
		WebElement foundbychannel= driver.findElement(By.xpath("(//*[contains(text(),'Found by Channel?')]//parent::label)/following-sibling::div[1]/lightning-base-combobox/div/div[1]/input"));
//		js.executeScript("arguments[0].scrollIntoView();",foundbychannel);
		if(foundbychannel.isEnabled()){
		//js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//*[contains(text(),'Found by Channel?')]//parent::label)/following-sibling::div")));
			js.executeScript("arguments[0].click();",foundbychannel);
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//*[contains(text(),'Found by Channel?')]//parent::label)/following-sibling::div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[@data-value='No']")));		
		}Thread.sleep(5000);
		
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@name='SaveEdit']")));
		Thread.sleep(5000);
		
		driver.close();
	}
}