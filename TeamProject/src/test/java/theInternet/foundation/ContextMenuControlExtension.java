package theInternet.foundation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuControlExtension extends ControlExtensionBase {
	protected boolean alertIsPresent;
	
	public ContextMenuControlExtension(WebElement mappedElement, WebDriver driver) {
		super(mappedElement, driver);
	}
	
	public ContextMenuControlExtension click() {
		Actions actions = new Actions(driver);
		actions.contextClick(mappedElement).perform();
		return this;
	}
	
	public boolean isAlertPresent() throws InterruptedException {
		Thread.sleep(1000);
		if(driver.switchTo().alert() != null) {
			alertIsPresent = true;
		}
		return alertIsPresent;
	}
	
	
}
