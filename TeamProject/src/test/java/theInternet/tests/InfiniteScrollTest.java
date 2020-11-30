package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.ScrollPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class InfiniteScrollTest extends TheInternetTestBase {
  @Test
  public void canScrollInfinitelly() throws InterruptedException {
	  //This test checks if more content is generated whenever the page is scrolled to its bottom.
	  int numberOfTestScrolls = 2; //sets number of times it will be scrolled to bottom
	  int numberOfTextElements = new ScrollPage(webDriver, baseUrl)
			  .navigate()
			  .scroll(numberOfTestScrolls)
			  .getNumberOfTextElements();
	  
	  int expectedTotalElements = 2 + numberOfTestScrolls;
	  
	  Assert.assertEquals(numberOfTextElements, expectedTotalElements);
	  
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
