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

 

public class amendmentSubmitForSignature extends Base {

 

    @Test
    public void amendmentSubmitForSignature() throws IOException, InterruptedException
    {
        
        driver= initialiseDriver();
        
        contractPage c= new contractPage(driver);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        
        driver.get(amendurl);
        Thread.sleep(15000);
        js.executeScript("window.scrollBy(0,1300)", "");
        Actions act = new Actions(driver);
        
        driver.findElement(By.xpath("//*[text() = 'Billing Contact']//parent::div//following-sibling::div/button")).click();
        Thread.sleep(5000);
        
        Thread.sleep(10000);
        WebElement bc=driver.findElement(By.xpath("//*[text() = 'Billing Contact']//parent::lightning-grouped-combobox//following-sibling::div/div/lightning-base-combobox/div/div/input"));
       String bcvalue= bc.getAttribute("placeholder");
       if(bcvalue.equals("Search Contacts...")){
        bc.sendKeys(primarycontact);
      
       
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//*[text() = 'Billing Contact']//parent::lightning-grouped-combobox//following-sibling::div/div/lightning-base-combobox/div/div/ul/li/lightning-base-combobox-item/span/span/lightning-base-combobox-formatted-text[@title='"
                + primarycontact
                + "']")).click();
       }
        driver.findElement(By.xpath("//button[text() = 'Save']")).click();
        Thread.sleep(20000);
        driver.navigate().refresh();
        Thread.sleep(15000);
        
        driver.findElement(By.xpath("//span[contains(text(),'Show more actions')]//parent::button")).click(); // Changed
        Thread.sleep(5000);
        
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text() = 'Submit For Signature']")));
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
        Thread.sleep(10000);
        //driver.navigate().refresh();
        
        oppPage op = new oppPage(driver);
        String status = op.getAmendcontractstatus().getText();
        System.out.println(status);
        Assert.assertEquals(op.getAmendcontractstatus().getText(), "Submission Under Review");
        
        Thread.sleep(5000);
        if(driver.findElement(By.xpath("//*[@data-name='6 - Ops Review']")).getAttribute("class").contains("active"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
        
        driver.findElement(By.xpath("//*[text()='Related']")).click(); // Tag name changed
        Thread.sleep(10000);

 

        // Cases
        js.executeScript("window.scrollBy(0,150)", "");
        
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@class='rlql-toggle slds-text-align_center']/a[contains(text(),'Show All')]"))
                .click();
        act.moveByOffset(10, 0).build().perform();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[contains(text(),'Cases')]//parent::a")).click();

 

        Thread.sleep(10000);
        driver.navigate().refresh();
        try {
            List<WebElement> Cases_List = driver.findElements(
                    By.xpath("//table[@role='grid']/tbody/tr/td[3]/span/span[contains(text(),'Contract Submission')]"));
            int Cases_Count = Cases_List.size();
            System.out.println("Number of Case records when Submit Edit is done = " + Cases_Count);
            if (Cases_Count == 1) {
                Assert.assertTrue(true);
            } else {
                Assert.assertFalse(true);
            }
            Thread.sleep(5000);
            driver.findElement(By.xpath(
                    "//table[@role='grid']/tbody/tr/td[3]/span/span[contains(text(),'Contract Submission')]/parent::span/parent::td/preceding-sibling::th/span/a"))
                    .click();
            Thread.sleep(10000);
            System.out.println(c.Case_Owner().getText());
            Assert.assertEquals("Sales Operations", c.Case_Owner().getText());
            driver.navigate().back();
        } catch (Exception e) {
        	
            System.out.println("No Case Records");
            Assert.assertFalse(true);
        }

 

        driver.navigate().back();
        Thread.sleep(10000);
        
 driver.close();
            
        
    }
}