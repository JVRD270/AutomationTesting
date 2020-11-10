package theInternet.foundation.tablesControl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableControlExtension {

	private WebElement mappedElement;
	private WebDriver driver;
	private By columnHeaderLocator = By.cssSelector("thead th");
	private By rowLocator = By.cssSelector("tbody tr");
	
	
	public TableControlExtension(WebElement mappedElement, WebDriver driver) {
		this.mappedElement = mappedElement;
		this.driver = driver;
	}
	
	private List<WebElement> getColumnHeaders() {
		List<WebElement> columnHeaders = this.mappedElement.findElements(columnHeaderLocator);
		return columnHeaders;
	}
	
	public TableRowControlExtension getRow(int ordinalRow) {
		List<WebElement> rowElements = this.mappedElement.findElements(rowLocator);
		WebElement selectedRow = rowElements.get(ordinalRow - 1);
		
		List<WebElement> columnHeaders = getColumnHeaders();
		
		return new TableRowControlExtension(selectedRow, driver, columnHeaders);
	}
	
}
