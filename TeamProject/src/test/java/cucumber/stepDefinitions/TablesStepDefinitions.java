package cucumber.stepDefinitions;

import org.testng.Assert;

import framework.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import theInternet.pages.TablesPage;

public class TablesStepDefinitions extends TestBase{
	TablesPage tablesPage;
	int userId;
	
	@Given("I want to assert the amount user {int} owes me")
	public void setTablesPage(int ID) {
		super.beforeTest();
		tablesPage = new TablesPage(webDriver, baseUrl);
		userId = ID;
	}
	
	@When("I navigate to my data page")
	public void navigateToTablesPage() {
		tablesPage = tablesPage.navigate();
	}
	
	@Then("I want to get the amount so I can assert it equals {string}")
	public void assertEquality(String expectedAmount) {
		Assert.assertEquals(tablesPage.getAmountDueForUserTableRow(userId), expectedAmount);
		super.afterTest();
	}
}
