package dataDriven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReactDropdownControlExtension {
	private WebElement mappedElement;


	public ReactDropdownControlExtension(WebElement mappedElement) {
		this.mappedElement = mappedElement;

	}

	//use this one
	public void selectByText(String value) {
		expand();
		WebElement inputElement = mappedElement.findElement(By.tagName("input"));
		inputElement.sendKeys(value);
		inputElement.sendKeys(Keys.TAB);
	}
	
	//not working reliably
	public void select(String value) {	
		expand();
		List<WebElement> options = getOptions();
		
		for(WebElement option : options) {
			if(option.getText().equals(value)) {
				option.click();
				
				waitForCollapsed();
			}
		}	
		
		throw new RuntimeException(value + " is not a valid selection.");
	}

	private void waitForCollapsed() {
		// not implemented		
		
	}

	private List<WebElement> getOptions() {
		WebElement menuElement = mappedElement.findElement(By.cssSelector("div[class$='css-2613qy-menu']"));
		List<WebElement> options = menuElement.findElements(By.cssSelector("div[class$='-option']"));
		
		return options;
	}

	private void expand() {
		WebElement expandIcon = mappedElement.findElement(By.cssSelector(".css-2b097c-container .css-19bqh2r"));
		expandIcon.click();
		waitForExpanded();
	}

	private void waitForExpanded() {
		// not implemented
	}	
}