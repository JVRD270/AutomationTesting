package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.FormAuthenticationPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FormAuthenticationTest extends TheInternetTestBase {
  @Test
  public void canLogin() {
	  String username = "tomsmith";
	  String password = "SuperSecretPassword!";
	  String expectedSuccessMessage = "Welcome to the Secure Area. When you are done click logout below.";
	  
	  String returnedMessage = new FormAuthenticationPage(webDriver, baseUrl)
			  .navigate()
			  .submitCredentials(username, password)
			  .getSuccessMessage(expectedSuccessMessage);
	  
	  Assert.assertEquals(returnedMessage, expectedSuccessMessage);
	  
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
