package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class DragAndDropPage extends PageObjectBase {
	
	public DragAndDropPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	
	
	public DragAndDropPage navigate() {
		super.navigate("/drag_and_drop");
		return this;
	}
	
	@FindBy(css="#column-a")
	WebElement columnA;
	
	@FindBy(css="#column-b")
	WebElement columnB;
	
	private By leftBoxLabel = By.cssSelector("#column-a header");
	private By rightBoxLabel = By.cssSelector("#column-b header");
	Actions actions = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 1);
	

	public DragAndDropPage dragLeftToRight() {
		actions.clickAndHold(columnA).moveToElement(columnB).release(columnB).build().perform();
		return this;
	}
	
	public String getLeftBoxLabel() {
		wait.until(ExpectedConditions.textToBe(leftBoxLabel, "B"));
		String actualLabel = driver.findElement(leftBoxLabel).getText();
		return actualLabel;
	}

	public String getRightBoxLabel() {
		wait.until(ExpectedConditions.textToBe(rightBoxLabel, "A"));
		String actualLabel = columnB.findElement(By.tagName("header")).getText();
		return actualLabel;
	}
	
}
