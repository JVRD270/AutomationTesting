package theInternet.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class JQueryUIMenuPage extends PageObjectBase {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	public JQueryUIMenuPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public JQueryUIMenuPage navigate() {
		super.navigate("/jqueryui/menu");
		return this;
	}
	
	public String clickMenuElement(String elementName) {
		Actions actions = new Actions(driver);
		List<String> enabledMenu = Arrays.asList("Downloads", "Back to JQuery UI");
		List<String> downloadMenu = Arrays.asList("PDF", "CSV", "Excel");
		WebElement desiredElement;;
		String lastClickedElementLabel;
		
		menuElementLocator("Enabled").click();
		wait.until(ExpectedConditions.visibilityOf(menuElementLocator(enabledMenu.get(0))));
		
		if (enabledMenu.contains(elementName)) {
			desiredElement = menuElementLocator(elementName);
			actions.click(desiredElement);
			lastClickedElementLabel = desiredElement.getText();
			return lastClickedElementLabel;
		}
		if (downloadMenu.contains(elementName)) {
			menuElementLocator("Downloads").click();
			wait.until(ExpectedConditions.visibilityOf(menuElementLocator(downloadMenu.get(0))));
			desiredElement = menuElementLocator(elementName);
			actions.click(desiredElement);
			lastClickedElementLabel = desiredElement.getText();
			return lastClickedElementLabel;
		}
		
		throw new NotFoundException("element not found in menu");
	}
	
	
	public WebElement menuElementLocator(String elementName) {
		return driver.findElement(By.xpath("//a[text()[contains(.,'" + elementName + "')]]"));
	}
	
}
