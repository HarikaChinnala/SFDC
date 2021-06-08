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
		oppPage op = new oppPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(30000);
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

		if (sellinglane.equals("Risk"))
			driver.findElement(By.xpath("//*[@id='items']/sb-table-row[3]")).click();
		else if (sellinglane.equals("Marketing"))
			driver.findElement(By.xpath("//*[@id='items']/sb-table-row[2]")).click();
		else if (sellinglane.equals("Communications"))
			driver.findElement(By.xpath("//*[@id='items']/sb-table-row[1]")).click();
		else if (sellinglane.equals("Security"))
			driver.findElement(By.xpath("//*[@id='items']/sb-table-row[4]")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		// Thread.sleep(3000);
		Actions act = new Actions(driver);
		// act.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		// js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		int j = driver.findElements(By.xpath("//iframe")).size();
		for (int a = 0; a < j; a++) {
			driver.switchTo().frame(a);
			// WebElement checkbox
			// =driver.findElement(By.xpath("//*[@name='UltraDNS']/sb-swipe-container/div/div/sb-group/div/div/sb-table-cell-select/div/paper-checkbox"));
			// if(driver.findElement(By.xpath("//*[@name='UltraDNS']/sb-swipe-container/div/div/sb-group/div/div/sb-table-cell-select/div/paper-checkbox")).isEnabled()==true){
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

	
	// Marketing products

	else if(productname.equals("AdAdvisor"))

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

	

	Thread.sleep(3000);driver.findElement(By.xpath("//*[@class='style-scope sb-product-config'][text()='Save']")).click();

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
