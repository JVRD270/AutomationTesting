package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.DisappearingElementsPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DisappearingElementsTest extends TheInternetTestBase {
	@Test
	public void canElementDisappear() {
		//Checks if an element disappears from the page. Stops whenever an element disappears. Limit = 100 reloads.
		boolean didElementDisappear = new DisappearingElementsPage(webDriver, baseUrl)
				.navigate()
				.reloadAndCheckForElement()
				.disappearedAtLeastOnce();
		
		Assert.assertTrue(didElementDisappear);
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
