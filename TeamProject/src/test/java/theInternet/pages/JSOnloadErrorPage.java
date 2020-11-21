package theInternet.pages;

import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class JSOnloadErrorPage extends PageObjectBase {
	public JSOnloadErrorPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public JSOnloadErrorPage navigate() {
		super.navigate("/javascript_error");
		return this;
	}
	
	
	public String getSource() {
		return driver.getPageSource();
	}
}	
