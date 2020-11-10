package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableCellControlExtension {
	private WebElement mappedElement;
	public TableCellControlExtension(WebElement mappedElement, WebDriver driver) {
		this.mappedElement = mappedElement;
	}
	
	public String getText() {
			String text = mappedElement.getText();
		
		return text;
	}
}
