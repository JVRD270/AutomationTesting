import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SeleniumTest {
  @Test
  public void f() {
	  //C:\\Users\\CDantas\\Desktop\\JV training\\chromedriver.exe
	  //Arrange
//	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\CDantas\\Desktop\\JV training\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  String url = "https://www.google.com/";
	  //Act
	  driver.navigate().to(url);
	  String currentURL = driver.getCurrentUrl();
	  //Assert
	  Assert.assertEquals(currentURL, url);
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
