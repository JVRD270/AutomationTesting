package cucumber.stepDefinitions;

import java.util.List;

import org.testng.Assert;

import framework.TestBase;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import theInternet.pages.HorizontalSliderPage;

public class HorizontalSliderStepDefinitions extends TestBase{
	HorizontalSliderPage horizontalSliderPage;
	double[] expectedPositions;

	@Given("I want to move my horizontal slider")
	public void navigateToSliderPage() {
		super.beforeTest();
		horizontalSliderPage = new HorizontalSliderPage(webDriver, baseUrl).navigate();
	}

	@When("I set its positions to")
	public void setSliderPositions(List<String> positions) throws InterruptedException {
		double[] doublePositions = new double[positions.size()];
		for (int i=0; i<positions.size(); i++) {
			doublePositions[i] = Double.parseDouble(positions.get(i));
		}
		expectedPositions = doublePositions;
		horizontalSliderPage = horizontalSliderPage.move(doublePositions);
	}

	@Then("I check if it moved to the correct positions")
	public void assertEquality() {
		Assert.assertEquals(horizontalSliderPage.getOutputs(), expectedPositions);
		super.afterTest();
	}
}
