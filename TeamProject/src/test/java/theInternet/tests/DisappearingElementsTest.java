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
		//Tests if element disappears at least once with a set number of page reloads
		int numberOfPageReloads = 5;
		boolean didElementDisappear = new DisappearingElementsPage(webDriver, baseUrl)
				.navigate()
				.reloadAndCheckForElement(numberOfPageReloads)
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
