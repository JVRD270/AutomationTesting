package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.JSOnloadErrorPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class JSOnloadErrorTest extends TheInternetTestBase {
  @Test
  public void getsErrorWhenPageLoads() {
	  String expectedErrorMessage = "This page has a JavaScript error in the onload event.";
	  String pageSource = new JSOnloadErrorPage(webDriver, baseUrl)
			  .navigate()
			  .getSource();
	  
	  Assert.assertTrue(pageSource.contains(expectedErrorMessage));
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
