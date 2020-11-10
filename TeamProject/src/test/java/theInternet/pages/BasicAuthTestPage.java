package theInternet.pages;

import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class BasicAuthTestPage extends PageObjectBase {
	public BasicAuthTestPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public BasicAuthTestPage authenticate(String username, String password) {
		super.navigate("/basic_auth/");
		return this;
	}
	
	public String getSourceText() {
		return driver.getPageSource();
	}

}
