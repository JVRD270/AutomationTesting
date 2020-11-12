package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.JavaScriptAlertsPage;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class JavaScriptAlertsTest extends TheInternetTestBase{
  @Test
  public void canActivateAlert() {
	  String expectedTextOutput = "You successfuly clicked an alert";
	  String actualText = new JavaScriptAlertsPage(webDriver, baseUrl)
			  .navigate()
			  .click("Alert")
			  .confirmAlert()
			  .getText();
	  
	  Assert.assertEquals(actualText, expectedTextOutput);
	  
  }
  
  @Test
  public void canConfirmAlert() {
	  String expectedTextOutput = "You clicked: Ok";
	  String actualText = new JavaScriptAlertsPage(webDriver, baseUrl)
			  .navigate()
			  .click("Confirm")
			  .confirmAlert()
			  .getText();
	  
	  Assert.assertEquals(actualText, expectedTextOutput);
	  
  }
  
  @Test
  public void canSendPromptAlert() {
	  String inputText = "asodoad";
	  String expectedTextOutput = "You entered: " + inputText;
	  String actualText = new JavaScriptAlertsPage(webDriver, baseUrl)
			  .navigate()
			  .click("Prompt")
			  .confirmAlert(inputText)
			  .getText();
	  
	  Assert.assertEquals(actualText, expectedTextOutput);
	  
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
