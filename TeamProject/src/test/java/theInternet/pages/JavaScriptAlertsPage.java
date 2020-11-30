package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class JavaScriptAlertsPage extends PageObjectBase {
	public JavaScriptAlertsPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	WebElement clickedButton;
	
	@FindBy(id="result")
	WebElement outputText;
	
	@FindBy(xpath="//button[contains(text(),'JS Alert')]")
	WebElement alertButton;
	
	@FindBy(xpath="//button[contains(text(),'JS Confirm')]")
	WebElement confirmButton;
	
	@FindBy(xpath="//button[contains(text(),'JS Prompt')]")
	WebElement promptButton;
	
	public JavaScriptAlertsPage navigate() {
		super.navigate("/javascript_alerts");
		return this;
	}
	
	public JavaScriptAlertsPage click(String button) {
		if(button == "Alert") {
			alertButton.click();
			clickedButton = alertButton;
		}
		
		if(button == "Confirm") {
			confirmButton.click();
			clickedButton = confirmButton;
			
		}
		
		if(button == "Prompt") {
			promptButton.click();
			clickedButton = promptButton;
		}
		
		return this;
	}
	
	public JavaScriptAlertsPage confirmAlert() {
		if(clickedButton == alertButton) {
			driver.switchTo().alert().dismiss();
		}
		
		if(clickedButton == confirmButton) {
			driver.switchTo().alert().accept();
		}
		
		if(clickedButton == promptButton) {
			driver.switchTo().alert().sendKeys("");
			driver.switchTo().alert().accept();
		}
		return this;
	}
	
	
	public JavaScriptAlertsPage confirmAlert(String promptInput) {
		if (clickedButton == promptButton) {
			driver.switchTo().alert().sendKeys(promptInput);
			driver.switchTo().alert().accept();
		}
		
		else {
			confirmAlert();
		}
		
		return this;
	}
	
	public String getText() {
		return outputText.getText();
	}
	
	
}
