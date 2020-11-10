package theInternet.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class AddRemoveElementPage extends PageObjectBase{
	private By removeButtonLocator = By.cssSelector("button.added-manually");
	private List<WebElement> removeButtons;
	
	public AddRemoveElementPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(css = "button:not(.added-manually)")
	WebElement addButton;
	
	public AddRemoveElementPage navigate() {
		super.navigate("/add_remove_elements/");
		return this;
	}
	
	
	public AddRemoveElementPage addElements(int howManyClicks) {
		for(int i=0;i<howManyClicks; i++) {
			addButton.click();
		}
		removeButtons = driver.findElements(removeButtonLocator);
		return this;
	}
	
	public AddRemoveElementPage removeElements(int howManyClicks) {
		for(int i=0;i<howManyClicks; i++) {
			removeButtons.get(removeButtons.size()-1).click();
			removeButtons.remove(removeButtons.size()-1);
		}
		return this;
	}
	
	public int getNumberOfElements() {
		return removeButtons.size();
	}

}
