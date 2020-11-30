package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.ExitIntentPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ExitIntentTest extends TheInternetTestBase{
  @Test
  public void checksMessageAppearsWhenUserTriesToLeave() {
	  boolean isMessageDisplayed = new ExitIntentPage(webDriver, baseUrl)
			  .navigate()
			  .tryToLeave()
			  .getMessageDisplay();
	  
	  Assert.assertTrue(isMessageDisplayed);
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
