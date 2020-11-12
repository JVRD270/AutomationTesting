package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.RedirectionControlExtension;

public class RedirectionPage extends PageObjectBase {
	public RedirectionPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	@FindBy(id="redirect")
	WebElement redirectLink;
	
	public RedirectionPage navigate() {
		super.navigate("/redirector");
		return this;
	}
	
	public RedirectionControlExtension redirect() {
		return new RedirectionControlExtension(redirectLink, driver).redirect();
	}
	
	

}
