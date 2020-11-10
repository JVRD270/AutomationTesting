package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.TablesPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TablesTest extends TheInternetTestBase {
  @Test
  public void canGetTable1CellContents() {
	  String userEmailAddress = "jdoe@hotmail.com";
		String expectedText = "$50.00";
		
		String actualText = new TablesPage(webDriver, baseUrl)
				.navigate()
				.getAmountDueForUserTableRow(userEmailAddress);

		Assert.assertEquals(actualText, expectedText);
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
