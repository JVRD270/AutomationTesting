package theInternet.pages.DynamicLoading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class HiddenElementPage extends PageObjectBase {
	public HiddenElementPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@FindBy(css="#start button")
	WebElement startButton;
	
	WebElement finishText;
	
	public HiddenElementPage toggleElement() {
		startButton.click();
		finishText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		return this;
	}
	
	
	public boolean getElementDisplay() {
		return finishText.isDisplayed();
	}
}
