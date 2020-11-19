package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.DragAndDropPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DragAndDropTest extends TheInternetTestBase {
  @Test
  public void canDragAndDropAndLabelChanges() throws InterruptedException {
	  DragAndDropPage testPage = new DragAndDropPage(webDriver, baseUrl);
	  
	  String expectedLabel = "B";
	  
	  String actualLabel = testPage
			  .navigate()
			  .dragBoxIntoAnother("B", "A")
			  .dragBoxIntoAnother("B", "A")
			  .dragBoxIntoAnother("A", "B")
			  .getLeftBoxLabel();
	  
	  Assert.assertEquals(actualLabel, expectedLabel);
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
