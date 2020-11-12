package theInternet.foundation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import bsh.ParseException;

public class HorizontalSliderControlExtension extends ControlExtensionBase{
	public HorizontalSliderControlExtension(WebElement mappedElement, WebDriver driver) {
		super(mappedElement, driver);
	}
	
	public HorizontalSliderControlExtension moveTo(String[] positions) throws ParseException{
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(mappedElement, 100, 0);

		
//		for(String p : positions) {
//		}
		
		return null;
	}
}
