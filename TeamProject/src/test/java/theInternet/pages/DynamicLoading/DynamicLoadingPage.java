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
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		return new HiddenElementPage(driver, baseUrl);
	}
	
	public NotRenderedElementPage goToNotRenderedElementExample() {
		driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
		return new NotRenderedElementPage(driver, baseUrl);
	}
	
	
	
}
