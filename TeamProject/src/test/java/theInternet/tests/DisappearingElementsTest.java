package theInternet.tests;

import org.testng.annotations.Test;

import framework.TestBase;
import theInternet.pages.DisappearingElementsPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DisappearingElementsTest extends TestBase {
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
