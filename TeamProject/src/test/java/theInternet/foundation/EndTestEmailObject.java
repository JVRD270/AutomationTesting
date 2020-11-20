package theInternet.foundation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EndTestEmailObject {
	public String title;
	public String sender;
	public String content;
	public WebDriver driver;
	
	
	public EndTestEmailObject(WebDriver driver, WebElement emailElement) {
		this.driver = driver;
		this.title = emailElement.findElement(By.cssSelector(".email_subject")).getText();
		this.sender = emailElement.findElement(By.cssSelector(".from_item")).getText();
		this.content = emailElement.findElement(By.cssSelector(".email_content div p")).getText();
		
	}
	
	
	public String getTitle() {
		return this.title;
	}
}
