package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.ShadowDomPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ShadowDOMTest extends TheInternetTestBase {
  @Test
  public void canGetShadowDOMStyles() {
	  int indexOfShadowDomRoot = 0;
	  
	  String expectedStyles = "color: white;\n"
	  		+ "      background-color: #666;";
	  
	  String shadowDomStyles = new ShadowDomPage(webDriver, baseUrl)
			  .navigate()
			  .getShadowDomStyles(indexOfShadowDomRoot);
	  
	  Assert.assertTrue(shadowDomStyles.contains(expectedStyles));
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
