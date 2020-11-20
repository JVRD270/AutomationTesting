package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.EmailManager;

public class ForgotPWPage extends PageObjectBase {
	public ForgotPWPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public ForgotPWPage navigate() {
		super.navigate("/forgot_password");
		return this;
	}
	
	@FindBy(id="email")
	WebElement emailInput;
	
	@FindBy(id="form_submit")
	WebElement submit;
	
	public ForgotPWPage submitEmail(String emailAddress) {
		emailInput.sendKeys(emailAddress);
		submit.click();
		return this;
	}
	
	public EmailManager openInbox(String emailAddress) throws InterruptedException {
		EmailManager myEmailManager = new EmailManager(driver);
		return myEmailManager.openInbox(emailAddress);
	}
}
