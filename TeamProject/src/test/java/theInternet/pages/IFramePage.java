package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class IFramePage extends PageObjectBase{
	
	public IFramePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public IFramePage navigate() {
		super.navigate("/tinymce");
		return this;
	}
	
	public IFramePage removeMessage() {
		driver.findElement(By.cssSelector(".mce-reset button")).click();
		return this;
	}
	
	public IFramePage insertTextIntoIFrame(String input) {
		driver.switchTo().frame(driver.findElement(By.cssSelector("#mce_0_ifr")));
		driver.findElement(By.cssSelector("body")).sendKeys(input);
		driver.switchTo().defaultContent();
		return this;
	}
	
	public String getSource() {
		return driver.getPageSource();
	}

}
