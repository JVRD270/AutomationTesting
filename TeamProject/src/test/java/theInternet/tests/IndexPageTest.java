package theInternet.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.IndexPage;

public class IndexPageTest extends TheInternetTestBase{
	
  @Test
  public void canNavigateToTheIndexPage() {
	 
	  String expectedPageTitle = "The Internet";
	  //Act
	  String actualPageTitle = new IndexPage(webDriver, baseUrl)
			  						.navigate()
			  						.getTitle();
	  //Assert
	  Assert.assertEquals(actualPageTitle, expectedPageTitle);
  }
  
  @BeforeClass
  public void beforeClass() {
	 super.beforeTest();
  }

  @AfterClass
  public void afterClass() {
	  super.afterTest();
  }

}
