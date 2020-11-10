package theInternet.foundation.tablesControl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableRowControlExtension {
	private WebElement mappedElement;
	private WebDriver driver;
	private List<WebElement> columnHeaders;
	private By CellLocator = By.cssSelector("tr td");
	
	
	public TableRowControlExtension(WebElement mappedElement, WebDriver driver, List<WebElement> columnHeaders) {
		this.mappedElement = mappedElement;
		this.driver = driver;
		this.columnHeaders = columnHeaders;
		
	}
	
	public TableCellControlExtension getCell(String columnHeader) {
		List<WebElement> cellElements = this.mappedElement.findElements(CellLocator);
		
		List<String> textHeaders = new ArrayList<String>();
		for(WebElement h : columnHeaders) {
			String headerText = h.findElement(By.cssSelector("th span")).getText();
			textHeaders.add(headerText);
		}
		
		int selectedCellIndex = textHeaders.indexOf(columnHeader);
		WebElement selectedCell = cellElements.get(selectedCellIndex);
		return new TableCellControlExtension(selectedCell, driver);
	}
}
