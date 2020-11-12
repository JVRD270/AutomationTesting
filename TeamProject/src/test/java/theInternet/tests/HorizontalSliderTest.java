package theInternet.tests;

import org.testng.annotations.Test;

import bsh.ParseException;
import theInternet.foundation.HorizontalSliderControlExtension;
import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.HorizontalSliderPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class HorizontalSliderTest extends TheInternetTestBase{
	@Test
	public void canMoveSlider() throws ParseException {
		String[] expectedOutputs = {"1", "3", "2", "4", "5"};
		HorizontalSliderControlExtension sliderOutputs = new HorizontalSliderPage(webDriver, baseUrl)
				.navigate()
				.move(expectedOutputs);
//				.getOutputs();

	}
	@BeforeTest
	public void beforeTest() {
		super.beforeTest();
	}

	@AfterTest
	public void afterTest() {
		super.afterTest();
	}

}
