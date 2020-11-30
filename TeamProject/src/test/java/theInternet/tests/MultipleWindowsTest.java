package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.MultipleWindowsPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MultipleWindowsTest extends TheInternetTestBase {
  @Test
  public void canOpenNewWindow() {
	  String expectedTabMessage = "New Window";
	  String actualTabSource = new MultipleWindowsPage(webDriver, baseUrl)
			  .navigate()
			  .openNewTab()
			  .getNewTabSource();
	  
	  Assert.assertTrue(actualTabSource.contains(expectedTabMessage));
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
