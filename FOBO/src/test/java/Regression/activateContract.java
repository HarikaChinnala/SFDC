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

	// Attention required
	@Test(priority = 1)
	public void attentionrequired() throws IOException, InterruptedException {
		driver = initialiseDriver();
		landingPage lp = new landingPage(driver);
		contractPage cp = new contractPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", lp.getcontracts());
		Thread.sleep(5000);
		lp.getcontracttxtbox().sendKeys(contractid);
		lp.getcontracttxtbox().sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		// String contractid = prop.getProperty("contractid");
		driver.findElement(By.xpath("//*[@title='" + contractid + "']")).click();
		Thread.sleep(10000);
		type = driver.findElement(By.xpath(
				"//*[@class='test-id__field-label'][starts-with(text(),'Type')]//parent::div/following-sibling::div/span/span"))
				.getText();
		System.out.println(type);
		
		// Contract can't be sent for eSignature after Submit for Signature
		if (cp.Contract_Status().getText().equalsIgnoreCase("Submission Under Review")) {
			cp.getdropdown().click();
			js.executeScript("arguments[0].click();", cp.getesign());
			Thread.sleep(5000);
			try {
				waitForWebElementPresent(driver.findElement(By.xpath("//*[@class='forceVisualMessageQueue']/div/div/div/div/span")));
				System.out.print("Error message for eSignature : ");
				System.out.println(
						driver.findElement(By.xpath("//*[@class='forceVisualMessageQueue']/div/div/div/div/span")).getText());
				
				driver.findElement(By.xpath(
						"//button[@class='slds-button slds-button_icon toastClose slds-notify__close slds-button--icon-inverse slds-button_icon-bare']"))
						.click();
			} catch (Exception e) {
				Assert.assertTrue(false);
			}
		}

		((JavascriptExecutor) driver).executeScript("scroll(0,100);");
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.doubleClick(cp.getstatus()).build().perform();
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("a.select")));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", cp.getARdrop());

		cp.getARcomments().sendKeys(ARcomments);
		Thread.sleep(5000);
		try {
			js.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("(//*[@dir='ltr'][contains(text(),'Save')])[2]")));
		} catch (Exception e) {

			js.executeScript("arguments[0].click();", cp.geteditsave());
		}
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(10000);

		String AR = cp.getARchev().getAttribute("aria-selected");
		if (AR.equals("true")) {
			System.out.println("Contract stage is moved to Attention Required");
		} else
			System.out.println("Contract stage is not moved to Attention Required");

	}

	// Awaiting activation
	@Test(priority = 2)
	public void awaitingactivation() throws IOException, InterruptedException {

		contractPage cp = new contractPage(driver);
		((JavascriptExecutor) driver).executeScript("scroll(0,100);");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		action.doubleClick(cp.getstatus()).build().perform();
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("a.select")));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", cp.getAAdrop());
		js.executeScript("arguments[0].click();", cp.geteditsave());
		Thread.sleep(10000);
		for (int m = 0; m <= 1; m++) {
			driver.navigate().refresh();
			Thread.sleep(10000);

		}

		String AA = cp.getAAchev().getAttribute("aria-selected");
		if (AA.equals("true")) {
			System.out.println("Contract stage is moved to Awaiting Activation");
		} else
			System.out.println("Contract stage is not moved to Awaiting Activation");
	}

	// contract activation
	@Test(priority = 3)
	public void contractactivation() throws IOException, InterruptedException {

		contractPage cp = new contractPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Contract can't be sent for Submit Edit/Submit for Signature when Contract is
		// in Awaiting Activation
		if (cp.Contract_Status().getText().equalsIgnoreCase("Awaiting Activation")) {
			cp.getdropdown().click();
			js.executeScript("arguments[0].click();", cp.SubmitEdit());
			cp.SubmitEditDetails().sendKeys(SubmitEditDetails);
			Thread.sleep(5000);
			cp.Submit_SubmitEdit().click();
			try {
				waitForWebElementPresent(driver.findElement(By.xpath("//*[@class='forceVisualMessageQueue']/div/div/div/div/span")));
				System.out.print("Error message for Submit Edit : ");
				System.out
						.println(driver.findElement(By.xpath("//*[@class='forceVisualMessageQueue']/div/div/div/div/span")).getText());
				driver.findElement(By.xpath(
						"//button[@class='slds-button slds-button_icon slds-modal__close closeIcon slds-button_icon-bare slds-button_icon-inverse']"))
						.click();
			} catch (Exception e) {
				Assert.assertTrue(false);
			}
		}
		Thread.sleep(5000);
		if (cp.Contract_Status().getText().equalsIgnoreCase("Awaiting Activation")) {
			cp.Dropdown().click();
			js.executeScript("arguments[0].click();", cp.SubmitForSignature());
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@id='parent_Signature_Tool__c2']/div/div")).click();
			driver.findElement(By.xpath("//*[@title='Neustar Adobe Signature']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@id='parent_Signing_Order__c2']/div/div")).click();
			driver.findElement(By.xpath("//*[@title='Customer then Neustar']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@class='slds-form-element']/div/textarea")).sendKeys("eSignature");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			try {
				waitForWebElementPresent(driver.findElement(By.xpath("//*[@class='forceVisualMessageQueue']/div/div/div/div/span")));
				System.out.print("Error message for Submit for Signature : ");
				System.out.println(
						driver.findElement(By.xpath("//*[@class='forceVisualMessageQueue']/div/div/div/div/span")).getText());
				driver.findElement(By.xpath(
						"//button[@class='slds-button slds-button_icon slds-modal__close closeIcon slds-button_icon-bare slds-button_icon-inverse']"))
						.click();
			} catch (Exception e) {
				Assert.assertTrue(false);
			}
		}
		Thread.sleep(5000);

		js.executeScript("arguments[0].click();", cp.getActivate());
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", cp.getActivatepopup());
		Thread.sleep(5000);
		// driver.navigate().refresh();
		Thread.sleep(10000);

		String act = cp.getActchev().getAttribute("aria-selected");
		if (act.equals("true")) {
			System.out.println("Contract is Activated");
		} else
			System.out.println("Contract is not Activated");

		if (type.equals("Service Order")) {
			js.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("//*[@class='slds-form-element__control']/div/div/a")));
			Thread.sleep(10000);
			driver.navigate().refresh();
			Thread.sleep(10000);

			String chev = driver.findElement(By.xpath("//*[@title='7 - Won']")).getAttribute("aria-selected");
			if (chev.equals("true")) {
				System.out.println("Opportunity is moved to 7-won stage");
			} else
				System.out.println("Opportunity is not moved to 7-won stage");
		}
		Thread.sleep(3000);
		driver.close();
	
	}
}