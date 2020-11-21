package theInternet.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class ShadowDomPage extends PageObjectBase {
	public ShadowDomPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public ShadowDomPage navigate() {
		super.navigate("/shadowdom");
		return this;
	}

	public String getShadowDomStyles(int indexOfRoot) {
		String styles = getAllShadowRoots().get(indexOfRoot);
		return styles;
	}
	
	public List<String> getAllShadowRoots(){
		List<WebElement> paragraphs = driver.findElements(By.tagName("my-paragraph"));
		List<String> shadowDomList = new ArrayList<String>();
		for(WebElement paragraph : paragraphs) {
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			shadowDomList.add((String) js.executeScript("return arguments[0].shadowRoot.innerHTML", paragraph));
		}
		return shadowDomList;
	}

}
