package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.DynamicControlsPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DynamicControlsTest extends TheInternetTestBase {
  @Test
  public void canMakeCheckboxAppearOrDisappear() {
	  boolean expectedDisplay = true;
	  boolean isCheckBoxPresent = new DynamicControlsPage(webDriver, baseUrl)
			  .navigate()
			  .toggleCheckboxDisplay(false)
			  .toggleCheckboxDisplay(true)
			  .getCheckboxDisplay();
	  
	  Assert.assertEquals(isCheckBoxPresent, expectedDisplay);
  }
  
  @Test
  public void canEnableOrDisableInputText() {
	  String expectedText = "enabled";
	  String isCheckBoxPresent = new DynamicControlsPage(webDriver, baseUrl)
			  .navigate()
			  .toggleTextInput(true)
			  .insertText(expectedText)
			  .getInputTextOrDisabled();
	  
	  Assert.assertEquals(isCheckBoxPresent, expectedText);
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
