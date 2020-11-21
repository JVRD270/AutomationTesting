package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.JQueryUIMenuPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class JQueryUIMenusTest extends TheInternetTestBase {
  @Test
  public void canSelectMenuElements() {
	  String expectedLabelOfElementToClick = "Excel";
	  String clickedElement = new JQueryUIMenuPage(webDriver, baseUrl)
			  .navigate()
			  .clickMenuElement(expectedLabelOfElementToClick);
	  
	  Assert.assertEquals(clickedElement, expectedLabelOfElementToClick);
	  
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
