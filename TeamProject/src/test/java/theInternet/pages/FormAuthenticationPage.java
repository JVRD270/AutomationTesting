package theInternet.pages;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class FormAuthenticationPage extends PageObjectBase {
	
	@FindBy(id = "username")
	WebElement userNameField;
	
	@FindBy(id = "password")
	WebElement passWordField;
	
	@FindBy(xpath = "//button[descendant::i[contains(text(),'Login')]]")
	WebElement loginButton;
	
	public FormAuthenticationPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public FormAuthenticationPage navigate() {
		super.navigate("/login");
		return this;
	}
	
	public FormAuthenticationPage submitCredentials(String username, String pw) {
		userNameField.sendKeys(username);
		passWordField.sendKeys(pw);
		loginButton.click();
		return this;
	}
	
	public String getSuccessMessage(String successMessage) {
		if(driver.getPageSource().contains(successMessage)) {
			return successMessage;
		}
		throw new NotFoundException("message was not found");
	}
}
