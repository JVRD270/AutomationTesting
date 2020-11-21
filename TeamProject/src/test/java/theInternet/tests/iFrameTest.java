package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.IFramePage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class iFrameTest extends TheInternetTestBase {
  @Test
  public void canInsertTextIntoWYSIWYG() {
	  String expectedInsertedText = "djwedowiej";
	  String iFrameSourceCode = new IFramePage(webDriver, baseUrl)
			  .navigate()
			  .removeMessage()
			  .insertTextIntoIFrame(expectedInsertedText)
			  .getSource();
	  
	  Assert.assertTrue(iFrameSourceCode.contains(expectedInsertedText));;
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
