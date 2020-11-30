package theInternet.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.HorizontalSliderControlExtension;

public class HorizontalSliderPage extends PageObjectBase{
	List<String> detectedValuesText = new ArrayList<String>();

	public HorizontalSliderPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public HorizontalSliderPage navigate() {
		super.navigate("/horizontal_slider");
		return this;
	}

	@FindBy(css=".sliderContainer input")
	WebElement slider;

	@FindBy(id="range")
	WebElement outputText;

	public HorizontalSliderPage move(double[] positions) throws InterruptedException {
		HorizontalSliderControlExtension sliderController = new HorizontalSliderControlExtension(slider, driver);
		for(double position : positions) {
			sliderController.moveTo(position);
			detectedValuesText.add(outputText.getText());
		}

		return this;
	}

	public double[] getOutputs(){
		double[] convertedDetectedValues = new double[detectedValuesText.size()];
		for(int i=0; i<detectedValuesText.size(); i++) {
			double newValue = Double.parseDouble(detectedValuesText.get(i));
			convertedDetectedValues[i] = newValue;
		}
		
		return convertedDetectedValues;
	}

}
