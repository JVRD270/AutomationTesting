package theInternet.foundation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class HorizontalSliderControlExtension extends ControlExtensionBase{
	double maxValue = Double.parseDouble(mappedElement.getAttribute("max"));
	double minValue = Double.parseDouble(mappedElement.getAttribute("min"));
	double step = Double.parseDouble(mappedElement.getAttribute("step"));
	double currentValue = 0;


	public HorizontalSliderControlExtension(WebElement mappedElement, WebDriver driver) {
		super(mappedElement, driver);
	}

	public HorizontalSliderControlExtension moveTo(double value){
		int numberOfSteps = (int) Math.abs((value - currentValue)/step);
		if (value < currentValue) {
			for(int i=1;i<=numberOfSteps;i++) {
				mappedElement.sendKeys(Keys.ARROW_LEFT);
			}
		}
		if (value > currentValue) {
			for(int i=1;i<=numberOfSteps;i++) {
				mappedElement.sendKeys(Keys.ARROW_RIGHT);
			}
		}

		currentValue = value;

		return this;
	}
}
