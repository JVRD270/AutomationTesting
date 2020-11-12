package theInternet.tests.EntryAd;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.EntryAdPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class canReEnableAdTest extends TheInternetTestBase{
	@Test
	public void canReEnableAd() {
		boolean entryAdShows = new EntryAdPage(webDriver, baseUrl)
				.navigate()
				.closeAd()
				.reEnable()
				.checkAdDisplay();

		Assert.assertTrue(entryAdShows);
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
