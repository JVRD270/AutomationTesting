package theInternet.foundation.EmailManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailManager {
	String inboxBaseUrl = "https://endtest.io/mailbox?email=";
	private WebDriver driver;
	private By emailLocator = By.cssSelector(".email_item");
	private List<WebElement> emails = new ArrayList<WebElement>();
	
	public EmailManager(WebDriver driver) {
		this.driver = driver;
	}

	public EmailManager openInbox(String emailAddress) throws InterruptedException {
		Thread.sleep(30000); //wait for the email to arrive, the documentation asks for 30 secs
		driver.get(inboxBaseUrl + emailAddress);
		emails = driver.findElements(emailLocator);
		return this;
	}
	
	public EndTestEmailObject getLatestEmail() {
		return new EndTestEmailObject(driver, emails.get(emails.size()-1));
	}

}
