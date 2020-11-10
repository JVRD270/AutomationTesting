package theInternet.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.TestBase;
import theInternet.pages.IndexPage;

public class IndexPageTest extends TestBase{
	WebDriver driver;
	
  @Test
  public void canLaunchChromeBrowser() {
	 //Act
	  webDriver.navigate().to(baseUrl);
	  String currentURL = driver.getCurrentUrl();
	  //Assert
	  Assert.assertEquals(currentURL, baseUrl);
  }
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
