package theInternet.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import framework.PageObjectBase;

public class InputPage extends PageObjectBase{

	public InputPage(WebDriver driver, String url) {
		super(driver, url);
	}
		
	@FindBy(css="input")
	WebElement inputElement;
	
	public InputPage navigate() {
		super.navigate("/inputs");
		return this;
	}
	
	public InputPage setInput(int expectedInput) {
		inputElement.sendKeys(Integer.toString(expectedInput));
		return this;
	}
		
	public int getInput() {
		String inputValue = inputElement.getAttribute("value");
		return Integer.parseInt(inputValue);
	}

	
	
}
