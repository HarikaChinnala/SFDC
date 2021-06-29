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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

public class productConfiguration extends Base {
	public productConfiguration(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public  WebDriver productConfiguration(String sellinglane, String productname) throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(30000);
//		waitForWebElementPresent(driver.findElement(By.xpath("//*[@name='Add Products']/paper-button")));
		int x = driver.findElements(By.xpath("//iframe")).size();
		for (int i = 0; i < x; i++) {
			driver.switchTo().frame(i);
			try {
				js.executeScript("arguments[0].click();",
						driver.findElement(By.xpath("//*[@name='Add Products']/paper-button")));
			}

			catch (Exception e) {

				driver.switchTo().defaultContent();
			}
		}

		if (sellinglane.equals("Risk")){
			driver.findElement(By.xpath("//*[@id='items']/sb-table-row[3]")).click();
			}
		else if (sellinglane.equals("Marketing")){
			driver.findElement(By.xpath("//*[@id='items']/sb-table-row[2]")).click();
		}
		else if (sellinglane.equals("Communications")){
			driver.findElement(By.xpath("//*[@id='items']/sb-table-row[1]")).click();
			}
		else if (sellinglane.equals("Security")){
			driver.findElement(By.xpath("//*[@id='items']/sb-table-row[4]")).click();
		}
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		// Thread.sleep(3000);
		Actions act = new Actions(driver);
	Thread.sleep(5000);
		int j = driver.findElements(By.xpath("//iframe")).size();
		for (int a = 0; a < j; a++) {
			driver.switchTo().frame(a);
		try {
				try {
					js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@name='" + productname
							+ "']/sb-swipe-container/div/div/sb-group/div/div/sb-table-cell-select/div/paper-checkbox")));
				} catch (Exception ex) {

					act.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
					js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@name='" + productname
							+ "']/sb-swipe-container/div/div/sb-group/div/div/sb-table-cell-select/div/paper-checkbox")));
				}

			} catch (Exception e) {
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
			}

		}

		driver.findElement(By.xpath("//*[text()='Select']")).click();

		Thread.sleep(10000);
		if (sellinglane.equals("Risk")){
		if (productname.equals("Contact Compliance Risk")) {
			driver.findElement(By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input"))
					.sendKeys("5");

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By
					.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Threshold with Overages']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();
			driver.findElement(By.xpath("//*[@name='Change Notification Platform']//sb-group[@id='selection']"))
					.click();
		} else if (productname.equals("Contact Tracing Solutions")) {
			driver.findElement(By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input"))
					.sendKeys("5");

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Custom Billing']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();
			driver.findElement(By.xpath("//*[@name='Change Notification Platform']//sb-group[@id='selection']"))
					.click();

		} else if (productname.equals("Digital Identity Risk Flex")) {
			driver.findElement(By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input"))
					.sendKeys("5");

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Custom Billing']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();
			driver.findElement(By.xpath("//*[@name='Identity Verification (MPIC 3.0)']//sb-group[@id='selection']"))
					.click();

		} else if (productname.equals("Digital Identity Risk Pro")) {
			driver.findElement(By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input"))
					.sendKeys("5");

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Custom Billing']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();
			driver.findElement(By.xpath("//*[@name='Email Attributes']//sb-group[@id='selection']")).click();
		} else if (productname.equals("Domestic Phone Takeover Risk")) {
			driver.findElement(By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input"))
					.sendKeys("5");

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Custom Billing']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();
			driver.findElement(By.xpath("//*[@name='Call Forwarding']//sb-group[@id='selection']")).click();
		} else if (productname.equals("EveryoneAPI")) {
			driver.findElement(By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input"))
					.sendKeys("5");

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Custom Billing']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();
			driver.findElement(By.xpath("//*[@name='Address Attributes']//sb-group[@id='selection']")).click();
		} else if (productname.equals("Inbound Authentication")) {
			driver.findElement(By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input"))
					.sendKeys("5");

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Custom Billing']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();

			driver.findElement(By.xpath("//*[@label='ACV Usage']/div/div/sb-field/span/div/sb-input")).sendKeys("5");

			driver.findElement(By.xpath("//*[@name='Setup Fee']//sb-group[@id='selection']")).click();
		} else if (productname.equals("Initial Account Database Processing - Authentication")) {
			js.executeScript("arguments[0].value='5';", driver.findElement(
					By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input")));

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Custom Billing']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();
			driver.findElement(By.xpath("//*[@name='Overage Rate']//sb-group[@id='selection']")).click();

		} else if (productname.equals("Initial Account Database Processing - Compliance")) {
			js.executeScript("arguments[0].value='5';", driver.findElement(
					By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input")));

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Custom Billing']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();
			driver.findElement(By.xpath("//*[@name='Overage Rate']//sb-group[@id='selection']")).click();
		} else if (productname.equals("Initial Account Database Processing - Customer Operations")) {
			js.executeScript("arguments[0].value='5';", driver.findElement(
					By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input")));

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Custom Billing']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();
			driver.findElement(By.xpath("//*[@name='Overage Rate']//sb-group[@id='selection']")).click();

		} else if (productname.equals("International Phone Takeover Risk")) {
			js.executeScript("arguments[0].value='5';", driver.findElement(
					By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input")));

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Custom Billing']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();
			driver.findElement(By
					.xpath("//*[@name='Carrier Change Information (International & Domestic)']//sb-group[@id='selection']"))
					.click();

		} else if (productname.equals("Insight Engine - SmartDial")) {
			js.executeScript("arguments[0].value='5';",driver.findElement(By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input")));

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By
					.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Threshold with Overages']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();

		} else if (productname.equals("iTact")) {
			js.executeScript("arguments[0].value='5';",driver.findElement(By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input")));

			driver.findElement(By.xpath("//*[@name='Overage Rate']//sb-group[@id='selection']")).click();

		} else if (productname.equals("iTact (per seat pricing)")) {
			driver.findElement(By.xpath("//*[@name='Overage Rate']//sb-group[@id='selection']")).click();

		} else if (productname.equals("Phone Behavior Intelligence")) {
			js.executeScript("arguments[0].value='5';", driver.findElement(
					By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input")));

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Custom Billing']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();
			driver.findElement(By.xpath("//*[@name='Change Notification Platform']//sb-group[@id='selection']"))
					.click();

		} else if (productname.equals("Risk - Custom Solution - Authentication")) {
			js.executeScript("arguments[0].value='5';", driver.findElement(
					By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input")));

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By
					.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Threshold with Overages']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();
			driver.findElement(By.xpath("//*[@name='Overage Rate']//sb-group[@id='selection']")).click();

		} else if (productname.equals("Risk - Custom Solution - Compliance")) {
			js.executeScript("arguments[0].value='5';", driver.findElement(
					By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input")));
			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By
					.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Threshold with Overages']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();
			driver.findElement(By.xpath("//*[@name='Overage Rate']//sb-group[@id='selection']")).click();
		} else if (productname.equals("Risk - Custom Solution - Customer Operations")) {
			js.executeScript("arguments[0].value='5';", driver.findElement(
					By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input")));

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By
					.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Threshold with Overages']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();
			driver.findElement(By.xpath("//*[@name='Overage Rate']//sb-group[@id='selection']")).click();
		} else if (productname.equals("SmartTrace")) {
			// driver.findElement(By.xpath("//*[@label='Scope of Records
			// (Millions)']/div/div/sb-field/span/div/sb-input")).click();
			js.executeScript("arguments[0].value='5';", driver.findElement(
					By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input")));

			driver.findElement(By
					.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By
					.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Threshold with Overages']"))
					.click();

			driver.findElement(By
					.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
					.click();
			driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
					.click();
			driver.findElement(By.xpath("//*[@name='Phone Attributes']//sb-group[@id='selection']")).click();

		}

	} 
	// Marketing products
		else if (sellinglane.equals("Marketing")){
	 if(productname.equals("AdAdvisor"))

	{
		driver.findElement(By
				.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
				.click();
	}
	else if(productname.equals("Customer Identity File (CIF)"))
	{
		driver.findElement(By
				.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly PreBill']"))
				.click();

		driver.findElement(By
				.xpath("//*[@label='Geography']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Basic State']")).click();

		driver.findElement(By
				.xpath("//*[@label='File Attributes']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='PII Only']")).click();

		driver.findElement(By.xpath("//*[@id='offRadio']")).click();

	}
	else if(productname.equals("Customer Identity Management (CIM)"))
	{
		driver.findElement(By
				.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(
				By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Threshold with Overages']"))
				.click();

		driver.findElement(By
				.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
				.click();

		driver.findElement(
				By.xpath("//*[@name='Initial Database Processing (Up Front Scrub)']//sb-group[@id='selection']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By
				.xpath("//*[@id='swipe-header']//*[@class='td sb-action-icon sf-icon-custom_apps   --desktop  style-scope sb-actions']"))
				.click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input"))
				.sendKeys("5");
		driver.findElement(By
				.xpath("//*[@label='Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='1']")).click();

		driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();
		Thread.sleep(10000);

	}
	else if(productname.equals("ElementOne Analytics"))
	{
		driver.findElement(By
				.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly PreBill']"))
				.click();
		js.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//*[@name='Users (5)']//sb-group[@id='selection']")));

	}
	else if(productname.equals("Financial Spectrum"))
	{
		driver.findElement(By
				.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly PreBill']"))
				.click();
		driver.findElement(
				By.xpath("//*[@name='AdAdvisor Audience (Stand Alone or with DMP)']//sb-group[@id='selection']"))
				.click();

	}
	else if(productname.equals("Identity Data Management Platform (IDMP)"))
	{
		driver.findElement(By
				.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
				.click();
		driver.findElement(By.xpath("//*[@name='Package D - Up to 3B Impressions']//sb-group[@id='selection']"))
				.click();
		driver.findElement(
				By.xpath("//*[@class='td sb-action-icon sf-icon-custom_apps   --desktop  style-scope sb-actions']"))
				.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@name='Data Feeds (Per Month)']//sb-group[@id='selection']")).click();
		driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();

		Thread.sleep(10000);
	}
	else if(productname.equals("Omni Channel Remarketing"))
	{
		driver.findElement(By
				.xpath("//*[@label='Use Case']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Direct to Advertiser']"))
				.click();

		driver.findElement(By
				.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
				.click();
		driver.findElement(By.xpath("//*[@name='Pilot']//sb-group[@id='selection']")).click();
	}
	else if(productname.equals("Onboarding"))
	{
		driver.findElement(By
				.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
				.click();

		driver.findElement(
				By.xpath("//*[@name='Package A (Up to 20M Input Records / Month)']//sb-group[@id='selection']"))
				.click();
		driver.findElement(
				By.xpath("//*[@class='td sb-action-icon sf-icon-custom_apps   --desktop  style-scope sb-actions']"))
				.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();
		Thread.sleep(10000);

	}
	else if(productname.equals("Other Identity Data"))
	{
		driver.findElement(By
				.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly PreBill']"))
				.click();
		driver.findElement(By.xpath("//*[@name='US Cons. Enh.']//sb-group[@id='selection']")).click();

	}
	else if(productname.equals("RealTime Identity"))
	{
		js.executeScript("arguments[0].value='5';",driver.findElement(By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input")));
		driver.findElement(By
				.xpath("//*[@label='Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='1']")).click();

		driver.findElement(By
				.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
				.click();

		driver.findElement(By.xpath("//*[@name='Verification and Identification']//sb-group[@id='selection']")).click();
		Thread.sleep(2000);

	}
	else if(productname.equals("Realtime Website Personalizations"))
	{
		driver.findElement(By
				.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
				.click();
		driver.findElement(By.xpath("//*[@name='Package A (Up to 12M Queries / Year)']//sb-group[@id='selection']"))
				.click();
		driver.findElement(
				By.xpath("//*[@class='td sb-action-icon sf-icon-custom_apps   --desktop  style-scope sb-actions']"))
				.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();

		Thread.sleep(30000);

	}
	else if(productname.equals("Unified Analytics - MMM"))
	{
		driver.findElement(By
				.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
				.click();
		driver.findElement(By.xpath("//*[@id='offRadio']")).click();

	}
	else if(productname.equals("Unified Analytics - MTA"))
	{
		driver.findElement(By
				.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']"))
				.click();
		driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']"))
				.click();

	}
		}
		else if (sellinglane.equals("Communications")){
			//communication products
	/*1*/	if(productname.equals("Branded Call Display")) {
				
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
				
				driver.findElement(By.xpath("//*[@name='Platform Fee']//sb-group[@id='selection']")).click();
				
			}
			
	/*2*/	else if(productname.equals("Branded Call Display and Caller Name Optimization Combo")) {
				
				//Configure Branded Call Display
				driver.findElement(By.xpath("//*[@name='Branded Call Display']//span[@class='td sb-action-icon sf-icon-custom_apps   --desktop  style-scope sb-actions']")).click();
				Thread.sleep(10000);
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
				
				driver.findElement(By.xpath("//*[@name='Platform Fee']//sb-group[@id='selection']")).click();
				
				driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();
				
				Thread.sleep(10000);
				
				//Configure Caller Name Optimization
				driver.findElement(By.xpath("//*[@name='Caller Name Optimization']//span[@class='td sb-action-icon sf-icon-custom_apps   --desktop  style-scope sb-actions']")).click();
				Thread.sleep(10000);
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
				
				driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();
				
				Thread.sleep(10000);
				
			}
			
	/*3*/	else if(productname.equals("CNO/BCD/ECC Combo")) {
				
				//Configure Caller Name Optimization
				driver.findElement(By.xpath("//*[@name='Caller Name Optimization']//span[@class='td sb-action-icon sf-icon-custom_apps   --desktop  style-scope sb-actions']")).click();
				Thread.sleep(10000);
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
		
				driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();
				Thread.sleep(10000);
				
				//Configure Branded Call Display
				driver.findElement(By.xpath("//*[@name='Branded Call Display']//span[@class='td sb-action-icon sf-icon-custom_apps   --desktop  style-scope sb-actions']")).click();
				Thread.sleep(10000);
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
				
				driver.findElement(By.xpath("//*[@name='Platform Fee']//sb-group[@id='selection']")).click();
				
				driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();
				Thread.sleep(10000);
				
				//Configure Enterprise Certified Caller
				driver.findElement(By.xpath("//*[@name='Enterprise Certified Caller']//span[@class='td sb-action-icon sf-icon-custom_apps   --desktop  style-scope sb-actions']")).click();
				Thread.sleep(10000);
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
		
				driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();
				Thread.sleep(10000);
				
			}
			
	/*4*/	else if(productname.equals("Caller ID (CNAM)")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
				
				driver.findElement(By.xpath("//*[@id='radioContainer'][1]")).click();
				driver.findElement(By.xpath("//*[@name='Storage and Delivery']//span[@class='td sb-action-icon sf-icon-custom_apps   --desktop  style-scope sb-actions']")).click();
				
				driver.findElement(By.xpath("//*[@name='Access Fee (Monthly Minimum)']//sb-group[@id='selection']")).click();
				
				driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();
				Thread.sleep(10000);
				
			}
			
	/*5*/	else if(productname.equals("Caller Name Optimization")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
		
			}
			
	/*6*/	else if(productname.equals("Certified Caller")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
		
				driver.findElement(By.xpath("//*[@name='Standalone (Premises) - Perpetual']//sb-group[@id='selection']")).click();
				
			}
			
	/*7*/	else if(productname.equals("Communications Professional Services")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();

				driver.findElement(By.xpath("//*[@name='e911 Audit']//sb-group[@id='selection']")).click();
				
			}
			
	/*8*/	else if(productname.equals("Directory Listings")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
				
				driver.findElement(By.xpath("//*[@name='Directory Listings - Band 1']//sb-group[@id='selection']")).click();
		
			}
			
	/*9*/	else if(productname.equals("Enterprise Certified Caller")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();

			}
			
	/*10*/	else if(productname.equals("Global Numbering Intelligence Services (GNIS)")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
				
			}
			
	/*11*/	else if(productname.equals("Hosted OMS")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
				
				driver.findElement(By.xpath("//*[@name='ESR Commercial']//sb-group[@id='selection']")).click();
				driver.findElement(By.xpath("//*[@name='ESR Commercial']//span[@class='td sb-action-icon sf-icon-custom_apps   --desktop  style-scope sb-actions']")).click();
				driver.findElement(By.xpath("//*[@name='Per Trading Partner Configuration']//sb-group[@id='selection']")).click();
				
				driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();
				Thread.sleep(10000);
				
			}
			
	/*12*/	else if(productname.equals("Licensed OMS")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
		
				driver.findElement(By.xpath("//*[@name='NumeriTrack']//sb-group[@id='selection']")).click();

			}
			
	/*13*/	else if(productname.equals("Localeze")) {
		
				driver.findElement(By.xpath("//*[@name='Business Registry Manager Service (BRM) - Monthly']//div[@id='radioContainer']")).click();
				driver.findElement(By.xpath("//*[@name='Business Registry Manager Service (BRM) - Monthly']//span[@class='td sb-action-icon sf-icon-custom_apps   --desktop  style-scope sb-actions']")).click();
		
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
		
				driver.findElement(By.xpath("//*[@label='Monthly Minimum Listing Volume #']//input[@type='text']")).sendKeys("1");
				driver.findElement(By.xpath("//*[@label='Monthly Minimum Fee $']//input[@type='text']")).sendKeys("1");
		
		
				driver.findElement(By.xpath("//*[@name='Monthly Minimum Listings Commitment']//sb-group[@id='selection']")).click();
		
				driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();
				Thread.sleep(10000);
		
			}
			
	/*14*/	else if(productname.equals("Neustar Certificate Manager")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
		
				driver.findElement(By.xpath("//*[@name='Certificate Authority']//sb-group[@id='selection']")).click();
		
			}
			
	/*15*/	else if(productname.equals("Pathfinder")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
		
				driver.findElement(By.xpath("//*[@name='Setup Fee']//sb-group[@id='selection']")).click();
				driver.findElement(By.xpath("//*[@id='radioContainer'][1]")).click();
				driver.findElement(By.xpath("//*[@name='Country Transaction - Onboard US']//sb-group[@id='selection']")).click();
		
			}
			
	/*16*/	else if(productname.equals("PortPS")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();

				driver.findElement(By.xpath("//*[@name='Query Manager']//sb-group[@id='selection']")).click();
				driver.findElement(By.xpath("//*[@name='Query Manager']//span[@class='td sb-action-icon sf-icon-custom_apps   --desktop  style-scope sb-actions']")).click();
				driver.findElement(By.xpath("//*[@label='Customers TN Ownership (Millions)']//input[@type='text']")).sendKeys("1");
				driver.findElement(By.xpath("//*[@label='Max Seats']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='5']")).click();
				driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();
				Thread.sleep(10000);
				
			}
			
	/*17*/	else if(productname.equals("PortPS RIMS")) {
				driver.findElement(By.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Threshold with Overages']")).click();
		
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();

				driver.findElement(By.xpath("//*[@name='RIMS - API Only']//sb-group[@id='selection']")).click();

			}
			
	/*18*/	else if(productname.equals("Robocall Mitigation")) {
				js.executeScript("arguments[0].value='5';", driver.findElement(By.xpath("//*[@label='Scope of Records (Millions)']/div/div/sb-field/span/div/sb-input")));
		
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
		
			}
			
	/*19*/	else if(productname.equals("SIP-IX")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
		
				driver.findElement(By.xpath("//*[@id='radioContainer'][1]")).click();
				driver.findElement(By.xpath("//*[@name='SIP-IX Subscribe Interface - Contract One']//span[@class='td sb-action-icon sf-icon-custom_apps   --desktop  style-scope sb-actions']")).click();
				driver.findElement(By.xpath("//*[@id='radioContainer'][1]")).click();
				driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();
				Thread.sleep(10000);
		
			}
			
	/*20  -	else if(productname.equals("System Admin Guides")) {
			}*/
		
	/*21*/	else if(productname.equals("Trusted Call Vetting")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
				driver.findElement(By.xpath("//*[@name='Enterprise Vetting']//sb-group[@id='selection']")).click();
		
			}
			
			}
		else if (sellinglane.equals("Security")){
			//Security products
	/*1*/	if(productname.equals("DNS Audit")) {
				
				driver.findElement(By.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Threshold with Overages']")).click();
				
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
				
			}
			
	/*2*/	else if(productname.equals("InfoBlox")) {
				
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly PreBill']")).click();
				
			}
			
	/*3*/	else if(productname.equals("IP Intelligence")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
		
			}
			
	/*4*/	else if(productname.equals("Security Professional Services")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='One-time PreBill']")).click();
				
			}
			
	/*5*/	else if(productname.equals("Threat Feeds")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly PreBill']")).click();
		
			}
			
	/*6*/	else if(productname.equals("UltraDDoS Protect")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly PreBill']")).click();
				
			}
			
	/*7*/	else if(productname.equals("UltraDNS")) {
				Thread.sleep(5000);
//				driver.findElement(By.xpath("//div[@class='tab-content style-scope paper-tab'][text()='Dedicated Resolvers']")).click();
//				driver.findElement(By.xpath("//*[@id='radioContainer']")).click();
				
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
	
			}
			
	/*8*/	else if(productname.equals("UltraDNS Firewall")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly PreBill']")).click();
				
			}
			
	/*9*/	else if(productname.equals("Valimail")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly PreBill']")).click();

			}
			
	/*10*/	else if(productname.equals("Web Performance Monitoring")) {
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Arrears']")).click();
				
			}
			
	/*11*/	else if(productname.equals("Webmetrics")) {
				driver.findElement(By.xpath("//*[@label='Billing Option']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Monthly Threshold with Overages']")).click();
		
				driver.findElement(By.xpath("//*[@label='Billing Frequency']/div/div/sb-field/span/div/sb-select/select[@class='myselect style-scope sb-select --desktop']")).click();
				driver.findElement(By.xpath("//option[@class='sbOption style-scope sb-select'][@title='Annual PreBill']")).click();
				
			}
		}
		
	if(!productname.equals("System Admin Guides")) {
		Thread.sleep(3000);driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();
	}
	if(productname.equalsIgnoreCase("UltraDNS Firewall")) {
		driver.findElement(By.xpath("//*[text()='Continue']")).click();
	}
	
	Thread.sleep(5000);

	js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@name='Quick Save']/paper-button")));Thread.sleep(30000);

	// SAVE
	js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@name='Save']/paper-button")));
	try{
	// driver.navigate().refresh();
	Thread.sleep(30000);js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@name='Save']/paper-button")));}
	catch(Exception exc)
	{
		Thread.sleep(1000);
		driver.switchTo().defaultContent();

	}driver.navigate().refresh();
	Thread.sleep(10000);
//	driver.close();
	return driver;

	}

	
}
