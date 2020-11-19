package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
		

	public DragAndDropPage dragBoxIntoAnother(String sourceBoxHeader, String targetBoxHeader) {
		javaScriptDragAndDrop(getBoxByHeader(sourceBoxHeader), getBoxByHeader(targetBoxHeader));
		return this;
	}

	public WebElement getBoxByHeader(String header) {
		if(getLeftBoxLabel().equals(header)) {
			return columnA;
		}
		if(getRightBoxLabel().equals(header)) {
			return columnB;
		}
		
		throw new RuntimeException("Label invalid");
	}

	public String getLeftBoxLabel() {
		String label = columnA.findElement(By.tagName("header")).getText();
		return label;
	}

	public String getRightBoxLabel() {
		String label = columnB.findElement(By.tagName("header")).getText();
		return label;
	}

	
	
}
