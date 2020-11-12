package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.ContextMenuPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ContextMenuTest extends TheInternetTestBase{
  @Test
  public void checkContextMenuAlertAppears() throws InterruptedException {
	  boolean alertAppears = new ContextMenuPage(webDriver, baseUrl)
			  .navigate()
			  .clickBox()
			  .isAlertPresent();
	  
	  Assert.assertTrue(alertAppears);
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
