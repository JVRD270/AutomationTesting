package cucumber.stepDefinitions;

import org.testng.Assert;
import framework.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import theInternet.pages.AddRemoveElementPage;

public class addDeleteElementsStepDefinitions extends TestBase{
	AddRemoveElementPage addRemovePage;
	
	
	
	@Given("I want to add {int} elements and delete {int}")
	public void navigatesToPage(int addedElements, int deletedElements) {
		super.beforeTest();
		addRemovePage = new AddRemoveElementPage(webDriver, baseUrl).navigate();
	}
	
	@When("I click \"Add Element\" {int} times")
	public void addElements(int elementsToAdd) {
		addRemovePage.addElements(elementsToAdd);
	}
	
	@Then("there will be {int} elements")
	public void assertNumberOfElements(int addedElements) {
		Assert.assertEquals(addRemovePage.getNumberOfElements(), addedElements);
	}
	
	@When("I click \"Delete\" {int} times")
	public void deleteElements(int elementsToDelete) {
		addRemovePage.removeElements(elementsToDelete);
	}
	
	@Then("there will be {int} elements left")
	public void assertElementsLeft(int result) {
		Assert.assertEquals(addRemovePage.getNumberOfElements(), result);
		super.afterTest();
	}
	
	
}
