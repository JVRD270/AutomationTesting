package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class HoveringPage extends PageObjectBase {
	
	public HoveringPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public HoveringPage navigate() {
		super.navigate("/hovers");
		return this;
	}
	
public String getUserInfoDisplayedOnHover(String userInformation) {
		WebElement user = hoverOverUser(userInformation);
		WebElement userCaption = new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(user.findElement(By.cssSelector(".figcaption h5"))));
		return userCaption.getText();
	}
	
	public WebElement hoverOverUser(String userInformation) {
		WebElement user = driver.findElement(By.xpath("//div[descendant::h5[text()[contains(.,'" + userInformation + "')]] and contains(@class, 'figure')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(user).perform();
		return user;
	}
	
}
