package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.HorizontalSliderPage;

import org.testng.annotations.BeforeTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HorizontalSliderTest extends TheInternetTestBase{
	@Test
	public void canMoveSlider() throws InterruptedException {
		double[] expectedOutputs = {1.0, 3.0, 2.0, 4.5, 5.0};
		double[] sliderOutputs = new HorizontalSliderPage(webDriver, baseUrl)
				.navigate()
				.move(expectedOutputs)
				.getOutputs();

		
		Assert.assertEquals(sliderOutputs, expectedOutputs);
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
