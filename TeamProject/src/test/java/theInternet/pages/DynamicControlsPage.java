package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class DynamicControlsPage extends PageObjectBase {
	public DynamicControlsPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	public DynamicControlsPage navigate() {
		super.navigate("/dynamic_controls");
		return this;
	}
	
	@FindBy(css="#checkbox-example button")
	WebElement addRemoveButton;
	
	@FindBy(css="#input-example button")
	WebElement enableInputButton;
	
	boolean checkboxDisplays = true;
	boolean inputIsEnabled = false;
	By inputLocator = By.cssSelector("#input-example input");
	
	public DynamicControlsPage toggleCheckboxDisplay(boolean shouldDisplay) {
		if(checkboxDisplays == shouldDisplay) {
			return this;
		}
		addRemoveButton.click();
		if(checkboxDisplays) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
		}
		if(!checkboxDisplays) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
		}
		
		checkboxDisplays = !checkboxDisplays;
		return this;
	}
	
	public DynamicControlsPage toggleTextInput(boolean shouldBeEnabled) {
		if(inputIsEnabled == shouldBeEnabled) {
			return this;
		}
		enableInputButton.click();
		if(inputIsEnabled) {
			wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(inputLocator, "disabled", "")));
		}
		if(!inputIsEnabled) {
			wait.until(ExpectedConditions.attributeToBe(inputLocator, "disabled", ""));
		}
		
		inputIsEnabled = !inputIsEnabled;
		return this;
	}
	
	public DynamicControlsPage insertText(String inputText) {
		if(!inputIsEnabled) {
			return this;
		}
		
		if(inputIsEnabled) {
			driver.findElement(inputLocator).sendKeys(inputText);
		}
		return this;
	}
	
	public boolean getCheckboxDisplay() {
		return checkboxDisplays;
	}
	
	public String getInputTextOrDisabled() {
		if(inputIsEnabled) {
			return driver.findElement(inputLocator).getAttribute("value");
		}
		if(!inputIsEnabled) {
			return "disabled";
		}
		
		return "";
	}

	
	
}
