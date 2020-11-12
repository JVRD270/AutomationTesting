package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.ContextMenuControlExtension;

public class ContextMenuPage extends PageObjectBase{
	
	
	public ContextMenuPage(WebDriver driver, String url) {
		super(driver, url);
	}

	@FindBy(id = "hot-spot")
	WebElement clickableBox;

	public ContextMenuPage navigate() {
		super.navigate("/context_menu");
		return this;
	}

	public ContextMenuControlExtension clickBox() {
		return new ContextMenuControlExtension(clickableBox, driver).click();
	}

	
	
}
