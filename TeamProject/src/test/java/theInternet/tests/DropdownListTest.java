package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.DropdownPage;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class DropdownListTest extends TheInternetTestBase {
  @Test
  public void tc4CanSelectDropdownListOption() {
	 String expectedSelection = "Option 2";
	 String actualSelection = new DropdownPage(webDriver,baseUrl)
			 					.navigate()
			 					.select(expectedSelection)
			 					.getSelection();
	 
	 Assert.assertEquals(actualSelection, expectedSelection);
  }
  @BeforeClass
  public void beforeClass() {
	  super.beforeTest();
  }

  @AfterClass
  public void afterClass() {
	  super.afterTest();
  }

}
