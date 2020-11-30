package theInternet.foundation.EmailManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailManager {
	String inboxBaseUrl = "https://endtest.io/mailbox?email=";
	private WebDriver driver;
	private By emailLocator = By.cssSelector(".email_item");
	private List<WebElement> emails = new ArrayList<WebElement>();
	
	public EmailManager(WebDriver driver) {
		this.driver = driver;
	}

	public EmailManager openInbox(String emailAddress) throws InterruptedException {
		driver.get(inboxBaseUrl + emailAddress);
		emails = driver.findElements(emailLocator);
		int currentNumberOfEmails = emails.size();
		new WebDriverWait(driver, 30).until(d -> {
			driver.navigate().refresh();
			emails = driver.findElements(emailLocator);
			return emails.size() != currentNumberOfEmails;
					});
		return this;
	}
	
	public EndTestEmailObject getLatestEmail() {
		return new EndTestEmailObject(driver, emails.get(emails.size()-1));
	}

}
