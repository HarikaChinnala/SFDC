package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contractPage {
	
@FindBy(xpath="//*[contains(@title,'more actions')]")
public WebElement dropdown;

@FindBy(xpath="//*[@class='forceActionLink'][@title='eSignature']")
public WebElement esign;

@FindBy(xpath="//*[@class='forceActionLink'][@title='Generate Documents']")
public WebElement GenerateDoc;

@FindBy(xpath="((((((//*[@title='Files'])/parent::a)/parent::h2)/parent::div)/parent::header)/parent::div)/following-sibling::div/div/div/div/div/div/div[2]/ul/li/a")
public WebElement Files;
	
@FindBy(xpath="//*[@title='Activate']")
public WebElement Activate;

@FindBy(xpath="//*[@class='forceModalActionContainer--footerAction forceModalActionContainer']/button[@title='Activate']")
public WebElement Activatepopup;

@FindBy(xpath="//*[@title='Activated']")
public WebElement  Actchev;

@FindBy(xpath="//*[@title='Related']")
public WebElement Related;

@FindBy(xpath="//*[@title='Details']")
public WebElement Details;

@FindBy(xpath="//*[@title='Managed Clauses']")
public WebElement manageclause;

@FindBy(xpath="(//tbody)[3]/tr")
public WebElement MClist;

@FindBy(xpath="//*[@title='Pending Customer Signature']")
public WebElement  PCSchev;

@FindBy(xpath="//*[@title='Client Signed']")
		public WebElement  CSchev;

@FindBy(xpath="(((//span[contains(text(),'Status')])/parent::div)/following-sibling::div/button[contains(@title,'Edit Status')])/preceding-sibling::span")
public WebElement  status;	

@FindBy(xpath="//*[@title='Attention Required']")
public WebElement  ARchev;

@FindBy(xpath="//*[@title='Awaiting Activation']")
public WebElement  AAchev;

@FindBy(xpath="(//*[@title='Attention Required'])[2]")
public WebElement  ARdrop;

@FindBy(xpath="(//*[@title='Awaiting Activation'])[2]")
public WebElement  AAdrop;

@FindBy(xpath="(((//span[contains(text(),'Attention Required Comments')])/parent::label)/parent::div)/textarea")
public WebElement  ARcomments;

@FindBy(xpath="//*[@dir='ltr'][contains(text(),'Save')]")
public WebElement  editsave;


// Agreement

@FindBy(xpath="//button[contains(text(),'Next')]")
public WebElement Next;

@FindBy(xpath="(//*[@class='slds-media__body']/*[@class='slds-tile__detail slds-truncate esign-title-width'])/li/span[2]")
public WebElement agreementstat;

@FindBy(xpath="(//*[@class='slds-media__body']/*[@class='slds-tile__detail slds-truncate esign-title-width'])/li/span[1]")
public WebElement agreement;

@FindBy(xpath="(((//*[contains(text(),'UltraDNS Service Order - 00023482 - 00023482')])/parent::div)/parent::th)/following-sibling::td[3]")
public WebElement agreementstatus;

@FindBy(xpath="//*[@class='esign-top-object-lookup-section slds-form-element slds-grid']/div[3]")
public WebElement contractlink;
public contractPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	//this.driver=driver;
	super();
	//setTitle();
	PageFactory.initElements(driver, this);
}

public WebElement getRelated(){
	return Related;
}

public WebElement getdropdown(){
	return dropdown;
}

public WebElement getDetail(){
	return Details;
}

public WebElement getmanageclauses(){
	return manageclause;
}

public WebElement getMClist(){
	return MClist;
}

public WebElement getesign(){
	return esign;
}

public WebElement getFiles(){
	return Files;
}

	
	public WebElement getGenerateDoc(){
		return GenerateDoc;
}
	
	public WebElement getNext(){
		return Next;
}

	public WebElement getagreementstat(){
		return agreementstat;
}
	
	public WebElement getagreement(){
		return agreement;
}

	public WebElement getagreementstatus(){
		return agreementstatus;
}
	
	public WebElement getcontractlink(){
		return contractlink;
}
	
	public WebElement getPCSchev(){
		return PCSchev;
}
	
	public WebElement getCSchev(){
		return CSchev;
}
	
	public WebElement getActchev(){
		return Actchev;
}
	
	public WebElement getARchev(){
		return ARchev;
}
	
	public WebElement getAAdrop(){
		return AAdrop;
}
	public WebElement getARdrop(){
		return ARdrop;
}
	
	public WebElement getAAchev(){
		return AAchev;
}
	public WebElement getActivate(){
		return Activate;
}
	
	public WebElement getActivatepopup(){
		return Activatepopup;
}
	public WebElement getstatus(){
		return status;
}
	
	public WebElement getARcomments(){
		return ARcomments;
}
	public WebElement geteditsave(){
		return editsave;
}
}
