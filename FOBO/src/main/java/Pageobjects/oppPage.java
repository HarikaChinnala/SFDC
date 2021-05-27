package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class oppPage {
	@FindBy(xpath="//button[contains(text(),'Next')]")
	public WebElement Next;	
	
@FindBy(xpath="//*[@class='slds-button__icon'][@viewBox='0 0 52 52'][@data-key='down']")	
public WebElement dropdown;

@FindBy(xpath="//*[contains(@name,'Opportunity.Send_For_Signature')]")	
public WebElement esign;

	
@FindBy(xpath="//*[@id='relatedListsTab__item']")
public WebElement Related;

@FindBy(xpath="//*[@id='detailTab__item']")
public WebElement Details;

@FindBy(xpath="((//*[contains(text(),'Amendment Contract Status')]//parent::div)/following-sibling::div)/span/slot/slot/lightning-formatted-text")
public WebElement Amendcontractstatus;

@FindBy(xpath="//*[@id='window'][contains(text(),'Quotes')]")
public WebElement quotequicklinks;


@FindBy(xpath="(//*[starts-with(text(),'Q-')])[1]")
public WebElement quotelink;

@FindBy(xpath="(//*[contains(@id,'dropdown-element')]//parent::div)/div[2]/lightning-base-combobox-item/span[@title='Activated']")
public WebElement Activated;

@FindBy(xpath="//*[@title='7 - Won']")
public WebElement  wonchev;

@FindBy(xpath="//*[@title='Closed']")
public WebElement  Closedchev;

@FindBy(xpath="//*[contains(text(),'Select Closed Stage')]")
public WebElement  selectstage;

@FindBy(xpath="//*[@title='3 - Selection']")
public WebElement selection;

@FindBy(xpath="//*[contains(text(),'Mark as Current Stage')]")
public WebElement mark;

@FindBy(xpath="//*[@name='Opportunity.Contract']")
public WebElement contract;

@FindBy(xpath="//*[contains(@class,'slds-modal__footer')]/button[2]")
public WebElement contractsave;

@FindBy(xpath="//*[@title='4 - Contracting']")
public WebElement contracting;

@FindBy(xpath="//*[@class='container forceRelatedListSingleContainer']/article/div[2]/div/div/div/div/ul/li/article/div/div[1]/h3/div/a")
public WebElement contractlinkuat;

@FindBy(xpath="//*[@class='container forceRelatedListSingleContainer']/article/div[2]/div/div/div/div/ul/li/div[2]/h3/div/a")
public WebElement contractlink;

@FindBy(xpath="(//*[@class='slds-media__body']/*[@class='slds-tile__detail slds-truncate esign-title-width'])/li/span[2]")
public WebElement agreementstat;

@FindBy(xpath="(//*[@class='slds-media__body']/*[@class='slds-tile__detail slds-truncate esign-title-width'])/li/span[1]")
public WebElement agreement;

@FindBy(xpath="//button[contains(text(),'Edit Lines')]")
public WebElement editlines;

@FindBy(xpath="//*[contains(@name,'Opportunity.Generate_Amendment')]")
public WebElement Genamend;

@FindBy(xpath="((((((//*[@title='Files'])/parent::a)/parent::h2)/parent::div)/parent::header)/parent::div)/following-sibling::div/div/div/div/div/div/div[2]/ul/li/a")
public WebElement Files;

@FindBy(xpath="//*[@name='SaveEdit']")
public WebElement Saveedit;

public oppPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	//this.driver=driver;
	super();
	//setTitle();
	PageFactory.initElements(driver, this);
}

public WebElement getRelated(){
	return Related;
}

public WebElement getDetail(){
	return Details;
}

public WebElement getquotequicklinks(){
	return quotequicklinks;
}

public WebElement getquotelink(){
	return quotelink;
}


public WebElement geteditlines(){
	return editlines;
}


public WebElement getselection(){
	return selection;
}
public WebElement getmark(){
	return mark;
}

public WebElement getcontract(){
	return contract;
}

public WebElement getcontractsave(){
	return contractsave;
}

public WebElement getcontracting(){
	return contracting;
}

public WebElement getcontractlink(){
	return contractlink;
}

public WebElement getcontractlinkuat(){
	return contractlinkuat;
}

public WebElement getGenamend(){
	return Genamend;
}


public WebElement getFiles(){
	return Files;
}

public WebElement getdropdown(){
	return dropdown;
}

public WebElement getesign(){
	return esign;
}

public WebElement getagreementstat(){
	return agreementstat;
}

	public WebElement getagreement(){
		return agreement;
	}

	public WebElement getNext(){
		return Next;
	}
	
	public WebElement getAmendcontractstatus(){
		return Amendcontractstatus;
}
	
	public WebElement getActivated(){
		return Activated;
}
	
	public WebElement getSaveedit(){
		return Saveedit;
}
	
	public WebElement getClosedchev(){
		return Closedchev;
}
	
	public WebElement getselectstage(){
		return selectstage;
}

	
	public WebElement get7won(){
		return wonchev;
}
	
}
