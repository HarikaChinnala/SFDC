package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contractPage {
	
	

@FindBy(xpath="(//*[@title='Related'])[2]")
public WebElement Related;

@FindBy(xpath="(//*[@title='Details'])[2]")
public WebElement Details;

@FindBy(xpath="//*[@title='Managed Clauses']")
public WebElement manageclause;

@FindBy(xpath="(//tbody)[3]/tr")
public WebElement MClist;




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

public WebElement getDetail(){
	return Details;
}

public WebElement getmanageclauses(){
	return manageclause;
}

public WebElement getMClist(){
	return MClist;
}


}
