package theInternet.foundation.tablesControl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import theInternet.foundation.ControlExtensionBase;

public class TableCellControlExtension extends ControlExtensionBase{
	public TableCellControlExtension(WebElement mappedElement, WebDriver driver) {
		super(mappedElement, driver);
	}
	
	public String getText() {
			String text = mappedElement.getText();
		
		return text;
	}
}
