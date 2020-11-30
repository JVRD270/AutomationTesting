package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class ChallengingDOMPage extends PageObjectBase {
	
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public ChallengingDOMPage(WebDriver driver, String url) {
		super(driver, url);
	}

	public ChallengingDOMPage navigate() {
		super.navigate("/challenging_dom");
		return this;
	}

	public String getCurrentResult() {
		WebElement elementThatContainsScript = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("content")));
		String innerHTMLOfElement = elementThatContainsScript.getAttribute("innerHTML");
		String result = innerHTMLOfElement.substring(innerHTMLOfElement.indexOf("Answer: ") + "Answer: ".length(), innerHTMLOfElement.lastIndexOf("'"));
		return result;
	}

	public ChallengingDOMPage clickAnyColoredButton(int timesToClick) {
		for(int i=0;i<timesToClick;i++) {
			double randomButtonSelector = Math.random() * 3;
			if(randomButtonSelector <= 1) {
				driver.findElement(By.cssSelector("[class = button]")).click();
			}
			if(randomButtonSelector > 1 && randomButtonSelector < 2) {
				driver.findElement(By.cssSelector(".alert")).click();
			}
			if(randomButtonSelector >= 2) {
				driver.findElement(By.cssSelector(".success")).click();
			}
		}
		return this;
	}
	
	
	
}
