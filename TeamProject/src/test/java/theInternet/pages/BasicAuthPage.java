package theInternet.pages;

import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class BasicAuthPage extends PageObjectBase {
	public BasicAuthPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public BasicAuthPage authenticate(String username, String password) {
		String url = String.format("http://%s:%s@the-internet.herokuapp.com/basic_auth", username, password);
		driver.navigate().to(url);
		return this;
	}
	
	public String getSourceText() {
		return driver.getPageSource();
	}

}
