package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.DynamicLoading.DynamicLoadingPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DynamicLoadingTest extends TheInternetTestBase {
  @Test
  public void canMakeHiddenElementAppear() {
	  boolean isElementDisplayed = new DynamicLoadingPage(webDriver, baseUrl)
			  .navigate()
			  .goToHiddenElementExample()
			  .toggleElement()
			  .getElementDisplay();
	  
	  Assert.assertTrue(isElementDisplayed);
  }
  
  @Test
  public void canMakeNotRenderedElementAppear() {
	  boolean isElementDisplayed = new DynamicLoadingPage(webDriver, baseUrl)
			  .navigate()
			  .goToNotRenderedElementExample()
			  .toggleElement()
			  .getElementDisplay();
	  
	  Assert.assertTrue(isElementDisplayed);
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
