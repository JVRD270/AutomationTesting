package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.RedirectionPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RedirectionTest extends TheInternetTestBase{
  @Test
  public void canRedirect() {
	  String urlToRedirect = baseUrl + "/status_codes";
	  String pageRedirectedTo = new RedirectionPage(webDriver, baseUrl)
			  .navigate()
			  .redirect()
			  .getUrl();
	  
	  Assert.assertEquals(pageRedirectedTo, urlToRedirect);
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
