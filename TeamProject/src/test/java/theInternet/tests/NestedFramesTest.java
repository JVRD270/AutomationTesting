package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.NestedFramesPage;

import org.testng.annotations.BeforeTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NestedFramesTest extends TheInternetTestBase {
  @Test
  public void canSelectFrames() {
	  String expectedLabelOfSelectedFrame = "LEFT";
	  
	  String selectedFrame = new NestedFramesPage(webDriver, baseUrl)
			  .navigate()
			  .selectFrame(expectedLabelOfSelectedFrame);
	  
	  Assert.assertEquals(selectedFrame, expectedLabelOfSelectedFrame);
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
