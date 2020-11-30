package theInternet.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class MultipleWindowsPage extends PageObjectBase {
	@FindBy(css=".example a")
	WebElement openTabButton;
	
	List<String> browserTabs = new ArrayList<String> ();
	
	public MultipleWindowsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public MultipleWindowsPage navigate() {
		super.navigate("/windows");
		return this;
	}
	
	public MultipleWindowsPage openNewTab() {
		openTabButton.click();
		return this;
	}

	public String getNewTabSource() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.not(ExpectedConditions.numberOfWindowsToBe(1)));
		browserTabs.addAll(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		return driver.getPageSource();
	}
	
}
