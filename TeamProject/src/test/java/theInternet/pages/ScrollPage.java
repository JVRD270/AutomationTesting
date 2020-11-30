package theInternet.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import framework.PageObjectBase;

public class ScrollPage extends PageObjectBase{

	
	public ScrollPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	@FindBy(css=".jscroll-added")
	List<WebElement> addedDivs;
	
	public ScrollPage navigate() {
		super.navigate("/infinite_scroll");
		return this;
	}
	
	
	public ScrollPage scroll(int numberOfTimes) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String script = "scroll(0,document.body.scrollHeight);";
		for(int i = 0;i<=numberOfTimes;i++) {
			jse.executeScript(script);
			Thread.sleep(100);
		}
		return this;
		
	}
	
	public int getNumberOfTextElements() {
		return addedDivs.size();
	}

}
