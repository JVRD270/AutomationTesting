package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class EntryAdPage extends PageObjectBase{
	public EntryAdPage(WebDriver driver, String url){
		super(driver, url);
	}

	WebDriverWait wait = new WebDriverWait(driver,1);

	@FindBy(css=".modal")
	WebElement modalWindow;

	public EntryAdPage navigate() {
		super.navigate("/entry_ad");
		return this;
	}

	public boolean checkAdDisplay() {
		wait.until(ExpectedConditions.visibilityOf(modalWindow));
		return (modalWindow.getAttribute("display") != "none");
	}

	public EntryAdPage closeAd() {
		wait.until(ExpectedConditions.visibilityOf(modalWindow));
		WebElement closeModalButton = modalWindow.findElement(By.cssSelector(".modal-footer p"));
		closeModalButton.click();
		return this;
	}

	public EntryAdPage reEnable() {
		WebElement reEnableButton = driver.findElement(By.cssSelector("#restart-ad"));
		reEnableButton.click();
		return this;
	}


}
