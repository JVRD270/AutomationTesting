package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.ChallengingDOMPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ChallengingDOMTest extends TheInternetTestBase {
  @Test
  public void resultChangesWhenButtonIsClicked() {
	  int numberOfTimesToClick = 4;
	  
	  ChallengingDOMPage testPage = new ChallengingDOMPage(webDriver, baseUrl);
	  String startingResult = testPage
			  .navigate()
			  .getCurrentResult();
	  
	  String currentResult = testPage
			  .clickAnyColoredButton(numberOfTimesToClick)
			  .getCurrentResult();
	  
	  Assert.assertNotEquals(currentResult, startingResult);
	  
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
