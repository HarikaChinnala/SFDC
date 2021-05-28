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

@FindBy(xpath="//*[@data-name='Draft']")
public WebElement Chevron_Draft;

//@FindBy(xpath="//*[@title = 'Show 22 more actions']/*[@role='button']")
//@FindBy(xpath="//*[@title = 'Show 22 more actions']")
@FindBy(xpath="//*[@class='uiMenu']/div/div/div/a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix']")
public WebElement Dropdown;

@FindBy(xpath="//*[@title = 'Submit Edit'] //*[@role='button']")
public WebElement SubmitEdit;

@FindBy(xpath="//*[@class='slds-form-element']/div/textarea")
public WebElement SubmitEditDetails;

@FindBy(xpath="//*[@class='slds-card__footer']/button[@type='submit']")
public WebElement Submit_SubmitEdit;

@FindBy(xpath="//*[@data-name='Edit Under Review']")
public WebElement Chevron_EditUnderReview;

@FindBy(xpath="(//*[text()='Status'])[2]/parent :: div/following-sibling::div/span")
public WebElement Details_Status;

@FindBy(xpath="//*[@title='Status']/following-sibling::div")
public WebElement Contract_Status;

@FindBy(xpath="//span[text()='Related']")
public WebElement Related_Tab;

@FindBy(xpath="//*[text()='Cases']")//*[@title='Cases']//parent::a
public WebElement Cases_Section;


//@FindBy(xpath="//table[@role='grid']/tbody/tr/th/span/a")
@FindBy(xpath="//table[@role='grid']/tbody/tr/td[3]/span/a[contains(@title,'Edit Request -- Security')]/parent::span/parent::td/preceding-sibling::th/span/a")
public WebElement Case_SubmitEdit;

@FindBy(xpath="(((//*[text() = 'Case Owner'])//parent::div)//following-sibling::div)/span/slot/slot/force-owner-lookup/div/span")
public WebElement Case_Owner;

@FindBy(xpath="//*[text()='Approvals']")
public WebElement Approvals_Section;

@FindBy(xpath="(((//*[@class='slds-truncate'][contains(text(),'Requested')])/parent::span)/parent::td)/preceding-sibling::th/span/a")
public WebElement Approvals_Requested;

@FindBy(xpath="//*[@type='button'][text()='Approve']")
public WebElement Approve_Button;

@FindBy(xpath="//*[@class='slds-textarea']")
public WebElement Approve_Text;

@FindBy(xpath="//*[@class='slds-button slds-button--brand']")
public WebElement Approval_Submit;

@FindBy(xpath="//*[@data-name='Edit Complete']")
public WebElement Chevron_EditComplete;

@FindBy(xpath="//*[@title = 'Submit For Signature'] //*[@role='button']")
public WebElement SubmitForSignature;

@FindBy(xpath="//*[@data-name='Submission Under Review']")
public WebElement Chevron_SubmissionUnderReview;

@FindBy(xpath="//table[@role='grid']/tbody/tr/td[3]/span/a[contains(@title,'Contract Submission -- Security')]/parent::span/parent::td/preceding-sibling::th/span/a")
public WebElement Case_SubmitForSignature;


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

	public WebElement Chevron_Draft(){
		return Chevron_Draft;
	}
	
	public WebElement Dropdown(){
		return Dropdown;
	}
	
	public WebElement SubmitEdit(){
		return SubmitEdit;
	}
	
	public WebElement SubmitEditDetails(){
		return SubmitEditDetails;
	}
	
	public WebElement Submit_SubmitEdit(){
		return Submit_SubmitEdit;
	}
	
	public WebElement Chevron_EditUnderReview(){
		return Chevron_EditUnderReview;
	}
	
	public WebElement Details_Status(){
		return Details_Status;
	}
	
	public WebElement Contract_Status(){
		return Contract_Status;
	}
	
	public WebElement Related_Tab(){
		return Related_Tab;
	}
	
	public WebElement Cases_Section(){
		return Cases_Section;
	}
	
	public WebElement Case_SubmitEdit(){
		return Case_SubmitEdit;
	}
	
	public WebElement Case_Owner(){
		return Case_Owner;
	}
	
	public WebElement Approvals_Section(){
		return Approvals_Section;
	}
	
	public WebElement Approvals_Requested(){
		return Approvals_Requested;
	}
	
	public WebElement Approve_Button(){
		return Approve_Button;
	}
	
	public WebElement Approve_Text(){
		return Approve_Text;
	}
	
	public WebElement Approval_Submit(){
		return Approval_Submit;
	}
	
	public WebElement Chevron_EditComplete(){
		return Chevron_EditComplete;
	}
	
	public WebElement SubmitForSignature(){
		return SubmitForSignature;
	}
	
	public WebElement Chevron_SubmissionUnderReview(){
		return Chevron_SubmissionUnderReview;
	}
	
	public WebElement Case_SubmitForSignature(){
		return Case_SubmitForSignature;
	}

	
}
