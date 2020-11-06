import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InputPage extends PageObjectBase{

	public InputPage(WebDriver driver, String url) {
		super(driver, url);
	}
		
//	@FindBy(css="input")
//	WebElement inputElement;
	
	public InputPage navigate() {
		super.navigate("/inputs");
		return this;
	}
	
	public InputPage setInput(String expectedInput) {
		WebElement inputElement = driver.findElement(By.cssSelector("input"));
		Input inputWrapped = new Input(inputElement);
		inputWrapped.setText(expectedInput);
		return this;
	}
		
	public String getInput() {
		return driver
				.findElement(By.cssSelector("input"))
				.getAttribute("value");
	}

	
	
}
