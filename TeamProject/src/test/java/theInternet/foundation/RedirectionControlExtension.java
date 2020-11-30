package theInternet.foundation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedirectionControlExtension extends ControlExtensionBase{

	public RedirectionControlExtension(WebElement mappedElement, WebDriver driver) {
		super(mappedElement, driver);
	}
	
	public String getUrl() {
		return driver.getCurrentUrl(); 
	}
	
	public RedirectionControlExtension redirect() {
		driver.navigate().to(mappedElement.getAttribute("href"));
		return this;
	}
	

}
