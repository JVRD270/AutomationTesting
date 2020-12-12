package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.AddRemoveElementPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AddRemoveElementsTest extends TheInternetTestBase{
	@Test
	public void CanAddElements() {
		int expectedAddedElements = 1;
		int numberOfElements = new AddRemoveElementPage(webDriver, baseUrl)
				.navigate()
				.addElements(expectedAddedElements)
				.getNumberOfElements();

		Assert.assertEquals(numberOfElements, expectedAddedElements);
	}

	@Test
	public void CanDeleteElements() {
		int expectedAddedElements = 5;
		int expectedRemovedElements = 5;
		if (expectedAddedElements - expectedRemovedElements < 0) {
			throw new ArithmeticException("you cannot remove more elements than you added");
		}

		int remainingElements = new AddRemoveElementPage(webDriver, baseUrl)
				.navigate()
				.addElements(expectedAddedElements)
				.removeElements(expectedRemovedElements)
				.getNumberOfElements();
		

		Assert.assertEquals(remainingElements, expectedAddedElements - expectedRemovedElements);
	}

	@Test
	public void CanAddAndDeleteElements() {
		int expectedAddedElements = 5;
		int expectedRemovedElements = 3;
		int expectedRemainingElements = expectedAddedElements - expectedRemovedElements;
		if (expectedRemainingElements < 0) {
			throw new ArithmeticException("you cannot remove more elements than you added");
		}

		int remainingElements = new AddRemoveElementPage(webDriver, baseUrl)
				.navigate()
				.addElements(expectedAddedElements)
				.removeElements(expectedRemovedElements)
				.getNumberOfElements();

		Assert.assertEquals(remainingElements, expectedRemainingElements);
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
