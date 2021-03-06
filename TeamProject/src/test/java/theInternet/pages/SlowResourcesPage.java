package theInternet.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import framework.PageObjectBase;

public class SlowResourcesPage extends PageObjectBase {
	boolean loadedStatus = false;
	
	public SlowResourcesPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public SlowResourcesPage navigate() {
		super.navigate("/slow");
		return this;
	}

	public SlowResourcesPage waitForPageLoad() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean currentLoadStatus = (Boolean) js.executeScript("return $.active == 0");
		while(!currentLoadStatus) {
			Thread.sleep(50);
			currentLoadStatus = (Boolean) js.executeScript("return $.active == 0");
		}
		Thread.sleep(1000);
		currentLoadStatus = (Boolean) js.executeScript("return $.active == 0");
		if(!currentLoadStatus) {
			throw new Exception("A new load event has started");
		}
		loadedStatus = true;
		return this;
	}
	
	public boolean getLoadedStatus() {
		return loadedStatus;
	}
}
