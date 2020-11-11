package theInternet.tests;

import org.testng.annotations.Test;

import framework.TestBase;
import theInternet.pages.KeyPressPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class KeyPressTest extends TestBase{
  @Test
  public void recognizesPressedKey() {
	  String textInput = "sdiujowijdpqow"; //checks if we can detect each character and reassemble string from web page
	  String detectedKeyInputs = new KeyPressPage(webDriver, baseUrl)
			  .navigate()
			  .pressAndRecordKeysIntoString(textInput)
			  .getRecordedKeys();
	  
	  Assert.assertEquals(detectedKeyInputs, textInput.toUpperCase());
	  //must be uppercase, since we are detecting keys
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
