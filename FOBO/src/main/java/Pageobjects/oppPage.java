package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class oppPage {
	
	

@FindBy(xpath="//*[@id='relatedListsTab__item']")
public WebElement Related;

@FindBy(xpath="//*[@id='detailTab__item']")
public WebElement Details;

@FindBy(xpath="//*[@id='window'][contains(text(),'Quotes')]")
public WebElement quotequicklinks;


@FindBy(xpath="(//*[starts-with(text(),'Q-')])[1]")
public WebElement quotelink;

@FindBy(xpath="//*[@title='3 - Selection']")
public WebElement selection;

@FindBy(xpath="//*[contains(text(),'Mark as Current Stage')]")
public WebElement mark;

@FindBy(xpath="//*[@name='Opportunity.Contract']")
public WebElement contract;

@FindBy(xpath="//*[@class='slds-modal__footer']/button[2]")
public WebElement contractsave;

@FindBy(xpath="//*[@title='4 - Contracting']")
public WebElement contracting;

@FindBy(xpath="//*[@class='container forceRelatedListSingleContainer']/article/div[2]/div/div/div/div/ul/li/article/div/div[1]/h3/div/a")
public WebElement contractlink;


@FindBy(xpath="//button[contains(text(),'Edit Lines')]")
public WebElement editlines;


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

}
