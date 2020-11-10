package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.InputPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class InputTest extends TheInternetTestBase {
  @Test
  public void tc5CanSetAnInput() {
	  //Arrange
	  int expectedInput = 2;
	  //Act
	  int actualInput = new InputPage(webDriver, baseUrl)
			  						.navigate()
			  						.setInput(expectedInput)
			  						.getInput();
	  
	  //Assert
	  Assert.assertEquals(actualInput, expectedInput);
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
