package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.BasicAuthPage;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class BasicAuthTest extends TheInternetTestBase {
  @Test
  public void canAuthenticate() {
	  String username = "admin";
	  String password = "admin";
	  String contentInAuthenticatedPageSource = new BasicAuthPage(webDriver, baseUrl)
			  .authenticate(username, password)
			  .getSourceText();
	  
	  Assert.assertTrue(contentInAuthenticatedPageSource.contains("Congratulations! You must have the proper credentials."));
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
