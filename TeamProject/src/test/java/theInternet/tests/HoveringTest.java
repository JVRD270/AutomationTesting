package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.HoveringPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HoveringTest extends TheInternetTestBase {
  @Test
  public void canMakeInformationShowOnHover() {
	  
	  String expectedInformationToBeDisplayedOnHover = "name: user1";
	  
	  String infoDisplayed = new HoveringPage(webDriver, baseUrl)
			  .navigate()
			  .getUserInfoDisplayedOnHover(expectedInformationToBeDisplayedOnHover);
	  
	  Assert.assertEquals(infoDisplayed, expectedInformationToBeDisplayedOnHover);
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
