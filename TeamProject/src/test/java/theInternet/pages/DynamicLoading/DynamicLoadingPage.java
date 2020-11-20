package theInternet.pages.DynamicLoading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class DynamicLoadingPage extends PageObjectBase {
	public DynamicLoadingPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public DynamicLoadingPage navigate() {
		super.navigate("/dynamic_loading");
		return this;
	}
	
	public HiddenElementPage goToHiddenElementExample() {
		driver.findElement(By.partialLinkText("Example 1")).click();
		return new HiddenElementPage(driver, baseUrl);
	}
	
	public NotRenderedElementPage goToNotRenderedElementExample() {
		driver.findElement(By.partialLinkText("Example 2")).click();
		return new NotRenderedElementPage(driver, baseUrl);
	}
	
	
	
}
