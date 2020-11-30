package theInternet.foundation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ControlExtensionBase {
	
	protected WebElement mappedElement;
	protected WebDriver driver;
	
	protected ControlExtensionBase(WebElement mappedElement, WebDriver driver) {
		this.mappedElement = mappedElement;
		this.driver = driver;
	}

}
