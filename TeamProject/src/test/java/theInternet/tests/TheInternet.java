package theInternet.tests;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.TestBase;
import theInternet.pages.DropdownPage;
import theInternet.pages.IndexPage;
import theInternet.pages.InputPage;

public class TheInternet extends TestBase{
	WebDriver driver;
	
  @Test
  public void canLaunchChromeBrowser() {
	 
	  String url = "http://the-internet.herokuapp.com/";
	  //Act
	  driver.navigate().to(url);
	  String currentURL = driver.getCurrentUrl();
	  //Assert
	  Assert.assertEquals(currentURL, url);
  }
  @Test
  public void canNavigateToTheIndexPage() {
	 
	  String url = "http://the-internet.herokuapp.com/";
	  String expectedPageTitle = "The Internet";
	  //Act
	  String actualPageTitle = new IndexPage(driver, url)
			  						.navigate()
			  						.getTitle();
	  //Assert
	  Assert.assertEquals(actualPageTitle, expectedPageTitle);
  }
  
  @Test
  public void tc4CanSelectDropdownListItem() {
	 
	  String url = "http://the-internet.herokuapp.com/";
	  String expectedSelection = "Option 2";
	  //Act
	  String actualSelection = new DropdownPage(driver, url)
			  						.navigate()
			  						.select(expectedSelection)
			  						.getSelection();
	  
	  //Assert
	  Assert.assertEquals(actualSelection, expectedSelection);
  }
  
  @Test
  public void tc5CanSetAnInput() {
	  //Arrange
	  String url = "http://the-internet.herokuapp.com/";
	  int expectedInput = 2;
	  //Act
	  int actualInput = new InputPage(driver, url)
			  						.navigate()
			  						.setInput(expectedInput)
			  						.getInput();
	  
	  //Assert
	  Assert.assertEquals(actualInput, expectedInput);
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  URL url = ClassLoader.getSystemResource("chromedriver.exe");
	  System.setProperty("webdriver.chrome.driver", url.getFile());
	  driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
