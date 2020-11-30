package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.SlowResourcesPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SlowResourcesTest extends TheInternetTestBase{
  @Test
  public void canLoadSlowResourcesPage() throws Exception {
	  boolean isPageLoaded = new SlowResourcesPage(webDriver, baseUrl)
	  .navigate()
	  .waitForPageLoad()
	  .getLoadedStatus();
	  
	  Assert.assertTrue(isPageLoaded);
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
