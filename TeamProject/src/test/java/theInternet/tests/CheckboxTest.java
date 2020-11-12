package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.CheckboxPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CheckboxTest extends TheInternetTestBase{
  @Test
  public void canToggleCheckbox() {
	  String[] boxesToToggle = {"checkbox 1", "checkbox 2"};
	  String[] selectedCheckboxes = new CheckboxPage(webDriver, baseUrl)
			  .navigate()
			  .toggleCheckboxes(boxesToToggle, true)
			  .toggleCheckboxes(boxesToToggle, false)
			  .getSelectedCheckboxes();
	  
	  Assert.assertEquals(selectedCheckboxes.length, 0);
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
