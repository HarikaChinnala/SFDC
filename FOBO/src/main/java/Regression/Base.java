package Regression;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import Pageobjects.loginPageObject;
import junit.framework.Assert;

public class Base {
	
	
	public WebDriver driver;
	
	protected String userid;
	protected String userid1;
	protected String contracturl;
	protected String contractid;
	protected String ARcomments;
	protected String NewAccountname;
	protected String websitename;
	protected String existingaccountname;
	protected String firstname1;
	protected String lastname1;
	protected String email1;
	protected String Accountname1;
	protected String country;
	protected String newfirstname;
	protected String existingcontactname;
	protected String firstname;
	protected String lastname;
	protected String email;
	protected String company;
	protected String phone;
	protected String website;
	protected String street;
	protected String city;
	protected String state;
	protected String postalcode;
	protected String Accountname;
	protected String currency;
	protected String opportunityname;
	protected String opptype;
	protected String pilotvalue;
	protected String sellinglane;
	protected String usecase;
	protected String entity;
	protected String primarycontact;
	protected String foundbychannel;
	protected String existquote;
	protected String RNperiod;
	protected String OppName;
	protected String amendurl;
	protected String ApprovalComments;
	protected String SubmitEditDetails;
	protected String usernameadmin;
	protected String pwd;

	//private Properties configProp;
	
	public WebDriver initialiseDriver() throws IOException, InterruptedException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//966790//git//newrepo//FOBO//src//main//java//Regression//data.properties");
		prop.load(fis);
		
    	String browserName = prop.getProperty("browser");
    	System.out.println(browserName);
    	if (browserName.equals("chrome"))
    	{
    		ChromeOptions opt = new ChromeOptions();
    		opt.addArguments("--disable-notifications");
    		opt.addArguments("--disable-web-security");
    		System.setProperty("webdriver.chrome.driver", "C://Users//966790//chromedriver//chromedriver.exe");
    		driver = new ChromeDriver(opt);
    		
    	}
    	else if (browserName.equals("firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver","C://Users//966790//geckodriver.exe");
    		driver = new FirefoxDriver();
    	}
    	else if (browserName.equals("IE"))
    	{
    		//exceute in IE
    	}
    
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
    	driver.get(prop.getProperty("url"));
		loginPageObject l = new loginPageObject(driver);
		l.getusername().sendKeys(prop.getProperty("username"));
		l.getpassword().sendKeys(prop.getProperty("pwd"));
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
		Thread.sleep(2000);
		userid=prop.getProperty("userid");
		userid1=prop.getProperty("userid1");
		contracturl=prop.getProperty("contracturl");
		contractid=prop.getProperty("contractid");
		ARcomments=prop.getProperty("ARcomments");
		NewAccountname=prop.getProperty("NewAccountname");
		websitename=prop.getProperty("websitename");
		existingaccountname=prop.getProperty("existingaccountname");
		firstname1=prop.getProperty("firstname1");
		lastname1=prop.getProperty("lastname1");
		email1=prop.getProperty("email1");
		Accountname1=prop.getProperty("Accountname1");
		country=prop.getProperty("country");
		newfirstname=prop.getProperty("newfirstname");
		existingcontactname=prop.getProperty("existingcontactname");
		firstname=prop.getProperty("firstname");
		lastname=prop.getProperty("lastname");
		email=prop.getProperty("email");
		company=prop.getProperty("company");
		phone=prop.getProperty("phone");
		website=prop.getProperty("website");
		street=prop.getProperty("street");
		city=prop.getProperty("city");
		state=prop.getProperty("state");
		postalcode=prop.getProperty("postalcode");
		Accountname=prop.getProperty("Accountname");
		opportunityname=prop.getProperty("opportunityname");
		currency=prop.getProperty("currency");
		opptype=prop.getProperty("opptype");
		pilotvalue=prop.getProperty("pilotvalue");
		sellinglane=prop.getProperty("sellinglane");
		usecase=prop.getProperty("usecase");
		entity=prop.getProperty("entity");
		primarycontact=prop.getProperty("primarycontact");
		foundbychannel=prop.getProperty("foundbychannel");
		existquote=prop.getProperty("existquote");
		RNperiod=prop.getProperty("RNperiod");
		OppName=prop.getProperty("OppName");
		amendurl=prop.getProperty("amendurl");
		ApprovalComments=prop.getProperty("ApprovalComments");
		SubmitEditDetails=prop.getProperty("SubmitEditDetails");
		usernameadmin=prop.getProperty("usernameadmin");
		pwd=prop.getProperty("pwd");
		return driver;
		
	}
	/*public void setProperty(String key, String value){
		  prop.setProperty(key, value);
		}
		 
		public void flush() throws FileNotFoundException, IOException {
		    try (final OutputStream outputstream 
		                = new FileOutputStream("data.properties");) {
		        prop.store(outputstream,"File Updated");
		        outputstream.close();
		    }*/
		}
	
	
	



