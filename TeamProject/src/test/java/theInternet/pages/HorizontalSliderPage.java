package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bsh.ParseException;
import framework.PageObjectBase;
import theInternet.foundation.HorizontalSliderControlExtension;

public class HorizontalSliderPage extends PageObjectBase{
	public HorizontalSliderPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public HorizontalSliderPage navigate() {
		super.navigate("/horizontal_slider");
		return this;
	}
	
	@FindBy(css="sliderContainer input")
	WebElement slider;
	
	public HorizontalSliderControlExtension move(String[] positions) throws ParseException {
		return new HorizontalSliderControlExtension(slider, driver).moveTo(positions);
	}
	
	
}
