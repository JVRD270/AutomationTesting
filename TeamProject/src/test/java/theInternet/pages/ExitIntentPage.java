package theInternet.pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class ExitIntentPage extends PageObjectBase {

	public ExitIntentPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, 2);
	
	public ExitIntentPage navigate() {
		super.navigate("/exit_intent");
		return this;
	}
	
	public ExitIntentPage tryToLeave() {
		try {
			Robot robot = new Robot();
			robot.mouseMove(100, 100);
			robot.mouseMove(50, 0);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		System.out.println(driver.findElement(By.id("ouibounce-modal")));
		return this;
	}
	
	public boolean getMessageDisplay() {
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ouibounce-modal"))));
		}
		catch(TimeoutException e){
			throw new TimeoutException("modal did not appear");
		}
		return true;
	}
}
